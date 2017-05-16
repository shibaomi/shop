package com.study.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springmvc.common.constant.Constant.DictState;
import com.study.springmvc.common.db.page.QueryCondition;
import com.study.springmvc.common.exception.BusiException;
import com.study.springmvc.common.utils.Page;
import com.study.springmvc.dal.faces.UserDao;
import com.study.springmvc.dal.model.UserModel;
import com.study.springmvc.service.faces.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserModel queryUserModelById(Long id) {
		return userDao.queryUserModelById(id);
	}

	@Override
	public Long saveOrUpdateUserModel(UserModel user) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("userNo", user.getUserNo());
		map.put("certiType",user.getCertiType());
		map.put("certiNo",user.getCertiNo());
		map.put("mobile", user.getMobile());
		map.put("email",user.getEmail());
		map.put("status",DictState.DETELE.val());//非删除状态的数据字典
		map.put("id", user.getId());
		List<UserModel> existUserList=userDao.selectUserExist(map);
		//检查用户数据是否存在，存在抛出业务存在异常，否则继续
		checkUserIsExist(existUserList,user);
		//若id不存在，说明为新增,否则为修改
		if(user.getId()==null){
			userDao.saveUserModel(user);
		}else{
			UserModel checkUserModel=userDao.queryUserModelById(user.getId());
			//数据未查到
			if(checkUserModel==null){
				log.error("要更新的用户id={}的用户信息未查到",user.getId());
				throw new BusiException("用户信息不存在");
			}
			//用户已删除
			if(DictState.DETELE.val().equals(checkUserModel.getStatus())){
				log.error("用户id={}，name={}的用户已删除",user.getId(),checkUserModel.getNickName());
				throw new BusiException("用户信息已删除");
			}
			userDao.updateUserModel(user);
		}
		return user.getId();
	}
	/***
	 * 检查新增的用户是否已经存在
	 */
	private void checkUserIsExist(List<UserModel> existUserList,UserModel user){
		if(existUserList==null||existUserList.isEmpty()){
			//未查询到直接返回
			return;
		}
		for(UserModel checkUser: existUserList){
			if(user.getUserNo().equals(checkUser.getUserNo())){
				log.error("编号={}的用户已存在",checkUser.getUserNo());
				throw new BusiException("用户编号已存在");
			}else if(user.getCertiNo().equals(checkUser.getCertiNo())&&
					user.getCertiType().equals(checkUser.getCertiType())){
				log.error("证件类型={},证件号={}的用户已存在",checkUser.getCertiType(),checkUser.getCertiNo());
				throw new BusiException("证件号已注册");
			}else if(user.getMobile().equals(checkUser.getMobile())){
				log.error("手机号={}的用户已存在",checkUser.getMobile());
				throw new BusiException("手机号已注册");
			}else if(user.getEmail().equals(checkUser.getEmail())){
				log.error("邮箱={}的用户已存在",checkUser.getEmail());
				throw new BusiException("邮箱已注册");
			}
		}
	}

	@Override
	public void deleteUserById(Long id) {
		UserModel checkUserModel=userDao.queryUserModelById(id);
		//数据未查到
		if(checkUserModel==null){
			log.error("要删除的用户id={}的用户信息未查到",id);
			throw new BusiException("删除的用户信息不存在");
		}
		//用户已删除
		if(DictState.DETELE.val().equals(checkUserModel.getStatus())){
			log.error("用户id={}，name={}的用户已删除",id,checkUserModel.getNickName());
			throw new BusiException("用户信息已删除");
		}
		//操作流程为，先判断是物理删除还是软删除
		userDao.updateUserState(id,DictState.DETELE,null);
	}

	@Override
	public Page<UserModel> queryPageUserModel(QueryCondition query) {
		return userDao.queryPageUserModel(query);
	}
	
}
