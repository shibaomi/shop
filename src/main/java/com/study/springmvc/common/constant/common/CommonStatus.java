package com.study.springmvc.common.constant.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用状态
 * @author shibaomi
 *
 */
public enum CommonStatus {
	/**
	 * 不可用
	 */
	DISABLED,
	/**
	 * 可用
	 */
	ENABLED,
	/**
	 * 删除
	 */
	DETELE;
	
	public static List<CommonStatus> getNoDeteleStatus(){
		List<CommonStatus> status=new ArrayList<CommonStatus>();
		status.add(DISABLED);
		status.add(ENABLED);
		return  status;
	}
}
