package com.navaco.service.gateway.repository;

import com.navaco.service.gateway.model.ContextServiceMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextServiceMappingRepository extends JpaRepository<ContextServiceMapping, Long> {
}
