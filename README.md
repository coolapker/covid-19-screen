# 新冠肺炎疫情数据大屏


## 技术栈

 - [Vue.js](https://cn.vuejs.org/)
 - [Apache ECharts](https://echarts.apache.org/zh/index.html)
 - [DataV](http://datav.jiaminghi.com/)
 - [axios](https://axios-http.com/)
 - [Element UI](https://element.eleme.io/#/zh-CN)

## 开发

代码中各种图表均已封装成组件，查看相关的代码请看组件代码。

## 项目结构

```shell
├─build
├─data                                   # 本地模拟数据目录
├─mock                                   # mock 配置
├─public
└─src
    ├─api                                # 接口封装目录
    ├─assets
    ├─components                         # 组件目录
    │  ├─About                           # 关于
    │  ├─BasicDataItemLabel              # 基本数据显示标签
    │  ├─BasicTrendChart                 # 趋势图表
    │  ├─ChartCard                       # 图表面板
    │  ├─CuredAndDeadRateChart           # 治愈率和死亡率图表
    │  ├─CurrentConfirmedCompareBarChart # 最近一周累计治愈图表
    │  ├─DataMap                         # 数据地图
    │  └─ProvinceRankingBarChart         # 累计排名图表
    ├─libs                               # 一些常用的配置
    ├─router                             # 路由配置
    ├─utils                              # 工具类
    └─views                              # 视图
```

## 项目构建

```shell
# 安装依赖
npm install

# 运行
npm run dev

# 打包
npm run build
```

