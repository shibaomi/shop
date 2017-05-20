package com.study.springmvc.controller.command;

import lombok.Data;

public @Data class FastRegisterCommand {
	
	/**注册账号类型**/
	private String accountType;
	
	/**注册账号**/
	private String accountNo;
	
	/*** 短信/邮箱等收到验证的流水  */
	private String verifyNum;

}
