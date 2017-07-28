package com.study.springmvc.controller.common;

/**
 * token操作service
 * @author shibaomi
 */
public interface TokenService {
	
	/**
	 * 验证token是否超时，是否被篡改
	 * token正确且未超时，返回true，否则返回false
	 * @param token
	 */
	boolean validateToken(String token);
	
	/**
	 * 刷新老的token，返回新token，若老token需要重新生成则返回新的token，否则返回原token
	 * @param oldToken
	 */
	String reflushToken(String oldToken);
}
