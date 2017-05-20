package com.study.springmvc.dal.model.sms;

import com.study.springmvc.common.constant.sms.SmsState;
import com.study.springmvc.common.constant.sms.SmsType;
import com.study.springmvc.common.constant.user.CertificateType;
import com.study.springmvc.controller.command.sms.SendSmsCommand;
import com.study.springmvc.dal.model.TimeModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 短信流水映射类
 * @author shibaomi
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class SmsFlowModel extends TimeModel{
	/**短信流水,无意义主键**/
	private Long flowNo;
	/***短信接收手机***/
	private Long mobile;
	/***短信发送应用类型***/
	private SmsType smsType;
	/***证件类型***/
	private CertificateType certiType;
	/***证件号***/
	private String certiNo;
	/**短信验证码*/
	private String verifyCode;
	/***关联业务流水***/
	private String originBizNo;
	/***短信验证状态***/
	private SmsState state=SmsState.INIT;
	/***备注***/
	private String remark;
	
	/**
	 * 默认短信流水构造
	 */
	public SmsFlowModel(){
		
	}
	
	public SmsFlowModel(SendSmsCommand command,String verifyCode){
		this.certiNo=command.getCertiNo();
		this.certiType=command.getCertiType();
		this.mobile=command.getMobile();
		this.originBizNo=command.getOriginBizNo();
		this.remark=command.getRemark();
		this.smsType=command.getSmsType();
		this.verifyCode=verifyCode;
	}
}
