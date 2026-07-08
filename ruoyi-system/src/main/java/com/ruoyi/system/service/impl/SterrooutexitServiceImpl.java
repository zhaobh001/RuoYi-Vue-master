package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SterrooutexitMapper;
import com.ruoyi.system.domain.Sterrooutexit;
import com.ruoyi.system.service.ISterrooutexitService;

/**
 * 立体库出入口档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
@Service
public class SterrooutexitServiceImpl implements ISterrooutexitService 
{
    @Autowired
    private SterrooutexitMapper sterrooutexitMapper;

    /**
     * 查询立体库出入口档案
     * 
     * @param sterrooutexitid 立体库出入口档案主键
     * @return 立体库出入口档案
     */
    @Override
    public Sterrooutexit selectSterrooutexitBySterrooutexitid(Long sterrooutexitid)
    {
        return sterrooutexitMapper.selectSterrooutexitBySterrooutexitid(sterrooutexitid);
    }

    /**
     * 查询立体库出入口档案列表
     * 
     * @param sterrooutexit 立体库出入口档案
     * @return 立体库出入口档案
     */
    @Override
    public List<Sterrooutexit> selectSterrooutexitList(Sterrooutexit sterrooutexit)
    {
        return sterrooutexitMapper.selectSterrooutexitList(sterrooutexit);
    }

    /**
     * 新增立体库出入口档案
     * 
     * @param sterrooutexit 立体库出入口档案
     * @return 结果
     */
    @Override
    public int insertSterrooutexit(Sterrooutexit sterrooutexit)
    {
        return sterrooutexitMapper.insertSterrooutexit(sterrooutexit);
    }

    /**
     * 修改立体库出入口档案
     * 
     * @param sterrooutexit 立体库出入口档案
     * @return 结果
     */
    @Override
    public int updateSterrooutexit(Sterrooutexit sterrooutexit)
    {
        return sterrooutexitMapper.updateSterrooutexit(sterrooutexit);
    }

    /**
     * 批量删除立体库出入口档案
     * 
     * @param sterrooutexitids 需要删除的立体库出入口档案主键
     * @return 结果
     */
    @Override
    public int deleteSterrooutexitBySterrooutexitids(Long[] sterrooutexitids)
    {
        return sterrooutexitMapper.deleteSterrooutexitBySterrooutexitids(sterrooutexitids);
    }

    /**
     * 删除立体库出入口档案信息
     * 
     * @param sterrooutexitid 立体库出入口档案主键
     * @return 结果
     */
    @Override
    public int deleteSterrooutexitBySterrooutexitid(Long sterrooutexitid)
    {
        return sterrooutexitMapper.deleteSterrooutexitBySterrooutexitid(sterrooutexitid);
    }
}
