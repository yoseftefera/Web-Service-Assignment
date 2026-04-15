package com.shapetool.endpoint;

import com.shapetool.generated.*;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ShapeToolEndpoint {

    private static final String NAMESPACE_URI = "http://www.woldia.edu/shapetool";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "circleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse circleArea(@RequestPayload CircleAreaRequest request) {
        // Just throw IllegalArgumentException - Spring WS handles it automatically!
        if (request.getRadius() <= 0) {
            throw new IllegalArgumentException("Radius must be positive. Received: " + request.getRadius());
        }

        CircleAreaResponse response = new CircleAreaResponse();
        response.setArea(Math.PI * request.getRadius() * request.getRadius());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "squareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse squareArea(@RequestPayload SquareAreaRequest request) {
        if (request.getSide() <= 0) {
            throw new IllegalArgumentException("Side must be positive. Received: " + request.getSide());
        }

        SquareAreaResponse response = new SquareAreaResponse();
        response.setArea(request.getSide() * request.getSide());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "rectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse rectangleArea(@RequestPayload RectangleAreaRequest request) {
        if (request.getLength() <= 0) {
            throw new IllegalArgumentException("Length must be positive. Received: " + request.getLength());
        }
        if (request.getWidth() <= 0) {
            throw new IllegalArgumentException("Width must be positive. Received: " + request.getWidth());
        }

        RectangleAreaResponse response = new RectangleAreaResponse();
        response.setArea(request.getLength() * request.getWidth());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "parallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse parallelogramArea(@RequestPayload ParallelogramAreaRequest request) {
        if (request.getBase() <= 0) {
            throw new IllegalArgumentException("Base must be positive. Received: " + request.getBase());
        }
        if (request.getHeight() <= 0) {
            throw new IllegalArgumentException("Height must be positive. Received: " + request.getHeight());
        }

        ParallelogramAreaResponse response = new ParallelogramAreaResponse();
        response.setArea(request.getBase() * request.getHeight());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "triangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse triangleArea(@RequestPayload TriangleAreaRequest request) {
        if (request.getBase() <= 0) {
            throw new IllegalArgumentException("Base must be positive. Received: " + request.getBase());
        }
        if (request.getHeight() <= 0) {
            throw new IllegalArgumentException("Height must be positive. Received: " + request.getHeight());
        }

        TriangleAreaResponse response = new TriangleAreaResponse();
        response.setArea(0.5 * request.getBase() * request.getHeight());
        return response;
    }
}