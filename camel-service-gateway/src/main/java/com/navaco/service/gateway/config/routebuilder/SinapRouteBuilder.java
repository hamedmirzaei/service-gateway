package com.navaco.service.gateway.config.routebuilder;

import ir.navaco.core.gateway.soap.sinap.DailySituation;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SinapRouteBuilder extends RouteBuilder {

    @Value("${rest.port}")
    private String port;

    @Override
    public void configure() throws Exception {

        String operationName = "Insert";
        String namespace = "http://tempuri.org/";
        String serviceURL = "http://localhost:8096/services/services/daily";
        String serviceClass = "ir.navaco.core.gateway.soap.sinap.IDailySituationService";
        String serviceWSDL = "/wsdl/dailysituation.wsdl";

        // rest configuration
        setupRestConfiguration();

        // add a daily situation
        from("spark-rest:post:/soap/sinap")
                .setHeader(CxfConstants.OPERATION_NAME, simple(operationName))
                .setHeader(CxfConstants.OPERATION_NAMESPACE, simple(namespace))
                .unmarshal().json(JsonLibrary.Jackson, DailySituation.class)
                .toD("cxf://" + serviceURL + "?serviceClass=" + serviceClass + "&wsdlURL=" + serviceWSDL)
                .marshal().json(JsonLibrary.Jackson);
    }

    private void setupRestConfiguration() {
        restConfiguration()
                .host("localhost")
                .port(port)
                .bindingMode(RestBindingMode.json);
    }
}
