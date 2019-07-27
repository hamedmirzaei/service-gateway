package com.navaco.service.gateway.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SOAPInvokerRoute extends RouteBuilder {

    @Value("${rest.port}")
    private String port;

    @Override
    public void configure() throws Exception {

        String operationName1 = "sayHello";
        String operationName2 = "sayBye";
        String operationName3 = "getCustomer";
        String namespace = "http://service.gateway.service.navaco.com/";
        String serviceURL = "http://localhost:8094/services/GreetingService";
        String serviceURL2 = "http://localhost:8094/services/CustomerService";
        String serviceClass = "com.navaco.service.gateway.service.GreetingService";
        String serviceClass2 = "com.navaco.service.gateway.service.CustomerService";
        String serviceWSDL = "/wsdl/GreetingService.wsdl";
        String serviceWSDL2 = "/wsdl/CustomerService.wsdl";

        setupRestConfiguration();

        from("spark-rest:get:/soap/hello/:name")
            .setBody(simple("${header.name}"))
            .setHeader(CxfConstants.OPERATION_NAME, simple(operationName1))
            .setHeader(CxfConstants.OPERATION_NAMESPACE, simple(namespace))
            .toD("cxf://" + serviceURL + "?serviceClass=" + serviceClass + "&wsdlURL=" + serviceWSDL)
            .marshal().json(JsonLibrary.Jackson);

        from("spark-rest:get:/soap/bye/:name")
            .setBody(simple("${header.name}"))
            .setHeader(CxfConstants.OPERATION_NAME, simple(operationName2))
            .setHeader(CxfConstants.OPERATION_NAMESPACE, simple(namespace))
            .toD("cxf://" + serviceURL + "?serviceClass=" + serviceClass + "&wsdlURL=" + serviceWSDL)
            .marshal().json(JsonLibrary.Jackson);

        from("spark-rest:get:/soap/customers/:id")
                .setBody(simple("${header.id}"))
                .setHeader(CxfConstants.OPERATION_NAME, simple(operationName3))
                .setHeader(CxfConstants.OPERATION_NAMESPACE, simple(namespace))
                .toD("cxf://" + serviceURL2 + "?serviceClass=" + serviceClass2 + "&wsdlURL=" + serviceWSDL2)
                .marshal().json(JsonLibrary.Jackson);
    }

    private void setupRestConfiguration() {
        restConfiguration()
                .host("localhost")
                .port(port)
                .bindingMode(RestBindingMode.json)
                .componentProperty("matchOnUriPrefix", "true")
                .apiProperty("api.title", "SOAP/REST Camel API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true");
    }
}
