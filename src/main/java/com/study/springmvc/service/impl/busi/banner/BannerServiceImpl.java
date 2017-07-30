package com.study.springmvc.service.impl.busi.banner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springmvc.common.constant.banner.BannerType;
import com.study.springmvc.common.constant.common.ChannelType;
import com.study.springmvc.common.constant.common.CommonState;
import com.study.springmvc.common.exception.BusiException;
import com.study.springmvc.controller.command.busi.banner.BannerCommand;
import com.study.springmvc.dal.faces.busi.banner.BannerDao;
import com.study.springmvc.dal.model.busi.banner.BannerModel;
import com.study.springmvc.service.faces.busi.banner.BannerService;

@Service
public class BannerServiceImpl implements BannerService{
	
	private static Logger log=LoggerFactory.getLogger(BannerServiceImpl.class);
	
	@Autowired
	private BannerDao bannerDao;

	@Override
	public Long saveBanner(BannerCommand command) {
		BannerModel banner=new BannerModel(command);
		banner.setState(CommonState.ENABLED);
		bannerDao.saveBanner(banner);
		return banner.getId();
	}

	@Override
	public int updateBanner(BannerCommand command) {
		if(command.getId()==null){
			log.error("更新轮播图时id不存在");
			throw new BusiException("轮播图id不存在");
		}
		if(bannerDao.queryBannerModel(command.getId())==null){
			log.error("轮播图id={}的轮播图不存在",command.getId());
			throw new BusiException("修改的轮播图不存在");
		}
		BannerModel banner=new BannerModel(command);
		return bannerDao.updateBanner(banner);
	}

	@Override
	public List<BannerModel> queryBannerModel(BannerType type, CommonState state, ChannelType channel, Integer offset,
			Integer limit) {
		return bannerDao.queryBannerModel(type, state, channel, offset, limit);
	}

	@Override
	public int deleteBanner(Long id) {
		BannerModel banner=bannerDao.queryBannerModel(id);
		if(banner==null){
			log.error("删除轮播图出错，轮播图id={}的轮播图不存在",id);
			throw new BusiException("删除的轮播图不存在");
		}
		if(CommonState.DETELE.equals(banner.getState())){
			log.error("删除轮播图错误，轮播图id={}的轮播图已删除",id);
			throw new BusiException("轮播图已删除");
		}
		return bannerDao.updateBannerState(id, CommonState.DETELE);
	}
}
