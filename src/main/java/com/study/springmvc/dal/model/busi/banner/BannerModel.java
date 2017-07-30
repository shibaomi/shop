package com.study.springmvc.dal.model.busi.banner;

import com.study.springmvc.common.constant.banner.BannerType;
import com.study.springmvc.common.constant.banner.BannerValueType;
import com.study.springmvc.common.constant.common.ChannelType;
import com.study.springmvc.common.constant.common.CommonState;
import com.study.springmvc.controller.command.busi.banner.BannerCommand;
import com.study.springmvc.dal.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 轮播图映射类
 * @author shibaomi
 */
@ApiModel(description="轮播图映射类")
@EqualsAndHashCode(callSuper=false)
@Data
public class BannerModel extends BaseModel{
	/*** 无意义主键 **/
	@ApiModelProperty(value = "无意义主键 ",example="1")
	private Long id;
	/*** 轮播图名称 **/
	@ApiModelProperty(value = "轮播图名称",example="双十一活动")
	private String name;
	/*** 轮播图类型(首页轮播图等) **/
	@ApiModelProperty(value = "轮播图类型(首页轮播图等)",example="HOME_BANNER")
	private BannerType type;
	/*** 轮播图状态  **/
	@ApiModelProperty(value = "轮播图状态 ",example="ENABLED")
	private CommonState state;
	/*** 轮播图对应的渠道(如iso、Android、电脑web、手机web等)**/
	@ApiModelProperty(value = "轮播图对应的渠道(如iso、Android、电脑web、手机web等)",example="IOS_APP")
	private ChannelType channel;
	/*** 轮播图地址 **/
	@ApiModelProperty(value = "轮播图图片地址",example="/banner/test.jpg")
	private String imageUrl;
	/*** 轮播图对应的值类型（如外部链接，内部链接等） **/
	@ApiModelProperty(value = " 轮播图对应的值类型（如外部链接，内部链接等）",example="INNER_LINK")
	private BannerValueType valueType;
	/*** 轮播图对应的值（如页面跳转值等信息） **/
	@ApiModelProperty(value = "轮播图对应的值（如页面跳转值等信息）",example="https://www.baidu.com")
	private String value;
	/*** 轮播图详细描述 **/
	@ApiModelProperty(value = "轮播图详细描述",example="双十一活动轮播图")
	private String remark;
	
	public BannerModel(){
		
	}
	
	public BannerModel(BannerCommand banner){
		if(banner!=null){
			this.channel=banner.getChannel();
			this.id=banner.getId();
			this.imageUrl=banner.getImageUrl();
			this.name=banner.getName();
			this.remark=banner.getRemark();
			this.type=banner.getType();
			this.value=banner.getValue();
			this.valueType=banner.getValueType();
		}
	}
}
