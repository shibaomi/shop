package com.study.springmvc.dal.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.ProductModel;

/**
 * 产品dao层
 * @author 史保密 2017年8月23日
 */
public interface ProductDao {
    /**
     * 新增产品信息
     */
    int insert(ProductModel record);

    /**
     * 根据id查询产品信息
     */
    ProductModel selectByPrimaryKey(Long id);

    /**
     * 选择性更新产品信息
     */
    int updateByPrimaryKeySelective(ProductModel record);

    /**
     * 更新全部产品信息
     */
    int updateByPrimaryKey(ProductModel record);
}