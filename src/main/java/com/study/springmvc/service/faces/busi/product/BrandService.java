package com.study.springmvc.service.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.BrandModel;

/**
 * 产品品牌Dao层
 * @author 史保密
 */
public interface BrandService {
	/**
	 * 新增品牌
	 */
	int saveBrandModel(BrandModel brand);
	
	/**
	 * 更新品牌
	 */
	int updateBrandModel(BrandModel brand);
	
	/**
	 * 根据id查询品牌
	 */
	BrandModel queryBrandModelById(Long id);
}
