<template>
  <div class="container">
    <!--    <dv-full-screen-container>-->
    <dv-border-box-11 :title="title">
      <!-- 顶部 -->
      <div class="abc" />
      <div class="main-content">
        <el-row>
          <el-col :span="18">
            <!-- 中间信息开始 -->
            <div class="statistics-content">
              <!-- 中间左侧开始 -->
              <div class="main-inner">
                <!--左列-->
                <el-row>
                  <el-col :span="7">
                    <!--                  各市新增确诊Top10-->
                    <chart-card :customClass="`chart-item-bottom-sep`">
                      <div slot="title" class="province-table-title flex">
                        各市新增确诊
                        <el-link
                          :underline="false"
                          icon="el-icon-view"
                          style="color: #bcbcbf; padding-left: 10px"
                          @click="cityTableDialogShowHandler"
                          >详情
                        </el-link>
                      </div>
                      <province-ranking-chart
                        ref="topConfirmedCountRankChart"
                        :data="top10CityData"
                        style="width: 100%; height: 380px"
                      />
                    </chart-card>
                    <!--                  港澳台新增确诊-->
                    <chart-card
                      :customClass="`chart-item-bottom-sep`"
                      title="港澳台新增确诊"
                    >
                      <special-region-ranking-chart
                        ref="specialRegionConfirmedCountRankChart"
                        :data="specialRegionData"
                        style="width: 100%; height: 120px"
                      />
                    </chart-card>
                    <!--                  新增趋势组件-->
                    <chart-card
                      :customClass="`chart-item-bottom-sep`"
                      title="新增趋势"
                    >
                      <basic-trend-chart
                        ref="confirmedCountTrendChart"
                        :data="basicIncrTrendData"
                        style="width: 100%; height: 320px"
                      />
                    </chart-card>
                  </el-col>
                  <el-col :span="17">
                    <!-- 顶部基本统计信息开始 -->
                    <div class="basic-header flex">
                      <!-- 顶部统计信息开始 -->
                      <div class="top-basic-info">
                        <basic-data-item-label
                          :config="defaultDataConfig.currentConfirmedCount"
                          :inCrValue="basicData.currentConfirmedIncr"
                          label="现有确诊"
                        />
                        <basic-data-item-label
                          :config="defaultDataConfig.confirmedCount"
                          :inCrValue="basicData.confirmedIncr"
                          label="累计确诊"
                        />
                        <!-- 境外输入 -->
                        <basic-data-item-label
                          :config="defaultDataConfig.importedCount"
                          :inCrValue="basicData.importedIncr"
                          label="境外输入"
                        />
                        <!-- 无症状感染者 -->
                        <basic-data-item-label
                          :config="defaultDataConfig.noInfectCount"
                          :inCrValue="basicData.noInfectIncr"
                          label="无症状感染者"
                        />
                        <!-- 累计治愈 -->
                        <basic-data-item-label
                          :config="defaultDataConfig.curedCount"
                          :inCrValue="basicData.curedIncr"
                          label="累计治愈"
                        />
                        <!-- 死亡人数 -->
                        <basic-data-item-label
                          :config="defaultDataConfig.deadCount"
                          :inCrValue="basicData.deadIncr"
                          label="累计死亡"
                        />
                      </div>
                      <!-- 顶部统计信息结束 -->
                    </div>
                    <!-- 顶部基本统计信息开始 -->
                    <div class="main-inner-map-wraper">
                      <!-- 地图 -->
                      <div class="map">
                        <!--                        <el-button-group>-->
                        <el-button
                          :style="countStyle"
                          type="info"
                          @click="changeData('count')"
                          >累计
                        </el-button>
                        <el-button
                          :style="existingStyle"
                          type="info"
                          @click="changeData('existing')"
                          >现存
                        </el-button>
                        <!--                        </el-button-group>-->
                        <data-map
                          ref="dataMap"
                          :list="mapDataList"
                          style="width: 100%; height: 100%"
                          title=""
                        />
                      </div>
                    </div>
                  </el-col>
                </el-row>
              </div>
              <!-- 中间左侧结束 -->
            </div>
            <!-- 中间信息结束 -->
          </el-col>
          <el-col :span="6">
            <!-- 右侧区域开始 -->
            <div class="main-right">
              <chart-card
                :customClass="`chart-item-bottom-sep`"
                :innerClass="`cure-and-dead-rate-chart`"
                title="治愈率和死亡率"
              >
                <cured-and-dead-rate-chart
                  ref="cureRateChart"
                  :data="rate"
                  style="width: 280px; height: 130px"
                  title="治愈率"
                />
              </chart-card>

              <chart-card
                :customClass="`chart-item-bottom-sep`"
                title="最近一周累计治愈"
              >
                <current-confirmed-compare-bar-chart
                  ref="confirmSingleBarChart"
                  :data="confirmSingleBarChartData"
                  style="width: 100%; height: 310px"
                />
              </chart-card>
              <chart-card>
                <div slot="title" class="province-table-title flex">
                  各省累计确诊
                  <el-link
                    :underline="false"
                    icon="el-icon-view"
                    style="color: #bcbcbf; padding-left: 10px"
                    @click="provinceTableDialogShowHandler"
                    >详情
                  </el-link>
                </div>
                <dv-scroll-board
                  :config="provinceConfirmedCountBoardConfig"
                  style="width: 100%; height: 360px"
                />
              </chart-card>
            </div>
            <!-- 右侧区域结束 -->
          </el-col>
        </el-row>
      </div>
      <!-- 其他页面 -->
      <div class="province-data-table-wrapper">
        <!--      省份信息对话框-->
        <el-dialog
          :before-close="provinceTableDialogClose"
          :visible.sync="provinceTableDialogVisible"
          width="50%"
        >
          <div slot="title" class="province-data-modal-title">
            <p>各省数据表</p>
            <span class="province-data-modal-update-time"
              >（更新时间：{{ basicData.updateTime }}）</span
            >
          </div>

          <div style="margin-top: 15px">
            <el-input v-model="provinceName" placeholder="请输入省份名">
              <el-button
                slot="append"
                icon="el-icon-search"
                @click="searchProvince"
              ></el-button>
            </el-input>
          </div>

          <div class="area-data-table-wrapper">
            <el-table
              ref="provinceTable"
              :data="provinceDataList"
              class="area-data-table"
              style="width: 100%"
            >
              <el-table-column align="center" label="省份" prop="provinceLabel">
              </el-table-column>
              <el-table-column
                align="center"
                label="累计确诊"
                prop="confirmedCount"
                sortable
              >
              </el-table-column>
              <el-table-column
                align="center"
                label="现有确诊"
                prop="currentConfirmedCount"
                sortable
              >
              </el-table-column>
              <el-table-column
                align="center"
                label="较昨日新增"
                prop="todayConfirmedCount"
                sortable
              >
              </el-table-column>
              <el-table-column
                align="center"
                label="累计治愈"
                prop="curedCount"
                sortable
              >
              </el-table-column>
              <el-table-column
                align="center"
                label="累计死亡"
                prop="deadCount"
                sortable
              >
              </el-table-column>
            </el-table>
          </div>
        </el-dialog>
        <el-dialog
          :before-close="cityTableDialogClose"
          :visible.sync="cityTableDialogVisible"
          width="50%"
        >
          <div slot="title" class="province-data-modal-title">
            <p>各市数据表</p>
            <span class="province-data-modal-update-time"
              >（更新时间：{{ basicData.updateTime }}）</span
            >
          </div>

          <div style="margin-top: 15px">
            <el-input v-model="cityName" placeholder="请输入城市名">
              <el-button
                slot="append"
                icon="el-icon-search"
                @click="searchCity"
              ></el-button>
            </el-input>
          </div>

          <div class="area-data-table-wrapper">
            <el-table
              ref="cityTable"
              :data="cityDataList"
              class="area-data-table"
              style="width: 100%"
            >
              <el-table-column align="center" label="城市" prop="cityName">
              </el-table-column>
              <el-table-column
                align="center"
                label="较昨日新增"
                prop="confirmedIncr"
                sortable
              >
              </el-table-column>
              <el-table-column
                align="center"
                label="累计确诊"
                prop="confirmed"
                sortable
              >
              </el-table-column>
              <el-table-column
                align="center"
                label="现有确诊"
                prop="existing"
                sortable
              >
              </el-table-column>
              <el-table-column
                align="center"
                label="累计治愈"
                prop="cured"
                sortable
              >
              </el-table-column>
              <el-table-column
                align="center"
                label="累计死亡"
                prop="dead"
                sortable
              >
              </el-table-column>
            </el-table>
          </div>
        </el-dialog>
        <!-- 关于弹窗 -->
        <el-dialog
          :before-close="aboutDialogClose"
          :visible.sync="aboutDialogVisible"
          title="关于"
          width="30%"
        >
          <about :updateTime="basicData.updateTime"></about>
        </el-dialog>
        <!-- 关于图标 -->
        <div class="about-wraper">
          <i
            class="el-icon-info"
            style="font-size: 30px"
            @click="aboutDialogShowHandler"
          ></i>
        </div>
      </div>
    </dv-border-box-11>
    <!--    </dv-full-screen-container>-->
  </div>
