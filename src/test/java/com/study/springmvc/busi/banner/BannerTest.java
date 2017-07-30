package com.study.springmvc.busi.banner;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.study.springmvc.base.BaseTest;
import com.study.springmvc.common.constant.banner.BannerType;
import com.study.springmvc.common.constant.banner.BannerValueType;
import com.study.springmvc.common.constant.common.ChannelType;
import com.study.springmvc.common.constant.common.CommonState;
import com.study.springmvc.controller.command.busi.banner.BannerCommand;
import com.study.springmvc.dal.model.busi.banner.BannerModel;
import com.study.springmvc.service.faces.busi.banner.BannerService;

public class BannerTest extends BaseTest{
	
	@Autowired
	private BannerService bannerService;
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSaveSmsInfo() {
		BannerCommand command=new BannerCommand();
		command.setChannel(ChannelType.ANDROID_APP);
		command.setImageUrl("dd");
		command.setName("测试轮播图");
		command.setRemark("测试使用");
		command.setValue("dd");;
		command.setType(BannerType.HOME_BANNER);
		command.setValueType(BannerValueType.INNER_LINK);
		Long id=bannerService.saveBanner(command);
		assertNotNull(id);
		List<BannerModel> banners=bannerService.queryBannerModel(BannerType.HOME_BANNER, 
				CommonState.ENABLED, ChannelType.ANDROID_APP, 0, 10);
		assertNotNull(banners);
		
		command.setName("更新操作");
		command.setId(id);
		bannerService.updateBanner(command);
		bannerService.deleteBanner(id);
	}
}
