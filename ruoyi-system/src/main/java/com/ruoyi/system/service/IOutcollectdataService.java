package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Outcollectdata;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-08-12
 */
public interface IOutcollectdataService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param outcollectdataid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Outcollectdata selectOutcollectdataByOutcollectdataid(Long outcollectdataid);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param outcollectdata 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Outcollectdata> selectOutcollectdataList(Outcollectdata outcollectdata);

    /**
     * 新增【请填写功能名称】
     *
     * @param outcollectdata 【请填写功能名称】
     * @return 结果
     */
    public int insertOutcollectdata(Outcollectdata outcollectdata);

    /**
     * 修改【请填写功能名称】
     *
     * @param outcollectdata 【请填写功能名称】
     * @return 结果
     */
    public int updateOutcollectdata(Outcollectdata outcollectdata);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param outcollectdataids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteOutcollectdataByOutcollectdataids(Long[] outcollectdataids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param outcollectdataid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOutcollectdataByOutcollectdataid(Long outcollectdataid);

    /**
     * 新增【请填写功能名称】
     *
     * @param list 【请填写功能名称】
     * @return 结果
     */
    public int insertOutcollectdataBatch(List<Outcollectdata> list);

}
