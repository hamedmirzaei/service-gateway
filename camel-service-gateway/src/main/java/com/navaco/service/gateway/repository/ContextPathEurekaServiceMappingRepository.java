package com.navaco.service.gateway.repository;

import com.navaco.service.gateway.model.ContextPathEurekaServiceMappingEntity;
import com.navaco.service.gateway.model.EurekaServiceStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContextPathEurekaServiceMappingRepository extends JpaRepository<ContextPathEurekaServiceMappingEntity, Long> {
    public List<ContextPathEurekaServiceMappingEntity> findByEurekaServiceStatusEntity(EurekaServiceStatusEntity eurekaServiceStatusEntity);
}
