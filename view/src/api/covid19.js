import * as request from '@/utils/request'
import axios from 'axios'
/**
 * 接口封装
 */
export default {
  // 总体
  getOverall() {
    let url = `/api/overall`
    return request.get(url)
  },
  // 省 累计确诊
  getProvinceList() {
    let url = `/api/province/totalDesc`
    return request.get(url)
  },
  // 省 现存
  getProvinceExisting() {
    let url = `/api/province/existing`
    return request.get(url)
  },
  // 港澳台 新增
  getSpecialRegion() {
    let url = '/api/province/specialRegion'
    return request.get(url)
  },
  // 市 新增
  getCityDataList() {
    let url = '/api/city/incr'
    return request.get(url)
  },
  // 省 日增
  getDailyList() {
    let url = `/api/daily/list`
    return request.get(url)
  }
}