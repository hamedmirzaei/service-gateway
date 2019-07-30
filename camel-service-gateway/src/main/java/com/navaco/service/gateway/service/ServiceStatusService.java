package com.navaco.service.gateway.service;

import com.navaco.service.gateway.enums.ServiceStatusType;
import com.navaco.service.gateway.model.ServiceStatus;
import com.navaco.service.gateway.repository.ServiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceStatusService {

    private ServiceStatusRepository serviceStatusRepository;

    @Autowired
    public ServiceStatusService(ServiceStatusRepository serviceStatusRepository) {
        this.serviceStatusRepository = serviceStatusRepository;
    }

    public ServiceStatus getServiceStatusByServiceStatusType(ServiceStatusType serviceStatusType) {
        return serviceStatusRepository.findByServiceStatusType(serviceStatusType);
    }
}
