/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : upload

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 21/04/2020 17:34:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oldFileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原始名',
  `newFileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新名',
  `ext` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扩展名',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件大小',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (1, '旧的', '新的', 'jps', 'c', '1024', NULL);
INSERT INTO `file` VALUES (2, '打打', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `file` VALUES (3, 'tgshop.sql', NULL, '.sql', '/D:/Myworkspace/NewWorkSpace/uploadstudy/target/classes/', '946880', 'application/octet-stream');
INSERT INTO `file` VALUES (4, 'tgshop.sql', NULL, '.sql', '/D:/Myworkspace/NewWorkSpace/uploadstudy/target/classes/', '946880', 'application/octet-stream');
INSERT INTO `file` VALUES (5, 'sql索引，存储过程，触发器.txt', 'java.text.SimpleDateFormat@5069d960288bce776f234b9a8d858d955348d89a.txt', '.txt', '/D:/Myworkspace/NewWorkSpace/uploadstudy/target/classes/', '744', 'text/plain');
INSERT INTO `file` VALUES (6, 'UpdateFileServiceImpl.java', 'java.text.SimpleDateFormat@5069d96076ea014387444e759a11e8d1c8823ba9.java', '.java', '/D:/Myworkspace/NewWorkSpace/uploadstudy/target/classes/', '6552', 'application/octet-stream');
INSERT INTO `file` VALUES (7, 'tgshop.sql', 'java.text.SimpleDateFormat@5069d96084ec8e13eaa243aa9c110b19674308d4.sql', '.sql', '/2020-04-21', '946880', 'application/octet-stream');
INSERT INTO `file` VALUES (8, 'UpdateFileServiceImpl.java', 'java.text.SimpleDateFormat@5069d96036faf987eb2541a3899c328fe14724ce.java', '.java', '/2020-04-21', '6552', 'application/octet-stream');
INSERT INTO `file` VALUES (9, '1.png', 'java.text.SimpleDateFormat@5069d960b0b7da15ae0e4971af577e6df3ec9679.png', '.png', '/2020-04-21', '68564', 'image/png');
INSERT INTO `file` VALUES (10, '北京培训企业黑名单.xlsx', 'java.text.SimpleDateFormat@5069d9607ed06172864f4116b37ba7160e0f77e3.xlsx', '.xlsx', '/2020-04-21', '17040', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');

SET FOREIGN_KEY_CHECKS = 1;
