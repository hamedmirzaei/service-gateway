package com.navaco.service.gateway.enums.converter;

import com.navaco.service.gateway.enums.ServiceStatusType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ServiceStatusTypeConverter implements AttributeConverter<ServiceStatusType, String> {

    @Override
    public String convertToDatabaseColumn(ServiceStatusType serviceStatusEnum) {
        if (serviceStatusEnum == null) {
            return null;
        }
        return serviceStatusEnum.getStatusName();
    }

    @Override
    public ServiceStatusType convertToEntityAttribute(String statusName) {
        if (statusName == null) {
            return null;
        }

        return Stream.of(ServiceStatusType.values())
                .filter(s -> s.getStatusName().equals(statusName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
