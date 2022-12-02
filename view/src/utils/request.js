import axios from "axios";

const request = axios.create({
  baseURL: process.env.VUE_APP_BASE_API,
  timeout: 10000,
});

// 响应拦截器
request.interceptors.response.use(
  res => {
    return res.data;
  },
  error => Promise.reject(error)
);

export default request;
