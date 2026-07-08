package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Expcollectdata;

/**
 * 异常登记采集 父为errlogsaveMapper接口
 * 
 * @author ruoyi
 * @date 2023-10-12
 */
public interface ExpcollectdataMapper 
{
    /**
     * 查询异常登记采集 父为errlogsave
     * 
     * @param expcollectdataid 异常登记采集 父为errlogsave主键
     * @return 异常登记采集 父为errlogsave
     */
    public Expcollectdata selectExpcollectdataByExpcollectdataid(Long expcollectdataid);

    /**
     * 查询异常登记采集 父为errlogsave列表
     * 
     * @param expcollectdata 异常登记采集 父为errlogsave
     * @return 异常登记采集 父为errlogsave集合
     */
    public List<Expcollectdata> selectExpcollectdataList(Expcollectdata expcollectdata);

    /**
     * 新增异常登记采集 父为errlogsave
     * 
     * @param expcollectdata 异常登记采集 父为errlogsave
     * @return 结果
     */
    public int insertExpcollectdata(Expcollectdata expcollectdata);

    /**
     * 修改异常登记采集 父为errlogsave
     * 
     * @param expcollectdata 异常登记采集 父为errlogsave
     * @return 结果
     */
    public int updateExpcollectdata(Expcollectdata expcollectdata);

    /**
     * 删除异常登记采集 父为errlogsave
     * 
     * @param expcollectdataid 异常登记采集 父为errlogsave主键
     * @return 结果
     */
    public int deleteExpcollectdataByExpcollectdataid(Long expcollectdataid);

    /**
     * 批量删除异常登记采集 父为errlogsave
     * 
     * @param expcollectdataids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExpcollectdataByExpcollectdataids(Long[] expcollectdataids);
}
