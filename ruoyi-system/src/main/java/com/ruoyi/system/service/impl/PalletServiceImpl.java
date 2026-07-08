package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PalletMapper;
import com.ruoyi.system.domain.Pallet;
import com.ruoyi.system.service.IPalletService;

/**
 * 托盘Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-06
 */
@Service
public class PalletServiceImpl implements IPalletService 
{
    @Autowired
    private PalletMapper palletMapper;

    /**
     * 查询托盘
     * 
     * @param palletid 托盘主键
     * @return 托盘
     */
    @Override
    public Pallet selectPalletByPalletid(Long palletid)
    {
        return palletMapper.selectPalletByPalletid(palletid);
    }

    /**
     * 查询托盘列表
     * 
     * @param pallet 托盘
     * @return 托盘
     */
    @Override
    public List<Pallet> selectPalletList(Pallet pallet)
    {
        return palletMapper.selectPalletList(pallet);
    }

    /**
     * 新增托盘
     * 
     * @param pallet 托盘
     * @return 结果
     */
    @Override
    public int insertPallet(Pallet pallet)
    {
        return palletMapper.insertPallet(pallet);
    }

    /**
     * 修改托盘
     * 
     * @param pallet 托盘
     * @return 结果
     */
    @Override
    public int updatePallet(Pallet pallet)
    {
        return palletMapper.updatePallet(pallet);
    }

    /**
     * 批量删除托盘
     * 
     * @param palletids 需要删除的托盘主键
     * @return 结果
     */
    @Override
    public int deletePalletByPalletids(Long[] palletids)
    {
        return palletMapper.deletePalletByPalletids(palletids);
    }

    /**
     * 删除托盘信息
     * 
     * @param palletid 托盘主键
     * @return 结果
     */
    @Override
    public int deletePalletByPalletid(Long palletid)
    {
        return palletMapper.deletePalletByPalletid(palletid);
    }

    /**
     * 查询托盘
     *
     * @param palletNo 托盘编码
     * @return 托盘
     */
    public Pallet selectPalletByPalletNo(String palletNo)

    {
        return palletMapper.selectPalletByPalletNo(palletNo);
    }

    /**
     * 查询托盘
     *
     * @param pallet 托盘
     * @return 托盘
     */
    public String checkBindingTrayNo(Pallet pallet)
    {
        return palletMapper.checkBindingTrayNo(pallet);
    }
}
