/*
 Navicat Premium Data Transfer

 Source Server         : lfm
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : mywms

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 08/01/2020 20:04:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for action
-- ----------------------------
DROP TABLE IF EXISTS `action`;
CREATE TABLE `action`  (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `action_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `modifie` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of action
-- ----------------------------
INSERT INTO `action` VALUES (13, '进货入库', '/PurchaseList/**', '7', '7');
INSERT INTO `action` VALUES (14, '销售管理', '/SaleList/**', '8', '8');
INSERT INTO `action` VALUES (15, '库存管理', '/DamageList/**', '9', '9');

-- ----------------------------
-- Table structure for action_perm
-- ----------------------------
DROP TABLE IF EXISTS `action_perm`;
CREATE TABLE `action_perm`  (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `actionid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `perinitid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of action_perm
-- ----------------------------
INSERT INTO `action_perm` VALUES (10, '13', '38');
INSERT INTO `action_perm` VALUES (11, '13', '39');
INSERT INTO `action_perm` VALUES (12, '14', '41');
INSERT INTO `action_perm` VALUES (13, '15', '42');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `concat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '福州新弯曲5号', 'leefm6', '福州艾玛超市', '13556764452', '良好客户');

-- ----------------------------
-- Table structure for customer_return_list
-- ----------------------------
DROP TABLE IF EXISTS `customer_return_list`;
CREATE TABLE `customer_return_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_paid` float NOT NULL,
  `amount_payable` float NOT NULL,
  `customer_return_date` datetime(0) DEFAULT NULL,
  `customer_return_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKd55ju83f0ntixagdvdrsmw10c`(`user_id`) USING BTREE,
  INDEX `FKl0ahdwa8slkocbfe57opembfx`(`customer_id`) USING BTREE,
  CONSTRAINT `FKd55ju83f0ntixagdvdrsmw10c` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKl0ahdwa8slkocbfe57opembfx` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_return_list
-- ----------------------------
INSERT INTO `customer_return_list` VALUES (2, 2200, 2200, '2017-10-27 00:00:00', 'XT201710270001', 'cc', 1, 1, 3);
INSERT INTO `customer_return_list` VALUES (3, 4514, 4514, '2017-10-28 00:00:00', 'XT201710280001', 'cc', 1, 1, 3);
INSERT INTO `customer_return_list` VALUES (4, 4400, 4400, '2017-10-30 00:00:00', 'XT201710300001', 'cc', 1, 1, 3);
INSERT INTO `customer_return_list` VALUES (5, 139, 139, '2017-10-30 00:00:00', 'XT201710300002', 'cc', 1, 1, 2);
INSERT INTO `customer_return_list` VALUES (6, 38, 38, '2017-11-03 00:00:00', 'XT201711030001', 'cc', 1, 1, 2);
INSERT INTO `customer_return_list` VALUES (7, 5555, 116655, '2020-01-03 00:00:00', 'XT202001030001', '', 1, 1, 1);
INSERT INTO `customer_return_list` VALUES (8, 55555, 444440, '2020-01-03 00:00:00', 'XT202001030002', '', 1, 1, 1);
INSERT INTO `customer_return_list` VALUES (9, 5555, 116655, '2020-01-03 00:00:00', 'XT202001030003', '', 1, 1, 1);

-- ----------------------------
-- Table structure for customer_return_list_goods
-- ----------------------------
DROP TABLE IF EXISTS `customer_return_list_goods`;
CREATE TABLE `customer_return_list_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `customer_return_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKtqt67mbn96lxn8hvtl4piblhi`(`customer_return_list_id`) USING BTREE,
  INDEX `FK4sm5si4swbj3gae46jfk441yx`(`type_id`) USING BTREE,
  CONSTRAINT `FK4sm5si4swbj3gae46jfk441yx` FOREIGN KEY (`type_id`) REFERENCES `goodstype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKtqt67mbn96lxn8hvtl4piblhi` FOREIGN KEY (`customer_return_list_id`) REFERENCES `customer_return_list` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_return_list_goods
-- ----------------------------
INSERT INTO `customer_return_list_goods` VALUES (3, '0002', 'Note8', '华为荣耀Note8', 1, 2200, 2200, '台', 2, 16, 2);
INSERT INTO `customer_return_list_goods` VALUES (4, '0002', 'Note8', '华为荣耀Note8', 2, 2200, 4400, '台', 3, 16, 2);
INSERT INTO `customer_return_list_goods` VALUES (5, '0003', '500g装', '野生东北黑木耳', 3, 38, 114, '袋', 3, 11, 11);
INSERT INTO `customer_return_list_goods` VALUES (6, '0002', 'Note8', '华为荣耀Note8', 2, 2200, 4400, '台', 4, 16, 2);
INSERT INTO `customer_return_list_goods` VALUES (7, '0007', '500g装', '吉利人家牛肉味蛋糕', 2, 10, 20, '袋', 5, 11, 15);
INSERT INTO `customer_return_list_goods` VALUES (8, '0009', '240g装', '休闲零食坚果特产精品干果无漂白大个开心果', 3, 33, 99, '袋', 5, 11, 17);
INSERT INTO `customer_return_list_goods` VALUES (9, '0010', '250g装', '劲仔小鱼干', 1, 20, 20, '袋', 5, 11, 18);
INSERT INTO `customer_return_list_goods` VALUES (10, '0003', '500g装', '野生东北黑木耳', 1, 38, 38, '袋', 6, 11, 11);
INSERT INTO `customer_return_list_goods` VALUES (11, '0004', '2斤装', '新疆红枣', 5555, 0, 72215, '袋', NULL, 12, 12);
INSERT INTO `customer_return_list_goods` VALUES (12, '0005', '散装500克', '麦片燕麦巧克力', 5555, 0, 44440, '袋', NULL, 13, 13);
INSERT INTO `customer_return_list_goods` VALUES (15, '0004', '2斤装', '新疆红枣', 5555, 0, 72215, '袋', 9, 12, 12);
INSERT INTO `customer_return_list_goods` VALUES (16, '0005', '散装500克', '麦片燕麦巧克力', 5555, 0, 44440, '袋', 9, 13, 13);

-- ----------------------------
-- Table structure for damage_list
-- ----------------------------
DROP TABLE IF EXISTS `damage_list`;
CREATE TABLE `damage_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `damage_date` datetime(0) DEFAULT NULL,
  `damage_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKpn094ma69sch1icjc2gu7xus`(`user_id`) USING BTREE,
  CONSTRAINT `FKpn094ma69sch1icjc2gu7xus` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of damage_list
-- ----------------------------
INSERT INTO `damage_list` VALUES (3, '2017-10-27 00:00:00', 'BS201710270001', 'cc', 1);
INSERT INTO `damage_list` VALUES (4, '2017-10-27 00:00:00', 'BS201710270002', 'cc', 1);
INSERT INTO `damage_list` VALUES (5, '2017-11-03 00:00:00', 'BS201711030001', '', 1);
INSERT INTO `damage_list` VALUES (7, '2020-01-05 00:00:00', 'BS202001050001', '555', 1);
INSERT INTO `damage_list` VALUES (8, '2020-01-05 00:00:00', 'BS202001050002', '555', 1);
INSERT INTO `damage_list` VALUES (9, '2020-01-05 00:00:00', 'BS202001050003', '', 1);

-- ----------------------------
-- Table structure for damage_list_goods
-- ----------------------------
DROP TABLE IF EXISTS `damage_list_goods`;
CREATE TABLE `damage_list_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `damage_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKbf5m8mm3gctrnuubr9xkjamj8`(`damage_list_id`) USING BTREE,
  INDEX `FKdbdfmp09hlf2raktincwroe9n`(`type_id`) USING BTREE,
  CONSTRAINT `FKbf5m8mm3gctrnuubr9xkjamj8` FOREIGN KEY (`damage_list_id`) REFERENCES `damage_list` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKdbdfmp09hlf2raktincwroe9n` FOREIGN KEY (`type_id`) REFERENCES `goodstype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of damage_list_goods
-- ----------------------------
INSERT INTO `damage_list_goods` VALUES (4, '0003', '500g装', '野生东北黑木耳', 2, 23, 46, '袋', 3, 11, 11);
INSERT INTO `damage_list_goods` VALUES (5, '0006', '300g装', '冰糖金桔干', 2, 5, 10, '盒', 3, 11, 14);
INSERT INTO `damage_list_goods` VALUES (6, '0003', '500g装', '野生东北黑木耳', 2, 23, 46, '袋', 4, 11, 11);
INSERT INTO `damage_list_goods` VALUES (7, '0005', '散装500克', '麦片燕麦巧克力', 32, 8, 256, '袋', 4, 11, 13);
INSERT INTO `damage_list_goods` VALUES (8, '0007', '500g装', '吉利人家牛肉味蛋糕', 2, 4.5, 9, '袋', 4, 11, 15);
INSERT INTO `damage_list_goods` VALUES (9, '0002', 'Note8', '华为荣耀Note8', 1, 2220, 2220, '台', 5, 16, 2);
INSERT INTO `damage_list_goods` VALUES (10, '0004', '2斤装', '新疆红枣', 4555, 0, 59215, '袋', 9, 12, 12);
INSERT INTO `damage_list_goods` VALUES (11, '0005', '散装500克', '麦片燕麦巧克力', 4555, 0, 36440, '袋', 9, 13, 13);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `inventory_quantity` int(11) NOT NULL,
  `min_num` int(11) NOT NULL,
  `model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `producer` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `purchasing_price` float NOT NULL,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `selling_price` float NOT NULL,
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `last_purchasing_price` float NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKlxnna5ngumghp4f279mmbjtyo`(`type_id`) USING BTREE,
  CONSTRAINT `FKlxnna5ngumghp4f279mmbjtyo` FOREIGN KEY (`type_id`) REFERENCES `goodstype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '0001', 175, 1000, '红色装', '陶华碧老干妈香辣脆油辣椒', '贵州省贵阳南明老干妈风味食品有限公司', 6.32, '好卖', 8.5, '瓶', 10, 2, 8.5);
INSERT INTO `goods` VALUES (2, '0002', 0, 400, 'Note8', '华为荣耀Note84', '华为计算机系统有限公司', 1950, '热销', 2200, '台', 16, 0, 0);
INSERT INTO `goods` VALUES (11, '0003', 2897, 400, '500g装', '野生东北黑木耳', '辉南县博康土特产有限公司', 23, '够黑2', 38, '袋', 11, 2, 23);
INSERT INTO `goods` VALUES (12, '0004', 326, 300, '2斤装', '新疆红枣', '沧州铭鑫食品有限公司', 13, '好吃', 25, '袋', 10, 2, 13);
INSERT INTO `goods` VALUES (13, '0005', 53, 1000, '散装500克', '麦片燕麦巧克力', '福建省麦德好食品工业有限公司', 8, 'Goods', 15, '袋', 11, 2, 8);
INSERT INTO `goods` VALUES (14, '0006', 36, 1999, '300g装', '冰糖金桔干', '揭西县同心食品有限公司', 5.1, '', 13, '盒', 11, 2, 5);
INSERT INTO `goods` VALUES (15, '0007', 100651, 400, '500g装', '吉利人家牛肉味蛋糕', '合肥吉利人家食品有限公司', 4.5, 'good', 10, '袋', 11, 2, 4.5);
INSERT INTO `goods` VALUES (16, '0008', 196, 500, '128g装', '奕森奶油桃肉蜜饯果脯果干桃肉干休闲零食品', '潮州市潮安区正大食品有限公司', 3, '', 10, '盒', 11, 2, 3);
INSERT INTO `goods` VALUES (17, '0009', 365, 1000, '240g装', '休闲零食坚果特产精品干果无漂白大个开心果', '石家庄博群食品有限公司', 20, '', 33, '袋', 11, 2, 20);
INSERT INTO `goods` VALUES (18, '0010', 10, 300, '250g装', '劲仔小鱼干', '湖南省华文食品有限公司', 12, '', 20, '袋', 11, 2, 12);
INSERT INTO `goods` VALUES (19, '0011', 11, 300, '198g装', '山楂条', '临朐县七贤升利食品厂', 3.2, '', 10, '袋', 11, 0, 3.2);
INSERT INTO `goods` VALUES (20, '0012', 22, 200, '500g装', '大乌梅干', '长春市鼎丰真食品有限责任公司', 20, '', 25, '袋', 11, 0, 20);
INSERT INTO `goods` VALUES (21, '0013', 400, 100, '250g装', '手工制作芝麻香酥麻通', '桂林兰雨食品有限公司', 3, '', 8, '袋', 11, 2, 3);
INSERT INTO `goods` VALUES (22, '0014', 12, 200, '250g装', '美国青豆原味 蒜香', '菲律宾', 5, '', 8, '袋', 11, 2, 5);
INSERT INTO `goods` VALUES (24, '0015', -3, 100, 'X', ' iPhone X', 'xx2', 8000, 'xxx2', 9500, '台', 16, 2, 8000);
INSERT INTO `goods` VALUES (25, '0016', 0, 12, 'X', '21', '32', 100, '21', 120, '盒', 3, 0, 100);
INSERT INTO `goods` VALUES (26, '0017', -1, 100, 'ILCE-A6000L', 'Sony/索尼 ILCE-A6000L WIFI微单数码相机高清单电', 'xxx', 3000, 'xxx', 3650, '台', 15, 2, 3000);
INSERT INTO `goods` VALUES (27, '0018', -1, 400, 'IXUS 285 HS', 'Canon/佳能 IXUS 285 HS 数码相机 2020万像素高清拍摄', 'xx', 800, 'xxx', 1299, '台', 15, 2, 800);
INSERT INTO `goods` VALUES (28, '0019', 0, 300, 'Q8', 'Golden Field/金河田 Q8电脑音响台式多媒体家用音箱低音炮重低音', 'xxxx', 60, '', 129, '台', 17, 0, 60);
INSERT INTO `goods` VALUES (29, '0020', 0, 50, '190WDPT', 'Haier/海尔冰箱BCD-190WDPT双门电冰箱大两门冷藏冷冻', 'cc', 1000, '', 1699, '台', 14, 0, 1000);
INSERT INTO `goods` VALUES (30, '0021', 0, 320, '4A ', 'Xiaomi/小米 小米电视4A 32英寸 智能液晶平板电视机', 'cc', 700, '', 1199, '台', 12, 0, 700);
INSERT INTO `goods` VALUES (31, '0022', 0, 40, 'XQB55-36SP', 'TCL XQB55-36SP 5.5公斤全自动波轮迷你小型洗衣机家用单脱抗菌', 'cc', 400, '', 729, '台', 13, 0, 400);
INSERT INTO `goods` VALUES (32, '0023', 0, 1000, '80g*2', '台湾进口膨化零食品张君雅小妹妹日式串烧丸子80g*2', 'cc', 4, '', 15, '袋', 9, 0, 4);
INSERT INTO `goods` VALUES (33, '0024', 0, 10, 'A字裙', '卓图女装立领针织格子印花拼接高腰A字裙2017秋冬新款碎花连衣裙', 'cc', 168, '', 298, '件', 6, 0, 168);
INSERT INTO `goods` VALUES (34, '0025', 0, 10, '三件套秋', '西服套装男三件套秋季新款商务修身职业正装男士西装新郎结婚礼服', 'cc', 189, '', 299, '件', 7, 0, 189);
INSERT INTO `goods` VALUES (35, '0026', 0, 10, 'AFS JEEP', '加绒加厚正品AFS JEEP/战地吉普男大码长裤植绒保暖男士牛仔裤子', 'c', 60, '', 89, '条', 8, 0, 60);
INSERT INTO `goods` VALUES (41, '0027', 0, 400, '方法', '女性红蕾丝内衣', '华为计算机系统有限公司', 1950, 'dd', 2200, '盒', 34, 0, 1950);

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES (1, '所有类别', -1, 1, 'icon-folderOpen');
INSERT INTO `goodstype` VALUES (2, '服饰', 1, 1, 'icon-folder');
INSERT INTO `goodstype` VALUES (3, '食品', 1, 1, 'icon-folder');
INSERT INTO `goodstype` VALUES (4, '家电', 1, 1, 'icon-folder');
INSERT INTO `goodstype` VALUES (5, '数码', 1, 1, 'icon-folder');
INSERT INTO `goodstype` VALUES (6, '连衣裙', 2, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (7, '男士西装', 2, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (8, '牛仔裤', 2, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (9, '进口食品', 3, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (10, '地方特产', 3, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (11, '休闲食品', 3, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (12, '电视机', 4, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (13, '洗衣机', 4, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (14, '冰箱', 4, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (15, '相机', 5, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (16, '手机', 5, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (17, '音箱', 5, 0, 'icon-folder');
INSERT INTO `goodstype` VALUES (34, '电脑', 4, 0, 'icon-folder');

-- ----------------------------
-- Table structure for goodsunit
-- ----------------------------
DROP TABLE IF EXISTS `goodsunit`;
CREATE TABLE `goodsunit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodsunit
-- ----------------------------
INSERT INTO `goodsunit` VALUES (1, '个');
INSERT INTO `goodsunit` VALUES (2, '袋');
INSERT INTO `goodsunit` VALUES (3, '盒');
INSERT INTO `goodsunit` VALUES (4, '箱');
INSERT INTO `goodsunit` VALUES (5, '台');
INSERT INTO `goodsunit` VALUES (6, '包');
INSERT INTO `goodsunit` VALUES (11, '件');
INSERT INTO `goodsunit` VALUES (12, '条');

-- ----------------------------
-- Table structure for overflow_list
-- ----------------------------
DROP TABLE IF EXISTS `overflow_list`;
CREATE TABLE `overflow_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `overflow_date` datetime(0) DEFAULT NULL,
  `overflow_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK3bu8hj2xniqwbrtg6ls6b8ej2`(`user_id`) USING BTREE,
  CONSTRAINT `FK3bu8hj2xniqwbrtg6ls6b8ej2` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of overflow_list
-- ----------------------------
INSERT INTO `overflow_list` VALUES (3, '2017-10-27 00:00:00', 'BY201710270001', 'dd', 1);
INSERT INTO `overflow_list` VALUES (4, '2017-10-27 00:00:00', 'BY201710270002', 'ccc', 1);
INSERT INTO `overflow_list` VALUES (6, '2020-01-07 00:00:00', 'BY202001070001', '5555', 1);
INSERT INTO `overflow_list` VALUES (7, '2020-01-07 00:00:00', 'BY202001070002', '555', 1);

-- ----------------------------
-- Table structure for overflow_list_goods
-- ----------------------------
DROP TABLE IF EXISTS `overflow_list_goods`;
CREATE TABLE `overflow_list_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `overflow_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKd3s9761mgl456tn2xb0d164h7`(`overflow_list_id`) USING BTREE,
  INDEX `FK8t46iik5kpciki8fnqtiuq5q3`(`type_id`) USING BTREE,
  CONSTRAINT `FK8t46iik5kpciki8fnqtiuq5q3` FOREIGN KEY (`type_id`) REFERENCES `goodstype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKd3s9761mgl456tn2xb0d164h7` FOREIGN KEY (`overflow_list_id`) REFERENCES `overflow_list` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of overflow_list_goods
-- ----------------------------
INSERT INTO `overflow_list_goods` VALUES (4, '0002', 'Note8', '华为荣耀Note8', 2, 2220, 4440, '台', 3, 16, 2);
INSERT INTO `overflow_list_goods` VALUES (5, '0006', '300g装', '冰糖金桔干', 3, 5, 15, '盒', 3, 11, 14);
INSERT INTO `overflow_list_goods` VALUES (6, '0004', '2斤装', '新疆红枣', 2, 13, 26, '袋', 4, 10, 12);
INSERT INTO `overflow_list_goods` VALUES (7, '0006', '300g装', '冰糖金桔干', 3, 5, 15, '盒', 4, 11, 14);
INSERT INTO `overflow_list_goods` VALUES (8, '0007', '500g装', '吉利人家牛肉味蛋糕', 555, 0, 2497.5, '袋', 7, 15, 15);
INSERT INTO `overflow_list_goods` VALUES (9, '0008', '128g装', '奕森奶油桃肉蜜饯果脯果干桃肉干休闲零食品', 555, 0, 1665, '盒', 7, 16, 16);

-- ----------------------------
-- Table structure for purchase_list
-- ----------------------------
DROP TABLE IF EXISTS `purchase_list`;
CREATE TABLE `purchase_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_paid` float NOT NULL,
  `amount_payable` float NOT NULL,
  `purchase_date` datetime(0) DEFAULT NULL,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int(11) NOT NULL,
  `purchase_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK5j2dev8b2b5d0l69nb8vtr4yb`(`supplier_id`) USING BTREE,
  INDEX `FK69s6eyxr4wwvsywe9hbthef1h`(`user_id`) USING BTREE,
  CONSTRAINT `FK5j2dev8b2b5d0l69nb8vtr4yb` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK69s6eyxr4wwvsywe9hbthef1h` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purchase_list
-- ----------------------------
INSERT INTO `purchase_list` VALUES (25, 73299, 73299, '2017-10-27 00:00:00', 'cc', 1, 'JH201710270001', 2, 1);
INSERT INTO `purchase_list` VALUES (26, 69099, 69099, '2017-10-28 00:00:00', 'cc', 1, 'JH201710280001', 2, 1);
INSERT INTO `purchase_list` VALUES (28, 17, 17, '2017-10-31 00:00:00', 'cc', 1, 'JH201710310001', 5, 1);
INSERT INTO `purchase_list` VALUES (29, 463, 463, '2017-11-03 00:00:00', 'cc', 1, 'JH201711030001', 1, 1);
INSERT INTO `purchase_list` VALUES (30, 1240, 1240, '2017-11-03 00:00:00', 'cc', 1, 'JH201711030002', 1, 1);
INSERT INTO `purchase_list` VALUES (31, 450, 450, '2017-11-03 00:00:00', 'ccc', 1, 'JH201711030003', 2, 1);
INSERT INTO `purchase_list` VALUES (32, 5555, 72215, '2019-12-31 00:00:00', '555', 1, 'JH201912310001', 4, 1);
INSERT INTO `purchase_list` VALUES (33, 58588, 11655, '2019-12-31 00:00:00', '', 1, 'JH201912310002', 3, 1);
INSERT INTO `purchase_list` VALUES (34, 58588, 11655, '2019-12-31 00:00:00', '', 1, 'JH201912310002', 3, 1);
INSERT INTO `purchase_list` VALUES (35, 5555, 1155, '2019-12-31 00:00:00', '', 1, 'JH201912310003', 4, 1);
INSERT INTO `purchase_list` VALUES (36, 444, 924, '2019-12-31 00:00:00', '444', 1, 'JH201912310004', 3, 1);
INSERT INTO `purchase_list` VALUES (37, 555, 7215, '2019-12-31 00:00:00', '', 1, 'JH201912310005', 3, 1);
INSERT INTO `purchase_list` VALUES (38, 55555, 11655, '2019-12-31 00:00:00', '555', 1, 'JH201912310006', 4, 1);

-- ----------------------------
-- Table structure for purchase_list_goods
-- ----------------------------
DROP TABLE IF EXISTS `purchase_list_goods`;
CREATE TABLE `purchase_list_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `purchase_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKfvdvgcebqkkokyn0o00idqnpy`(`purchase_list_id`) USING BTREE,
  INDEX `FK83ikbi2x3epn49fwcco8jlfwu`(`type_id`) USING BTREE,
  CONSTRAINT `FK83ikbi2x3epn49fwcco8jlfwu` FOREIGN KEY (`type_id`) REFERENCES `goodstype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKfvdvgcebqkkokyn0o00idqnpy` FOREIGN KEY (`purchase_list_id`) REFERENCES `purchase_list` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purchase_list_goods
-- ----------------------------
INSERT INTO `purchase_list_goods` VALUES (35, '0002', 'Note8', '华为荣耀Note8', 33, 2220, 73260, '台', 25, 16, 2);
INSERT INTO `purchase_list_goods` VALUES (36, '0004', '2斤装', '新疆红枣', 3, 13, 39, '袋', 25, 10, 12);
INSERT INTO `purchase_list_goods` VALUES (37, '0003', '500g装', '野生东北黑木耳', 3000, 23, 69000, '袋', 26, 11, 11);
INSERT INTO `purchase_list_goods` VALUES (38, '0007', '500g装', '吉利人家牛肉味蛋糕', 22, 4.5, 99, '袋', 26, 11, 15);
INSERT INTO `purchase_list_goods` VALUES (41, '0001', '红色装', '陶华碧老干妈香辣脆油辣椒', 2, 8.5, 17, '瓶', 28, 10, 1);
INSERT INTO `purchase_list_goods` VALUES (42, '0001', '红色装', '陶华碧老干妈香辣脆油辣椒', 4, 8.5, 34, '瓶', 29, 10, 1);
INSERT INTO `purchase_list_goods` VALUES (43, '0004', '2斤装', '新疆红枣', 33, 13, 429, '袋', 29, 10, 12);
INSERT INTO `purchase_list_goods` VALUES (44, '0001', '红色装', '陶华碧老干妈香辣脆油辣椒', 100, 8.5, 850, '瓶', 30, 10, 1);
INSERT INTO `purchase_list_goods` VALUES (45, '0004', '2斤装', '新疆红枣', 30, 13, 390, '袋', 30, 10, 12);
INSERT INTO `purchase_list_goods` VALUES (46, '0015', 'X', ' iPhone X', 30, 0, 0, '台', 30, 16, 24);
INSERT INTO `purchase_list_goods` VALUES (47, '0007', '500g装', '吉利人家牛肉味蛋糕', 100, 4.5, 450, '袋', 31, 11, 15);
INSERT INTO `purchase_list_goods` VALUES (48, '0005', '散装500克', '麦片燕麦巧克力', 5555, 0, 44440, '袋', 32, 13, 13);
INSERT INTO `purchase_list_goods` VALUES (49, '0006', '300g装', '冰糖金桔干', 5555, 0, 27775, '盒', 32, 14, 14);
INSERT INTO `purchase_list_goods` VALUES (50, '0004', '2斤装', '新疆红枣', 555, 0, 7215, '袋', NULL, 12, 12);
INSERT INTO `purchase_list_goods` VALUES (51, '0005', '散装500克', '麦片燕麦巧克力', 555, 0, 4440, '袋', NULL, 13, 13);
INSERT INTO `purchase_list_goods` VALUES (52, '0004', '2斤装', '新疆红枣', 555, 0, 7215, '袋', 33, 12, 12);
INSERT INTO `purchase_list_goods` VALUES (53, '0005', '散装500克', '麦片燕麦巧克力', 555, 0, 4440, '袋', 33, 13, 13);
INSERT INTO `purchase_list_goods` VALUES (54, '0004', '2斤装', '新疆红枣', 55, 0, 715, '袋', 34, 12, 12);
INSERT INTO `purchase_list_goods` VALUES (55, '0005', '散装500克', '麦片燕麦巧克力', 55, 0, 440, '袋', 34, 13, 13);
INSERT INTO `purchase_list_goods` VALUES (56, '0004', '2斤装', '新疆红枣', 44, 0, 572, '袋', 35, 12, 12);
INSERT INTO `purchase_list_goods` VALUES (57, '0005', '散装500克', '麦片燕麦巧克力', 44, 0, 352, '袋', 35, 13, 13);
INSERT INTO `purchase_list_goods` VALUES (58, '0005', '散装500克', '麦片燕麦巧克力', 555, 0, 4440, '袋', 36, 13, 13);
INSERT INTO `purchase_list_goods` VALUES (59, '0006', '300g装', '冰糖金桔干', 555, 0, 2775, '盒', 36, 14, 14);
INSERT INTO `purchase_list_goods` VALUES (60, '0004', '2斤装', '新疆红枣', 555, 0, 7215, '袋', 37, 12, 12);
INSERT INTO `purchase_list_goods` VALUES (61, '0005', '散装500克', '麦片燕麦巧克力', 555, 0, 4440, '袋', 37, 13, 13);

-- ----------------------------
-- Table structure for return_list
-- ----------------------------
DROP TABLE IF EXISTS `return_list`;
CREATE TABLE `return_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_paid` float NOT NULL,
  `amount_payable` float NOT NULL,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `return_date` datetime(0) DEFAULT NULL,
  `return_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int(11) NOT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK4qxjj8bvj2etne243xluni0vn`(`supplier_id`) USING BTREE,
  INDEX `FK904juw2v1hm2av0ig26gae9jb`(`user_id`) USING BTREE,
  CONSTRAINT `FK4qxjj8bvj2etne243xluni0vn` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK904juw2v1hm2av0ig26gae9jb` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_list
-- ----------------------------
INSERT INTO `return_list` VALUES (4, 4464, 4464, 'cc', '2017-10-27 00:00:00', 'TH201710270001', 1, 2, 1);
INSERT INTO `return_list` VALUES (5, 4440, 4440, 'cc', '2017-11-03 00:00:00', 'TH201711030001', 1, 2, 1);
INSERT INTO `return_list` VALUES (6, 555, 116655, '555', NULL, NULL, 1, 1, 1);
INSERT INTO `return_list` VALUES (7, 5555, 7215, '', NULL, NULL, 1, 1, 1);
INSERT INTO `return_list` VALUES (8, 55555, 116655, '555', NULL, NULL, 1, 1, 1);
INSERT INTO `return_list` VALUES (9, 5555, 7215, '5555', NULL, NULL, 1, 1, 1);
INSERT INTO `return_list` VALUES (10, 55555, 10101, '', '2019-12-30 00:00:00', 'TH201912300001', 1, 1, 1);

-- ----------------------------
-- Table structure for return_list_goods
-- ----------------------------
DROP TABLE IF EXISTS `return_list_goods`;
CREATE TABLE `return_list_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `return_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKemclu281vyvyk063c3foafq1w`(`return_list_id`) USING BTREE,
  INDEX `FKa1prpd96fcs0x2oe0omny9vio`(`type_id`) USING BTREE,
  CONSTRAINT `FKa1prpd96fcs0x2oe0omny9vio` FOREIGN KEY (`type_id`) REFERENCES `goodstype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKemclu281vyvyk063c3foafq1w` FOREIGN KEY (`return_list_id`) REFERENCES `return_list` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_list_goods
-- ----------------------------
INSERT INTO `return_list_goods` VALUES (7, '0002', 'Note8', '华为荣耀Note8', 2, 2220, 4440, '台', 4, 16, 2);
INSERT INTO `return_list_goods` VALUES (8, '0005', '散装500克', '麦片燕麦巧克力', 3, 8, 24, '袋', 4, 11, 13);
INSERT INTO `return_list_goods` VALUES (9, '0002', 'Note8', '华为荣耀Note8', 2, 2220, 4440, '台', 5, 16, 2);
INSERT INTO `return_list_goods` VALUES (10, '0015', 'X', ' iPhone X', 3, 0, 0, '台', 5, 16, 24);
INSERT INTO `return_list_goods` VALUES (11, '0005', '散装500克', '麦片燕麦巧克力', 555, 0, 4440, '袋', 7, 13, 13);
INSERT INTO `return_list_goods` VALUES (12, '0006', '300g装', '冰糖金桔干', 555, 0, 2775, '盒', 7, 14, 14);
INSERT INTO `return_list_goods` VALUES (13, '0004', '2斤装', '新疆红枣', 5555, 0, 72215, '袋', 8, 12, 12);
INSERT INTO `return_list_goods` VALUES (14, '0005', '散装500克', '麦片燕麦巧克力', 5555, 0, 44440, '袋', 8, 13, 13);
INSERT INTO `return_list_goods` VALUES (15, '0005', '散装500克', '麦片燕麦巧克力', 555, 0, 4440, '袋', NULL, 13, 13);
INSERT INTO `return_list_goods` VALUES (16, '0006', '300g装', '冰糖金桔干', 555, 0, 2775, '盒', NULL, 14, 14);
INSERT INTO `return_list_goods` VALUES (17, '0005', '散装500克', '麦片燕麦巧克力', 777, 0, 6216, '袋', 9, 13, 13);
INSERT INTO `return_list_goods` VALUES (18, '0006', '300g装', '冰糖金桔干', 777, 0, 3885, '盒', 9, 14, 14);

-- ----------------------------
-- Table structure for role_perm
-- ----------------------------
DROP TABLE IF EXISTS `role_perm`;
CREATE TABLE `role_perm`  (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `perm_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限id',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_perm
-- ----------------------------
INSERT INTO `role_perm` VALUES (1, '1', '1');
INSERT INTO `role_perm` VALUES (2, '2', '1');
INSERT INTO `role_perm` VALUES (3, '1', '2');
INSERT INTO `role_perm` VALUES (4, '2', '2');
INSERT INTO `role_perm` VALUES (5, '3', '2');
INSERT INTO `role_perm` VALUES (6, '4', '2');
INSERT INTO `role_perm` VALUES (7, '1', '7');

-- ----------------------------
-- Table structure for sale_list
-- ----------------------------
DROP TABLE IF EXISTS `sale_list`;
CREATE TABLE `sale_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_paid` float NOT NULL,
  `amount_payable` float NOT NULL,
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sale_date` datetime(0) DEFAULT NULL,
  `sale_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK34bnujemrdqimbhg133enp8k8`(`user_id`) USING BTREE,
  INDEX `FKox4qfs87eu3fvwdmrvelqhi8e`(`customer_id`) USING BTREE,
  CONSTRAINT `FK34bnujemrdqimbhg133enp8k8` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKox4qfs87eu3fvwdmrvelqhi8e` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_list
-- ----------------------------
INSERT INTO `sale_list` VALUES (4, 5060, 5060, 'cc', '2017-01-27 00:00:00', 'XS201701270001', 1, 1, 2);
INSERT INTO `sale_list` VALUES (6, 4889, 4889, 'dd', '2017-02-28 00:00:00', 'XS201702280002', 1, 1, 2);
INSERT INTO `sale_list` VALUES (7, 4400, 4400, 'cccc', '2017-03-30 00:00:00', 'XS201703300001', 1, 1, 2);
INSERT INTO `sale_list` VALUES (8, 860, 860, 'cc', '2017-04-30 00:00:00', 'XS201704300002', 1, 1, 2);
INSERT INTO `sale_list` VALUES (11, 83, 83, 'ccc', '2017-05-01 00:00:00', 'XS201705100003', 1, 1, 2);
INSERT INTO `sale_list` VALUES (12, 6626, 6626, 'cccc', '2017-06-03 00:00:00', 'XS201706300001', 1, 1, 2);
INSERT INTO `sale_list` VALUES (13, 76, 76, 'cc', '2017-06-03 00:00:00', 'XS201706300002', 1, 1, 1);
INSERT INTO `sale_list` VALUES (14, 127, 127, 'cc', '2017-07-03 00:00:00', 'XS201707300003', 2, 1, 2);
INSERT INTO `sale_list` VALUES (15, 1579.5, 1579.5, 'cc', '2017-08-03 00:00:00', 'XS201708300004', 1, 1, 2);
INSERT INTO `sale_list` VALUES (16, 76, 76, 'cc', '2017-09-03 00:00:00', 'XS201709300005', 1, 1, 2);
INSERT INTO `sale_list` VALUES (17, 111, 111, 'cc', '2017-10-28 00:00:00', 'XS201710280006', 1, 1, 2);
INSERT INTO `sale_list` VALUES (18, 40, 40, 'cc', '2017-10-29 00:00:00', 'XS201710290007', 1, 1, 1);
INSERT INTO `sale_list` VALUES (19, 45, 45, 'cc', '2017-10-30 00:00:00', 'XS201710300008', 1, 1, 1);
INSERT INTO `sale_list` VALUES (20, 10, 10, 'cc', '2017-10-31 00:00:00', 'XS201710310009', 1, 1, 1);
INSERT INTO `sale_list` VALUES (21, 202, 202, 'cc', '2017-11-01 00:00:00', 'XS201711010010', 1, 1, 2);
INSERT INTO `sale_list` VALUES (22, 3650, 3650, '11', '2017-11-02 00:00:00', 'XS201711020011', 1, 1, 2);
INSERT INTO `sale_list` VALUES (23, 20, 20, 'cc', '2017-11-03 00:00:00', 'XS201711030012', 1, 1, 1);
INSERT INTO `sale_list` VALUES (24, 59, 59, 'cc', '2016-12-03 00:00:00', 'XS201712030013', 1, 1, 2);
INSERT INTO `sale_list` VALUES (25, 146, 146, 'cc', '2016-11-03 00:00:00', 'XS201711030014', 1, 1, 1);
INSERT INTO `sale_list` VALUES (26, 455555, 116655, '', NULL, NULL, 1, 1, NULL);
INSERT INTO `sale_list` VALUES (27, 55555, 72215, '', '2020-01-03 00:00:00', 'XS202001030001', 1, 1, 1);
INSERT INTO `sale_list` VALUES (28, 55555, 116655, '', '2020-01-03 00:00:00', 'XS202001030002', 1, 1, 1);
INSERT INTO `sale_list` VALUES (29, 22255, 11655, '', '2020-01-03 00:00:00', NULL, 1, 1, 1);

-- ----------------------------
-- Table structure for sale_list_goods
-- ----------------------------
DROP TABLE IF EXISTS `sale_list_goods`;
CREATE TABLE `sale_list_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sale_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK20ehd6ta9geyql4hxtdsnhbox`(`sale_list_id`) USING BTREE,
  INDEX `FKn9i5p1d8f0gek5x7q45cq8ibw`(`type_id`) USING BTREE,
  CONSTRAINT `FK20ehd6ta9geyql4hxtdsnhbox` FOREIGN KEY (`sale_list_id`) REFERENCES `sale_list` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKn9i5p1d8f0gek5x7q45cq8ibw` FOREIGN KEY (`type_id`) REFERENCES `goodstype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_list_goods
-- ----------------------------
INSERT INTO `sale_list_goods` VALUES (7, '0002', 'Note8', '华为荣耀Note8', 2, 2200, 4400, '台', 4, 16, 2);
INSERT INTO `sale_list_goods` VALUES (8, '0010', '250g装', '劲仔小鱼干', 33, 20, 660, '袋', 4, 11, 18);
INSERT INTO `sale_list_goods` VALUES (11, '0003', '500g装', '野生东北黑木耳', 100, 38, 3800, '袋', 6, 11, 11);
INSERT INTO `sale_list_goods` VALUES (12, '0009', '240g装', '休闲零食坚果特产精品干果无漂白大个开心果', 33, 33, 1089, '袋', 6, 11, 17);
INSERT INTO `sale_list_goods` VALUES (13, '0002', 'Note8', '华为荣耀Note8', 2, 2200, 4400, '台', 7, 16, 2);
INSERT INTO `sale_list_goods` VALUES (14, '0003', '500g装', '野生东北黑木耳', 22, 38, 836, '袋', 8, 11, 11);
INSERT INTO `sale_list_goods` VALUES (15, '0014', '250g装', '美国青豆原味 蒜香', 3, 8, 24, '袋', 8, 11, 22);
INSERT INTO `sale_list_goods` VALUES (20, '0003', '500g装', '野生东北黑木耳', 1, 38, 38, '袋', 11, 11, 11);
INSERT INTO `sale_list_goods` VALUES (21, '0005', '散装500克', '麦片燕麦巧克力', 3, 15, 45, '袋', 11, 11, 13);
INSERT INTO `sale_list_goods` VALUES (22, '0002', 'Note8', '华为荣耀Note8', 3, 2200, 6600, '台', 12, 16, 2);
INSERT INTO `sale_list_goods` VALUES (23, '0006', '300g装', '冰糖金桔干', 2, 13, 26, '盒', 12, 11, 14);
INSERT INTO `sale_list_goods` VALUES (24, '0003', '500g装', '野生东北黑木耳', 2, 38, 76, '袋', 13, 11, 11);
INSERT INTO `sale_list_goods` VALUES (25, '0004', '2斤装', '新疆红枣', 3, 25, 75, '袋', 14, 10, 12);
INSERT INTO `sale_list_goods` VALUES (26, '0006', '300g装', '冰糖金桔干', 4, 13, 52, '盒', 14, 11, 14);
INSERT INTO `sale_list_goods` VALUES (27, '0001', '红色装', '陶华碧老干妈香辣脆油辣椒', 33, 8.5, 280.5, '瓶', 15, 10, 1);
INSERT INTO `sale_list_goods` VALUES (28, '0018', 'IXUS 285 HS', 'Canon/佳能 IXUS 285 HS 数码相机 2020万像素高清拍摄', 1, 1299, 1299, '台', 15, 15, 27);
INSERT INTO `sale_list_goods` VALUES (29, '0003', '500g装', '野生东北黑木耳', 2, 38, 76, '袋', 16, 11, 11);
INSERT INTO `sale_list_goods` VALUES (30, '0005', '散装500克', '麦片燕麦巧克力', 3, 15, 45, '袋', 17, 11, 13);
INSERT INTO `sale_list_goods` VALUES (31, '0009', '240g装', '休闲零食坚果特产精品干果无漂白大个开心果', 2, 33, 66, '袋', 17, 11, 17);
INSERT INTO `sale_list_goods` VALUES (32, '0010', '250g装', '劲仔小鱼干', 1, 20, 20, '袋', 18, 11, 18);
INSERT INTO `sale_list_goods` VALUES (33, '0008', '128g装', '奕森奶油桃肉蜜饯果脯果干桃肉干休闲零食品', 2, 10, 20, '盒', 18, 11, 16);
INSERT INTO `sale_list_goods` VALUES (34, '0004', '2斤装', '新疆红枣', 1, 25, 25, '袋', 19, 10, 12);
INSERT INTO `sale_list_goods` VALUES (35, '0008', '128g装', '奕森奶油桃肉蜜饯果脯果干桃肉干休闲零食品', 2, 10, 20, '盒', 19, 11, 16);
INSERT INTO `sale_list_goods` VALUES (36, '0007', '500g装', '吉利人家牛肉味蛋糕', 1, 10, 10, '袋', 20, 11, 15);
INSERT INTO `sale_list_goods` VALUES (37, '0003', '500g装', '野生东北黑木耳', 2, 38, 76, '袋', 21, 11, 11);
INSERT INTO `sale_list_goods` VALUES (38, '0007', '500g装', '吉利人家牛肉味蛋糕', 2, 10, 20, '袋', 21, 11, 15);
INSERT INTO `sale_list_goods` VALUES (39, '0009', '240g装', '休闲零食坚果特产精品干果无漂白大个开心果', 2, 33, 66, '袋', 21, 11, 17);
INSERT INTO `sale_list_goods` VALUES (40, '0010', '250g装', '劲仔小鱼干', 2, 20, 40, '袋', 21, 11, 18);
INSERT INTO `sale_list_goods` VALUES (41, '0017', 'ILCE-A6000L', 'Sony/索尼 ILCE-A6000L WIFI微单数码相机高清单电', 1, 3650, 3650, '台', 22, 15, 26);
INSERT INTO `sale_list_goods` VALUES (42, '0010', '250g装', '劲仔小鱼干', 1, 20, 20, '袋', 23, 11, 18);
INSERT INTO `sale_list_goods` VALUES (43, '0009', '240g装', '休闲零食坚果特产精品干果无漂白大个开心果', 1, 33, 33, '袋', 24, 11, 17);
INSERT INTO `sale_list_goods` VALUES (44, '0006', '300g装', '冰糖金桔干', 2, 13, 26, '盒', 24, 11, 14);
INSERT INTO `sale_list_goods` VALUES (45, '0009', '240g装', '休闲零食坚果特产精品干果无漂白大个开心果', 2, 33, 66, '袋', 25, 11, 17);
INSERT INTO `sale_list_goods` VALUES (46, '0014', '250g装', '美国青豆原味 蒜香', 10, 8, 80, '袋', 25, 11, 22);
INSERT INTO `sale_list_goods` VALUES (47, '0005', '散装500克', '麦片燕麦巧克力', 5555, 0, 44440, '袋', NULL, 13, 13);
INSERT INTO `sale_list_goods` VALUES (48, '0006', '300g装', '冰糖金桔干', 5555, 0, 27775, '盒', NULL, 14, 14);
INSERT INTO `sale_list_goods` VALUES (49, '0005', '散装500克', '麦片燕麦巧克力', 4555, 0, 36440, '袋', NULL, 13, 13);
INSERT INTO `sale_list_goods` VALUES (50, '0006', '300g装', '冰糖金桔干', 4555, 0, 22775, '盒', NULL, 14, 14);
INSERT INTO `sale_list_goods` VALUES (51, '0004', '2斤装', '新疆红枣', 5555, 0, 72215, '袋', 28, 12, 12);
INSERT INTO `sale_list_goods` VALUES (52, '0005', '散装500克', '麦片燕麦巧克力', 5555, 0, 44440, '袋', 28, 13, 13);
INSERT INTO `sale_list_goods` VALUES (53, '0004', '2斤装', '新疆红枣', 555, 0, 7215, '袋', NULL, 12, 12);
INSERT INTO `sale_list_goods` VALUES (54, '0005', '散装500克', '麦片燕麦巧克力', 555, 0, 4440, '袋', NULL, 13, 13);

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `concat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '上海市金山区张堰镇松金公路2072号6607室', '李富民', '上海福桂食品有限公司', '13556764452', '失信供应商');
INSERT INTO `supplier` VALUES (2, '安徽省合肥市肥西县桃花工业园合派路', '小王', '安徽麦堡食品工业有限公司', '0773-7217275', NULL);
INSERT INTO `supplier` VALUES (3, '晋江市罗山后林西区41号', '小李', '福建省晋江市罗山惠康食品有限公司', '1273-1217175', '优质供应商');
INSERT INTO `supplier` VALUES (4, '南京市江宁区科学园竹山路565号1幢', '小丽', '南京含羞草食品有限公司', '2121-7217175', NULL);
INSERT INTO `supplier` VALUES (5, '南京市高淳县阳江镇新桥村下桥278号', '王大狗', '南京禾乃美工贸有限公司', '2133-7217125', NULL);
INSERT INTO `supplier` VALUES (6, '开平市水口镇东埠路６号', '小七', '开平广合腐乳有限公司', '3332-7217175', '2');
INSERT INTO `supplier` VALUES (7, '汕头市跃进路２３号利鸿基中心大厦写字楼２座', '刘钩子', '汕头市金茂食品有限公司', '0723-7232175', NULL);
INSERT INTO `supplier` VALUES (8, '南京市溧水区经济开发区', '七枷社', '南京喜之郎食品有限公司', '1773-7217175', NULL);
INSERT INTO `supplier` VALUES (9, '深圳市罗湖区翠竹北路中深石化区厂房B栋6楼', '小蔡', '深圳昌信实业有限公司', '1773-7217175', NULL);
INSERT INTO `supplier` VALUES (10, '南京市下关区金陵小区6村27-2-203室', '小路', '南京市下关区红鹰调味品商行', '2132-7217175', NULL);
INSERT INTO `supplier` VALUES (11, '荔浦县荔塔路１６－３６号', '亲亲', '桂林阜康食品工业有限公司', '2123-7217175', NULL);
INSERT INTO `supplier` VALUES (12, '南京鼓楼区世纪大楼123号', '小二', '南京大王科技', '0112-1426789', '123');
INSERT INTO `supplier` VALUES (13, '南京将军路800号', '小吴', '南京大陆食品公司', '1243-2135487', 'cc');

-- ----------------------------
-- Table structure for sys_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm`  (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `perm_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限名称',
  `perm_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限描述',
  `perm_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限值',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `is_disable` int(1) DEFAULT NULL COMMENT '是否禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_perm
-- ----------------------------
INSERT INTO `sys_perm` VALUES (1, '创建', '创建权限', 'create', '2018-05-26 00:39:16', NULL, 0);
INSERT INTO `sys_perm` VALUES (2, '删除', '删除权限', 'delete', '2018-05-26 00:39:39', NULL, 0);
INSERT INTO `sys_perm` VALUES (3, '修改', '修改权限', 'update', '2018-05-26 00:39:58', NULL, 0);
INSERT INTO `sys_perm` VALUES (4, '查询', '查询权限', 'select', '2018-05-26 00:40:16', NULL, 0);

-- ----------------------------
-- Table structure for sys_permission_init
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_init`;
CREATE TABLE `sys_permission_init`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '程序对用url地址',
  `permission_init` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '对应shiro权限',
  `sort` int(100) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission_init
-- ----------------------------
INSERT INTO `sys_permission_init` VALUES (1, '/userInfo/login', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (2, '/userInfo/selectAll', 'anon', 2);
INSERT INTO `sys_permission_init` VALUES (3, '/logout', 'anon', 3);
INSERT INTO `sys_permission_init` VALUES (4, '/**', 'authc', 0);
INSERT INTO `sys_permission_init` VALUES (5, '/userInfo/selectById', 'authc, roles[cw]', 6);
INSERT INTO `sys_permission_init` VALUES (6, '/sysPermissionInit/aaa', 'anon', 5);
INSERT INTO `sys_permission_init` VALUES (7, '/route/login.html', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (8, '/swagger-ui.html', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (9, '/image/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (10, '/css/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (11, '/js/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (12, '/swagger-resources/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (13, '/v2/api-docs/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (14, '/webjars/springfox-swagger-ui/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (15, '/static/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (16, '/fonts/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (17, '/layui/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (18, '/layui2/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (19, '/less/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (20, '/lib/**', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (38, '/PurchaseList/**', 'authc,roles[cg]', 1);
INSERT INTO `sys_permission_init` VALUES (39, '/PurchaseList/**', 'authc,roles[cg]', 1);
INSERT INTO `sys_permission_init` VALUES (40, '/shiroUtils/defaultKaptcha', 'anon', 1);
INSERT INTO `sys_permission_init` VALUES (41, '/SaleList/**', 'authc,roles[xsjl]', 1);
INSERT INTO `sys_permission_init` VALUES (42, '/DamageList/**', 'authc,roles[kcgl]', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(36) NOT NULL AUTO_INCREMENT COMMENT '角色名称',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称，用于显示',
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  `role_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色值，用于权限判断',
  `create_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `is_disable` int(1) DEFAULT NULL COMMENT '是否禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '财务', '负责发工资', 'cw', '2018-05-26', NULL, 0);
INSERT INTO `sys_role` VALUES (2, '人事', '负责员工', 'rs', '2018-05-26', NULL, 0);
INSERT INTO `sys_role` VALUES (7, '采购员', '采购货物', 'cg', '2020-01-08', NULL, 0);
INSERT INTO `sys_role` VALUES (8, '销售经理', '销售管理', 'xsjl', '2020-01-08', NULL, 0);
INSERT INTO `sys_role` VALUES (9, '仓库管理员', '库存管理', 'kcgl', '2020-01-08', NULL, 0);

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '日志信息描述',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '方法名称',
  `log_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '日志类型 0是正常，1是异常',
  `request_ip` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求的ip',
  `exception_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '异常错误码',
  `exception_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '异常详情',
  `params` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求参数',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求的用户id',
  `create_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户加密盐值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'leefm666', '607d1229e4cdac6a7a2628f22498ee3c', 'wxKYXuTPST5SG0jMQzVPsg==');
INSERT INTO `user_info` VALUES (2, 'leefmin', '729dc42f7376c0f0ddf95e943ca6c81d', 'wxKYXuTPST5SG0jMQzVPsg==');
INSERT INTO `user_info` VALUES (15, '李富民', '43443492a7052f4243a786a4573107ad', 'M19V0oajYuS8flBjOUVstpeB');
INSERT INTO `user_info` VALUES (16, '李飞飞', 'dda786e167ca6e2ebe0d00d2c0ec5a63', 'hcXKGCeDZKcb5CKe8CbRasPa');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, '1', '1');
INSERT INTO `user_role` VALUES (2, '1', '2');
INSERT INTO `user_role` VALUES (26, '2', '4');
INSERT INTO `user_role` VALUES (27, '1', '4');
INSERT INTO `user_role` VALUES (28, '1', '4');
INSERT INTO `user_role` VALUES (39, '2', '7');
INSERT INTO `user_role` VALUES (40, '1', '7');
INSERT INTO `user_role` VALUES (41, '15', '8');
INSERT INTO `user_role` VALUES (42, '16', '9');
INSERT INTO `user_role` VALUES (43, '1', '8');
INSERT INTO `user_role` VALUES (44, '1', '9');

SET FOREIGN_KEY_CHECKS = 1;
