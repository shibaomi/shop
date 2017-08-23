package com.study.springmvc.dao;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;

public class GeneralDaoTest {
	public static void main(String[] args) {
		String projectPath=new File("").getAbsolutePath();
		String daoPath="/src/main/java/com/study/springmvc/dal/faces/busi/product";
		String servicePath="/src/main/java/com/study/springmvc/service/faces/busi/product/";
		File daoFile=new File(projectPath+daoPath);
		if(daoFile.isDirectory()) {
			int i=0;
			File[]daoInterface =daoFile.listFiles();
			for(File f:daoInterface ) {
				String oldFileName=f.getName();
				File out=new File(projectPath+servicePath+oldFileName.replaceAll("Dao", "Service"));
				try {
					if(out.exists()) {
						continue;
					}
					FileCopyUtils.copy(f, out);
					i++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println(i);
		}else {
			System.out.println("路径错误");
		}
	}
}
