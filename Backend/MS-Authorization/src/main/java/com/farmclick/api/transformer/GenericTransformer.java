package com.farmclick.api.transformer;

import org.springframework.beans.BeanUtils;

public class GenericTransformer <ENTITY, DTO> {

    public ENTITY createEntity(DTO dto, Class<ENTITY> entityClass) {
        ENTITY entity = null;
        try {
            entity = entityClass.newInstance();
            BeanUtils.copyProperties(dto, entity);
            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public DTO createDTO(ENTITY entity, Class<DTO> dtoClass)  {
        DTO dto = null;
        try {
            dto = dtoClass.newInstance();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
