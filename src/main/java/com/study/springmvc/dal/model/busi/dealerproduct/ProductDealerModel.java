package com.study.springmvc.dal.model.busi.dealerproduct;

import java.math.BigDecimal;

import com.study.springmvc.common.constant.product.DiscountType;
import com.study.springmvc.common.constant.product.ProductState;
import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 产品商家关联model
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class ProductDealerModel extends BaseModel{
	
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 产品id
	 */
	private Long productId;
	
	/**
	 * 经销商id
	 */
	private Long dealerId;
	
	/**
	 * 价格
	 */
	private BigDecimal price;
	
	/**
	 * 库存
	 */
	private Long stock;
	
	/**
	 * 产品状态
	 */
	private ProductState productStatus;
	
	/**
	 * 销量
	 */
	private Integer saleAmount;
	
	/**
	 * 折扣类型
	 */
	private DiscountType discountType;
	
	/**
	 * 普通折扣金额
	 */
	private BigDecimal discount;
	
	/**
	 * 点击量
	 */
	private Integer clickAmount;
	
}
