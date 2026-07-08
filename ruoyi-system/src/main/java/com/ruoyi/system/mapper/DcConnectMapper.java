package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.DcConnect;

/**
 * ?通讯批次Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public interface DcConnectMapper 
{
    /**
     * 查询?通讯批次
     * 
     * @param dcConnectid ?通讯批次主键
     * @return ?通讯批次
     */
    public DcConnect selectDcConnectByDcConnectid(Long dcConnectid);

    /**
     * 查询?通讯批次列表
     * 
     * @param dcConnect ?通讯批次
     * @return ?通讯批次集合
     */
    public List<DcConnect> selectDcConnectList(DcConnect dcConnect);

    /**
     * 新增?通讯批次
     * 
     * @param dcConnect ?通讯批次
     * @return 结果
     */
    public Long insertDcConnect(DcConnect dcConnect);

    /**
     * 修改?通讯批次
     * 
     * @param dcConnect ?通讯批次
     * @return 结果
     */
    public int updateDcConnect(DcConnect dcConnect);

    /**
     * 删除?通讯批次
     * 
     * @param dcConnectid ?通讯批次主键
     * @return 结果
     */
    public int deleteDcConnectByDcConnectid(Long dcConnectid);

    /**
     * 批量删除?通讯批次
     * 
     * @param dcConnectids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDcConnectByDcConnectids(Long[] dcConnectids);

    /**
     * 查询?通讯批次列表
     *
     * @param dcConnect ?通讯批次
     * @return ?通讯批次集合
     */
    public List<DcConnect> selectPdaCollExceptList(DcConnect dcConnect);

    /**
     * 查询?通讯批次列表
     *
     * @param dcConnect ?通讯批次
     * @return ?通讯批次集合
     */
    public List<DcConnect> selectSapInteExceptList(DcConnect dcConnect);
}
