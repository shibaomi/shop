package com.study.springmvc.controller.command;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="只有Id的post请求")
public class IdCommand {
	/*** 无意义主键 **/
	@ApiModelProperty(value = "无意义主键 ",required=true,example="1")
	@NotNull
	private Long id;
}
