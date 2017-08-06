package com.study.springmvc.common.selfannotation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.study.springmvc.common.selfannotation.Scope;
import com.study.springmvc.common.utils.ArraysUtils;

public class ScopeValidator implements ConstraintValidator<Scope, Object>{
	
	//存放约束条件
	private String[] scopesValue;
	
	//实例化约束调试
	public void initialize(Scope scope) {
		this.scopesValue=scope.value();
	}

	@SuppressWarnings("rawtypes")
	public boolean isValid(Object paramter, ConstraintValidatorContext constraintValidatorContext) {
		if(paramter instanceof String){
			if(StringUtils.isEmpty(paramter)||ArraysUtils.isEmpty(scopesValue)){
				return true;
			}
			for(String value:scopesValue){
				if(value.equals(paramter)){
					return true;
				}
			}
		}else if(paramter instanceof Enum){
			if(paramter==null||ArraysUtils.isEmpty(scopesValue)){
				return true;
			}
			for(String value:scopesValue){
				if(value.equals(((Enum) paramter).name())){
					return true;
				}
			}
		}
		return false;
	}
}
