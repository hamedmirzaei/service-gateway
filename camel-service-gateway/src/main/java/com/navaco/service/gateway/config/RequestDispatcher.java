package com.navaco.service.gateway.config;

import com.navaco.service.gateway.config.routebuilder.ServiceRouteBuilder;
import com.navaco.service.gateway.domain.ContextPathEurekaServiceMappingEntity;
import com.navaco.service.gateway.service.ContextPathEurekaServiceMappingService;
import org.apache.camel.CamelContext;
import org.apache.camel.model.RouteDefinition;

import java.util.ArrayList;
import java.util.List;

public class RequestDispatcher {

    /**
     * this is going to add all the routes based on 'ContextPathEurekaServiceMappingEntity' table content
     *
     * @param contextPathEurekaServiceMappingService: the service layer og 'ContextPathEurekaServiceMappingEntity' model class
     * @param camelContext:                           the 'CamelContext' class
     */
    public static void setup(ContextPathEurekaServiceMappingService contextPathEurekaServiceMappingService, CamelContext camelContext) {
        // mapping of context strings to eureka service names
        List<ContextPathEurekaServiceMappingEntity> contextServiceMappingEntities = contextPathEurekaServiceMappingService.getAllContextPathEurekaServiceMappingEntities();

        // for each single micro-service which expose a rest API
        for (ContextPathEurekaServiceMappingEntity contextPathEurekaServiceMappingEntity : contextServiceMappingEntities) {
            try {
                camelContext.addRoutes(new ServiceRouteBuilder(camelContext, contextPathEurekaServiceMappingEntity));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * this is going to remove all the previous routes start with '/services'
     * and add them based on 'ContextPathEurekaServiceMappingEntity' table content again. So, it will be updated without
     * restarting the application and by just calling Http.GET to '/refresh' API
     *
     * @param contextPathEurekaServiceMappingService: the service layer og 'ContextPathEurekaServiceMappingEntity' model class
     * @param camelContext:                           the 'CamelContext' class
     */
    public static void refresh(ContextPathEurekaServiceMappingService contextPathEurekaServiceMappingService, CamelContext camelContext) {
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
        setup(contextPathEurekaServiceMappingService, camelContext);
    }

}
