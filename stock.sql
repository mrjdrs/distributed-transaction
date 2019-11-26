DROP TABLE IF EXISTS `t_stoke`;
CREATE TABLE `t_stoke` (
  `id` int(11) NOT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_stoke` VALUES ('1001', '黑色皮鞭', '100');
INSERT INTO `t_stoke` VALUES ('1002', '红蜡烛', '100');
INSERT INTO `t_stoke` VALUES ('1003', '杜蕾斯54mm', '100');
INSERT INTO `t_stoke` VALUES ('1004', '亿级流量网站架构核心技术', '100');
INSERT INTO `t_stoke` VALUES ('1005', 'IPhoneXS', '100');
INSERT INTO `t_stoke` VALUES ('1006', '云析学院BATJ高级JavaVIP', '99');
INSERT INTO `t_stoke` VALUES ('1007', '办公室趴枕', '100');