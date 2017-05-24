package com.study.springmvc.controller.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2 java配置方法，xml配置见servlet-context.xml中配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
//    	List<ResponseMessage> customResps=new ArrayList<ResponseMessage>();
//    	customResps.add(new ResponseMessageBuilder()
//        		  	.code(500)
//        		  	.message("500 error")
//        		  	.responseModel(new ModelRef("Error")).build()
//        		  );
//    	customResps.add(new ResponseMessageBuilder()
//    		  	.code(403)
//    		  	.message("403")
//    		  	.responseModel(new ModelRef("Error")).build()
//    		  );
        		  
        return new Docket(DocumentationType.SWAGGER_2)  //文档类型，swagger版本，有swagger1和swagger2        		
          .select()//select返回ApiSelectorBuilder的一个实例，对通过swagger暴露的端点进行细粒度的控制。                              
          .apis(RequestHandlerSelectors.basePackage("com.study.springmvc.controller"))//swagger暴露aip 包过滤 ,只暴露指定的包接口
          .paths(PathSelectors.ant("/**")) //swagger暴露aip url过滤  ，只显示满足指定情况的url请求
          .build().apiInfo(apiInfo())//配置自定义api信息       
//          .pathMapping("/")//路径映射
//          .directModelSubstitute(LocalDate.class,String.class)//渲染值映射，localDate映射为string
//          .useDefaultResponseMessages(false)//标识是否采用默认响应配置，false不采用默认响应设置
//          .globalResponseMessage(RequestMethod.GET, customResps)//设置自定义响应设置（只自定义get响应请求）
          ;                                    
    }
    private ApiInfo apiInfo() {
//    	String title="商店 API 接口";//
//    	String description="按模块提供接口，可测试";
//    	String version="1.0.0";
//    	String termsOfServiceUrl="项目服务url";
//    	Contact contact=new Contact("shibm","https://github.com/shibaomi/shop","shibm890130@163.com");
//		String license="暂无许可号";
//		String licenseUrl="暂无许可号地址";
//		Collection<VendorExtension> vendorExtensions=null;//扩展字段
//    	return new ApiInfo(title, description, version, termsOfServiceUrl, contact,
//    			license, licenseUrl,new ArrayList());
    	return new ApiInfoBuilder()
                .title("商店 API 接口")
                .description("按模块提供接口，可测试")
                .termsOfServiceUrl("https://github.com/shibaomi/shop")
                .contact(new Contact("shibm", "https://github.com/shibaomi/shop", "shibm890130@163.com"))
                .license("暂无许可号")
                .licenseUrl("暂无许可号地址")
                .version("1.0.0")
                .build();
    }
}