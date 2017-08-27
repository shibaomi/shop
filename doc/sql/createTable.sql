DROP TABLE IF EXISTS `busi_banner`;
CREATE TABLE `busi_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '无意义主键',
  `name` varchar(50) DEFAULT NULL COMMENT '轮播图名称',
  `type` varchar(20) DEFAULT NULL COMMENT '轮播图类型(首页轮播图等)',
  `banner_status` varchar(20) DEFAULT NULL COMMENT '轮播图状态',
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
  `sms_status` varchar(30) DEFAULT NULL COMMENT '短信验证状态',
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
  `user_status` varchar(20) DEFAULT NULL COMMENT '状态',
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

CREATE TABLE `busi_attribute_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `option_name` varchar(50) DEFAULT NULL COMMENT '属性选项名称',
  `option_code` varchar(30) DEFAULT NULL COMMENT '属性选项编码',
  `option_value` varchar(50) DEFAULT NULL COMMENT '属性选项的值',
  `option_desc` varchar(100) DEFAULT NULL COMMENT '属性选项描述',
  `atttibute_id` bigint(20) DEFAULT NULL COMMENT '所属属性id',
  `category_id` bigint(20) DEFAULT NULL COMMENT '所属产品类别id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性选项表';

CREATE TABLE `busi_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '无意义主键',
  `attribute_name` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `attribute_code` varchar(30) DEFAULT NULL COMMENT '属性编码',
  `attribute_type` varchar(30) DEFAULT NULL COMMENT '属性类型',
  `attrbute_desc` varchar(100) DEFAULT NULL COMMENT '属性描述',
  `category_id` bigint(20) DEFAULT NULL COMMENT '所属产品类别id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类的属性';

CREATE TABLE `busi_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '无意义主键',
  `product_name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `product_code` varchar(30) DEFAULT NULL COMMENT '产品编码',
  `summary` varchar(150) DEFAULT NULL COMMENT '产品简介',
  `product_desc` varchar(300) DEFAULT NULL COMMENT '产品详细描述',
  `product_status` varchar(30) DEFAULT NULL COMMENT '产品状态',
  `mobile_image_url` varchar(100) DEFAULT NULL COMMENT '产品app缩略图',
  `computer_image_url` varchar(100) DEFAULT NULL COMMENT '产品电脑缩略图',
  `categorys` varchar(100) DEFAULT NULL COMMENT '产品类别,已","分割，最左边是大类别的id，往右一级级类别的id',
  `brand_id` bigint(20) DEFAULT NULL COMMENT '品牌id',
  `manufacturer_id` bigint(20) DEFAULT NULL COMMENT '产品制造商id',
  `new_product` varchar(10) DEFAULT NULL COMMENT '是否新品',
  `new_product_time` int(8) DEFAULT NULL COMMENT '新品时间',
  `hot_product` varchar(10) DEFAULT NULL COMMENT '是否热门',
  `hot_product_time` int(20) DEFAULT NULL COMMENT '热门产品时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表';

CREATE TABLE `busi_product_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `option_id` bigint(20) DEFAULT NULL COMMENT '产品对应的属性选项id',
  `atttibute_id` bigint(20) DEFAULT NULL COMMENT '产品对应的属性id',
  `category_id` bigint(20) DEFAULT NULL COMMENT '所属产品类别id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品关联的分类属性表';

CREATE TABLE `busi_product_specification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `option_id` bigint(20) DEFAULT NULL COMMENT '产品对应的规格选项id',
  `specification_id` bigint(20) DEFAULT NULL COMMENT '产品对应的规格id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品关联的规格model(所有产品都有的)';

CREATE TABLE `busi_specification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `specification_name` varchar(50) DEFAULT NULL COMMENT '规格名称',
  `specification_code` varchar(30) DEFAULT NULL COMMENT '规格编码',
  `specification_desc` varchar(100) DEFAULT NULL COMMENT '规格描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品规格';

CREATE TABLE `busi_specification_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `option_name` varchar(50) DEFAULT NULL COMMENT '规格选项名称',
  `option_code` varchar(30) DEFAULT NULL COMMENT '规格选项编码',
  `option_value` varchar(50) DEFAULT NULL COMMENT '规格选项的值',
  `option_desc` varchar(100) DEFAULT NULL COMMENT '规格选项描述',
  `specification_id` bigint(20) DEFAULT NULL COMMENT '所属规格id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品规格选项';

CREATE TABLE `busi_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '无意义主键',
  `category_name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `category_code` varchar(20) DEFAULT NULL COMMENT '类别编码',
  `category_desc` varchar(100) DEFAULT NULL COMMENT '类别描述',
  `category_status` varchar(20) DEFAULT NULL COMMENT '类别状态',
  `category_level` varchar(20) DEFAULT NULL COMMENT '类别级别',
  `category_parent_id` bigint(20) DEFAULT NULL COMMENT '直接父类id',
  `parents_id` varchar(60) DEFAULT NULL COMMENT '所有父类id组合，第一个为一级父类id，第二个为二级父类id，最后一个字符串一定为","',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id_status` (`category_parent_id`,`category_status`),
  KEY `idx_parents_id_status` (`parents_id`,`category_status`),
  KEY `idx_code_status` (`category_code`,`category_status`),
  KEY `idx_name_status` (`category_name`,`category_status`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='产品类别表';

CREATE TABLE `busi_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '无意义主键',
  `brand_name` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `brand_code` varchar(30) DEFAULT NULL COMMENT '品牌编码',
  `summary` varchar(150) DEFAULT NULL COMMENT '品牌简介',
  `brand_desc` varchar(300) DEFAULT NULL COMMENT '品牌描述',
  `brand_status` varchar(10) DEFAULT NULL COMMENT '品牌状态',
  `logo_image_url` varchar(100) DEFAULT NULL COMMENT '品牌logo图片地址',
  `company_id` bigint(20) DEFAULT NULL COMMENT '品牌所属公司id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品品牌';

CREATE TABLE `sys_user_role_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '无意义主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `user_level` varchar(30) DEFAULT NULL COMMENT '用户等级',
  `user_role` varchar(30) DEFAULT NULL COMMENT '用户角色',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色信息表';



