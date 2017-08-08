package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 产品规格
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class SpecificationModel extends BaseModel{
	
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 规格名称
	 */
	private String specificationName;
	
	/**
	 * 规格编码
	 */
	private String specificationCode;
	
	/**
	 * 规格描述
	 */
	private String specificationDesc;
	
}
