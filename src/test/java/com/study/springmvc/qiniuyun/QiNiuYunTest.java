package com.study.springmvc.qiniuyun;

import com.qiniu.util.Auth;

public class QiNiuYunTest {
	public static void main(String[] args) {
		String accessKey = "11gNdL98IIS_42sjZ0sdDHJUxagIGIGtoIGHDG1Q";
		String secretKey = "HE9RFr1F_k2C8HiGlSrsUExAinY";
		String bucket = "shibm890130";
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		System.out.println(upToken);
	}
}
