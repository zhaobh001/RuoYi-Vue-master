package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InterfaceWmsToWcsMapper;
import com.ruoyi.system.domain.InterfaceWmsToWcs;
import com.ruoyi.system.service.IInterfaceWmsToWcsService;

/**
 * 写仓储控制系统(堆垛机)Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-07
 */
@Service
public class InterfaceWmsToWcsServiceImpl implements IInterfaceWmsToWcsService {
    @Autowired
    private InterfaceWmsToWcsMapper interfaceWmsToWcsMapper;

    /**
     * 查询写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcsId 写仓储控制系统(堆垛机)主键
     * @return 写仓储控制系统(堆垛机)
     */
    @Override
    public InterfaceWmsToWcs selectInterfaceWmsToWcsByInterfaceWmsToWcsId(Long interfaceWmsToWcsId) {
        return interfaceWmsToWcsMapper.selectInterfaceWmsToWcsByInterfaceWmsToWcsId(interfaceWmsToWcsId);
    }

    /**
     * 查询写仓储控制系统(堆垛机)列表
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 写仓储控制系统(堆垛机)
     */
    @Override
    public List<InterfaceWmsToWcs> selectInterfaceWmsToWcsList(InterfaceWmsToWcs interfaceWmsToWcs) {
        return interfaceWmsToWcsMapper.selectInterfaceWmsToWcsList(interfaceWmsToWcs);
    }

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    @Override
    public int insertInterfaceWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs) {
        return interfaceWmsToWcsMapper.insertInterfaceWmsToWcs(interfaceWmsToWcs);
    }

    /**
     * 修改写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    @Override
    public int updateInterfaceWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs) {
        return interfaceWmsToWcsMapper.updateInterfaceWmsToWcs(interfaceWmsToWcs);
    }

    /**
     * 批量删除写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcsIds 需要删除的写仓储控制系统(堆垛机)主键
     * @return 结果
     */
    @Override
    public int deleteInterfaceWmsToWcsByInterfaceWmsToWcsIds(Long[] interfaceWmsToWcsIds) {
        return interfaceWmsToWcsMapper.deleteInterfaceWmsToWcsByInterfaceWmsToWcsIds(interfaceWmsToWcsIds);
    }

    /**
     * 删除写仓储控制系统(堆垛机)信息
     *
     * @param interfaceWmsToWcsId 写仓储控制系统(堆垛机)主键
     * @return 结果
     */
    @Override
    public int deleteInterfaceWmsToWcsByInterfaceWmsToWcsId(Long interfaceWmsToWcsId) {
        return interfaceWmsToWcsMapper.deleteInterfaceWmsToWcsByInterfaceWmsToWcsId(interfaceWmsToWcsId);
    }

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitUpWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs) {
        return interfaceWmsToWcsMapper.commitUpWmsToWcs(interfaceWmsToWcs);
    }

    /**
     * 查询写仓储控制系统(堆垛机)列表
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 写仓储控制系统(堆垛机)集合
     */
    public List<InterfaceWmsToWcs> selectWmsToWcsByTaskID(InterfaceWmsToWcs interfaceWmsToWcs) {
        return interfaceWmsToWcsMapper.selectWmsToWcsByTaskID(interfaceWmsToWcs);
    }

    /**
     * 查询写仓储控制系统(堆垛机)列表
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 写仓储控制系统(堆垛机)集合
     */
    public List<InterfaceWmsToWcs> selectWmsToWcsByTaskID2(InterfaceWmsToWcs interfaceWmsToWcs) {
        return interfaceWmsToWcsMapper.selectWmsToWcsByTaskID2(interfaceWmsToWcs);
    }

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitDownWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs) {
        return interfaceWmsToWcsMapper.commitDownWmsToWcs(interfaceWmsToWcs);
    }

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitEmptyTrayWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs) {
        return interfaceWmsToWcsMapper.commitEmptyTrayWmsToWcs(interfaceWmsToWcs);
    }

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitResetWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs){
        return interfaceWmsToWcsMapper.commitResetWmsToWcs(interfaceWmsToWcs);
    }

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitInvDownWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs){
        return interfaceWmsToWcsMapper.commitInvDownWmsToWcs(interfaceWmsToWcs);
    }

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitInvResetWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs){
        return interfaceWmsToWcsMapper.commitInvResetWmsToWcs(interfaceWmsToWcs);
    }

}
