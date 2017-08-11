package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 产品关联的分类属性model
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class ProductAttributeModel extends BaseModel{
	
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	/**
	 * 产品对应的属性选项id
	 */
	private Long optionId;
	
	/**
	 * 产品对应的属性id
	 */
	private Long attributeId;
	
	/**
	 * 所属产品类别id
	 */
	private Long categoryId;
	
}
