package com.study.springmvc.controller.command.sms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.study.springmvc.common.constant.sms.SmsType;
import com.study.springmvc.common.constant.user.CertificateType;
import com.study.springmvc.common.utils.Validator;

import lombok.Data;

/**
 * 短信校验请求model
 * @author shibaomi
 */
@Data
public class VerifySmsCommand {
	/***短信发送结果流水*/
	@NotNull(message="短信发送流水必传")
	private Long flowNo;
	/***短信发送应用类型***/
	@NotNull(message="短信发送场景类型必传")
	private SmsType smsType;
	/**短信验证码*/
	@NotBlank(message="短信验证码必传")
	private String verifyCode;
	/***短信接收手机***/
	@Pattern(regexp=Validator.REGEX_MOBILE,message="手机格式不正确或非法手机号")
	private String mobile;
	/***证件类型***/
	private CertificateType certiType;
	/***证件号***/
	private String certiNo;
	/***说明***/
	private String remark;
}
