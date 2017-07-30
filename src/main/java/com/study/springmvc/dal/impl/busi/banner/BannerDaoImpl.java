package com.study.springmvc.dal.impl.busi.banner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.springmvc.common.constant.banner.BannerType;
import com.study.springmvc.common.constant.common.ChannelType;
import com.study.springmvc.common.constant.common.CommonState;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.banner.BannerDao;
import com.study.springmvc.dal.model.busi.banner.BannerModel;

@Repository
public class BannerDaoImpl implements BannerDao{
	@Autowired
	private BaseDao_Mybatis baseDao;

	@Override
	public int saveBanner(BannerModel banner) {
		return baseDao.insert("BannerModelMapper.insertBanner", banner);
	}

	@Override
	public int updateBanner(BannerModel banner) {
		Map<String,Object>parameter=new HashMap<String,Object>();
		parameter.put("name", banner.getName());
		parameter.put("type", banner.getType().name());
		parameter.put("channel", banner.getChannel().name());
		parameter.put("imageUrl", banner.getImageUrl());
		parameter.put("valueType", banner.getValueType().name());
		parameter.put("value", banner.getValue());
		parameter.put("remark", banner.getRemark());
		parameter.put("createBy", banner.getCreateBy());
		parameter.put("updateBy", banner.getUpdateBy());
		return baseDao.update("BannerModelMapper.updateBanner", parameter);
	}

	@Override
	public int updateBannerState(Long id, CommonState state) {
		Map<String,Object>parameter=new HashMap<String,Object>();
		parameter.put("id", id);
		parameter.put("state", state.name());
		return baseDao.update("BannerModelMapper.updateBannerState", parameter);
	}

	@Override
	public BannerModel queryBannerModel(Long id) {
		return baseDao.selectOne("BannerModelMapper.selectByKey", id);
	}

	@Override
	public List<BannerModel> queryBannerModel(BannerType type, CommonState state, ChannelType channel,Integer offset,Integer limit) {
		Map<String,Object>parameter=new HashMap<String,Object>();
		parameter.put("type", type==null?null:type.name());
		parameter.put("state", state==null?null:state.name());
		parameter.put("channel",channel==null?null:channel.name());
		if(offset!=null&&limit!=null){
			parameter.put("offset",offset);
			parameter.put("limit",limit);
		}
		List<BannerModel> result=baseDao.selectList("BannerModelMapper.selectByType_State_Channle", parameter);
		return result;
	}
}
