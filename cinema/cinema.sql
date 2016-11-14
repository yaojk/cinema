# Host: localhost  (Version: 5.6.21-log)
# Date: 2016-11-13 20:53:00
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "category"
#

INSERT INTO `category` VALUES (1,'青春片'),(2,'爱情片'),(3,'战争片'),(4,'武侠片'),(5,'体育片'),(6,'科幻片'),(7,'西部片'),(8,'动作片'),(9,'喜剧片'),(10,'恐怖片');

#
# Structure for table "categorysecond"
#

DROP TABLE IF EXISTS `categorysecond`;
CREATE TABLE `categorysecond` (
  `csid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `csname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`csid`),
  KEY `cid` (`cid`),
  CONSTRAINT `FK_CATEGORY_RELATIONS_CATEGORY` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`),
  CONSTRAINT `categorysecond_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "categorysecond"
#

INSERT INTO `categorysecond` VALUES (1,1,'校园剧情'),(2,3,'抗日战争'),(3,4,'国产武侠片'),(4,1,'222');

#
# Structure for table "movie"
#

DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `movieid` int(11) NOT NULL AUTO_INCREMENT,
  `csid` int(11) DEFAULT NULL,
  `mname` varchar(50) DEFAULT NULL,
  `mdirector` varchar(50) DEFAULT NULL,
  `mstar` varchar(255) DEFAULT NULL,
  `mtype` varchar(50) DEFAULT NULL,
  `mcountry` varchar(20) DEFAULT NULL,
  `mstory` varchar(255) DEFAULT NULL,
  `mduration` varchar(255) DEFAULT NULL,
  `mpremiere` date DEFAULT NULL,
  `mis_hot` int(11) DEFAULT NULL,
  `mimage` varchar(255) DEFAULT NULL,
  `marketprice` double DEFAULT NULL,
  `shopprice` double DEFAULT NULL,
  `mticketcount` varchar(255) DEFAULT NULL,
  `mscore` float DEFAULT NULL,
  PRIMARY KEY (`movieid`),
  KEY `csid` (`csid`),
  CONSTRAINT `movie_ibfk_1` FOREIGN KEY (`csid`) REFERENCES `categorysecond` (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Data for table "movie"
#

INSERT INTO `movie` VALUES (1,1,'热血高校','姚俭康1','张富强','青春','中国','校园生活','1','2012-11-11',0,'20161109112853477.jpg',1,12,'212',3),(5,2,'抗日奇侠','大','我去玩','抗日','中国','撒大帝撒','67分钟','2012-11-11',1,'20161110143514636.jpg',23,21,'111',6.4),(6,2,'11','22','22','22','22','阿萨','22','2012-11-11',1,'20161110143522228.jpg',11,22,'2',2),(7,1,'1','11','2','1','2','11','2','1022-10-10',1,'20161110143537526.jpg',1,2,'1',2),(8,3,'22','22','','2','','2222','','2012-11-11',1,'20161110143528874.jpg',22,NULL,'22',NULL),(9,4,'22','22','2','11','2','2','23','1022-10-10',1,'20161110143601790.png',2222,2,'1',33),(10,4,'233','w','1','ww','1','11111111','1','2012-11-11',1,'20161110143626638.png',33,1,'22',1),(11,1,'2','','','','','222','',NULL,1,'20161110143707932.jpg',22,NULL,'',NULL),(12,1,'','','','','','','',NULL,1,'20161110143729837.png',NULL,NULL,'',NULL),(13,1,'','','','','','','',NULL,1,'20161110143745461.jpg',NULL,NULL,'',NULL),(14,1,'','','','','','','',NULL,1,'20161110143756555.png',NULL,NULL,'',NULL),(15,1,'22','2','2','2','2','2','2','1022-10-10',1,'20161108200329617.jpg',22,212,'2',NULL);

#
# Structure for table "news"
#

DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `newsid` int(11) NOT NULL AUTO_INCREMENT,
  `newscontent` varchar(255) DEFAULT NULL,
  `newstime` date DEFAULT NULL,
  PRIMARY KEY (`newsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "news"
#


#
# Structure for table "sysfunction"
#

DROP TABLE IF EXISTS `sysfunction`;
CREATE TABLE `sysfunction` (
  `funid` int(11) NOT NULL AUTO_INCREMENT,
  `sys_funid` int(11) DEFAULT NULL,
  `funname` varchar(20) DEFAULT NULL,
  `funurl` varchar(50) DEFAULT NULL,
  `funstate` int(11) DEFAULT NULL,
  PRIMARY KEY (`funid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

#
# Data for table "sysfunction"
#

INSERT INTO `sysfunction` VALUES (7,-1,'电影商城管理','111',1),(8,-1,'系统管理','222',1),(9,7,'电影管理','333',1),(10,7,'评论管理','444',1),(11,7,'新闻管理','555',1),(12,7,'公告管理','666',1),(13,7,'一级分类管理','777',1),(14,7,'二级分类','888',1),(15,7,'订单管理','999',1),(16,7,'用户管理','1000',1),(17,8,'角色管理','1001',1),(18,8,'系统功能管理','1002',1);

#
# Structure for table "sysrole"
#

DROP TABLE IF EXISTS `sysrole`;
CREATE TABLE `sysrole` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) DEFAULT NULL,
  `rolestate` int(11) DEFAULT NULL,
  `roledesc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "sysrole"
#

INSERT INTO `sysrole` VALUES (1,'超级管理员',1,'管理整个系统'),(2,'普通管理员',1,'管理部分系统');

#
# Structure for table "sysadmin"
#

DROP TABLE IF EXISTS `sysadmin`;
CREATE TABLE `sysadmin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `adminname` varchar(20) DEFAULT NULL,
  `adminpwd` varchar(20) DEFAULT NULL,
  `admintruename` varchar(20) DEFAULT NULL,
  `adminstate` int(11) DEFAULT NULL,
  PRIMARY KEY (`adminid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `sysadmin_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `sysrole` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "sysadmin"
#

INSERT INTO `sysadmin` VALUES (1,1,'yjk','123','姚俭康',1);

#
# Structure for table "roleright"
#

DROP TABLE IF EXISTS `roleright`;
CREATE TABLE `roleright` (
  `rrid` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `funid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rrid`),
  KEY `roleid` (`roleid`),
  KEY `funid` (`funid`),
  CONSTRAINT `roleright_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `sysrole` (`roleid`),
  CONSTRAINT `roleright_ibfk_2` FOREIGN KEY (`funid`) REFERENCES `sysfunction` (`funid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "roleright"
#


#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `uname` varchar(20) DEFAULT NULL,
  `uemail` varchar(50) DEFAULT NULL,
  `uphone` varchar(50) DEFAULT NULL,
  `uaddr` varchar(50) DEFAULT NULL,
  `ustate` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'yjk','123','姚俭康','931051853@qq.com','18435185908','山西省太原市',1,'1'),(2,'1','1',NULL,NULL,NULL,NULL,NULL,NULL),(3,'2','2',NULL,NULL,NULL,NULL,NULL,NULL),(4,'1111','1',NULL,NULL,NULL,NULL,NULL,NULL);

#
# Structure for table "orders"
#

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `ordertime` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `addr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `uid` (`uid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

#
# Data for table "orders"
#

INSERT INTO `orders` VALUES (1,1,333,'2013-11-11',1,'姚俭康','18435185908','平遥'),(14,1,21,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(15,1,21,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(16,1,21,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(17,1,21,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(18,1,22,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(19,1,22,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(20,1,21,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(21,1,21,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(22,1,21,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(23,1,42,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(24,1,12,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(25,1,21,'2016-11-10',1,'姚俭康','18435185908','山西省太原市'),(26,1,21,'2016-11-10',1,'姚俭康','18435185908','山西省太原市');

#
# Structure for table "orderitem"
#

DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `movieid` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `movieid` (`movieid`),
  KEY `oid` (`oid`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`movieid`) REFERENCES `movie` (`movieid`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "orderitem"
#

INSERT INTO `orderitem` VALUES (1,7,1,21,222),(2,1,1,1,11);

#
# Structure for table "comment"
#

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `movieid` int(11) DEFAULT NULL,
  `ccontent` varchar(255) DEFAULT NULL,
  `commenttime` date DEFAULT NULL,
  `cis_hot` int(11) DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `uid` (`uid`),
  KEY `movieid` (`movieid`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`movieid`) REFERENCES `movie` (`movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "comment"
#

INSERT INTO `comment` VALUES (1,1,1,'不错，满分','2011-11-11',1);
