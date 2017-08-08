package com.study.springmvc.common.constant.product;

/**
 * 折扣类型
 * @author 史保密
 */
public enum DiscountType {
	NO,//没有折扣
	NORMAL,//普通折扣，没有规则，直接在产品经销商表中保存折扣信息
	COMPLEX,//复杂折扣，有折扣规则，产品经销商表中保存复杂折扣id
}
