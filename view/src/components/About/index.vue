<template>
  <div class="about">
    <div class="about-info">
      <p>
        数据
        <del>实时</del>
        且真实，来自
        <a
          href="https://wp.m.163.com/163/page/news/virus_report/index.html"
          target="_blank"
          >网易新闻-实时更新|新冠肺炎疫情动态地图</a
        >
      </p>
      <p style="color: #dc0e0e">
        注意：卫健委已停更 <br />
        当前数据为此日数据 ↓
      </p>
      <p>最后更新时间：{{ updateTime }}</p>
      <p>前端技术栈：Vue + DataV + Echarts + Element UI</p>
      <p>后端技术栈：SSMP</p>
      <p>作者：{{ author }}</p>
      <p>
        Github：<a
          href="https://github.com/coolapker/covid-19-screen_vue"
          target="_blank"
          >covid-19-screen</a
        >
      </p>
      <p>
        博客：<a href="https://www.cnblogs.com/libm" target="_blank">ね律こ</a>
      </p>
    </div>
  </div>
</template>
<script>
export default {
  props: ["updateTime"],
  name: "",
  data() {
    return {
      author: "mojospy",
    };
  },
};
</script>
<style scoped>
.about-info {
  text-align: left;
}

.about-info p {
  line-height: 30px;
}
</style>