</template>
<script>
// 引入组件
import ChartCard from "../components/ChartCard";
import DataMap from "../components/DataMap";
import CuredAndDeadRateChart from "../components/CuredAndDeadRateChart";
import BasicDataItemLabel from "../components/BasicDataItemLabel";
import BasicTrendChart from "../components/BasicTrendChart";
import SpecialRegionRankingChart from "../components/RankingChart/SpecialRegionRankingChart";
import CurrentConfirmedCompareBarChart from "../components/CurrentConfirmedCompareBarChart";
import About from "../components/About";

import covid19Service from "../api/covid19";
import ProvinceRankingChart from "@/components/RankingChart/ProvinceRankingChart";

const formatter = (number) => {
  const numbers = number.toString().split("").reverse();
  const segs = [];
  while (numbers.length) segs.push(numbers.splice(0, 3).join(""));
  return segs.join(",").split("").reverse().join("");
};
// 数据样式
const getNumberStyle = (
  color = "#E8EAF6",
  fontSize = 30,
  fontWeight = "bolder"
) => {
  return {
    fontSize: fontSize,
    fill: color,
    fontWeight: fontWeight,
  };
};

const initBasicConfig = (data = null) => {
  let currentConfirmedCount = data ? [data.currentConfirmedCount] : 0;
  let confirmedCount = data ? [data.confirmedCount] : 0;
  let importedCount = data ? [data.importedCount] : 0;
  let noInfectCount = data ? [data.noInfectCount] : 0;
  let deadCount = data ? [data.deadCount] : 0;
  let curedCount = data ? [data.curedCount] : 0;
  return {
    confirmedCount: {
      number: [confirmedCount],
      content: "{nt}",
      formatter,
      style: getNumberStyle(),
    },
    currentConfirmedCount: {
      number: [currentConfirmedCount],
      content: "{nt}",
      formatter,
      style: getNumberStyle("#2E8EEA"),
    },
    importedCount: {
      number: [importedCount],
      content: "{nt}",
      formatter,
      style: getNumberStyle(),
    },
    noInfectCount: {
      number: [noInfectCount],
      content: "{nt}",
      formatter,
      style: getNumberStyle(),
    },
    deadCount: {
      number: [deadCount],
      content: "{nt}",
      formatter,
      style: getNumberStyle("#D32E58"),
    },
    curedCount: {
      number: [curedCount],
      content: "{nt}",
      formatter,
      style: getNumberStyle(),
    },
  };
};

