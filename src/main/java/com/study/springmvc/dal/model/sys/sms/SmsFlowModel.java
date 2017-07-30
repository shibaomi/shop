package com.study.springmvc.dal.model.sys.sms;

import com.study.springmvc.common.constant.common.CertificateType;
import com.study.springmvc.common.constant.sms.SmsState;
import com.study.springmvc.common.constant.sms.SmsType;
import com.study.springmvc.controller.command.sys.sms.SendSmsCommand;
import com.study.springmvc.dal.model.TimeModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 短信流水映射类
 * @author shibaomi
 */
@ApiModel(description="短信流水映射类")
@EqualsAndHashCode(callSuper=false)
@Data
public class SmsFlowModel extends TimeModel{
	/**短信流水**/
	@ApiModelProperty(value = "短信发送结果流水号",example="1")
	private Long flowNo;
	/***短信接收手机***/
	@ApiModelProperty(value = "短信接收手机",example="15201857832")
	private Long mobile;
	/***短信发送应用类型***/
	@ApiModelProperty(value = "短信发送应用类型",example="FAST_MOBILE_REGISTER")
	private SmsType smsType;
	/***证件类型***/
	@ApiModelProperty(value = "证件类型",example="ID")
	private CertificateType certiType;
	/***证件号***/
	@ApiModelProperty(value = "证件号",example="411XXX19XXXXXXXXXX")
	private String certiNo;
	/**短信验证码*/
	@ApiModelProperty(value = "短信验证码",example="1XDF")
	private String verifyCode;
	/***关联业务流水***/
	@ApiModelProperty(value = "关联业务流水")
	private String originBizNo;
	/***短信验证状态***/
	@ApiModelProperty(value = "短信验证状态",example="INIT")
	private SmsState state=SmsState.INIT;
	/***备注***/
	@ApiModelProperty(value = "备注")
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
