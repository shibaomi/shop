package com.study.springmvc.service.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.CategoryModel;

/**
 * 产品品类service
 * @author 史保密 2017年8月16日
 */
public interface CategoryService {
	/**
     * 新增产品品类
     */
    int createCategory(CategoryModel record);

    /**
     * 根据id查询产品品类信息
     */
    CategoryModel selectById(Long id);

    /**
     * 更新产品品类信息
     */
    int updateCategoryModel(CategoryModel record);
}
