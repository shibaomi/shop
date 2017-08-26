package com.study.springmvc.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 拷贝dao层的interface到service的interface
 * @author 史保密 2017年8月25日
 */
public class DaoInterfaceCopyTest {
	
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
			System.out.println("Service层interface总共copy的文件："+i);
		}else {
			System.out.println("路径错误:"+srcPath);
		}
	}
	
	private static void copyDaoInterfaceFileToServiceInterfaceFile(BufferedReader in, BufferedWriter out,String destPackagePath,String oldFileName) throws IOException {
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
