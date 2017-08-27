package com.study.springmvc.controller.command.busi.product;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 品牌更新新建发送请求model
 * @author shibaomi
 */
@ApiModel(description="轮播图新增更新发送请求model")
@Data
public class BrandCommand{
	/*** 无意义主键 **/
	@ApiModelProperty(hidden=true)
	private Long id;
	
	/*** 品牌名称 **/
	@ApiModelProperty(value = "品牌名称",required=true,example="特步")
	@NotNull(message="品牌名称必传")
	private String brandName;
	
	/*** 品牌编码 **/
	@ApiModelProperty(value = "品牌编码",required=true,example="tebu")
	@NotNull(message="品牌编码必传")
	private String brandCode;
	
	/*** 品牌简介**/
	@ApiModelProperty(value = "品牌简介",required=true,example="品牌简介")
	@NotNull(message="品牌简介必传")
	private String summary;
	
	/*** 品牌描述 **/
	@ApiModelProperty(value = "品牌描述",required=true,example="品牌描述")
	@NotNull(message="品牌描述必传")
	private String brandDesc;
	
	/*** 品牌logo图片地址  **/
	@ApiModelProperty(value = "品牌logo图片地址",required=true,example="/test/tebu.jpg")
	@NotNull(message="品牌logo图片地址必传")
	private String logoImageUrl;
	
	/*** 品牌所属公司id **/
	@ApiModelProperty(value = "品牌所属公司id",example="1")
	private Long companyId;
	
	//创建人
	@ApiModelProperty(hidden=true)
	private String createBy;
	//修改人id
	@ApiModelProperty(hidden=true)
	private String updateBy;
	
}
