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

 Date: 12/01/2021 00:26:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
BEGIN;
INSERT INTO `tbl_user` VALUES ('666666', '组件', '123456', '4567', '2020-11-13 00:19:41', '234', '2020-11-13 00:19:53');
INSERT INTO `tbl_user` VALUES ('888888', '小明waz', '123456', '234', '2020-11-13 00:17:31', '666666', '2020-12-14 00:00:00');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
