DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `customer` varchar(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11795 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_stoke`;
CREATE TABLE `t_stoke` (
  `id` int(11) NOT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;