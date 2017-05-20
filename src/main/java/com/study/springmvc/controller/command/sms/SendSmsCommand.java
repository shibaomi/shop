package com.study.springmvc.controller.command.sms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.util.StringUtils;

import com.study.springmvc.common.constant.sms.SmsType;
import com.study.springmvc.common.constant.user.CertificateType;
import com.study.springmvc.common.utils.Validator;

import lombok.Data;

/**
 * 短信发送请求model
 * @author shibaomi
 */
@Data
public class SendSmsCommand {
	/***短信接收手机***/
	@NotNull(message="手机号必传")
	@Pattern(regexp=Validator.REGEX_MOBILE,message="手机格式不正确或非法手机号")
	private String mobile;
	/***短信发送应用类型***/
	@NotNull(message="短信发送场景类型必传")
	
	private SmsType smsType;
	/***证件类型***/
	private CertificateType certiType;
	/***证件号***/
	private String certiNo;
	/***关联业务流水***/
	private String originBizNo;
	/***备注***/
	private String remark;
	
	public Long getMobile(){
		if(!StringUtils.isEmpty(this.mobile)){
			return Long.parseLong(this.mobile);
		}
		return null;
	}
}
