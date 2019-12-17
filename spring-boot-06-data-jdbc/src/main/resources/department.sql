
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `department`;

create  table `department` (
   `id` int(11) not null auto_increment,
   `departmentName` varchar(255) default null,
   primary key (`id`)
 ) engine=InnoDB default charset=utf8;

insert into department values (1, "开发部");

