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

 Date: 14/01/2022 01:07:25
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
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code_type`) USING BTREE,
  KEY `code_type` (`code_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='码值类型表';

-- ----------------------------
-- Records of tbl_code_type
-- ----------------------------
BEGIN;
INSERT INTO `tbl_code_type` VALUES ('dataOperateSubgroup', '数据操作分组', '666666', '2021-10-16 18:49:33', '666666', '2021-10-16 18:49:39', '2', NULL);
INSERT INTO `tbl_code_type` VALUES ('delTag', '是否删除', '666666', '2021-10-11 01:23:23', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_type` VALUES ('education', '学历', '2', '2021-04-29 13:26:16', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_type` VALUES ('likes', '喜好', '2', '2021-04-29 12:50:32', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_type` VALUES ('menuDefaultSelected', '菜单是否默认选中', '666666', '2021-09-07 01:11:07', '666666', '2021-09-07 01:11:17', '2', NULL);
INSERT INTO `tbl_code_type` VALUES ('sex', '性别', '2', '2021-05-13 22:31:08', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_type` VALUES ('yesOrNo', '是否', '666666', '2021-09-12 20:41:52', '666666', '2021-09-12 20:41:58', '2', NULL);
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
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code_type`,`code`,`code_name`),
  CONSTRAINT `fk_code_value_ct` FOREIGN KEY (`code_type`) REFERENCES `tbl_code_type` (`code_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='码值表';

-- ----------------------------
-- Records of tbl_code_value
-- ----------------------------
BEGIN;
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '1', '用户管理组', 1, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:52', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '10', '菜单管理组', 10, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '11', '角色菜单关系管理组', 11, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '12', '角色用户关系管理组', 12, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '13', '用户爱好管理组', 13, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '14', '产品规格分组管理组', 14, '666666', '2021-12-30 01:05:13', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '15', 'SKU商品规格管理', 15, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '16', 'SKU货品类型管理', 16, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '17', '属性管理', 17, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '18', '属性选项管理', 18, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '19', 'SKU产品属性选项关联管理', 19, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '2', '码值类型管理组', 2, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:46', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '20', 'SKU产品管理', 20, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '21', '规格选项管理', 21, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '22', 'SKU产品规格选项关联管理', 22, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '23', 'SPU货品管理', 23, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '24', 'SPU货品品牌管理', 24, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '3', '码值管理组', 3, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '4', '数据操作权限管理组', 4, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '5', '文件上传下载管理组', 5, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '6', '图标管理组', 6, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '7', '邮件发送管理组', 7, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '8', '菜单数据操作权限关系管理组', 8, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('dataOperateSubgroup', '9', '角色管理组', 9, '666666', '2021-10-16 18:50:26', '666666', '2021-10-16 18:51:38', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('delTag', '1', '删除', 1, '666666', '2021-10-11 01:24:52', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('delTag', '2', '保留', 2, '666666', '2021-10-11 01:25:12', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '1', '小学', 1, '2', '2021-04-29 13:26:37', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '2', '中学', 2, '2', '2021-04-29 13:29:02', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '3', '高中', 3, '2', '2021-04-29 13:29:05', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '4', '专科', 4, '2', '2021-04-29 13:29:09', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '5', '本科', 5, '2', '2021-04-29 13:29:12', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '6', '研究生', 6, '2', '2021-04-29 13:29:15', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '7', '博士', 7, '2', '2021-04-29 13:29:18', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('education', '8', '其它', 8, '2', '2021-04-29 13:29:22', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('likes', '1', '唱歌', 1, '2', '2021-04-29 13:14:49', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('likes', '2', '打篮球', 2, '2', '2021-04-29 13:15:10', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('likes', '3', '游泳', 3, '2', '2021-04-29 13:15:31', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('menuDefaultSelected', '1', '是', 1, '666666', '2021-09-07 01:12:26', '666666', '2021-09-07 01:12:33', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('menuDefaultSelected', '2', '否', 2, '666666', '2021-09-07 01:12:52', '666666', '2021-09-07 01:12:59', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('sex', '1', '男', 1, '2', '2021-05-13 22:32:17', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('sex', '2', '女', 2, '2', '2021-05-13 22:32:37', NULL, NULL, '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('yesOrNo', '1', '是', 1, '666666', '2021-09-12 20:42:32', '666666', '2021-09-12 20:42:39', '2', NULL);
INSERT INTO `tbl_code_value` VALUES ('yesOrNo', '2', '否', 2, '666666', '2021-09-12 20:43:26', '666666', '2021-09-12 20:43:34', '2', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_data_operate
-- ----------------------------
DROP TABLE IF EXISTS `tbl_data_operate`;
CREATE TABLE `tbl_data_operate` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '操作名称',
  `operate_addr` varchar(100) NOT NULL COMMENT '操作地址[地址要写全]',
  `create_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `subgroup` varchar(50) NOT NULL COMMENT '所属分组[有什么分组去码值表看]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据操作表';

-- ----------------------------
-- Records of tbl_data_operate
-- ----------------------------
BEGIN;
INSERT INTO `tbl_data_operate` VALUES ('00CC1DF3CBCB4E27BADC5F1432692DF8', '产品规格分组列表-查询产品规格分组', '/specificationGroup/queryById', '666666', '2021-12-31 00:55:35', '666666', '2022-01-01 23:54:25', '查询产品规格分组', '2', '14');
INSERT INTO `tbl_data_operate` VALUES ('0EDD3B07131F4182A7C166DED4F3E1A8', '退出登录', '/signOut', '666666', '2021-10-20 01:00:31', NULL, NULL, '用户管理-退出登录', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('1182B53FD2A6461C81FB9FB579FF2D01', '角色管理-逻辑删除角色', '/role/updateRoleDelTag', '666666', '2021-11-22 00:36:30', NULL, NULL, '角色删除', '2', '9');
INSERT INTO `tbl_data_operate` VALUES ('135608F3B2914EC8820CA543940ACB36', 'SPU货品类型管理-逻辑删除操作', '/spuType/updateDelTag', '666666', '2022-01-03 17:14:49', NULL, NULL, '逻辑删除操作', '2', '16');
INSERT INTO `tbl_data_operate` VALUES ('17B500D657294B0F83843C116371C7C3', '查询所有菜单，结果是树结构', '/menu/queryMenuAll', '666666', '2021-12-03 02:20:27', '666666', '2021-12-03 02:29:35', '查询所有菜单，结果是树结构', '2', '11');
INSERT INTO `tbl_data_operate` VALUES ('194E6BECB9104D7AB50BE9F407FE5C84', 'SKU商品规格列表-逻辑删除操作', '/specification/updateDelTag', '666666', '2022-01-01 23:07:03', NULL, NULL, '逻辑删除操作', '2', '15');
INSERT INTO `tbl_data_operate` VALUES ('19FEABB23BE74452B074932139B33AC8', '用户角色关系管理-左侧用户树查询', '/queryAllUser', '666666', '2021-11-22 00:28:25', '666666', '2021-11-22 00:30:30', '查询所有有效用户', '2', '12');
INSERT INTO `tbl_data_operate` VALUES ('1EE7F79AACC44895AA49A4E8ABC7C63E', '添加用户', '/insertUser', '666666', '2021-10-20 00:55:40', NULL, NULL, '用户管理-添加用户', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('24D14FD01D584AF2A4804197B46C5F16', '角色菜单关系列表-右侧菜单树查询', '/menu/queryMenu', '666666', '2021-11-22 00:14:47', NULL, NULL, NULL, '2', '11');
INSERT INTO `tbl_data_operate` VALUES ('24F587D5D49549119E1C21C6AF0F1208', '数据操作修改', '/dataOperate/updateDop', '666666', '2021-10-16 21:37:49', NULL, NULL, '数据操作权限-修改操作', '2', '4');
INSERT INTO `tbl_data_operate` VALUES ('2621B6E105924EC79ADCCE7990C3B38D', '菜单与数据操作关系配置-左侧菜单树查询', '/menu/queryMenu', '666666', '2021-11-22 00:21:39', NULL, NULL, '后管左侧菜单树', '2', '8');
INSERT INTO `tbl_data_operate` VALUES ('29DAC7A48BC941F0BD36DA71EF185892', '属性管理-维护', '/property/updateProperty', '666666', '2022-01-12 01:26:15', NULL, NULL, '维护', '2', '17');
INSERT INTO `tbl_data_operate` VALUES ('2B028C0AD50B4484893F35E0CBD77E44', '重置密码', '/resetPass', '666666', '2021-10-20 00:59:17', NULL, NULL, '用户管理-重置密码【没有登录时使用】', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('3504712A66B14BA5B725EBBF6CFC93E9', 'SPU货品类型管理-添加', '/spuType/insertSpuType', '666666', '2022-01-03 17:16:45', NULL, NULL, '添加', '2', '16');
INSERT INTO `tbl_data_operate` VALUES ('38DEA333011D48A287CF950C96052B21', '新增图标', '/icon/insertIcon', '666666', '2021-12-08 01:45:22', NULL, NULL, NULL, '2', '6');
INSERT INTO `tbl_data_operate` VALUES ('3F96044756684544B46CA8CDFFF5B9B0', '菜单与数据操作关系配置-通过菜单ID查询查询菜单原来的操作关系', '/menuDataOperateRelation/queryMenuDataOperation', '666666', '2021-11-22 00:24:53', NULL, NULL, '通过菜单ID查询查询菜单原来的操作关系', '2', '8');
INSERT INTO `tbl_data_operate` VALUES ('4762EC926DA540009E3A580AB468840F', '属性管理-逻辑删除操作', '/property/updateDelTag', '666666', '2022-01-12 01:25:02', NULL, NULL, '逻辑删除操作', '2', '17');
INSERT INTO `tbl_data_operate` VALUES ('56FCF927B08E4290B5802FD7147154D9', 'SKU商品规格列表-根据ID查询产品规格详细信息', '/specification/queryDetail', '666666', '2022-01-05 02:00:43', NULL, NULL, '根据ID查询产品规格详细信息，返回了码值对应的中文。', '2', '15');
INSERT INTO `tbl_data_operate` VALUES ('5800365147F34CD9A447DEF4C7F8C1E3', 'SKU商品规格列表-维护产品规格', '/specification/updateSpecification', '666666', '2022-01-01 23:07:41', NULL, NULL, '维护产品规格', '2', '15');
INSERT INTO `tbl_data_operate` VALUES ('59FED7AC3A1C4EEB8C6F2F32E032DC13', '产品规格分组列表-添加产品规格分组', '/specificationGroup/insertSpecificationGroup', '666666', '2021-12-31 00:15:27', NULL, NULL, '添加产品规格分组', '2', '14');
INSERT INTO `tbl_data_operate` VALUES ('60C03D0A123C4E23B78A815F154DD924', '菜单管理-菜单列表查询', '/menu/queryMenuList', '666666', '2021-11-21 01:36:24', NULL, NULL, NULL, '2', '10');
INSERT INTO `tbl_data_operate` VALUES ('61272929AB4D44B493C530C230A70336', '用户角色关系管理-更新用户角色关系', '/roleUserRelation/updateUserRoleRelation', '666666', '2021-11-22 00:33:07', NULL, NULL, '修改用户角色关系', '2', '12');
INSERT INTO `tbl_data_operate` VALUES ('62EF34AF479946119FFB4F40CA5339DC', '数据操作权限控制器-分页查询', '/dataOperate/findPage', '666666', '2021-10-09 13:25:43', '666666', '2021-10-11 01:46:14', 'sv34', '2', '4');
INSERT INTO `tbl_data_operate` VALUES ('6570E12DFA9043F0B25DF30068A86362', '产品规格分组列表-产品规格分组列表查询', '/specificationGroup/findPage', '666666', '2021-12-30 01:01:21', '666666', '2021-12-30 01:05:37', NULL, '2', '14');
INSERT INTO `tbl_data_operate` VALUES ('6EA30662BC3C499BA88ADF38F515BDF8', 'SKU商品规格列表-分页查询产品规格', '/specification/findPage', '666666', '2022-01-01 22:57:34', '666666', '2022-01-01 23:03:52', '分页查询产品规格', '2', '15');
INSERT INTO `tbl_data_operate` VALUES ('70ED61CFE6F64B57A4C793D1B3F11C61', '更新用户信息', '/updateUser', '666666', '2021-10-20 00:58:07', NULL, NULL, '用户管理-更新用户信息', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('75A53EA470804769AB6E255300CD3216', 'SKU商品规格列表-根据ID查询产品规格', '/specification/queryById', '666666', '2022-01-01 23:06:29', NULL, NULL, '根据ID查询产品规格', '2', '15');
INSERT INTO `tbl_data_operate` VALUES ('77C5E3FCBC4247B0BD798163EF9CEE0F', 'SPU货品类型管理-分页查询货品类型', '/spuType/findPage', '666666', '2022-01-03 17:10:59', '666666', '2022-01-03 17:13:07', '分页查询货品类型', '2', '16');
INSERT INTO `tbl_data_operate` VALUES ('7911E9E92C4C4AFBACF7BA5D29DD9F28', '属性管理-通过主键查询', '/property/queryById', '666666', '2022-01-12 01:24:36', NULL, NULL, '通过主键查询', '2', '17');
INSERT INTO `tbl_data_operate` VALUES ('7BB207E65DBB491D9883A052C6D95FE8', '菜单管理-根据ID查询菜单', '/menu/queryMenuById', '666666', '2021-11-21 01:39:36', NULL, NULL, NULL, '2', '10');
INSERT INTO `tbl_data_operate` VALUES ('7C8B6C6EA72249718435020255728186', '菜单与数据操作关系配置-右侧数据操作树查询', '/codeValue/findPageChildren2', '666666', '2021-11-22 00:22:53', NULL, NULL, '数据操作', '2', '8');
INSERT INTO `tbl_data_operate` VALUES ('85F019D8CF134E5584C1BF9AC775E7CF', '添加角色', '/role/insertRole', '666666', '2021-10-15 01:50:23', '666666', '2021-11-22 00:44:05', '角色管理模块中的新增角色', '1', '9');
INSERT INTO `tbl_data_operate` VALUES ('86470DD56163445EBFC5C4209D9FB80E', '角色管理-添加角色', '/role/insertRole', '666666', '2021-11-22 00:37:38', NULL, NULL, '添加角色', '2', '9');
INSERT INTO `tbl_data_operate` VALUES ('872C3E391E094B53A5326CC8AE7CB3A7', '用户注册', '/registerUser', '666666', '2021-10-20 00:56:26', NULL, NULL, '用户管理-用户注册【新用户注册】', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('8DB4B7272A8249E1868C2D0BA67C9BD4', '属性管理-分页查询货品属性', '/property/findPage', '666666', '2022-01-12 01:10:58', '666666', '2022-01-12 01:24:06', '分页查询货品属性', '2', '17');
INSERT INTO `tbl_data_operate` VALUES ('8E8BDEA34FA04B71AAF6B677BF0E42D6', '登录', '/login', '666666', '2021-10-20 00:54:21', NULL, NULL, '用户管理-登录', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('90CA7D56AB3A492EAA0D0A3198180813', '菜单管理-根据ID维护菜单', '/menu/updateMenu', '666666', '2021-11-21 01:42:56', NULL, NULL, NULL, '2', '10');
INSERT INTO `tbl_data_operate` VALUES ('92A7DD61DC9C4414A8098ACFF322DEAA', 'SKU商品规格列表-添加产品规格', '/specification/insertSpecification', '666666', '2022-01-01 23:05:30', NULL, NULL, '添加产品规格', '2', '15');
INSERT INTO `tbl_data_operate` VALUES ('9399C627612A4E059680BCEB2CFEC7F6', '删除用户', '/deleteUser', '666666', '2021-10-20 00:56:58', NULL, NULL, '用户管理-删除用户物理删除', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('95A26D67373F4781A40281F79F39C6DE', '维护图标', '/icon/updateIcon', '666666', '2021-12-08 01:45:59', NULL, NULL, NULL, '2', '6');
INSERT INTO `tbl_data_operate` VALUES ('966B93587FCF4E53834AC2F1DD10BF14', '角色列表查询', '/role/findPage', '666666', '2021-10-15 01:49:13', '666666', '2021-11-22 00:44:36', '角色管理模块的分页查询', '1', '9');
INSERT INTO `tbl_data_operate` VALUES ('991139F0B9364367A4E5A88FD841B23B', '菜单与数据操作关系配置-更新菜单数据操作关系', '/menuDataOperateRelation/updateMenuDataOperateRelation', '666666', '2021-11-22 00:23:52', NULL, NULL, '更新菜单数据操作关系', '2', '8');
INSERT INTO `tbl_data_operate` VALUES ('9B08369A0D1F4BF2BFF327C26F3CC5B2', '用户角色关系管理-根据用户ID查询出所有角色权限', '/roleUserRelation/queryUserRoleByUserId', '666666', '2021-11-22 00:32:24', NULL, NULL, '根据用户ID查询出所有角色权限', '2', '12');
INSERT INTO `tbl_data_operate` VALUES ('9BF6D660B9914E33AEA0019C0543DCEC', '产品规格分组列表-查询产品规格逻辑删除操作', '/specificationGroup/updateDelTag', '666666', '2022-01-01 01:04:38', NULL, NULL, '查询产品规格分组', '2', '14');
INSERT INTO `tbl_data_operate` VALUES ('9CC0081C5C2743D9A0E5981253F693D9', '角色菜单关系列表-修改角色菜单关系', '/roleMenuRelation/updateRoleMenuRelation', '666666', '2021-11-22 00:17:25', NULL, NULL, '修改角色菜单关系', '2', '11');
INSERT INTO `tbl_data_operate` VALUES ('9F17D389B4C94A7992FD04FFA459E8F3', '图标维护', '/icon/updateIcon', '666666', '2021-12-11 09:13:21', '666666', '2021-12-11 09:17:53', NULL, '1', '6');
INSERT INTO `tbl_data_operate` VALUES ('A2A3360CF45649869D5A7492BB982710', '菜单管理-新增菜单', '/menu/insertMenu', '666666', '2021-12-03 02:00:32', NULL, NULL, NULL, '2', '10');
INSERT INTO `tbl_data_operate` VALUES ('A54B9351440147A4A78ADCD75076103B', '测试流式查询', '/test', '666666', '2021-10-20 00:58:38', NULL, NULL, '用户管理-流式查询测试', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('AB48464587544EBF8DE4282811F7A496', '角色菜单关系列表-角色树查询', '/role/queryAllRole', '666666', '2021-11-22 00:13:33', NULL, NULL, NULL, '2', '11');
INSERT INTO `tbl_data_operate` VALUES ('AD0BDD7782C848F29930D1D105C258C0', '属性管理-通过产品属性主键ID查询详细信息', '/property/queryDetail', '666666', '2022-01-13 01:59:05', NULL, NULL, '通过产品属性主键ID查询详细信息', '2', '17');
INSERT INTO `tbl_data_operate` VALUES ('B1673EE1651547749B2FA7AFFE312179', '重置密码', '/resetPass2', '666666', '2021-10-20 00:59:59', NULL, NULL, '用户管理-重置密码【登录之后重置密码时使用】', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('B34A68CD039E47A7AA1B1781038776A4', '用户角色关系管理-右侧角色树查询', '/role/queryAllRole', '666666', '2021-11-22 00:31:24', NULL, NULL, '查询所有角色', '2', '12');
INSERT INTO `tbl_data_operate` VALUES ('B949B972B1F547C494F0C4EBC16FA8F6', '数据操作权限控制器-添加操作', '/dataOperate/insertDop', '666666', '2021-10-10 01:31:14', NULL, NULL, 'erer 谷歌', '2', '4');
INSERT INTO `tbl_data_operate` VALUES ('BBE6FE2D6DF64A70BB5EA3C8AE89AB61', '用户列表分页查询', '/findPage', '666666', '2021-10-20 00:55:06', NULL, NULL, '用户管理-用户列表查询', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('C11B9AFBD8EC420CA8603AEFE5EF1B81', '菜单管理-删除菜单', '/menu/deleteMenu', '666666', '2021-11-21 01:41:45', NULL, NULL, NULL, '2', '10');
INSERT INTO `tbl_data_operate` VALUES ('C13C5735F99C4688955F051AA5782923', '角色管理-通过ID查询角色信息', '/role/queryById', '666666', '2021-11-22 00:38:28', NULL, NULL, '通过ID查询角色信息', '2', '9');
INSERT INTO `tbl_data_operate` VALUES ('C19180114F564B2F8DC29118777A083C', '后台管理主页面菜单树查询', '/menu/queryMenu', '666666', '2021-11-21 01:13:10', '666666', '2021-11-21 01:17:26', NULL, '1', '10');
INSERT INTO `tbl_data_operate` VALUES ('C39EA5BD5E2E4E0E9EA33776949843B2', '数据操作修改逻辑删除数据操', '/dataOperate/updateDelTag', '666666', '2021-12-11 09:16:50', NULL, NULL, '数据操作权限-逻辑删除', '2', '4');
INSERT INTO `tbl_data_operate` VALUES ('C692687667A248B9851BC26E37678571', '角色管理-更新角色', '/role/updateRole', '666666', '2021-11-22 00:38:59', NULL, NULL, '更新角色', '2', '9');
INSERT INTO `tbl_data_operate` VALUES ('C7D36B458CA74C7686C37378041E7086', '数据操作权限控制器-通过ID查询数据操作信息', '/dataOperate/queryById', '666666', '2021-10-10 01:31:48', '666666', '2021-10-11 01:58:22', 'dd三顿饭 谷歌', '2', '4');
INSERT INTO `tbl_data_operate` VALUES ('E1311C59CD2D4200BFBF466A4C98C026', '根据用户编号查询用户信息', '/queryUserById', '666666', '2021-10-20 00:57:35', '666666', '2021-11-12 00:57:42', '用户管理-根据用户编号查询用户信息', '2', '1');
INSERT INTO `tbl_data_operate` VALUES ('E7E0A31630414C0FA45DF54B0CF4A2CA', '属性管理-添加', '/property/insertProperty', '666666', '2022-01-12 01:25:54', NULL, NULL, '添加', '2', '17');
INSERT INTO `tbl_data_operate` VALUES ('E90A1387823C462DAAA6C970C37C85B1', '产品规格分组列表-维护产品规格分组', '/specificationGroup/updateSpecificationGroup', '666666', '2021-12-31 00:54:56', NULL, NULL, NULL, '2', '14');
INSERT INTO `tbl_data_operate` VALUES ('EA8F22D4F11F4A7B875E17601EF30962', '角色菜单关系列表-通过角色ID查询角色所有菜单', '/roleMenuRelation/queryRoleMenu', '666666', '2021-11-22 00:16:26', NULL, NULL, '通过角色ID查询角色所有菜单', '2', '11');
INSERT INTO `tbl_data_operate` VALUES ('F4095DFAEDE24F79A5F8A1E9430ABC8A', '额外', '发v', '666666', '2021-10-11 02:00:25', '666666', '2021-10-11 02:02:06', '反反复复', '1', '');
INSERT INTO `tbl_data_operate` VALUES ('F5E61B3A66CA4EF6A544FF6452C485A3', 'SPU货品类型管理-维护', '/spuType/updateSpuType', '666666', '2022-01-03 17:17:14', NULL, NULL, '维护', '2', '16');
INSERT INTO `tbl_data_operate` VALUES ('F67FEFAA064C4E49B80C3BC794A1FC8C', '图标库列表查询', '/icon/findPage', '666666', '2021-12-03 01:55:41', NULL, NULL, NULL, '2', '6');
INSERT INTO `tbl_data_operate` VALUES ('F6CFBE4E09BE45DC8D424239194FE821', 'SPU货品类型管理-根据主键查询详情', '/spuType/queryById', '666666', '2022-01-03 17:14:00', NULL, NULL, '根据主键查询详情', '2', '16');
INSERT INTO `tbl_data_operate` VALUES ('F7E2FEFC650D4FC3BE1CE67ED96A6DAB', '图标详情查询', '/icon/queryIconById', '666666', '2021-12-11 09:07:40', NULL, NULL, NULL, '2', '6');
INSERT INTO `tbl_data_operate` VALUES ('F83BACD610E646AA9A90DB4A75D6B044', '角色管理-分页查询', '/role/findPage', '666666', '2021-11-22 00:35:06', NULL, NULL, NULL, '2', '9');
INSERT INTO `tbl_data_operate` VALUES ('F8D6AAEF49134E8CA3E81B9AAAC839D3', '通过ID查询角色信息', '/role/queryById', '666666', '2021-10-15 01:51:05', '666666', '2021-11-22 00:44:14', '角色控制器-通过ID查询角色信息', '1', '9');
INSERT INTO `tbl_data_operate` VALUES ('FF041F75060A48F79D11B2CBD9F53CE9', '逻辑删除图标', '/icon/updateDelTag', '666666', '2021-12-12 22:17:16', NULL, NULL, NULL, '2', '6');
COMMIT;

-- ----------------------------
-- Table structure for tbl_icon
-- ----------------------------
DROP TABLE IF EXISTS `tbl_icon`;
CREATE TABLE `tbl_icon` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '图标中文名称',
  `english_name` varchar(20) NOT NULL COMMENT '图标英文名称',
  `index` int(255) DEFAULT NULL COMMENT '图标排序',
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图标表';

-- ----------------------------
-- Records of tbl_icon
-- ----------------------------
BEGIN;
INSERT INTO `tbl_icon` VALUES ('1', '编辑图标', 'el-icon-edit', 1, '666666', '2021-09-08 00:44:32', '666666', '2021-09-08 00:44:39', '2', NULL);
INSERT INTO `tbl_icon` VALUES ('2', '分享', 'el-icon-share', 2, '666666', '2021-09-08 00:45:11', '666666', '2021-09-08 00:45:19', '2', NULL);
INSERT INTO `tbl_icon` VALUES ('26F0BA2DCC62464288CB66D1984BE1AE', '二', '二', 0, '666666', '2021-12-12 22:15:17', '666666', '2021-12-12 22:18:13', '1', NULL);
INSERT INTO `tbl_icon` VALUES ('3', '删除', 'el-icon-delete', 3, '666666', '2021-09-08 00:45:49', '666666', '2021-09-08 00:45:54', '2', NULL);
INSERT INTO `tbl_icon` VALUES ('5DDFF73A80B24D6A85A826144AE37DFA', '设置', 'el-icon-setting', 9, '666666', '2021-12-08 01:58:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_icon` VALUES ('80626043E136406AA5362C7D1703EDD7', 'df发', 'el-icon-edit', 8, '666666', '2021-09-10 17:11:51', '666666', '2021-12-12 22:13:49', '2', NULL);
INSERT INTO `tbl_icon` VALUES ('8F3300BD950741909E3C85478D6DFB71', '工具', 'el-icon-s-tools', 3, '666666', '2021-12-08 01:53:54', NULL, NULL, '2', NULL);
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
  `default_select` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否默认选中1:是;2:否 只有根节点才能设置这个属性',
  `uri` varchar(50) DEFAULT NULL COMMENT '请求地址',
  `create_user` varchar(6) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `children_flag` varchar(2) DEFAULT NULL COMMENT '是否是子菜单[1:是; 2:否;]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of tbl_menu
-- ----------------------------
BEGIN;
INSERT INTO `tbl_menu` VALUES ('02B6B5C3A1B445979922C9D53DE0927D', '系统资源库', 'el-icon-edit', '0', '2', '/sysIconLib', '666666', '2021-12-03 02:02:09', NULL, NULL, '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('1', '用户管理', 'el-icon-edit', '0', '1', '/a', '666666', '2020-11-07 09:02:18', '666666', '2021-09-28 00:51:46', '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('1AEC2B1F18824D06A14CEF072538545A', 'SKU商品规格管理', 'el-icon-share', 'DA84C47521184288892D7A01AA06E40E', '2', '/listSpecification', '666666', '2021-12-13 23:49:10', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('2', '菜单管理', 'el-icon-message', '0', '1', '/b', '666666', '2020-11-07 09:03:25', NULL, NULL, '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('28C9E8AC6ABF4E7BA0A6CE7D8A114D09', '菜单与数据操作关系配置', 'el-icon-edit', '640EF8CAA138431D842DDDD12C692B7A', NULL, '/menuDataOperateShipList', '666666', '2021-10-11 13:23:27', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('29A93A61ADF8428A9DABACDA7F7FC7E0', '数据操作列表查询', 'el-icon-edit', '640EF8CAA138431D842DDDD12C692B7A', NULL, '/menuAuthList', '666666', '2021-09-28 00:48:45', '666666', '2021-09-28 01:32:47', '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('2A64BCD8F08B45A9A3BF144006780F08', '用户角色列表查询', 'el-icon-delete', '640EF8CAA138431D842DDDD12C692B7A', NULL, '/userRoleList', '666666', '2021-09-26 01:09:57', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('2A8B9D6453874843A20F425304891A81', '系统图标管理', 'el-icon-edit', '02B6B5C3A1B445979922C9D53DE0927D', '2', NULL, '666666', '2021-12-06 00:39:54', NULL, NULL, '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('3', 'API接口管理', 'el-icon-setting', '0', '2', '/c', '666666', '2020-11-07 09:04:49', NULL, NULL, '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('329BDCBD5AD74CA99A2722968AA5BFDA', '菜单与数据操作关系配置2', 'el-icon-edit', '640EF8CAA138431D842DDDD12C692B7A', NULL, '/menuDataOperateShipSetting2', '666666', '2021-10-27 01:27:33', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('4', '用户列表查询', 'el-icon-share', '1', '2', '/userList', '666666', '2020-11-07 09:05:33', '666666', '2021-09-28 00:52:07', '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('4A862D6004A949E5B72064E60E0F1820', 'SUP商品信息管理', 'el-icon-share', 'DA84C47521184288892D7A01AA06E40E', '2', '/test', '666666', '2021-12-13 00:13:10', '666666', '2021-12-13 00:26:56', '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('5', '菜单列表查询', 'el-icon-delete', '2', '2', '/menuList', '666666', '2020-11-07 09:06:13', '666666', '2021-09-28 00:49:15', '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('5D5FECCBEB8F498C808ECF36709B767D', 'SKU商品规格选项管理', 'el-icon-delete', 'DA84C47521184288892D7A01AA06E40E', '2', '/test', '666666', '2021-12-13 23:50:28', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('6', '二级菜单', 'el-icon-setting', '1', NULL, '/w', '666666', '2020-11-10 00:38:11', NULL, NULL, '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('640EF8CAA138431D842DDDD12C692B7A', '权限管理', 'el-icon-edit', '0', '2', NULL, '666666', '2021-09-26 00:53:49', NULL, NULL, '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('8', '三级菜单-1', 'el-icon-setting', '6', NULL, NULL, '666666', '2020-11-10 01:23:23', NULL, NULL, '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('8075707DC0E74E3C81DFC7DB2EF9347A', 'rtt', 'el-icon-delete', '9', NULL, '45', '666666', '2021-09-18 00:49:56', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('84AEFBAD231E414FBF689F4BCF2064F7', '图标查询', 'el-icon-share', '2A8B9D6453874843A20F425304891A81', '2', '/iconList', '666666', '2021-12-06 00:41:04', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('9', '4-1', 'el-icon-edit', '8', NULL, '/y', '666666', '2020-11-10 01:23:19', '666666', '2021-09-28 00:37:00', '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('999ECF06188E4418B19BFA562EAF864D', '属性管理', 'el-icon-setting', 'DA84C47521184288892D7A01AA06E40E', '2', '/listProperty', '666666', '2021-12-13 23:54:11', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('AB363B00FFE746B7A274F34E52E6F1D4', 'SKU规格组管理', 'el-icon-edit', 'DA84C47521184288892D7A01AA06E40E', '2', '/specificationGroupList', '666666', '2021-12-13 23:38:52', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('B0167A92314A4356AD6FB543F44B854A', 'SKU商品库存量规格组管理', 'el-icon-share', 'DA84C47521184288892D7A01AA06E40E', '2', '/test', '666666', '2021-12-13 00:38:50', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('B22E24BCB117465094F27193F2C070BF', 'hahah', 'el-icon-edit', '0', '2', NULL, '666666', '2021-10-05 01:34:20', '666666', '2021-12-03 02:00:47', '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('C19CD584F56847C1A5E2035CCF8580EF', 'SPU货品类型管理', 'el-icon-share', 'DA84C47521184288892D7A01AA06E40E', '2', '/listSpuType', '666666', '2021-12-13 00:29:42', '666666', '2022-01-03 17:19:00', '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('C4FF51003E584E0F91391AC2AFE0FC9D', '角色菜单列表查询', 'el-icon-share', '640EF8CAA138431D842DDDD12C692B7A', NULL, '/roleMenuList', '666666', '2021-09-28 00:43:01', '666666', '2021-09-28 00:46:55', '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('C59E2150467C464D8974154D2B3FDDB1', 'haha', 'el-icon-edit', '1', NULL, '/aaa', '666666', '2021-10-29 01:27:46', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('C9F42A39651E48F0887EEE7E8B784BBC', '角色列表查询', 'el-icon-edit', '640EF8CAA138431D842DDDD12C692B7A', NULL, '/roleList', '666666', '2021-09-26 00:58:58', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('DA84C47521184288892D7A01AA06E40E', '商品管理', 'el-icon-edit', '0', '2', NULL, '666666', '2021-12-13 00:04:39', NULL, NULL, '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('DAE20372C7B34E619B4278E05AD6A251', '测试', 'el-icon-share', '0', NULL, NULL, '666666', '2021-09-30 21:52:27', NULL, NULL, '2', NULL, '2');
INSERT INTO `tbl_menu` VALUES ('E96F2EFEAEB04339BB4B685F02E25061', 'SKU商品属性选项管理', 'el-icon-delete', 'DA84C47521184288892D7A01AA06E40E', '2', '/test', '666666', '2021-12-13 23:52:12', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('EE71C54493334D3D86702AB33D616213', 'SKU商品库存量管理', 'el-icon-share', 'DA84C47521184288892D7A01AA06E40E', '2', '/test', '666666', '2021-12-13 00:15:56', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('F5E119665CA04DF1811684D4F52CE04F', 'SPU商品品牌表', 'el-icon-edit', 'DA84C47521184288892D7A01AA06E40E', '2', '/test', '666666', '2021-12-13 00:30:51', NULL, NULL, '2', NULL, '1');
INSERT INTO `tbl_menu` VALUES ('F9F2BF01330A435BA0D75907CBD69A18', 'dfrvf', 'el-icon-edit', 'DAE20372C7B34E619B4278E05AD6A251', NULL, '/sd', '666666', '2021-10-05 01:34:41', NULL, NULL, '2', NULL, '1');
COMMIT;

-- ----------------------------
-- Table structure for tbl_menu_data_operate_relation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_menu_data_operate_relation`;
CREATE TABLE `tbl_menu_data_operate_relation` (
  `id` varchar(32) NOT NULL COMMENT '菜单与操作关系主键',
  `menu_id` varchar(32) NOT NULL COMMENT '菜单ID',
  `data_oper_id` varchar(32) NOT NULL COMMENT '数据操作ID',
  `create_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `menu_data_oper_fk1` (`menu_id`),
  KEY `menu_data_oper_fk2` (`data_oper_id`),
  CONSTRAINT `menu_data_oper_fk1` FOREIGN KEY (`menu_id`) REFERENCES `tbl_menu` (`id`),
  CONSTRAINT `menu_data_oper_fk2` FOREIGN KEY (`data_oper_id`) REFERENCES `tbl_data_operate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单与数据操作的关系表';

-- ----------------------------
-- Records of tbl_menu_data_operate_relation
-- ----------------------------
BEGIN;
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('010B5E69F0E44EF6BB32B3D2F059502F', '999ECF06188E4418B19BFA562EAF864D', '4762EC926DA540009E3A580AB468840F', '666666', '2022-01-13 01:59:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('026FF545A9E642A5AF7825183560DB78', '329BDCBD5AD74CA99A2722968AA5BFDA', '7C8B6C6EA72249718435020255728186', '666666', '2021-12-03 02:20:44', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('0396FE4609C3414DAE8FB2512AFC628E', '4', 'E1311C59CD2D4200BFBF466A4C98C026', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('03C41124EBDC4FF28012511A00F0753A', '4', '0EDD3B07131F4182A7C166DED4F3E1A8', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('059AF655D82E4DB3B060EAA6E11E4312', '4', 'B1673EE1651547749B2FA7AFFE312179', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('0846F3C9CC8346E68DAC20EC68472AEF', '5', '60C03D0A123C4E23B78A815F154DD924', '666666', '2021-12-03 02:01:29', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('085909C8B0544DABA77240DD8249D906', '1AEC2B1F18824D06A14CEF072538545A', '92A7DD61DC9C4414A8098ACFF322DEAA', '666666', '2022-01-01 23:11:38', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('0A81E0FC19774BFBB80CCB1F95A5C21A', '329BDCBD5AD74CA99A2722968AA5BFDA', '7C8B6C6EA72249718435020255728186', '666666', '2021-12-03 02:28:51', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('0A8F1E83D8F748148E35B630AA0F2B77', '4', 'E1311C59CD2D4200BFBF466A4C98C026', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('0CD13E02FAFC47048ECB671DBAFA349C', '4', '8E8BDEA34FA04B71AAF6B677BF0E42D6', '666666', '2021-10-31 15:35:58', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('12618775075F4A82A700D4246A8707E6', '4', '872C3E391E094B53A5326CC8AE7CB3A7', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('153C7FCDA996464EB3E81BDDBF21384D', 'C4FF51003E584E0F91391AC2AFE0FC9D', '24D14FD01D584AF2A4804197B46C5F16', '666666', '2021-11-22 00:39:59', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('1597936569EE415D822F2044A7E138D4', '999ECF06188E4418B19BFA562EAF864D', '8DB4B7272A8249E1868C2D0BA67C9BD4', '666666', '2022-01-12 01:26:45', '666666', '2022-01-13 01:59:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('15A9AEA77CE74852A04CFF98D7A234EA', '4', '70ED61CFE6F64B57A4C793D1B3F11C61', '666666', '2021-10-20 01:05:33', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('15B4737C664846A2B3927678043B6302', '4', 'BBE6FE2D6DF64A70BB5EA3C8AE89AB61', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('170CEB71B15D44BAABCC1E154CAE01BF', '4', '1EE7F79AACC44895AA49A4E8ABC7C63E', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('190273FE12B14095801CA86702DB41F5', '4', 'A54B9351440147A4A78ADCD75076103B', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('1929C98E7FB64DEA8614CC5837646512', '1AEC2B1F18824D06A14CEF072538545A', '00CC1DF3CBCB4E27BADC5F1432692DF8', '666666', '2022-01-01 01:04:52', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('194461AA39D649F28E8F483E05F57776', '4', 'B1673EE1651547749B2FA7AFFE312179', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('1957AA13A51643D29738104EA22AF475', '29A93A61ADF8428A9DABACDA7F7FC7E0', 'B949B972B1F547C494F0C4EBC16FA8F6', '666666', '2021-12-11 09:17:12', '666666', '2021-12-11 09:17:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('197B58BC60954E62B8FD38320A438916', '4', '872C3E391E094B53A5326CC8AE7CB3A7', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('1AE3C63480E040B6938A1C0F910FE8B8', '4', '70ED61CFE6F64B57A4C793D1B3F11C61', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('1C341C002E064ACE999F376BEB32B414', '999ECF06188E4418B19BFA562EAF864D', '4762EC926DA540009E3A580AB468840F', '666666', '2022-01-12 01:26:45', '666666', '2022-01-13 01:59:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('1DEFF867D93649E280FE5A80FE598C9A', '329BDCBD5AD74CA99A2722968AA5BFDA', '2621B6E105924EC79ADCCE7990C3B38D', '666666', '2021-12-03 02:20:44', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('1E2AD8F585D14046A9F28D9FC854C1E5', '84AEFBAD231E414FBF689F4BCF2064F7', '38DEA333011D48A287CF950C96052B21', '666666', '2021-12-08 01:46:16', '666666', '2021-12-12 22:17:30', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('1E65F2D0AE7F461CB95EED10DA2D8866', '4', 'BBE6FE2D6DF64A70BB5EA3C8AE89AB61', '666666', '2021-10-31 15:35:58', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('1FFCDEA99BE44F57A541CD862A285B5B', '329BDCBD5AD74CA99A2722968AA5BFDA', '17B500D657294B0F83843C116371C7C3', '666666', '2021-12-03 02:28:51', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('23A0480E47EC4200ABB074994C2BA18A', '4', '0EDD3B07131F4182A7C166DED4F3E1A8', '666666', '2021-10-31 14:28:22', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('279EC943CECA4D67A71671292A4E9F7B', '4', 'B1673EE1651547749B2FA7AFFE312179', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('283275DA5DA04942927856296918E371', '4', '24F587D5D49549119E1C21C6AF0F1208', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('2D8B887594E0462DAD97AB2755EF3420', '4', 'BBE6FE2D6DF64A70BB5EA3C8AE89AB61', '666666', '2021-10-20 01:01:05', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('30F22DD8FAEF44E48D12F66075EAC87A', '4', '1EE7F79AACC44895AA49A4E8ABC7C63E', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('34AF65593EA045AF9BAE2BD95262535C', '329BDCBD5AD74CA99A2722968AA5BFDA', '991139F0B9364367A4E5A88FD841B23B', '666666', '2021-12-03 02:28:51', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('35539DC43F0246F3A222EDCC31C17FEF', '4', 'BBE6FE2D6DF64A70BB5EA3C8AE89AB61', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('3563412B545F40F9BC696D4A3C069878', '329BDCBD5AD74CA99A2722968AA5BFDA', '991139F0B9364367A4E5A88FD841B23B', '666666', '2021-12-03 02:20:44', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('35AE03767E874045B24EA235A0CEDFA5', '4', '1EE7F79AACC44895AA49A4E8ABC7C63E', '666666', '2021-10-20 01:05:33', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('37AFC4FF96A4412B99DC879814C8ECE2', '5', '7BB207E65DBB491D9883A052C6D95FE8', '666666', '2021-11-21 01:43:07', '666666', '2021-12-03 02:01:29', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('37EF996DEA1748FF81C311E8EE6E79E8', '84AEFBAD231E414FBF689F4BCF2064F7', 'F67FEFAA064C4E49B80C3BC794A1FC8C', '666666', '2021-12-11 09:07:53', '666666', '2021-12-12 22:17:30', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('382DF540BE224AD28551C29297D9A640', '999ECF06188E4418B19BFA562EAF864D', 'AD0BDD7782C848F29930D1D105C258C0', '666666', '2022-01-13 01:59:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('3B1CB46033014E438924F10D5313B868', '29A93A61ADF8428A9DABACDA7F7FC7E0', 'B949B972B1F547C494F0C4EBC16FA8F6', '666666', '2021-11-21 01:37:59', '666666', '2021-12-11 09:17:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('3BD6748549BD489D976D18BCFBA46258', '4', '1EE7F79AACC44895AA49A4E8ABC7C63E', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('3D557520F68F4E0C9C7B2938B991461A', '4', 'BBE6FE2D6DF64A70BB5EA3C8AE89AB61', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('3EC28C032ADA42A3B9A02D74EC1F1BB5', '84AEFBAD231E414FBF689F4BCF2064F7', '95A26D67373F4781A40281F79F39C6DE', '666666', '2021-12-08 01:46:16', '666666', '2021-12-12 22:17:30', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('3F2BBE07964E42D5B71468E627892BD0', '29A93A61ADF8428A9DABACDA7F7FC7E0', 'C39EA5BD5E2E4E0E9EA33776949843B2', '666666', '2021-12-11 09:17:12', '666666', '2021-12-11 09:17:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('3F3F96365A7D4139845243AF272857F5', '1AEC2B1F18824D06A14CEF072538545A', '9BF6D660B9914E33AEA0019C0543DCEC', '666666', '2022-01-01 01:04:52', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('3F94CE7688B9484DB62268BA86F5C4DC', 'C4FF51003E584E0F91391AC2AFE0FC9D', 'AB48464587544EBF8DE4282811F7A496', '666666', '2021-11-22 00:39:59', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('404E7272E2DD4EB381CB92C079DBE25C', '329BDCBD5AD74CA99A2722968AA5BFDA', '2621B6E105924EC79ADCCE7990C3B38D', '666666', '2021-12-03 02:28:51', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('41305A9BA2CE4624A9B1F74542E4EB02', '4', '872C3E391E094B53A5326CC8AE7CB3A7', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('4339E9DE0B7E486E82EC0395F32E5714', 'AB363B00FFE746B7A274F34E52E6F1D4', '00CC1DF3CBCB4E27BADC5F1432692DF8', '666666', '2022-01-01 23:11:08', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('45DA2CDA8A594B65B05F4C81F007A182', '4', 'BBE6FE2D6DF64A70BB5EA3C8AE89AB61', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('4636AD3B043348CE8F74DDC9C3E5BBBB', '4', '0EDD3B07131F4182A7C166DED4F3E1A8', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('46424C5C27494BF3B6EADB4D836D1676', '29A93A61ADF8428A9DABACDA7F7FC7E0', 'C7D36B458CA74C7686C37378041E7086', '666666', '2021-11-21 01:37:59', '666666', '2021-12-11 09:17:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('48B220446A164DFEB89EF725CAF45B58', '5', '90CA7D56AB3A492EAA0D0A3198180813', '666666', '2021-12-03 01:56:15', '666666', '2021-12-03 02:01:29', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('4A4B82A6730846E1B3408A6C12793005', '5', 'C11B9AFBD8EC420CA8603AEFE5EF1B81', '666666', '2021-12-03 01:56:15', '666666', '2021-12-03 02:01:29', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('4C38D12D3D3C4BEAAD282D05B6738D16', '999ECF06188E4418B19BFA562EAF864D', '29DAC7A48BC941F0BD36DA71EF185892', '666666', '2022-01-13 01:59:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('4D3ACD1710834F0BA80D5005340D3D76', '4', '9399C627612A4E059680BCEB2CFEC7F6', '666666', '2021-10-20 01:05:33', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('4ECE72209E6E41B3883CA14906D76795', '329BDCBD5AD74CA99A2722968AA5BFDA', '3F96044756684544B46CA8CDFFF5B9B0', '666666', '2021-12-03 02:20:44', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('4F5A2561B30F42BDBBBCCF20B04DF2A7', '5', 'C11B9AFBD8EC420CA8603AEFE5EF1B81', '666666', '2021-12-03 02:01:29', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('4FEFAD084D8D4BB184997BFC2B2EC22A', '1AEC2B1F18824D06A14CEF072538545A', 'E90A1387823C462DAAA6C970C37C85B1', '666666', '2022-01-01 01:04:52', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('516E9703DA494DADB1F3130977BE6E39', '4', 'B1673EE1651547749B2FA7AFFE312179', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('5220010E46B149CFA44B40B233B96A77', '329BDCBD5AD74CA99A2722968AA5BFDA', '62EF34AF479946119FFB4F40CA5339DC', '666666', '2021-10-29 02:03:43', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('52DDFA42C2D643359B3BA853D84D33DB', '5', '90CA7D56AB3A492EAA0D0A3198180813', '666666', '2021-12-03 02:01:29', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('53118E74DA0540A29C16F5EE4878607B', 'AB363B00FFE746B7A274F34E52E6F1D4', 'E90A1387823C462DAAA6C970C37C85B1', '666666', '2022-01-01 23:11:08', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('53EEE7D6E4B64E26AC5144E7279DADF9', 'C9F42A39651E48F0887EEE7E8B784BBC', '1182B53FD2A6461C81FB9FB579FF2D01', '666666', '2021-11-22 00:42:34', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('546C8B8BB468415985A39A4B4E1B97F7', '4', 'B1673EE1651547749B2FA7AFFE312179', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('553BCFE59B924E92AD755E26694D4B55', '4', '0EDD3B07131F4182A7C166DED4F3E1A8', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('55F50CD37AB0493CBCE5906D6CDFAE0D', '29A93A61ADF8428A9DABACDA7F7FC7E0', 'C7D36B458CA74C7686C37378041E7086', '666666', '2021-12-11 09:17:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('563501416FB34EBE94B72885E9C5CE5F', '4', '70ED61CFE6F64B57A4C793D1B3F11C61', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('5739FC1B4C0244F9BF7524C966529911', '29A93A61ADF8428A9DABACDA7F7FC7E0', '62EF34AF479946119FFB4F40CA5339DC', '666666', '2021-12-11 09:17:12', '666666', '2021-12-11 09:17:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('5860BFA00F774C99ADECD9A3ED0F9532', 'C9F42A39651E48F0887EEE7E8B784BBC', 'F8D6AAEF49134E8CA3E81B9AAAC839D3', '666666', '2021-10-15 02:21:51', '666666', '2021-11-22 00:42:34', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('59A11186B63E4444B518BDA8C4A660D5', '4', 'E1311C59CD2D4200BFBF466A4C98C026', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('5BC97771CED24A1FA4B4DF3A01563F26', '4', '8E8BDEA34FA04B71AAF6B677BF0E42D6', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('5C539826907E49118FD4625B4E19925C', '2A64BCD8F08B45A9A3BF144006780F08', '9B08369A0D1F4BF2BFF327C26F3CC5B2', '666666', '2021-11-22 00:41:06', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('5D1D2E8C387D47AD8ECEB5AB3FD428C1', 'AB363B00FFE746B7A274F34E52E6F1D4', '9BF6D660B9914E33AEA0019C0543DCEC', '666666', '2022-01-01 23:11:08', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('5ED80A68FB344CE786E6E0F63B2656E2', '4', '9399C627612A4E059680BCEB2CFEC7F6', '666666', '2021-10-31 14:28:22', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('6003A418448441689AF6C103B2360902', '329BDCBD5AD74CA99A2722968AA5BFDA', 'B949B972B1F547C494F0C4EBC16FA8F6', '666666', '2021-10-29 02:03:43', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('63E8EF0DF5CF43FF8D9A0750998FB00A', '999ECF06188E4418B19BFA562EAF864D', 'E7E0A31630414C0FA45DF54B0CF4A2CA', '666666', '2022-01-12 01:26:45', '666666', '2022-01-13 01:59:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('65046A39E1D749E79673FC5D58AC1EF5', '4', '70ED61CFE6F64B57A4C793D1B3F11C61', '666666', '2021-10-31 14:28:22', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('650BA2879D17421BBB41FDFEF1166D78', '5', '90CA7D56AB3A492EAA0D0A3198180813', '666666', '2021-11-21 01:43:07', '666666', '2021-12-03 02:01:29', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('654B2DA8621D4090A1ECE20903E5950A', '4', '872C3E391E094B53A5326CC8AE7CB3A7', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('65524DEC78A243B2B6A4DC017B1BE5A1', '84AEFBAD231E414FBF689F4BCF2064F7', '95A26D67373F4781A40281F79F39C6DE', '666666', '2021-12-11 09:07:53', '666666', '2021-12-12 22:17:30', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('656F93029EBD4C00BBA42D1B5836650B', 'AB363B00FFE746B7A274F34E52E6F1D4', '6570E12DFA9043F0B25DF30068A86362', '666666', '2022-01-01 23:11:08', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('657DD5DA8C1B4449A4D6491A6B80C365', '329BDCBD5AD74CA99A2722968AA5BFDA', '17B500D657294B0F83843C116371C7C3', '666666', '2021-12-03 02:21:46', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('65C2000D986F47D69D57F941F2975ABC', '1AEC2B1F18824D06A14CEF072538545A', '59FED7AC3A1C4EEB8C6F2F32E032DC13', '666666', '2021-12-31 00:15:50', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('67369644B9A54D51BA74B7C5E614F90B', '4', '9399C627612A4E059680BCEB2CFEC7F6', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('67B56562FD9E4993A4694C1FF942689D', '1AEC2B1F18824D06A14CEF072538545A', '75A53EA470804769AB6E255300CD3216', '666666', '2022-01-01 23:11:38', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('680357528BE54A3CAAF60F4CA89F2016', '1AEC2B1F18824D06A14CEF072538545A', '6570E12DFA9043F0B25DF30068A86362', '666666', '2022-01-01 01:04:52', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('6C7BDDFC4B5F4548A8AAFC1A0D45CADC', '84AEFBAD231E414FBF689F4BCF2064F7', '95A26D67373F4781A40281F79F39C6DE', '666666', '2021-12-12 22:17:30', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('6E35CC7ED6EB485EA2BF9E79A4849B9E', '1AEC2B1F18824D06A14CEF072538545A', '6EA30662BC3C499BA88ADF38F515BDF8', '666666', '2022-01-01 23:11:38', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('6EDB7CB7DAAE438892349E633BBD87A0', '4', '0EDD3B07131F4182A7C166DED4F3E1A8', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('6EE6A08BADD64EFCBB84DC73C91F5099', '4', '8E8BDEA34FA04B71AAF6B677BF0E42D6', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('6F3CDF8671054DF1BE52A2E4FFA0BAA7', '4', 'A54B9351440147A4A78ADCD75076103B', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('6F7F312BE2C34E9995218544A8F158F9', '1AEC2B1F18824D06A14CEF072538545A', '6EA30662BC3C499BA88ADF38F515BDF8', '666666', '2022-01-05 02:01:10', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('7095AF5EC2CA4609911C21DBD8D3F267', '4', 'A54B9351440147A4A78ADCD75076103B', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('71784522F9CA48FD9A3C7F900F03189A', '4', 'A54B9351440147A4A78ADCD75076103B', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('71D2C6DC2CCC4D2B827A668F43CDB24D', '4', '9399C627612A4E059680BCEB2CFEC7F6', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('720C64B5839E4E1E82FBE28B4021DED3', '5', '60C03D0A123C4E23B78A815F154DD924', '666666', '2021-11-21 01:43:07', '666666', '2021-12-03 02:01:29', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('73022C755B08404B98A0A5450FFC3784', '1AEC2B1F18824D06A14CEF072538545A', '194E6BECB9104D7AB50BE9F407FE5C84', '666666', '2022-01-01 23:11:38', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('7507772109C048C591E754FEBE1F12C9', '4', 'B1673EE1651547749B2FA7AFFE312179', '666666', '2021-10-31 14:28:22', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('757B42BBFA9B4D6A959AEB21B49998DB', '4', '24F587D5D49549119E1C21C6AF0F1208', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('77C29C4F1D1740B3A1C8269C72465336', '999ECF06188E4418B19BFA562EAF864D', '7911E9E92C4C4AFBACF7BA5D29DD9F28', '666666', '2022-01-12 01:26:45', '666666', '2022-01-13 01:59:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('79DD3612FE99461C8CC7E91C8F383532', '4', '1EE7F79AACC44895AA49A4E8ABC7C63E', '666666', '2021-10-31 15:35:58', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('79FBEDB9686444DEA51282CAB5801D97', '999ECF06188E4418B19BFA562EAF864D', '8DB4B7272A8249E1868C2D0BA67C9BD4', '666666', '2022-01-13 01:59:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('7A465CEEAD8E437CBD55B4B88B132B74', '2A64BCD8F08B45A9A3BF144006780F08', '61272929AB4D44B493C530C230A70336', '666666', '2021-11-22 00:41:06', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('7A6D6F706AED4B569B4952EF21A53F90', '1AEC2B1F18824D06A14CEF072538545A', '59FED7AC3A1C4EEB8C6F2F32E032DC13', '666666', '2021-12-31 00:55:53', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('7B4B460094684553BFA6EA9412589F59', '84AEFBAD231E414FBF689F4BCF2064F7', 'F67FEFAA064C4E49B80C3BC794A1FC8C', '666666', '2021-12-06 00:49:54', '666666', '2021-12-12 22:17:30', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('7C741AF68E094450B7ACF2D068526B72', '5', '60C03D0A123C4E23B78A815F154DD924', '666666', '2021-12-03 01:56:15', '666666', '2021-12-03 02:01:29', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('7EC15FC71D0148A5BBC63775533EBE6E', '1AEC2B1F18824D06A14CEF072538545A', '194E6BECB9104D7AB50BE9F407FE5C84', '666666', '2022-01-05 02:01:10', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('805B39F0948140C18AF0D9D47BF44BDA', '4', '2B028C0AD50B4484893F35E0CBD77E44', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('851D0ADFEEAB48768D4E574E4F27818D', '999ECF06188E4418B19BFA562EAF864D', '7911E9E92C4C4AFBACF7BA5D29DD9F28', '666666', '2022-01-13 01:59:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('8701619B147C469F9194CA8D95BEA8F2', '4', '872C3E391E094B53A5326CC8AE7CB3A7', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('87BA48437BC849D3B5CC41FAB1C72896', '329BDCBD5AD74CA99A2722968AA5BFDA', '991139F0B9364367A4E5A88FD841B23B', '666666', '2021-12-03 02:21:46', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('87C728C3BCB64B698D88A3E3D8F54A96', '4', '0EDD3B07131F4182A7C166DED4F3E1A8', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('892943107F8344909B5ED9B53D017720', '4', '2B028C0AD50B4484893F35E0CBD77E44', '666666', '2021-10-31 15:35:58', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('8B81EE6B2D19498680AEA4E92BBE740C', '2A64BCD8F08B45A9A3BF144006780F08', 'B34A68CD039E47A7AA1B1781038776A4', '666666', '2021-11-22 00:41:06', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('8D1EAB2E2C484CE49A7E5CD7DDF11C88', '1AEC2B1F18824D06A14CEF072538545A', '92A7DD61DC9C4414A8098ACFF322DEAA', '666666', '2022-01-05 02:01:10', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('8DB5E8EA11C0444BAFC725F37FB558F8', '4', 'E1311C59CD2D4200BFBF466A4C98C026', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('8F0A2D1E29434AD697541CCE19B0A2BE', '5', 'F67FEFAA064C4E49B80C3BC794A1FC8C', '666666', '2021-12-03 02:01:29', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('8FAEAE542B39488FB424B056E35A2A7D', 'C9F42A39651E48F0887EEE7E8B784BBC', '86470DD56163445EBFC5C4209D9FB80E', '666666', '2021-11-22 00:42:34', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('8FD735F0B7104E44B2498EB2183075C2', '1AEC2B1F18824D06A14CEF072538545A', '6570E12DFA9043F0B25DF30068A86362', '666666', '2021-12-31 00:55:53', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('907F86FA7AF24C95AF3D775F578E24C5', '999ECF06188E4418B19BFA562EAF864D', '29DAC7A48BC941F0BD36DA71EF185892', '666666', '2022-01-12 01:26:45', '666666', '2022-01-13 01:59:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('90BA0BE7191E45F7BC89CBA376B9808F', '4', '872C3E391E094B53A5326CC8AE7CB3A7', '666666', '2021-10-31 15:35:58', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('91F50B08927C4FA1816FB75324BA1A49', '329BDCBD5AD74CA99A2722968AA5BFDA', '2621B6E105924EC79ADCCE7990C3B38D', '666666', '2021-11-22 00:40:50', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('92531B0F877148CB86EAB5B294636FA9', '4', '2B028C0AD50B4484893F35E0CBD77E44', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('940BF3C18DD042EAA20C03ADF90BA32E', 'C19CD584F56847C1A5E2035CCF8580EF', '77C5E3FCBC4247B0BD798163EF9CEE0F', '666666', '2022-01-03 17:18:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('95096420A251477DA5A8C3D554403B66', '5', 'A2A3360CF45649869D5A7492BB982710', '666666', '2021-12-03 02:01:29', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('95AA40D09A1A4A38A648DD407505A280', 'AB363B00FFE746B7A274F34E52E6F1D4', '59FED7AC3A1C4EEB8C6F2F32E032DC13', '666666', '2022-01-01 23:11:08', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('969E9A37C13648359C0B95F579E8B8AE', '329BDCBD5AD74CA99A2722968AA5BFDA', 'C7D36B458CA74C7686C37378041E7086', '666666', '2021-10-29 02:03:43', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('99E3460D1E804F43990CF71B3143E96C', '329BDCBD5AD74CA99A2722968AA5BFDA', '3F96044756684544B46CA8CDFFF5B9B0', '666666', '2021-12-03 02:21:46', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('9EA9D87B8C1A471BA83A6C3940A0B38C', '4', '1EE7F79AACC44895AA49A4E8ABC7C63E', '666666', '2021-10-31 14:28:22', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('A1012AE4F2CD41FB9F9EA32D42F3ABA3', 'C4FF51003E584E0F91391AC2AFE0FC9D', 'EA8F22D4F11F4A7B875E17601EF30962', '666666', '2021-11-22 00:39:59', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('A1D13101899942E4B20EB8D2977395B2', '4', 'E1311C59CD2D4200BFBF466A4C98C026', '666666', '2021-10-20 01:05:33', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('A27C9E64A4AA44CB9147A13B83F3F472', '4', '2B028C0AD50B4484893F35E0CBD77E44', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('A3EE62429C9B4F34AA94326777FFD4FC', '5', '7BB207E65DBB491D9883A052C6D95FE8', '666666', '2021-12-03 01:56:15', '666666', '2021-12-03 02:01:29', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('A40AB504612C4AD384048F1DE1E56B35', '4', 'BBE6FE2D6DF64A70BB5EA3C8AE89AB61', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('A495A0C5F99342D1AE2112D51B488837', '4', '9399C627612A4E059680BCEB2CFEC7F6', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('A60F756788294AC0A0B49529C6D914CD', '4', 'A54B9351440147A4A78ADCD75076103B', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('A6ADCC6AD46D4D8E82B622AC122B604B', '329BDCBD5AD74CA99A2722968AA5BFDA', '3F96044756684544B46CA8CDFFF5B9B0', '666666', '2021-12-03 02:28:51', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('A9FC39B7EB8C4C30927F86C48F4B9ED1', '4', '9399C627612A4E059680BCEB2CFEC7F6', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('AB4489B2778C456498DEB1F133EAEC97', '4', '2B028C0AD50B4484893F35E0CBD77E44', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('AEF73936AC004A4F929D61EEAEC95769', '4', 'E1311C59CD2D4200BFBF466A4C98C026', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('AF372FE0F9F94B7C85CB5222AD2E31B5', '4', 'B1673EE1651547749B2FA7AFFE312179', '666666', '2021-10-31 15:35:58', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('AFAED216BF7F4277A6108D1FD6AD8C02', '4', '872C3E391E094B53A5326CC8AE7CB3A7', '666666', '2021-10-31 14:28:22', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('B11C858C45D545E2AB69EDE3A2C60D18', '1AEC2B1F18824D06A14CEF072538545A', '59FED7AC3A1C4EEB8C6F2F32E032DC13', '666666', '2022-01-01 01:04:52', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('B1CC833B2E634CACBD7DD75B9D59707A', '1AEC2B1F18824D06A14CEF072538545A', '6570E12DFA9043F0B25DF30068A86362', '666666', '2021-12-30 01:06:00', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('B1F5EE3FAC044451A58E3BD2BF258BB1', '4', '8E8BDEA34FA04B71AAF6B677BF0E42D6', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('B369032BE94C409092583ABFF3DAD625', '329BDCBD5AD74CA99A2722968AA5BFDA', '2621B6E105924EC79ADCCE7990C3B38D', '666666', '2021-12-03 02:21:46', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('B5DD9EC59DDD479DB85A9CA3495270CD', '4', 'B1673EE1651547749B2FA7AFFE312179', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('B6A62F2B07CD45A29F9D4B78DE71CAF8', 'C19CD584F56847C1A5E2035CCF8580EF', 'F6CFBE4E09BE45DC8D424239194FE821', '666666', '2022-01-03 17:18:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('B6F4C043AEF54DA7BD24E827E560F0BE', 'C19CD584F56847C1A5E2035CCF8580EF', '3504712A66B14BA5B725EBBF6CFC93E9', '666666', '2022-01-03 17:18:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('BB4B29DC58B24A229583B782377E24B1', '29A93A61ADF8428A9DABACDA7F7FC7E0', 'C7D36B458CA74C7686C37378041E7086', '666666', '2021-12-11 09:17:12', '666666', '2021-12-11 09:17:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('BDC57A002D4D407690A770433569A522', 'C9F42A39651E48F0887EEE7E8B784BBC', '85F019D8CF134E5584C1BF9AC775E7CF', '666666', '2021-10-15 02:21:51', '666666', '2021-11-22 00:42:34', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('BE42197E493F4F52999E3A08F2C0E798', '4', 'BBE6FE2D6DF64A70BB5EA3C8AE89AB61', '666666', '2021-10-20 01:05:33', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('BE432EE5D2DE4AC58E9BC7020B1EC3BF', '4', '9399C627612A4E059680BCEB2CFEC7F6', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('BEB81EB7E0B0402C940E74753C222C9D', '84AEFBAD231E414FBF689F4BCF2064F7', '38DEA333011D48A287CF950C96052B21', '666666', '2021-12-12 22:17:30', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('C1EA7FC12A7040A5BB14832543F90941', '4', '1EE7F79AACC44895AA49A4E8ABC7C63E', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('C3ABC5798B91426CA8625E2EA671D841', '5', 'C11B9AFBD8EC420CA8603AEFE5EF1B81', '666666', '2021-11-21 01:43:07', '666666', '2021-12-03 02:01:29', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('C43B8A4B065743ACBF052D73FBDEC900', '5', '60C03D0A123C4E23B78A815F154DD924', '666666', '2021-11-21 01:38:14', '666666', '2021-12-03 02:01:29', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('C57131C9A8C44FDEA82D31B39406CFAF', '4', 'A54B9351440147A4A78ADCD75076103B', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('C5B9AFD2F5FF4D0D8F6DE997C8B6BA21', '84AEFBAD231E414FBF689F4BCF2064F7', 'F67FEFAA064C4E49B80C3BC794A1FC8C', '666666', '2021-12-08 01:46:16', '666666', '2021-12-12 22:17:30', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('C955D743272E44B6A7A23E061F7035D6', 'C9F42A39651E48F0887EEE7E8B784BBC', 'F83BACD610E646AA9A90DB4A75D6B044', '666666', '2021-11-22 00:42:34', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('CA8B24CA132040A0B01B039DDBDCA416', '1AEC2B1F18824D06A14CEF072538545A', 'E90A1387823C462DAAA6C970C37C85B1', '666666', '2021-12-31 00:55:53', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('CA957CAD85D14387A086AF483288BD27', 'C9F42A39651E48F0887EEE7E8B784BBC', 'C13C5735F99C4688955F051AA5782923', '666666', '2021-11-22 00:42:34', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('CBC2F6066A2B48F2B0EC21E16B3A7ADB', '4', '2B028C0AD50B4484893F35E0CBD77E44', '666666', '2021-10-31 14:28:22', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('CC47AE8F483842568AC9A7279DF53F9D', '4', '8E8BDEA34FA04B71AAF6B677BF0E42D6', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('CDBF6E087CAB4CE4A076378FF39F88FA', '29A93A61ADF8428A9DABACDA7F7FC7E0', '62EF34AF479946119FFB4F40CA5339DC', '666666', '2021-12-11 09:17:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('CF1997C6141C44839022EF194F2063FD', '4', '9399C627612A4E059680BCEB2CFEC7F6', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('CFBA3885EA9C4A05A206CEDA6C11E8CF', '4', '872C3E391E094B53A5326CC8AE7CB3A7', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D001C811DF3140478BE5B08FE80DC209', '1AEC2B1F18824D06A14CEF072538545A', '5800365147F34CD9A447DEF4C7F8C1E3', '666666', '2022-01-01 23:11:38', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D1482287C0824EACA587CCF9B75DF336', '329BDCBD5AD74CA99A2722968AA5BFDA', '24F587D5D49549119E1C21C6AF0F1208', '666666', '2021-10-29 02:03:43', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D1A43A670A0340749F835D0C6291BB66', '329BDCBD5AD74CA99A2722968AA5BFDA', '7C8B6C6EA72249718435020255728186', '666666', '2021-11-22 00:40:50', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D1BDC094D8544C97B0D2B4F9EC586898', '84AEFBAD231E414FBF689F4BCF2064F7', 'F7E2FEFC650D4FC3BE1CE67ED96A6DAB', '666666', '2021-12-11 09:07:53', '666666', '2021-12-12 22:17:30', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D1FA5B242B144976BB2A5996A27F501B', '29A93A61ADF8428A9DABACDA7F7FC7E0', '24F587D5D49549119E1C21C6AF0F1208', '666666', '2021-12-11 09:17:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D2081B3FDA2B4AD3803A0F12D90A1BD8', '4', '0EDD3B07131F4182A7C166DED4F3E1A8', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D29673B3D8F947178E03144A868F1752', 'C9F42A39651E48F0887EEE7E8B784BBC', '966B93587FCF4E53834AC2F1DD10BF14', '666666', '2021-10-15 02:21:51', '666666', '2021-11-22 00:42:34', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D326A19F167C42DA9A02E308005F78E5', '4', 'E1311C59CD2D4200BFBF466A4C98C026', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D37F44DE066D402492E0C84ABD8ABE04', '4', '9399C627612A4E059680BCEB2CFEC7F6', '666666', '2021-10-31 15:35:58', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D3F758C91664421189B59CC64D566B05', '4', '1EE7F79AACC44895AA49A4E8ABC7C63E', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D486BF037F484D0EB2381083ADE4C027', '4', '8E8BDEA34FA04B71AAF6B677BF0E42D6', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D6FCA09E44F94EA9976234776C3AB729', '84AEFBAD231E414FBF689F4BCF2064F7', 'F7E2FEFC650D4FC3BE1CE67ED96A6DAB', '666666', '2021-12-12 22:17:30', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D755CAA07B4249B090063211E37ED266', '4', '70ED61CFE6F64B57A4C793D1B3F11C61', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D78FF423D1974652A364EA6BDF695302', '29A93A61ADF8428A9DABACDA7F7FC7E0', 'B949B972B1F547C494F0C4EBC16FA8F6', '666666', '2021-12-11 09:17:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('D9F172DADE0742FD93C40F5F5223B339', '4', '8E8BDEA34FA04B71AAF6B677BF0E42D6', '666666', '2021-10-31 14:28:22', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('DB10A03D3B5C450FA133DC9E975BA404', '4', '1EE7F79AACC44895AA49A4E8ABC7C63E', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('DB212DD01F1848A494C25F4A715DA70C', '4', '8E8BDEA34FA04B71AAF6B677BF0E42D6', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('DD73B7EEA24E4B8D9EB5F24C50B12C92', 'C9F42A39651E48F0887EEE7E8B784BBC', 'C692687667A248B9851BC26E37678571', '666666', '2021-11-22 00:42:34', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('DD9D1B4C71FC44F08C10B209B89E99F0', '29A93A61ADF8428A9DABACDA7F7FC7E0', '24F587D5D49549119E1C21C6AF0F1208', '666666', '2021-11-21 01:37:59', '666666', '2021-12-11 09:17:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('DE2A376EE8154801964B07C8F1C7B119', '29A93A61ADF8428A9DABACDA7F7FC7E0', '24F587D5D49549119E1C21C6AF0F1208', '666666', '2021-12-11 09:17:12', '666666', '2021-12-11 09:17:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('DE474E82270D449AA459F815D9BAB8C5', '5', 'F67FEFAA064C4E49B80C3BC794A1FC8C', '666666', '2021-12-03 01:56:15', '666666', '2021-12-03 02:01:29', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('DF9C0A13455B4FBAA327536D0BEBAE98', 'C4FF51003E584E0F91391AC2AFE0FC9D', '9CC0081C5C2743D9A0E5981253F693D9', '666666', '2021-11-22 00:39:59', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('DFED5C200B1E4D538FEB4B73AADB7E6C', '8075707DC0E74E3C81DFC7DB2EF9347A', '1EE7F79AACC44895AA49A4E8ABC7C63E', '666666', '2021-11-12 01:02:02', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('E5E65547A101415AA51BB80034FD8A48', 'C19CD584F56847C1A5E2035CCF8580EF', '135608F3B2914EC8820CA543940ACB36', '666666', '2022-01-03 17:18:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('E7EF0260A3B541E58BEDB93994DD0DD9', '29A93A61ADF8428A9DABACDA7F7FC7E0', 'C39EA5BD5E2E4E0E9EA33776949843B2', '666666', '2021-12-11 09:17:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('E98C7D6DAEDE4611B8239921D1AA01A1', 'C19CD584F56847C1A5E2035CCF8580EF', 'F5E61B3A66CA4EF6A544FF6452C485A3', '666666', '2022-01-03 17:18:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('EB11CB4339D74779B4DA5C0F339E0F64', '329BDCBD5AD74CA99A2722968AA5BFDA', '991139F0B9364367A4E5A88FD841B23B', '666666', '2021-11-22 00:40:50', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('EB20EB539CA24B3D9083B01706D582E5', '4', '2B028C0AD50B4484893F35E0CBD77E44', '666666', '2021-10-29 02:03:07', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('EBBC533F1B21470E9C27817F7F7251F3', '4', '70ED61CFE6F64B57A4C793D1B3F11C61', '666666', '2021-10-29 02:02:50', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('ECF3861D9C9448D7B14F9DF999BD4ACD', '1AEC2B1F18824D06A14CEF072538545A', '5800365147F34CD9A447DEF4C7F8C1E3', '666666', '2022-01-05 02:01:10', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('EDC1CAB1E1794BF28EB3912F1C6F53B6', '999ECF06188E4418B19BFA562EAF864D', 'E7E0A31630414C0FA45DF54B0CF4A2CA', '666666', '2022-01-13 01:59:20', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('EF8AB30E43B64D7E9B51F80712363490', '1AEC2B1F18824D06A14CEF072538545A', '00CC1DF3CBCB4E27BADC5F1432692DF8', '666666', '2021-12-31 00:55:53', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F009D1EF12DD46AE970E442401AF9622', '4', '2B028C0AD50B4484893F35E0CBD77E44', '666666', '2021-10-20 01:05:33', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F1027FC55FAD424193EF64A0D89FC4FE', '5', '7BB207E65DBB491D9883A052C6D95FE8', '666666', '2021-12-03 02:01:29', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F140E0EF0F644A9DB9988BDD1C591BA7', '4', 'A54B9351440147A4A78ADCD75076103B', '666666', '2021-10-31 15:35:58', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F1E52EAC8D044DB2BEBF7C4028D1AA46', '4', '2B028C0AD50B4484893F35E0CBD77E44', '666666', '2021-10-29 19:49:11', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F3BD13282ADA47F4B0E84DCD0D2940A3', '29A93A61ADF8428A9DABACDA7F7FC7E0', '62EF34AF479946119FFB4F40CA5339DC', '666666', '2021-11-21 01:37:59', '666666', '2021-12-11 09:17:20', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F42DBF161CFE45B09944B8F96ACB2282', '2A64BCD8F08B45A9A3BF144006780F08', '19FEABB23BE74452B074932139B33AC8', '666666', '2021-11-22 00:41:06', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F496A364412D4F4A94F2E0097D3F2548', '329BDCBD5AD74CA99A2722968AA5BFDA', '17B500D657294B0F83843C116371C7C3', '666666', '2021-12-03 02:20:44', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F5F309E8EE6145BEAE73A47EC7CDD22F', '84AEFBAD231E414FBF689F4BCF2064F7', 'FF041F75060A48F79D11B2CBD9F53CE9', '666666', '2021-12-12 22:17:30', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F7550BED83B44D0DAB6F4CF3FEB666E1', '329BDCBD5AD74CA99A2722968AA5BFDA', '3F96044756684544B46CA8CDFFF5B9B0', '666666', '2021-11-22 00:40:50', '666666', '2021-12-03 02:28:51', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F7A4CB369FF14641BE04708E9C880F1F', '4', '70ED61CFE6F64B57A4C793D1B3F11C61', '666666', '2021-10-29 02:03:00', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F88694A627AC4D609A5DA79ED9E0B60B', '1AEC2B1F18824D06A14CEF072538545A', '6570E12DFA9043F0B25DF30068A86362', '666666', '2021-12-31 00:15:50', '666666', '2022-01-05 02:01:10', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F97A21CC56CA47069A8D71F5C06B23C5', '4', 'A54B9351440147A4A78ADCD75076103B', '666666', '2021-10-31 14:28:22', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('F9F04A671CAC44DD9C1E76988C42FFD8', '4', '70ED61CFE6F64B57A4C793D1B3F11C61', '666666', '2021-11-21 01:38:36', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('FAF964A9A71B461FB5F7E8102D852E65', '84AEFBAD231E414FBF689F4BCF2064F7', 'F67FEFAA064C4E49B80C3BC794A1FC8C', '666666', '2021-12-12 22:17:30', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('FC38BDD006114BD0B77F48C4D278A5AF', '4', 'BBE6FE2D6DF64A70BB5EA3C8AE89AB61', '666666', '2021-10-31 14:27:53', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('FD2E965AD0424E378AFAD7BCA5581308', '84AEFBAD231E414FBF689F4BCF2064F7', '38DEA333011D48A287CF950C96052B21', '666666', '2021-12-11 09:07:53', '666666', '2021-12-12 22:17:30', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('FE44F572C5CD407FAEC14F4DD7A7536C', '1AEC2B1F18824D06A14CEF072538545A', '56FCF927B08E4290B5802FD7147154D9', '666666', '2022-01-05 02:01:10', NULL, NULL, '2', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('FE9E890682EB42E29CA21FACC5A82353', '4', '0EDD3B07131F4182A7C166DED4F3E1A8', '666666', '2021-10-31 15:35:58', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('FEB1F364BFAD4A6289EC49E2A1DBAF92', '4', '70ED61CFE6F64B57A4C793D1B3F11C61', '666666', '2021-10-31 15:35:58', '666666', '2021-11-21 01:38:36', '1', NULL);
INSERT INTO `tbl_menu_data_operate_relation` VALUES ('FFF5F1149B2D415EBD2D8E065A3214AD', '1AEC2B1F18824D06A14CEF072538545A', '75A53EA470804769AB6E255300CD3216', '666666', '2022-01-05 02:01:10', NULL, NULL, '2', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_property
-- ----------------------------
DROP TABLE IF EXISTS `tbl_property`;
CREATE TABLE `tbl_property` (
  `id` varchar(255) NOT NULL COMMENT '属性ID',
  `name` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `type_id` varchar(255) DEFAULT NULL COMMENT '分类ID',
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `value` varchar(255) DEFAULT NULL COMMENT '属性值',
  PRIMARY KEY (`id`),
  KEY `fk_type_id` (`type_id`),
  CONSTRAINT `fk_type_id` FOREIGN KEY (`type_id`) REFERENCES `tbl_spu_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性表';

-- ----------------------------
-- Records of tbl_property
-- ----------------------------
BEGIN;
INSERT INTO `tbl_property` VALUES ('1', '手机颜色', '2', '', '2022-01-12 01:34:13', '666666', '2022-01-14 01:01:47', '2', 'dfdf', '红色');
INSERT INTO `tbl_property` VALUES ('2', '手机容量', '1', '', '2022-01-12 01:34:17', '666666', '2022-01-14 01:02:27', '2', NULL, '200G');
INSERT INTO `tbl_property` VALUES ('3', '腊肉重量', '3', '', '2022-01-12 01:34:21', '666666', '2022-01-14 01:04:45', '1', NULL, NULL);
INSERT INTO `tbl_property` VALUES ('4', '手机屏幕尺寸', '1', '', '2022-01-12 01:34:25', NULL, NULL, '2', NULL, NULL);
INSERT INTO `tbl_property` VALUES ('5', '电脑机盖颜色', '2', '', '2022-01-12 01:34:28', NULL, NULL, '2', NULL, NULL);
INSERT INTO `tbl_property` VALUES ('6', '电脑硬盘容量', '2', '', '2022-01-12 01:39:52', NULL, NULL, '2', NULL, NULL);
INSERT INTO `tbl_property` VALUES ('6F487D34A67744349A8ED65711148877', '屏幕尺寸', '1', '666666', '2022-01-13 01:56:57', NULL, NULL, '2', '哈哈', NULL);
INSERT INTO `tbl_property` VALUES ('7', '电脑运行内存', '2', '', '2022-01-12 01:39:56', NULL, NULL, '2', NULL, NULL);
INSERT INTO `tbl_property` VALUES ('8', '腊肉已存放时间', '3', '', '2022-01-12 01:39:59', NULL, NULL, '2', NULL, NULL);
INSERT INTO `tbl_property` VALUES ('B55F559193F844588879C6943C3B8F29', '尺寸大小', '2', '666666', '2022-01-14 01:03:38', NULL, NULL, '2', '哈哈', '10米');
COMMIT;

-- ----------------------------
-- Table structure for tbl_property_options
-- ----------------------------
DROP TABLE IF EXISTS `tbl_property_options`;
CREATE TABLE `tbl_property_options` (
  `id` varchar(255) NOT NULL COMMENT '属性选项ID',
  `value` varchar(50) DEFAULT NULL COMMENT '选项值',
  `attr_id` varchar(255) DEFAULT NULL COMMENT '属性ID',
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_pro_opt_1` (`attr_id`),
  CONSTRAINT `fk_pro_opt_1` FOREIGN KEY (`attr_id`) REFERENCES `tbl_property` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性选项表';

-- ----------------------------
-- Records of tbl_property_options
-- ----------------------------
BEGIN;
INSERT INTO `tbl_property_options` VALUES ('1', '黑色', '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('10', '16G', '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('11', '32', '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('12', '1KG', '3', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('13', '2KG', '3', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('14', '0.5KG', '3', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('15', '5.5寸', '4', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('16', '6寸', '4', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('17', '8个月', '8', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('18', '1年', '8', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('2', '白色', '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('3', '玫瑰金', '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('4', '灰色', '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('5', '深灰', '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('6', '1G', '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('7', '2G', '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('8', '4G', '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_property_options` VALUES ('9', '8G', '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role` (
  `id` varchar(32) NOT NULL COMMENT '角色主键',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `create_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
BEGIN;
INSERT INTO `tbl_role` VALUES ('1', '管理员', '666666', '2021-09-29 23:31:24', '666666', '2021-11-12 01:01:23', '2', 'fdf出具的附近');
INSERT INTO `tbl_role` VALUES ('11CBE4967EB94D3C8501649410DFF112', '万麻子', '666666', '2021-10-05 02:34:39', '666666', '2021-11-01 00:14:06', '2', '地方快递费地方的看法');
INSERT INTO `tbl_role` VALUES ('2C1EEEB12EAA483CBA8BCD3EE6FDCC6B', 'fggrt', '666666', '2021-10-08 00:22:02', NULL, '2021-10-08 00:22:08', '1', NULL);
INSERT INTO `tbl_role` VALUES ('922B45F488D14FEC855DC507DAF2D676', 'AAS', '666666', '2021-11-22 00:49:26', '666666', '2021-11-22 00:49:30', '1', NULL);
INSERT INTO `tbl_role` VALUES ('A86247E3DD4A4980BA4254577DE0C28D', '觉得偶然454', '666666', '2021-10-08 00:24:40', '666666', '2021-10-10 00:46:35', '2', '线程能的分开风干肉天报文为45');
INSERT INTO `tbl_role` VALUES ('C261B6E1EA1845029615AF964768EEA8', 'f', '666666', '2021-11-01 00:14:17', '666666', '2021-11-01 00:14:21', '1', 'c');
INSERT INTO `tbl_role` VALUES ('F8BE63A3E1404372989FEB97D13DC6A1', 'sdrw', '666666', '2021-10-07 00:06:59', NULL, '2021-10-07 00:18:15', '1', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_menu_relation`;
CREATE TABLE `tbl_role_menu_relation` (
  `id` varchar(32) NOT NULL COMMENT '角色与菜单关系ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(32) NOT NULL COMMENT '菜单ID',
  `create_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `role_menu_fk1` (`role_id`),
  KEY `role_menu_fk2` (`menu_id`),
  CONSTRAINT `role_menu_fk1` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_menu_fk2` FOREIGN KEY (`menu_id`) REFERENCES `tbl_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单的关系表';

-- ----------------------------
-- Records of tbl_role_menu_relation
-- ----------------------------
BEGIN;
INSERT INTO `tbl_role_menu_relation` VALUES ('0261BD83641545E4BC9BCE6BCFF34437', '1', '8075707DC0E74E3C81DFC7DB2EF9347A', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('031F52FE1DD7485F890BCA2CD56E2BB0', '1', '2A64BCD8F08B45A9A3BF144006780F08', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('0541CDD30DA444E7815A4965DC82791D', '1', '4', '666666', '2021-11-10 01:24:57', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('0564AF5205F24B2083DB8CC2EA32E4D1', '1', 'AB363B00FFE746B7A274F34E52E6F1D4', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('08FF5B582004426B97D948D16127B2DA', '1', '2A64BCD8F08B45A9A3BF144006780F08', '666666', '2021-11-10 01:24:57', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('0AE38EBF24074A10ACA4ED2666BDE6CA', '1', 'C59E2150467C464D8974154D2B3FDDB1', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('0DF56F71CCF940C19CADDAC14B1A7DBF', '11CBE4967EB94D3C8501649410DFF112', '8075707DC0E74E3C81DFC7DB2EF9347A', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('0E99A9C8D6B14549A5FC74C793EA15F5', '1', '4', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('0F578E4AA0EF41AB920C1CB8948D706F', '1', '9', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('151D14C8FB0B40F5A1F64CA8D5CAC572', '11CBE4967EB94D3C8501649410DFF112', '29A93A61ADF8428A9DABACDA7F7FC7E0', '666666', '2021-11-05 02:18:22', '666666', '2021-11-12 01:01:40', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('16E4A0C06AAD4A02A3872C95ADC6C5F0', '1', '329BDCBD5AD74CA99A2722968AA5BFDA', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('17B38B14B89149A5B9A2E456A30719B2', '1', 'C59E2150467C464D8974154D2B3FDDB1', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('17BCAA25689747C29593B6D99835EFBE', '1', '02B6B5C3A1B445979922C9D53DE0927D', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('17D0ACBAEDC34B85B589057B012AECDC', '1', '29A93A61ADF8428A9DABACDA7F7FC7E0', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('196298B543B54E0682754C4BEFCCD500', '1', '2A64BCD8F08B45A9A3BF144006780F08', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('1FC9FD4A71C740F989B9D8684ACD7BD6', '1', '29A93A61ADF8428A9DABACDA7F7FC7E0', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('211DF277E35E4BD8BDBE49CB043000B7', '1', '29A93A61ADF8428A9DABACDA7F7FC7E0', '666666', '2021-11-10 01:24:57', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('2157B21E8CB14C2586075120F3791660', '1', '1AEC2B1F18824D06A14CEF072538545A', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('23195B81645642DEA1ADDFBC0F1BD9C1', '1', '8', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('23D8923310DD40799352B6050428533B', '11CBE4967EB94D3C8501649410DFF112', '1', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('25A6EC78619348328A6089B7DC4CA121', '1', '6', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('26C85D5C36994AB581E86E29F8D65944', '1', '2A64BCD8F08B45A9A3BF144006780F08', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('28F0FDDD967344B28E45DF5E56AD3E18', '1', '5', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('28F2F87F487C4A2FA79F983CBBBD5F24', '1', 'C4FF51003E584E0F91391AC2AFE0FC9D', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('2AB17175C66B43BE8BDB81A3E6CA84BE', '1', '4', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('3251CB6F20244D34B5FFECC88D8890A5', '1', '329BDCBD5AD74CA99A2722968AA5BFDA', '666666', '2021-11-10 01:24:57', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('345EE5BE80314481A253B2BFB7A1EE47', '1', '2', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('347636785DF041CF9E0CE039C3C64F2A', '1', '6', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('34A310CCEFE04F7F99F82E8D0D604714', '1', '5', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('35B1BEE9D6F24183B7A06CD690EA7D93', '1', '8075707DC0E74E3C81DFC7DB2EF9347A', '666666', '2021-11-04 01:58:55', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('36C2A7EE2E5D40A8BD595C619E47F495', '1', '4', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('36CA2C36EA3843CABD1D33B8D0D2BA50', '1', 'C4FF51003E584E0F91391AC2AFE0FC9D', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('3A5BD2E18F3E46908A32A908354D2E4E', '1', '02B6B5C3A1B445979922C9D53DE0927D', '666666', '2021-12-05 23:22:57', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('3CF00FE3EA444EA0A734B2E643560A10', '11CBE4967EB94D3C8501649410DFF112', '8', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('3D239424D54F4789999BC818A136AAC6', '11CBE4967EB94D3C8501649410DFF112', '2', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('3E0236423929447EACD0C0546CDDD8C3', '1', 'C4FF51003E584E0F91391AC2AFE0FC9D', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('3E2958C72A094D04985FE0FDEBA30E70', '11CBE4967EB94D3C8501649410DFF112', '5', '666666', '2021-11-05 02:18:22', '666666', '2021-11-12 01:01:40', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('3EB9F6E1DD424D26B17F79FC6A5AFCD4', '1', 'B22E24BCB117465094F27193F2C070BF', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('44CFEB4B60CA43ADBB94F2D29ECC5FD9', '1', '5', '666666', '2021-11-10 01:24:57', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('4A5FCDCD0876480F9E716E7FADBFC994', '1', '640EF8CAA138431D842DDDD12C692B7A', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('4CF9813979A6437CB073B1B71FE13F91', '1', 'F9F2BF01330A435BA0D75907CBD69A18', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('4DCF6CF539624036B28EAE9F49533964', '1', '2A64BCD8F08B45A9A3BF144006780F08', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('503D3D03F6EA4460951B2569F3202522', '1', '3', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('50A09CA337CC4B9D9FEAEFFD679D23E9', '1', '28C9E8AC6ABF4E7BA0A6CE7D8A114D09', '666666', '2021-11-10 01:24:57', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('5105BC2B13F04BD08DC6045DF3FB060B', '11CBE4967EB94D3C8501649410DFF112', '29A93A61ADF8428A9DABACDA7F7FC7E0', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('5554A8CEF23242D589D37AFDDAB1B394', '1', 'C4FF51003E584E0F91391AC2AFE0FC9D', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('590278F2FCEB4514B04B06E544CB05FF', '1', 'C9F42A39651E48F0887EEE7E8B784BBC', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('590D252DEE8D4EBB9A526C6402D7C181', '1', '4', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('59BE98F0F7B94A2587339BA4CC5D79B4', '1', '329BDCBD5AD74CA99A2722968AA5BFDA', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('5A2814567BBC48D58DE7EDA7A3128291', '1', '8075707DC0E74E3C81DFC7DB2EF9347A', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('5B2720F8332A45819EA5EB6CE8D57479', '1', 'B22E24BCB117465094F27193F2C070BF', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('5E806562063B4DCAB96532B323BE735B', '1', 'C59E2150467C464D8974154D2B3FDDB1', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('5FF8DF2EC3814DF9A5C1B6A200C4D7A2', '1', 'C9F42A39651E48F0887EEE7E8B784BBC', '666666', '2021-11-10 01:24:57', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('61633B01305445DFA3B14C57D4BB7DF4', '1', '4A862D6004A949E5B72064E60E0F1820', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('62305808FB4146EF8F064AAADDDB40F7', '1', '8', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('62C95E31CA76415E88ECAF9523B5D00D', '11CBE4967EB94D3C8501649410DFF112', '2A64BCD8F08B45A9A3BF144006780F08', '666666', '2021-11-05 02:18:22', '666666', '2021-11-12 01:01:40', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('643648025C9842799A45CCC6F9CC6A28', '1', '6', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('65CD1FF51D2742568EC5E5764E3FDB66', '1', '29A93A61ADF8428A9DABACDA7F7FC7E0', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('67A631A492594CF09290EE0C3D2431F4', '1', '29A93A61ADF8428A9DABACDA7F7FC7E0', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('683EE7EE99F144E394E72B8BE7CF590C', '11CBE4967EB94D3C8501649410DFF112', '2A64BCD8F08B45A9A3BF144006780F08', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('6BACEA02E85F45CAABAD70256F89EADA', '11CBE4967EB94D3C8501649410DFF112', '28C9E8AC6ABF4E7BA0A6CE7D8A114D09', '666666', '2021-11-05 02:18:22', '666666', '2021-11-12 01:01:40', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('6D0C28A3B48D46B3A166029B2A6E50BE', '1', 'DAE20372C7B34E619B4278E05AD6A251', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('6E996781C90E4DE4860D31CBC99E2509', '1', '329BDCBD5AD74CA99A2722968AA5BFDA', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('70913610965D4D2E9926C7C1A36B7F96', '1', '2A64BCD8F08B45A9A3BF144006780F08', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('717348AED6954595A07B34198FD6FB89', '1', '2', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('7178202FA5FF4FEFA906073430CFDD4A', '1', '3', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('78256C27D3E34A1283528AABB22BE4AB', '11CBE4967EB94D3C8501649410DFF112', '28C9E8AC6ABF4E7BA0A6CE7D8A114D09', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('7C5964C1A6854454AF14184B5338C625', '1', '2A8B9D6453874843A20F425304891A81', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('7C8B4A13F42F4CBABBDAFB913E81EE16', '1', '8', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('7CA63D0B543A4A41B1C243F3FE4674ED', '1', '1', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('7DEBED461D6245BC92D38510DD8E1F5C', '1', '1', '666666', '2021-12-05 23:22:57', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('7F145DA5F4154ED499AA22A986F6827B', '1', '5', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('8077B7E2E9254BC2BF261014512A707F', '1', 'F9F2BF01330A435BA0D75907CBD69A18', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('81611219C10044CAA1D553586FAE772A', '11CBE4967EB94D3C8501649410DFF112', '329BDCBD5AD74CA99A2722968AA5BFDA', '666666', '2021-11-05 02:18:22', '666666', '2021-11-12 01:01:40', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('8268540F87AF4B26BC7436F8EB01F7FC', '1', '5', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('83D275073BBD4021BF24AD1D33BE0E3A', '11CBE4967EB94D3C8501649410DFF112', 'C59E2150467C464D8974154D2B3FDDB1', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('841FFE245B6B41C783441BC710EFB5E7', '11CBE4967EB94D3C8501649410DFF112', '8075707DC0E74E3C81DFC7DB2EF9347A', '666666', '2021-11-05 02:18:22', '666666', '2021-11-12 01:01:40', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('880864DD314446E5A2A0D5C89928799D', '11CBE4967EB94D3C8501649410DFF112', 'C59E2150467C464D8974154D2B3FDDB1', '666666', '2021-11-05 02:18:22', '666666', '2021-11-12 01:01:40', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('9076165B753E40169594585D15B87774', '11CBE4967EB94D3C8501649410DFF112', '329BDCBD5AD74CA99A2722968AA5BFDA', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('907837A5441D4AF2B72C7FF599E5C541', '1', '28C9E8AC6ABF4E7BA0A6CE7D8A114D09', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('9105192F508248DCA9ECD1B457944560', '1', '28C9E8AC6ABF4E7BA0A6CE7D8A114D09', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('933D8755636940AE8674A5EA7C57FB39', '1', '3', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('93AE360BBBED4CE9926ECF3C7B9697AE', '1', '84AEFBAD231E414FBF689F4BCF2064F7', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('95D99142CFF1434594C41A24F5D9982E', '1', '29A93A61ADF8428A9DABACDA7F7FC7E0', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('9853477116A34B32B780C776E66C9835', '11CBE4967EB94D3C8501649410DFF112', '6', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('995F37BF18D044EA914E1DE8659110AE', '1', 'DAE20372C7B34E619B4278E05AD6A251', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('9A5750CAFA9646C6BC2C1FAE408DD66C', '1', 'F9F2BF01330A435BA0D75907CBD69A18', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('9D17EE494A9C46EA97E4F2AEC32E26A8', '1', '8075707DC0E74E3C81DFC7DB2EF9347A', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('9D699D30C4644CBDB43A5B1FA7D55715', '1', '2', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('A2610E80C9FE46179DD4144F537FA161', '1', '8', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('A2EE4140284B4C9B9C3485762A321F7E', '1', '4', '666666', '2021-11-04 01:58:55', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('A3C30586884E474A89648D733FBB4439', '1', '640EF8CAA138431D842DDDD12C692B7A', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('A671019954BF453CA57C68AAB4800285', '1', '2A8B9D6453874843A20F425304891A81', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('A751C5A6274C43E59240FE3990210160', '1', 'C9F42A39651E48F0887EEE7E8B784BBC', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('A7E38B30227E4FDB86A39272E7240D41', '1', '28C9E8AC6ABF4E7BA0A6CE7D8A114D09', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('A7E512EBA24047E499B87B4AC5FA7A36', '1', 'DAE20372C7B34E619B4278E05AD6A251', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('AC6F2FA406454B269D6F264647ABE131', '1', '640EF8CAA138431D842DDDD12C692B7A', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('ACCCF8EA968341AF9113CF7B022CCE6D', '1', 'E96F2EFEAEB04339BB4B685F02E25061', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('AFB2E388243B4B82929863E857C87587', '1', '8075707DC0E74E3C81DFC7DB2EF9347A', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('B0F7849E176940CEA9EFE03993A5B986', '1', 'F5E119665CA04DF1811684D4F52CE04F', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('B1630A8FEBD9433F9894791F72BA44D3', '1', '329BDCBD5AD74CA99A2722968AA5BFDA', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('BAB4CB71A0C745D1A634D55ECDD2BD9B', '1', '02B6B5C3A1B445979922C9D53DE0927D', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('BC69385534D345758939832338A7E7BD', '1', 'EE71C54493334D3D86702AB33D616213', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('BC757C40984C496493E05A2E3B37B147', '11CBE4967EB94D3C8501649410DFF112', 'C4FF51003E584E0F91391AC2AFE0FC9D', '666666', '2021-11-05 02:18:22', '666666', '2021-11-12 01:01:40', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('BDD6171B209B472A94BE2AA9A28A3A10', '1', 'DAE20372C7B34E619B4278E05AD6A251', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('BF03218A9D0745BD9A4F4F40DE368A15', '1', '5', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('C1FF81FD60CF493FAAB47668D457C7F2', '1', '9', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('C49BB485C11543B8B44433F20DA6FC29', '1', 'C4FF51003E584E0F91391AC2AFE0FC9D', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('C53352728CF5456887FB956A4A1E6A6E', '1', 'B22E24BCB117465094F27193F2C070BF', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('C5464BA5F93649C29AED61AB730CFAB8', '11CBE4967EB94D3C8501649410DFF112', '9', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('C5DFB556046D4285B7D5AF68D5C716F5', '1', '9', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('CE81484987A148C7954F40F7A2C888A7', '1', 'C9F42A39651E48F0887EEE7E8B784BBC', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('D0B97C89E3A741ED98FA068B1434C0C4', '1', '329BDCBD5AD74CA99A2722968AA5BFDA', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('D2AA214001094A038573D47CE6825BC1', '1', '5D5FECCBEB8F498C808ECF36709B767D', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('D6E97F7A3289442480646BF4F65E7DCE', '1', 'B0167A92314A4356AD6FB543F44B854A', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('DA03EAEF067B406ABD3C772187351C59', '11CBE4967EB94D3C8501649410DFF112', 'C9F42A39651E48F0887EEE7E8B784BBC', '666666', '2021-11-05 02:18:22', '666666', '2021-11-12 01:01:40', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('DAB2F7378D854504AC83BD31FBC32EF2', '1', 'F9F2BF01330A435BA0D75907CBD69A18', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('DB6289E921A94899AB40BCF54C21AC17', '11CBE4967EB94D3C8501649410DFF112', '5', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('DB6D50A3EB764B679034E5E3BA5BE75D', '1', 'F9F2BF01330A435BA0D75907CBD69A18', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('DB9178D803EB4C99A0C5AD6940364395', '11CBE4967EB94D3C8501649410DFF112', '4', '666666', '2021-11-05 02:18:22', '666666', '2021-11-12 01:01:40', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('DD5E8D29BF36471A8F9169ACC8D6564A', '1', '4', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('DEB0B9CFFA1F48AAB1EAF6EABF76C90B', '1', '4', '666666', '2021-11-05 02:18:07', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('DF0B56FF9D994866AEC2AFEF89FE000C', '1', 'C4FF51003E584E0F91391AC2AFE0FC9D', '666666', '2021-11-10 01:24:57', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('E7BBDFD2CBDB45DCB8B1DE52BAF6EB3E', '1', 'C9F42A39651E48F0887EEE7E8B784BBC', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('E809011B8CB84E8F8482AB5EAF457A6A', '1', 'DA84C47521184288892D7A01AA06E40E', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('E9D0E12176284A90B460EBDEF69F6A41', '1', '1', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('EC79ECE432584259968E2F923563D9B3', '1', '28C9E8AC6ABF4E7BA0A6CE7D8A114D09', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('ED37C466EB894986B84CBF72F732F30F', '11CBE4967EB94D3C8501649410DFF112', '4', '666666', '2021-11-12 01:01:40', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('EE5AE7139EE449C49006E62C57DF11CE', '1', '999ECF06188E4418B19BFA562EAF864D', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('EEF400BD87D3474A85E59C079E99D10F', '1', '2', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('F119D6BD975743928E4FBB2FB49BB98D', '1', '1', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('F1214B8B9DB341479D39D206EFCCA21D', '1', 'B22E24BCB117465094F27193F2C070BF', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('F1830BEF4B2049F892F5979256043319', '1', '9', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('F1CCB7015A114913B7BD93D919A1F9DB', '1', 'C9F42A39651E48F0887EEE7E8B784BBC', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('F2B55F911B5B44D999B30B5A7EFBF5A9', '1', '3', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('F84A0F481ED9474FA09CA571543BA3AB', '1', 'C59E2150467C464D8974154D2B3FDDB1', '666666', '2021-11-10 01:50:37', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('FB72ADB8F92342B7BB6C7A439FC8A8BC', '1', 'C19CD584F56847C1A5E2035CCF8580EF', '666666', '2021-12-13 23:55:47', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('FB87A4DCDA0D427BB8A91AE15FE8AE88', 'A86247E3DD4A4980BA4254577DE0C28D', 'F9F2BF01330A435BA0D75907CBD69A18', '666666', '2021-11-06 23:39:27', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('FBC0D4D34A034FAD8FB132F23ABA5A8E', '1', 'C59E2150467C464D8974154D2B3FDDB1', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('FC042ECC854140B2BF7F009CB01CB7B4', '1', '640EF8CAA138431D842DDDD12C692B7A', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('FC646B929FBB4738A5ED7515377A34D4', '1', '6', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('FEB859B010BA49CA99B56ECE7A46253D', '1', '8075707DC0E74E3C81DFC7DB2EF9347A', '666666', '2021-12-05 23:22:58', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('FF10A1143136426E8E08F8C101710C53', '1', '84AEFBAD231E414FBF689F4BCF2064F7', '666666', '2021-12-06 00:50:14', '666666', '2021-12-13 23:55:47', '1', NULL);
INSERT INTO `tbl_role_menu_relation` VALUES ('FFA89ADAD4C94068960B93EE2C6AFB18', '1', '28C9E8AC6ABF4E7BA0A6CE7D8A114D09', '666666', '2021-11-10 01:47:53', '666666', '2021-12-13 23:55:47', '1', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_role_user_relation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_user_relation`;
CREATE TABLE `tbl_role_user_relation` (
  `id` varchar(32) NOT NULL COMMENT '角色与用户关系ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `create_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `role_user_fk1` (`role_id`),
  KEY `role_user_fk2` (`user_id`),
  CONSTRAINT `role_user_fk1` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`id`),
  CONSTRAINT `role_user_fk2` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与用户的关系表';

-- ----------------------------
-- Records of tbl_role_user_relation
-- ----------------------------
BEGIN;
INSERT INTO `tbl_role_user_relation` VALUES ('00B9252152D24092805FA9965165C1E2', 'A86247E3DD4A4980BA4254577DE0C28D', '130469', '666666', '2021-11-10 01:16:49', '666666', '2021-11-12 01:02:19', '1', NULL);
INSERT INTO `tbl_role_user_relation` VALUES ('17AF0F32769A44A4B569972C4A5A9259', '11CBE4967EB94D3C8501649410DFF112', '666666', '666666', '2021-11-22 00:46:56', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_user_relation` VALUES ('2D01ABC3B6FF4C599FCB0D286C5FC752', '1', '130469', '666666', '2021-11-10 01:16:49', '666666', '2021-11-12 01:02:19', '1', NULL);
INSERT INTO `tbl_role_user_relation` VALUES ('2D9DBB50371F46BF9341CE88C6A982A2', '1', '666666', '666666', '2021-11-10 01:54:00', '666666', '2021-11-22 00:46:56', '1', NULL);
INSERT INTO `tbl_role_user_relation` VALUES ('AC6895435E9846FABCA618BAD0707C57', '1', '107768', '666666', '2021-11-10 01:15:32', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_user_relation` VALUES ('BBF0ACF66B9C4DC4A8735D705B2E6984', '1', '130469', '666666', '2021-11-12 01:02:19', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_user_relation` VALUES ('C21FD59A25FA463D9BEA6868507C7D42', '11CBE4967EB94D3C8501649410DFF112', '666666', '666666', '2021-11-10 01:54:00', '666666', '2021-11-22 00:46:56', '1', NULL);
INSERT INTO `tbl_role_user_relation` VALUES ('E4CB5105E04E4BB7B80CAEF8D3BDA749', '1', '666666', '666666', '2021-11-22 00:46:56', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_user_relation` VALUES ('E87C2802E5D34AE1BB0A8BB1BEB0EF61', '11CBE4967EB94D3C8501649410DFF112', '130469', '666666', '2021-11-10 01:16:49', '666666', '2021-11-12 01:02:19', '1', NULL);
INSERT INTO `tbl_role_user_relation` VALUES ('F59784B510CC4FDA9813DF8F13F3587B', '11CBE4967EB94D3C8501649410DFF112', '107768', '666666', '2021-11-10 01:15:32', NULL, NULL, '2', NULL);
INSERT INTO `tbl_role_user_relation` VALUES ('F66563E512A0432C8541A0BBBE18A5CA', 'A86247E3DD4A4980BA4254577DE0C28D', '666666', '666666', '2021-11-22 00:46:56', NULL, NULL, '2', NULL);
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
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk1` (`spu_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`spu_id`) REFERENCES `tbl_spu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SKU产品表';

-- ----------------------------
-- Records of tbl_sku
-- ----------------------------
BEGIN;
INSERT INTO `tbl_sku` VALUES ('1', '黑色128G电信版苹果12', 'phone_12_11', 5894.00, '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku` VALUES ('2', '蓝色500G华为Mate11', 'mate11', 1000.00, '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku` VALUES ('3', '卫华1代电脑', 'HUAWEI_1', 5000.00, '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku` VALUES ('4', '华为2代电脑', 'HUAWEI_2', 60000.00, '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku` VALUES ('5', '烟熏肉1', 'yxr1', 100.00, '3', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku` VALUES ('6', '风干猪肉1', 'fgzr1', 150.00, '3', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_sku_property_option
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sku_property_option`;
CREATE TABLE `tbl_sku_property_option` (
  `id` varchar(255) NOT NULL COMMENT 'SKU-属性选项关联ID',
  `sku_id` varchar(255) DEFAULT NULL COMMENT 'SKU ID',
  `pro_opt_id` varchar(255) DEFAULT NULL COMMENT '属性选项ID',
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_sku_pro_opt_1` (`pro_opt_id`),
  KEY `fk_sku_pro_opt_2` (`sku_id`),
  CONSTRAINT `fk_sku_pro_opt_1` FOREIGN KEY (`pro_opt_id`) REFERENCES `tbl_property_options` (`id`),
  CONSTRAINT `fk_sku_pro_opt_2` FOREIGN KEY (`sku_id`) REFERENCES `tbl_sku` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SKU-属性选项关联表';

-- ----------------------------
-- Records of tbl_sku_property_option
-- ----------------------------
BEGIN;
INSERT INTO `tbl_sku_property_option` VALUES ('1', '1', '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_property_option` VALUES ('10', '1', '10', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_property_option` VALUES ('2', '1', '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_property_option` VALUES ('3', '1', '3', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_property_option` VALUES ('4', '1', '4', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_property_option` VALUES ('5', '1', '5', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_property_option` VALUES ('6', '1', '6', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_property_option` VALUES ('7', '1', '7', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_property_option` VALUES ('8', '1', '8', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_property_option` VALUES ('9', '1', '9', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_sku_specification_option
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sku_specification_option`;
CREATE TABLE `tbl_sku_specification_option` (
  `id` varchar(255) NOT NULL COMMENT 'ID',
  `sku_id` varchar(255) DEFAULT NULL COMMENT 'SKU ID',
  `spec_opti_id` varchar(255) DEFAULT NULL COMMENT '规格选项ID',
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_sku_s_o_1` (`sku_id`),
  KEY `fk_sku_s_o_2` (`spec_opti_id`),
  CONSTRAINT `fk_sku_s_o_1` FOREIGN KEY (`sku_id`) REFERENCES `tbl_sku` (`id`),
  CONSTRAINT `fk_sku_s_o_2` FOREIGN KEY (`spec_opti_id`) REFERENCES `tbl_specification_option` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SKU-规格选项关联表';

-- ----------------------------
-- Records of tbl_sku_specification_option
-- ----------------------------
BEGIN;
INSERT INTO `tbl_sku_specification_option` VALUES ('1', '1', '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_specification_option` VALUES ('2', '1', '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_specification_option` VALUES ('3', '1', '3', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_specification_option` VALUES ('4', '1', '4', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_specification_option` VALUES ('5', '1', '5', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_specification_option` VALUES ('6', '1', '6', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_sku_specification_option` VALUES ('7', '1', '7', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
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
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_speci_1` (`group_id`),
  KEY `fk_speci_type_id` (`type_id`),
  CONSTRAINT `fk_speci_1` FOREIGN KEY (`group_id`) REFERENCES `tbl_specification_group` (`id`),
  CONSTRAINT `fk_speci_type_id` FOREIGN KEY (`type_id`) REFERENCES `tbl_spu_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规格表';

-- ----------------------------
-- Records of tbl_specification
-- ----------------------------
BEGIN;
INSERT INTO `tbl_specification` VALUES ('1', '品牌', '1', '1', '1', '', '2022-01-01 01:45:03', '666666', '2022-01-06 00:56:13', '2', NULL);
INSERT INTO `tbl_specification` VALUES ('2', '型号', '1', '1', '2', '', '2022-01-01 01:45:08', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification` VALUES ('3', '颜色', '1', '1', '3', '', '2022-01-01 01:45:12', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification` VALUES ('4', '4G网络制式', '2', '1', '3', '', '2022-01-01 01:45:15', '666666', '2022-01-06 01:05:20', '2', '二人');
INSERT INTO `tbl_specification` VALUES ('5', '5G网络制式', '2', '1', '5', '', '2022-01-01 01:45:18', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification` VALUES ('6', '机身内存', '3', '1', '6', '', '2022-01-01 01:45:22', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification` VALUES ('7', '存储卡内省', '3', '1', '7', '', '2022-01-01 01:45:25', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification` VALUES ('DE546077192942A590EF3EB58F809179', '测试22', 'D03BA4DE066E46D086880802901F5190', '2', '4', '666666', '2022-01-05 00:51:55', '666666', '2022-01-06 01:12:56', '1', '还是说333');
COMMIT;

-- ----------------------------
-- Table structure for tbl_specification_group
-- ----------------------------
DROP TABLE IF EXISTS `tbl_specification_group`;
CREATE TABLE `tbl_specification_group` (
  `id` varchar(255) NOT NULL COMMENT '规格组ID',
  `name` varchar(50) DEFAULT NULL COMMENT '规格组名称',
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规格组表';

-- ----------------------------
-- Records of tbl_specification_group
-- ----------------------------
BEGIN;
INSERT INTO `tbl_specification_group` VALUES ('1', '主体2', '', '2021-12-30 01:14:18', '666666', '2022-01-01 01:33:20', '2', 'fvf ffg三顿饭');
INSERT INTO `tbl_specification_group` VALUES ('2', '主体', '', '2021-12-30 01:14:22', '666666', '2022-01-01 01:27:56', '2', NULL);
INSERT INTO `tbl_specification_group` VALUES ('3', '存储', '', '2021-12-30 01:14:27', '666666', '2022-01-01 01:06:01', '1', NULL);
INSERT INTO `tbl_specification_group` VALUES ('D03BA4DE066E46D086880802901F5190', '哈哈', '666666', '2022-01-01 01:06:15', '666666', '2022-01-01 01:06:29', '2', '哈哈哈二');
INSERT INTO `tbl_specification_group` VALUES ('F1459C28212C4D81B0270CABA294C927', '覆盖', '666666', '2021-12-31 00:36:14', '666666', '2022-01-01 01:05:56', '1', NULL);
INSERT INTO `tbl_specification_group` VALUES ('F5E51F4F72C14588BF0D0491CE033038', 'fj', '666666', '2021-12-31 00:39:04', '666666', '2022-01-01 01:23:20', '1', '缴');
COMMIT;

-- ----------------------------
-- Table structure for tbl_specification_option
-- ----------------------------
DROP TABLE IF EXISTS `tbl_specification_option`;
CREATE TABLE `tbl_specification_option` (
  `id` varchar(255) NOT NULL COMMENT '规格选项ID',
  `value` varchar(100) DEFAULT NULL COMMENT '选项值',
  `spec_id` varchar(255) DEFAULT NULL COMMENT '规格ID',
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_speci_o_1` (`spec_id`),
  CONSTRAINT `fk_speci_o_1` FOREIGN KEY (`spec_id`) REFERENCES `tbl_specification` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规格选项表';

-- ----------------------------
-- Records of tbl_specification_option
-- ----------------------------
BEGIN;
INSERT INTO `tbl_specification_option` VALUES ('1', '苹果', '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification_option` VALUES ('2', '爱疯6plus', '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification_option` VALUES ('3', '灰色', '3', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification_option` VALUES ('4', '移动联通4G', '4', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification_option` VALUES ('5', '联通5G', '5', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification_option` VALUES ('6', '8G', '6', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_specification_option` VALUES ('7', '32G', '7', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
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
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_spu1` (`brand_id`),
  KEY `fk_spu2` (`type_id`),
  CONSTRAINT `fk_spu1` FOREIGN KEY (`brand_id`) REFERENCES `tbl_spu_brand` (`id`),
  CONSTRAINT `fk_spu2` FOREIGN KEY (`type_id`) REFERENCES `tbl_spu_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='SPU货品表';

-- ----------------------------
-- Records of tbl_spu
-- ----------------------------
BEGIN;
INSERT INTO `tbl_spu` VALUES ('1', '手机', 'shouji', '这是好用的手机', '这是手机的详细信息说明', '1', '1', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_spu` VALUES ('2', '电脑', 'diannao_01', '这电脑好用', '打电脑', '2', '2', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_spu` VALUES ('3', '烟熏肉', 'yznxurou_01', '超级好吃的烟熏肉', '这是5年老腊肉，做法多多', '3', '3', '', '0000-00-00 00:00:00', NULL, NULL, '2', NULL);
COMMIT;

-- ----------------------------
-- Table structure for tbl_spu_brand
-- ----------------------------
DROP TABLE IF EXISTS `tbl_spu_brand`;
CREATE TABLE `tbl_spu_brand` (
  `id` varchar(255) NOT NULL COMMENT '品牌ID',
  `name` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `code` varchar(50) DEFAULT NULL COMMENT '品牌编码',
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货品品牌表';

-- ----------------------------
-- Records of tbl_spu_brand
-- ----------------------------
BEGIN;
INSERT INTO `tbl_spu_brand` VALUES ('1', '苹果', 'Apple', '', NULL, NULL, '2', NULL, '0000-00-00 00:00:00');
INSERT INTO `tbl_spu_brand` VALUES ('2', '华为', 'HUAWEI', '', NULL, NULL, '2', NULL, '0000-00-00 00:00:00');
INSERT INTO `tbl_spu_brand` VALUES ('3', '哈哈', 'haha', '', NULL, NULL, '2', NULL, '0000-00-00 00:00:00');
COMMIT;

-- ----------------------------
-- Table structure for tbl_spu_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_spu_type`;
CREATE TABLE `tbl_spu_type` (
  `id` varchar(255) NOT NULL COMMENT '货品类型ID',
  `name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `code` varchar(50) DEFAULT NULL COMMENT '类型编码',
  `create_user` varchar(6) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(6) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货品类型表';

-- ----------------------------
-- Records of tbl_spu_type
-- ----------------------------
BEGIN;
INSERT INTO `tbl_spu_type` VALUES ('1', '手机', 'spu_shouji', '', '2022-01-03 17:23:00', NULL, NULL, '2', NULL);
INSERT INTO `tbl_spu_type` VALUES ('18EB9A53B09D45DABDCCCD6BFBD8C690', 'grgr哈哈哈', 'sdsd', '666666', '2022-01-09 12:14:59', '666666', '2022-01-10 13:31:34', '1', 'erer哈哈哈');
INSERT INTO `tbl_spu_type` VALUES ('2', '电脑', 'spu_diannao', '', '2022-01-03 17:23:05', NULL, NULL, '2', NULL);
INSERT INTO `tbl_spu_type` VALUES ('3', '腊肉', 'spu_larou', '', '2022-01-03 17:23:09', NULL, NULL, '2', NULL);
INSERT INTO `tbl_spu_type` VALUES ('3D8604F05EE74AE9803617E7581C4C2E', '水果', 'shuiguo', '666666', '2022-01-10 00:14:34', NULL, NULL, '2', '这是水果');
INSERT INTO `tbl_spu_type` VALUES ('99D84F19D1F846509490B780A9FF94EA', '牛肉', 'niurou', '666666', '2022-01-10 00:15:36', NULL, NULL, '2', '带你飞分局就覅大V发v看看发v费率发v发v就覅发v方面你发VN发vv带你飞分局就覅大V发v看看发v费率发v发v就覅发v方面你发VN发vv带你飞分局就覅大V发v看看发v费率发v发v就覅发v方面你发VN发vv带你飞分局就覅大V发v看看发v费率发v发v就覅发v方面你发VN发vv带你飞分局就覅大V发v看看发v费率发v发v就覅发v方面你发VN发vv带你飞分局就覅大V发v看看发v费率发v发v就覅发v方面你发VN发vv');
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
  `del_tag` varchar(2) NOT NULL DEFAULT '2' COMMENT '删除标志[1: 删除; 2: 保留]',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
BEGIN;
INSERT INTO `tbl_user` VALUES ('107768', '134', '1', '666666', '2021-05-18 00:35:06', '666666', '2021-11-12 01:02:53', 1, NULL, '2021-11-01', '1', '1', '1', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('112619', '45', '45', '666666', '2021-05-29 00:56:10', NULL, '2021-06-17 01:32:11', 1, '2', NULL, '34', 'e', NULL, NULL, '/Users/wangsheng/headPortrai/出租车3.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('117621', 'dfe', NULL, '666666', '2021-05-29 02:17:23', '666666', '2021-09-07 00:30:08', 1, '2', '2021-09-08', '1', '1', '1', '7', '/Users/wangsheng/headPortrai/117621-/AADA0184464D47889193F82F6B610D9B..jpeg.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('130469', '小张', '123333', '666666', '2021-05-18 00:33:02', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('150259', '666', '66', '666666', '2021-06-02 13:22:08', NULL, NULL, 3, '2', NULL, '6', '6', '6', '8', '/Users/wangsheng/headPortrai/150259_BBE0F53B47534BA2A083F93AFE7B140A.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('162240', '34', '34', '666666', '2021-05-29 02:23:36', NULL, NULL, 1, '2', NULL, NULL, NULL, NULL, NULL, '/Users/wangsheng/headPortrai/162240-16AB06159C2643F78F2B8FE12011BBA4.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('162420', 'wangsheng5', '666666', NULL, '2021-07-08 01:08:58', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('167884', 'rrrr', '666666', NULL, '2021-08-25 00:31:28', NULL, NULL, 3, '2', NULL, 'r', 'r', 'r', '6', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('172492', '2', '123456', '666666', '2021-05-27 00:39:53', NULL, NULL, 1, '1', NULL, '2', '2', '2', '3', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('182454', '王健林', '111111', '666666', '2021-05-17 23:40:04', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('183974', '张闪闪', '666666', NULL, '2021-09-30 21:12:51', NULL, NULL, 5, '1', NULL, '112', '1212', '121@qq.com', '1', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('188148', 'wangsheng2', '666666', NULL, '2021-07-08 01:04:39', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('2', '张杰', '111111', '666666', '2021-04-26 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('221093', '555', '666666', NULL, '2021-08-25 01:23:40', NULL, NULL, 1, '2', NULL, '5', '5', '5', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('239525', '1', '666666', NULL, '2021-07-08 01:37:48', NULL, NULL, 1, '2', NULL, '1', '1', '1', '1', '/Users/wangsheng/headPortrai/239525_32EA60CD43A6443DAAD9AA863D7CC562.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('252190', '小明', '111111', '666666', '2021-05-18 00:31:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('320992', NULL, NULL, '666666', '2021-06-27 01:15:30', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('325522', 'liming', '123456', '666666', '2021-06-27 11:35:24', NULL, NULL, 1, '2', NULL, '1', '1', '1', '5', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('337172', 'zhangjie', '123456', '666666', '2021-06-27 11:29:17', NULL, NULL, 9, '2', NULL, '1', '1', '1', '7', '/Users/wangsheng/headPortrai/337172_D52F292B18DF4AE197C3C673A7FA8EA8.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('343146', '34', '34', '666666', '2021-05-29 02:19:50', NULL, NULL, 1, '2', NULL, NULL, NULL, NULL, NULL, '/Users/wangsheng/headPortrai/343146-9891F842CE5B4C08B5070AE99692B221.jpeg.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('346266', NULL, NULL, '666666', '2021-06-27 01:22:13', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, '/Users/wangsheng/headPortrai/346266_92BBAB8148484D668A2F95C6CF6B76CC.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('361983', 'zhangchunjie', '666666', NULL, '2021-09-30 21:08:02', NULL, NULL, 3, '1', NULL, '12', '12', '12@qq.com', '8', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('390175', '3232', '666666', NULL, '2021-07-08 01:12:09', NULL, NULL, 1, '2', NULL, '1', '1', '1', '8', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('395823', '晓东', '333333', '666666', '2021-05-18 00:34:02', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('450977', '33', '33', '666666', '2021-05-27 00:47:32', NULL, NULL, 3, '2', NULL, '33', '333', '33', '6', '/Users/wangsheng/headPortrai/出租1.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('523964', 'er', 'df', '666666', '2021-05-29 00:46:19', NULL, NULL, 3, '2', NULL, 'e', 'd', '1', '6', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('528107', 'wangsheng1', '666666', NULL, '2021-07-08 01:01:57', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('540861', 'wangsheng4', '666666', NULL, '2021-07-08 01:06:57', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('600928', NULL, NULL, '666666', '2021-06-27 01:14:18', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('611520', '刘备2', '666666', NULL, '2021-07-11 00:30:31', '666666', '2021-08-29 02:40:22', 96, '2', '2021-08-10', '11', '11', '11@qq.com', '7', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('613426', 'wangsheng3', '666666', NULL, '2021-07-08 01:05:41', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('624614', 'ereir', '666666', '666666', '2021-09-30 21:23:48', '666666', '2021-09-30 21:24:19', 3, '2', '2021-09-08', '1', '34', '23', '6', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('625288', '1', '1', '666666', '2021-05-18 00:36:26', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('630163', 'wangsheng5', '666666', NULL, '2021-07-08 01:08:37', NULL, NULL, 3, '1', NULL, '1', '1', '1', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('666666', '组件', '123456', '4567', '2020-11-13 00:19:41', '234', '2021-07-11 00:29:41', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('705089', '88888', '88888888', '666666', '2021-06-02 01:33:49', NULL, NULL, 8, '2', NULL, '88', '88', '88', '5', '/Users/wangsheng/headPortrai/705089_6C51DC7856F642739ABD791983E6B836.jpg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('722762', '刘备', '666666', NULL, '2021-07-11 00:31:10', '666666', '2021-08-29 02:41:08', 100, '2', '2021-08-11', '1', '1', '1@qq.com', '1', '/Users/wangsheng/headPortrai/722762_21EE6E5EDB534EE2967B05C5E7036C30.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('727250', 'qqww', '666666', NULL, '2021-09-30 21:19:41', NULL, NULL, 3, '2', NULL, 'q', 'q', 'q', '5', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('739813', '小明', '111111', '666666', '2021-05-18 00:27:01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('755849', 'wwww', 'wwww', '666666', '2021-06-02 00:36:57', NULL, NULL, 3, '2', NULL, 'www', 'www', 'ww', '5', '/Users/wangsheng/headPortrai/755849_12F35D59D6F043EFBCC58117C0649DB3.jpg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('775217', '王麻子', '666666', '666666', '2021-06-29 00:49:56', NULL, NULL, 1, '2', NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('781488', '2', '2', '666666', '2021-05-18 00:41:44', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('788254', '中', '666666', NULL, '2021-09-24 00:48:04', NULL, NULL, 1, '1', NULL, '1', '2', '3', '7', '/Users/wangsheng/headPortrai/788254_0DBBB810E4554AEBB3012C7B2CDD70C1.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('794722', NULL, NULL, '666666', '2021-05-29 02:17:38', NULL, NULL, 1, '2', NULL, '1', '1', '1', '8', '/Users/wangsheng/headPortrai/794722-9F999EEFFBD84E6F85B0C30B9FFEB2C0..jpeg.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('794783', '3444', '444', '666666', '2021-06-02 13:21:12', NULL, NULL, 5, '2', NULL, '44', '44', '44', '2', '/Users/wangsheng/headPortrai/794783_123E2C64E8D844AC830052E4A8E2C3ED.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('805061', '12', '666666', NULL, '2021-07-08 01:35:58', NULL, NULL, 1, '2', NULL, '1', '1', '1', '3', '/Users/wangsheng/headPortrai/805061_659FFCDF819B4443A9092031BED9DCF9.jpeg', '2', NULL);
INSERT INTO `tbl_user` VALUES ('818917', 'as', '34', '666666', '2021-05-29 00:52:44', NULL, NULL, 3, '2', NULL, '23', '34', '34', '4', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('857177', '555', '666666', NULL, '2021-08-25 01:23:20', NULL, NULL, 1, '2', NULL, '5', '5', '5', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('888888', '小明waz', '123456', '234', '2020-11-13 00:17:31', '666666', '2020-12-14 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('919798', 'hhh', '666666', NULL, '2021-07-08 01:10:14', NULL, NULL, 1, '2', NULL, 'q', 'q', 'q', '1', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('926854', NULL, NULL, '666666', '2021-06-27 01:18:01', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('949628', 'pp', '666666', NULL, '2021-08-25 01:33:04', NULL, NULL, 1, '1', NULL, '1', '1', '1', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('973852', 'as', 'we', '666666', '2021-05-29 00:47:52', NULL, NULL, 3, '2', NULL, 'we', 'we', 'we', '5', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('974738', '12', '12', '666666', '2021-05-27 00:42:26', NULL, NULL, 11, '2', NULL, '12', '21', '21', '7', NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('980812', '王校长', '111111', '666666', '2021-05-17 23:14:15', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('981191', '王健林', '111111', '666666', '2021-05-17 23:40:11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL);
INSERT INTO `tbl_user` VALUES ('993443', '1', '1', '666666', '2021-05-27 00:37:01', NULL, NULL, 3, '1', NULL, '1', '1', '1', '8', NULL, '2', NULL);
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
INSERT INTO `tbl_user_likes` VALUES ('081AF0920EA94389A65DDA2BCBBB8395', '2', '727250', '666666', '2021-09-30 21:19:41', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('08A66A2CBED542DC91B0E8B2531C54F4', '1', '949628', '666666', '2021-08-25 01:33:16', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('0A6E078ECBD44791BC65CED4EC158FC4', '3', '788254', '666666', '2021-09-24 00:48:04', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('0B3EFD7333EA43CC848E146FA17E7139', '1', '182454', '182454', '2021-05-17 23:40:04', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('0C46140BCD944BA99E49EC03F71E2D22', '2', '337172', '337172', '2021-06-27 11:29:17', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('1', '1', '2', NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('137338D9A0E04AB1B786EB4528726D36', '1', '980812', '980812', '2021-05-17 23:14:25', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('14E49EDBC2EC442D94B915A224A65323', '3', '337172', '337172', '2021-06-27 11:29:17', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('1815297E42D24A008CB1617132223CC8', '1', '788254', '666666', '2021-09-24 00:48:04', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('2', '2', '2', NULL, NULL, NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('21B21082D4AE453D95CAFF5A2A46B84E', '1', '172492', '172492', '2021-05-27 00:39:53', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('237AE4761D9A4609B06F9141A220D88F', '2', '818917', '818917', '2021-05-29 00:52:44', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('35C897155EC343628DB0E799B68709EF', '1', '739813', '739813', '2021-05-18 00:27:01', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('3A89F9B085134AC1833AD9C6A156A398', '3', '973852', '973852', '2021-05-29 00:47:52', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('3D0C640923CE44ADB71007C4FDB72D81', '1', '625288', '625288', '2021-05-18 00:36:26', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('426E2651437742D78AE57039A8936DE6', '1', '630163', '630163', '2021-07-08 01:08:40', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('42A29292075542198B24B10DAFA3BBCD', '3', '705089', '705089', '2021-06-02 01:33:49', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('443D68A3AC1B480FA510C11AAF076407', '1', '395823', '395823', '2021-05-18 00:34:02', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('4A9A64BA83154D82A5440D0F5F5C7792', '3', '523964', '523964', '2021-05-29 00:46:19', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('4D49D793D5164F4293B898E462A2B2BB', '1', '993443', '993443', '2021-05-27 00:37:01', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('5434CB12DD6E4595A0F5DE5B57B81E22', '2', '775217', '775217', '2021-06-29 00:49:56', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('57DCB8D0A2F14ACBA83E4AC3EB8AAF39', '3', '167884', '167884', '2021-08-25 00:31:28', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('5CE4B0EB455E4BC090441554BBAE1FEE', '2', '788254', '666666', '2021-09-24 00:48:04', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('60FED025D8894ACF91FEC127D59EA16C', '2', '755849', '755849', '2021-06-02 00:36:57', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('6A6DDF74BBA44188B073DBA04A5AEA8C', '1', '361983', '', '2021-09-30 21:08:02', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('6DAF47F9FA90422E96C019F96FEB54EE', '2', '974738', '974738', '2021-05-27 00:42:26', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('6FAD2A23D6AE48B3B21F20D2C7AF481D', '3', '130469', '130469', '2021-05-18 00:33:02', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('704F64922658487F9DF25BD1F9680BE4', '2', '150259', '150259', '2021-06-02 13:22:08', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('72ECD862463247CB9149D4F08FB3715D', '1', '107768', '666666', '2021-11-12 01:02:53', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('7659FE7BF1E74C8EA5961E5A11863D0A', '2', '343146', '343146', '2021-05-29 02:19:50', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('799EE3F65E634489BCEBB014784E890B', '2', '182454', '182454', '2021-05-17 23:40:04', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('7A11F89938B147A39267567C610E1D00', '2', '980812', '980812', '2021-05-17 23:14:29', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('7A530484E8D04892B8C09F1E3129ECCC', '1', '183974', '666666', '2021-09-30 21:12:51', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('7D6C0937EC9440C78AE2C709DF38ECBC', '2', '794783', '794783', '2021-06-02 13:21:12', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('815F58C147A647FDB69D3D6455E3E65E', '2', '112619', '112619', '2021-05-29 00:56:10', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('8634B4792EAB47458FE7EF0AB646AC08', '3', '755849', '755849', '2021-06-02 00:36:57', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('8A5EFFCDFB084C5AA86E0B343D51FE5E', '2', '325522', '325522', '2021-06-27 11:35:24', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('8AE0A5B2BB334C3CAF624C240487F64E', '1', '162420', '162420', '2021-07-08 01:08:58', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('8D9BDA52CD9F45639425E1D568904CC1', '2', '705089', '705089', '2021-06-02 01:33:49', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('986FF42357CB4230A0E7526ADC48CE9D', '2', '981191', '981191', '2021-05-17 23:40:11', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('A0B75E33BF0A403AB9186BBB9FC565B8', '1', '981191', '981191', '2021-05-17 23:40:11', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('A1B3AE73F3594E259BB3C9B2781DE83A', '2', '221093', '', '2021-08-25 01:23:40', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('A4E4C49F44684896BD3C143A214E0535', '2', '239525', '239525', '2021-07-08 01:37:48', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('AB9452622F7E4B918C4E56FFEE73E32F', '2', '117621', '666666', '2021-09-07 00:30:08', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('B3FF2861563F4241924B67BF4403687A', '2', '805061', '805061', '2021-07-08 01:35:58', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('B91ADC68B1B3412BBE23406526A74087', '1', '611520', '666666', '2021-08-29 02:40:22', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('BA98D34E31014E1D9C995D410B94AE9D', '1', '390175', '390175', '2021-07-08 01:12:09', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('BAEB1780518840CB9CFEBA5FCEE9EDFE', '2', '252190', '252190', '2021-05-18 00:31:17', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('BC36ED204DBB4EDF8D4453A6C2FD1D9E', '2', '162240', '162240', '2021-05-29 02:23:36', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('C7D6A1511401486D9217BA5EA07F2531', '3', '980812', '980812', '2021-05-17 23:14:31', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('EBF961CB72964F66BB1419A10B2024D2', '3', '395823', '395823', '2021-05-18 00:34:02', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('EFBEB51D0D7F463C8B232333C06D5382', '1', '781488', '781488', '2021-05-18 00:41:44', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('F061E81E1B484A079E0FD20836E527A6', '2', '722762', '666666', '2021-08-29 02:41:08', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('F0730C3472124DD1902D802B177D2828', '2', '857177', '', '2021-08-25 01:23:32', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('F34A089EA61B4E3DB92D7A3BF053BEE3', '3', '624614', '666666', '2021-09-30 21:24:19', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('F73525F30E33487295F171BECB3D581C', '2', '450977', '450977', '2021-05-27 00:47:32', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('FAA43215F81946A2ADA24C9B1340D0B4', '2', '794722', '794722', '2021-05-29 02:17:38', NULL, NULL);
INSERT INTO `tbl_user_likes` VALUES ('FB6426DCB18A454AB0327929F87749C7', '1', '755849', '755849', '2021-06-02 00:36:57', NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE `api`.`tbl_sku`
ADD COLUMN `sku_number` int(50) NOT NULL COMMENT '产品数量' AFTER `remark`;