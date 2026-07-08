package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Storeroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RepertoryMapper;
import com.ruoyi.system.domain.Repertory;
import com.ruoyi.system.service.IRepertoryService;

/**
 * 货物库存Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-30
 */
@Service
public class RepertoryServiceImpl implements IRepertoryService
{
    @Autowired
    private RepertoryMapper repertoryMapper;

    /**
     * 查询货物库存
     *
     * @param repertoryid 货物库存主键
     * @return 货物库存
     */
    @Override
    public Repertory selectRepertoryByRepertoryid(Long repertoryid)
    {
        return repertoryMapper.selectRepertoryByRepertoryid(repertoryid);
    }

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存
     */
    @Override
    public List<Repertory> selectRepertoryList(Repertory repertory)
    {
        return repertoryMapper.selectRepertoryList(repertory);
    }

    /**
     * 新增货物库存
     *
     * @param repertory 货物库存
     * @return 结果
     */
    @Override
    public int insertRepertory(Repertory repertory)
    {
        return repertoryMapper.insertRepertory(repertory);
    }

    /**
     * 修改货物库存
     *
     * @param repertory 货物库存
     * @return 结果
     */
    @Override
    public int updateRepertory(Repertory repertory)
    {
        return repertoryMapper.updateRepertory(repertory);
    }

    /**
     * 批量删除货物库存
     *
     * @param repertoryids 需要删除的货物库存主键
     * @return 结果
     */
    @Override
    public int deleteRepertoryByRepertoryids(Long[] repertoryids)
    {
        return repertoryMapper.deleteRepertoryByRepertoryids(repertoryids);
    }

    /**
     * 删除货物库存信息
     *
     * @param repertoryid 货物库存主键
     * @return 结果
     */
    @Override
    public int deleteRepertoryByRepertoryid(Long repertoryid)
    {
        return repertoryMapper.deleteRepertoryByRepertoryid(repertoryid);
    }
    /**
     * 根取物料库位库存
     *
     * @param repertory 库房
     * @return 库房集合
     */
    public List<Repertory> selectMtlRepertoryByMatNo(Repertory repertory){
        return repertoryMapper.selectMtlRepertoryByMatNo(repertory);
    };

    /**
     * 取物料库位库存
     *
     * @param repertory 库房
     * @return 库房集合
     */
    public List<Repertory> selectMtlRepertoryByStoresiteNo(Repertory repertory){
        return repertoryMapper.selectMtlRepertoryByStoresiteNo(repertory);
    };

    /**
     * 取物料库位库存
     *
     * @param repertory 库房
     * @return 库房集合
     */
    public List<Repertory> selectMtlRepertoryByStoresiteNo3(Repertory repertory){
        return repertoryMapper.selectMtlRepertoryByStoresiteNo3(repertory);
    };


    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryByStoresiteNo(Repertory repertory){
        return repertoryMapper.GetRepertoryByStoresiteNo(repertory);
    };
    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @param repertory 根据扫描货位号/物料号/托盘号等查询库存信息
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryByBarCode(Repertory repertory){
        return repertoryMapper.GetRepertoryByBarCode(repertory);
    };

    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @param repertory 根据扫描货位号/物料号/托盘号等查询库存信息
     * @return 货物库存集合
     */
    public List<Repertory> GetUnRepertoryByStoresiteNo(Repertory repertory)
    {
        return repertoryMapper.GetUnRepertoryByStoresiteNo(repertory);
    };

    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @param repertory 根据扫描货位号/物料号/托盘号等查询库存信息
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryByStoresiteNoSn(Repertory repertory)
    {
        return repertoryMapper.GetRepertoryByStoresiteNoSn(repertory);
    };
    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @param repertory 根据扫描货位号/物料号/托盘号等查询库存信息
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryByStoresiteNoErp(Repertory repertory)
    {
        return repertoryMapper.GetRepertoryByStoresiteNoErp(repertory);
    };

    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @param palletno 根据扫描货位号/物料号/托盘号等查询库存信息
     * @return 货物库存集合
     */
    public Repertory GetPalletSiteNo(String palletno)
    {
        return repertoryMapper.GetPalletSiteNo(palletno);
    };

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> selectLSMtlRepertoryByMatNo(Repertory repertory)
    {
        return repertoryMapper.selectLSMtlRepertoryByMatNo(repertory);
    };

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> selectLSMtlRepertoryByStoresiteNo(Repertory repertory)
    {
        return repertoryMapper.selectLSMtlRepertoryByStoresiteNo(repertory);
    };

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryBySiteNoMatCode(Repertory repertory)    {
        return repertoryMapper.GetRepertoryBySiteNoMatCode(repertory);
    };

    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryByStoresiteNoTransfer(Repertory repertory)    {
        return repertoryMapper.GetRepertoryByStoresiteNoTransfer(repertory);
    };
    /**
     * 查询货物库存列表
     *
     * @param repertory 货物库存
     * @return 货物库存集合
     */
    public List<Repertory> GetRepertoryTransfer(Repertory repertory)   {
        return repertoryMapper.GetRepertoryTransfer(repertory);
    };


    public List<Repertory> selectMtlRepertoryByStoresiteNo2(Repertory repertory)  {
        return repertoryMapper.selectMtlRepertoryByStoresiteNo2(repertory);
    };
}
