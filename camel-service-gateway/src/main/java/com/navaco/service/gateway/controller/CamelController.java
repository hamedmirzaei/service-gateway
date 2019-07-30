package com.navaco.service.gateway.controller;

import com.navaco.service.gateway.config.RequestDispatcher;
import com.navaco.service.gateway.enums.ServiceStatusType;
import com.navaco.service.gateway.model.ContextServiceMapping;
import com.navaco.service.gateway.model.ServiceStatus;
import com.navaco.service.gateway.service.ContextServiceMappingService;
import com.navaco.service.gateway.service.ServiceStatusService;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/camel")
public class CamelController {

    private ContextServiceMappingService contextServiceMappingService;
    private ServiceStatusService serviceStatusService;
    private CamelContext camelContext;

    @Autowired
    public CamelController(ContextServiceMappingService contextServiceMappingService,
                           ServiceStatusService serviceStatusService,
                           CamelContext camelContext) {
        this.contextServiceMappingService = contextServiceMappingService;
        this.serviceStatusService = serviceStatusService;
        this.camelContext = camelContext;
    }

    @GetMapping("/refresh")
    public ResponseEntity refreshRoutes() {
        RequestDispatcher.refresh(contextServiceMappingService, camelContext);
        return ResponseEntity.ok("CamelContext Refreshed Successfully");
    }

    @GetMapping("/test1")
    public ResponseEntity<List<ContextServiceMapping>> test1() {
        /*ContextServiceMapping contextServiceMapping = new ContextServiceMapping();
        contextServiceMapping.setContext("/customers");
        contextServiceMapping.setService("customer-service");
        contextServiceMapping.setServiceStatus(new ServiceStatus(ServiceStatusType.PUBLISHED));
        contextServiceMapping.setSubSystemCategory(new SubSystemCategory(SubSystemCategoryType.ARZI));
        contextServiceMappingService.addContextServiceMapping(contextServiceMapping);*/
        return ResponseEntity.ok(contextServiceMappingService.getAllActiveContextServiceMapping());
    }

    @GetMapping("/test2")
    public ResponseEntity<ServiceStatus> test2() {
        /*ContextServiceMapping contextServiceMapping = new ContextServiceMapping();
        contextServiceMapping.setContext("/customers");
        contextServiceMapping.setService("customer-service");
        contextServiceMapping.setServiceStatus(new ServiceStatus(ServiceStatusType.PUBLISHED));
        contextServiceMapping.setSubSystemCategory(new SubSystemCategory(SubSystemCategoryType.ARZI));
        contextServiceMappingService.addContextServiceMapping(contextServiceMapping);*/
        return ResponseEntity.ok(serviceStatusService.getServiceStatusByStatusName(ServiceStatusType.PUBLISHED));
    }


    @GetMapping("/health")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("Server is UP");
    }
}
