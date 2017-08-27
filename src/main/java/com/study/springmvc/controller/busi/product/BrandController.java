package com.study.springmvc.controller.busi.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.common.constant.banner.BannerType;
import com.study.springmvc.common.constant.common.ChannelType;
import com.study.springmvc.common.constant.common.CommonStatus;
import com.study.springmvc.common.utils.Page;
import com.study.springmvc.controller.command.busi.product.BrandCommand;
import com.study.springmvc.dal.model.busi.banner.BannerModel;
import com.study.springmvc.dal.model.busi.product.BrandModel;
import com.study.springmvc.service.faces.busi.product.BrandService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="品牌管理接口",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@Controller
@RequestMapping(value = "brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	/***
	 * 新增品牌信息
	 */
	@ApiOperation(value = "新增品牌信息") 
	@RequestMapping(value = "/",method=RequestMethod.POST)
	@ResponseBody
	public Long addBrand(@RequestBody @Valid BrandCommand command) {
		return brandService.insert(command);
	}
	
	/***
	 * 根据id查询品牌信息
	 */
	@ApiOperation(value = "根据id查询品牌信息") 
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	@ResponseBody
	public BrandModel get(@PathVariable("id") Long id) {
		return brandService.selectByPrimaryKey(id);
	}
	
	/***
	 * 更新品牌信息
	 */
	@ApiOperation(value = "更新品牌信息") 
	@RequestMapping(value = "/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Long updateBrand(@PathVariable("id") Long id,@RequestBody @Valid BrandCommand command) {
		command.setId(id);
		return brandService.updateByPrimaryKeySelective(command);
	}
	
	/***
	 * 删除品牌信息
	 */
	@ApiOperation(value = "删除品牌信息") 
	@RequestMapping(value = "/{id}/delete",method=RequestMethod.POST)
	@ResponseBody
	public void deleteBrand(@PathVariable("id") Long id) {
		brandService.deleteByPrimaryKey(id);
	}
	
	/***
	 * 获取品牌信息列表
	 */
	@ApiOperation(value = "获取品牌信息列表") 
	@RequestMapping(value = "/",method=RequestMethod.GET)
	@ResponseBody
	public List<BrandModel> queryBrands(@ApiParam(value = "品牌名称") @RequestParam(required=false)String brandName,
			@ApiParam(value = "品牌编码") @RequestParam(required=false)String brandCode,
			@ApiParam(value = "品牌状态") @RequestParam(required=false) CommonStatus status,
			@RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit
			) {
		return null;
	}

}