const initProvinceConfirmedCountBoardConfig = (resultList = []) => {
  return {
    header: ["省份", "累计确诊", "累计治愈", "累计死亡"],
    headerHeight: 30,
    data: resultList,
    align: ["center"],
    rowNum: 10,
    index: true,
    indexHeader: "排名",
    headerBGC: "",
    oddRowBGC: "",
    evenRowBGC: "",
    carousel: "single",
  };
};
export default {
  components: {
    ProvinceRankingChart,
    ChartCard,
    DataMap,
    CuredAndDeadRateChart,
    BasicDataItemLabel,
    BasicTrendChart,
    SpecialRegionRankingChart,
    CurrentConfirmedCompareBarChart,
    About,
    // BasicProportionChart
  },
  data() {
    return {
      cityName: "",
      provinceName: "",
      countStyle: "background-color: #06061A",
      existingStyle: "background-color: #26254F",
      title: "新冠疫情数据大屏",
      provinceTableDialogVisible: false,
      cityTableDialogVisible: false,
      aboutDialogVisible: false,
      commonData: {},
      basicData: {
        currentConfirmedCount: 0,
        currentConfirmedIncr: 0,
        confirmedCount: 0,
        confirmedIncr: 0,
        curedCount: 0,
        curedIncr: 0,
        deadCount: 0,
        deadIncr: 0,
        sure: 0,
        sureAdd: 0,
        importedCount: 0,
        importedIncr: 0,
        noInfectCount: 0,
        noInfectIncr: 0,
        updateTime: "",
      },
      defaultDataConfig: initBasicConfig(),
      cureRateConfig: {
        data: [0],
        shape: "round",
      },
      deadRateConfig: {
        data: [0],
        shape: "round",
      },
      countryRankingTakeTurnChartConfig: {
        data: [],
        waitTime: 2000,
        unit: "单位",
        valueFormatter({ value }) {
          const reverseNumber = (value + "").split("").reverse();
          let valueStr = "";

          while (reverseNumber.length) {
            const seg = reverseNumber.splice(0, 3).join("");
            valueStr += seg;
            if (seg.length === 3) valueStr += ",";
          }

          return valueStr.split("").reverse().join("");
        },
      },
      provinceConfirmedCountBoardConfig:
        initProvinceConfirmedCountBoardConfig(),
      // 对话框搜索数据
      provinceDataList: [],
      cityDataList: [],
      trendDataList: [],
      confirmedCountList: [],
      // 市 现存数据
      top10CityData: {
        cityList: [],
        valueList: [],
      },
      // 港澳台数据
      specialRegionData: {
        regionList: [],
        valueList: [],
      },
      // 趋势数据
      basicIncrTrendData: {
        dateList: [],
        importedIncrDataList: [],
        currentConfirmedIncrDataList: [],
      },
      // 最近一周累计治愈数据
      confirmSingleBarChartData: {
        dateList: [],
        curedCountList: [],
        currentConfirmedCountList: [],
        confirmedCountList: [],
      },
      rate: {
        curedRate: 0,
        deadRate: 0,
      },
      areaData: {},
      mapDataList: [],
    };
  },
  methods: {
    searchCity() {
      covid19Service.searchCity(this.cityName).then((res) => {
        this.cityDataList = res.data;
      });
    },
    searchProvince() {
      covid19Service.searchProvince(this.provinceName).then((res) => {
        this.provinceDataList = res.data;
      });
    },
    queryBasicData() {
      let self = this;
      covid19Service.getOverall().then((res) => {
        self.basicData = res.data;
        self.setBasicData(res.data);
      });
    },
    queryProvinceDataList() {
      let self = this;
      covid19Service.getSpecialRegion().then((res) => {
        if (!res.success) {
          // TODO 错误处理...
          console.log("错误:" + res.info);
          return;
        }
        self.specialRegionData = res.data;
        self.setSpecialRegionRankingData(res.data);
      });
      // 市数据
      covid19Service.getCityDataList().then((res) => {
        self.top10CityData = res.data;
        self.setTop10CityData(res.data);
        self.cityDataList = res.data;
      });

      covid19Service.getProvinceList().then((res) => {
        if (!res.success) {
          // TODO 错误处理...
          console.log("错误:" + res.info);
          return;
        }
        self.provinceDataList = res.data;
        self.setAreaChartData(res.data);
        // 设置累计排名数据
        self.setProvinceRankingData(res.data);
        // 设置各省累计确诊轮播表格数据
        self.setProvinceConfirmedCountBoardData(res.data);
      });
    },
    // 地图更改数据
    changeData(type) {
      if (type === "existing") {
        this.existingStyle = "background-color: #26254F";
        this.countStyle = "background-color: #06061A";
        covid19Service.getProvinceExisting().then((res) => {
          this.setMapData(res.data, "existing");
        });
      }
      if (type === "count") {
        this.countStyle = "background-color: #5D0773";
        this.existingStyle = "background-color: #06061A";
        covid19Service.getProvinceList().then((res) => {
          this.setMapData(res.data, "count");
        });
      }
    },
    // 查询趋势
    queryTrendDataList() {
      let self = this;
      covid19Service.getDailyList().then((res) => {
        self.trendDataList = res.data;
        // 重置图表数据
        self.setBasicIncrTrendData(res.data);
      });
    },
    setProvinceRankingData(areaList) {
      let provinceList = [];
      let dataValueList = [];
      for (let i = 0; i < 10; i++) {
        provinceList.push(areaList[i].provinceLabel);
        dataValueList.push(areaList[i].currentConfirmedCount);
      }
    },
    // 设置港澳台数据
    setSpecialRegionRankingData(specialRegionList) {
      let specialRegion = [];
      let dataValueList = [];
      for (let i = 0; i < 3; i++) {
        specialRegion.push(specialRegionList[i].provinceLabel);
        dataValueList.push(specialRegionList[i].todayConfirmedCount);
      }
      this.specialRegionData = {
        regionList: specialRegion,
        valueList: dataValueList,
      };
    },
    // 设置市新增数据
    setTop10CityData(cityData) {
      let top10City = [];
      let top10Value = [];
      for (let i = 0; i < 10; i++) {
        top10City.push(cityData[i].cityName);
        top10Value.push(cityData[i].confirmedIncr);
      }
      this.top10CityData = {
        cityList: top10City,
        valueList: top10Value,
      };
    },
    setBasicIncrTrendData(data) {
      let dateList = [];
      let currentConfirmedIncrList = [];
      let importedIncrList = [];

      let sevenDayDateList = [];
      // 仅显示一周条数据
      let confirmedCountList = [];
      let curedCountList = [];
      // 仅获取7条数据
      let count = 7;
      // let noInfectDataList = []
      //
      for (let i = data.currentConfirmedIncrList.length - 1; i >= 0; i--) {
        dateList.push(data.currentConfirmedIncrList[i][0]);
        currentConfirmedIncrList.push(data.currentConfirmedIncrList[i][1]);
      }
      for (let i = data.importedIncrList.length - 1; i >= 0; i--) {
        importedIncrList.push(data.importedIncrList[i][1]);
      }
      // for (let i = data.noInfectCountList.length - 1; i >= 0; i--) {
      //   noInfectDataList.push(data.noInfectCountList[i][1])
      // }

      for (let i = count; i >= 0; i--) {
        if (confirmedCountList.length >= count) {
          break;
        }
        sevenDayDateList.push(data.confirmedCountList[i][0]);
        confirmedCountList.push(data.confirmedCountList[i][1]);
      }
      for (let i = count; i >= 0; i--) {
        if (curedCountList.length >= count) {
          break;
        }
        curedCountList.push(data.curedCountList[i][1]);
      }

      this.basicIncrTrendData = {
        dateList: dateList,
        importedIncrDataList: importedIncrList,
        currentConfirmedIncrDataList: currentConfirmedIncrList,
        //   noInfectDataList: noInfectDataList
      };
      this.confirmSingleBarChartData = {
        dateList: sevenDayDateList,
        curedCountList: curedCountList,
        confirmedCountList: confirmedCountList,
      };
    },
    setProvinceConfirmedCountBoardData(areaList) {
      let resultList = areaList.map((item) => {
        return [
          item.provinceLabel,
          item.confirmedCount,
          item.curedCount,
          item.deadCount,
        ];
      });
      // 重新生成，否则无法刷新状态
      this.provinceConfirmedCountBoardConfig =
        initProvinceConfirmedCountBoardConfig(resultList);
    },
    setAreaChartData(areaList) {
      let confirmedCountList = [];
      let provinceList = [];
      let curedCountList = [];
      let deadCountList = [];
      areaList.forEach((item) => {
        provinceList.push(item.provinceLabel);
        confirmedCountList.push(item.confirmedCount);
        curedCountList.push(item.curedCount);
        deadCountList.push(item.deadCount);
      });
      this.areaData = {
        provinceList: provinceList,
        confirmedCountList: confirmedCountList,
        curedCountList: curedCountList,
        deadCountList: deadCountList,
      };
    },
    setMapData(dataList, type) {
      let list = dataList.map((item) => {
        if (type === "count") {
          return {
            name: item.provinceLabel,
            value: item.confirmedCount,
          };
        }
        if (type === "existing") {
          return {
            name: item.provinceLabel,
            value: item.currentConfirmedCount,
          };
        }
      });
      this.mapDataList = list;
    },
    provinceTableDialogShowHandler() {
      this.provinceTableDialogVisible = true;
    },
    cityTableDialogShowHandler() {
      this.cityTableDialogVisible = true;
    },
    provinceTableDialogClose() {
      this.provinceTableDialogVisible = false;
      this.provinceName = "";
      covid19Service.getProvinceList().then((res) => {
        this.provinceDataList = res.data;
      });
      this.$refs.provinceTable.clearSort();
    },
    cityTableDialogClose() {
      this.cityTableDialogVisible = false;
      // 退出后恢复原样
      this.cityName = "";
      covid19Service.getCityDataList().then((res) => {
        this.cityDataList = res.data;
      });
      // 清除排序状态
      this.$refs.cityTable.clearSort();
    },
    aboutDialogShowHandler() {
      this.aboutDialogVisible = true;
    },
    aboutDialogClose() {
      this.aboutDialogVisible = false;
    },
    setBasicData(data) {
      // 重新生成，否则视图不更新
      let config = initBasicConfig(data);
      this.defaultDataConfig = config;
      // 处理治愈率和死亡率
      this.rate = {
        curedRate: data.curedRate / 100,
        deadRate: data.deadRate / 100,
      };
    },
    startQueryData() {
      this.queryBasicData();
      this.queryProvinceDataList();
      this.queryTrendDataList();
    },
    initAllChart() {
      this.$refs.dataMap.initChart();
      this.$refs.cureRateChart.initChart();
      this.$refs.confirmedCountTrendChart.initChart();
      this.$refs.topConfirmedCountRankChart.initChart();
      // 初始化港澳台
      this.$refs.specialRegionConfirmedCountRankChart.initChart();
      this.$refs.confirmSingleBarChart.initChart();
      // this.$refs.basicProportionChart.initChart()
    },
  },
  mounted() {
    this.initAllChart();
    this.startQueryData();
    // 地图默认显示现存确诊
    covid19Service.getProvinceExisting().then((res) => {
      this.setMapData(res.data, "existing");
    });

    let self = this;
    // 定义定时器，隔 5 秒刷新一次
    this.timer = setInterval(() => {
      self.startQueryData();
    }, 1000000);
  },
  beforeDestroy() {
    clearInterval(this.timer);
  },
};
</script>
<style>
.container {
  position: relative;
}

