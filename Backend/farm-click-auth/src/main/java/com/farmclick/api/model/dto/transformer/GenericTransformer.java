package com.farmclick.api.model.dto.transformer;

import org.springframework.beans.BeanUtils;

public class GenericTransformer <E, D> {

    public E createEntity(D dto, Class<E> entityClass) {
        E entity = null;
        try {
            entity = entityClass.newInstance();
            BeanUtils.copyProperties(dto, entity);
            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public D createDTO(E entity, Class<D> dtoClass)  {
        D dto = null;
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
