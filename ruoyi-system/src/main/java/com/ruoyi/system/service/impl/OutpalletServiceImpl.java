package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OutpalletMapper;
import com.ruoyi.system.domain.Outpallet;
import com.ruoyi.system.service.IOutpalletService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class OutpalletServiceImpl implements IOutpalletService 
{
    @Autowired
    private OutpalletMapper outpalletMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param pallettaskid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Outpallet selectOutpalletByPallettaskid(Long pallettaskid)
    {
        return outpalletMapper.selectOutpalletByPallettaskid(pallettaskid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param outpallet 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Outpallet> selectOutpalletList(Outpallet outpallet)
    {
        return outpalletMapper.selectOutpalletList(outpallet);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param outpallet 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOutpallet(Outpallet outpallet)
    {
        return outpalletMapper.insertOutpallet(outpallet);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param outpallet 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOutpallet(Outpallet outpallet)
    {
        return outpalletMapper.updateOutpallet(outpallet);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param pallettaskids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutpalletByPallettaskids(Long[] pallettaskids)
    {
        return outpalletMapper.deleteOutpalletByPallettaskids(pallettaskids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param pallettaskid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOutpalletByPallettaskid(Long pallettaskid)
    {
        return outpalletMapper.deleteOutpalletByPallettaskid(pallettaskid);
    }
}
