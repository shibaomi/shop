package com.study.springmvc.dal.faces.busi.product;

import java.util.List;

import com.study.springmvc.common.constant.common.CommonStatus;
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
     * 注：brandStatus可选，不填查所有状态的数据
     */
    BrandModel selectByPrimaryKey(Long id,List<CommonStatus> brandStatus);
    
    /**
     * 根据品牌名称查看品牌信息
     * 注：brandStatus可选，不填查所有状态的数据
     */
    List<BrandModel> selectByBrandName(String brandName,List<CommonStatus> brandStatus);

    /**
     * 根据品牌code查看品牌信息
     * 注：brandStatus可选，不填查所有状态的数据
     */
    List<BrandModel> selectByBrandCode(String brandCode,List<CommonStatus> brandStatus);
    
    /**
     * 根据品牌名称或品牌code查看品牌信息（只要符合其中一条（名称或code）就返回数据）
     * 注：brandStatus可选，不填查所有状态的数据
     */
    List<BrandModel> selectByBrandNameAndBrandCode(String brandCode,String brandName,List<CommonStatus> brandStatus);
    
    /**
     * 根据关联公司id查看品牌信息
     * 注：brandStatus可选，不填查所有状态的数据
     */
    List<BrandModel> selectByCompanyId(Long companyId,List<CommonStatus> brandStatus);
    
    /**
     * 选择性更新品牌信息
     */
    int updateByPrimaryKeySelective(BrandModel record);

    /**
     * 更新全部品牌信息
     */
    int updateByPrimaryKey(BrandModel record);
    
    /**
     * 分页查询品牌信息列表
     */
    List<BrandModel> selectByPage(String brandName,String brandCode,List<CommonStatus> brandStatus,Long companyId,Integer offset,Integer limit);
}