.abc {
  /*font-size: 35px;*/
  /*font-weight: bold;*/
  padding: 27px;
}

.flex {
  display: flex;
}

.top-header {
  position: relative;
  margin-bottom: 10px;
}

.top-header-tip {
  font-size: 14px;
  position: absolute;
  padding: 20px 20px;
  text-align: right;
  top: 0;
  right: 0;
}

.title {
  min-width: 350px;
}

.chart-card {
  background: #0f142b;
  border-radius: 10px;
  margin: 0 20px;
}

.main-inner-map-wraper {
  height: 100%;
  margin: 0 20px;
}

.map {
  width: 99%;
  height: 840px;
  padding: 20px 10px 10px 10px;
}

.province-scroll-board-wrapper {
  padding-top: 10px;
  padding-bottom: 10px;
}

.chart-item-bottom-sep {
  margin-bottom: 20px;
}

.province-table-title {
  color: #fff;
  font-size: 16px;
  font-weight: bold;
  padding: 10px 10px 10px 20px;
  text-align: left;
}

.basic-incr-trend-chart-wrapper {
  padding-bottom: 10px;
}

.sub-title,
.last-update-time,
.province-scroll-board-wrapper ::v-deep .dv-scroll-board .header,
.province-scroll-board-wrapper ::v-deep .dv-scroll-board .rows {
  font-size: 14px;
}

.province-scroll-board-wrapper ::v-deep .dv-scroll-board .rows {
  color: #bcbcbf;
}

.province-data-modal-title {
  color: #000;
  font-size: 20px;
  font-weight: bold;
}

.province-data-modal-update-time {
  color: #58585a;
  font-size: 16px;
  font-weight: normal;
  padding-top: 10px;
  display: block;
}

.cure-and-dead-rate-chart {
  display: flex;
  justify-content: space-around;
}

.top-basic-info {
  display: flex;
}

.dv-scroll-ranking-board .ranking-column .inside-column {
  background: linear-gradient(90deg, #29bfff, #a231ff, #0deccd, #29bfff);
}

.chart-item-container {
  margin: 0 10px;
}

.about-wraper {
  position: fixed;
  bottom: 20px;
  right: 20px;
}
</style>
