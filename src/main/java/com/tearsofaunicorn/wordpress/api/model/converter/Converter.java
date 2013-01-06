package com.tearsofaunicorn.wordpress.api.model.converter;

/**
 * Convert one object type to another
 */
public interface Converter<F, T> {

    T convert(F fromObject);
}
