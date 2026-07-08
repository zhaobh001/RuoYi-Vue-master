package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ArrivalsBillCheckerMapper;
import com.ruoyi.system.domain.ArrivalsBillChecker;
import com.ruoyi.system.service.IArrivalsBillCheckerService;

/**
 * 到货单实物清点人Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
@Service
public class ArrivalsBillCheckerServiceImpl implements IArrivalsBillCheckerService 
{
    @Autowired
    private ArrivalsBillCheckerMapper arrivalsBillCheckerMapper;

    /**
     * 查询到货单实物清点人
     * 
     * @param abcheckerSeqid 到货单实物清点人主键
     * @return 到货单实物清点人
     */
    @Override
    public ArrivalsBillChecker selectArrivalsBillCheckerByAbcheckerSeqid(Long abcheckerSeqid)
    {
        return arrivalsBillCheckerMapper.selectArrivalsBillCheckerByAbcheckerSeqid(abcheckerSeqid);
    }

    /**
     * 查询到货单实物清点人列表
     * 
     * @param arrivalsBillChecker 到货单实物清点人
     * @return 到货单实物清点人
     */
    @Override
    public List<ArrivalsBillChecker> selectArrivalsBillCheckerList(ArrivalsBillChecker arrivalsBillChecker)
    {
        return arrivalsBillCheckerMapper.selectArrivalsBillCheckerList(arrivalsBillChecker);
    }

    /**
     * 新增到货单实物清点人
     * 
     * @param arrivalsBillChecker 到货单实物清点人
     * @return 结果
     */
    @Override
    public int insertArrivalsBillChecker(ArrivalsBillChecker arrivalsBillChecker)
    {
        return arrivalsBillCheckerMapper.insertArrivalsBillChecker(arrivalsBillChecker);
    }

    /**
     * 修改到货单实物清点人
     * 
     * @param arrivalsBillChecker 到货单实物清点人
     * @return 结果
     */
    @Override
    public int updateArrivalsBillChecker(ArrivalsBillChecker arrivalsBillChecker)
    {
        return arrivalsBillCheckerMapper.updateArrivalsBillChecker(arrivalsBillChecker);
    }

    /**
     * 批量删除到货单实物清点人
     * 
     * @param abcheckerSeqids 需要删除的到货单实物清点人主键
     * @return 结果
     */
    @Override
    public int deleteArrivalsBillCheckerByAbcheckerSeqids(Long[] abcheckerSeqids)
    {
        return arrivalsBillCheckerMapper.deleteArrivalsBillCheckerByAbcheckerSeqids(abcheckerSeqids);
    }

    /**
     * 删除到货单实物清点人信息
     * 
     * @param abcheckerSeqid 到货单实物清点人主键
     * @return 结果
     */
    @Override
    public int deleteArrivalsBillCheckerByAbcheckerSeqid(Long abcheckerSeqid)
    {
        return arrivalsBillCheckerMapper.deleteArrivalsBillCheckerByAbcheckerSeqid(abcheckerSeqid);
    }
}
