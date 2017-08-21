package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分类的属性选项model
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class AttributeOptionModel extends BaseModel{
	
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 属性选项名称
	 */
	private String optionName;
	
	/**
	 * 属性选项编码
	 */
	private String optionCode;
	
	/**
	 * 属性选项的值
	 */
	private String optionValue;
	
	/**
	 * 属性选项描述
	 */
	private String optionDesc;
	
	/**
	 * 所属属性id
	 */
	private Long atttibuteId;
	
	/**
	 * 所属产品类别id
	 */
	private Long categoryId;
}
