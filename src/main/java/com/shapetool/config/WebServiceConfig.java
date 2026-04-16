package com.shapetool.config;

import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;

@EnableWs
@Configuration
public class WebServiceConfig implements org.springframework.ws.config.annotation.WsConfigurer {

    // 1. SOAP Servlet (maps /ws/*)
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    // 2. Load XSD schema
    @Bean
    public XsdSchema shapetoolSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/shapetool.xsd"));
    }

    // 3. Generate WSDL automatically
    @Bean(name = "shapetool")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema shapetoolSchema) {

        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("ShapeToolPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://www.woldia.edu/shapetool");
        wsdl.setSchema(shapetoolSchema);

        return wsdl;
    }

    // 4. XSD Validation Interceptor
    @Bean
    public PayloadValidatingInterceptor validatingInterceptor() {

        PayloadValidatingInterceptor interceptor = new PayloadValidatingInterceptor();

        interceptor.setXsdSchema(shapetoolSchema());
        interceptor.setValidateRequest(true); // validate incoming SOAP request
        interceptor.setValidateResponse(true); // validate outgoing response

        return interceptor;
    }

    // 5. Register interceptor
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(validatingInterceptor());
    }
}