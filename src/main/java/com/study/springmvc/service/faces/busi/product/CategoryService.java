package com.study.springmvc.service.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.CategoryModel;

/**
 * 产品品类service层
 * @author 史保密 2017年8月16日
 */
public interface CategoryService {
    /**
     * 新增产品品类
     */
    int insert(CategoryModel record);

    /**
     * 根据id查询产品品类信息
     */
    CategoryModel selectByPrimaryKey(Long id);

    /**
     * 根据所给信息更新产品品类信息
     */
    int updateByPrimaryKeySelective(CategoryModel record);

    /**
     *	根据id更新产品品类信息
     */
    int updateByPrimaryKey(CategoryModel record);
}
