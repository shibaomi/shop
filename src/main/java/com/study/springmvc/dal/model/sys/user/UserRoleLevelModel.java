package com.study.springmvc.dal.model.sys.user;

import com.study.springmvc.common.constant.user.UserLevel;
import com.study.springmvc.common.constant.user.UserRole;
import com.study.springmvc.dal.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 用户角色等级表
 * @author shibaomi 2017年8月27日
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class UserRoleLevelModel extends BaseModel{

	/*** 无意义主键 **/
	private Long id;
	/*** 用户id **/
	private Long userId;
	/*** 用户角色 **/
	private UserRole userRole;
	/*** 用户等级 **/
	private UserLevel userLevel;
	
	public UserRoleLevelModel(){
		
	}
	
	public UserRoleLevelModel(Long userId,UserRole userRole,UserLevel userLevel){
		this.userId=userId;
		this.userLevel=userLevel;
		this.userRole=userRole;
	}
	
}
