package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DcConnectMapper;
import com.ruoyi.system.domain.DcConnect;
import com.ruoyi.system.service.IDcConnectService;

/**
 * ?通讯批次Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
@Service
public class DcConnectServiceImpl implements IDcConnectService 
{
    @Autowired
    private DcConnectMapper dcConnectMapper;

    /**
     * 查询?通讯批次
     * 
     * @param dcConnectid ?通讯批次主键
     * @return ?通讯批次
     */
    @Override
    public DcConnect selectDcConnectByDcConnectid(Long dcConnectid)
    {
        return dcConnectMapper.selectDcConnectByDcConnectid(dcConnectid);
    }

    /**
     * 查询?通讯批次列表
     * 
     * @param dcConnect ?通讯批次
     * @return ?通讯批次
     */
    @Override
    public List<DcConnect> selectDcConnectList(DcConnect dcConnect)
    {
        return dcConnectMapper.selectDcConnectList(dcConnect);
    }

    /**
     * 新增?通讯批次
     * 
     * @param dcConnect ?通讯批次
     * @return 结果
     */
    @Override
    public Long insertDcConnect(DcConnect dcConnect)
    {
        return dcConnectMapper.insertDcConnect(dcConnect);
    }

    /**
     * 修改?通讯批次
     * 
     * @param dcConnect ?通讯批次
     * @return 结果
     */
    @Override
    public int updateDcConnect(DcConnect dcConnect)
    {
        return dcConnectMapper.updateDcConnect(dcConnect);
    }

    /**
     * 批量删除?通讯批次
     * 
     * @param dcConnectids 需要删除的?通讯批次主键
     * @return 结果
     */
    @Override
    public int deleteDcConnectByDcConnectids(Long[] dcConnectids)
    {
        return dcConnectMapper.deleteDcConnectByDcConnectids(dcConnectids);
    }

    /**
     * 删除?通讯批次信息
     * 
     * @param dcConnectid ?通讯批次主键
     * @return 结果
     */
    @Override
    public int deleteDcConnectByDcConnectid(Long dcConnectid)
    {
        return dcConnectMapper.deleteDcConnectByDcConnectid(dcConnectid);
    }

    /**
     * 查询?通讯批次列表
     *
     * @param dcConnect ?通讯批次
     * @return ?通讯批次集合
     */
    public List<DcConnect> selectPdaCollExceptList(DcConnect dcConnect)
    {
        return dcConnectMapper.selectPdaCollExceptList(dcConnect);
    }
    /**
     * 查询?通讯批次列表
     *
     * @param dcConnect ?通讯批次
     * @return ?通讯批次集合
     */
    public List<DcConnect> selectSapInteExceptList(DcConnect dcConnect) {
        return dcConnectMapper.selectSapInteExceptList(dcConnect);
    }
}
