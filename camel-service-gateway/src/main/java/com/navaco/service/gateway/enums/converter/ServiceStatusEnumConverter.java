package com.navaco.service.gateway.enums.converter;

import com.navaco.service.gateway.enums.ServiceStatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ServiceStatusEnumConverter implements AttributeConverter<ServiceStatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(ServiceStatusEnum serviceStatusEnum) {
        if (serviceStatusEnum == null) {
            return null;
        }
        return serviceStatusEnum.getStatusName();
    }

    @Override
    public ServiceStatusEnum convertToEntityAttribute(String statusName) {
        if (statusName == null) {
            return null;
        }

        return Stream.of(ServiceStatusEnum.values())
                .filter(s -> s.getStatusName().equals(statusName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
