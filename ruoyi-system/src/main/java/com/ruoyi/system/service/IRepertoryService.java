package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Repertory;
import com.ruoyi.system.domain.Storeroom;

/**
 * 货物库存Service接口
 *
 * @author ruoyi
 * @date 2023-07-30
 */
public interface IRepertoryService
{
    /**
     * 查询货物库存
     *
     * @param repertoryid 货物库存主键
     * @return 货物库存
     */
    public Repertory selectRepertoryByRepertoryid(Long repertoryid);

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> selectRepertoryList(Repertory repertory);

    /**
     * 新增货物库存
     *
     * @param repertory 货物库存
     * @return 结果
     */
    public int insertRepertory(Repertory repertory);

    /**
     * 修改货物库存
     *
     * @param repertory 货物库存
     * @return 结果
     */
    public int updateRepertory(Repertory repertory);

    /**
     * 批量删除货物库存
     *
     * @param repertoryids 需要删除的货物库存主键集合
     * @return 结果
     */
    public int deleteRepertoryByRepertoryids(Long[] repertoryids);

    /**
     * 删除货物库存信息
     *
     * @param repertoryid 货物库存主键
     * @return 结果
     */
    public int deleteRepertoryByRepertoryid(Long repertoryid);

    /**
     * 取物料库位库存
     *
     * @param repertory 库房
     * @return 库房集合
     */
    public List<Repertory> selectMtlRepertoryByMatNo(Repertory repertory);

    /**
     * 根取物料库位库存
     *
     * @param repertory 库房
     * @return 库房集合
     */
    public List<Repertory> selectMtlRepertoryByStoresiteNo(Repertory repertory);

    /**
     * 根取物料库位库存
     *
     * @param repertory 库房
     * @return 库房集合
     */
    public List<Repertory> selectMtlRepertoryByStoresiteNo3(Repertory repertory);

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryByStoresiteNo(Repertory repertory);

    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @param repertory 根据扫描货位号/物料号/托盘号等查询库存信息
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryByBarCode(Repertory repertory);

    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @param repertory 根据扫描货位号/物料号/托盘号等查询库存信息
     * @return 货物库存集合
     */
    public List<Repertory> GetUnRepertoryByStoresiteNo(Repertory repertory);

    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @param repertory 根据扫描货位号/物料号/托盘号等查询库存信息
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryByStoresiteNoSn(Repertory repertory);

    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @param repertory 根据扫描货位号/物料号/托盘号等查询库存信息
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryByStoresiteNoErp(Repertory repertory);

    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @param palletno 根据扫描货位号/物料号/托盘号等查询库存信息
     * @return 货物库存集合
     */
    public Repertory GetPalletSiteNo(String palletno);

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> selectLSMtlRepertoryByMatNo(Repertory repertory);

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> selectLSMtlRepertoryByStoresiteNo(Repertory repertory);

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryBySiteNoMatCode(Repertory repertory);

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryByStoresiteNoTransfer(Repertory repertory);

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryTransfer(Repertory repertory);


    public List<Repertory> selectMtlRepertoryByStoresiteNo2(Repertory repertory);
}
