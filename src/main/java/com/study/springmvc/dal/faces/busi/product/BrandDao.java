package com.study.springmvc.dal.faces.busi.product;

import com.study.springmvc.dal.model.busi.product.BrandModel;

/**
 * 品牌操作dao层
 * @author shibaomi 2017年8月26日
 */
public interface BrandDao {
    /**
     * 新增品牌
     */
    int insert(BrandModel record);

    /**
     * 根据id查看品牌信息
     */
    BrandModel selectByPrimaryKey(Long id);

    /**
     * 选择性更新品牌信息
     */
    int updateByPrimaryKeySelective(BrandModel record);

    /**
     * 更新全部品牌信息
     */
    int updateByPrimaryKey(BrandModel record);
}