package com.study.springmvc.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * dao层的实现类自动化
 * @author 史保密 2017年8月25日
 */
public class DaoImplGenerateTest {
	
	//拷贝文件，并替换包地址和类名
	public static void copyDaoDirctoryToServiceDirctory(String srcPath,String destPath,String destPackagePath) {
		File daoFile=new File(srcPath);
		if(daoFile.isDirectory()) {
			int i=0;
			File[]daoInterface =daoFile.listFiles();
			for(File f:daoInterface ) {
				String oldFileName=f.getName();
				File copyFile=new File(destPath+oldFileName.replaceAll("Dao", "DaoImpl"));
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
	
	private static void copyDaoInterfaceFileToServiceInterfaceFile(BufferedReader in, BufferedWriter out,String destPackagePath,String oldFileName) throws IOException {
		String line=null;
		boolean isRemark=false;
		while((line=in.readLine())!=null) {
			if(line.matches("^\\s*package\\s+.+")) {
				String daoPackage=line.replace("package","").replace(";", "");
				line="package "+destPackagePath+";";
				out.write(line);
				out.newLine();
				out.newLine();
				out.write("import org.springframework.beans.factory.annotation.Autowired;");
				out.newLine();
				out.write("import org.springframework.stereotype.Repository;");
				out.newLine();
				out.write("import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;");
				out.newLine();
				out.write("import"+daoPackage+"."+oldFileName.substring(0, oldFileName.length()-5)+";");
			}else if(line.matches("^\\s*public\\s+interface\\s+.+")) {
				out.write("@Repository");
				out.newLine();
				String javaName=oldFileName.replace("Dao", "DaoImpl");
				line="public class " + javaName.substring(0, javaName.length()-5)+" implements " + oldFileName.substring(0, oldFileName.length()-5)+" {";
				out.write(line);
				out.newLine();
				out.newLine();
				out.write("\t@Autowired");
				out.newLine();
				out.write("\tprivate BaseDao_Mybatis baseDao;");
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
				out.write(methodGenerate(line,oldFileName));
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
	
	private static String methodGenerate(String line,String fileName) {
		String sch=fileName.replace("Dao", "Mapper");
		if(line.indexOf("insert")>-1) {
			return "\t\treturn baseDao.insert(\""+sch.substring(0, sch.length()-5)+".insert\", record);";
		}else if(line.indexOf("selectByPrimaryKey")>-1) {
			return "\t\treturn baseDao.selectOne(\""+sch.substring(0, sch.length()-5)+".selectByPrimaryKey\", id);";
		}else if(line.indexOf("updateByPrimaryKeySelective")>-1) {
			return "\t\treturn baseDao.update(\""+sch.substring(0, sch.length()-5)+".updateByPrimaryKeySelective\", record);";
		}else if(line.indexOf("updateByPrimaryKey")>-1) {
			return "\t\treturn baseDao.update(\""+sch.substring(0, sch.length()-5)+".updateByPrimaryKey\", record);";
		}
		return "";
	}
	
	public static void main(String[] args) {
		String s="/**";
		System.out.println(s.matches("^\\s*/\\*\\*.*"));
		System.out.println(s.matches("^\\s*/\\*\\*"));
	}
}
