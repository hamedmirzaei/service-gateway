package com.navaco.service.gateway.repository;

import com.navaco.service.gateway.model.ContextServiceMapping;
import com.navaco.service.gateway.model.ServiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContextServiceMappingRepository extends JpaRepository<ContextServiceMapping, Long> {
    public List<ContextServiceMapping> findByServiceStatus(ServiceStatus serviceStatus);
}
