package com.study.springmvc.service.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.AttributeOptionModel;

/**
 * 分类的属性选项service层
 * @author 史保密 2017年8月23日
 */
public interface AttributeOptionService {
    /**
     * 新增分类的属性选项信息
     */
    int insert(AttributeOptionModel record);

    /**
     * 根据id查询分类的属性s选项信息
     */
    AttributeOptionModel selectByPrimaryKey(Long id);

    /**
     * 选择性的更新分类的属性选项信息
     */
    int updateByPrimaryKeySelective(AttributeOptionModel record);

    /**
     * 更新分类的属性选项信息的全部属性
     */
    int updateByPrimaryKey(AttributeOptionModel record);
}