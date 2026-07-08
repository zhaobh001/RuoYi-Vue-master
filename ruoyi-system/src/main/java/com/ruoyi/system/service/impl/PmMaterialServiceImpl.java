package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PmMaterialMapper;
import com.ruoyi.system.domain.PmMaterial;
import com.ruoyi.system.service.IPmMaterialService;

/**
 * 物料Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@Service
public class PmMaterialServiceImpl implements IPmMaterialService 
{
    @Autowired
    private PmMaterialMapper pmMaterialMapper;

    /**
     * 查询物料
     * 
     * @param pmMaterialid 物料主键
     * @return 物料
     */
    @Override
    public PmMaterial selectPmMaterialByPmMaterialid(Long pmMaterialid)
    {
        return pmMaterialMapper.selectPmMaterialByPmMaterialid(pmMaterialid);
    }

    /**
     * 查询物料列表
     * 
     * @param pmMaterial 物料
     * @return 物料
     */
    @Override
    public List<PmMaterial> selectPmMaterialList(PmMaterial pmMaterial)
    {
        return pmMaterialMapper.selectPmMaterialList(pmMaterial);
    }

    /**
     * 新增物料
     * 
     * @param pmMaterial 物料
     * @return 结果
     */
    @Override
    public int insertPmMaterial(PmMaterial pmMaterial)
    {
        return pmMaterialMapper.insertPmMaterial(pmMaterial);
    }

    /**
     * 修改物料
     * 
     * @param pmMaterial 物料
     * @return 结果
     */
    @Override
    public int updatePmMaterial(PmMaterial pmMaterial)
    {
        return pmMaterialMapper.updatePmMaterial(pmMaterial);
    }

    /**
     * 批量删除物料
     * 
     * @param pmMaterialids 需要删除的物料主键
     * @return 结果
     */
    @Override
    public int deletePmMaterialByPmMaterialids(Long[] pmMaterialids)
    {
        return pmMaterialMapper.deletePmMaterialByPmMaterialids(pmMaterialids);
    }

    /**
     * 删除物料信息
     * 
     * @param pmMaterialid 物料主键
     * @return 结果
     */
    @Override
    public int deletePmMaterialByPmMaterialid(Long pmMaterialid)
    {
        return pmMaterialMapper.deletePmMaterialByPmMaterialid(pmMaterialid);
    }

    /**
     * 查询物料
     *
     * @param matcode 物料主键
     * @return 物料
     */
    public PmMaterial selectPmMaterialByMatcode(String matcode)    {
        return pmMaterialMapper.selectPmMaterialByMatcode(matcode);
    }
}
