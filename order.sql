DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_id` int(11) DEFAULT NULL,
  `customer` varchar(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `status` VARCHAR(10) DEFAULT 'INIT',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11795 DEFAULT CHARSET=utf8;