package com.navaco.service.gateway.service;

import com.navaco.service.gateway.enums.ServiceStatusType;
import com.navaco.service.gateway.model.ContextServiceMapping;
import com.navaco.service.gateway.repository.ContextServiceMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContextServiceMappingService {

    private ContextServiceMappingRepository contextServiceMappingRepository;
    private ServiceStatusService serviceStatusService;

    @Autowired
    public ContextServiceMappingService(ContextServiceMappingRepository contextServiceMappingRepository,
                                        ServiceStatusService serviceStatusService) {
        this.contextServiceMappingRepository = contextServiceMappingRepository;
        this.serviceStatusService = serviceStatusService;
    }

    public ContextServiceMapping getContextServiceMapping(Long id) {
        return contextServiceMappingRepository.findById(id).orElse(new ContextServiceMapping(-1L, "", ""));
    }

    public List<ContextServiceMapping> getAllContextServiceMapping() {
        return contextServiceMappingRepository.findAll();
    }

    public List<ContextServiceMapping> getAllActiveContextServiceMapping() {
        return contextServiceMappingRepository.findByServiceStatus(
                serviceStatusService.getServiceStatusByStatusName(ServiceStatusType.PUBLISHED));
    }

    public ContextServiceMapping addContextServiceMapping(ContextServiceMapping contextServiceMapping) {
        return contextServiceMappingRepository.save(contextServiceMapping);
    }
}
