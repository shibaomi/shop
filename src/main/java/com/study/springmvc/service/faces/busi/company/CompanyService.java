package com.study.springmvc.service.faces.busi.company;

import java.util.List;

import com.study.springmvc.common.constant.common.CommonStatus;
import com.study.springmvc.dal.model.busi.company.CompanyModel;

/**
 * 公司信息管理service
 * @author shibaomi 2017年8月27日
 */
public interface CompanyService {
	
	/**
     * 根据id查看公司信息
     * 注：companyStatus可选，不填查所有状态的数据
     */
	CompanyModel selectByPrimaryKey(Long id,List<CommonStatus> companyStatus);
	
}
