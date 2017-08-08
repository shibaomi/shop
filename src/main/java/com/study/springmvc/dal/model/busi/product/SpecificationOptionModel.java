package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 产品规格选项
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class SpecificationOptionModel extends BaseModel{
	
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 规格选项名称
	 */
	private String optionName;
	
	/**
	 * 规格选项编码
	 */
	private String optionCode;
	
	/**
	 * 规格选项的值
	 */
	private String value;
	
	/**
	 * 规格选项描述
	 */
	private String optionDesc;
	
	/**
	 * 所属规格id
	 */
	private Long specificationId;
	
}
