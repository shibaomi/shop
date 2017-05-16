package com.study.springmvc.dal.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 用户信息表
 * @author shibaomi
 */
@EqualsAndHashCode(callSuper=false)
public @Data class UserModel extends BaseModel{
	// 无意义主键
	private Long id;
	// 用户编号
	private String userNo;
	// 真实姓名
	private String realName;
	// 昵称
	private String nickName;
	// 证件类型
	private String certiType;
	// 证件号码
	private String certiNo;
	// 手机号
	private String mobile;
	// 固话
	private String phone;
	// 邮箱
	private String email;
	// 地址
	private String addr;
	// 状态，0启用1停用2删除
	private String status;
	// 登录密码
	private String pwdLogin;
	// 描述
	private String description;
	// 大学
	private String university;
	// 学历
	private String degree;
	// 所属国家
	private String country;
	// 所在省或直辖市
	private String province;
	// 所属市
	private String city;
	// 所属县/区
	private String countyArea;
	// 乡镇/街道
	private String townStreet;
	// 村庄/路
	private String villageRoad;
}
