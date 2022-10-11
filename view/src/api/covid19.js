import * as request from '@/utils/request'
import axios from 'axios'
/**
 * 接口封装
 */
export default {
  getOverall() {
    let url = `/api/overall`
    return request.get(url)
  },
  getProvinceDataList() {
    let url = `/api/province/confirmed/current`
    return request.get(url)
  },
  getSpecialRegion() {
    let url = '/api/province/specialRegion'
    return request.get(url)
  },
  getDailyList() {
    let url = `/api/province/list`
    return request.get(url)
  }
}