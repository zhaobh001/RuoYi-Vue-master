package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PmMaterial;

/**
 * 物料Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public interface PmMaterialMapper 
{
    /**
     * 查询物料
     * 
     * @param pmMaterialid 物料主键
     * @return 物料
     */
    public PmMaterial selectPmMaterialByPmMaterialid(Long pmMaterialid);

    /**
     * 查询物料列表
     * 
     * @param pmMaterial 物料
     * @return 物料集合
     */
    public List<PmMaterial> selectPmMaterialList(PmMaterial pmMaterial);

    /**
     * 新增物料
     * 
     * @param pmMaterial 物料
     * @return 结果
     */
    public int insertPmMaterial(PmMaterial pmMaterial);

    /**
     * 修改物料
     * 
     * @param pmMaterial 物料
     * @return 结果
     */
    public int updatePmMaterial(PmMaterial pmMaterial);

    /**
     * 删除物料
     * 
     * @param pmMaterialid 物料主键
     * @return 结果
     */
    public int deletePmMaterialByPmMaterialid(Long pmMaterialid);

    /**
     * 批量删除物料
     * 
     * @param pmMaterialids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmMaterialByPmMaterialids(Long[] pmMaterialids);

    /**
     * 查询物料
     *
     * @param matcode 物料主键
     * @return 物料
     */
    public PmMaterial selectPmMaterialByMatcode(String matcode);
}
