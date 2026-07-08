package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StoresiteMapper;
import com.ruoyi.system.domain.Storesite;
import com.ruoyi.system.service.IStoresiteService;

/**
 * 库位Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-04
 */
@Service
public class StoresiteServiceImpl implements IStoresiteService 
{
    @Autowired
    private StoresiteMapper storesiteMapper;

    /**
     * 查询库位
     * 
     * @param storesiteid 库位主键
     * @return 库位
     */
    @Override
    public Storesite selectStoresiteByStoresiteid(Long storesiteid)
    {
        return storesiteMapper.selectStoresiteByStoresiteid(storesiteid);
    }

    /**
     * 查询库位列表
     * 
     * @param storesite 库位
     * @return 库位
     */
    @Override
    public List<Storesite> selectStoresiteList(Storesite storesite)
    {
        return storesiteMapper.selectStoresiteList(storesite);
    }

    /**
     * 新增库位
     * 
     * @param storesite 库位
     * @return 结果
     */
    @Override
    public int insertStoresite(Storesite storesite)
    {
        return storesiteMapper.insertStoresite(storesite);
    }

    /**
     * 修改库位
     * 
     * @param storesite 库位
     * @return 结果
     */
    @Override
    public int updateStoresite(Storesite storesite)
    {
        return storesiteMapper.updateStoresite(storesite);
    }

    /**
     * 批量删除库位
     * 
     * @param storesiteids 需要删除的库位主键
     * @return 结果
     */
    @Override
    public int deleteStoresiteByStoresiteids(Long[] storesiteids)
    {
        return storesiteMapper.deleteStoresiteByStoresiteids(storesiteids);
    }

    /**
     * 删除库位信息
     * 
     * @param storesiteid 库位主键
     * @return 结果
     */
    @Override
    public int deleteStoresiteByStoresiteid(Long storesiteid)
    {
        return storesiteMapper.deleteStoresiteByStoresiteid(storesiteid);
    }

    /**
     * 查询库位
     *
     * @param storesiteno 库位编码
     * @return 库位
     */
    public Storesite selectStoresiteByStoresiteno(String storesiteno){
        return storesiteMapper.selectStoresiteByStoresiteno(storesiteno);
    }
}
