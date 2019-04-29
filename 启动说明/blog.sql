CREATE DATABASE my_demo;

USE my_demo;

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(200),
 `sex` varchar(20),
 `age` int(20),
 `address` varchar(200),
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `user` VALUES ('1', '张三', '男','12','北京');
INSERT INTO `user` VALUES ('2', '李四', '男','24','上海');
INSERT INTO `user` VALUES ('3', '王五', '男','48','南京');
INSERT INTO `user` VALUES('4', '陈其', '男','35','日本');
INSERT INTO `user` VALUES ('5', '刘八', '男','72','东北');