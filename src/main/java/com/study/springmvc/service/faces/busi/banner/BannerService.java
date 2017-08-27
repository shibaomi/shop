package com.study.springmvc.service.faces.busi.banner;

import java.util.List;

import com.study.springmvc.common.constant.banner.BannerType;
import com.study.springmvc.common.constant.common.ChannelType;
import com.study.springmvc.common.constant.common.CommonStatus;
import com.study.springmvc.controller.command.busi.banner.BannerCommand;
import com.study.springmvc.dal.model.busi.banner.BannerModel;

/***
 * 轮播图管理服务
 * @author shibaomi
 */
public interface BannerService {
	/**
	 * 保存轮播图
	 * @param banner
	 */
	Long saveBanner(BannerCommand command);
	
	/**
	 * 更新轮播图
	 * @param banner
	 */
	int updateBanner(BannerCommand command);
	
	/**
	 * 删除轮播图状态
	 * @param banner
	 */
	int deleteBanner(Long id);
	
	/**
	 * 根据轮播图类型、轮播图状态、渠道类型查询轮播图
	 * 其中offset和limit传值则分页查询，否则查所有
	 * @param type:轮播图类型，可传可不传
	 * @param status：轮播图状态，可传可不传
	 * @param channel：轮播图渠道类型，可传可不传
	 */
	List<BannerModel> queryBannerModel(BannerType type,CommonStatus status,ChannelType channel,Integer offset,Integer limit);
}
