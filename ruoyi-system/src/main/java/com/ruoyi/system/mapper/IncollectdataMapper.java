package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Incollectdata;
import com.ruoyi.system.domain.Outcollectdata;

/**
 * 入库采集数据Mapper接口
 *
 * @author ruoyi
 * @date 2023-07-30
 */
public interface IncollectdataMapper
{
    /**
     * 查询入库采集数据
     *
     * @param incollectdataid 入库采集数据主键
     * @return 入库采集数据
     */
    public Incollectdata selectIncollectdataByIncollectdataid(Long incollectdataid);

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库采集数据
     * @return 入库采集数据集合
     */
    public List<Incollectdata> selectIncollectdataList(Incollectdata incollectdata);

    /**
     * 新增入库采集数据
     *
     * @param incollectdata 入库采集数据
     * @return 结果
     */
    public int insertIncollectdata(Incollectdata incollectdata);

    /**
     * 新增【请填写功能名称】
     *
     * @param list 【请填写功能名称】
     * @return 结果
     */
    public int insertIncollectdataBatch(List<Incollectdata> list);

    /**
     * 修改入库采集数据
     *
     * @param incollectdata 入库采集数据
     * @return 结果
     */
    public int updateIncollectdata(Incollectdata incollectdata);

    /**
     * 删除入库采集数据
     *
     * @param incollectdataid 入库采集数据主键
     * @return 结果
     */
    public int deleteIncollectdataByIncollectdataid(Long incollectdataid);

    /**
     * 批量删除入库采集数据
     *
     * @param incollectdataids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteIncollectdataByIncollectdataids(Long[] incollectdataids);

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> selectIncollectdatabathCheack(Incollectdata incollectdata);

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> selectIncollectdatabathCheackOld(Incollectdata incollectdata);

    /**
     * 查询入库采集数据
     *
     * @param intaskitemid 入库任务明细主键
     * @return 入库采集数据
     */
    public Incollectdata selectSumqtyByintaskitemid(Long intaskitemid);

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getInboundData(Incollectdata incollectdata);

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getOutboundData(Incollectdata incollectdata);

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getWorkloadData(Incollectdata incollectdata);

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getInboundDatabykindqty(Incollectdata incollectdata);

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getInbounddetail(Incollectdata incollectdata);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param incollectdata 需要删除的数据主键集合
     * @return 结果
     */
    public List<Incollectdata> getOutbounddetail(Incollectdata incollectdata);


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftPack();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftin();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftout();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLefworkorder();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCentershouhuolv();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterbaojianlv();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterrukulv();



    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterchukulv();



    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterqitaolv();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCentershouhuoqty();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterfahuoqty();



    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCentercaituiqty();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterchengruqty();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterchengfaqty();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCentershengtuiqty();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getStatyear();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuo();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMat();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoC();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMatC();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoW();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMatW();


















    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuo();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMat();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoC();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMatC();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoW();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMatW();























    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuo();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMat();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoC();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMatC();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoW();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMatW();





    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengshuo();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengshuoMat();












    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengfhuo();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengfhuoMat();













    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuiku();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMat();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuC();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMatC();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuW();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMatW();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getIndexRightStomeroom();





















    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailshouhuolv();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailshouhuolvC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailshouhuolvW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailbaojianlv();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailbaojianlvC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailbaojianlvW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailrukulv();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailrukulvC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailrukulvW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailchukulv();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailchukulvC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailchukulvW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailqitaolv();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailqitaolvC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailqitaolvW();















    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getShouHuoLvDetailDataTable(Incollectdata con);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getBaoJianLvDetailDataTable(Incollectdata con);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRuKuLvDetailDataTable(Incollectdata con);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getChuKuLvDetailDataTable(Incollectdata con);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getQiTaoLvDetailDataTable(Incollectdata con);


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRightActiveRingData1();


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRightActiveRingData2();






    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getShouHuoLvWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getBaoJianLvWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRuKuLvWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getChuKuLvWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getQitaoLvWeek();
























    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMatWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoWeekC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMatWeekC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoWeekW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMatWeekW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMatWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoWeekC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMatWeekC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoWeekW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMatWeekW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMatWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoWeekC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMatWeekC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoWeekW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMatWeekW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengshuoWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengshuoMatWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengfhuoWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengfhuoMatWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMatWeek();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuWeekC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMatWeekC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuWeekW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMatWeekW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getQitaoLvDetail(Incollectdata con);























    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftinDetail();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftinDetailC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftinDetailW();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftoutDetail();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftoutDetailC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftoutDetailW();




    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRohAgingDetailData(Incollectdata con);


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getReAgingDetailData(Incollectdata con);










    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayDetailData(Incollectdata con);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayDetailDataC(Incollectdata con);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayDetailDataW(Incollectdata con);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayData(Incollectdata con);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayDataC(Incollectdata con);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayDataW(Incollectdata con);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvWeekData();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthData();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDataC();

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDataW();



    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataDay();
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataWeek();
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataMonth();
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataYear();










    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataDayC();
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataWeekC();
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataMonthC();
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataYearC();







    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataDayW();
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataWeekW();
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataMonthW();
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataYearW();











    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getReAgingDetailTable(Incollectdata con);
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRohAgingDetailTable(Incollectdata con);

    public List<Incollectdata> getChuKuLvWeekW();

    public List<Incollectdata> getChuKuLvWeekC();




    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getChuKuLvDetail(Incollectdata con);
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRuKuLvDetail(Incollectdata con);
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getBaoJianLvDetail(Incollectdata con);
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getShouHuoLvDetail(Incollectdata con);

    public List<Incollectdata> getQitaoLvDetail2(Incollectdata con);

    public List<Incollectdata> getractIndexCenterpipeilv();

    public List<Incollectdata> getIPQC(Incollectdata con);
    public List<Incollectdata> getZXD(Incollectdata con);

    public List<Incollectdata> getRightActiveRingData1C();
    public List<Incollectdata> getRightActiveRingData1W();

    public List<Incollectdata> getRohAgingDetailDataC(Incollectdata con);
    public List<Incollectdata> getRohAgingDetailDataW(Incollectdata con);

    public List<Incollectdata> getRohAgingDetailTableW(Incollectdata con);
    public List<Incollectdata> getRohAgingDetailTableC(Incollectdata con);
}
