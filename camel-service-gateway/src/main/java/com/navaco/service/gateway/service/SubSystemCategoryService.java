package com.navaco.service.gateway.service;

import com.navaco.service.gateway.enums.SubSystemCategoryType;
import com.navaco.service.gateway.domain.SubSystemCategoryEntity;
import com.navaco.service.gateway.repository.SubSystemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubSystemCategoryService {

    private SubSystemCategoryRepository subSystemCategoryRepository;

    @Autowired
    public SubSystemCategoryService(SubSystemCategoryRepository subSystemCategoryRepository) {
        this.subSystemCategoryRepository = subSystemCategoryRepository;
    }

    public SubSystemCategoryEntity getSubSystemCategoryBySubSystemCategoryType(SubSystemCategoryType subSystemCategoryType) {
        return subSystemCategoryRepository.findBySubSystemCategoryType(subSystemCategoryType);
    }
}
