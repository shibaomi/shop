package com.study.springmvc.dal.faces.sys;

import com.study.springmvc.dal.model.sys.user.UserRoleLevelModel;

/**
 * 用户角色级别维护信息
 * @author shibaomi 2017年8月27日
 */
public interface UserRoleLevelDao {
    /**
     * 新增用户角色级别信息
     */
    int insert(UserRoleLevelModel record);

    /**
     * 根据id查用户角色级别信息
     */
    UserRoleLevelModel selectByPrimaryKey(Long id);

    /**
     * 有选择性的更新用户角色级别信息
     */
    int updateByPrimaryKeySelective(UserRoleLevelModel record);

    /**
     * 更新用户的角色级别信息
     */
    int updateByPrimaryKey(UserRoleLevelModel record);
}