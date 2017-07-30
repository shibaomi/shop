package com.study.springmvc.controller.dto.sys.sms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * 短信发送结果响应model
 * @author shibaomi
 */
@ApiModel(description="短信发送结果响应model")
@Data
public class SendSmsDto {
	/***
	 * 短信发送结果流水
	 */
	@ApiModelProperty(value = "短信发送结果流水号",example="1")
	private Long flowNo;
	
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注，暂留",example="1")
	private String remark;
}
