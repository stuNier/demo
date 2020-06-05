CREATE TABLE `order` (
`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '主键',
`userId` INT ( 11 ) NOT NULL COMMENT 'user id',
`bookId` INT ( 11 ) NOT NULL COMMENT 'book id',
`unitPrice` NUMERIC ( 20, 4 ) NOT NULL COMMENT '单价',
`number` INT ( 11 ) NOT NULL COMMENT '数量',
`createdTime` TIMESTAMP NOT NULL COMMENT '创建时间',
`updateTime` TIMESTAMP NOT NULL COMMENT '更新时间',
`status` VARCHAR ( 30 ) NOT NULL DEFAULT '01' COMMENT '状态',
PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '订单';
