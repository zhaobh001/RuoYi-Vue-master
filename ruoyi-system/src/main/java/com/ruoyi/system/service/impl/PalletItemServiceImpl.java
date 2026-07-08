package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PalletItemMapper;
import com.ruoyi.system.domain.PalletItem;
import com.ruoyi.system.service.IPalletItemService;

/**
 * 托盘物料档案Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-06
 */
@Service
public class PalletItemServiceImpl implements IPalletItemService {
    @Autowired
    private PalletItemMapper palletItemMapper;

    /**
     * 查询托盘物料档案
     *
     * @param palletItemid 托盘物料档案主键
     * @return 托盘物料档案
     */
    @Override
    public PalletItem selectPalletItemByPalletItemid(Long palletItemid) {
        return palletItemMapper.selectPalletItemByPalletItemid(palletItemid);
    }

    /**
     * 查询托盘物料档案列表
     *
     * @param palletItem 托盘物料档案
     * @return 托盘物料档案
     */
    @Override
    public List<PalletItem> selectPalletItemList(PalletItem palletItem) {
        return palletItemMapper.selectPalletItemList(palletItem);
    }

    /**
     * 新增托盘物料档案
     *
     * @param palletItem 托盘物料档案
     * @return 结果
     */
    @Override
    public int insertPalletItem(PalletItem palletItem) {
        return palletItemMapper.insertPalletItem(palletItem);
    }

    /**
     * 修改托盘物料档案
     *
     * @param palletItem 托盘物料档案
     * @return 结果
     */
    @Override
    public int updatePalletItem(PalletItem palletItem) {
        return palletItemMapper.updatePalletItem(palletItem);
    }

    /**
     * 批量删除托盘物料档案
     *
     * @param palletItemids 需要删除的托盘物料档案主键
     * @return 结果
     */
    @Override
    public int deletePalletItemByPalletItemids(Long[] palletItemids) {
        return palletItemMapper.deletePalletItemByPalletItemids(palletItemids);
    }

    /**
     * 删除托盘物料档案信息
     *
     * @param palletItemid 托盘物料档案主键
     * @return 结果
     */
    @Override
    public int deletePalletItemByPalletItemid(Long palletItemid) {
        return palletItemMapper.deletePalletItemByPalletItemid(palletItemid);
    }

    /**
     * 查询托盘物料档案列表
     *
     * @param palletItem 托盘物料档案
     * @return 托盘物料档案集合
     */
    public List<PalletItem> selectPalletItemByTaskID(PalletItem palletItem) {
        return palletItemMapper.selectPalletItemByTaskID(palletItem);
    }
}
