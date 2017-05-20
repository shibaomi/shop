package com.study.springmvc.dal.model;

import java.util.Date;

import lombok.Data;

/**
 * 基础时间model，存创建时间和更新时间
 * @author shibaomi
 */
@Data
public class TimeModel {
	/**创建时间**/
	private Date createTime;
	/**修改时间**/
	private Date updateTime;
}
