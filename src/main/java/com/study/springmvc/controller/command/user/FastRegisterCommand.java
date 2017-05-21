package com.study.springmvc.controller.command.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.study.springmvc.common.selfannotation.Scope;

import lombok.Data;

/**
 * 快速注册请求command
 * @author shibaomi
 */
@Data
public class FastRegisterCommand {
	
	/**注册账号类型**/
	@NotNull(message="注册账号类型必传")
	@Scope(value={"MOBILE","EMAIL","QQ","WEIXIN","XINLANG_WEIBO"})
	private String accountType;
	
	/**注册账号**/
	@NotBlank(message="注册账号必传")
	private String accountNo;
	
	/*** 短信/邮箱等收到验证的流水  */
	
	private String verifyNum;

}
