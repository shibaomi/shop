package com.study.springmvc.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GeneralDaoTest {
	public static void main(String[] args) {
		copyDaoToService();
	}
	
	public static void copyDaoToService() {
		String projectPath=new File("").getAbsolutePath();
		String daoPath=projectPath+"/src/main/java/com/study/springmvc/dal/faces/busi/product";
		String servicePath=projectPath+"/src/main/java/com/study/springmvc/service/faces/busi/product/";
		String destPackagePath="com.study.springmvc.service.faces.busi.product";
		copyDaoDirctoryToServiceDirctory(daoPath,servicePath,destPackagePath);
	}
	
	//拷贝文件，并替换包地址和类名
	public static void copyDaoDirctoryToServiceDirctory(String srcPath,String destPath,String destPackagePath) {
		File daoFile=new File(srcPath);
		if(daoFile.isDirectory()) {
			int i=0;
			File[]daoInterface =daoFile.listFiles();
			for(File f:daoInterface ) {
				String oldFileName=f.getName();
				File copyFile=new File(destPath+oldFileName.replaceAll("Dao", "Service"));
				try {
					if(copyFile.exists()) {
						continue;
					}
					BufferedReader in=new BufferedReader(new  FileReader(f));
					BufferedWriter out=new BufferedWriter(new FileWriter(copyFile));
					copyDaoInterfaceFileToServiceInterfaceFile(in,out,destPackagePath,f.getName());
					in.close();
					out.close();
					i++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("总共copy的文件："+i);
		}else {
			System.out.println("路径错误:"+srcPath);
		}
	}
	
	public static void copyDaoInterfaceFileToServiceInterfaceFile(BufferedReader in, BufferedWriter out,String destPackagePath,String oldFileName) throws IOException {
		String line=null;
		while((line=in.readLine())!=null) {
			if(line.matches("^\\s*package\\s+.+")) {
				line="package "+destPackagePath+";";
			}else if(line.matches("^\\s*public\\s+interface\\s+.+")) {
				String javaName=oldFileName.replace("Dao", "Service");
				line="public interface " + javaName.substring(0, javaName.length()-5)+" {";
			}else if(line.matches(".*dao层.*")) {
				line=line.replaceAll("dao层", "service层");
			}
			out.write(line);
			out.newLine();
		}
		out.flush();
	}
}
