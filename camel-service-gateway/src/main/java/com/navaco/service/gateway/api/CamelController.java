package com.navaco.service.gateway.api;

import com.navaco.service.gateway.config.RequestDispatcher;
import com.navaco.service.gateway.enums.EurekaServiceStatusType;
import com.navaco.service.gateway.model.ContextPathEurekaServiceMappingEntity;
import com.navaco.service.gateway.model.EurekaServiceStatusEntity;
import com.navaco.service.gateway.service.ContextPathEurekaServiceMappingService;
import com.navaco.service.gateway.service.EurekaServiceStatusService;
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

    private ContextPathEurekaServiceMappingService contextPathEurekaServiceMappingService;
    private EurekaServiceStatusService eurekaServiceStatusService;
    private CamelContext camelContext;

    @Autowired
    public CamelController(ContextPathEurekaServiceMappingService contextPathEurekaServiceMappingService,
                           EurekaServiceStatusService eurekaServiceStatusService,
                           CamelContext camelContext) {
        this.contextPathEurekaServiceMappingService = contextPathEurekaServiceMappingService;
        this.eurekaServiceStatusService = eurekaServiceStatusService;
        this.camelContext = camelContext;
    }

    @GetMapping("/refresh")
    public ResponseEntity refreshRoutes() {
        RequestDispatcher.refresh(contextPathEurekaServiceMappingService, camelContext);
        return ResponseEntity.ok("CamelContext Refreshed Successfully");
    }

    @GetMapping("/test1")
    public ResponseEntity<List<ContextPathEurekaServiceMappingEntity>> test1() {
        return ResponseEntity.ok(contextPathEurekaServiceMappingService.getAllContextPathEurekaServiceMappingEntitiesByEurekaServiceStatusType(EurekaServiceStatusType.PUBLISHED));
    }

    @GetMapping("/test2")
    public ResponseEntity<EurekaServiceStatusEntity> test2() {
        return ResponseEntity.ok(eurekaServiceStatusService.getEurekaServiceStatusByEurekaServiceStatusType(EurekaServiceStatusType.PUBLISHED));
    }


    @GetMapping("/health")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("Server is UP");
    }
}
