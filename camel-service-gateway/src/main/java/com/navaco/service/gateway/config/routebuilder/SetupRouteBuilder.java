package com.navaco.service.gateway.config.routebuilder;

import com.navaco.service.gateway.config.RequestDispatcher;
import com.navaco.service.gateway.service.ContextPathEurekaServiceMappingService;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SetupRouteBuilder extends RouteBuilder {

    @Value("${rest.port}")
    private String port;

    private ContextPathEurekaServiceMappingService contextPathEurekaServiceMappingService;
    private CamelContext camelContext;

    @Autowired
    public SetupRouteBuilder(ContextPathEurekaServiceMappingService contextPathEurekaServiceMappingService, CamelContext camelContext) {
        this.contextPathEurekaServiceMappingService = contextPathEurekaServiceMappingService;
        this.camelContext = camelContext;
    }

    @Override
    public void configure() throws Exception {
        // set up configuration for rest
        setupRestConfiguration();
        // add routes to camel context
        RequestDispatcher.setup(contextPathEurekaServiceMappingService, camelContext);
    }

    /**
     * setting up REST configuration
     */
    private void setupRestConfiguration() {
        restConfiguration()
                .host("localhost")
                .port(port)
                .bindingMode(RestBindingMode.json)
                .componentProperty("matchOnUriPrefix", "true")
                .apiProperty("api.title", "Dispatcher Camel API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true");
    }

}
