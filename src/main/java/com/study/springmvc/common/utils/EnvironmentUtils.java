package com.study.springmvc.common.utils;

import org.springframework.util.StringUtils;

public abstract class EnvironmentUtils {

	public static final String ENV_CONFIG_NAME = "config_env";
	
	public static final String env;
	static {
		if(!StringUtils.isEmpty(System.getProperty(ENV_CONFIG_NAME))){
			env = System.getProperty(ENV_CONFIG_NAME);
		}else if(!StringUtils.isEmpty(System.getenv(ENV_CONFIG_NAME))){
			env = System.getenv(ENV_CONFIG_NAME);
		}else{
			env = "dev";
		}
	}
}
