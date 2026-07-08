package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Pallet;

/**
 * 托盘Service接口
 * 
 * @author ruoyi
 * @date 2023-08-06
 */
public interface IPalletService 
{
    /**
     * 查询托盘
     * 
     * @param palletid 托盘主键
     * @return 托盘
     */
    public Pallet selectPalletByPalletid(Long palletid);

    /**
     * 查询托盘列表
     * 
     * @param pallet 托盘
     * @return 托盘集合
     */
    public List<Pallet> selectPalletList(Pallet pallet);

    /**
     * 新增托盘
     * 
     * @param pallet 托盘
     * @return 结果
     */
    public int insertPallet(Pallet pallet);

    /**
     * 修改托盘
     * 
     * @param pallet 托盘
     * @return 结果
     */
    public int updatePallet(Pallet pallet);

    /**
     * 批量删除托盘
     * 
     * @param palletids 需要删除的托盘主键集合
     * @return 结果
     */
    public int deletePalletByPalletids(Long[] palletids);

    /**
     * 删除托盘信息
     * 
     * @param palletid 托盘主键
     * @return 结果
     */
    public int deletePalletByPalletid(Long palletid);

    /**
     * 查询托盘
     *
     * @param palletNo 托盘编码
     * @return 托盘
     */
    public Pallet selectPalletByPalletNo(String palletNo);

    /**
     * 查询托盘
     *
     * @param pallet 托盘
     * @return 托盘
     */
    public String checkBindingTrayNo(Pallet pallet);
}
