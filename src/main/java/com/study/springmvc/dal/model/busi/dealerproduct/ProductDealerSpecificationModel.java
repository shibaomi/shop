package com.study.springmvc.dal.model.busi.dealerproduct;

import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商家产品规格关联model
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class ProductDealerSpecificationModel extends BaseModel{
	
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 产品商家关联表id
	 */
	private Long productDealerId;
	
	/**
	 * 规格选项id
	 */
	private Long specificationOptionId;
	
}
