package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ArrivalsBillChecker;

/**
 * 到货单实物清点人Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-04
 */
public interface ArrivalsBillCheckerMapper 
{
    /**
     * 查询到货单实物清点人
     * 
     * @param abcheckerSeqid 到货单实物清点人主键
     * @return 到货单实物清点人
     */
    public ArrivalsBillChecker selectArrivalsBillCheckerByAbcheckerSeqid(Long abcheckerSeqid);

    /**
     * 查询到货单实物清点人列表
     * 
     * @param arrivalsBillChecker 到货单实物清点人
     * @return 到货单实物清点人集合
     */
    public List<ArrivalsBillChecker> selectArrivalsBillCheckerList(ArrivalsBillChecker arrivalsBillChecker);

    /**
     * 新增到货单实物清点人
     * 
     * @param arrivalsBillChecker 到货单实物清点人
     * @return 结果
     */
    public int insertArrivalsBillChecker(ArrivalsBillChecker arrivalsBillChecker);

    /**
     * 修改到货单实物清点人
     * 
     * @param arrivalsBillChecker 到货单实物清点人
     * @return 结果
     */
    public int updateArrivalsBillChecker(ArrivalsBillChecker arrivalsBillChecker);

    /**
     * 删除到货单实物清点人
     * 
     * @param abcheckerSeqid 到货单实物清点人主键
     * @return 结果
     */
    public int deleteArrivalsBillCheckerByAbcheckerSeqid(Long abcheckerSeqid);

    /**
     * 批量删除到货单实物清点人
     * 
     * @param abcheckerSeqids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArrivalsBillCheckerByAbcheckerSeqids(Long[] abcheckerSeqids);
}
