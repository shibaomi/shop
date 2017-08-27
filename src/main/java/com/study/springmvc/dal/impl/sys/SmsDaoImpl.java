package com.study.springmvc.dal.impl.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.study.springmvc.common.constant.sms.SmsStatus;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.sys.SmsDao;
import com.study.springmvc.dal.model.sys.sms.SmsFlowModel;

@Repository
public class SmsDaoImpl implements SmsDao{
	@Autowired
	private BaseDao_Mybatis baseDao;

	@Override
	public int saveSmsInfo(SmsFlowModel sms) {
		return baseDao.insert("SmsFlowMapper.insertSmsFlow", sms);
	}

	@Override
	public int updateAllSmsFlowStatusFromInitToTimeOut(Long mobile) {
		Map<String,Object>parameter=new HashMap<String,Object>();
		parameter.put("mobile", mobile);
		parameter.put("newStatus", SmsStatus.TIME_OUT.toString());
		parameter.put("oldStatus", SmsStatus.INIT.toString());
		return baseDao.update("SmsFlowMapper.updateSmsFlowStatus", parameter);
	}

	@Override
	public SmsFlowModel getSmsInfoById(Long flowNo) {
		return baseDao.selectOne("SmsFlowMapper.selectByKey", flowNo);
	}

	@Override
	public int updateSmsFlowStatus(Long flowNo, SmsStatus status) {
		Map<String,Object>parameter=new HashMap<String,Object>();
		parameter.put("flowNo", flowNo);
		parameter.put("newStatus", status.toString());
		return baseDao.update("SmsFlowMapper.updateSmsFlowStatus", parameter);
	}

	@Override
	public SmsFlowModel getLastEffectiveSmsInfoByMobile(Long mobile) {
		Map<String,Object>parameter=new HashMap<String,Object>();
		parameter.put("mobile", mobile);
		parameter.put("smsStatus", SmsStatus.INIT.toString());
		List<SmsFlowModel> result=baseDao.selectList("SmsFlowMapper.selectLastEffectiveByMobile", parameter);
		if(CollectionUtils.isEmpty(result)){
			return null;
		}
		return result.get(0);
	}

}
