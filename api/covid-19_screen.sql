drop table if exists `t_city`;
drop table if exists `t_province`;
drop table if exists `t_overall`;
drop table if exists `t_daily`;

# 省
CREATE TABLE t_province
(
    pid                     varchar(255) not null COMMENT '省份id',
    province_label          VARCHAR(50) COMMENT '省份名称',
    current_confirmed_count INT(11) COMMENT '现有确诊',
    confirmed_count         INT(11) COMMENT '累计确诊',
    today_confirmed_count   int(11) comment '较昨日新增',
    dead_count              INT(11) COMMENT '累计死亡',
    dead_rate               varchar(11) comment '死亡率',
    cured_count             INT(11) COMMENT '累计治愈',
    cured_rate              varchar(11) comment '治愈率',
    update_time             datetime COMMent '更新时间',
    PRIMARY KEY (pid)
)comment '省份疫情信息';

# 市
create table t_city
(
    cid            varchar(255) not null comment '城市id',
    city_name      varchar(50) comment '城市名称',
    existing       INT(11) COMMENT '现有确诊',
    confirmed      INT(11) COMMENT '累计确诊',
    confirmed_incr int(11) comment '较昨日新增',
    dead           INT(11) COMMENT '死亡',
    cured          INT(11) COMMENT '治愈',
    pid            varchar(255) comment '城市表外键',
    update_time    datetime COMMent '更新时间',
    primary key (cid)
)comment '市疫情信息';

# 总体
create table t_overall
(
    confirmed_count         int(11) comment '累计确诊',
    confirmed_incr          int(11) comment '累计确诊新增',
    cured_count             int(11) comment '累计治愈',
    cured_incr              int(11) comment '累计治愈新增',
    cured_rate              varchar(11) comment '治愈率',
    current_confirmed_count int(11) comment '现有确诊',
    current_confirmed_incr  int(11) comment '现有确诊新增',
    dead_count              int(11) comment '累计死亡',
    dead_incr               int(11) comment '累计死亡新增',
    dead_rate               varchar(11) comment '死亡率',
    imported_count          int(11) comment '境外输入',
    imported_incr           int(11) comment '境外输入新增',
    no_infect_count         int(11) comment '无症状感染者',
    no_infect_incr          int(11) comment '无症状感染者新增',
    update_time             datetime comment '更新时间'
)comment '国内疫情信息';
# 日增
create table t_daily
(
    date_of      date comment '记录日期',
    confirm_count int(11) comment '累计确诊',
    confirm_incr int(11) comment '较昨日新增确诊',
    input_incr int (11) comment '境外输入新增',
    cure_incr  int (11) comment '较昨日治愈新增'

)comment ''




