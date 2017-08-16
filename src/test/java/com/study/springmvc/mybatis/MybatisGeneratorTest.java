package com.study.springmvc.mybatis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisGeneratorTest {
	public static void main(String[] args){
		try {
			String path=MybatisGeneratorTest.class.getResource(".").getPath();
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			File configFile = new File(path+"MybatisGeneratorConfig.xml");
			System.out.println(configFile.getAbsolutePath());
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			Context context=config.getContexts().get(0);
			context.getJavaModelGeneratorConfiguration().setTargetProject(
					new File("").getAbsolutePath()+"/src/test/java"+
					context.getJavaModelGeneratorConfiguration().getTargetProject());
			context.getJavaClientGeneratorConfiguration().setTargetProject(
					new File("").getAbsolutePath()+"/src/test/java"+
					context.getJavaClientGeneratorConfiguration().getTargetProject());
			context.getSqlMapGeneratorConfiguration().setTargetProject(
					new File("").getAbsolutePath()+"/src/test/java"+
					context.getSqlMapGeneratorConfiguration().getTargetProject());
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			ProgressCallback progressCallback = new VerboseProgressCallback();
			myBatisGenerator.generate(progressCallback);
			for (String warning : warnings) {
	            System.out.println(warning);
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
