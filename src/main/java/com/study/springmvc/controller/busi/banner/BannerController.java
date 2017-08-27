package com.study.springmvc.controller.busi.banner;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.common.constant.banner.BannerType;
import com.study.springmvc.common.constant.common.ChannelType;
import com.study.springmvc.common.constant.common.CommonStatus;
import com.study.springmvc.controller.command.IdCommand;
import com.study.springmvc.controller.command.busi.banner.BannerCommand;
import com.study.springmvc.dal.model.busi.banner.BannerModel;
import com.study.springmvc.service.faces.busi.banner.BannerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="轮播图管理接口",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@Controller
@RequestMapping(value = "banners")
public class BannerController {
	
	@Autowired
	private BannerService bannerService;
	
	/***
	 * 新增轮播图
	 */
	@ApiOperation(value = "新增轮播图") 
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public Long addBanner(@RequestBody @Valid BannerCommand command) {
		return bannerService.saveBanner(command);
	}
	
	/***
	 * 更新轮播图
	 */
	@ApiOperation(value = "更新轮播图") 
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public void updateBanner(@RequestBody @Valid BannerCommand command) {
		bannerService.updateBanner(command);
	}
	
	/***
	 * 删除轮播图
	 */
	@ApiOperation(value = "删除轮播图") 
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public void deleteBanner(@RequestBody @Valid IdCommand id) {
		bannerService.deleteBanner(id.getId());
	}
	
	/***
	 * 获取轮播图列表
	 */
	@ApiOperation(value = "获取轮播图列表") 
	@RequestMapping(value = "/",method=RequestMethod.GET)
	@ResponseBody
	public List<BannerModel> queryBanners(@ApiParam(value = "轮播图类型") @RequestParam(required=false)BannerType type,
			@ApiParam(value = "轮播图状态") @RequestParam(required=false)CommonStatus status,
			@ApiParam(value = "请求轮播图渠道类型") @RequestParam(required=false) ChannelType channel,
			@RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit
			) {
		return bannerService.queryBannerModel(type, status, channel, offset, limit);
	}
}
