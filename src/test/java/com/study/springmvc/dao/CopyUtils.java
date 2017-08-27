package com.study.springmvc.dao;

import java.io.File;

public class CopyUtils {
	public static void main(String[] args) {
		daoImplGenerate();
		copyDaoToService();
		serviceImplGenerate();
	}
	
	public static void serviceImplGenerate() {
		String projectPath=new File("").getAbsolutePath();
		String servicePath=projectPath+"/src/main/java/com/study/springmvc/service/faces/sys";
		String serviceImplPath=projectPath+"/src/main/java/com/study/springmvc/service/impl/sys/";
		String destPackagePath="com.study.springmvc.service.impl.sys";
		String daoInterfacePath="com.study.springmvc.dal.facessys";
		ServiceImplGenerateTest.copyServiceInterfaceToImplDirctory(servicePath, 
				serviceImplPath, destPackagePath,daoInterfacePath);
	}
	
	public static void daoImplGenerate() {
		String projectPath=new File("").getAbsolutePath();
		String daoPath=projectPath+"/src/main/java/com/study/springmvc/dal/faces/sys";
		String daoImplPath=projectPath+"/src/main/java/com/study/springmvc/dal/impl/sys/";
		String destPackagePath="com.study.springmvc.dal.impl.sys";
		DaoImplGenerateTest.copyDaoInterfaceToImplDirctory(daoPath, daoImplPath, destPackagePath);
	}
	
	public static void copyDaoToService() {
		String projectPath=new File("").getAbsolutePath();
		String daoPath=projectPath+"/src/main/java/com/study/springmvc/dal/faces/sys";
		String servicePath=projectPath+"/src/main/java/com/study/springmvc/service/faces/sys/";
		String destPackagePath="com.study.springmvc.service.faces.sys";
		DaoInterfaceCopyTest.copyDaoDirctoryToServiceDirctory(daoPath,servicePath,destPackagePath);
	}
}
