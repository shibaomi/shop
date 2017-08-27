package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.common.constant.product.ProductStatus;
import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 产品model
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class ProductModel extends BaseModel{
	
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 产品编码
	 */
	private String productCode;
	
	/**
	 * 产品简介
	 */
	private String summary;
	
	/**
	 * 产品详细描述
	 */
	private String productDesc;
	
	/**
	 * 产品状态
	 */
	private ProductStatus productStatus;
	
	/**
	 * 产品app缩略图
	 */
	private String mobileImageUrl;
	
	/**
	 * 产品电脑缩略图
	 */
	private String computerImageUrl;
	
	/**
	 * 产品类别,已","分割，最左边是大类别的id，往右一级级类别的id
	 */
	private String categorys;
	
	/**
	 * 品牌id
	 */
	private Long brandId;
	
	/**
	 * 产品制造商id
	 */
	private Long manufacturerId;
	
	/**
	 * 是否新品
	 */
	private Boolean newProduct;
	
	/**
	 * 是否热门
	 */
	private Boolean hotProduct;
	
}
