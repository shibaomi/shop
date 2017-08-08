package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 产品关联的规格model(所有产品都有的)
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class ProductSpecificationModel extends BaseModel{
	
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	/**
	 * 产品对应的规格选项id
	 */
	private Long optionId;
	
	/**
	 * 产品对应的规格id
	 */
	private Long specificationId;
	
}
