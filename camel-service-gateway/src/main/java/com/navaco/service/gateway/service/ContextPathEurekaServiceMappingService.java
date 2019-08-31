package com.navaco.service.gateway.service;

import com.navaco.service.gateway.domain.ContextPathEurekaServiceMappingEntity;
import com.navaco.service.gateway.enums.EurekaServiceStatusType;
import com.navaco.service.gateway.repository.ContextPathEurekaServiceMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContextPathEurekaServiceMappingService {

    private ContextPathEurekaServiceMappingRepository contextPathEurekaServiceMappingRepository;
    private EurekaServiceStatusService eurekaServiceStatusService;

    @Autowired
    public ContextPathEurekaServiceMappingService(ContextPathEurekaServiceMappingRepository contextPathEurekaServiceMappingRepository,
                                                  EurekaServiceStatusService eurekaServiceStatusService) {
        this.contextPathEurekaServiceMappingRepository = contextPathEurekaServiceMappingRepository;
        this.eurekaServiceStatusService = eurekaServiceStatusService;
    }

    public ContextPathEurekaServiceMappingEntity getContextPathEurekaServiceMappingEntity(Long id) {
        return contextPathEurekaServiceMappingRepository.findById(id).orElse(new ContextPathEurekaServiceMappingEntity(-1L, "", ""));
    }

    public List<ContextPathEurekaServiceMappingEntity> getAllContextPathEurekaServiceMappingEntities() {
        return contextPathEurekaServiceMappingRepository.findAll();
    }

    public List<ContextPathEurekaServiceMappingEntity> getAllContextPathEurekaServiceMappingEntitiesByEurekaServiceStatusType(EurekaServiceStatusType eurekaServiceStatusType) {
        return contextPathEurekaServiceMappingRepository.findByEurekaServiceStatusEntity(
                eurekaServiceStatusService.getEurekaServiceStatusByEurekaServiceStatusType(eurekaServiceStatusType));
    }

    public ContextPathEurekaServiceMappingEntity addContextPathEurekaServiceMappingEntity(ContextPathEurekaServiceMappingEntity contextPathEurekaServiceMappingEntity) {
        return contextPathEurekaServiceMappingRepository.save(contextPathEurekaServiceMappingEntity);
    }
}
