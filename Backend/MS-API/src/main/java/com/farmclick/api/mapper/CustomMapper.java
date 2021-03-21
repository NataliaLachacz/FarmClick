package com.farmclick.api.mapper;


import org.springframework.beans.BeanUtils;

/**
 *
 * @param <O> Means output object class
 * @param <I> Means input object class
 */
public interface CustomMapper<O extends Mappable, I extends Mappable> {

    O map(I entity);

    default O defaultMap(I entity, Class<O> entityClass) {
        O transformed = null;
        try {
            transformed = entityClass.newInstance();
            BeanUtils.copyProperties(entity, transformed);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return transformed;
    }
}
