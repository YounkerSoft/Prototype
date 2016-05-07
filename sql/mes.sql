/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : mes

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2016-04-07 20:33:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `machine`
-- ----------------------------
DROP TABLE IF EXISTS `machine`;
CREATE TABLE `machine` (
  `brand` varchar(255) NOT NULL COMMENT '机器品牌',
  `model` varchar(255) NOT NULL COMMENT '型号',
  `products` varchar(255) NOT NULL COMMENT '可生产产品列表',
  PRIMARY KEY (`brand`,`model`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of machine
-- ----------------------------
INSERT INTO `machine` VALUES ('stoll', 'stoll_1', '1;2;3');
INSERT INTO `machine` VALUES ('stoll', 'stoll_2', '2;3');

-- ----------------------------
-- Table structure for `sku`
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `id` int(11) NOT NULL,
  `sku` varchar(255) NOT NULL COMMENT 'sku',
  `spu` varchar(255) NOT NULL COMMENT 'spu',
  `parts` varchar(255) NOT NULL COMMENT 'SKU包含前后袖子等；以;分隔',
  `materials` varchar(255) NOT NULL COMMENT '所需原材料；以x,x,x;m,m,m分隔',
  `materialsamount` varchar(255) NOT NULL COMMENT '所需原材料数量；以x,x,x;m,m,m分隔',
  `requiredTime` varchar(255) NOT NULL COMMENT '不同机器生产该部分所需要的时间，以M:t,t,t;M:t,t,t分隔',
  PRIMARY KEY (`sku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sku
-- ----------------------------
INSERT INTO `sku` VALUES ('1', '1', '1', '1;2;3', 'r,g;r,g;r,g,b', '20,30;20,30;10,20,30', 'stoll_1:10,10,16');
INSERT INTO `sku` VALUES ('2', '2', '1', '1;2', 'r;r', '20;20', 'stoll_1:15,15');
INSERT INTO `sku` VALUES ('3', '3', '1', '1', 'r', '10', 'stoll_1:10');
INSERT INTO `sku` VALUES ('4', '4', '2', '1;2;3', 'b;b;b', '20;20;20', 'stoll_2:10,10,12');
INSERT INTO `sku` VALUES ('5', '5', '2', '1;2', 'g;g', '15;15', 'stoll_2:5,5');

-- ----------------------------
-- Table structure for `spu`
-- ----------------------------
DROP TABLE IF EXISTS `spu`;
CREATE TABLE `spu` (
  `id` int(11) NOT NULL,
  `spu` varchar(255) NOT NULL COMMENT 'spu',
  `skus` varchar(255) NOT NULL COMMENT 'spu所包含的skus，以;分隔',
  `machines` varchar(255) DEFAULT NULL COMMENT '能生产该产品的机器，以;分隔',
  PRIMARY KEY (`spu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of spu
-- ----------------------------
INSERT INTO `spu` VALUES ('1', '1', '1;2;3', 'stoll_1');
INSERT INTO `spu` VALUES ('2', '2', '4;5', 'stoll_2');
