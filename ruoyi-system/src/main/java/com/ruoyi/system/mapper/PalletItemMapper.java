package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PalletItem;

/**
 * 托盘物料档案Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-06
 */
public interface PalletItemMapper 
{
    /**
     * 查询托盘物料档案
     * 
     * @param palletItemid 托盘物料档案主键
     * @return 托盘物料档案
     */
    public PalletItem selectPalletItemByPalletItemid(Long palletItemid);

    /**
     * 查询托盘物料档案列表
     * 
     * @param palletItem 托盘物料档案
     * @return 托盘物料档案集合
     */
    public List<PalletItem> selectPalletItemList(PalletItem palletItem);

    /**
     * 新增托盘物料档案
     * 
     * @param palletItem 托盘物料档案
     * @return 结果
     */
    public int insertPalletItem(PalletItem palletItem);

    /**
     * 修改托盘物料档案
     * 
     * @param palletItem 托盘物料档案
     * @return 结果
     */
    public int updatePalletItem(PalletItem palletItem);

    /**
     * 删除托盘物料档案
     * 
     * @param palletItemid 托盘物料档案主键
     * @return 结果
     */
    public int deletePalletItemByPalletItemid(Long palletItemid);

    /**
     * 批量删除托盘物料档案
     * 
     * @param palletItemids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePalletItemByPalletItemids(Long[] palletItemids);

    /**
     * 查询托盘物料档案列表
     *
     * @param palletItem 托盘物料档案
     * @return 托盘物料档案集合
     */
    public List<PalletItem> selectPalletItemByTaskID(PalletItem palletItem);
}
