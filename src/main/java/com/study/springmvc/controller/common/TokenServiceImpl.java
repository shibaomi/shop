package com.study.springmvc.controller.common;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import io.jsonwebtoken.Claims;

/**
 * token操作service
 * @author shibaomi
 */
@Service
public class TokenServiceImpl implements TokenService{
	
	/**
	 * 刷新间隔，每隔10分钟刷新一下token
	 */
	private static int flushInterval=10*60*100;
	@Override
	public boolean validateToken(String token) {
		return JwtUtils.parseJWT(token)!=null;
	}
	@Override
	public String reflushToken(String oldToken) {
		Claims claims=JwtUtils.parseJWT(oldToken);
		//判断是否到刷新间隔了，到了刷新token，不到不刷新
		if(claims.getExpiration().getTime()-System.currentTimeMillis()<flushInterval){
			//判断
			return oldToken;
		}
		JSONObject jsonObject = JSONObject.parseObject(claims.getSubject());
		return JwtUtils.createJWT(jsonObject);
	}
	
}
