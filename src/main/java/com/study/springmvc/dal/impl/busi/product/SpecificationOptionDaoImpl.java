package com.study.springmvc.dal.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.SpecificationOptionDao;

import com.study.springmvc.dal.model.busi.product.SpecificationOptionModel;

@Repository
public class SpecificationOptionDaoImpl implements SpecificationOptionDao {

	@Autowired
	private BaseDao_Mybatis baseDao;

	public int insert(SpecificationOptionModel record){
		return baseDao.insert("SpecificationOptionMapper.insert", record);
	}


	public SpecificationOptionModel selectByPrimaryKey(Long id){
		return baseDao.selectOne("SpecificationOptionMapper.selectByPrimaryKey", id);
	}


	public int updateByPrimaryKeySelective(SpecificationOptionModel record){
		return baseDao.update("SpecificationOptionMapper.updateByPrimaryKeySelective", record);
	}


	public int updateByPrimaryKey(SpecificationOptionModel record){
		return baseDao.update("SpecificationOptionMapper.updateByPrimaryKey", record);
	}

}
