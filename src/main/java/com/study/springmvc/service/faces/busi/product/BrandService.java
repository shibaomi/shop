package com.study.springmvc.service.faces.busi.product;

import com.study.springmvc.controller.command.busi.product.BrandCommand;
import com.study.springmvc.dal.model.busi.product.BrandModel;

/**
 * 品牌操作service层
 * @author shibaomi 2017年8月26日
 */
public interface BrandService {
    /**
     * 新增品牌
     */
    Long insert(BrandCommand record);

    /**
     * 根据id查看品牌信息
     */
    BrandModel selectByPrimaryKey(Long id);

    /**
     * 选择性更新品牌信息
     */
    Long updateByPrimaryKeySelective(BrandCommand record);
    
    /**
     * 删除品牌信息
     */
    void deleteByPrimaryKey(Long id);

}
