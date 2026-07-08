package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.InterfaceWmsToWcs;

/**
 * 写仓储控制系统(堆垛机)Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-07
 */
public interface InterfaceWmsToWcsMapper 
{
    /**
     * 查询写仓储控制系统(堆垛机)
     * 
     * @param interfaceWmsToWcsId 写仓储控制系统(堆垛机)主键
     * @return 写仓储控制系统(堆垛机)
     */
    public InterfaceWmsToWcs selectInterfaceWmsToWcsByInterfaceWmsToWcsId(Long interfaceWmsToWcsId);

    /**
     * 查询写仓储控制系统(堆垛机)列表
     * 
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 写仓储控制系统(堆垛机)集合
     */
    public List<InterfaceWmsToWcs> selectInterfaceWmsToWcsList(InterfaceWmsToWcs interfaceWmsToWcs);

    /**
     * 新增写仓储控制系统(堆垛机)
     * 
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public int insertInterfaceWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs);

    /**
     * 修改写仓储控制系统(堆垛机)
     * 
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public int updateInterfaceWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs);

    /**
     * 删除写仓储控制系统(堆垛机)
     * 
     * @param interfaceWmsToWcsId 写仓储控制系统(堆垛机)主键
     * @return 结果
     */
    public int deleteInterfaceWmsToWcsByInterfaceWmsToWcsId(Long interfaceWmsToWcsId);

    /**
     * 批量删除写仓储控制系统(堆垛机)
     * 
     * @param interfaceWmsToWcsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInterfaceWmsToWcsByInterfaceWmsToWcsIds(Long[] interfaceWmsToWcsIds);

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitUpWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs);

    /**
     * 查询写仓储控制系统(堆垛机)列表
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 写仓储控制系统(堆垛机)集合
     */
    public List<InterfaceWmsToWcs> selectWmsToWcsByTaskID(InterfaceWmsToWcs interfaceWmsToWcs);

    /**
     * 查询写仓储控制系统(堆垛机)列表
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 写仓储控制系统(堆垛机)集合
     */
    public List<InterfaceWmsToWcs> selectWmsToWcsByTaskID2(InterfaceWmsToWcs interfaceWmsToWcs);

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitDownWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs);

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitEmptyTrayWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs);

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitResetWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs);

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitInvDownWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs);

    /**
     * 新增写仓储控制系统(堆垛机)
     *
     * @param interfaceWmsToWcs 写仓储控制系统(堆垛机)
     * @return 结果
     */
    public String commitInvResetWmsToWcs(InterfaceWmsToWcs interfaceWmsToWcs);

}
