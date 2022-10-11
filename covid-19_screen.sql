drop table if exists `t_province`;
drop table if exists `t_overall`;
# 省
CREATE TABLE t_province
(
    pid                     varchar(255) not null COMMENT '省份id',
    province_label          VARCHAR(50) COMMENT '省份名称',
    current_confirmed_count INT(11) COMMENT '现存确诊',
    confirmed_count         INT(11) COMMENT '累计确诊',
    today_confirmed_count   int(11) comment '较昨日新增',
    dead_count              INT(11) COMMENT '累计死亡',
    dead_rate               varchar(11) comment '死亡率',
    cured_count             INT(11) COMMENT '累计治愈',
    cured_rate              varchar(11) comment '治愈率',
    update_time             datetime COMMent '更新时间',
    PRIMARY KEY (pid)
);

create table t_overall
(
    confirmed_count         int(11) comment '累计确诊',
    confirmed_incr          int(11) comment '累计确诊增长',
    cured_count             int(11) comment '累计治愈',
    cured_incr              int(11) comment '累计治愈增长',
    cured_rate              varchar(11) comment '治愈率',
    current_confirmed_count int(11) comment '现有确诊',
    current_confirmed_incr  int(11) comment '现有确诊增长',
    dead_count              int(11) comment '累计死亡',
    dead_incr               int(11) comment '累计死亡增长',
    dead_rate               varchar(11) comment '死亡率',
    imported_count          int(11) comment '境外输入',
    imported_incr           int(11) comment '境外输入增长',
    no_infect_count          int(11) comment '无症状感染者',
    no_infect_incr           int(11) comment '无症状感染者新增',
    update_time             datetime comment '更新时间'
);

# create table t_daily_list(
#
# )




