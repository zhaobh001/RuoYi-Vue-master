package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MaterialQty;

/**
 * 库位物料数量控制Service接口
 * 
 * @author ruoyi
 * @date 2023-08-22
 */
public interface IMaterialQtyService 
{
    /**
     * 查询库位物料数量控制
     * 
     * @param materialQtyId 库位物料数量控制主键
     * @return 库位物料数量控制
     */
    public MaterialQty selectMaterialQtyByMaterialQtyId(Long materialQtyId);

    /**
     * 查询库位物料数量控制列表
     * 
     * @param materialQty 库位物料数量控制
     * @return 库位物料数量控制集合
     */
    public List<MaterialQty> selectMaterialQtyList(MaterialQty materialQty);

    /**
     * 新增库位物料数量控制
     * 
     * @param materialQty 库位物料数量控制
     * @return 结果
     */
    public int insertMaterialQty(MaterialQty materialQty);

    /**
     * 修改库位物料数量控制
     * 
     * @param materialQty 库位物料数量控制
     * @return 结果
     */
    public int updateMaterialQty(MaterialQty materialQty);

    /**
     * 批量删除库位物料数量控制
     * 
     * @param materialQtyIds 需要删除的库位物料数量控制主键集合
     * @return 结果
     */
    public int deleteMaterialQtyByMaterialQtyIds(Long[] materialQtyIds);

    /**
     * 删除库位物料数量控制信息
     * 
     * @param materialQtyId 库位物料数量控制主键
     * @return 结果
     */
    public int deleteMaterialQtyByMaterialQtyId(Long materialQtyId);
}
