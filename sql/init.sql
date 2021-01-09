
CREATE TABLE `t_course` (
    `F_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `F_no` varchar(30) NOT NULL COMMENT '课程编号',
    `F_name` varchar(30) DEFAULT NULL COMMENT '课程名',
    `F_teacher` varchar(30) DEFAULT NULL COMMENT '教师',
    `F_gmt_create` datetime DEFAULT null COMMENT '创建时间',
    `F_gmt_update` datetime DEFAULT null COMMENT '更新时间',
    `F_deleted` tinyint(2) default 0 comment '逻辑删除标识',
    `F_version` int(11) default 0 comment '版本号',
    PRIMARY KEY (F_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_student` (
     `F_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
     `F_name` varchar(30) DEFAULT NULL COMMENT '姓名',
     `F_age` int(11) DEFAULT NULL COMMENT '年龄',
     `F_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
     `F_gmt_create` datetime DEFAULT null COMMENT '创建时间',
     `F_gmt_update` datetime DEFAULT null COMMENT '更新时间',
     `F_deleted` tinyint(2) default 0 comment '逻辑删除标识',
     `F_version` int(11) default 0 comment '版本号',
     PRIMARY KEY (`F_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO t_student (F_id, F_name, F_age, F_email, F_gmt_create, F_gmt_update, F_version, F_deleted) VALUES (1, 'Annie', 21, 'Annie@abc.com', now(), now(), 0, 0);
INSERT INTO t_student (F_id, F_name, F_age, F_email, F_gmt_create, F_gmt_update, F_version, F_deleted) VALUES (2, 'Bob', 20, 'Bob@abc.com', now(), now(), 0, 0);
INSERT INTO t_student (F_id, F_name, F_age, F_email, F_gmt_create, F_gmt_update, F_version, F_deleted) VALUES (3, 'Cindy', 15, 'Cindy@abc.com', now(), now(), 0, 0);
INSERT INTO t_student (F_id, F_name, F_age, F_email, F_gmt_create, F_gmt_update, F_version, F_deleted) VALUES (4, 'Dave', 20, 'Dave@abc.com', now(), now(), 0, 0);
INSERT INTO t_student (F_id, F_name, F_age, F_email, F_gmt_create, F_gmt_update, F_version, F_deleted) VALUES (5, 'Elaina', 18, 'Elaina@abc.com', now(), now(), 0, 0);
INSERT INTO t_student (F_id, F_name, F_age, F_email, F_gmt_create, F_gmt_update, F_version, F_deleted) VALUES (6, 'Frank', 18, 'Frank@abc.com', now(), now(), 0, 0);