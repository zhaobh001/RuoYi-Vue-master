package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.IncollectdataMapper;
import com.ruoyi.system.domain.Incollectdata;
import com.ruoyi.system.service.IIncollectdataService;

/**
 * 入库采集数据Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-30
 */
@Service
public class IncollectdataServiceImpl implements IIncollectdataService
{
    @Autowired
    private IncollectdataMapper incollectdataMapper;

    /**
     * 查询入库采集数据
     *
     * @param incollectdataid 入库采集数据主键
     * @return 入库采集数据
     */
    @Override
    public Incollectdata selectIncollectdataByIncollectdataid(Long incollectdataid)
    {
        return incollectdataMapper.selectIncollectdataByIncollectdataid(incollectdataid);
    }

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库采集数据
     * @return 入库采集数据
     */
    @Override
    public List<Incollectdata> selectIncollectdataList(Incollectdata incollectdata)
    {
        return incollectdataMapper.selectIncollectdataList(incollectdata);
    }

    /**
     * 新增入库采集数据
     *
     * @param incollectdata 入库采集数据
     * @return 结果
     */
    @Override
    public int insertIncollectdata(Incollectdata incollectdata)
    {
        return incollectdataMapper.insertIncollectdata(incollectdata);
    }

    /**
     * 新增入库采集数据
     *
     * @param list 入库采集数据
     * @return 结果
     */
    @Override
    public int insertIncollectdataBatch(List<Incollectdata> list)
    {
        return incollectdataMapper.insertIncollectdataBatch(list);
    }
    /**
     * 修改入库采集数据
     *
     * @param incollectdata 入库采集数据
     * @return 结果
     */
    @Override
    public int updateIncollectdata(Incollectdata incollectdata)
    {
        return incollectdataMapper.updateIncollectdata(incollectdata);
    }

    /**
     * 批量删除入库采集数据
     *
     * @param incollectdataids 需要删除的入库采集数据主键
     * @return 结果
     */
    @Override
    public int deleteIncollectdataByIncollectdataids(Long[] incollectdataids)
    {
        return incollectdataMapper.deleteIncollectdataByIncollectdataids(incollectdataids);
    }

    /**
     * 删除入库采集数据信息
     *
     * @param incollectdataid 入库采集数据主键
     * @return 结果
     */
    @Override
    public int deleteIncollectdataByIncollectdataid(Long incollectdataid)
    {
        return incollectdataMapper.deleteIncollectdataByIncollectdataid(incollectdataid);
    }

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> selectIncollectdatabathCheack(Incollectdata incollectdata)
    {
        return incollectdataMapper.selectIncollectdatabathCheack(incollectdata);
    }

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> selectIncollectdatabathCheackOld(Incollectdata incollectdata)
    {
        return incollectdataMapper.selectIncollectdatabathCheackOld(incollectdata);
    }
    /**
     * 查询入库采集数据
     *
     * @param intaskitemid 入库任务明细主键
     * @return 入库采集数据
     */
    public Incollectdata selectSumqtyByintaskitemid(Long intaskitemid){
        return incollectdataMapper.selectSumqtyByintaskitemid(intaskitemid);
    }

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getInboundData(Incollectdata incollectdata){
        return incollectdataMapper.getInboundData(incollectdata);
    }
    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getOutboundData(Incollectdata incollectdata){
        return incollectdataMapper.getOutboundData(incollectdata);
    }

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getWorkloadData(Incollectdata incollectdata){
        return incollectdataMapper.getWorkloadData(incollectdata);
    }
    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getInboundDatabykindqty(Incollectdata incollectdata){
        return incollectdataMapper.getInboundDatabykindqty(incollectdata);
    }

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getInbounddetail(Incollectdata incollectdata){
        return incollectdataMapper.getInbounddetail(incollectdata);
    }

