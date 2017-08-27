package com.study.springmvc.controller.sys.third;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.common.qiniuyun.QiNiuYunUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 管理七牛云权限结果
 * @author 史保密
 */
@Api(description="七牛云管理接口",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@Controller
@RequestMapping(value = "sys/image")
public class QiniuYunController {
	
	/***
	 * 获取七牛云上传token
	 */
	@ApiOperation(value = "获取七牛云上传token") 
	@RequestMapping(value = "/upload_token",method=RequestMethod.GET)
	@ResponseBody
	public String getUploadToken() {
		return QiNiuYunUtils.getToken();
	}
	
}
