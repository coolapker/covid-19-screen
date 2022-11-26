import request from '@/utils/request';

/**
 * 接口封装
 */
export default {
	// 总体
	getOverall() {
		return request({
			method: 'get',
			url: '/overall',
		});
	},
	// 省 累计确诊
	getProvinceList() {
		return request({
			method: 'get',
			url: '/province/totalDesc',
		});
	},
	// 省 模糊查询
	searchProvince(provinceNames) {
		return request({
			method: 'get',
			url: '/province/search',
			params: {
				provinceNames,
			},
		});
	},
	// 省 现存
	getProvinceExisting() {
		return request({
			method: 'get',
			url: '/province/existing',
		});
	},
	// 港澳台 新增
	getSpecialRegion() {
		return request({
			method: 'get',
			url: '/province/specialRegion',
		});
	},
	// 市 新增
	getCityDataList() {
		return request({
			method: 'get',
			url: '/city/incr',
		});
	},
	// 市 模糊查询
	searchCity(cityNames) {
		return request({
			method: 'get',
			url: '/city/search',
			params: {
				cityNames,
			},
		});
	},
	// 省 日增
	getDailyList() {
		return request({
			method: 'get',
			url: '/daily/list',
		});
	},
};
