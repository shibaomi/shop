package com.study.springmvc.common.selfannotation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.study.springmvc.common.selfannotation.Scope;
import com.study.springmvc.common.utils.ArraysUtils;

public class ScopeValidator implements ConstraintValidator<Scope, String>{
	
	//存放约束条件
	private String[] scopesValue;
	
	//实例化约束调试
	public void initialize(Scope scope) {
		this.scopesValue=scope.value();
	}

	public boolean isValid(String paramter, ConstraintValidatorContext constraintValidatorContext) {
		if(StringUtils.isEmpty(paramter)||ArraysUtils.isEmpty(scopesValue)){
			return true;
		}
		for(String value:scopesValue){
			if(value.equals(paramter)){
				return true;
			}
		}
		return false;
	}
}
