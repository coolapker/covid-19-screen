<template>
  <div class="about">
    <div class="about-info">
      <p>前端技术栈：Vue + DataV + Echarts + Element UI</p>
      <p>后端技术栈：SSMP</p>
      <p>数据实时且真实，来自 <a href="https://wp.m.163.com/163/page/news/virus_report/index.html" target="_blank">网易新闻-实时更新|新冠肺炎疫情动态地图</a> </p>
      <p>作者：{{ author }}</p>
      <p>联系方式：{{ contact }}</p>
      <p>Github：<a href="https://github.com/coolapker/covid-19-screen_vue" target="_blank">covid-19-screen</a></p>
      <p>博客：<a href="https://www.cnblogs.com/mojospy" target="_blank">ね律こ</a></p>
    </div>
  </div>
</template>
<script>
export default {
  name: '',
  data () {
    return {
      author: 'mojospy',
      contact: 'coolapker@qq.com'
    }
  }
}
</script>
<style  scoped>
.about-info {
  text-align: left;
}
.about-info p {
  line-height: 30px;
}
</style>