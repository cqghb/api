/*
 Navicat Premium Data Transfer

 Source Server         : 测试连接
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : api

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 11/07/2021 01:37:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_code_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_code_type`;
CREATE TABLE `tbl_code_type` (
  `code_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '码类型',
  `code_type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '码类型中文',
  `create_user` varchar(6) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`code_type`) USING BTREE,
  KEY `code_type` (`code_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='码值类型表';

-- ----------------------------
-- Records of tbl_code_type
-- ----------------------------
BEGIN;
INSERT INTO `tbl_code_type` VALUES ('education', '学历', '2', '2021-04-29 13:26:16', NULL, NULL);
INSERT INTO `tbl_code_type` VALUES ('likes', '喜好', '2', '2021-04-29 12:50:32', NULL, NULL);
INSERT INTO `tbl_code_type` VALUES ('sex', '性别', '2', '2021-05-13 22:31:08', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_code_value
-- ----------------------------
DROP TABLE IF EXISTS `tbl_code_value`;
CREATE TABLE `tbl_code_value` (
  `code_type` varchar(50) NOT NULL COMMENT '码类型',
  `code` varchar(50) NOT NULL COMMENT '码',
  `code_name` varchar(50) NOT NULL COMMENT '中文',
  `index` int(11) DEFAULT NULL COMMENT '序号',
  `create_user` varchar(6) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`code_type`,`code`,`code_name`),
  CONSTRAINT `fk_code_value_ct` FOREIGN KEY (`code_type`) REFERENCES `tbl_code_type` (`code_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='码值表';

-- ----------------------------
-- Records of tbl_code_value
-- ----------------------------
BEGIN;
INSERT INTO `tbl_code_value` VALUES ('education', '1', '小学', 1, '2', '2021-04-29 13:26:37', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '2', '中学', 2, '2', '2021-04-29 13:29:02', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '3', '高中', 3, '2', '2021-04-29 13:29:05', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '4', '专科', 4, '2', '2021-04-29 13:29:09', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '5', '本科', 5, '2', '2021-04-29 13:29:12', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '6', '研究生', 6, '2', '2021-04-29 13:29:15', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '7', '博士', 7, '2', '2021-04-29 13:29:18', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '8', '其它', 8, '2', '2021-04-29 13:29:22', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('likes', '1', '唱歌', 1, '2', '2021-04-29 13:14:49', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('likes', '2', '打篮球', 2, '2', '2021-04-29 13:15:10', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('likes', '3', '游泳', 3, '2', '2021-04-29 13:15:31', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('sex', '1', '男', 1, '2', '2021-05-13 22:32:17', NULL, NULL);
INSERT INTO `tbl_code_value` VALUES ('sex', '2', '女', 2, '2', '2021-05-13 22:32:37', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_menu`;
CREATE TABLE `tbl_menu` (
  `id` varchar(32) NOT NULL COMMENT '菜单主键',
  `name` varchar(20) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `parent_node` varchar(32) DEFAULT NULL COMMENT '父节点ID',
  `default_select` varchar(4) DEFAULT NULL COMMENT '是否默认选中1:是;0:否 只有根节点才能设置这个属性',
  `uri` varchar(50) DEFAULT NULL COMMENT '请求地址',
  `create_user` varchar(6) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of tbl_menu
-- ----------------------------
BEGIN;
INSERT INTO `tbl_menu` VALUES ('1', '用户管理', 'el-icon-menu', '0', '1', '/a', '666666', '2020-11-07 09:02:18', NULL, NULL);
INSERT INTO `tbl_menu` VALUES ('2', '菜单管理', 'el-icon-message', '0', '1', '/b', '666666', '2020-11-07 09:03:25', NULL, NULL);
INSERT INTO `tbl_menu` VALUES ('3', 'API接口管理', 'el-icon-setting', '0', '0', '/c', '666666', '2020-11-07 09:04:49', NULL, NULL);
INSERT INTO `tbl_menu` VALUES ('4', '用户列表查询', NULL, '1', '0', '/userList', '666666', '2020-11-07 09:05:33', NULL, NULL);
INSERT INTO `tbl_menu` VALUES ('5', '菜单列表查询', NULL, '2', '0', '/e', '666666', '2020-11-07 09:06:13', NULL, NULL);
INSERT INTO `tbl_menu` VALUES ('6', '二级菜单', 'el-icon-setting', '1', NULL, '/w', '666666', '2020-11-10 00:38:11', NULL, NULL);
INSERT INTO `tbl_menu` VALUES ('7', '三级菜单', NULL, '6', NULL, '/c', '666666', '2020-11-10 00:38:52', NULL, NULL);
INSERT INTO `tbl_menu` VALUES ('8', '三级菜单-1', 'el-icon-setting', '6', NULL, NULL, '666666', '2020-11-10 01:23:23', NULL, NULL);
INSERT INTO `tbl_menu` VALUES ('9', '4-1', NULL, '8', NULL, '/y', '666666', '2020-11-10 01:23:19', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_property
-- ----------------------------
DROP TABLE IF EXISTS `tbl_property`;
CREATE TABLE `tbl_property` (
  `id` varchar(255) NOT NULL COMMENT '属性ID',
  `name` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `type_id` varchar(255) DEFAULT NULL COMMENT '分类ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性表';

-- ----------------------------
-- Records of tbl_property
-- ----------------------------
BEGIN;
INSERT INTO `tbl_property` VALUES ('1', '手机颜色', '1');
INSERT INTO `tbl_property` VALUES ('2', '手机容量', '1');
INSERT INTO `tbl_property` VALUES ('3', '腊肉重量', '3');
INSERT INTO `tbl_property` VALUES ('4', '手机屏幕尺寸', '1');
INSERT INTO `tbl_property` VALUES ('5', '电脑机盖颜色', '2');
INSERT INTO `tbl_property` VALUES ('6', '电脑硬盘容量', '2');
INSERT INTO `tbl_property` VALUES ('7', '电脑运行内存', '2');
INSERT INTO `tbl_property` VALUES ('8', '腊肉已存放时间', '3');
COMMIT;

-- ----------------------------
-- Table structure for tbl_property_options
-- ----------------------------
DROP TABLE IF EXISTS `tbl_property_options`;
CREATE TABLE `tbl_property_options` (
  `id` varchar(255) NOT NULL COMMENT '属性选项ID',
  `value` varchar(50) DEFAULT NULL COMMENT '选项值',
  `attr_id` varchar(255) DEFAULT NULL COMMENT '属性ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性选项表';

-- ----------------------------
-- Records of tbl_property_options
-- ----------------------------
BEGIN;
INSERT INTO `tbl_property_options` VALUES ('1', '黑色', '1');
INSERT INTO `tbl_property_options` VALUES ('10', '16G', '2');
INSERT INTO `tbl_property_options` VALUES ('11', '32', '2');
INSERT INTO `tbl_property_options` VALUES ('12', '1KG', '3');
INSERT INTO `tbl_property_options` VALUES ('13', '2KG', '3');
INSERT INTO `tbl_property_options` VALUES ('14', '0.5KG', '3');
INSERT INTO `tbl_property_options` VALUES ('15', '5.5寸', '4');
INSERT INTO `tbl_property_options` VALUES ('16', '6寸', '4');
INSERT INTO `tbl_property_options` VALUES ('17', '8个月', '8');
INSERT INTO `tbl_property_options` VALUES ('18', '1年', '8');
INSERT INTO `tbl_property_options` VALUES ('2', '白色', '1');
INSERT INTO `tbl_property_options` VALUES ('3', '玫瑰金', '1');
INSERT INTO `tbl_property_options` VALUES ('4', '灰色', '1');
INSERT INTO `tbl_property_options` VALUES ('5', '深灰', '1');
INSERT INTO `tbl_property_options` VALUES ('6', '1G', '2');
INSERT INTO `tbl_property_options` VALUES ('7', '2G', '2');
INSERT INTO `tbl_property_options` VALUES ('8', '4G', '2');
INSERT INTO `tbl_property_options` VALUES ('9', '8G', '2');
COMMIT;

-- ----------------------------
-- Table structure for tbl_sku
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sku`;
CREATE TABLE `tbl_sku` (
  `id` varchar(255) NOT NULL COMMENT 'SKU产品ID',
  `name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `code` varchar(50) DEFAULT NULL COMMENT '产品编码',
  `price` decimal(10,2) DEFAULT NULL COMMENT '产品价格',
  `spu_id` varchar(255) DEFAULT NULL COMMENT 'SPU货品ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SKU产品表';

-- ----------------------------
-- Records of tbl_sku
-- ----------------------------
BEGIN;
INSERT INTO `tbl_sku` VALUES ('1', '黑色128G电信版苹果12', 'phone_12_11', 5894.00, '1');
INSERT INTO `tbl_sku` VALUES ('2', '蓝色500G华为Mate11', 'mate11', 1000.00, '1');
INSERT INTO `tbl_sku` VALUES ('3', '卫华1代电脑', 'HUAWEI_1', 5000.00, '2');
INSERT INTO `tbl_sku` VALUES ('4', '华为2代电脑', 'HUAWEI_2', 60000.00, '2');
INSERT INTO `tbl_sku` VALUES ('5', '烟熏肉1', 'yxr1', 100.00, '3');
INSERT INTO `tbl_sku` VALUES ('6', '风干猪肉1', 'fgzr1', 150.00, '3');
COMMIT;

-- ----------------------------
-- Table structure for tbl_sku_property_option
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sku_property_option`;
CREATE TABLE `tbl_sku_property_option` (
  `id` varchar(255) NOT NULL COMMENT 'SKU-属性选项关联ID',
  `sku_id` varchar(255) DEFAULT NULL COMMENT 'SKU ID',
  `pro_opt_id` varchar(255) DEFAULT NULL COMMENT '属性选项ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SKU-属性选项关联表';

-- ----------------------------
-- Records of tbl_sku_property_option
-- ----------------------------
BEGIN;
INSERT INTO `tbl_sku_property_option` VALUES ('1', '1', '1');
INSERT INTO `tbl_sku_property_option` VALUES ('10', '1', '10');
INSERT INTO `tbl_sku_property_option` VALUES ('2', '1', '2');
INSERT INTO `tbl_sku_property_option` VALUES ('3', '1', '3');
INSERT INTO `tbl_sku_property_option` VALUES ('4', '1', '4');
INSERT INTO `tbl_sku_property_option` VALUES ('5', '1', '5');
INSERT INTO `tbl_sku_property_option` VALUES ('6', '1', '6');
INSERT INTO `tbl_sku_property_option` VALUES ('7', '1', '7');
INSERT INTO `tbl_sku_property_option` VALUES ('8', '1', '8');
INSERT INTO `tbl_sku_property_option` VALUES ('9', '1', '9');
COMMIT;

-- ----------------------------
-- Table structure for tbl_sku_specification_option
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sku_specification_option`;
CREATE TABLE `tbl_sku_specification_option` (
  `id` varchar(255) NOT NULL COMMENT 'ID',
  `sku_id` varchar(255) DEFAULT NULL COMMENT 'SKU ID',
  `spec_opti_id` varchar(255) DEFAULT NULL COMMENT '规格选项ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SKU-规格选项关联表';

-- ----------------------------
-- Records of tbl_sku_specification_option
-- ----------------------------
BEGIN;
INSERT INTO `tbl_sku_specification_option` VALUES ('1', '1', '1');
INSERT INTO `tbl_sku_specification_option` VALUES ('2', '1', '2');
INSERT INTO `tbl_sku_specification_option` VALUES ('3', '1', '3');
INSERT INTO `tbl_sku_specification_option` VALUES ('4', '1', '4');
INSERT INTO `tbl_sku_specification_option` VALUES ('5', '1', '5');
INSERT INTO `tbl_sku_specification_option` VALUES ('6', '1', '6');
INSERT INTO `tbl_sku_specification_option` VALUES ('7', '1', '7');
COMMIT;

-- ----------------------------
-- Table structure for tbl_specification
-- ----------------------------
DROP TABLE IF EXISTS `tbl_specification`;
CREATE TABLE `tbl_specification` (
  `id` varchar(255) NOT NULL COMMENT '规格ID',
  `name` varchar(50) DEFAULT NULL COMMENT '参数名称',
  `group_id` varchar(255) DEFAULT NULL COMMENT '规格组ID',
  `type_id` varchar(255) DEFAULT NULL COMMENT '分类ID',
  `addr` varchar(50) DEFAULT NULL COMMENT '显示位置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规格表';

-- ----------------------------
-- Records of tbl_specification
-- ----------------------------
BEGIN;
INSERT INTO `tbl_specification` VALUES ('1', '品牌', '1', '1', '1');
INSERT INTO `tbl_specification` VALUES ('2', '型号', '1', '1', '2');
INSERT INTO `tbl_specification` VALUES ('3', '颜色', '1', '1', '3');
INSERT INTO `tbl_specification` VALUES ('4', '4G网络制式', '2', '1', '4');
INSERT INTO `tbl_specification` VALUES ('5', '5G网络制式', '2', '1', '5');
INSERT INTO `tbl_specification` VALUES ('6', '机身内存', '3', '1', '6');
INSERT INTO `tbl_specification` VALUES ('7', '存储卡内省', '3', '1', '7');
COMMIT;

-- ----------------------------
-- Table structure for tbl_specification_group
-- ----------------------------
DROP TABLE IF EXISTS `tbl_specification_group`;
CREATE TABLE `tbl_specification_group` (
  `id` varchar(255) NOT NULL COMMENT '规格组ID',
  `name` varchar(50) DEFAULT NULL COMMENT '规格组名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规格组表';

-- ----------------------------
-- Records of tbl_specification_group
-- ----------------------------
BEGIN;
INSERT INTO `tbl_specification_group` VALUES ('1', '主体');
INSERT INTO `tbl_specification_group` VALUES ('2', '网络');
INSERT INTO `tbl_specification_group` VALUES ('3', '存储');
COMMIT;

-- ----------------------------
-- Table structure for tbl_specification_option
-- ----------------------------
DROP TABLE IF EXISTS `tbl_specification_option`;
CREATE TABLE `tbl_specification_option` (
  `id` varchar(255) NOT NULL COMMENT '规格选项ID',
  `value` varchar(100) DEFAULT NULL COMMENT '选项值',
  `spec_id` varchar(255) DEFAULT NULL COMMENT '规格ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规格选项表';

-- ----------------------------
-- Records of tbl_specification_option
-- ----------------------------
BEGIN;
INSERT INTO `tbl_specification_option` VALUES ('1', '苹果', '1');
INSERT INTO `tbl_specification_option` VALUES ('2', '爱疯6plus', '2');
INSERT INTO `tbl_specification_option` VALUES ('3', '灰色', '3');
INSERT INTO `tbl_specification_option` VALUES ('4', '移动联通4G', '4');
INSERT INTO `tbl_specification_option` VALUES ('5', '联通5G', '5');
INSERT INTO `tbl_specification_option` VALUES ('6', '8G', '6');
INSERT INTO `tbl_specification_option` VALUES ('7', '32G', '7');
COMMIT;

-- ----------------------------
-- Table structure for tbl_spu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_spu`;
CREATE TABLE `tbl_spu` (
  `id` varchar(255) NOT NULL COMMENT '货品ID',
  `name` varchar(255) DEFAULT NULL COMMENT '货品名称',
  `code` varchar(255) DEFAULT NULL COMMENT '货品编码',
  `brief_introduction` varchar(255) DEFAULT NULL COMMENT '货品简介',
  `detail` varchar(255) DEFAULT NULL COMMENT '货品详情',
  `type_id` varchar(255) DEFAULT NULL COMMENT '分类ID',
  `brand_id` varchar(255) DEFAULT NULL COMMENT '品牌ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SPU货品表';

-- ----------------------------
-- Records of tbl_spu
-- ----------------------------
BEGIN;
INSERT INTO `tbl_spu` VALUES ('1', '手机', 'shouji', '这是好用的手机', '这是手机的详细信息说明', '1', '1');
INSERT INTO `tbl_spu` VALUES ('2', '电脑', 'diannao_01', '这电脑好用', '打电脑', '2', '2');
INSERT INTO `tbl_spu` VALUES ('3', '烟熏肉', 'yznxurou_01', '超级好吃的烟熏肉', '这是5年老腊肉，做法多多', '3', '3');
COMMIT;

-- ----------------------------
-- Table structure for tbl_spu_brand
-- ----------------------------
DROP TABLE IF EXISTS `tbl_spu_brand`;
CREATE TABLE `tbl_spu_brand` (
  `id` varchar(255) NOT NULL COMMENT '品牌ID',
  `name` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `code` varchar(50) DEFAULT NULL COMMENT '品牌编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货品品牌表';

-- ----------------------------
-- Records of tbl_spu_brand
-- ----------------------------
BEGIN;
INSERT INTO `tbl_spu_brand` VALUES ('1', '苹果', 'Apple');
INSERT INTO `tbl_spu_brand` VALUES ('2', '华为', 'HUAWEI');
INSERT INTO `tbl_spu_brand` VALUES ('3', '哈哈', 'haha');
COMMIT;

-- ----------------------------
-- Table structure for tbl_spu_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_spu_type`;
CREATE TABLE `tbl_spu_type` (
  `id` varchar(255) NOT NULL COMMENT '货品类型ID',
  `name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `code` varchar(50) DEFAULT NULL COMMENT '类型编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货品类型表';

-- ----------------------------
-- Records of tbl_spu_type
-- ----------------------------
BEGIN;
INSERT INTO `tbl_spu_type` VALUES ('1', '手机', 'spu_shouji');
INSERT INTO `tbl_spu_type` VALUES ('2', '电脑', 'spu_diannao');
INSERT INTO `tbl_spu_type` VALUES ('3', '腊肉', 'spu_larou');
COMMIT;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` varchar(6) NOT NULL COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `pass` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `create_user` varchar(6) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改人',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `qq` varchar(30) DEFAULT NULL COMMENT 'qq号',
  `we_chat` varchar(50) DEFAULT NULL COMMENT '微信号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `education` varchar(4) DEFAULT NULL COMMENT '学历',
  `head_portrait_url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
BEGIN;
INSERT INTO `tbl_user` VALUES ('107768', '1', '1', '666666', '2021-05-18 00:35:06', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('112619', '45', '45', '666666', '2021-05-29 00:56:10', NULL, '2021-06-17 01:32:11', 1, '2', NULL, '34', 'e', NULL, NULL, '/Users/wangsheng/headPortrai/出租车3.jpeg');
INSERT INTO `tbl_user` VALUES ('117621', NULL, NULL, '666666', '2021-05-29 02:17:23', NULL, NULL, 1, '2', NULL, '1', '1', '1', '8', '/Users/wangsheng/headPortrai/117621-/AADA0184464D47889193F82F6B610D9B..jpeg.jpeg');
INSERT INTO `tbl_user` VALUES ('130469', '小张', '123333', '666666', '2021-05-18 00:33:02', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('150259', '666', '66', '666666', '2021-06-02 13:22:08', NULL, NULL, 3, '2', NULL, '6', '6', '6', '8', '/Users/wangsheng/headPortrai/150259_BBE0F53B47534BA2A083F93AFE7B140A.jpeg');
INSERT INTO `tbl_user` VALUES ('162240', '34', '34', '666666', '2021-05-29 02:23:36', NULL, NULL, 1, '2', NULL, NULL, NULL, NULL, NULL, '/Users/wangsheng/headPortrai/162240-16AB06159C2643F78F2B8FE12011BBA4.jpeg');
INSERT INTO `tbl_user` VALUES ('162420', 'wangsheng5', '666666', NULL, '2021-07-08 01:08:58', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL);
INSERT INTO `tbl_user` VALUES ('172492', '2', '123456', '666666', '2021-05-27 00:39:53', NULL, NULL, 1, '1', NULL, '2', '2', '2', '3', NULL);
INSERT INTO `tbl_user` VALUES ('182454', '王健林', '111111', '666666', '2021-05-17 23:40:04', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('188148', 'wangsheng2', '666666', NULL, '2021-07-08 01:04:39', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL);
INSERT INTO `tbl_user` VALUES ('2', '张杰', '111111', '666666', '2021-04-26 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('239525', '1', '666666', NULL, '2021-07-08 01:37:48', NULL, NULL, 1, '2', NULL, '1', '1', '1', '1', '/Users/wangsheng/headPortrai/239525_32EA60CD43A6443DAAD9AA863D7CC562.jpeg');
INSERT INTO `tbl_user` VALUES ('252190', '小明', '111111', '666666', '2021-05-18 00:31:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('320992', NULL, NULL, '666666', '2021-06-27 01:15:30', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('325522', 'liming', '123456', '666666', '2021-06-27 11:35:24', NULL, NULL, 1, '2', NULL, '1', '1', '1', '5', NULL);
INSERT INTO `tbl_user` VALUES ('337172', 'zhangjie', '123456', '666666', '2021-06-27 11:29:17', NULL, NULL, 9, '2', NULL, '1', '1', '1', '7', '/Users/wangsheng/headPortrai/337172_D52F292B18DF4AE197C3C673A7FA8EA8.jpeg');
INSERT INTO `tbl_user` VALUES ('343146', '34', '34', '666666', '2021-05-29 02:19:50', NULL, NULL, 1, '2', NULL, NULL, NULL, NULL, NULL, '/Users/wangsheng/headPortrai/343146-9891F842CE5B4C08B5070AE99692B221.jpeg.jpeg');
INSERT INTO `tbl_user` VALUES ('346266', NULL, NULL, '666666', '2021-06-27 01:22:13', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, '/Users/wangsheng/headPortrai/346266_92BBAB8148484D668A2F95C6CF6B76CC.jpeg');
INSERT INTO `tbl_user` VALUES ('390175', '3232', '666666', NULL, '2021-07-08 01:12:09', NULL, NULL, 1, '2', NULL, '1', '1', '1', '8', NULL);
INSERT INTO `tbl_user` VALUES ('395823', '晓东', '333333', '666666', '2021-05-18 00:34:02', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('450977', '33', '33', '666666', '2021-05-27 00:47:32', NULL, NULL, 3, '2', NULL, '33', '333', '33', '6', '/Users/wangsheng/headPortrai/出租1.jpeg');
INSERT INTO `tbl_user` VALUES ('523964', 'er', 'df', '666666', '2021-05-29 00:46:19', NULL, NULL, 3, '2', NULL, 'e', 'd', '1', '6', NULL);
INSERT INTO `tbl_user` VALUES ('528107', 'wangsheng1', '666666', NULL, '2021-07-08 01:01:57', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL);
INSERT INTO `tbl_user` VALUES ('540861', 'wangsheng4', '666666', NULL, '2021-07-08 01:06:57', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL);
INSERT INTO `tbl_user` VALUES ('600928', NULL, NULL, '666666', '2021-06-27 01:14:18', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('611520', '刘备', '666666', NULL, '2021-07-11 00:30:31', NULL, NULL, 100, '1', NULL, '1', '1', '1@qq.com', '3', '/Users/wangsheng/headPortrai/611520_8445589F53884233AB67312F4A5861BE.jpeg');
INSERT INTO `tbl_user` VALUES ('613426', 'wangsheng3', '666666', NULL, '2021-07-08 01:05:41', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL);
INSERT INTO `tbl_user` VALUES ('625288', '1', '1', '666666', '2021-05-18 00:36:26', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('630163', 'wangsheng5', '666666', NULL, '2021-07-08 01:08:37', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL);
INSERT INTO `tbl_user` VALUES ('666666', '组件', '123456', '4567', '2020-11-13 00:19:41', '234', '2021-07-11 00:29:41', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('705089', '88888', '88888888', '666666', '2021-06-02 01:33:49', NULL, NULL, 8, '2', NULL, '88', '88', '88', '5', '/Users/wangsheng/headPortrai/705089_6C51DC7856F642739ABD791983E6B836.jpg');
INSERT INTO `tbl_user` VALUES ('722762', '刘备', '666666', NULL, '2021-07-11 00:31:10', NULL, NULL, 100, '1', NULL, '1', '1', '1@qq.com', '1', '/Users/wangsheng/headPortrai/722762_21EE6E5EDB534EE2967B05C5E7036C30.jpeg');
INSERT INTO `tbl_user` VALUES ('739813', '小明', '111111', '666666', '2021-05-18 00:27:01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('755849', 'wwww', 'wwww', '666666', '2021-06-02 00:36:57', NULL, NULL, 3, '2', NULL, 'www', 'www', 'ww', '5', '/Users/wangsheng/headPortrai/755849_12F35D59D6F043EFBCC58117C0649DB3.jpg');
INSERT INTO `tbl_user` VALUES ('775217', '王麻子', '666666', '666666', '2021-06-29 00:49:56', NULL, NULL, 1, '2', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('781488', '2', '2', '666666', '2021-05-18 00:41:44', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('794722', NULL, NULL, '666666', '2021-05-29 02:17:38', NULL, NULL, 1, '2', NULL, '1', '1', '1', '8', '/Users/wangsheng/headPortrai/794722-9F999EEFFBD84E6F85B0C30B9FFEB2C0..jpeg.jpeg');
INSERT INTO `tbl_user` VALUES ('794783', '3444', '444', '666666', '2021-06-02 13:21:12', NULL, NULL, 5, '2', NULL, '44', '44', '44', '2', '/Users/wangsheng/headPortrai/794783_123E2C64E8D844AC830052E4A8E2C3ED.jpeg');
INSERT INTO `tbl_user` VALUES ('805061', '12', '666666', NULL, '2021-07-08 01:35:58', NULL, NULL, 1, '2', NULL, '1', '1', '1', '3', '/Users/wangsheng/headPortrai/805061_659FFCDF819B4443A9092031BED9DCF9.jpeg');
INSERT INTO `tbl_user` VALUES ('818917', 'as', '34', '666666', '2021-05-29 00:52:44', NULL, NULL, 3, '2', NULL, '23', '34', '34', '4', NULL);
INSERT INTO `tbl_user` VALUES ('888888', '小明waz', '123456', '234', '2020-11-13 00:17:31', '666666', '2020-12-14 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('919798', 'hhh', '666666', NULL, '2021-07-08 01:10:14', NULL, NULL, 1, '2', NULL, 'q', 'q', 'q', '1', NULL);
INSERT INTO `tbl_user` VALUES ('926854', NULL, NULL, '666666', '2021-06-27 01:18:01', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('973852', 'as', 'we', '666666', '2021-05-29 00:47:52', NULL, NULL, 3, '2', NULL, 'we', 'we', 'we', '5', NULL);
INSERT INTO `tbl_user` VALUES ('974738', '12', '12', '666666', '2021-05-27 00:42:26', NULL, NULL, 11, '2', NULL, '12', '21', '21', '7', NULL);
INSERT INTO `tbl_user` VALUES ('980812', '王校长', '111111', '666666', '2021-05-17 23:14:15', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('981191', '王健林', '111111', '666666', '2021-05-17 23:40:11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user` VALUES ('993443', '1', '1', '666666', '2021-05-27 00:37:01', NULL, NULL, 3, '1', NULL, '1', '1', '1', '8', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_user_likes
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_likes`;
CREATE TABLE `tbl_user_likes` (
  `id` varchar(32) NOT NULL COMMENT '爱好主键',
  `title_code` varchar(4) DEFAULT NULL COMMENT '爱好代码',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户主键',
  `create_user` varchar(6) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户喜好表';

-- ----------------------------
-- Records of tbl_user_likes
-- ----------------------------
BEGIN;
INSERT INTO `tbl_user_likes` VALUES ('0B3EFD7333EA43CC848E146FA17E7139', '1', '182454', '182454', '2021-05-17 23:40:04', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('0C46140BCD944BA99E49EC03F71E2D22', '2', '337172', '337172', '2021-06-27 11:29:17', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('0EB11F56B7BE48CFBFF8F616AF9AAC1D', '2', '722762', '722762', '2021-07-11 00:31:10', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('1', '1', '2', NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('137338D9A0E04AB1B786EB4528726D36', '1', '980812', '980812', '2021-05-17 23:14:25', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('14E49EDBC2EC442D94B915A224A65323', '3', '337172', '337172', '2021-06-27 11:29:17', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('2', '2', '2', NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('21B21082D4AE453D95CAFF5A2A46B84E', '1', '172492', '172492', '2021-05-27 00:39:53', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('237AE4761D9A4609B06F9141A220D88F', '2', '818917', '818917', '2021-05-29 00:52:44', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('333B95DEAD914366BFEAACC548803618', '1', '107768', '107768', '2021-05-18 00:35:06', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('3543FBE46B2F436A977E672E2C2DF2C9', '2', '611520', '611520', '2021-07-11 00:30:31', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('35C897155EC343628DB0E799B68709EF', '1', '739813', '739813', '2021-05-18 00:27:01', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('3A89F9B085134AC1833AD9C6A156A398', '3', '973852', '973852', '2021-05-29 00:47:52', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('3C439427FC9F41DE9A60633F40FDA89F', '1', '722762', '722762', '2021-07-11 00:31:10', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('3D0C640923CE44ADB71007C4FDB72D81', '1', '625288', '625288', '2021-05-18 00:36:26', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('426E2651437742D78AE57039A8936DE6', '1', '630163', '630163', '2021-07-08 01:08:40', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('42A29292075542198B24B10DAFA3BBCD', '3', '705089', '705089', '2021-06-02 01:33:49', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('443D68A3AC1B480FA510C11AAF076407', '1', '395823', '395823', '2021-05-18 00:34:02', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('4A9A64BA83154D82A5440D0F5F5C7792', '3', '523964', '523964', '2021-05-29 00:46:19', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('4D49D793D5164F4293B898E462A2B2BB', '1', '993443', '993443', '2021-05-27 00:37:01', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('5434CB12DD6E4595A0F5DE5B57B81E22', '2', '775217', '775217', '2021-06-29 00:49:56', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('60FED025D8894ACF91FEC127D59EA16C', '2', '755849', '755849', '2021-06-02 00:36:57', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('6DAF47F9FA90422E96C019F96FEB54EE', '2', '974738', '974738', '2021-05-27 00:42:26', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('6FAD2A23D6AE48B3B21F20D2C7AF481D', '3', '130469', '130469', '2021-05-18 00:33:02', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('704F64922658487F9DF25BD1F9680BE4', '2', '150259', '150259', '2021-06-02 13:22:08', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('7659FE7BF1E74C8EA5961E5A11863D0A', '2', '343146', '343146', '2021-05-29 02:19:50', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('799EE3F65E634489BCEBB014784E890B', '2', '182454', '182454', '2021-05-17 23:40:04', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('7A11F89938B147A39267567C610E1D00', '2', '980812', '980812', '2021-05-17 23:14:29', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('7D6C0937EC9440C78AE2C709DF38ECBC', '2', '794783', '794783', '2021-06-02 13:21:12', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('815F58C147A647FDB69D3D6455E3E65E', '2', '112619', '112619', '2021-05-29 00:56:10', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('8634B4792EAB47458FE7EF0AB646AC08', '3', '755849', '755849', '2021-06-02 00:36:57', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('8A5EFFCDFB084C5AA86E0B343D51FE5E', '2', '325522', '325522', '2021-06-27 11:35:24', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('8AE0A5B2BB334C3CAF624C240487F64E', '1', '162420', '162420', '2021-07-08 01:08:58', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('8D9BDA52CD9F45639425E1D568904CC1', '2', '705089', '705089', '2021-06-02 01:33:49', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('986FF42357CB4230A0E7526ADC48CE9D', '2', '981191', '981191', '2021-05-17 23:40:11', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('A0B75E33BF0A403AB9186BBB9FC565B8', '1', '981191', '981191', '2021-05-17 23:40:11', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('A4E4C49F44684896BD3C143A214E0535', '2', '239525', '239525', '2021-07-08 01:37:48', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('B3FF2861563F4241924B67BF4403687A', '2', '805061', '805061', '2021-07-08 01:35:58', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('BA98D34E31014E1D9C995D410B94AE9D', '1', '390175', '390175', '2021-07-08 01:12:09', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('BAEB1780518840CB9CFEBA5FCEE9EDFE', '2', '252190', '252190', '2021-05-18 00:31:17', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('BC36ED204DBB4EDF8D4453A6C2FD1D9E', '2', '162240', '162240', '2021-05-29 02:23:36', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('C7D6A1511401486D9217BA5EA07F2531', '3', '980812', '980812', '2021-05-17 23:14:31', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('E153DCD367BA46E99B64D479CE8D387E', '1', '611520', '611520', '2021-07-11 00:30:31', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('EBF961CB72964F66BB1419A10B2024D2', '3', '395823', '395823', '2021-05-18 00:34:02', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('ED7DF717C037442681E3850566DF50E2', '2', '117621', '117621', '2021-05-29 02:17:23', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('EFBEB51D0D7F463C8B232333C06D5382', '1', '781488', '781488', '2021-05-18 00:41:44', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('F73525F30E33487295F171BECB3D581C', '2', '450977', '450977', '2021-05-27 00:47:32', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('FAA43215F81946A2ADA24C9B1340D0B4', '2', '794722', '794722', '2021-05-29 02:17:38', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('FB6426DCB18A454AB0327929F87749C7', '1', '755849', '755849', '2021-06-02 00:36:57', NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
