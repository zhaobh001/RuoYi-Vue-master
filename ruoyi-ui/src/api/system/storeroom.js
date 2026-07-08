import request from '@/utils/request'

// 查询库房列表
export function listStoreroom(query) {
  return request({
    url: '/system/storeroom/list',
    method: 'get',
    params: query
  })
}

// 查询库房详细
export function getStoreroom(storeroomid) {
  return request({
    url: '/system/storeroom/' + storeroomid,
    method: 'get'
  })
}

// 新增库房
export function addStoreroom(data) {
  return request({
    url: '/system/storeroom',
    method: 'post',
    data: data
  })
}

// 修改库房
export function updateStoreroom(data) {
  return request({
    url: '/system/storeroom',
    method: 'put',
    data: data
  })
}

// 删除库房
export function delStoreroom(storeroomid) {
  return request({
    url: '/system/storeroom/' + storeroomid,
    method: 'delete'
  })
}
