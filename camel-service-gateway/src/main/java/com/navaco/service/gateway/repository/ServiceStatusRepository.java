package com.navaco.service.gateway.repository;

import com.navaco.service.gateway.enums.ServiceStatusType;
import com.navaco.service.gateway.model.ServiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceStatusRepository extends JpaRepository<ServiceStatus, Long> {
    public ServiceStatus findByServiceStatusType(ServiceStatusType serviceStatusType);
}
