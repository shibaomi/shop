package com.study.springmvc.controller.command.sys.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.study.springmvc.common.selfannotation.Scope;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 快速注册请求command
 * @author shibaomi
 */
@Data
@ApiModel(description="快速注册发送请求model")
public class FastRegisterCommand {
	
	/**注册账号类型**/
	@ApiModelProperty(value = "注册账号类型",required=true,example="MOBILE",
			allowableValues="MOBILE,EMAIL,QQ,WEIXIN,XINLANG_WEIBO")
	@NotNull(message="注册账号类型必传")
	@Scope(value={"MOBILE","EMAIL","QQ","WEIXIN","XINLANG_WEIBO"},
		message="注册账号类型不在指定范围内")
	private String accountType;
	
	/**注册账号**/
	@ApiModelProperty(value = "注册账号（与注册类型相关，若为手机注册，则账号必须为验证短信的手机号，其他类似）",example="15201857832")
	@NotBlank(message="注册账号必传")
	@Length(max=30,min=6,message="请输入6-30位注册账号")
	private String accountNo;
	
	/*** 短信/邮箱等收到验证的流水  */
	@ApiModelProperty(value = "短信或邮箱的验证流水",example="1")
	@NotBlank(message="验证流水必传")
	private String verifyNum;
	
	/*** 账号密码 */
	@ApiModelProperty(value = "账号登录密码",example="123456")
	@NotBlank(message="登录密码必传")
	@Length(max=30,min=6,message="请输入6-30登录密码")
	private String pwd;

}
