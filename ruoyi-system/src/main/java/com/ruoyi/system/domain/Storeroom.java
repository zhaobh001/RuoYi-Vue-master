package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysRole;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

import java.util.List;

/**
 * 库房对象 storeroom
 * 
 * @author ruoyi
 * @date 2023-07-01
 */
public class Storeroom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long storeroomid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String storeroomno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String storeroomname;

    /** 0：正常
1：冻结
2：锁定 */
    @Excel(name = "0：正常1：冻结 2：锁定")
    private String isfrozen;

    /** Y  已初始化
N  未初始化 */
    @Excel(name = "Y  已初始化N  未初始化")
    private String isinitialized;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String roomcharger;

    /** 0：WMS
1：外系统 */
    @Excel(name = "0：WMS1：外系统")
    private Long issystem;

    /** 0：平面库
1：立体库 */
    @Excel(name = "0：平面库1：立体库")
    private String roomtag;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String belongfactory;

    /** 1：合格
0：不合格 */
    @Excel(name = "1：合格0：不合格")
    private String isgood;

    /** 地区名拼音全拼 */
    @Excel(name = "地区名拼音全拼")
    private String areacode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String storeroomdesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dataversion;

    /** VMI子库指向 */
    @Excel(name = "VMI子库指向")
    private String data1;

    /** 自采子库指向 */
    @Excel(name = "自采子库指向")
    private String data2;

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

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data9;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data10;

    /** 0：出库下达允许被指派
1：出库下达不允许被指派 */
    @Excel(name = "0：出库下达允许被指派1：出库下达不允许被指派")
    private String allotflag;

    /** 箱区类型 */
    @Excel(name = "箱区类型")
    private String yaaType;

    /** 起始倍位 */
    @Excel(name = "起始倍位")
    private String yaaStbayno;

    /** 终止倍位 */
    @Excel(name = "终止倍位")
    private String yaaEdbayno;

    /** 排数 */
    @Excel(name = "排数")
    private Long yaaRows;

    /** 层数 */
    @Excel(name = "层数")
    private Long yaaTiers;

    /** X坐标 */
    @Excel(name = "X坐标")
    private Long yaaAreax;

    /** Y坐标 */
    @Excel(name = "Y坐标")
    private Long yaaAreay;

    /** 高度 */
    @Excel(name = "高度")
    private Long yaaHeight;

    /** 倍位走向 */
    @Excel(name = "倍位走向")
    private String yaaBayway;

    /** 排走向 */
    @Excel(name = "排走向")
    private String yaaRowway;

    /** 车道走向 */
    @Excel(name = "车道走向")
    private String yaaLaneway;

    /** 集卡数 */
    @Excel(name = "集卡数")
    private Long yaaTrucknum;

    /** 区域ID */
    @Excel(name = "区域ID")
    private Long yaaYbkBlockid;

    /** 所属客户ID */
    @Excel(name = "所属客户ID")
    private Long yaaTerCstmid;

    /** 箱区用途 */
    @Excel(name = "箱区用途")
    private String yaaUseage;

    /** 0：入库需要校验标准件
1：入库需要校验标准件 */
    @Excel(name = "0：入库需要校验标准件1：入库需要校验标准件")
    private String incheckflag;

    /** 0：按计划下发
1：按分配库存下发 */
    @Excel(name = "0：按计划下发1：按分配库存下发")
    private String dispatchflag;

    /** 库房占地面积 */
    @Excel(name = "库房占地面积")
    private Long storeroomarea;

    /** 物料采集方式 0：默认按物料采集
 1：全库按单件检查批次 2：全库按套不检查批次 */
    @Excel(name = "物料采集方式 0：默认按物料采集 1：全库按单件检查批次 2：全库按套不检查批次")
    private Long roommatcontrol;

    /** 高低状态(Y：正常,N：停用) */
    @Excel(name = "高低状态(Y：正常,N：停用)")
    private String highflag;

    /** 快慢状态(Y：正常,N：停用) */
    @Excel(name = "快慢状态(Y：正常,N：停用)")
    private String velocityflag;

    /** 项目管理状态(Y：正常,N：停用) */
    @Excel(name = "项目管理状态(Y：正常,N：停用)")
    private String projectflag;

    /** 角色对象 */
    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

    /** 角色ID */
    private Long roleId;

    private String storesiteno;

    public String getStoresiteno() {
        return storesiteno;
    }

    public void setStoresiteno(String storesiteno) {
        this.storesiteno = storesiteno;
    }

    public List<SysRole> getRoles()
    {
        return roles;
    }

    public void setRoles(List<SysRole> roles)
    {
        this.roles = roles;
    }

    public Long[] getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds)
    {
        this.roleIds = roleIds;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public void setStoreroomid(Long storeroomid) 
    {
        this.storeroomid = storeroomid;
    }

    public Long getStoreroomid() 
    {
        return storeroomid;
    }
    public void setStoreroomno(String storeroomno) 
    {
        this.storeroomno = storeroomno;
    }

    public String getStoreroomno() 
    {
        return storeroomno;
    }
    public void setStoreroomname(String storeroomname) 
    {
        this.storeroomname = storeroomname;
    }

    public String getStoreroomname() 
    {
        return storeroomname;
    }
    public void setIsfrozen(String isfrozen) 
    {
        this.isfrozen = isfrozen;
    }

    public String getIsfrozen() 
    {
        return isfrozen;
    }
    public void setIsinitialized(String isinitialized) 
    {
        this.isinitialized = isinitialized;
    }

    public String getIsinitialized() 
    {
        return isinitialized;
    }
    public void setRoomcharger(String roomcharger) 
    {
        this.roomcharger = roomcharger;
    }

    public String getRoomcharger() 
    {
        return roomcharger;
    }
    public void setIssystem(Long issystem) 
    {
        this.issystem = issystem;
    }

    public Long getIssystem() 
    {
        return issystem;
    }
    public void setRoomtag(String roomtag) 
    {
        this.roomtag = roomtag;
    }

    public String getRoomtag() 
    {
        return roomtag;
    }
    public void setBelongfactory(String belongfactory) 
    {
        this.belongfactory = belongfactory;
    }

    public String getBelongfactory() 
    {
        return belongfactory;
    }
    public void setIsgood(String isgood) 
    {
        this.isgood = isgood;
    }

    public String getIsgood() 
    {
        return isgood;
    }
    public void setAreacode(String areacode) 
    {
        this.areacode = areacode;
    }

    public String getAreacode() 
    {
        return areacode;
    }
    public void setStoreroomdesc(String storeroomdesc) 
    {
        this.storeroomdesc = storeroomdesc;
    }

    public String getStoreroomdesc() 
    {
        return storeroomdesc;
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
    public void setData9(String data9) 
    {
        this.data9 = data9;
    }

    public String getData9() 
    {
        return data9;
    }
    public void setData10(String data10) 
    {
        this.data10 = data10;
    }

    public String getData10() 
    {
        return data10;
    }
    public void setAllotflag(String allotflag) 
    {
        this.allotflag = allotflag;
    }

    public String getAllotflag() 
    {
        return allotflag;
    }
    public void setYaaType(String yaaType) 
    {
        this.yaaType = yaaType;
    }

    public String getYaaType() 
    {
        return yaaType;
    }
    public void setYaaStbayno(String yaaStbayno) 
    {
        this.yaaStbayno = yaaStbayno;
    }

    public String getYaaStbayno() 
    {
        return yaaStbayno;
    }
    public void setYaaEdbayno(String yaaEdbayno) 
    {
        this.yaaEdbayno = yaaEdbayno;
    }

    public String getYaaEdbayno() 
    {
        return yaaEdbayno;
    }
    public void setYaaRows(Long yaaRows) 
    {
        this.yaaRows = yaaRows;
    }

    public Long getYaaRows() 
    {
        return yaaRows;
    }
    public void setYaaTiers(Long yaaTiers) 
    {
        this.yaaTiers = yaaTiers;
    }

    public Long getYaaTiers() 
    {
        return yaaTiers;
    }
    public void setYaaAreax(Long yaaAreax) 
    {
        this.yaaAreax = yaaAreax;
    }

    public Long getYaaAreax() 
    {
        return yaaAreax;
    }
    public void setYaaAreay(Long yaaAreay) 
    {
        this.yaaAreay = yaaAreay;
    }

    public Long getYaaAreay() 
    {
        return yaaAreay;
    }
    public void setYaaHeight(Long yaaHeight) 
    {
        this.yaaHeight = yaaHeight;
    }

    public Long getYaaHeight() 
    {
        return yaaHeight;
    }
    public void setYaaBayway(String yaaBayway) 
    {
        this.yaaBayway = yaaBayway;
    }

    public String getYaaBayway() 
    {
        return yaaBayway;
    }
    public void setYaaRowway(String yaaRowway) 
    {
        this.yaaRowway = yaaRowway;
    }

    public String getYaaRowway() 
    {
        return yaaRowway;
    }
    public void setYaaLaneway(String yaaLaneway) 
    {
        this.yaaLaneway = yaaLaneway;
    }

    public String getYaaLaneway() 
    {
        return yaaLaneway;
    }
    public void setYaaTrucknum(Long yaaTrucknum) 
    {
        this.yaaTrucknum = yaaTrucknum;
    }

    public Long getYaaTrucknum() 
    {
        return yaaTrucknum;
    }
    public void setYaaYbkBlockid(Long yaaYbkBlockid) 
    {
        this.yaaYbkBlockid = yaaYbkBlockid;
    }

    public Long getYaaYbkBlockid() 
    {
        return yaaYbkBlockid;
    }
    public void setYaaTerCstmid(Long yaaTerCstmid) 
    {
        this.yaaTerCstmid = yaaTerCstmid;
    }

    public Long getYaaTerCstmid() 
    {
        return yaaTerCstmid;
    }
    public void setYaaUseage(String yaaUseage) 
    {
        this.yaaUseage = yaaUseage;
    }

    public String getYaaUseage() 
    {
        return yaaUseage;
    }
    public void setIncheckflag(String incheckflag) 
    {
        this.incheckflag = incheckflag;
    }

    public String getIncheckflag() 
    {
        return incheckflag;
    }
    public void setDispatchflag(String dispatchflag) 
    {
        this.dispatchflag = dispatchflag;
    }

    public String getDispatchflag() 
    {
        return dispatchflag;
    }
    public void setStoreroomarea(Long storeroomarea) 
    {
        this.storeroomarea = storeroomarea;
    }

    public Long getStoreroomarea() 
    {
        return storeroomarea;
    }
    public void setRoommatcontrol(Long roommatcontrol) 
    {
        this.roommatcontrol = roommatcontrol;
    }

    public Long getRoommatcontrol() 
    {
        return roommatcontrol;
    }
    public void setHighflag(String highflag) 
    {
        this.highflag = highflag;
    }

    public String getHighflag() 
    {
        return highflag;
    }
    public void setVelocityflag(String velocityflag) 
    {
        this.velocityflag = velocityflag;
    }

    public String getVelocityflag() 
    {
        return velocityflag;
    }
    public void setProjectflag(String projectflag) 
    {
        this.projectflag = projectflag;
    }

    public String getProjectflag() 
    {
        return projectflag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("storeroomid", storeroomid)
                .append("storeroomno", storeroomno)
                .append("storeroomname", storeroomname)
                .append("isfrozen", isfrozen)
                .append("isinitialized", isinitialized)
                .append("roomcharger", roomcharger)
                .append("issystem", issystem)
                .append("roomtag", roomtag)
                .append("belongfactory", belongfactory)
                .append("isgood", isgood)
                .append("areacode", areacode)
                .append("storeroomdesc", storeroomdesc)
                .append("dataversion", dataversion)
                .append("data1", data1)
                .append("data2", data2)
                .append("data3", data3)
                .append("data4", data4)
                .append("data5", data5)
                .append("data6", data6)
                .append("data7", data7)
                .append("data8", data8)
                .append("data9", data9)
                .append("data10", data10)
                .append("allotflag", allotflag)
                .append("yaaType", yaaType)
                .append("yaaStbayno", yaaStbayno)
                .append("yaaEdbayno", yaaEdbayno)
                .append("yaaRows", yaaRows)
                .append("yaaTiers", yaaTiers)
                .append("yaaAreax", yaaAreax)
                .append("yaaAreay", yaaAreay)
                .append("yaaHeight", yaaHeight)
                .append("yaaBayway", yaaBayway)
                .append("yaaRowway", yaaRowway)
                .append("yaaLaneway", yaaLaneway)
                .append("yaaTrucknum", yaaTrucknum)
                .append("yaaYbkBlockid", yaaYbkBlockid)
                .append("yaaTerCstmid", yaaTerCstmid)
                .append("yaaUseage", yaaUseage)
                .append("incheckflag", incheckflag)
                .append("dispatchflag", dispatchflag)
                .append("storeroomarea", storeroomarea)
                .append("roommatcontrol", roommatcontrol)
                .append("highflag", highflag)
                .append("velocityflag", velocityflag)
                .append("projectflag", projectflag)
                .append("roles", roles)
                .append("roleIds", roleIds)
                .append("roleId", roleId)
                .append("storesiteno", storesiteno)
                .toString();
    }
}
