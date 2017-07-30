package com.study.springmvc.dal.faces.busi.banner;

import java.util.List;

import com.study.springmvc.common.constant.banner.BannerType;
import com.study.springmvc.common.constant.common.ChannelType;
import com.study.springmvc.common.constant.common.CommonState;
import com.study.springmvc.dal.model.busi.banner.BannerModel;

/**
 * 轮播图操作dao层
 * @author shibaomi
 */
public interface BannerDao {
	
	/**
	 * 保存轮播图
	 * @param banner
	 */
	int saveBanner(BannerModel banner);
	
	/**
	 * 更新轮播图
	 * @param banner
	 */
	int updateBanner(BannerModel banner);
	
	/**
	 * 更新轮播图状态
	 * @param banner
	 */
	int updateBannerState(Long id,CommonState state);
	
	/**
	 * 根据id查询轮播图
	 * @param id
	 */
	BannerModel queryBannerModel(Long id);
	
	/**
	 * 根据轮播图类型、轮播图状态、渠道类型查询轮播图
	 * 其中offset和limit传值则分页查询，否则查所有
	 * @param type:轮播图类型，可传可不传
	 * @param state：轮播图状态，可传可不传
	 * @param channel：轮播图渠道类型，可传可不传
	 */
	List<BannerModel> queryBannerModel(BannerType type,CommonState state,ChannelType channel,Integer offset,Integer limit);
}
