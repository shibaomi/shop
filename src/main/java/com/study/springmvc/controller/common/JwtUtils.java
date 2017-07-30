package com.study.springmvc.controller.common;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.study.springmvc.common.constant.common.CertificateType;
import com.study.springmvc.dal.model.sys.user.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
	
	private static Logger log=LoggerFactory.getLogger(JwtUtils.class);
	private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	
	private static String apiKeySecretBytes="testKey";
	
	private static String audience="shibm890130@163.com";
	
	private static int tokenTimeOut=30*60*1000;
	
	public static Claims parseJWT(String token) {
		if(StringUtils.isEmpty(token)){
			log.warn("jwt 签名解析错误！token 为空或为null：【{}】",token);
			return null;
		}
		try{
			Claims claims = Jwts.parser()
					.setSigningKey(apiKeySecretBytes.getBytes())
					.parseClaimsJws(token)
					.getBody();
			return claims;
		}catch(Exception ex){
			log.warn("jwt 签名解析错误！",ex);
			return null;
		}
	}

	/**
	 * 生成jwt token
	 */
	public static String createJWT(UserModel user) {
		long nowTimes=System.currentTimeMillis();
		// 生成签名密钥 就是一个base64加密后的字符串？
		Key signingKey = new SecretKeySpec(apiKeySecretBytes.getBytes(), signatureAlgorithm.getJcaName());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", user.getId());
		jsonObject.put("un", user.getUserNo());
		jsonObject.put("cn", user.getCertiNo());
		jsonObject.put("ct", user.getCertiType());
		jsonObject.put("e", user.getEmail());
		jsonObject.put("m", user.getMobile());
		jsonObject.put("nn", user.getNickName());
		// 添加构成JWT的参数
		JwtBuilder builder = Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.setIssuedAt(new Date(nowTimes)) // 创建时间
				.setSubject(jsonObject.toString()) //body信息
				.setIssuer(user.getId().toString()) // 发送谁
				.setAudience(audience) // 个人签名
				.signWith(signatureAlgorithm, signingKey)// 签名
				.setExpiration(new Date(nowTimes+tokenTimeOut));//添加Token过期时间
		// 生成JWT
		return builder.compact();
	}
	
	/**
	 * 生成jwt token
	 */
	public static String createJWT(JSONObject jsonObject) {
		long nowTimes=System.currentTimeMillis();
		// 生成签名密钥 就是一个base64加密后的字符串？
		Key signingKey = new SecretKeySpec(apiKeySecretBytes.getBytes(), signatureAlgorithm.getJcaName());
		// 添加构成JWT的参数
		JwtBuilder builder = Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.setIssuedAt(new Date(nowTimes)) // 创建时间
				.setSubject(jsonObject.toString()) //body信息
				.setIssuer(jsonObject.getString("id")) // 发送谁
				.setAudience(audience) // 个人签名
				.signWith(signatureAlgorithm, signingKey)// 签名
				.setExpiration(new Date(nowTimes+tokenTimeOut));//添加Token过期时间
		// 生成JWT
		return builder.compact();
	}
	
	public static void main(String[] args) {
		UserModel user=new UserModel();
		user.setId(2l);
		user.setUserNo("u0001");
		user.setNickName("test");
		user.setCertiType(CertificateType.ID);
		user.setCertiNo("110");
		user.setEmail("shib@163.com");
		user.setMobile("15201857832");
		String token =JwtUtils.createJWT(user);
		System.out.println("token="+token);
		Claims claims=JwtUtils.parseJWT(token);
		System.out.println(JSONObject.toJSONString(claims));
		String t="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1MDA5OTI4NjUsInN1YiI6IntcIm5uXCI6XCJ0ZXN0XCIsXCJjdFwiOlwiSURcIixcImVcIjpcInNoaWJAMTYzLmNvbVwiLFwidW5cIjpcInUwMDAxXCIsXCJpZFwiOjIsXCJjblwiOlwiMTEwXCIsXCJtXCI6XCIxNTIwMTg1NzgzMlwifSIsImlzcyI6IjIiLCJhdWQiOiJzaGlibTEyMzQ1NkAxNjMuY29tIiwiZXhwIjoxNTAwOTk0NjY1fQ.LJR3zk--p4WHT2D0gUMSahFr0KiKtsKRMRFZWw6jAuw";
		Claims claims1=JwtUtils.parseJWT(t);
		System.out.println(JSONObject.toJSONString(claims1));
	}
}
