package com.study.springmvc.controller.command.busi.banner;

import javax.validation.constraints.NotNull;

import com.study.springmvc.common.constant.banner.BannerType;
import com.study.springmvc.common.constant.banner.BannerValueType;
import com.study.springmvc.common.constant.common.ChannelType;
import com.study.springmvc.common.selfannotation.Scope;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 轮播图更新新建发送请求model
 * @author shibaomi
 */
@ApiModel(description="轮播图新增更新发送请求model")
@Data
public class BannerCommand{
	/*** 无意义主键 **/
	@ApiModelProperty(value = "无意义主键 ",example="1")
	private Long id;
	/*** 轮播图名称 **/
	@ApiModelProperty(value = "轮播图名称",required=true,example="双十一活动")
	@NotNull(message="轮播图名称必传")
	private String name;
	/*** 轮播图类型(首页轮播图等) **/
	@ApiModelProperty(value = "轮播图类型(首页轮播图等)",required=true,example="HOME_BANNER",
			allowableValues="HOME_BANNER")
	@NotNull(message="轮播图类型必传")
	@Scope(value={"HOME_BANNER"},message="轮播图类型不在指定范围内")
	private BannerType type;
	/*** 轮播图对应的渠道(如iso、Android、电脑web、手机web等)**/
	@ApiModelProperty(value = "轮播图对应的渠道(如iso、Android、电脑web、手机web等)",required=true,example="IOS_APP",
			allowableValues="IOS_APP,ANDROID_APP,IOS_WEB,ANDROID_WEB,COMPUTER_WEB")
	@NotNull(message="轮播图对应的渠道必传")
	@Scope(value={"IOS_APP","ANDROID_APP","IOS_WEB","ANDROID_WEB","COMPUTER_WEB"},message="轮播图对应的渠道不在指定范围内")
	private ChannelType channel;
	/*** 轮播图地址 **/
	@ApiModelProperty(value = "轮播图图片地址",required=true,example="/banner/test.jpg")
	@NotNull(message="轮播图图片地址必传")
	private String imageUrl;
	/*** 轮播图对应的值类型（如外部链接，内部链接等） **/
	@ApiModelProperty(value = " 轮播图对应的值类型（如外部链接，内部链接等）",required=true,example="INNER_LINK",
			allowableValues="NONE,INNER_LINK,EXTERNAL_LINK")
	@NotNull(message="轮播图对应的值类型必传")
	@Scope(value={"NONE","INNER_LINK","EXTERNAL_LINK"},message="轮播图对应的值类型不在指定范围内")
	private BannerValueType valueType;
	/*** 轮播图对应的值（如页面跳转值等信息） **/
	@ApiModelProperty(value = "轮播图对应的值（如页面跳转值等信息）",example="https://www.baidu.com")
	private String value;
	/*** 轮播图详细描述 **/
	@ApiModelProperty(value = "轮播图详细描述",example="双十一活动轮播图")
	private String remark;
}
