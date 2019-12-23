
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `employee`;

create  table `employee` (
   `id` int(11) not null auto_increment,
   `lastName` varchar(255) default null,
   `email` varchar(255) default null,
   `gender` int(2) default null,
   `d_id` int(11) default null,
   primary key (`id`)
 ) engine=InnoDB default charset=utf8;

-- insert into employee values (1, "张浩岚");

