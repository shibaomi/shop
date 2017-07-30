package com.study.springmvc.dal.model.sys.user;


import com.study.springmvc.common.constant.common.CertificateType;
import com.study.springmvc.common.constant.common.DegreeType;
import com.study.springmvc.common.constant.user.FastRegisterType;
import com.study.springmvc.common.constant.user.UserState;
import com.study.springmvc.controller.command.sys.user.FastRegisterCommand;
import com.study.springmvc.dal.model.BaseModel;
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
	
	/**
	 * 默认构造函数
	 */
	public UserModel(){
		
	}
	
	/**
	 * 快速注册构造函数
	 */
	public UserModel(FastRegisterCommand register){
		this.pwdLogin=register.getPwd();
		this.state=UserState.ENABLED;
		if(FastRegisterType.MOBILE.name().equals(register.getAccountType())){
			//手机注册，其他注册暂不处理
			this.mobile=register.getAccountNo();
			this.nickName=register.getAccountNo();
		}
	}
}
