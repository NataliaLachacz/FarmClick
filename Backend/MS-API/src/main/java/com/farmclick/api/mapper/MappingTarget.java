package com.farmclick.api.mapper;


import org.springframework.beans.BeanUtils;

/**
 * @param <I> Means Input class
 */
public interface MappingTarget<I extends MappingTarget<I>> extends Mappable {

    default <O extends Mappable> O transform(Class<O> targetEntity) {
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
    default <E extends MappingTarget<E>> E transform(CustomMapper customMapper) {
        return (E) customMapper.transform(this);
    }
}
