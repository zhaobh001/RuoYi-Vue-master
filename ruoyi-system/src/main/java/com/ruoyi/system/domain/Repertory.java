package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 货物库存对象 repertory
 * 
 * @author ruoyi
 * @date 2023-07-30
 */
public class Repertory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long repertoryid;

    /** 库房 */
    @Excel(name = "库房")
    private Long storeroomid;

    /** 库位 */
    @Excel(name = "库位")
    private Long storesiteid;

    /** 物料ID */
    @Excel(name = "物料ID")
    private Long materialid;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchno;

    /** 序列号 */
    @Excel(name = "序列号")
    private String sn;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private BigDecimal repqty;

    /** ? */
    @Excel(name = "?")
    private String repColor;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private String repProperty;

    /** 库存拥有方代码,自采为6463 */
    @Excel(name = "库存拥有方代码,自采为6463")
    private String repOwnerCode;

    /** 库存拥有方名称 */
    @Excel(name = "库存拥有方名称")
    private String repOwnerName;

    /** 库存拥有组织 */
    @Excel(name = "库存拥有组织")
    private String repOrg;

    /** 库存数量(辅助单位) */
    @Excel(name = "库存数量(辅助单位)")
    private Long secondrepqty;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long repprovider;

    private Date updatetime;

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /** 0：正常
1：不良
2：检验中 */
    @Excel(name = "0：正常1：不良2：检验中")
    private Long repstate;

    /** 0：正常
1：冻结 2：锁定

冻结：不再支持任何出入库业务 */
    @Excel(name = "0：正常1：冻结 2：锁定冻结：不再支持任何出入库业务")
    private String isfrozen;

    /** 0：否
1：是
锁定：允许库存变化 */
    @Excel(name = "0：否1：是锁定：允许库存变化")
    private String islocked;

    /** ?备注 */
    @Excel(name = "?备注")
    private String repdesc;

    /** 数据版本 */
    @Excel(name = "数据版本")
    private Long dataversion;

    /** Db中 有值为 0 和 null */
    @Excel(name = "Db中 有值为 0 和 null")
    private String data1;

    /** 颜色 */
    @Excel(name = "颜色")
    private String data2;

    private String storeSite;
    private String matCode;

    private String parno;
    private String erp_storeroom;

    private Long amount;

    private String storesiteno;
    private String matcode;

    private String storeroomname;
    private String storeroomno;
    private String matinnercode;
    private String matname;
    private String matunit;
    private String matmodel;
    private String name;
    private String repstate_nm;
    private String isfrozen_nm;
    private String parname;
    private String matycode;
    private String matyname;
    private String matcodecontrol;
    private String qualflg;

    private String sourceStoresiteNo;
    private String targetStoresiteNo;

    private Date createtime;

    private String filter;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSourceStoresiteNo() {
        return sourceStoresiteNo;
    }

    public void setSourceStoresiteNo(String sourceStoresiteNo) {
        this.sourceStoresiteNo = sourceStoresiteNo;
    }

    public String getTargetStoresiteNo() {
        return targetStoresiteNo;
    }

    public void setTargetStoresiteNo(String targetStoresiteNo) {
        this.targetStoresiteNo = targetStoresiteNo;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getStoreroomname() {
        return storeroomname;
    }

    public void setStoreroomname(String storeroomname) {
        this.storeroomname = storeroomname;
    }

    public String getStoreroomno() {
        return storeroomno;
    }

    public void setStoreroomno(String storeroomno) {
        this.storeroomno = storeroomno;
    }

    public String getMatinnercode() {
        return matinnercode;
    }

    public void setMatinnercode(String matinnercode) {
        this.matinnercode = matinnercode;
    }

    public String getMatname() {
        return matname;
    }

    public void setMatname(String matname) {
        this.matname = matname;
    }

    public String getMatunit() {
        return matunit;
    }

    public void setMatunit(String matunit) {
        this.matunit = matunit;
    }

    public String getMatmodel() {
        return matmodel;
    }

    public void setMatmodel(String matmodel) {
        this.matmodel = matmodel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepstate_nm() {
        return repstate_nm;
    }

    public void setRepstate_nm(String repstate_nm) {
        this.repstate_nm = repstate_nm;
    }

    public String getIsfrozen_nm() {
        return isfrozen_nm;
    }

    public void setIsfrozen_nm(String isfrozen_nm) {
        this.isfrozen_nm = isfrozen_nm;
    }

    public String getParname() {
        return parname;
    }

    public void setParname(String parname) {
        this.parname = parname;
    }

    public String getMatycode() {
        return matycode;
    }

    public void setMatycode(String matycode) {
        this.matycode = matycode;
    }

    public String getMatyname() {
        return matyname;
    }

    public void setMatyname(String matyname) {
        this.matyname = matyname;
    }

    public String getMatcodecontrol() {
        return matcodecontrol;
    }

    public void setMatcodecontrol(String matcodecontrol) {
        this.matcodecontrol = matcodecontrol;
    }

    public String getQualflg() {
        return qualflg;
    }

    public void setQualflg(String qualflg) {
        this.qualflg = qualflg;
    }

    public String getStoresiteno() {
        return storesiteno;
    }

    public void setStoresiteno(String storesiteno) {
        this.storesiteno = storesiteno;
    }

    public String getMatcode() {
        return matcode;
    }

    public void setMatcode(String matcode) {
        this.matcode = matcode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getParno() {
        return parno;
    }

    public void setParno(String parno) {
        this.parno = parno;
    }

    public String getErp_storeroom() {
        return erp_storeroom;
    }

    public void setErp_storeroom(String erp_storeroom) {
        this.erp_storeroom = erp_storeroom;
    }

    public String getStoreSite() {
        return storeSite;
    }

    public void setStoreSite(String storeSite) {
        this.storeSite = storeSite;
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode;
    }

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data4;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data5;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data6;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data7;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data8;

    /** ERP子库 */
    @Excel(name = "ERP子库")
    private String erpStoreroom;

    /** 托盘号 */
    @Excel(name = "托盘号")
    private String palletno;

    /** 占用数量 */
    @Excel(name = "占用数量")
    private BigDecimal occupyqty;

    /** 托盘状态 */
    @Excel(name = "托盘状态")
    private Long palletstate;

    /** 项目号 */
    @Excel(name = "项目号")
    private String projectNum;

    /** 出库单号 */
    @Excel(name = "出库单号")
    private String orderno;

    /** 产线编号 */
    @Excel(name = "产线编号")
    private String productline;

    /** 工位 */
    @Excel(name = "工位")
    private String workstation;

    /** 工序 */
    @Excel(name = "工序")
    private Long operationSeqNum;

    /** 成套集盒 */
    @Excel(name = "成套集盒")
    private String wholesetno;

    /** 备份0：正常
1：冻结 2：锁定

冻结：不再支持任何出入库业务 */
    @Excel(name = "备份0：正常1：冻结 2：锁定冻结：不再支持任何出入库业务")
    private String isfrozenbak;

    /** 录入日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "录入日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inserttime;

    /** 占用出库单号 */
    @Excel(name = "占用出库单号")
    private String occupyOrderno;

    /** 冻结人员 */
    @Excel(name = "冻结人员")
    private String frozenuser;

    /** 备份冻结人员 */
    @Excel(name = "备份冻结人员")
    private String frozenuserbak;

    private int PageIndex;
    private int PageSize;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public void setRepertoryid(Long repertoryid) 
    {
        this.repertoryid = repertoryid;
    }

    public Long getRepertoryid() 
    {
        return repertoryid;
    }
    public void setStoreroomid(Long storeroomid) 
    {
        this.storeroomid = storeroomid;
    }

    public Long getStoreroomid() 
    {
        return storeroomid;
    }
    public void setStoresiteid(Long storesiteid) 
    {
        this.storesiteid = storesiteid;
    }

    public Long getStoresiteid() 
    {
        return storesiteid;
    }
    public void setMaterialid(Long materialid) 
    {
        this.materialid = materialid;
    }

    public Long getMaterialid() 
    {
        return materialid;
    }
    public void setBatchno(String batchno) 
    {
        this.batchno = batchno;
    }

    public String getBatchno() 
    {
        return batchno;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }

    public BigDecimal getRepqty() {
        return repqty;
    }

    public void setRepqty(BigDecimal repqty) {
        this.repqty = repqty;
    }

    public BigDecimal getOccupyqty() {
        return occupyqty;
    }

    public void setOccupyqty(BigDecimal occupyqty) {
        this.occupyqty = occupyqty;
    }

    public void setRepColor(String repColor)
    {
        this.repColor = repColor;
    }

    public String getRepColor() 
    {
        return repColor;
    }
    public void setRepProperty(String repProperty) 
    {
        this.repProperty = repProperty;
    }

    public String getRepProperty() 
    {
        return repProperty;
    }
    public void setRepOwnerCode(String repOwnerCode) 
    {
        this.repOwnerCode = repOwnerCode;
    }

    public String getRepOwnerCode() 
    {
        return repOwnerCode;
    }
    public void setRepOwnerName(String repOwnerName) 
    {
        this.repOwnerName = repOwnerName;
    }

    public String getRepOwnerName() 
    {
        return repOwnerName;
    }
    public void setRepOrg(String repOrg) 
    {
        this.repOrg = repOrg;
    }

    public String getRepOrg() 
    {
        return repOrg;
    }
    public void setSecondrepqty(Long secondrepqty) 
    {
        this.secondrepqty = secondrepqty;
    }

    public Long getSecondrepqty() 
    {
        return secondrepqty;
    }
    public void setRepprovider(Long repprovider) 
    {
        this.repprovider = repprovider;
    }

    public Long getRepprovider() 
    {
        return repprovider;
    }
    public void setRepstate(Long repstate) 
    {
        this.repstate = repstate;
    }

    public Long getRepstate() 
    {
        return repstate;
    }
    public void setIsfrozen(String isfrozen) 
    {
        this.isfrozen = isfrozen;
    }

    public String getIsfrozen() 
    {
        return isfrozen;
    }
    public void setIslocked(String islocked) 
    {
        this.islocked = islocked;
    }

    public String getIslocked() 
    {
        return islocked;
    }
    public void setRepdesc(String repdesc) 
    {
        this.repdesc = repdesc;
    }

    public String getRepdesc() 
    {
        return repdesc;
    }
    public void setDataversion(Long dataversion) 
    {
        this.dataversion = dataversion;
    }

    public Long getDataversion() 
    {
        return dataversion;
    }
    public void setData1(String data1) 
    {
        this.data1 = data1;
    }

    public String getData1() 
    {
        return data1;
    }
    public void setData2(String data2) 
    {
        this.data2 = data2;
    }

    public String getData2() 
    {
        return data2;
    }
    public void setData3(String data3) 
    {
        this.data3 = data3;
    }

    public String getData3() 
    {
        return data3;
    }
    public void setData4(String data4) 
    {
        this.data4 = data4;
    }

    public String getData4() 
    {
        return data4;
    }
    public void setData5(String data5) 
    {
        this.data5 = data5;
    }

    public String getData5() 
    {
        return data5;
    }
    public void setData6(String data6) 
    {
        this.data6 = data6;
    }

    public String getData6() 
    {
        return data6;
    }
    public void setData7(String data7) 
    {
        this.data7 = data7;
    }

    public String getData7() 
    {
        return data7;
    }
    public void setData8(String data8) 
    {
        this.data8 = data8;
    }

    public String getData8() 
    {
        return data8;
    }
    public void setErpStoreroom(String erpStoreroom) 
    {
        this.erpStoreroom = erpStoreroom;
    }

    public String getErpStoreroom() 
    {
        return erpStoreroom;
    }
    public void setPalletno(String palletno) 
    {
        this.palletno = palletno;
    }

    public String getPalletno() 
    {
        return palletno;
    }

    public void setPalletstate(Long palletstate) 
    {
        this.palletstate = palletstate;
    }

    public Long getPalletstate() 
    {
        return palletstate;
    }
    public void setProjectNum(String projectNum) 
    {
        this.projectNum = projectNum;
    }

    public String getProjectNum() 
    {
        return projectNum;
    }
    public void setOrderno(String orderno) 
    {
        this.orderno = orderno;
    }

    public String getOrderno() 
    {
        return orderno;
    }
    public void setProductline(String productline) 
    {
        this.productline = productline;
    }

    public String getProductline() 
    {
        return productline;
    }
    public void setWorkstation(String workstation) 
    {
        this.workstation = workstation;
    }

    public String getWorkstation() 
    {
        return workstation;
    }
    public void setOperationSeqNum(Long operationSeqNum) 
    {
        this.operationSeqNum = operationSeqNum;
    }

    public Long getOperationSeqNum() 
    {
        return operationSeqNum;
    }
    public void setWholesetno(String wholesetno) 
    {
        this.wholesetno = wholesetno;
    }

    public String getWholesetno() 
    {
        return wholesetno;
    }
    public void setIsfrozenbak(String isfrozenbak) 
    {
        this.isfrozenbak = isfrozenbak;
    }

    public String getIsfrozenbak() 
    {
        return isfrozenbak;
    }
    public void setInserttime(Date inserttime) 
    {
        this.inserttime = inserttime;
    }

    public Date getInserttime() 
    {
        return inserttime;
    }
    public void setOccupyOrderno(String occupyOrderno) 
    {
        this.occupyOrderno = occupyOrderno;
    }

    public String getOccupyOrderno() 
    {
        return occupyOrderno;
    }
    public void setFrozenuser(String frozenuser) 
    {
        this.frozenuser = frozenuser;
    }

    public String getFrozenuser() 
    {
        return frozenuser;
    }
    public void setFrozenuserbak(String frozenuserbak) 
    {
        this.frozenuserbak = frozenuserbak;
    }

    public String getFrozenuserbak() 
    {
        return frozenuserbak;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("repertoryid", repertoryid)
                .append("storeroomid", storeroomid)
                .append("storesiteid", storesiteid)
                .append("materialid", materialid)
                .append("batchno", batchno)
                .append("sn", sn)
                .append("repqty", repqty)
                .append("repColor", repColor)
                .append("repProperty", repProperty)
                .append("repOwnerCode", repOwnerCode)
                .append("repOwnerName", repOwnerName)
                .append("repOrg", repOrg)
                .append("secondrepqty", secondrepqty)
                .append("repprovider", repprovider)
                .append("repstate", repstate)
                .append("isfrozen", isfrozen)
                .append("islocked", islocked)
                .append("repdesc", repdesc)
                .append("dataversion", dataversion)
                .append("data1", data1)
                .append("data2", data2)
                .append("storeSite", storeSite)
                .append("matCode", matCode)
                .append("parno", parno)
                .append("erp_storeroom", erp_storeroom)
                .append("amount", amount)
                .append("storesiteno", storesiteno)
                .append("matcode", matcode)
                .append("storeroomname", storeroomname)
                .append("storeroomno", storeroomno)
                .append("matinnercode", matinnercode)
                .append("matname", matname)
                .append("matunit", matunit)
                .append("matmodel", matmodel)
                .append("name", name)
                .append("repstate_nm", repstate_nm)
                .append("isfrozen_nm", isfrozen_nm)
                .append("parname", parname)
                .append("matycode", matycode)
                .append("matyname", matyname)
                .append("matcodecontrol", matcodecontrol)
                .append("qualflg", qualflg)
                .append("createtime", createtime)
                .append("data3", data3)
                .append("data4", data4)
                .append("data5", data5)
                .append("data6", data6)
                .append("data7", data7)
                .append("data8", data8)
                .append("erpStoreroom", erpStoreroom)
                .append("palletno", palletno)
                .append("occupyqty", occupyqty)
                .append("palletstate", palletstate)
                .append("projectNum", projectNum)
                .append("orderno", orderno)
                .append("productline", productline)
                .append("workstation", workstation)
                .append("operationSeqNum", operationSeqNum)
                .append("wholesetno", wholesetno)
                .append("isfrozenbak", isfrozenbak)
                .append("inserttime", inserttime)
                .append("occupyOrderno", occupyOrderno)
                .append("frozenuser", frozenuser)
                .append("frozenuserbak", frozenuserbak)
                .toString();
    }
}
