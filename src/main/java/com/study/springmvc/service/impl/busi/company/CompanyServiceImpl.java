package com.study.springmvc.service.impl.busi.company;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.springmvc.common.constant.common.CommonStatus;
import com.study.springmvc.dal.model.busi.company.CompanyModel;
import com.study.springmvc.service.faces.busi.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Override
	public CompanyModel selectByPrimaryKey(Long id, List<CommonStatus> companyStatus) {
		return new CompanyModel();
	}

}
