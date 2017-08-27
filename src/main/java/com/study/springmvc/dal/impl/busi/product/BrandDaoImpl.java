package com.study.springmvc.dal.impl.busi.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.study.springmvc.common.constant.common.CommonStatus;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.BrandDao;
import com.study.springmvc.dal.model.busi.product.BrandModel;

@Repository
public class BrandDaoImpl implements BrandDao {

	@Autowired
	private BaseDao_Mybatis baseDao;

	public int insert(BrandModel record){
		return baseDao.insert("BrandMapper.insert", record);
	}

	public BrandModel selectByPrimaryKey(Long id,List<CommonStatus> brandStatus){
		Map<String,Object> parameters=new HashMap<String,Object>();
		parameters.put("id", id);
		if(!CollectionUtils.isEmpty(brandStatus)){
			List<String> status=new ArrayList<String>();
			for(CommonStatus cs: brandStatus){
				status.add(cs.name());
			}
			parameters.put("brandStatus", status);
		}
		return baseDao.selectOne("BrandMapper.selectByPrimaryKey",parameters);
	}

	public int updateByPrimaryKeySelective(BrandModel record){
		return baseDao.update("BrandMapper.updateByPrimaryKeySelective", record);
	}

	public int updateByPrimaryKey(BrandModel record){
		return baseDao.update("BrandMapper.updateByPrimaryKey", record);
	}

	@Override
	public List<BrandModel> selectByBrandName(String brandName, List<CommonStatus> brandStatus) {
		Map<String,Object> parameters=new HashMap<String,Object>();
		parameters.put("brandName", brandName);
		if(!CollectionUtils.isEmpty(brandStatus)){
			List<String> status=new ArrayList<String>();
			for(CommonStatus cs: brandStatus){
				status.add(cs.name());
			}
			parameters.put("brandStatus", status);
		}
		List<BrandModel>result=baseDao.selectList("BrandMapper.selectByBrandName", parameters);
		return result;
	}

	@Override
	public List<BrandModel> selectByBrandCode(String brandCode, List<CommonStatus> brandStatus) {
		Map<String,Object> parameters=new HashMap<String,Object>();
		parameters.put("brandCode", brandCode);
		if(!CollectionUtils.isEmpty(brandStatus)){
			List<String> status=new ArrayList<String>();
			for(CommonStatus cs: brandStatus){
				status.add(cs.name());
			}
			parameters.put("brandStatus", status);
		}
		List<BrandModel>result=baseDao.selectList("BrandMapper.selectByBrandCode", parameters);
		return result;
	}

	@Override
	public List<BrandModel> selectByBrandNameAndBrandCode(String brandCode, String brandName, List<CommonStatus> brandStatus) {
		Map<String,Object> parameters=new HashMap<String,Object>();
		parameters.put("brandCode", brandCode);
		parameters.put("brandName", brandName);
		if(!CollectionUtils.isEmpty(brandStatus)){
			List<String> status=new ArrayList<String>();
			for(CommonStatus cs: brandStatus){
				status.add(cs.name());
			}
			parameters.put("brandStatus", status);
		}
		List<BrandModel>result=baseDao.selectList("BrandMapper.selectByBrandNameAndBrandCode", parameters);
		return result;
	}

	@Override
	public List<BrandModel> selectByCompanyId(Long companyId, List<CommonStatus> brandStatus) {
		Map<String,Object> parameters=new HashMap<String,Object>();
		parameters.put("companyId", companyId);
		if(!CollectionUtils.isEmpty(brandStatus)){
			List<String> status=new ArrayList<String>();
			for(CommonStatus cs: brandStatus){
				status.add(cs.name());
			}
			parameters.put("brandStatus", status);
		}
		List<BrandModel>result=baseDao.selectList("BrandMapper.selectByCompanyId", parameters);
		return result;
	}

}
