/*
SQLyog v10.2 
MySQL - 5.5.21 : Database - yunva-admin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yunva-admin` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yunva-admin`;

/*Table structure for table `tb_pictures` */

DROP TABLE IF EXISTS `tb_pictures`;

CREATE TABLE `tb_pictures` (
  `PICTURES_ID` varchar(100) NOT NULL,
  `TITLE` varchar(255) DEFAULT NULL COMMENT '标题',
  `NAME` varchar(255) DEFAULT NULL COMMENT '文件名',
  `PATH` varchar(255) DEFAULT NULL COMMENT '路径',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `MASTER_ID` varchar(255) DEFAULT NULL COMMENT '属于',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`PICTURES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_pictures` */

insert  into `tb_pictures`(`PICTURES_ID`,`TITLE`,`NAME`,`PATH`,`CREATETIME`,`MASTER_ID`,`BZ`) values ('1','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('2','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('21','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('2b89fc8d503f45f6b92c1949e3a8c450','图片','3510aecb641d45e78c0d55bde9ad748a.png','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('3','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('4','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('42','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('5','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('544b5c7fec1a46dba4092e14f0560dc1','图片','f07c1bbc55194886a043cfea78f88076.png','20150509/f07c1bbc55194886a043cfea78f88076.png','2015-05-09 22:23:21','1','图片管理处上传'),('64','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('66','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('7','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('76','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('94fb5e7e602549c19b38e13886139583','图片','819d4d795f22476a9181d9a5627c342a.png','20150509/819d4d795f22476a9181d9a5627c342a.png','2015-05-09 22:23:11','1','图片管理处上传'),('bb9aeacf4ce441178996a430af861f1c','图片','2ea51c4342df4d3ea918a52ff52da343.jpg','20150509/2ea51c4342df4d3ea918a52ff52da343.jpg','2015-05-09 22:23:11','1','图片管理处上传'),('df','图片',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `tbl_consume_score_rule` */

DROP TABLE IF EXISTS `tbl_consume_score_rule`;

CREATE TABLE `tbl_consume_score_rule` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `consume_min` int(11) DEFAULT '0' COMMENT '消费最小区间值 以分为单位',
  `consume_max` int(11) DEFAULT '0' COMMENT '消费区间最大值 以分为单位',
  `gain_score` int(11) DEFAULT '0' COMMENT '获取积分数量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_consume_score_rule` */

insert  into `tbl_consume_score_rule`(`id`,`consume_min`,`consume_max`,`gain_score`,`create_time`) values (1,1663,163,3663,'2016-08-08 17:38:07'),(2,227,2277,42,'2016-08-08 17:48:31'),(5,5,4,4,'2016-08-08 15:48:04'),(6,6,4,4,'2016-08-08 15:48:01'),(7,7,4,4,'2016-08-08 15:48:02'),(8,8,4,4,'2016-08-08 15:48:05'),(9,9,4,4,'2016-08-08 15:48:06'),(10,10,4,4,'2016-08-08 15:48:07'),(11,11,4,4,'2016-08-08 15:48:08'),(12,12,4,4,'2016-08-08 15:48:09'),(13,13,4,4,'2016-08-08 15:48:09'),(14,14,4,4,'2016-08-08 15:48:10'),(15,15,4,4,'2016-08-08 15:48:11'),(16,16,4,4,'2016-08-08 15:48:12'),(17,13,2,2,'2016-08-08 15:48:19'),(18,18,3,3,'2016-08-08 15:48:27');

/*Table structure for table `tbl_role_menu` */

DROP TABLE IF EXISTS `tbl_role_menu`;

CREATE TABLE `tbl_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_role_menu` */

insert  into `tbl_role_menu`(`role_id`,`menu_id`,`create_time`) values (1,1,'2016-08-08 15:44:58'),(1,2,'2016-08-08 15:44:58'),(1,5,'2016-08-08 15:44:58'),(1,6,'2016-08-08 15:44:58'),(1,7,'2016-08-08 15:44:58'),(1,8,'2016-08-08 15:44:58');

/*Table structure for table `tbl_sys_menu` */

DROP TABLE IF EXISTS `tbl_sys_menu`;

CREATE TABLE `tbl_sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `parent_id` int(11) DEFAULT '0' COMMENT '父级id',
  `menu_order` varchar(100) DEFAULT NULL COMMENT '菜单排列循序 从小到大',
  `menu_icon` varchar(30) DEFAULT NULL COMMENT '菜单图标',
  `menu_type` varchar(10) DEFAULT '1' COMMENT '菜单类型 1 系统菜单 2 业务菜单',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_sys_menu` */

insert  into `tbl_sys_menu`(`menu_id`,`menu_name`,`menu_url`,`parent_id`,`menu_order`,`menu_icon`,`menu_type`,`create_time`) values (1,'系统管理','#',0,'1','icon-th','1','0000-00-00 00:00:00'),(2,'角色管理','role.do',1,'2',NULL,'1','0000-00-00 00:00:00'),(5,'用户管理','user/listUsers.do',1,'3',NULL,'1','0000-00-00 00:00:00'),(6,'信息管理','#',0,'2','icon-calendar','2','0000-00-00 00:00:00'),(7,'图片管理','pictures/list.do',6,'1',NULL,'2','0000-00-00 00:00:00'),(8,'消费积分管理','consumeScoreRule/list.do',6,'1',NULL,'2','2016-08-08 15:44:45');

/*Table structure for table `tbl_sys_role` */

DROP TABLE IF EXISTS `tbl_sys_role`;

CREATE TABLE `tbl_sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_sys_role` */

insert  into `tbl_sys_role`(`role_id`,`role_name`,`role_desc`,`create_time`) values (1,'系统管理员',NULL,'2016-08-03 10:46:00'),(2,'运营管理人员',NULL,'2016-08-03 10:46:42'),(7,'普通人员',NULL,'2016-08-03 10:46:42');

/*Table structure for table `tbl_sys_user` */

DROP TABLE IF EXISTS `tbl_sys_user`;

CREATE TABLE `tbl_sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `role_id` varchar(100) DEFAULT NULL COMMENT '用户角色id',
  `status` int(3) DEFAULT '1' COMMENT '用户状态 1 正常 2 失效',
  `user_type` int(3) DEFAULT '1' COMMENT '用户类型 1 内部管理用户',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `skin` varchar(100) DEFAULT NULL COMMENT '皮肤',
  `email` varchar(32) DEFAULT NULL COMMENT '邮件地址',
  `number` varchar(100) DEFAULT NULL COMMENT '用户编号',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_sys_user` */

insert  into `tbl_sys_user`(`user_id`,`user_name`,`password`,`name`,`role_id`,`status`,`user_type`,`remark`,`skin`,`email`,`number`,`phone`,`create_time`) values (1,'admin','de41b7fb99201d8334c23c014db35ecd92df81bc','系统管理员','1',1,1,'最高统治者1','skin-2','admin@main.com','001','18788888881','2016-08-03 22:36:10'),(12,'123','601f1889667efaebb33b8c12572835da3f027f78','1','1',1,1,'1','default','zhangzhi19891008@126.com','123','13094445098','2016-08-08 10:18:53');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
