package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.common.constant.common.CommonState;
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
	private String catagoryName;
	
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
	private CommonState categoryStatus;
	
	/**
	 * 类别级别
	 */
	private CategoryLevel categoryLevel;
	
	/**
	 * 父类id
	 */
	private Long categoryParentId;
}
