package com.study.springmvc.dal.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基础时间model，存创建时间和更新时间
 * @author shibaomi
 */
@Data
public class TimeModel {
	/**创建时间**/
	@ApiModelProperty(value = "创建时间",example="2017-05-26T08:21:31.342Z")
	private Date createTime;
	/**修改时间**/
	@ApiModelProperty(value = "修改时间",example="2017-05-26T08:21:31.342Z")
	private Date updateTime;
}
