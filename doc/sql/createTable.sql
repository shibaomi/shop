DROP TABLE IF EXISTS `busi_banner`;
CREATE TABLE `busi_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '无意义主键',
  `name` varchar(50) DEFAULT NULL COMMENT '轮播图名称',
  `type` varchar(20) DEFAULT NULL COMMENT '轮播图类型(首页轮播图等)',
  `state` varchar(20) DEFAULT NULL COMMENT '轮播图状态',
  `channel` varchar(30) DEFAULT NULL COMMENT '轮播图对应的渠道(如iso、Android、电脑web、手机web等)',
  `image_url` varchar(150) DEFAULT NULL COMMENT '轮播图对应的图片url',
  `value_type` varchar(20) DEFAULT NULL COMMENT '值类型，如外部链接、内部链接、弹出框、无需操作等',
  `value` varchar(100) DEFAULT NULL COMMENT '轮播图对应的值（如页面跳转值等信息）',
  `remark` varchar(200) DEFAULT NULL COMMENT '轮播图详情描述',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='轮播图表';

-- ----------------------------
-- Table structure for sys_sequence
-- ----------------------------
DROP TABLE IF EXISTS `sys_sequence`;
CREATE TABLE `sys_sequence` (
  `sequence_code` varchar(50) NOT NULL COMMENT '自定义序列编码',
  `value` bigint(20) DEFAULT NULL COMMENT '序列值',
  PRIMARY KEY (`sequence_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自定义序列表';

-- ----------------------------
-- Table structure for sys_sms_flow
-- ----------------------------
DROP TABLE IF EXISTS `sys_sms_flow`;
CREATE TABLE `sys_sms_flow` (
  `flow_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '默认短信流水，无意义主键',
  `mobile` bigint(11) DEFAULT NULL COMMENT '短信接收手机号',
  `sms_type` varchar(30) DEFAULT NULL COMMENT '短信发送应用类型',
  `certi_type` varchar(50) DEFAULT NULL COMMENT '证件类型',
  `certi_no` varchar(30) DEFAULT NULL COMMENT '证件号',
  `verify_code` varchar(12) DEFAULT NULL COMMENT '短信验证码',
  `origin_biz_no` varchar(30) DEFAULT NULL COMMENT '关联业务流水',
  `state` varchar(30) DEFAULT NULL COMMENT '短信验证状态',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`flow_no`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '无意义主键',
  `user_no` varchar(20) DEFAULT NULL COMMENT '用户编号',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `certi_type` varchar(50) DEFAULT NULL COMMENT '证件类型',
  `certi_no` varchar(30) DEFAULT NULL COMMENT '证件号码',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `phone` varchar(13) DEFAULT NULL COMMENT '固话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `addr` varchar(300) DEFAULT NULL COMMENT '地址',
  `state` varchar(20) DEFAULT NULL COMMENT '状态',
  `pwd_login` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `university_id` bigint(20) DEFAULT NULL COMMENT '大学id',
  `university_name` varchar(50) DEFAULT NULL COMMENT '大学名称',
  `degree` varchar(10) DEFAULT NULL COMMENT '学历',
  `country_code` varchar(10) DEFAULT NULL COMMENT '国家编码',
  `country_name` varchar(50) DEFAULT NULL COMMENT '所属国家',
  `province_code` varchar(10) DEFAULT NULL COMMENT '所在省或直辖市编码',
  `province_name` varchar(50) DEFAULT NULL COMMENT '所在省或直辖市名称',
  `city_code` varchar(10) DEFAULT NULL COMMENT '所属市编码',
  `city_name` varchar(40) DEFAULT NULL COMMENT '所属市',
  `county_area_code` varchar(10) DEFAULT NULL COMMENT '所属县/区编码',
  `county_area_name` varchar(40) DEFAULT NULL COMMENT '所属县/区',
  `town_street_code` varchar(10) DEFAULT NULL COMMENT '乡镇/街道编码',
  `town_street_name` varchar(50) DEFAULT NULL COMMENT '乡镇/街道',
  `village_road_code` varchar(10) DEFAULT NULL COMMENT '村庄/路编号',
  `village_road_name` varchar(40) DEFAULT NULL COMMENT '村庄/路',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人名称',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_NICK_NAME` (`nick_name`),
  UNIQUE KEY `INDEX_MOBILE` (`mobile`),
  UNIQUE KEY `INDEX_CERTI` (`certi_type`,`certi_no`),
  UNIQUE KEY `INDEX_USER_NO` (`user_no`) USING BTREE,
  KEY `INDEX_REAL_NAME` (`real_name`),
  KEY `INDEX_EMAIL` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
