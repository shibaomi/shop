package com.study.springmvc.dal.model.common;

import lombok.Data;

/**
 * 大学信息
 * @author shibaomi
 */
@Data
public class University {
	/*** 大学id，目前可能用不到，扩展保留 **/
	private Long universityId;
	/*** 大学全称 **/
	private String universityName;
}
