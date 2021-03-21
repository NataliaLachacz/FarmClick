package com.farmclick.api.mapper;


import org.springframework.beans.BeanUtils;

public interface Mappable {

    default <O extends Mappable> O map(Class<O> targetEntity) {
        O transformed = null;
        try {
            transformed = targetEntity.newInstance();
            BeanUtils.copyProperties(this, transformed);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return transformed;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    default <E extends Mappable> E map(CustomMapper customMapper) {
        return (E) customMapper.map(this);
    }
}
