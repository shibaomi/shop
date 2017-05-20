package com.study.springmvc.controller.dto.sms;

import lombok.Data;

/***
 * 短信发送结果页面
 * @author shibaomi
 */
@Data
public class SendSmsDto {
	/***
	 * 短信发送结果流水
	 */
	private Long flowNo;
	
	/**
	 * 备注
	 */
	private String remark;
}
