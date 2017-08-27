package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.common.constant.common.CommonStatus;
import com.study.springmvc.common.constant.product.CategoryLevel;
import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 产品类别
 * @author 史保密
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class CategoryModel extends BaseModel{
	/**
	 * 无意义主键
	 */
	private Long id;
	
	/**
	 * 类别名称
	 */
	private String categoryName;
	
	/**
	 * 类别编码
	 */
	private String categoryCode;
	
	/**
	 * 类别描述
	 */
	private String categoryDesc;
	
	/**
	 * 类别状态
	 */
	private CommonStatus categoryStatus;
	
	/**
	 * 类别级别
	 */
	private CategoryLevel categoryLevel;
	
	/**
	 * 直接父类id
	 */
	private Long categoryParentId;
	
	/**
	 * 所有父类id组合，第一个为一级父类id，第二个为二级父类id，最后一个字符串一定为","
	 */
	private String parentsId;
}
