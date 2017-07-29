package com.study.springmvc.controller.command.user;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="登录发送请求model")
public class LoginCommand {
	
	/**登录账号，可为手机号、身份证号、邮箱、用户编号等**/
	@ApiModelProperty(value = "登录账号，可为手机号、身份证号、邮箱、用户编号等",example="15201857832")
	@NotBlank(message="登录账号必传")
	private String accountNo;
	
	/*** 账号密码 */
	@ApiModelProperty(value = "账号登录密码",example="123456")
	@NotBlank(message="登录密码必传")
	@Length(max=30,min=6,message="请输入6-30登录密码")
	private String pwd;

}
