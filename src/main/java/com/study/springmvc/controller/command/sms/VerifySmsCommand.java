package com.study.springmvc.controller.command.sms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.StringUtils;

import com.study.springmvc.common.constant.sms.SmsType;
import com.study.springmvc.common.constant.user.CertificateType;
import com.study.springmvc.common.selfannotation.Scope;
import com.study.springmvc.common.utils.EnumUtils;
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
	@Scope(value={"FAST_MOBILE_REGISTER"})
	private String smsType;
	/**短信验证码*/
	@NotBlank(message="短信验证码必传")
	private String verifyCode;
	/***短信接收手机***/
	@Pattern(regexp=Validator.REGEX_MOBILE,message="手机格式不正确或非法手机号")
	private String mobile;
	/***证件类型***/
	@Scope(value={"ID"})
	private String certiType;
	/***证件号***/
	private String certiNo;
	/***说明***/
	private String remark;
	
	public Long getMobile(){
		if(!StringUtils.isEmpty(this.mobile)){
			return Long.parseLong(this.mobile);
		}
		return null;
	}
	
	/**
	 * 短信场景：字符串转枚举类型
	 */
	public SmsType getSmsType(){
		if(StringUtils.isEmpty(this.smsType)){
			return null;
		}
		return EnumUtils.noErrorValueOf(SmsType.class, this.smsType);
	}
	
	/**
	 * 证件类型：字符串转枚举类型
	 */
	public CertificateType getCertiType(){
		if(StringUtils.isEmpty(this.certiType)){
			return null;
		}
		return EnumUtils.noErrorValueOf(CertificateType.class, this.certiType);
	}
}
