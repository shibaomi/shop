package com.study.springmvc.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class EnumUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnumUtils.class);

    public static <T extends Enum<T>> T noErrorValueOf(Class<T> enumType, String name) {
        try {
            return Enum.valueOf(enumType, name);
        } catch (Exception ex) {
            LOGGER.warn("枚举类型转换错误, {} is not a type of {}", name, enumType.getName());
            return null;
        }
    }
}
