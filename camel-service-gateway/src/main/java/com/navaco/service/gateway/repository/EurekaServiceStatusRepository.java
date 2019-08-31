package com.navaco.service.gateway.repository;

import com.navaco.service.gateway.enums.EurekaServiceStatusType;
import com.navaco.service.gateway.domain.EurekaServiceStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EurekaServiceStatusRepository extends JpaRepository<EurekaServiceStatusEntity, Long> {
    public EurekaServiceStatusEntity findByEurekaServiceStatusType(EurekaServiceStatusType eurekaServiceStatusType);
}
