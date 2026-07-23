/*
 Navicat Premium Data Transfer

 Source Server         : link1
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : db_emp2

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 14/05/2024 17:02:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`,`name`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_department
-- ----------------------------
BEGIN;
INSERT INTO `tb_department` VALUES (1, '教学部', '北京总部');
INSERT INTO `tb_department` VALUES (2, '运营部', '北京总部');
INSERT INTO `tb_department` VALUES (3, '品保部', '北京总部');
INSERT INTO `tb_department` VALUES (4, '院校K战区', '河南');
INSERT INTO `tb_department` VALUES (5, '院校G战区', '江西');
INSERT INTO `tb_department` VALUES (6, '院校X战区', '山东');
INSERT INTO `tb_department` VALUES (7, '人力部', '北京总部');
INSERT INTO `tb_department` VALUES (8, '行政部', '北京总部');
INSERT INTO `tb_department` VALUES (9, '实训部', '北京总部');
COMMIT;

-- ----------------------------
-- Table structure for tb_emp
-- ----------------------------
DROP TABLE IF EXISTS `tb_emp`;
CREATE TABLE `tb_emp` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salary` decimal(10,2) NOT NULL DEFAULT '0.00',
  `age` int NOT NULL,
  `face` varchar(255) DEFAULT NULL,
  `depid` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`,`username`) USING BTREE,
  KEY `f1` (`depid`),
  CONSTRAINT `f1` FOREIGN KEY (`depid`) REFERENCES `tb_department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_emp
-- ----------------------------
BEGIN;
INSERT INTO `tb_emp` VALUES (10, '新员工-43', 10732.73, 25, NULL, 1);
INSERT INTO `tb_emp` VALUES (11, '新员工-0', 10588.00, 26, NULL, 1);
INSERT INTO `tb_emp` VALUES (12, 'Steven', 18000.00, 28, NULL, 1);
INSERT INTO `tb_emp` VALUES (22, '新员工-29', 18725.00, 41, NULL, 1);
INSERT INTO `tb_emp` VALUES (23, '新员工-61', 14239.00, 33, NULL, 1);
INSERT INTO `tb_emp` VALUES (24, '新员工-23', 13979.00, 36, NULL, 1);
INSERT INTO `tb_emp` VALUES (25, '新员工-87', 10637.00, 43, NULL, 1);
INSERT INTO `tb_emp` VALUES (26, 'Steven-85', 18000.00, 28, NULL, 1);
INSERT INTO `tb_emp` VALUES (28, '新员工-2', 17414.00, 36, NULL, 1);
INSERT INTO `tb_emp` VALUES (29, '新员工-78', 13009.00, 43, NULL, 1);
INSERT INTO `tb_emp` VALUES (30, '新员工-83', 15016.00, 44, NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `u_id` int NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `u_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `u_gender` smallint DEFAULT NULL,
  `reg_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
