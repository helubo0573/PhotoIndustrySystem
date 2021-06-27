/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : photoindustry_system

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2021-06-27 22:35:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `company_info`
-- ----------------------------
DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_info
-- ----------------------------

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT '0' COMMENT '上级ID',
  `menu_name` varchar(20) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(50) DEFAULT NULL COMMENT '请求串',
  `perms` varchar(50) DEFAULT NULL COMMENT '授权标识',
  `menu_type` tinyint(4) DEFAULT '0' COMMENT '资源类型 0:目录 1:菜单 2:限权',
  `menu_icon` varchar(20) DEFAULT NULL COMMENT '标图代码',
  `menu_order` int(11) DEFAULT '0' COMMENT '排序编号',
  `company_id` varchar(18) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL COMMENT '注备',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` varchar(18) DEFAULT NULL,
  `dept_id` int(11) DEFAULT '0' COMMENT '所属部门id',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '单菜ID',
  `company_id` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单映射表';

-- ----------------------------
-- Records of role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `user_password` varchar(128) NOT NULL DEFAULT '' COMMENT '用户密码',
  `user_mobile` varchar(11) DEFAULT '0' COMMENT '电话号码',
  `user_email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `company_id` varchar(18) DEFAULT NULL,
  `register_date` datetime DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '用户状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `company_id` varchar(18) DEFAULT NULL COMMENT '公司ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色映射表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
