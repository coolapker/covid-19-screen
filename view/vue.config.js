module.exports = {
  // transpileDependencies: true,
  lintOnSave: false,
  devServer: {
    proxy: {
      "/api": {
        target: "http://localhost", //接口域名
        changeOrigin: true, //是否跨域
        ws: true, //是否代理 websockets
        pathRewrite: {
          //路径重置
          "^/api": "",
        },
      },
    },
  },
};
