package com.study.springmvc.dal.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.ProductAttributeModel;

/**
 * 产品关联的分类属性dao层
 * @author 史保密 2017年8月23日
 */
public interface ProductAttributeDao {
    /**
     * 新增产品关联的分类属性信息
     */
    int insert(ProductAttributeModel record);

    /**
     * 根据id查询产品关联的分类属性信息
     */
    ProductAttributeModel selectByPrimaryKey(Long id);

    /**
     * 有选择性的更新产品关联的分类属性信息
     */
    int updateByPrimaryKeySelective(ProductAttributeModel record);

    /**
     * 全部更新产品关联的分类属性信息
     */
    int updateByPrimaryKey(ProductAttributeModel record);
}