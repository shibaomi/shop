package com.study.springmvc.common.constant.user;

/**
 * 用户状态，ENABLED（可用）、FROZEN（冻结）
 * 注：删除状态的用户直接移到历史账号表中
 * @author shibaomi
 */
public enum UserState {
	/**
	 * 可用
	 */
	ENABLED,
	/**
	 * 冻结
	 */
	FROZEN
}
