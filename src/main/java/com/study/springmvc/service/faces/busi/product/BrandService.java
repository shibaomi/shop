package com.study.springmvc.service.faces.busi.product;

import java.util.List;

import com.study.springmvc.common.constant.common.CommonStatus;
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
    
    /**
     * 分页查询品牌信息列表
     */
    List<BrandModel> selectByPage(String brandName,String brandCode,CommonStatus status,Long companyId,Integer offset,Integer limit);

}
