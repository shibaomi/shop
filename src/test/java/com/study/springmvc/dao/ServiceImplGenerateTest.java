package com.study.springmvc.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.util.StringUtils;

/**
 * service层的实现类自动化
 * @author 史保密 2017年8月25日
 */
public class ServiceImplGenerateTest {
	
	//拷贝文件，并替换包地址和类名
	public static void copyServiceInterfaceToImplDirctory(String srcPath,String destPath,
			String destPackagePath,String daoInterfacePath) {
		File daoFile=new File(srcPath);
		if(daoFile.isDirectory()) {
			int i=0;
			File[]daoInterface =daoFile.listFiles();
			for(File f:daoInterface ) {
				String oldFileName=f.getName();
				File copyFile=new File(destPath+oldFileName.replaceAll("Service", "ServiceImpl"));
				try {
					if(copyFile.exists()) {
						continue;
					}
					BufferedReader in=new BufferedReader(new  FileReader(f));
					BufferedWriter out=new BufferedWriter(new FileWriter(copyFile));
					copyServiceInterfaceFileToGenerateImplFile(in,out,destPackagePath,f.getName(),daoInterfacePath);
					in.close();
					out.close();
					i++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("service层impl总共copy的文件："+i);
		}else {
			System.out.println("路径错误:"+srcPath);
		}
	}
	
	private static void copyServiceInterfaceFileToGenerateImplFile(BufferedReader in, 
			BufferedWriter out,String destPackagePath,String oldFileName,String daoInterfacePath) throws IOException {
		String line=null;
		boolean isRemark=false;
		String daoName=oldFileName.substring(0, oldFileName.length()-5).replace("Service", "Dao");
		String daoNameFirstCharToLower=daoName.substring(0, 1).toLowerCase()+ daoName.substring(1);
		while((line=in.readLine())!=null) {
			if(line.matches("^\\s*package\\s+.+")) {
				String daoPackage=line.replace("package","").replace(";", "");
				line="package "+destPackagePath+";";
				out.write(line);
				out.newLine();
				out.newLine();
				out.write("import org.springframework.beans.factory.annotation.Autowired;");
				out.newLine();
				out.write("import org.springframework.stereotype.Service;");
				out.newLine();
				out.write("import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;");
				out.newLine();
				out.write("import"+daoInterfacePath+"."+oldFileName.substring(0, oldFileName.length()-5)+";");
				out.newLine();
				String daoInterface="import"+daoPackage+"."+daoName+";";
				out.write(daoInterface);
			}else if(line.matches("^\\s*public\\s+interface\\s+.+")) {
				out.write("@Service");
				out.newLine();
				String javaName=oldFileName.replace("Service", "ServiceImpl");
				line="public class " + javaName.substring(0, javaName.length()-5)+" implements " + oldFileName.substring(0, oldFileName.length()-5)+" {";
				out.write(line);
				out.newLine();
				out.newLine();
				out.write("\t@Autowired");
				out.newLine();
				out.write("\tprivate "+daoName+" "+daoNameFirstCharToLower+";");
				out.newLine();
			}else if(line.matches("^\\s*/\\*\\*.*")){
				isRemark=true;
				continue;
			}else if(line.matches(".*\\*/$")){
				isRemark=false;
				continue;
			}else if(isRemark){
				//注释，不保存继续
				continue;
			}else if(!line.matches("^\\s*import.*")&&!StringUtils.isEmpty(line)&&!"}".equals(line)){
				line=line.trim();
				//每个方法定义
				line="\tpublic "+line.substring(0, line.length()-1)+"{";
				out.write(line);
				out.newLine();
				out.write(methodGenerate(line,daoNameFirstCharToLower));
				out.newLine();
				out.write("\t}");
				out.newLine();
			}else {
				out.write(line);
			}
			out.newLine();
		}
		out.flush();
	}
	
	private static String methodGenerate(String line,String daoNameFirstCharToLower) {
		if(line.indexOf("insert")>-1) {
			return "\t\treturn "+daoNameFirstCharToLower+".insert(record);";
		}else if(line.indexOf("selectByPrimaryKey")>-1) {
			return "\t\treturn "+daoNameFirstCharToLower+".selectOne(id);";
		}else if(line.indexOf("updateByPrimaryKeySelective")>-1) {
			return "\t\treturn "+daoNameFirstCharToLower+".update(record);";
		}else if(line.indexOf("updateByPrimaryKey")>-1) {
			return "\t\treturn "+daoNameFirstCharToLower+".update(record);";
		}
		return "";
	}
	
	public static void main(String[] args) {
		String s="/**";
		System.out.println(s.matches("^\\s*/\\*\\*.*"));
		System.out.println(s.matches("^\\s*/\\*\\*"));
	}
}
