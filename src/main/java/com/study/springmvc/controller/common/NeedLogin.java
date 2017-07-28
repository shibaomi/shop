package com.study.springmvc.controller.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要登录标识
 * @author shibaomi
 */
@Documented
@Retention (RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NeedLogin {
	
}
