package com.study.springmvc.dal.model.busi.product;

import com.study.springmvc.common.constant.common.CommonStatus;
import com.study.springmvc.controller.command.busi.product.BrandCommand;
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
	private CommonStatus brandStatus;
	
	/**
	 * 品牌logo图片地址
	 */
	private String logoImageUrl;
	
	/**
	 * 品牌所属公司id
	 */
	private Long companyId;
	
	public BrandModel(){
		
	}
	
	public BrandModel(BrandCommand record){
		if(record!=null){
			this.brandCode=record.getBrandCode();
			this.brandDesc=record.getBrandDesc();
			this.brandName=record.getBrandName();
			this.companyId=record.getCompanyId();
			this.id=record.getId();
			this.logoImageUrl=record.getLogoImageUrl();
			this.summary=record.getSummary();
			this.setCreateBy(record.getCreateBy());
			this.setUpdateBy(record.getUpdateBy());
		}
	}
}
