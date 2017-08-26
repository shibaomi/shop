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
		String servicePath=projectPath+"/src/main/java/com/study/springmvc/service/faces/busi/product";
		String serviceImplPath=projectPath+"/src/main/java/com/study/springmvc/service/impl/busi/product/";
		String destPackagePath="com.study.springmvc.service.impl.busi.product";
		String daoInterfacePath="com.study.springmvc.dal.faces.busi.product";
		ServiceImplGenerateTest.copyServiceInterfaceToImplDirctory(servicePath, 
				serviceImplPath, destPackagePath,daoInterfacePath);
	}
	
	public static void daoImplGenerate() {
		String projectPath=new File("").getAbsolutePath();
		String daoPath=projectPath+"/src/main/java/com/study/springmvc/dal/faces/busi/product";
		String daoImplPath=projectPath+"/src/main/java/com/study/springmvc/dal/impl/busi/product/";
		String destPackagePath="com.study.springmvc.dal.impl.busi.product";
		DaoImplGenerateTest.copyDaoInterfaceToImplDirctory(daoPath, daoImplPath, destPackagePath);
	}
	
	public static void copyDaoToService() {
		String projectPath=new File("").getAbsolutePath();
		String daoPath=projectPath+"/src/main/java/com/study/springmvc/dal/faces/busi/product";
		String servicePath=projectPath+"/src/main/java/com/study/springmvc/service/faces/busi/product/";
		String destPackagePath="com.study.springmvc.service.faces.busi.product";
		DaoInterfaceCopyTest.copyDaoDirctoryToServiceDirctory(daoPath,servicePath,destPackagePath);
	}
}
