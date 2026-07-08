import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function getInboundData(query) {
  return request({
    url: '/system/terminal/getInboundData',
    method: 'get',
  })
}

// 查询用户列表
export function getOutboundData(query) {
  return request({
    url: '/system/terminal/getOutboundData',
    method: 'get',
  })
}

// 查询用户列表
export function getWorkloadData(query) {
  return request({
    url: '/system/terminal/getWorkloadData',
    method: 'get',
  })
}

// 查询用户列表
export function getInboundDatabykindqty(query) {
  return request({
    url: '/system/terminal/getInboundDatabykindqty',
    method: 'get',
  })
}

export function getInbounddetail(mode,year_month) {
  const data = {
    mode,year_month
  }
  return request({
    url: '/system/terminal/getInbounddetail',
    method: 'get',
    params: data
  })
}

export function getOutbounddetail(mode,year_month) {
  const data = {
    mode,year_month
  }
  return request({
    url: '/system/terminal/getOutbounddetail',
    method: 'get',
    params: data
  })
}
