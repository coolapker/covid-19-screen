# 新冠疫情数据大屏

## 技术栈

- [SpringBoot](https://spring.io/projects/spring-boot/)
- [MybatisPlus](https://baomidou.com/)
- [Vue.js](https://cn.vuejs.org/)
- [Apache ECharts](https://echarts.apache.org/zh/index.html)
- [DataV](http://datav.jiaminghi.com/)
- [axios](https://axios-http.com/)
- [Element UI](https://element.eleme.io/#/zh-CN)

## 前端项目结构

```java
view
  └─src
     ├─api                                # 接口封装目录
     ├─components                         # 组件目录
     │  ├─About                           # 关于
     │  ├─BasicDataItemLabel              # 基本数据显示标签
     │  ├─BasicTrendChart                 # 趋势图表
     │  ├─ChartCard                       # 图表面板
     │  ├─CuredAndDeadRateChart           # 治愈率和死亡率图表
     │  ├─CurrentConfirmedCompareBarChart # 最近一周累计治愈图表
     │  ├─DataMap                         # 数据地图
     │  └─ProvinceRankingBarChart         # 累计排名图表
     ├─router                             # 路由配置
     ├─utils                              # 工具类
     └─views                              # 视图
```

## 后端项目结构

```java
api
 └─src
    ├─controller  # 控制层
    ├─domain      # 持久层
    ├─mapper      # 数据访问层
    ├─service     # 业务层
    ├─tasker      # 定时任务
    ├─util       # 工具包
    │  ├─update   # 更新数据
    │  └─Spider   # 爬虫
    └─covid_19_screen.sql # sql文件
```

## 项目构建

> 执行sql文件后再启动后端项目

```shell
# 安装依赖
npm i

# 运行
npm run serve

# 打包
npm run build
```
