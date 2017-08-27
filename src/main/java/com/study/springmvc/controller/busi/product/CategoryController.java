package com.study.springmvc.controller.busi.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.controller.command.busi.product.CategoryCommand;
import com.study.springmvc.service.faces.busi.product.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="品类管理接口",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequestMapping(value="category")
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@ApiOperation("新增品类")
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public Long addCategory(@Valid @RequestBody CategoryCommand command){
		
		return null;
	}
	
}
