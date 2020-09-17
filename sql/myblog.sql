/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 17/09/2020 14:06:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_blog
-- ----------------------------
DROP TABLE IF EXISTS `m_blog`;
CREATE TABLE `m_blog`  (
  `id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '博客id',
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '博客标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '简介内容',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容',
  `gmt_created` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `status` tinyint(0) NOT NULL COMMENT '发布状态',
  `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
  `is_delete` tinyint(1) NOT NULL COMMENT '逻辑删除1删除，0未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of m_blog
-- ----------------------------
INSERT INTO `m_blog` VALUES ('1305416753169346562', '1305410190455115778', '抖音文案', '我的第一篇博客', '愿时光能缓，愿故人不散；愿你惦念的人能和你道晚安，愿你独闯的日子里不觉得孤单。', '2020-09-14 16:03:02', 0, '2020-09-14 16:03:02', 0);
INSERT INTO `m_blog` VALUES ('1305421144253382658', '1305410190455115778', '更新', '更新', '更新', '2020-09-14 16:20:29', 0, '2020-09-16 12:01:45', 0);
INSERT INTO `m_blog` VALUES ('1305421186011873281', '1305410190455115778', '抖音文案3', '博客3', '找一个不仅仅只会对你说晚安的人 早安比晚安更珍贵 因为没人会一醒来就想到你 ​​', '2020-09-14 16:20:39', 0, '2020-09-14 16:20:39', 0);
INSERT INTO `m_blog` VALUES ('1305421219239149569', '1305410190455115778', '抖音文案4', '博客4', '找一个不仅仅只会对你说晚安的人 早安比晚安更珍贵 因为没人会一醒来就想到你 ​​', '2020-09-14 16:20:47', 0, '2020-09-14 16:20:47', 0);
INSERT INTO `m_blog` VALUES ('1305421254978813953', '1305410190455115778', '抖音文案5', '博客5', '找一个不仅仅只会对你说晚安的人 早安比晚安更珍贵 因为没人会一醒来就想到你 ​​', '2020-09-14 16:20:55', 0, '2020-09-14 16:20:55', 0);
INSERT INTO `m_blog` VALUES ('1305421302579970050', '1305410190455115778', '抖音文案6', '博客6', '找一个不仅仅只会对你说晚安的人 早安比晚安更珍贵 因为没人会一醒来就想到你 ​​', '2020-09-14 16:21:07', 0, '2020-09-14 16:21:07', 0);
INSERT INTO `m_blog` VALUES ('1305421347832315906', '1305410190455115778', '抖音文案7', '博客7', '找一个不仅仅只会对你说晚安的人 早安比晚安更珍贵 因为没人会一醒来就想到你 ​​', '2020-09-14 16:21:18', 0, '2020-09-14 16:21:18', 0);
INSERT INTO `m_blog` VALUES ('1305421382196248578', '1305410190455115778', '抖音文案8', '博客8', '找一个不仅仅只会对你说晚安的人 早安比晚安更珍贵 因为没人会一醒来就想到你 ​​', '2020-09-14 16:21:26', 0, '2020-09-14 16:21:26', 0);
INSERT INTO `m_blog` VALUES ('1305421411640262657', '1305410190455115778', '抖音文案9', '博客9', '找一个不仅仅只会对你说晚安的人 早安比晚安更珍贵 因为没人会一醒来就想到你 ​​', '2020-09-14 16:21:33', 0, '2020-09-14 16:21:33', 0);
INSERT INTO `m_blog` VALUES ('1305421449267363841', '1305410190455115778', '抖音文案10', '博客10', '找一个不仅仅只会对你说晚安的人 早安比晚安更珍贵 因为没人会一醒来就想到你 ​​', '2020-09-14 16:21:42', 0, '2020-09-14 16:21:42', 0);
INSERT INTO `m_blog` VALUES ('1306151239792287745', '1', '哈哈哈哈', '哈哈哈哈', '哈哈哈哈', '2020-09-16 16:41:37', 0, '2020-09-16 16:41:37', 0);
INSERT INTO `m_blog` VALUES ('1306151284260298754', '1', '哈哈哈哈修改111', '哈哈哈哈修改2222', '哈哈哈哈修改3333', '2020-09-16 16:41:48', 0, '2020-09-17 10:43:23', 0);
INSERT INTO `m_blog` VALUES ('1306424841020174337', '', '随便写一篇', '随笔', '今天一天都在写代码，写自己的小项目，抓紧上线一版', '2020-09-17 10:48:49', 0, '2020-09-17 10:48:49', 0);
INSERT INTO `m_blog` VALUES ('1306427090895171585', '1', '随便写一篇222', '随便做个测试', '写代码啊写代码，写完上线，点未发布111111', '2020-09-17 10:57:45', 1, '2020-09-17 11:12:41', 0);

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `status` int(0) NOT NULL COMMENT '状态',
  `gmt_created` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) NOT NULL COMMENT '逻辑删除1删除，0未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `UK_USERNAME`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('1', 'tianxuanxuan', 'https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg', 'xx_tian189@163.com', '96e79218965eb72c92a549dd5a330112', 0, '2020-09-12 10:44:01', '2020-09-12 10:44:01', 0);
INSERT INTO `m_user` VALUES ('1305410190455115778', 'heshengzhi', NULL, '1826942350@qq.com', '6ab3192109b13af0bee985b266917b7b', 1, '2020-09-14 15:36:57', '2020-09-14 15:36:57', 0);
INSERT INTO `m_user` VALUES ('1305808614518263810', 'tianxuan', NULL, 'xx_tian@163.com', '96e79218965eb72c92a549dd5a330112', 1, '2020-09-15 18:00:09', '2020-09-15 18:00:09', 0);
INSERT INTO `m_user` VALUES ('1305809095038701569', 'tian11', NULL, 'xx_tain111@163.com', '96e79218965eb72c92a549dd5a330112', 1, '2020-09-15 18:02:04', '2020-09-15 18:02:04', 0);
INSERT INTO `m_user` VALUES ('1305822636286251009', 'tian123', NULL, 'tian123@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 1, '2020-09-15 18:55:52', '2020-09-15 18:55:52', 0);
INSERT INTO `m_user` VALUES ('1306067074484842498', 'tian12345', NULL, '12345@163.com', '96e79218965eb72c92a549dd5a330112', 1, '2020-09-16 11:07:11', '2020-09-16 11:07:11', 0);
INSERT INTO `m_user` VALUES ('1306067569265913857', 'tian00000', NULL, 'tian00000@163.com', '96e79218965eb72c92a549dd5a330112', 1, '2020-09-16 11:09:09', '2020-09-16 11:09:09', 0);

SET FOREIGN_KEY_CHECKS = 1;
