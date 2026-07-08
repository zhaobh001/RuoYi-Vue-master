package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Sterrooutexit;

/**
 * 立体库出入口档案Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-12
 */
public interface SterrooutexitMapper 
{
    /**
     * 查询立体库出入口档案
     * 
     * @param sterrooutexitid 立体库出入口档案主键
     * @return 立体库出入口档案
     */
    public Sterrooutexit selectSterrooutexitBySterrooutexitid(Long sterrooutexitid);

    /**
     * 查询立体库出入口档案列表
     * 
     * @param sterrooutexit 立体库出入口档案
     * @return 立体库出入口档案集合
     */
    public List<Sterrooutexit> selectSterrooutexitList(Sterrooutexit sterrooutexit);

    /**
     * 新增立体库出入口档案
     * 
     * @param sterrooutexit 立体库出入口档案
     * @return 结果
     */
    public int insertSterrooutexit(Sterrooutexit sterrooutexit);

    /**
     * 修改立体库出入口档案
     * 
     * @param sterrooutexit 立体库出入口档案
     * @return 结果
     */
    public int updateSterrooutexit(Sterrooutexit sterrooutexit);

    /**
     * 删除立体库出入口档案
     * 
     * @param sterrooutexitid 立体库出入口档案主键
     * @return 结果
     */
    public int deleteSterrooutexitBySterrooutexitid(Long sterrooutexitid);

    /**
     * 批量删除立体库出入口档案
     * 
     * @param sterrooutexitids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSterrooutexitBySterrooutexitids(Long[] sterrooutexitids);
}
