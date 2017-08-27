package com.study.springmvc.controller.command.busi.product;

import javax.validation.constraints.NotNull;

import com.study.springmvc.common.constant.product.CategoryLevel;
import com.study.springmvc.common.selfannotation.Scope;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 产品类别更新新建发送请求model
 * @author 史保密
 */
@ApiModel(description="产品类别更新新建发送请求model")
@Data
public class CategoryCommand{
	/**
	 * 无意义主键
	 */
	@ApiModelProperty(hidden=true)
	private Long id;
	
	/**
	 * 类别名称
	 */
	@ApiModelProperty(value="类别名称",required=true,example="服饰")
	@NotNull(message="类别名称必传")
	private String categoryName;
	
	/**
	 * 类别编码
	 */
	@ApiModelProperty(value="类别编码",required=true,example="f001")
	@NotNull(message="类别编码必传")
	private String categoryCode;
	
	/**
	 * 类别描述
	 */
	@ApiModelProperty(value="类别描述",required=true,example="类别描述")
	@NotNull(message="类别描述必传")
	private String categoryDesc;
	
	/**
	 * 类别级别
	 */
	@ApiModelProperty(value = "类别级别",required=true,example="ROOT",
			allowableValues="ROOT")
	@NotNull(message="类别级别必传")
	@Scope(value={"ROOT"},message="类别级别不在指定范围内")
	private CategoryLevel categoryLevel;
	
	/**
	 * 直接父类id
	 */
	@ApiModelProperty(value = "直接父类id",example="1")
	private Long categoryParentId;
}
