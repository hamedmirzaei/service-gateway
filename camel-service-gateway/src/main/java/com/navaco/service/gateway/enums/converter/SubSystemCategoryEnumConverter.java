package com.navaco.service.gateway.enums.converter;

import com.navaco.service.gateway.enums.SubSystemCategoryEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SubSystemCategoryEnumConverter implements AttributeConverter<SubSystemCategoryEnum, String> {

    @Override
    public String convertToDatabaseColumn(SubSystemCategoryEnum subSystemCategoryEnum) {
        if (subSystemCategoryEnum == null) {
            return null;
        }
        return subSystemCategoryEnum.getCategoryName();
    }

    @Override
    public SubSystemCategoryEnum convertToEntityAttribute(String categoryName) {
        if (categoryName == null) {
            return null;
        }

        return Stream.of(SubSystemCategoryEnum.values())
                .filter(c -> c.getCategoryName().equals(categoryName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
