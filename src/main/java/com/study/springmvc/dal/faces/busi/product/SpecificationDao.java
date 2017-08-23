package com.study.springmvc.dal.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.SpecificationModel;

/**
 * 产品规格dao层
 * @author 史保密 2017年8月23日
 */
public interface SpecificationDao {
    /**
     * 新增产品规格信息
     */
    int insert(SpecificationModel record);

    /**
     * 根据id查询产品规格信息
     */
    SpecificationModel selectByPrimaryKey(Long id);

    /**
     * 选择性更新产品规格信息
     */
    int updateByPrimaryKeySelective(SpecificationModel record);

    /**
     *	更新全部产品规格信息
     */
    int updateByPrimaryKey(SpecificationModel record);
}