package com.navaco.service.gateway.service;

import com.navaco.service.gateway.enums.EurekaServiceStatusType;
import com.navaco.service.gateway.model.EurekaServiceStatusEntity;
import com.navaco.service.gateway.repository.EurekaServiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EurekaServiceStatusService {

    private EurekaServiceStatusRepository eurekaServiceStatusRepository;

    @Autowired
    public EurekaServiceStatusService(EurekaServiceStatusRepository eurekaServiceStatusRepository) {
        this.eurekaServiceStatusRepository = eurekaServiceStatusRepository;
    }

    public EurekaServiceStatusEntity getEurekaServiceStatusByEurekaServiceStatusType(EurekaServiceStatusType eurekaServiceStatusType) {
        return eurekaServiceStatusRepository.findByEurekaServiceStatusType(eurekaServiceStatusType);
    }
}
