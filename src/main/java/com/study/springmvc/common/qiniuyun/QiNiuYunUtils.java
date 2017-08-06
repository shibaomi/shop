package com.study.springmvc.common.qiniuyun;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.qiniu.util.Auth;
import com.study.springmvc.common.utils.EnvironmentUtils;

/**
 * 七牛云utils
 * @author shibaomi
 */
public class QiNiuYunUtils {
	
	private static Properties pro;
	
	static{
		try {
			initProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initProperties() throws IOException{
		ClassLoader cl = QiNiuYunUtils.class.getClassLoader();
		String filePath="META-INF/spring/properties/qiniuyun_"+EnvironmentUtils.env+".properties";
		InputStream fileStream=cl.getResourceAsStream(filePath);
		pro= new Properties();
		try {
			pro.load(fileStream);
		} finally {
			fileStream.close();
		}
	}
	
	/**
	 * 获取上传token
	 * @return
	 */
	public static String getToken(){
		String accessKey = pro.getProperty("qiniuyun.ak");
		String secretKey = pro.getProperty("qiniuyun.sk");
		String bucket = pro.getProperty("qiniuyun.bucket");
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		return upToken;
	}
}
