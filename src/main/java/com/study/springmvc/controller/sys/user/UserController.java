package com.study.springmvc.controller.sys.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.study.springmvc.common.db.page.QueryCondition;
import com.study.springmvc.common.utils.Page;
import com.study.springmvc.dal.model.UserModel;
import com.study.springmvc.service.faces.UserService;

@Controller
@RequestMapping(value = "sys/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/***
	 * 用户信息分页查询
	 * @return
	 */
	@RequestMapping(value = "queryPageUser")
	@ResponseBody
	public Page<UserModel> queryPageUserModel(@RequestBody QueryCondition query) {
		Page<UserModel> page=userService.queryPageUserModel(query);
		return page;
	}
	
	/***
	 * 用户信息删除,根据系统参数配置的isDeleteUser决定是物理删除还是软删除
	 */
	@RequestMapping(value = "deleteUser/{userId}")
	@ResponseBody
	public void deleteUserModel(@PathVariable(required=true) Long userId) {
		userService.deleteUserById(userId);
	}
	
	/***
	 * 新增修改用户信息
	 */
	@RequestMapping(value = "saveOrUpdateUserModel")
	@ResponseBody
	public Long saveOrUpdateUserModel(@RequestBody UserModel userModel) {
		return userService.saveOrUpdateUserModel(userModel);
	}
	
}
