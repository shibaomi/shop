package com.study.springmvc.controller.command.sms;

import com.study.springmvc.common.constant.sms.SmsType;
import com.study.springmvc.common.constant.user.CertificateType;

import lombok.Data;

/**
 * 短信校验请求model
 * @author shibaomi
 */
@Data
public class VerifySmsCommand {
	/***短信发送结果流水*/
	private Long flowNo;
	/***短信发送应用类型***/
	private SmsType smsType;
	/**短信验证码*/
	private String verifyCode;
	/***短信接收手机***/
	private Long mobile;
	/***证件类型***/
	private CertificateType certiType;
	/***证件号***/
	private String certiNo;
	/***说明***/
	private String remark;
}
