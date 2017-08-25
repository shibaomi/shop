package com.study.springmvc.service.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.ProductSpecificationModel;
/**
 * 产品关联的规格信息service层(所有产品都有的)
 * @author 史保密 2017年8月23日
 */
public interface ProductSpecificationService {
    /**
     * 新增产品关联的规格信息
     */
    int insert(ProductSpecificationModel record);

    /**
     * 根据id查询产品关联的规格信息
     */
    ProductSpecificationModel selectByPrimaryKey(Long id);

    /**
     * 选择性更新产品关联的规格信息
     */
    int updateByPrimaryKeySelective(ProductSpecificationModel record);

    /**
     * 全部更新产品关联的规格信息
     */
    int updateByPrimaryKey(ProductSpecificationModel record);
}
