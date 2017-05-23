package com.study.springmvc.dal.model.common;

import lombok.Data;

/**
 * 地址信息
 * @author shibaomi
 */
@Data
public class Address {
	/*** 所属国家编号 **/
	private String countryCode;
	/*** 所属国家名称 **/
	private String countryName;
	/*** 所在省或直辖市编号 **/
	private String provinceCode;
	/*** 所在省或直辖市名称 **/
	private String provinceName;
	/*** 所属市编号 **/
	private String cityCode;
	/*** 所属市名称 **/
	private String cityName;
	/*** 所属县/区编号 **/
	private String countyAreaCode;
	/*** 所属县/区名称 **/
	private String countyAreaName;
	/*** 乡镇/街道编号 **/
	private String townStreetCode;
	/*** 乡镇/街道名称 **/
	private String townStreetName;
	/*** 村庄/路编号 **/
	private String villageRoadCode;
	/*** 村庄/路名称 **/
	private String villageRoadName;
}
