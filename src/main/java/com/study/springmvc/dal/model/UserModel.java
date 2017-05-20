package com.study.springmvc.dal.model;


import com.study.springmvc.common.constant.user.CertificateType;
import com.study.springmvc.common.constant.user.DegreeType;
import com.study.springmvc.common.constant.user.UserState;
import com.study.springmvc.dal.model.common.Address;
import com.study.springmvc.dal.model.common.University;

import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 用户信息表
 * @author shibaomi
 */
@EqualsAndHashCode(callSuper=false)
public @Data class UserModel extends BaseModel{
	/*** 无意义主键 **/
	private Long id;
	/*** 用户编号 **/
	private String userNo;
	/*** 真实姓名 **/
	private String realName;
	/*** 昵称  **/
	private String nickName;
	/*** 证件类型 **/
	private CertificateType certiType;
	/*** 证件号码 **/
	private String certiNo;
	/*** 手机号 **/
	private String mobile;
	/*** 固话 **/
	private String phone;
	/*** 邮箱 **/
	private String email;
	/*** 地址 **/
	private String addr;
	/*** 状态 ，ENABLED（可用）、FROZEN（冻结），注：删除状态的用户直接移到历史账号表中**/
	private UserState state;
	/*** 登录密码 **/
	private String pwdLogin;
	/*** 描述 **/
	private String description;
	/**大学信息**/
	private University university;
	/*** 学历 **/
	private DegreeType degree;
	
	/*** 地址信息  */
	private Address address;
	
}