package com.study.springmvc.controller.command.sms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.util.StringUtils;

import com.study.springmvc.common.constant.sms.SmsType;
import com.study.springmvc.common.constant.user.CertificateType;
import com.study.springmvc.common.selfannotation.Scope;
import com.study.springmvc.common.utils.EnumUtils;
import com.study.springmvc.common.utils.Validator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 短信发送请求model
 * @author shibaomi
 */
@Data
@ApiModel(description="短信发送请求model")
public class SendSmsCommand {
	/***短信接收手机***/
	@ApiModelProperty(value = "手机号",required=true,example="15201857832")
	@NotNull(message="手机号必传")
	@Pattern(regexp=Validator.REGEX_MOBILE,message="手机格式不正确或非法手机号")
	private String mobile;
	/***短信发送应用类型***/
	@ApiModelProperty(value = "短信发送应用类型",required=true,example="FAST_MOBILE_REGISTER",
			allowableValues="FAST_MOBILE_REGISTER")
	@NotNull(message="短信发送场景类型必传")
	@Scope(value={"FAST_MOBILE_REGISTER"},message="短信发送应用类型不在指定范围内")
	private String smsType;
	/***证件类型***/
	@ApiModelProperty(value = "证件类型",example="ID",
			allowableValues="ID")
	@Scope(value={"ID"},message="证件类型不在指定范围内")
	private String certiType;
	/***证件号***/
	@ApiModelProperty(value = "证件号",example="411XXX19XXXXXXXXXX")
	private String certiNo;
	/***关联业务流水***/
	@ApiModelProperty(value = "关联业务流水")
	private String originBizNo;
	/***备注***/
	@ApiModelProperty(value = "备注")
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
