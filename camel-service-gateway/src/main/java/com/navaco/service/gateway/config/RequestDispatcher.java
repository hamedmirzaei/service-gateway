package com.navaco.service.gateway.config;

import com.navaco.service.gateway.model.ContextServiceMapping;
import com.navaco.service.gateway.routebuilder.ServiceRouteBuilder;
import com.navaco.service.gateway.service.ContextServiceMappingService;
import org.apache.camel.CamelContext;
import org.apache.camel.model.RouteDefinition;

import java.util.ArrayList;
import java.util.List;

public class RequestDispatcher {

    /**
     * this is going to add all the routes based on 'ContextServiceMapping' table content
     * @param contextServiceMappingService: the service layer og 'ContextServiceMapping' model class
     * @param camelContext: the 'CamelContext' class
     */
    public static void setup(ContextServiceMappingService contextServiceMappingService, CamelContext camelContext) {
        // mapping of context strings to eureka service names
        List<ContextServiceMapping> contextServiceMappings = contextServiceMappingService.getAllContextServiceMapping();

        // for each single micro-service which expose a rest API
        for (ContextServiceMapping contextServiceMapping : contextServiceMappings) {
            try {
                camelContext.addRoutes(new ServiceRouteBuilder(camelContext, contextServiceMapping));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * this is going to remove all the previous routes start with '/services'
     * and add them based on 'ContextServiceMapping' table content again. So, it will be updated without
     * restarting the application and by just calling Http.GET to '/refresh' API
     * @param contextServiceMappingService: the service layer og 'ContextServiceMapping' model class
     * @param camelContext: the 'CamelContext' class
     */
    public static void refresh(ContextServiceMappingService contextServiceMappingService, CamelContext camelContext) {
        // removing the routes
        List<RouteDefinition> currentRoutes = new ArrayList<>(camelContext.getRouteDefinitions());
        for (RouteDefinition routeDefinition : currentRoutes) {
            // if the route belong to one of services
            if (routeDefinition.getInputs().get(0).getUri().contains(":services/")) {
                try {
                    camelContext.stopRoute(routeDefinition.getId());
                } catch (Exception e) {
                }
                try {
                    camelContext.removeRouteDefinition(routeDefinition);
                } catch (Exception e) {
                }
            }
        }
        // adding the routes
        setup(contextServiceMappingService, camelContext);
    }

}
