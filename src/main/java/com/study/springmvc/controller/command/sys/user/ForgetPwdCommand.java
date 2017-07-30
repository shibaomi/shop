package com.study.springmvc.controller.command.sys.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.study.springmvc.common.selfannotation.Scope;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 忘记密码请求command
 * @author shibaomi
 */
@Data
@ApiModel(description="忘记密码发送请求model")
public class ForgetPwdCommand {
	
	/**找回密码方式**/
	@ApiModelProperty(value = "找回密码方式",required=true,example="MOBILE",
			allowableValues="MOBILE,EMAIL")
	@NotNull(message="找回密码方式必传")
	@Scope(value={"MOBILE","EMAIL"},
		message="找回密码方式不在指定范围内")
	private String forgetPwdType;
	
	/**找回密码使用的账号（手机为手机号，邮箱为邮箱账户）**/
	@ApiModelProperty(value = "找回密码使用的账户（手机为手机号，邮箱为邮箱账户）",example="15201857832")
	@NotBlank(message="找回密码使用的账户必传")
	private String accountNo;
	
	/*** 短信/邮箱等收到验证的流水  */
	@ApiModelProperty(value = "短信或邮箱的验证通过的流水",example="1")
	@NotBlank(message="验证流水必传")
	private String verifyNum;
	
	/*** 账号密码 */
	@ApiModelProperty(value = "账号新登录密码",example="123456")
	@NotBlank(message="新登录密码必传")
	@Length(max=30,min=6,message="请输入6-30新登录密码")
	private String pwd;

}
