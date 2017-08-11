package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.common.constant.product.AttributeType;
import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分类的属性
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class AttributeModel extends BaseModel{
	
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 属性名称
	 */
	private String attributeName;
	
	/**
	 * 属性编码
	 */
	private String attributeCode;
	
	/**
	 * 属性类型
	 */
	private AttributeType attributeType;
	
	/**
	 * 属性描述
	 */
	private String attrbuteDesc;
	
	/**
	 * 所属产品类别id
	 */
	private Long categoryId;
}
