

 🔷 ShapeTool SOAP Web Service

📌 Overview

ShapeTool is a SOAP-based web service developed using Spring Boot. It provides functionality to calculate the area of different geometric shapes such as circle, square, rectangle, parallelogram, and triangle.

The project follows a **contract-first approach** using XSD for defining request and response structures.

---

 🎯 **Features**

* ✅ Calculate area of multiple shapes
* ✅ SOAP-based communication (XML)
* ✅ Automatic WSDL generation
* ✅ XSD validation for requests and responses
* ✅ Error handling for invalid inputs

---

🛠️ Technologies Used

* Java 25
* Spring Boot
* Spring Web Services
* Maven
* SOAP
* JAXB (XML Binding)

---

🏗️ Project Structure

```bash
src/
 ├── main/
 │   ├── java/com/shapetool/
 │   │   ├── config/        # SOAP Configuration
 │   │   ├── endpoint/      # Web Service Endpoints
 │   │   ├── generated/     # JAXB Generated Classes
 │   ├── resources/
 │   │   ├── xsd/           # XML Schema Definition
```

---

 ⚙️ How It Works

1. Client sends a SOAP request (XML)
2. Spring Boot processes the request
3. JAXB converts XML → Java objects
4. Endpoint performs calculation
5. Response is returned as XML

---

WSDL Access

After running the application, access WSDL at:

```bash
http://localhost:8080/ws/shapetool.wsdl
```

---

Available Operations**

* `circleArea`
* `squareArea`
* `rectangleArea`
* `parallelogramArea`
* `triangleArea`

---

Sample SOAP Request

xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:shp="http://www.woldia.edu/shapetool">
   <soapenv:Body>
      <shp:rectangleAreaRequest>
         <shp:length>10</shp:length>
         <shp:width>5</shp:width>
      </shp:rectangleAreaRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

---

Sample SOAP Response

```xml
<rectangleAreaResponse>
   <area>50.0</area>
</rectangleAreaResponse>
```

---

🚀 How to Run the Project

 1. Clone the repository

```bash
git clone https://github.com/your-username/shapetool.git
```

2. Navigate to project

```bash
cd shapetool
```

3. Run application

```bash
mvn spring-boot:run
```

---

Testing

You can test the service using:

* Postman
* SoapUI

 Endpoint:

```bash
POST http://localhost:8080/ws
```

---

 ⚠️ **Validation

* All inputs must be positive numbers
* Invalid inputs return an error

---

Architecture

* Client → SOAP Request
* Spring Boot → Processing
* JAXB → Object Mapping
* XSD → Validation
* WSDL → Service Contract

---

 Key Concepts

* SOAP Web Services
* Contract-first development
* XML Schema (XSD)
* WSDL generation
* JAXB data binding

---

📁 Documentation

The full project documentation is included in:

```bash
/ShapeTool_Documentation.docx
```

---

 👤Author

* **Name:** Yosef Tefera
* **University:** Woldia University
* id:147613



 📌 Conclusion

This project demonstrates the implementation of a SOAP-based web service using Spring Boot, including XML validation, WSDL generation, and structured service communication.



