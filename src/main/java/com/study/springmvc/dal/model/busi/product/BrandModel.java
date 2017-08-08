package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.common.constant.common.CommonState;
import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 产品品牌model
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class BrandModel extends BaseModel{
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 品牌名称
	 */
	private String brandName;
	
	/**
	 * 品牌编码
	 */
	private String brandCode;
	
	/**
	 * 品牌简介
	 */
	private String summary;
	
	/**
	 * 品牌描述
	 */
	private String brandDesc;
	
	/**
	 * 品牌状态
	 */
	private CommonState brandStatus;
	
	/**
	 * 品牌logo图片地址
	 */
	private String logoImageUrl;
}
