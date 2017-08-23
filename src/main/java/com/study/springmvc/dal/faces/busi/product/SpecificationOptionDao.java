package com.study.springmvc.dal.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.SpecificationOptionModel;

/**
 * 产品规格选项dao层
 * @author 史保密 2017年8月23日
 */
public interface SpecificationOptionDao {
    /**
     * 新增产品规格选项信息
     */
    int insert(SpecificationOptionModel record);

    /**
     * 根据id查询产品规格选项信息
     */
    SpecificationOptionModel selectByPrimaryKey(Long id);

    /**
     * 选择性更新产品规格选项信息
     */
    int updateByPrimaryKeySelective(SpecificationOptionModel record);

    /**
     * 全部更新产品规格选项信息
     */
    int updateByPrimaryKey(SpecificationOptionModel record);
}