package com.study.springmvc.dal.faces;

import com.study.springmvc.common.constant.sms.SmsState;
import com.study.springmvc.dal.model.sms.SmsFlowModel;

/**
 * 短信流水操作dao接口
 * @author shibaomi
 */
public interface SmsDao {
	/**
	 * 保存发送短信信息
	 */
	public int saveSmsInfo(SmsFlowModel sms);
	
	/**
	 * 更新所有短信流水状态为INIT的流水状态为TIME_OUT
	 */
	public int updateAllSmsFlowStateFromInitToTimeOut(Long mobile);
	
	/**
	 * 根据短信流水id查询发送短信信息
	 */
	public SmsFlowModel getSmsInfoById(Long flowNo);
	
	/**
	 * 根据手机号查询最新有效的短信消息
	 */
	public SmsFlowModel getLastEffectiveSmsInfoByMobile(Long mobile);
	
	/**
	 * 根据短信流水更新短信的状态
	 */
	public int updateSmsFlowState(Long flowNo,SmsState state);

}
