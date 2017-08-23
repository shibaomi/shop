package com.study.springmvc.service.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.AttributeModel;

/**
 * 分类属性service层
 * @author 史保密 2017年8月23日
 *
 */
public interface AttributeService {
    /**
     * 新增分类的属性
     */
    int insert(AttributeModel record);

    /**
     * 根据id查询分类的属性
     */
    AttributeModel selectByPrimaryKey(Long id);

    /**
     * 选择性更新分类的属性
     */
    int updateByPrimaryKeySelective(AttributeModel record);

    /**
     * 根据主键更新分类的属性，全部更新
     */
    int updateByPrimaryKey(AttributeModel record);
}