    /**
     * 查询入库采集数据列表
     *
     * @param incollectdata 入库批次检查
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getOutbounddetail(Incollectdata incollectdata)
    {
        return incollectdataMapper.getOutbounddetail(incollectdata);
    }

    /**
     * 查询入库采集数据列表
     *
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getractIndexLeftPack()
    {
        return incollectdataMapper.getractIndexLeftPack();
    }

    /**
     * 查询入库采集数据列表
     *
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getractIndexLeftin()
    {
        return incollectdataMapper.getractIndexLeftin();
    }

    /**
     * 查询入库采集数据列表
     *
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getractIndexLeftout()
    {
        return incollectdataMapper.getractIndexLeftout();
    }

    /**
     * 查询入库采集数据列表
     *
     * @return 入库采集数据集合
     */
    public List<Incollectdata> getractIndexLefworkorder()
    {
        return incollectdataMapper.getractIndexLefworkorder();
    }






    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCentershouhuolv(){
        return incollectdataMapper.getractIndexCentershouhuolv();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterbaojianlv(){
        return incollectdataMapper.getractIndexCenterbaojianlv();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterrukulv(){
        return incollectdataMapper.getractIndexCenterrukulv();
    }



    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterchukulv(){
        return incollectdataMapper.getractIndexCenterchukulv();
    }



    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterqitaolv(){
        return incollectdataMapper.getractIndexCenterqitaolv();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCentershouhuoqty(){
        return incollectdataMapper.getractIndexCentershouhuoqty();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterfahuoqty(){
        return incollectdataMapper.getractIndexCenterfahuoqty();
    }



    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCentercaituiqty(){
        return incollectdataMapper.getractIndexCentercaituiqty();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterchengruqty(){
        return incollectdataMapper.getractIndexCenterchengruqty();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCenterchengfaqty(){
        return incollectdataMapper.getractIndexCenterchengfaqty();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexCentershengtuiqty(){
        return incollectdataMapper.getractIndexCentershengtuiqty();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getStatyear(){
        return incollectdataMapper.getStatyear();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuo(){
        return incollectdataMapper.getAllLeftShouhuo();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMat(){
        return incollectdataMapper.getAllLeftShouhuoMat();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoC(){
        return incollectdataMapper.getAllLeftShouhuoC();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMatC(){
        return incollectdataMapper.getAllLeftShouhuoMatC();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoW(){
        return incollectdataMapper.getAllLeftShouhuoW();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMatW(){
        return incollectdataMapper.getAllLeftShouhuoMatW();
    }












    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuo(){
        return incollectdataMapper.getAllLeftFahuo();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMat(){
        return incollectdataMapper.getAllLeftFahuoMat();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoC(){
        return incollectdataMapper.getAllLeftFahuoC();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMatC(){
        return incollectdataMapper.getAllLeftFahuoMatC();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoW(){
        return incollectdataMapper.getAllLeftFahuoW();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMatW(){
        return incollectdataMapper.getAllLeftFahuoMatW();
    }












    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuo(){
        return incollectdataMapper.getAllLeftTuihuo();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMat(){
        return incollectdataMapper.getAllLeftTuihuoMat();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoC(){
        return incollectdataMapper.getAllLeftTuihuoC();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMatC(){
        return incollectdataMapper.getAllLeftTuihuoMatC();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoW(){
        return incollectdataMapper.getAllLeftTuihuoW();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMatW(){
        return incollectdataMapper.getAllLeftTuihuoMatW();
    }




    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengshuo(){
        return incollectdataMapper.getAllLeftChengshuo();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengshuoMat(){
        return incollectdataMapper.getAllLeftChengshuoMat();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengfhuo(){
        return incollectdataMapper.getAllLeftChengfhuo();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengfhuoMat(){
        return incollectdataMapper.getAllLeftChengfhuoMat();
    }









    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuiku(){
        return incollectdataMapper.getAllLeftTuiku();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMat(){
        return incollectdataMapper.getAllLeftTuikuMat();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuC(){
        return incollectdataMapper.getAllLeftTuikuC();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMatC(){
        return incollectdataMapper.getAllLeftTuikuMatC();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuW(){
        return incollectdataMapper.getAllLeftTuikuW();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMatW(){
        return incollectdataMapper.getAllLeftTuikuMatW();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getIndexRightStomeroom(){
        return incollectdataMapper.getIndexRightStomeroom();
    }



















    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailshouhuolv(){
        return incollectdataMapper.getractDetailshouhuolv();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailshouhuolvC(){
        return incollectdataMapper.getractDetailshouhuolvC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailshouhuolvW(){
        return incollectdataMapper.getractDetailshouhuolvW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailbaojianlv(){
        return incollectdataMapper.getractDetailbaojianlv();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailbaojianlvC(){
        return incollectdataMapper.getractDetailbaojianlvC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailbaojianlvW(){
        return incollectdataMapper.getractDetailbaojianlvW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailrukulv(){
        return incollectdataMapper.getractDetailrukulv();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailrukulvC(){
        return incollectdataMapper.getractDetailrukulvC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailrukulvW(){
        return incollectdataMapper.getractDetailrukulvW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailchukulv(){
        return incollectdataMapper.getractDetailchukulv();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailchukulvC(){
        return incollectdataMapper.getractDetailchukulvC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailchukulvW(){
        return incollectdataMapper.getractDetailchukulvW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailqitaolv(){
        return incollectdataMapper.getractDetailqitaolv();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailqitaolvC(){
        return incollectdataMapper.getractDetailqitaolvC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractDetailqitaolvW(){
        return incollectdataMapper.getractDetailqitaolvW();
    }




    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getShouHuoLvDetailDataTable(Incollectdata con){
        return incollectdataMapper.getShouHuoLvDetailDataTable(con);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getBaoJianLvDetailDataTable(Incollectdata con){
        return incollectdataMapper.getBaoJianLvDetailDataTable(con);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRuKuLvDetailDataTable(Incollectdata con){
        return incollectdataMapper.getRuKuLvDetailDataTable(con);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getChuKuLvDetailDataTable(Incollectdata con){
        return incollectdataMapper.getChuKuLvDetailDataTable(con);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getQiTaoLvDetailDataTable(Incollectdata con){
        return incollectdataMapper.getQiTaoLvDetailDataTable(con);
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRightActiveRingData1(){
        return incollectdataMapper.getRightActiveRingData1();
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRightActiveRingData2(){
        return incollectdataMapper.getRightActiveRingData2();
    }








    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getShouHuoLvWeek(){
        return incollectdataMapper.getShouHuoLvWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getBaoJianLvWeek(){
        return incollectdataMapper.getBaoJianLvWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRuKuLvWeek(){
        return incollectdataMapper.getRuKuLvWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getChuKuLvWeek(){
        return incollectdataMapper.getChuKuLvWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getQitaoLvWeek(){
        return incollectdataMapper.getQitaoLvWeek();
    }











    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoWeek(){
        return incollectdataMapper.getAllLeftShouhuoWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMatWeek(){
        return incollectdataMapper.getAllLeftShouhuoMatWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoWeekC(){
        return incollectdataMapper.getAllLeftShouhuoWeekC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMatWeekC(){
        return incollectdataMapper.getAllLeftShouhuoMatWeekC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoWeekW(){
        return incollectdataMapper.getAllLeftShouhuoWeekW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftShouhuoMatWeekW(){
        return incollectdataMapper.getAllLeftShouhuoMatWeekW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoWeek(){
        return incollectdataMapper.getAllLeftFahuoWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMatWeek(){
        return incollectdataMapper.getAllLeftFahuoMatWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoWeekC(){
        return incollectdataMapper.getAllLeftFahuoWeekC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMatWeekC(){
        return incollectdataMapper.getAllLeftFahuoMatWeekC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoWeekW(){
        return incollectdataMapper.getAllLeftFahuoWeekW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftFahuoMatWeekW(){
        return incollectdataMapper.getAllLeftFahuoMatWeekW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoWeek(){
        return incollectdataMapper.getAllLeftTuihuoWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMatWeek(){
        return incollectdataMapper.getAllLeftTuihuoMatWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoWeekC(){
        return incollectdataMapper.getAllLeftTuihuoWeekC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMatWeekC(){
        return incollectdataMapper.getAllLeftTuihuoMatWeekC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoWeekW(){
        return incollectdataMapper.getAllLeftTuihuoWeekW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuihuoMatWeekW(){
        return incollectdataMapper.getAllLeftTuihuoMatWeekW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengshuoWeek(){
        return incollectdataMapper.getAllLeftChengshuoWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengshuoMatWeek(){
        return incollectdataMapper.getAllLeftChengshuoMatWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengfhuoWeek(){
        return incollectdataMapper.getAllLeftChengfhuoWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftChengfhuoMatWeek(){
        return incollectdataMapper.getAllLeftChengfhuoMatWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuWeek(){
        return incollectdataMapper.getAllLeftTuikuWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMatWeek(){
        return incollectdataMapper.getAllLeftTuikuMatWeek();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuWeekC(){
        return incollectdataMapper.getAllLeftTuikuWeekC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMatWeekC(){
        return incollectdataMapper.getAllLeftTuikuMatWeekC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuWeekW(){
        return incollectdataMapper.getAllLeftTuikuWeekW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getAllLeftTuikuMatWeekW(){
        return incollectdataMapper.getAllLeftTuikuMatWeekW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getQitaoLvDetail(Incollectdata con){
        return incollectdataMapper.getQitaoLvDetail(con);
    }







    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftinDetail(){
        return incollectdataMapper.getractIndexLeftinDetail();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftinDetailC(){
        return incollectdataMapper.getractIndexLeftinDetailC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftinDetailW(){
        return incollectdataMapper.getractIndexLeftinDetailW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftoutDetail(){
        return incollectdataMapper.getractIndexLeftoutDetail();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftoutDetailC(){
        return incollectdataMapper.getractIndexLeftoutDetailC();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getractIndexLeftoutDetailW(){
        return incollectdataMapper.getractIndexLeftoutDetailW();
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRohAgingDetailData(Incollectdata con){
        return incollectdataMapper.getRohAgingDetailData(con);
    };


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getReAgingDetailData(Incollectdata con){
        return incollectdataMapper.getReAgingDetailData(con);
    };














    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayDetailData(Incollectdata con){
        return incollectdataMapper.getPiPeiLvMonthDayDetailData(con);
    };


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayData(Incollectdata con){
        return incollectdataMapper.getPiPeiLvMonthDayData(con);
    };


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvWeekData(){
        return incollectdataMapper.getPiPeiLvWeekData();
    };


    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthData(){
        return incollectdataMapper.getPiPeiLvMonthData();
    };







    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataDay(){
        return incollectdataMapper.getInOutQtyDetailDataDay();
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataWeek(){
        return incollectdataMapper.getInOutQtyDetailDataWeek();
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataMonth(){
        return incollectdataMapper.getInOutQtyDetailDataMonth();
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataYear(){
        return incollectdataMapper.getInOutQtyDetailDataYear();
    };











    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataDayC(){

        return incollectdataMapper.getInOutQtyDetailDataDayC();
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataWeekC(){
        return incollectdataMapper.getInOutQtyDetailDataWeekC();
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataMonthC(){
        return incollectdataMapper.getInOutQtyDetailDataMonthC();
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataYearC(){
        return incollectdataMapper.getInOutQtyDetailDataYearC();
    };





























    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataDayW(){

        return incollectdataMapper.getInOutQtyDetailDataDayW();
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataWeekW(){
        return incollectdataMapper.getInOutQtyDetailDataWeekW();
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataMonthW(){
        return incollectdataMapper.getInOutQtyDetailDataMonthW();
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getInOutQtyDetailDataYearW(){
        return incollectdataMapper.getInOutQtyDetailDataYearW();
    };



    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getReAgingDetailTable(Incollectdata con){
        return incollectdataMapper.getReAgingDetailTable(con);
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRohAgingDetailTable(Incollectdata con){
        return incollectdataMapper.getRohAgingDetailTable(con);
    };









    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getChuKuLvWeekW(){
        return incollectdataMapper.getChuKuLvWeekW();
    };




    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getChuKuLvWeekC(){
        return incollectdataMapper.getChuKuLvWeekC();
    };





    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getChuKuLvDetail(Incollectdata con){
        return incollectdataMapper.getChuKuLvDetail(con);
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getRuKuLvDetail(Incollectdata con){
        return incollectdataMapper.getRuKuLvDetail(con);
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getBaoJianLvDetail(Incollectdata con){
        return incollectdataMapper.getBaoJianLvDetail(con);
    };
    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getShouHuoLvDetail(Incollectdata con){
        return incollectdataMapper.getShouHuoLvDetail(con);
    };

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getQitaoLvDetail2(Incollectdata con){
        return incollectdataMapper.getQitaoLvDetail2(con);
    };

    public List<Incollectdata> getractIndexCenterpipeilv(){
        return incollectdataMapper.getractIndexCenterpipeilv();
    };

    @DataSource(value = DataSourceType.SLAVE)
    public List<Incollectdata> getIPQC(Incollectdata con){
        return incollectdataMapper.getIPQC(con);
    };

    @DataSource(value = DataSourceType.SLAVE)
    public List<Incollectdata> getZXD(Incollectdata con){
        return incollectdataMapper.getZXD(con);
    };

    public List<Incollectdata> getRightActiveRingData1C(){
        return incollectdataMapper.getRightActiveRingData1C();
    }
    public List<Incollectdata> getRightActiveRingData1W(){
        return incollectdataMapper.getRightActiveRingData1W();
    }

    public List<Incollectdata> getRohAgingDetailDataC(Incollectdata con){
        return incollectdataMapper.getRohAgingDetailDataC(con);
    };
    public List<Incollectdata> getRohAgingDetailDataW(Incollectdata con){
        return incollectdataMapper.getRohAgingDetailDataW(con);
    };

    public List<Incollectdata> getRohAgingDetailTableW(Incollectdata con){
        return incollectdataMapper.getRohAgingDetailTableW(con);
    };
    public List<Incollectdata> getRohAgingDetailTableC(Incollectdata con){
        return incollectdataMapper.getRohAgingDetailTableC(con);
    };




    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayDetailDataC(Incollectdata con){
        return incollectdataMapper.getPiPeiLvMonthDayDetailDataC(con);
    };

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayDetailDataW(Incollectdata con){
        return incollectdataMapper.getPiPeiLvMonthDayDetailDataW(con);
    };

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayDataC(Incollectdata con){
        return incollectdataMapper.getPiPeiLvMonthDayDataC(con);
    };

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDayDataW(Incollectdata con){
        return incollectdataMapper.getPiPeiLvMonthDayDataW(con);
    };

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDataC(){
        return incollectdataMapper.getPiPeiLvMonthDataC();
    };

    /**
     * 批量删除【请填写功能名称】
     *
     * @param
     * @return 结果
     */
    public List<Incollectdata> getPiPeiLvMonthDataW(){
        return incollectdataMapper.getPiPeiLvMonthDataW();
    };

}
