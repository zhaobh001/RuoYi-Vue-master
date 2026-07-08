package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Storesite;

/**
 * 库位Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-04
 */
public interface StoresiteMapper 
{
    /**
     * 查询库位
     * 
     * @param storesiteid 库位主键
     * @return 库位
     */
    public Storesite selectStoresiteByStoresiteid(Long storesiteid);

    /**
     * 查询库位列表
     * 
     * @param storesite 库位
     * @return 库位集合
     */
    public List<Storesite> selectStoresiteList(Storesite storesite);

    /**
     * 新增库位
     * 
     * @param storesite 库位
     * @return 结果
     */
    public int insertStoresite(Storesite storesite);

    /**
     * 修改库位
     * 
     * @param storesite 库位
     * @return 结果
     */
    public int updateStoresite(Storesite storesite);

    /**
     * 删除库位
     * 
     * @param storesiteid 库位主键
     * @return 结果
     */
    public int deleteStoresiteByStoresiteid(Long storesiteid);

    /**
     * 批量删除库位
     * 
     * @param storesiteids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStoresiteByStoresiteids(Long[] storesiteids);

    /**
     * 查询库位
     *
     * @param storesiteno 库位编码
     * @return 库位
     */
    public Storesite selectStoresiteByStoresiteno(String storesiteno);

}
