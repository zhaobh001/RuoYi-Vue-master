package com.ruoyi.web.controller.system;

import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import org.apache.poi.hpsf.Decimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/terminal")
public class SysTerminalController extends BaseController {
    @Autowired
    private IArrivalsBillService arrivalsBillService;

    @Autowired
    private IArrivalsDetailService arrivalsDetailService;

    @Autowired
    private IPmMaterialService pmMaterialService;

    @Autowired
    private IIntaskService intaskService;

    @Autowired
    private IIntaskitemService iIntaskitemService;

    @Autowired
    private IStoreroomService iStoreroomService;

    @Autowired
    private IRepertoryService iRepertoryService;

    @Autowired
    private IArrivalsBillCheckerService iArrivalsBillCheckerService;

    @Autowired
    private IArrivalsDetailCollService iArrivalsDetailCollService;
    @Autowired
    private IPmMaterialService iPmMaterialService;

    @Autowired
    private IIncollectdataService iIncollectdataService;

    @Autowired
    private IIntaskService iIntaskService;

    @Autowired
    IBbQueueService iBbQueueService;

    @Autowired
    IDcConnectService iDcConnectService;

    @Autowired
    IStoresiteService iStoresiteService;

    @Autowired
    IPalletService iPalletService;

    @Autowired
    IPalletItemService iPalletItemService;

    @Autowired
    IInterfaceWmsToWcsService iInterfaceWmsToWcsService;
    @Autowired
    IOuttaskService iOuttaskService;

    @Autowired
    IOuttaskitemService iOuttaskitemService;

    @Autowired
    IOutcollectdataService iOutcollectdataService;

    @Autowired
    ISterrooutexitService iSterrooutexitService;

    @Autowired
    IMaterialQtyService iMaterialQtyService;

    @Autowired
    IDrawmaterialRfBillService iDrawmaterialRfBillService;

    @Autowired
    IDrawmaterialRfBillItemService iDrawmaterialRfBillItemService;

    @Autowired
    IChecktaskService iChecktaskService;

    @Autowired
    ICheckcollectdataService iCheckcollectdataService;

    @Autowired
    IExpcollectdataService iExpcollectdataService;

    @Autowired
    private IOutbillService iOutbillService;

    @Autowired
    private ISysNoticeService iSysNoticeService;

    @Autowired
    private IMoveinoutService iMoveinoutService;

    @Autowired
    private ISysMessageService iSysMessageService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private ISysConfigService configService;

    // ===================== 配送核验（work_delivery）依赖 =====================

    @Autowired
    private IDeliverybillService iDeliverybillService;

    @Autowired
    private IDeliveryproofService iDeliveryproofService;

    @Autowired
    private IDeliverytaskService iDeliverytaskService;

    @Autowired
    private IDeliverytaskitemService iDeliverytaskitemService;

    @Autowired
    private IDeliverytaskitemExceService iDeliverytaskitemExceService;


    /**
     * 根据用户编号获已接收未完成到货任务清单
     */
    @GetMapping("/arriveSignList")
    public AjaxResult getInfo(ArrivalsBill arrivalsBill) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();
        arrivalsBill.setUserId(userId);
        if (arrivalsBill.getPageIndex() > 0 && arrivalsBill.getPageSize() > 0) {
            PageHelper.startPage(arrivalsBill.getPageIndex(), arrivalsBill.getPageSize());
        }
        List<ArrivalsBill> arrivalsBillList = arrivalsBillService.selectArriveSignList(arrivalsBill);
        AjaxResult ajax = AjaxResult.success(getDataTable(arrivalsBillList));
        return ajax;
    }

    /**
     * 根据用户编号获已接收未完成到货任务清单
     */
    @GetMapping("/arriveUnSignList")
    public AjaxResult getUnInfo(ArrivalsBill arrivalsBill) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        arrivalsBill.setUserId(userId);

        if (arrivalsBill.getPageIndex() > 0 && arrivalsBill.getPageSize() > 0) {
            PageHelper.startPage(arrivalsBill.getPageIndex(), arrivalsBill.getPageSize());
        }
        List<ArrivalsBill> arrivalsBillList = arrivalsBillService.selectArriveSignUnReceList(arrivalsBill);
        AjaxResult ajax = AjaxResult.success(getDataTable(arrivalsBillList));
        return ajax;
    }

    /**
     * 根据用户编号获已接收未完成到货任务清单
     */
    @GetMapping("/arriveSignDetailList")
    public AjaxResult getArriveSignDetailInfo(ArrivalsDetail arrivalsDetail) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();
        arrivalsDetail.setUserId(userId);
        if (arrivalsDetail.getPageIndex() > 0 && arrivalsDetail.getPageSize() > 0) {
            PageHelper.startPage(arrivalsDetail.getPageIndex(), arrivalsDetail.getPageSize());
        }
        List<ArrivalsDetail> arrivalsBillDetailList = arrivalsDetailService.selectArriveDetailList(arrivalsDetail);
        AjaxResult ajax = AjaxResult.success(getDataTable(arrivalsBillDetailList));
        return ajax;
    }

    /**
     * 单据接收
     */
    @GetMapping("/receArriveSign")
    public AjaxResult receArriveSign(Long arrivalsBillid) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        if (StringUtils.isNull(arrivalsBillid)) {
            return error("未查询到装箱单信息");
        }
        ArrivalsBill arrivalsBill = arrivalsBillService.selectArrivalsBillByArrivalsBillid(arrivalsBillid);
        if (StringUtils.isNull(arrivalsBill)) {
            return error("未查询到装箱单信息");
        }

        String is_data5 = arrivalsBill.getData5();
        if (!StringUtils.isNull(is_data5) && is_data5.indexOf(userId.toString()) > 0) {
            return error("已经领过该任务");
        }
        String is_data5_n = "";
        if (StringUtils.isNull(is_data5)) {
            is_data5_n = "," + userId.toString() + ",";
        } else {
            is_data5_n = is_data5 + userId.toString() + ",";
        }

        arrivalsBill.setData5(is_data5_n);
        arrivalsBillService.updateArrivalsBill(arrivalsBill);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 单据撤销
     */
    @GetMapping("/cancleArriveSign")
    public AjaxResult cancleArriveSign(Long arrivalsBillid) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        if (StringUtils.isNull(arrivalsBillid)) {
            return error("未查询到装箱单信息");
        }
        ArrivalsBill arrivalsBill = arrivalsBillService.selectArrivalsBillByArrivalsBillid(arrivalsBillid);
        if (StringUtils.isNull(arrivalsBill)) {
            return error("未查询到装箱单信息");
        }

        String is_data5 = arrivalsBill.getData5();
        if (StringUtils.isNull(is_data5) || is_data5.indexOf(userId.toString()) < 0) {
            return error("您没有领过该任务,无需撤销");
        }

        String is_data5_n = "";
        if (is_data5.indexOf(userId.toString()) > 0) {
            is_data5_n = is_data5.replace("," + userId.toString() + ",", ",");
        } else {
            return error("您没有领过该任务,无需撤销");
        }

        arrivalsBill.setData5(is_data5_n);
        arrivalsBillService.updateArrivalsBill(arrivalsBill);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 根据二维码获取物料信息
     */
    @GetMapping("/materialInfo")
    public AjaxResult getPmMaterialInfoByQR(String QRstring) {
        ArrivalsDetailColl arrivalsDetailColl = new ArrivalsDetailColl();
        String matcontrl = "";
        String newmarttask = "0";
        if (QRstring == null || QRstring.equals("")) {
            return error("二维码内容为空，请重新采集");
        }
        String lastCharStr = QRstring.substring(QRstring.length() - 1);
        /*if(lastCharStr.equals("*")){
            QRstring=QRstring.substring(0,QRstring.length()-1);
        }*/
        String[] PmMaterialArray = QRstring.split("\\*");
        //首先判断 二维码样式 是新格式还是老格式,是否包含 *BN
        if (StringUtils.contains(QRstring, "*BN")) {
            newmarttask = "1";
        }
        for (String item : PmMaterialArray) {
            if (item == null || item.equals("")) continue;
            if(item.length()<2){
                continue;
            }
            String mark = item.substring(0, 2);
            switch (mark) {
                case "MC":
                    String materialCode = item.substring(2);
                    PmMaterial pmMaterial = new PmMaterial();
                    if (newmarttask.equals("1")) {
                        if (materialCode.isEmpty()) {
                            return error("二维码中物料编码不能缺失");
                        }
                        pmMaterial.setMatcode(materialCode);
                        List<PmMaterial> pmMaterialList2 = pmMaterialService.selectPmMaterialList(pmMaterial);
                        if (pmMaterialList2.isEmpty() || pmMaterialList2.size() <= 0) {
                            return error("二维码中物料编码在当前系统未维护基础信息");
                        }
                        pmMaterial = pmMaterialList2.get(0);
                        arrivalsDetailColl.setId_old(newmarttask);
                        arrivalsDetailColl.setMatcode(materialCode);
                        arrivalsDetailColl.setMatname(pmMaterial.getMatname());
                        arrivalsDetailColl.setSeqctrl(pmMaterial.getMatcodecontrol().toString());
                        arrivalsDetailColl.setMaterialid(pmMaterial.getPmMaterialid());
                        String ASSORTMENT_4=pmMaterial.getAssortment4();
                        String dgFlg="N";
                        if(!StringUtils.isNull(ASSORTMENT_4)){
                            dgFlg="Y";
                        }else{
                            dgFlg="N";
                        }
                        arrivalsDetailColl.setDgFlg(dgFlg);
                    }
                    if (newmarttask.equals("0")) {
                        if (materialCode.isEmpty()) {
                            return error("二维码中物料编码不能缺失");
                        }
                        pmMaterial.setMatinnercode(materialCode);
                        List<PmMaterial> pmMaterialList = pmMaterialService.selectPmMaterialList(pmMaterial);
                        if (pmMaterialList.isEmpty() || pmMaterialList.size() <= 0) {
                            return error("二维码中物料编码在当前系统未维护基础信息");
                        }
                        pmMaterial = pmMaterialList.get(0);
                        arrivalsDetailColl.setMatcode(materialCode);
                        arrivalsDetailColl.setSeqctrl(pmMaterial.getMatcodecontrol().toString());
                    }
                    break;

                case "DN":
                    String drawCode = item.substring(2);
                    if (!drawCode.isEmpty())
                        arrivalsDetailColl.setDrawCode(drawCode);
                    break;

                case "DV":
                    String drawVersion = item.substring(2);
                    if (!drawVersion.isEmpty())
                        arrivalsDetailColl.setDrawVersion(drawVersion);
                    break;

                case "BN":
                    String BatchNo = item.substring(2);

                    if (!BatchNo.isEmpty()) {
                        arrivalsDetailColl.setBatchno(BatchNo);
                    } else {
                        if (arrivalsDetailColl.getSeqctrl().equals("2")) {
                            arrivalsDetailColl.setBatchno("unity_batch");
                        }
                    }
                    break;

                case "SN":
                    String sn = item.substring(2);
                    if (!sn.isEmpty())
                        arrivalsDetailColl.setSn(sn);
                    break;

                case "MF":
                    String manufacturerCode = item.substring(2);
                    if (!manufacturerCode.isEmpty())
                        arrivalsDetailColl.setManufacturerCode(manufacturerCode);
                    break;
                case "AG":
                    String agentCode = item.substring(2);
                    if (!agentCode.isEmpty())
                        arrivalsDetailColl.setAgentCode(agentCode);
                    break;
                case "PD":
                    String pdate = item.substring(2);
                    if ((!pdate.isEmpty()) && isValidYyyymmdd(pdate))
                        arrivalsDetailColl.setPdate(pdate);
                    break;
                case "WD":
                    String vdays = item.substring(2);
                    if (!vdays.isEmpty())
                        arrivalsDetailColl.setVdays(vdays);
                    break;
                default:
                    break;
            }
        }
        AjaxResult ajax = AjaxResult.success(arrivalsDetailColl);
        return ajax;
    }

    public static boolean isValidYyyymmdd(String dateStr) {
        if (dateStr == null || dateStr.length() != 8) {
            return false;
        }
        // 正则：4位年份 + 2位月份(01-12) + 2位日期(01-31)
        String regex = "^(\\d{4})(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])$";
        return dateStr.matches(regex);
    }
    /*    *//**
     * 采集上传
     * *//*
    @GetMapping("/commitSign")
    public AjaxResult CommitSignShelves(String upShelvesInfos)
    {
        List<UpShelvesInfo> demoList = JSON.parseArray(upShelvesInfos,UpShelvesInfo.class);
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId=user.getUserId();

        List<ArrivalsDetail> arrivalsBillDetailList = arrivalsDetailService.selectArriveDetailList(null);
        AjaxResult ajax = AjaxResult.success(arrivalsBillDetailList);
        ajax.put("arrivalsBill", null);
        return ajax;
    }*/

    /**
     * 到货签收采集上传
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitSign")
    public AjaxResult CommitSignShelves(@RequestBody UpShelvesInfoReq data) {

        List<UpShelvesInfo> upShelvesInfoList = data.getUpShelvesInfos();
        List<ItemListInfo> itemListInfoList = data.getItemListInfos();
        String filter = data.getFilter();

        if (upShelvesInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }
        if (itemListInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }

        java.util.Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(day));

        String collect_time = sdf.format(day);
        Long intaskitemid = Long.parseLong(upShelvesInfoList.get(0).getInTaskItemid());
        ArrivalsDetail arrivalsDetail = arrivalsDetailService.selectArrivalsDetailByArrivalsDetailid(intaskitemid);
        if (StringUtils.isNull(arrivalsDetail)) {
            return error("未查询到装箱单明细信息");
        }

        Long arrivals_billid = arrivalsDetail.getArrivalsBillid();
        ArrivalsBill arrivalsBill = arrivalsBillService.selectArrivalsBillByArrivalsBillid(arrivals_billid);
        if (StringUtils.isNull(arrivalsBill)) {
            return error("未查询到装箱单信息");
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        ArrivalsBillChecker arrivalsBillChecker = new ArrivalsBillChecker();
        arrivalsBillChecker.setUserid(userId);
        arrivalsBillChecker.setArrivalsBillid(arrivals_billid);
        List<ArrivalsBillChecker> ArrivalsBillCheckerList = iArrivalsBillCheckerService.selectArrivalsBillCheckerList(arrivalsBillChecker);
        if (StringUtils.isNull(ArrivalsBillCheckerList) || ArrivalsBillCheckerList.size() <= 0) {
            iArrivalsBillCheckerService.insertArrivalsBillChecker(arrivalsBillChecker);
        }

        ArrivalsDetail arrivalsDetail2 = new ArrivalsDetail();
        arrivalsDetail2.setArrivalsBillid(arrivals_billid);
        List<ArrivalsDetail> arrivalsDetailList = arrivalsDetailService.selectArrivalsDetailList(arrivalsDetail2);
        if (StringUtils.isNull(arrivalsDetailList)) {
            return error("未查询到装箱单明细对应的任务信息");
        }

        ArrivalsDetailColl arrivalsDetailColl = new ArrivalsDetailColl();
        arrivalsDetailColl.setArrivalsBillid(arrivals_billid);
        List<ArrivalsDetailColl> arrivalsDetailCollList = iArrivalsDetailCollService.selectArrivalsDetailCollList(arrivalsDetailColl);

        List<ArrivalsDetail> arrivalsDetailList_bk = new ArrayList<ArrivalsDetail>();
        List<ArrivalsDetailColl> arrivalsDetailCollList_del = new ArrayList<ArrivalsDetailColl>();
        List<ArrivalsDetailColl> arrivalsDetailCollList_new = new ArrayList<ArrivalsDetailColl>();

        Map<String, List<String>> dicMtlQty = new HashMap<>();
        for (int l = 0; l < upShelvesInfoList.size(); l++) {
            UpShelvesInfo item = upShelvesInfoList.get(l);

            BigDecimal taskQty = new BigDecimal(0);
            BigDecimal tmpQty = new BigDecimal(0);

            PmMaterial pmMaterial = new PmMaterial();
            pmMaterial.setMatcode(item.getMatCode());
            PmMaterial material = iPmMaterialService.selectPmMaterialList(pmMaterial).get(0);

            Boolean exsitFlag = false;
            if (item.getMatchingFlg().equals("0")) {
                BigDecimal decQty = item.getCollectQty();
                List<String> ls = new ArrayList<String>();
                Map<String, List<Decimal>> dicMtlOperatin = new HashMap<>();

                for (int i = 0; i < arrivalsDetailList.size(); i++) {
                    if (decQty.compareTo(BigDecimal.ZERO) <= 0) {
                        break;
                    }
                    if (!item.getInTaskItemid().equals(arrivalsDetailList.get(i).getArrivalsDetailid().toString())) {
                        continue;
                    }

                    taskQty = arrivalsDetailList.get(i).getQty();
                    String Goodqty = arrivalsDetailList.get(i).getGoodqty();
                    if (StringUtils.isNull(Goodqty)) {
                        Goodqty = "0";
                    }
                    BigDecimal GOODQTY = new BigDecimal(Goodqty);
                    tmpQty = GOODQTY;

                    if (taskQty.compareTo(tmpQty) == 0) {
                        continue;
                    }
                    ;

                    String inTaskItemid = item.getInTaskItemid() + item.getBatchNo() + item.getSn();

                    if (!dicMtlQty.containsKey(inTaskItemid)) {
                        ls = new ArrayList<String>();

                        ls.add(item.getInTaskItemid());
                        ls.add(item.getBatchNo());
                        ls.add(item.getSn());
                        ls.add("0");
                        ls.add("Y");
                        ls.add(material.getMatcodecontrol().toString());
                        ls.add(item.getData1());
                        ls.add(item.getData2());
                        dicMtlQty.put(inTaskItemid, ls);
                    }
                    if ((taskQty.subtract(tmpQty)).compareTo(decQty) >= 0)//表示足够扣
                    {

                        arrivalsDetailList.get(i).setGoodqty(decQty.add(GOODQTY).toString());
                        arrivalsDetailList.get(i).setData1(item.getData1()); //生产日期
                        arrivalsDetailList.get(i).setData2(item.getData2()); //保质期
                        arrivalsDetailList.get(i).setData3(userId.toString()); //采集时间
                        arrivalsDetailList.get(i).setData4(collect_time); //采集时间

                        if (arrivalsDetailList.get(i).getData5() == null || arrivalsDetailList.get(i).getData5().equals("匹配")) {
                            arrivalsDetailList.get(i).setData5("匹配"); //是否匹配
                        } else {
                            arrivalsDetailList.get(i).setData5("不匹配"); //是否匹配
                        }

                        List<String> dicMtlQty_item = dicMtlQty.get(inTaskItemid);
                        dicMtlQty_item.set(3, (new BigDecimal(dicMtlQty_item.get(3)).add(decQty)).toString());
                        dicMtlQty_item.set(4, "Y");
                        dicMtlQty.put(inTaskItemid, dicMtlQty_item);

                        arrivalsDetailService.updateArrivalsDetail(arrivalsDetailList.get(i));
                        decQty = new BigDecimal(0);
                        exsitFlag = true;

                    } else {
                        decQty = decQty.subtract(taskQty.subtract(tmpQty));//本次扫描数量- 计划剩余数量

                        arrivalsDetailList.get(i).setGoodqty(decQty.toString());
                        arrivalsDetailList.get(i).setData1(item.getData1()); //生产日期
                        arrivalsDetailList.get(i).setData2(item.getData2()); //保质期
                        arrivalsDetailList.get(i).setData3(userId.toString()); //采集时间
                        arrivalsDetailList.get(i).setData4(collect_time); //采集时间

                        if (arrivalsDetailList.get(i).getData5() == null || arrivalsDetailList.get(i).getData5().equals("匹配")) {
                            arrivalsDetailList.get(i).setData5("匹配"); //是否匹配
                        } else {
                            arrivalsDetailList.get(i).setData5("不匹配"); //是否匹配
                        }

                        List<String> dicMtlQty_item = dicMtlQty.get(inTaskItemid);
                        dicMtlQty_item.set(3, (new BigDecimal(dicMtlQty_item.get(3)).add(decQty.subtract(tmpQty))).toString());
                        dicMtlQty_item.set(4, "Y");
                        dicMtlQty.put(inTaskItemid, dicMtlQty_item);
                        arrivalsDetailService.updateArrivalsDetail(arrivalsDetailList.get(i));
                    }
                }
                if (!exsitFlag) {
                    return error("采集物料批号序列号信息匹配任务明细失败");
                }

                //添加采集记录;对于采集记录的修改操作统一在采集明细中操作
            }


            // qiangzhicajiFlag=1 正常采集 批次序列付采集任务匹配 需要踢掉已经采集数据里面的采集不批次记录，并将其转到其他任务
            if (item.getMatchingFlg().equals("1")) {
                BigDecimal decQty = item.getCollectQty();
                List<String> ls = new ArrayList<String>();
                Map<String, List<Decimal>> dicMtlOperatin = new HashMap<>();


                Long materialid = material.getPmMaterialid();

                List<ArrivalsDetailColl> stocks_cl = new ArrayList<ArrivalsDetailColl>();


                for (int i = 0; i < arrivalsDetailList.size(); i++) {
                    //首先修改任务-不匹配数据从已采集列表删除
                    //将采集任务的已采集数据减去不匹配数据数量
                    //处理当前采集数量
                    //处理删除的不匹配数量

                    if (decQty.compareTo(BigDecimal.ZERO) <= 0) {
                        break;
                    }
                    Long tmpMat = arrivalsDetailList.get(i).getMaterialid();//物料
                    if (!tmpMat.equals(materialid)) {
                        continue;//如果物料、货位不是当前输入的物料、货位 继续
                    }

                   /* if (!item.getInTaskItemid().equals(arrivalsDetailList.get(i).getArrivalsDetailid().toString()))
                    {
                        continue;
                    }*/

                    taskQty = arrivalsDetailList.get(i).getQty();

                    String Goodqty = arrivalsDetailList.get(i).getGoodqty();
                    if (StringUtils.isNull(Goodqty)) {
                        Goodqty = "0";
                    }
                    BigDecimal GOODQTY = new BigDecimal(Goodqty);
                    tmpQty = GOODQTY;

                    /*if (material.getMatcodecontrol().equals(1L) || material.getMatcodecontrol().equals(2L))
                    {
                        //booCheck true表示完工入库 不校验批次
                        String tmpBatch = arrivalsDetailList.get(i).getBatchno();
                        if (!tmpBatch.equals(item.getBatchNo()))
                        {
                            continue;
                        }
                    }

                    if (material.getMatcodecontrol().equals(0L))
                    {
                        String tmpBatch = arrivalsDetailList.get(i).getBatchno();
                        String tmpSn = arrivalsDetailList.get(i).getSn();
                        if (!(tmpBatch.equals(item.getBatchNo()) && tmpSn.equals(item.getSn())))
                        {
                            continue;
                        }
                    }*/
                    ArrivalsDetailColl arrivalsDetailColl02 = new ArrivalsDetailColl();
                    arrivalsDetailColl02.setArrivalsDetailid(arrivalsDetailList.get(i).getArrivalsDetailid());

                    //检查是否有非匹配采集记录
                    List<ArrivalsDetailColl> stocks = iArrivalsDetailCollService.selectArrivalsDetailCollList(arrivalsDetailColl02);

                    BigDecimal shengyuQty = new BigDecimal(0);

                    for (int j = stocks.size() - 1; j >= 0; j--) {
                        ArrivalsDetailColl stock = stocks.get(j);

                        Long InTaskItemid = stock.getArrivalsDetailid();
                        String InCollectFlg = stock.getYnpipei();

                        if (InTaskItemid.equals(arrivalsDetailList.get(i).getArrivalsDetailid()) && InCollectFlg.equals("N")) {
                            stocks_cl.add(stock);
                            arrivalsDetailCollList_del.add(stock);
                            shengyuQty = shengyuQty.add(stock.getGoodqty());
                            stocks.remove(j);
                        }
                    }

                    tmpQty = tmpQty.subtract(shengyuQty);
                    if (taskQty.equals(tmpQty)) {
                        continue;
                    }

                    String inTaskItemid = arrivalsDetailList.get(i).getArrivalsDetailid() + item.getBatchNo() + item.getSn();
                    if (!dicMtlQty.containsKey(inTaskItemid)) {
                        ls = new ArrayList<String>();

                        ls.add(arrivalsDetailList.get(i).getArrivalsDetailid().toString());
                        ls.add(item.getBatchNo());
                        ls.add(item.getSn());
                        ls.add("0");
                        ls.add("Y");
                        ls.add(material.getMatcodecontrol().toString());
                        ls.add(item.getData1());
                        ls.add(item.getData2());
                        dicMtlQty.put(inTaskItemid, ls);
                    }

                    if ((taskQty.subtract(tmpQty)).compareTo(decQty) >= 0)//表示足够扣
                    {
                        arrivalsDetailList.get(i).setGoodqty(decQty.add(GOODQTY).toString());
                        arrivalsDetailList.get(i).setData1(item.getData1()); //生产日期
                        arrivalsDetailList.get(i).setData2(item.getData2()); //保质期
                        arrivalsDetailList.get(i).setData3(userId.toString()); //采集时间
                        arrivalsDetailList.get(i).setData4(collect_time); //采集时间

                        if (arrivalsDetailList.get(i).getData5() == null || arrivalsDetailList.get(i).getData5().equals("匹配")) {
                            arrivalsDetailList.get(i).setData5("匹配"); //是否匹配
                        } else {
                            arrivalsDetailList.get(i).setData5("不匹配"); //是否匹配
                        }

                        List<String> dicMtlQty_item = dicMtlQty.get(inTaskItemid);
                        dicMtlQty_item.set(3, (new BigDecimal(dicMtlQty_item.get(3)).add(decQty)).toString());
                        dicMtlQty_item.set(4, "Y");
                        dicMtlQty.put(inTaskItemid, dicMtlQty_item);

                        decQty = new BigDecimal(0);
                        exsitFlag = true;
                        arrivalsDetailService.updateArrivalsDetail(arrivalsDetailList.get(i));

                    } else {
                        decQty = decQty.subtract(taskQty.subtract(tmpQty));//本次扫描数量- 计划剩余数量

                        arrivalsDetailList.get(i).setGoodqty(taskQty.toString());
                        arrivalsDetailList.get(i).setData1(item.getData1()); //生产日期
                        arrivalsDetailList.get(i).setData2(item.getData2()); //保质期
                        arrivalsDetailList.get(i).setData3(userId.toString()); //采集时间
                        arrivalsDetailList.get(i).setData4(collect_time); //采集时间

                        if (arrivalsDetailList.get(i).getData5() == null || arrivalsDetailList.get(i).getData5().equals("匹配")) {
                            arrivalsDetailList.get(i).setData5("匹配"); //是否匹配
                        } else {
                            arrivalsDetailList.get(i).setData5("不匹配"); //是否匹配
                        }

                        List<String> dicMtlQty_item = dicMtlQty.get(inTaskItemid);
                        dicMtlQty_item.set(3, (new BigDecimal(dicMtlQty_item.get(3)).add(taskQty.subtract(tmpQty))).toString());
                        dicMtlQty_item.set(4, "Y");
                        dicMtlQty.put(inTaskItemid, dicMtlQty_item);
                        arrivalsDetailService.updateArrivalsDetail(arrivalsDetailList.get(i));
                    }

                }
                if (!exsitFlag && decQty.equals(item.getCollectQty())) {
                    return error("采集物料批号序列号信息匹配任务明细失败");
                }

                if (decQty.compareTo(BigDecimal.ZERO) > 0) {
                    ArrivalsDetailColl newDetail_coll = new ArrivalsDetailColl();
                    newDetail_coll.setMaterialid(materialid);
                    newDetail_coll.setPdate(item.getData1());
                    newDetail_coll.setVdays(item.getData2());
                    newDetail_coll.setCjbatchno(item.getBatchNo());
                    newDetail_coll.setCjsn(item.getSn());
                    newDetail_coll.setGoodqty(decQty);
                    newDetail_coll.setYnpipei("Y");
                    stocks_cl.add(newDetail_coll);
                }

                for (int x = 0; x < stocks_cl.size(); x++) {
                    ArrivalsDetailColl stock = stocks_cl.get(x);

                    dicMtlOperatin = new HashMap<>();
                    decQty = stock.getGoodqty();

                    for (int i = 0; i < arrivalsDetailList.size(); i++) {

                        if (decQty.compareTo(BigDecimal.ZERO) <= 0) {
                            break;
                        }

                        Long tmpMat = arrivalsDetailList.get(i).getMaterialid();//物料

                        if (!tmpMat.equals(materialid)) {
                            continue;//如果物料、货位不是当前输入的物料、货位 继续
                        }

                        taskQty = arrivalsDetailList.get(i).getQty();
                        BigDecimal GOODQTY = new BigDecimal(arrivalsDetailList.get(i).getGoodqty());
                        tmpQty = GOODQTY;

                        if (taskQty.equals(tmpQty)) {
                            continue;
                        }

                        String inTaskItemid = arrivalsDetailList.get(i).getArrivalsDetailid() + item.getBatchNo() + item.getSn();
                        if (!dicMtlQty.containsKey(inTaskItemid)) {
                            ls = new ArrayList<String>();

                            ls.add(arrivalsDetailList.get(i).getArrivalsDetailid().toString());
                            ls.add(item.getBatchNo());
                            ls.add(item.getSn());
                            ls.add("0");
                            ls.add("N");
                            ls.add(material.getMatcodecontrol().toString());
                            ls.add(item.getData1());
                            ls.add(item.getData2());
                            dicMtlQty.put(inTaskItemid, ls);
                        }

                        if ((taskQty.subtract(tmpQty)).compareTo(decQty) >= 0)//表示足够扣
                        {
                            arrivalsDetailList.get(i).setGoodqty(decQty.add(GOODQTY).toString());
                            arrivalsDetailList.get(i).setData1(item.getData1()); //生产日期
                            arrivalsDetailList.get(i).setData2(item.getData2()); //保质期
                            arrivalsDetailList.get(i).setData3(userId.toString()); //采集时间
                            arrivalsDetailList.get(i).setData4(collect_time); //采集时间
                            arrivalsDetailList.get(i).setData5("不匹配"); //是否匹配


                            List<String> dicMtlQty_item = dicMtlQty.get(inTaskItemid);
                            dicMtlQty_item.set(3, (new BigDecimal(dicMtlQty_item.get(3)).add(decQty)).toString());
                            dicMtlQty_item.set(4, "N");
                            dicMtlQty.put(inTaskItemid, dicMtlQty_item);

                            decQty = new BigDecimal(0);
                            exsitFlag = true;
                            arrivalsDetailService.updateArrivalsDetail(arrivalsDetailList.get(i));
                        } else {
                            decQty = decQty.subtract(taskQty.subtract(tmpQty));//本次扫描数量- 计划剩余数量

                            arrivalsDetailList.get(i).setGoodqty(taskQty.toString());
                            arrivalsDetailList.get(i).setData1(item.getData1()); //生产日期
                            arrivalsDetailList.get(i).setData2(item.getData2()); //保质期
                            arrivalsDetailList.get(i).setData3(userId.toString()); //采集时间
                            arrivalsDetailList.get(i).setData4(collect_time); //采集时间
                            arrivalsDetailList.get(i).setData5("不匹配"); //是否匹配

                            List<String> dicMtlQty_item = dicMtlQty.get(inTaskItemid);
                            dicMtlQty_item.set(3, (new BigDecimal(dicMtlQty_item.get(3)).add(taskQty.subtract(tmpQty))).toString());
                            dicMtlQty_item.set(4, "N");
                            dicMtlQty.put(inTaskItemid, dicMtlQty_item);
                            arrivalsDetailService.updateArrivalsDetail(arrivalsDetailList.get(i));
                        }
                    }

                    if (!exsitFlag) {
                        return error("采集物料批号序列号信息匹配任务明细失败");
                    }
                }
            }
        }

        for (String key : dicMtlQty.keySet()) {
            for (int i = 0; i < arrivalsDetailList.size(); i++) {
                ArrivalsDetail delinfo = arrivalsDetailList.get(i);

                String arrivals_detailid = dicMtlQty.get(key).get(0);
                if (arrivals_detailid.equals(delinfo.getArrivalsDetailid().toString())) {
                    ArrivalsDetailColl newDetail_coll = new ArrivalsDetailColl();
                    newDetail_coll.setArrivalsDetailid(arrivalsDetailList.get(i).getArrivalsDetailid());
                    newDetail_coll.setArrivalsBillid(arrivalsDetailList.get(i).getArrivalsBillid());
                    newDetail_coll.setMaterialid(arrivalsDetailList.get(i).getMaterialid());
                    newDetail_coll.setSeqctrl(dicMtlQty.get(key).get(5));
                    newDetail_coll.setYnorig("Y");
                    newDetail_coll.setQty(arrivalsDetailList.get(i).getQty());
                    newDetail_coll.setBatchno(arrivalsDetailList.get(i).getBatchno());
                    if (StringUtils.isNull(arrivalsDetailList.get(i).getSn())) {
                        newDetail_coll.setSn(" ");
                    } else {
                        newDetail_coll.setSn(arrivalsDetailList.get(i).getSn());
                    }

                    newDetail_coll.setPdate(dicMtlQty.get(key).get(6));
                    newDetail_coll.setVdays(dicMtlQty.get(key).get(7));
                    newDetail_coll.setCjbatchno(dicMtlQty.get(key).get(1));
                    if (StringUtils.isNull(dicMtlQty.get(key).get(2))) {
                        newDetail_coll.setCjsn(" ");
                    } else {
                        newDetail_coll.setCjsn(dicMtlQty.get(key).get(2));
                    }

                    newDetail_coll.setGoodqty(new BigDecimal((dicMtlQty.get(key).get(3))));
                    newDetail_coll.setYnpipei(dicMtlQty.get(key).get(4));
                    arrivalsDetailCollList_new.add(newDetail_coll);
                    break;
                }
            }
        }

        for (int i = 0; i < arrivalsDetailCollList_del.size(); i++) {
            ArrivalsDetailColl delinfo = arrivalsDetailCollList_del.get(i);
            iArrivalsDetailCollService.deleteArrivalsDetailCollByArrivalsDetailid(delinfo);
        }

        for (int i = 0; i < arrivalsDetailCollList_new.size(); i++) {
            //需要增加逻辑 新增之前先判断是否存在 否则 修改

            ArrivalsDetailColl delinfo = arrivalsDetailCollList_new.get(i);

            ArrivalsDetailColl newDetail_coll_u = new ArrivalsDetailColl();
            newDetail_coll_u.setArrivalsDetailid(delinfo.getArrivalsDetailid());
            newDetail_coll_u.setArrivalsBillid(delinfo.getArrivalsBillid());
            newDetail_coll_u.setCjbatchno(delinfo.getCjbatchno());
            newDetail_coll_u.setCjsn(delinfo.getCjsn());
            newDetail_coll_u.setBatchno(delinfo.getBatchno());
            newDetail_coll_u.setSn(delinfo.getSn());
            List<ArrivalsDetailColl> newDetail_coll_uList = iArrivalsDetailCollService.selectArrivalsDetailCollList(newDetail_coll_u);
            if (newDetail_coll_uList.size() == 0) {
                iArrivalsDetailCollService.insertArrivalsDetailColl(delinfo);
            } else {
                newDetail_coll_u = newDetail_coll_uList.get(0);
                newDetail_coll_u.setGoodqty(delinfo.getGoodqty().add(newDetail_coll_u.getGoodqty()));
                iArrivalsDetailCollService.updateArrivalsDetailColl(newDetail_coll_u);
            }
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 获取尚未完成的已经收入库单据
     */
    @GetMapping("/intaskList")
   // @Log(title = "获取尚未完成的已经收入库单据", businessType = BusinessType.INSERT)
    public AjaxResult getIntaskList(Intask intask) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        intask.setI_collecter(userId);
        intask.setInstate(userId);

        Long iInstate = -1L;
        Long iUserId = 0L;
        if (intask.getUserId().equals("ALL")) {
            iInstate = 0L;
        } else {
            iUserId = Long.parseLong(intask.getUserId());
            iInstate = 1L;
        }
        intask.setI_collecter(iUserId);
        intask.setInstate(iInstate);
        intask.setUserId(intask.getRoleoRuserId());
        intask.setRoomTag(intask.getRoomTag());
        intask.setTransferType(intask.getTransferType());
        if (intask.getPageIndex() > 0 && intask.getPageSize() > 0) {
            PageHelper.startPage(intask.getPageIndex(), intask.getPageSize());
        }

        List<Intask> intaskList = intaskService.selectIntaskList(intask);
        AjaxResult ajax = AjaxResult.success(getDataTable(intaskList));
        return ajax;
    }

    /**
     * 获取尚未完成的已经收入库单据
     *
     * @param intaskitem 任务查询条件
     * @return 单据明细
     */
    @GetMapping("/intaskitemList")
    //@Log(title = "单据明细", businessType = BusinessType.INSERT)
    public AjaxResult getIntaskitemList(Intaskitem intaskitem) {

        Long iUserId = 0L;
        Long iInstate = -1L;

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        if (intaskitem.getUserId().equals("ALL")) {
            iInstate = 0L;
        } else {
            iInstate = 1L;
            iUserId = Long.parseLong(intaskitem.getUserId());
        }

        intaskitem.setInstate(iInstate);
        intaskitem.setUserId(userId.toString());
        intaskitem.setI_collecter(iUserId);
        if (intaskitem.getPageIndex() > 0 && intaskitem.getPageSize() > 0) {
            PageHelper.startPage(intaskitem.getPageIndex(), intaskitem.getPageSize());
        }

        List<Intaskitem> intaskitemList = iIntaskitemService.selectIntaskitemList(intaskitem);
        AjaxResult ajax = AjaxResult.success(getDataTable(intaskitemList));
        return ajax;
    }

    /**
     * 根据库房号获取该库房下所有的库位
     *
     * @param storeRoomNo 库方编码
     * @param storeSiteNo 库位编码
     * @return 当前库存数量
     */
    @GetMapping("/getStoreSite")
    public AjaxResult getStoreSiteByRoom(String storeRoomNo, String storeSiteNo) {
        Storeroom storeroom = new Storeroom();
        storeroom.setStoreroomno(storeRoomNo);
        storeroom.setStoresiteno(storeSiteNo);
        List<Storeroom> storeroomList = iStoreroomService.selectStoreSiteByRoom(storeroom);
        AjaxResult ajax = AjaxResult.success(storeroomList);
        return ajax;
    }

    /**
     * 取物料库位库存
     *
     * @param storeSite 来源库位
     * @param matCode   物料编码
     * @return 当前库存数量
     */
    @GetMapping("/getMtlRepertory")
    public AjaxResult getMtlRepertoryByStoresiteNo(String storeSite, String matCode) {
        Repertory repertory = new Repertory();
        repertory.setMatCode(matCode);
        repertory.setStoreSite(storeSite);

        List<Repertory> repertoryList = new ArrayList<Repertory>();
        if (StringUtils.isNull(storeSite)) {
            repertoryList = iRepertoryService.selectMtlRepertoryByMatNo(repertory);
        } else {
            repertoryList = iRepertoryService.selectMtlRepertoryByStoresiteNo(repertory);
        }
        AjaxResult ajax = AjaxResult.success(repertoryList);
        return ajax;
    }

    /**
     * 取物料库位库存
     *
     * @param storeSite 来源库位
     * @param matCode   物料编码
     * @return 当前库存数量
     */
    @GetMapping("/getLSMtlRepertoryByStoresiteNo")
    public AjaxResult getLSMtlRepertoryByStoresiteNo(String storeSite, String matCode) {
        Repertory repertory = new Repertory();
        repertory.setMatCode(matCode);
        repertory.setStoreSite(storeSite);

        List<Repertory> repertoryList = new ArrayList<Repertory>();
        if (StringUtils.isNull(storeSite)) {
            repertoryList = iRepertoryService.selectLSMtlRepertoryByMatNo(repertory);
        } else {
            repertoryList = iRepertoryService.selectLSMtlRepertoryByStoresiteNo(repertory);
        }
        AjaxResult ajax = AjaxResult.success(repertoryList);
        return ajax;
    }

    /**
     * 取物料库位库存
     *
     * @param storeSite 来源库位
     * @param matCode   物料编码
     * @return 当前库存数量
     */
    @GetMapping("/getMtlRepertoryGoodsDown")
    public AjaxResult getMtlRepertoryGoodsDown(String storeSite, String matCode, String erp_storeroom, String batchno, String sn) {
        Repertory repertory = new Repertory();
        repertory.setMatCode(matCode);
        repertory.setStoreSite(storeSite);

        List<Repertory> repertoryList = new ArrayList<Repertory>();
        if (storeSite.isEmpty()) {
            repertoryList = iRepertoryService.selectMtlRepertoryByMatNo(repertory);
        } else {
            repertoryList = iRepertoryService.selectMtlRepertoryByStoresiteNo(repertory);
        }
        AjaxResult ajax = AjaxResult.success(repertoryList);
        return ajax;
    }

    /// <summary>
    /// 生成通讯批次号
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    public String GenerateDcConnectNo() {
        java.util.Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(day));

        Calendar rightNow = Calendar.getInstance();

        int number = Register("通讯批次", String.format("%04d", rightNow.get(Calendar.YEAR))
                , String.format("%02d", rightNow.get(Calendar.MONTH) + 1), String.format("%02d", rightNow.get(Calendar.DATE)), 1);
        String rtnString = sdf.format(day) + String.format("%05d", number);
        return rtnString;
    }

    /// <summary>
    /// 生成通讯批次号
    /// </summary>
    /// <param name="context"></param>
    /// <returns></returns>
    public String GenerateOutBillNo() {
        java.util.Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(day));

        Calendar rightNow = Calendar.getInstance();

        int number = Register("拉式发料单", String.format("%04d", rightNow.get(Calendar.YEAR))
                , String.format("%02d", rightNow.get(Calendar.MONTH) + 1), String.format("%02d", rightNow.get(Calendar.DATE)), 1);
        String rtnString = sdf.format(day) + String.format("%05d", number);
        return rtnString;
    }

    public int Register(String cata1, String cata2, String cata3, String cata4, int number) {
        BbQueue bbQueue_req = new BbQueue();
        bbQueue_req.setCata1(cata1);
        bbQueue_req.setCata2(cata2);
        bbQueue_req.setCata3(cata3);
        bbQueue_req.setCata4(cata4);
        BbQueue bbQueue = new BbQueue();
        List<BbQueue> bbQueueList = iBbQueueService.selectBbQueueList(bbQueue_req);
        if (StringUtils.isNull(bbQueueList) || bbQueueList.size() <= 0) {

            bbQueue.setCata1(cata1);
            bbQueue.setCata2(cata2);
            bbQueue.setCata3(cata3);
            bbQueue.setCata4(cata4);
            bbQueue.setSno(0L);
            bbQueue.setDataversion(1L);
            iBbQueueService.insertBbQueue(bbQueue);
        } else {
            bbQueue = bbQueueList.get(0);
        }

        bbQueue.setSno(bbQueue.getSno() + number);
        bbQueue.setDataversion(bbQueue.getDataversion() + 1);
        iBbQueueService.updateBbQueue(bbQueue);
        return (int) bbQueue.getSno().longValue() - number + 1;
    }

    /**
     * 上架提交业务
     */
    @Transactional(rollbackFor = Exception.class)
    //@Log(title = "上架提交业务", businessType = BusinessType.INSERT)
    @PostMapping("/commitUp")
    public AjaxResult CommitUpShelves(@RequestBody UpShelvesInfoReq data) throws Exception {

        Long I_CONNECTID = null;
        List<UpShelvesInfo> upShelvesInfoList = data.getUpShelvesInfos();
        List<ItemListInfo> itemListInfoList = data.getItemListInfos();
        if (upShelvesInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }
        if (itemListInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }

        String filter = data.getFilter();
        List<Incollectdata> incollectdataList = new ArrayList<Incollectdata>();
        if (StringUtils.isNull(filter)) {

            if (filter.contains("@")) {
                StringBuilder sb = new StringBuilder();
                String[] larr_ = filter.split(",");
                for (int ii = 0; ii < larr_.length; ii++) {
                    String ls_mat_sn = larr_[ii];
                    if (ls_mat_sn == null || ls_mat_sn.length() < 3) {
                        continue;
                    }
                    int li_p_split = ls_mat_sn.indexOf("@");
                    if (li_p_split > 0) {
                        String ls_matcode = ls_mat_sn.substring(1, li_p_split - 1);
                        sb.append(',').append('\'').append(ls_matcode).append('\'');
                    }

                    Incollectdata incollectdata = new Incollectdata();
                    incollectdata.setFilter(filter);
                    incollectdata.setSb(sb.toString());
                    incollectdataList = iIncollectdataService.selectIncollectdatabathCheack(incollectdata);
                }
            } else {
                Incollectdata incollectdata = new Incollectdata();
                incollectdata.setFilter(filter);
                incollectdataList = iIncollectdataService.selectIncollectdatabathCheack(incollectdata);
            }
            if (!StringUtils.isNull(incollectdataList)) {
                String ls_exist_sn = "";
                for (int iesn = 0; iesn < incollectdataList.size(); iesn++) {
                    ls_exist_sn += " " + incollectdataList.get(iesn).getSn();
                }
                return error("批号【" + ls_exist_sn + "】在库房已经存在，请确认");
            }
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        String taskNo = upShelvesInfoList.get(0).getTaskNo();
        Intask task = iIntaskService.selectIntaskByIntaskNo(taskNo);
        if (StringUtils.isNull(task)) {
            return error("未查询到任务号" + taskNo + "对应的任务信息");
        }
        String S_CONNECTNO = GenerateDcConnectNo();
        java.util.Date D_CONTIME = new Date();

        DcConnect dcConnect = new DcConnect();
        dcConnect.setDcConnectno(S_CONNECTNO);
        dcConnect.setContime(D_CONTIME);
        dcConnect.setCollectortype("WIRELESS");
        dcConnect.setBusinesskind("IN");
        dcConnect.setConstate(1L);
        dcConnect.setConemp(i_collecterId);
        dcConnect.setTaskid(task.getIntaskid());
        dcConnect.setTaskno(task.getIntaskno());
        dcConnect.setProofno(task.getTaskcomment());
        dcConnect.setProofid(task.getTasksource());
        dcConnect.setDataversion(1L);
        Long retID = iDcConnectService.insertDcConnect(dcConnect);
        if (retID > 0) {
            I_CONNECTID = dcConnect.getDcConnectid();
        }

        Intaskitem intaskitem = new Intaskitem();
        intaskitem.setIntaskid(task.getIntaskid());
        List<Intaskitem> intaskitemList = iIntaskitemService.selectIntaskitemList2(intaskitem);
        if (StringUtils.isNull(intaskitemList) || intaskitemList.size() <= 0) {
            return error("未查询到任务号" + taskNo + "对应的任务信息");
        }

        Map<String, Intaskitem> dicIntask = new HashMap<>();

        for (int io = 0; io < itemListInfoList.size(); io++) {
            ItemListInfo itemListInfo = itemListInfoList.get(io);
            final Long inTaskItemid = Long.parseLong(itemListInfo.getInTaskItemid());

            List<Intaskitem> inTaskItemList2 = intaskitemList.stream().filter(item -> inTaskItemid.equals(item.getIntaskitemid())).collect(Collectors.toList());
            if (StringUtils.isNull(inTaskItemList2)) {
                return error("未查询到凭证号" + task.getTaskcomment() + ",货物" + itemListInfo.getMtlCode() + "对应的入库明细信息");
            }
            Intaskitem inTaskItem = inTaskItemList2.get(0);

            String strInTaskItemid = inTaskItem.getIntaskitemid().toString();
            if (!dicIntask.containsKey(strInTaskItemid)) {
                dicIntask.put(strInTaskItemid, inTaskItem);
            }
            if (!(new BigDecimal(itemListInfo.getMtlQty()[0]).equals(inTaskItem.getCollectedqty()))) {
                return error("货物" + itemListInfo.getMtlCode() + "的数据已经采集，请确认");
            }
            inTaskItem.setCollectedqty(new BigDecimal(itemListInfo.getMtlQty()[1]));//MtlQty[0] 表示开始采集数据时此笔物料的数量  MtlQty[1]表示当前采集数
            iIntaskitemService.updateIntaskitem(inTaskItem);
        }

        List<Incollectdata> list = new ArrayList<Incollectdata>();
        for (int io = 0; io < upShelvesInfoList.size(); io++) {
            UpShelvesInfo info = upShelvesInfoList.get(io);
            if (StringUtils.isNull(info.getStoreSiteNo())) {
                return error("上架明细中库位不能为空");
            }

            Storesite site = iStoresiteService.selectStoresiteByStoresiteno(info.getStoreSiteNo());
            if (StringUtils.isNull(site)) {
                return error("未查询到" + info.getStoreSiteNo() + "对应的库位信息");
            }
            if (!(site.getIsfrozen().equals("0"))) {
                return error("库位【" + info.getStoreSiteNo() + "】被锁定或者冻结");
            }

            if (StringUtils.isNull(info.getBatchNo()) && StringUtils.isNull(info.getSn())) {
                return error("物料" + info.getMatCode() + "的采集数据 批次、序列有采集为空的记录");
            }
            if (StringUtils.isNull(info.getBatchNo())) {
                return error("物料" + info.getMatCode() + "的采集数据 批次有采集为空的记录");
            }

            java.util.Date day = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String collect_time = sdf.format(day);

            Long I_InTaskItemid = 0L;
            Long I_InTaskId = 0L;
            if (!(StringUtils.isNull(info.getInTaskItemid()))) {
                I_InTaskItemid = Long.parseLong(info.getInTaskItemid());
            }
            if (!(StringUtils.isNull(info.getTaskid()))) {
                I_InTaskId = Long.parseLong(info.getTaskid());
            }

            String data1=info.getData1();
            String data2=info.getData2();

            Long I_STORESITEID = site.getStoresiteid();
            Long I_MATERIALID = dicIntask.get(info.getInTaskItemid()).getMaterialid();

            Incollectdata incollectdata = new Incollectdata();
            incollectdata.setDcConnectid(I_CONNECTID);
            incollectdata.setIntaskid(I_InTaskId);
            incollectdata.setIntaskitemid(I_InTaskItemid);
            incollectdata.setCollecttime(day);
            incollectdata.setInsite(I_STORESITEID);
            incollectdata.setMaterialid(I_MATERIALID);
            incollectdata.setBatchno(info.getBatchNo());
            incollectdata.setSn(info.getSn());
            incollectdata.setQty(info.getCollectQty());
            incollectdata.setIndesc(info.getDesc());
            incollectdata.setDataversion(1L);
            incollectdata.setCstate(1L);
            incollectdata.setData1(data1);//生产日期
            incollectdata.setData2(data2);//有效期
            /*incollectdata.setData1(info.get);
            incollectdata.setData2();*/
            //iIncollectdataService.insertIncollectdata(incollectdata);
            list.add(incollectdata);
        }
        if(list.size()>0){
            iIncollectdataService.insertIncollectdataBatch(list);
        }
        List<Intaskitem> inTaskItemList3 = iIntaskitemService.selectIntaskitemList3(task.getIntaskid());
        if (inTaskItemList3.size() <= 0) {
            task.setInstate(2L);
            iIntaskService.updateIntask(task);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 校验组盘托盘是否可用
     *
     * @param trayNo 托盘编码
     * @return 当前库存数量
     */
    @GetMapping("/checkTray")
    public AjaxResult CheckBindingTray(String trayNo) {
        if (StringUtils.isNull(trayNo)) {
            return error("待校验托盘单号不能为空");
        }
        Pallet pallet = iPalletService.selectPalletByPalletNo(trayNo);
        if (StringUtils.isNull(pallet)) {
            return error("托盘号【" + trayNo + "】不存在");
        }

        if (!(pallet.getPalletUseState().equals("4"))) {
            return error("托盘号【" + trayNo + "】状态非空闲或组盘");
        }
        BigDecimal decWidth = new BigDecimal(0);
        BigDecimal decHight = new BigDecimal(0);
        BigDecimal decLength = new BigDecimal(0);
        BigDecimal decPlotrtio = new BigDecimal(0);
        BigDecimal currentPlot = new BigDecimal(0);

        if (!StringUtils.isNull(pallet.getPalletWidth())) {
            decWidth = pallet.getPalletWidth();
        }
        if (!StringUtils.isNull(pallet.getPalletHight())) {
            decHight = pallet.getPalletHight();
        }
        if (!StringUtils.isNull(pallet.getPalletLength())) {
            decLength = pallet.getPalletLength();
        }
        if (!StringUtils.isNull(pallet.getPalletPlotratio())) {
            decPlotrtio = pallet.getPalletPlotratio();
        }
        if (!StringUtils.isNull(pallet.getPalletCurrentPlot())) {
            currentPlot = pallet.getPalletCurrentPlot();
        }
        if (decWidth.compareTo(BigDecimal.ZERO) == 0 || decHight.compareTo(BigDecimal.ZERO) == 0 || decLength.compareTo(BigDecimal.ZERO) == 0 || decPlotrtio.compareTo(BigDecimal.ZERO) == 0) {
            return error("托盘号【" + trayNo + "】的长、宽、高存在未维护的");
        }
        BigDecimal shengyuPlot = ((decPlotrtio.multiply(decHight.multiply(decLength.multiply(decWidth)))).subtract(currentPlot)).setScale(2, BigDecimal.ROUND_HALF_UP);
        ;

        AjaxResult ajax = AjaxResult.success(shengyuPlot);
        return ajax;
    }

    /**
     * 校验组盘托盘是否可用
     *
     * @param trayNo 托盘编码
     * @return 当前库存数量
     */
    @GetMapping("/checkBindingTray")

    public AjaxResult CheckBindingTrayByTaskId(Long taskId, String trayNo, String taskType) {
        String v_message = "";
        String v_true = "";

        if (StringUtils.isNull(trayNo)) {
            return error("待校验托盘单号不能为空");
        }
        Pallet pallet = iPalletService.selectPalletByPalletNo(trayNo);
        if (StringUtils.isNull(pallet)) {
            return error("托盘号【" + trayNo + "】不存在");
        }

        if (!(pallet.getPalletUseState().equals("4"))) {
            return error("托盘号【" + trayNo + "】状态非空闲或组盘");
        }

        Pallet pallet2 = new Pallet();
        pallet2.setI_taskId(taskId);
        pallet2.setI_palletNo(trayNo);
        pallet2.setI_tasktype(taskType);
        String ret = iPalletService.checkBindingTrayNo(pallet2);

        String o_message = pallet2.getO_message();
        String o_true = pallet2.getO_true();
        if (v_true.equals("N")) {
            return error("组盘采集：" + v_message);
        }

        AjaxResult ajax = AjaxResult.success(o_true);
        return ajax;
    }

    /// <summary>
    /// 根据物料号获取物料对应的编码控制：0单件(序列)控制，1批次控制，2无控制
    /// </summary>
    /// <param name="matCode"></param>
    /// <returns></returns>
    @GetMapping("/getMatControl")
    public AjaxResult GetMatControl(String matCode) {
        if (StringUtils.isNull(matCode)) {
            return error("物料编码参数不能为空");
        }

        String msgInfo = "";
        PmMaterial pmMaterial = iPmMaterialService.selectPmMaterialByMatcode(matCode);
        if (StringUtils.isNull(pmMaterial)) {
            return error("未查询到" + matCode + "对应的物料信息");
        }
        if (StringUtils.isNull(pmMaterial.getMatcodecontrol())) {
            return error("物料" + matCode + "的物料编码控制属性未维护");
        }

        msgInfo = pmMaterial.getMatcodecontrol().toString();//物料属性
        msgInfo += "!" + pmMaterial.getMatweisingle();//重量

        BigDecimal decWidth = new BigDecimal(0);
        BigDecimal decHight = new BigDecimal(0);
        BigDecimal decLength = new BigDecimal(0);

        if (!StringUtils.isNull(pmMaterial.getLength())) {
            decLength = pmMaterial.getLength();
        }
        if (!StringUtils.isNull(pmMaterial.getHeight())) {
            decHight = pmMaterial.getHeight();
        }
        if (!StringUtils.isNull(pmMaterial.getWidth())) {
            decWidth = pmMaterial.getWidth();
        }
        if (decWidth.compareTo(BigDecimal.ZERO) == 0 || decHight.compareTo(BigDecimal.ZERO) == 0 || decLength.compareTo(BigDecimal.ZERO) == 0) {
            return error("物料【" + matCode + "】的物料长、宽、高存在未维护的");
        }
        BigDecimal Plot = (decHight.multiply(decLength.multiply(decWidth))).setScale(2, BigDecimal.ROUND_HALF_UP);
        ;

        msgInfo += "!" + Plot.toString();
        msgInfo += "!" + pmMaterial.getPmMaterialid();
        if (StringUtils.isNull(pmMaterial.getMatsendcontrol())) {
            msgInfo += "!" + "0";
        } else {
            msgInfo += "!" + pmMaterial.getMatsendcontrol();
        }

        AjaxResult ajax = AjaxResult.success(msgInfo);
        return ajax;
    }

    /**
     * 根据提交上架托盘内容
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitUpTray")
    public AjaxResult CommitUpTray(@RequestBody UpShelvesInfoReq data) {

        Long I_CONNECTID = null;
        List<UpShelvesInfo> upShelvesInfoList = data.getUpShelvesInfos();
        List<ItemListInfo> itemListInfoList = data.getItemListInfos();

        if (upShelvesInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }
        if (itemListInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }

        String filter = data.getFilter();
        List<Incollectdata> incollectdataList = new ArrayList<Incollectdata>();
        if (StringUtils.isNull(filter)) {

            if (filter.contains("@")) {
                StringBuilder sb = new StringBuilder();
                String[] larr_ = filter.split(",");
                for (int ii = 0; ii < larr_.length; ii++) {
                    String ls_mat_sn = larr_[ii];
                    if (ls_mat_sn == null || ls_mat_sn.length() < 3) {
                        continue;
                    }
                    int li_p_split = ls_mat_sn.indexOf("@");
                    if (li_p_split > 0) {
                        String ls_matcode = ls_mat_sn.substring(1, li_p_split - 1);
                        sb.append(',').append('\'').append(ls_matcode).append('\'');
                    }

                    Incollectdata incollectdata = new Incollectdata();
                    incollectdata.setFilter(filter);
                    incollectdata.setSb(sb.toString());
                    incollectdataList = iIncollectdataService.selectIncollectdatabathCheack(incollectdata);
                }
            } else {
                Incollectdata incollectdata = new Incollectdata();
                incollectdata.setFilter(filter);
                incollectdataList = iIncollectdataService.selectIncollectdatabathCheack(incollectdata);
            }
            if (!StringUtils.isNull(incollectdataList)) {
                String ls_exist_sn = "";
                for (int iesn = 0; iesn < incollectdataList.size(); iesn++) {
                    ls_exist_sn += " " + incollectdataList.get(iesn).getSn();
                }
                return error("批号【" + ls_exist_sn + "】在库房已经存在，请确认");
            }
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        String taskNo = data.getTaskNo();
        Intask task = iIntaskService.selectIntaskByIntaskNo(taskNo);
        if (StringUtils.isNull(task)) {
            return error("未查询到任务号" + taskNo + "对应的任务信息");
        }

        String trayNo = data.getTrayNo();
        Pallet tray = iPalletService.selectPalletByPalletNo(trayNo);
        if (StringUtils.isNull(tray)) {
            return error("托盘号【" + trayNo + "】不存在");
        }

        BigDecimal currentPlot = data.getCurrentCapacity();
        tray.setPalletCurrentPlot(tray.getPalletCurrentPlot().add(currentPlot));

        BigDecimal currentWeight = data.getCurrentWeight();
        tray.setPalletCurrentWeight(tray.getPalletCurrentWeight().add(currentWeight));
        iPalletService.updatePallet(tray);



        String Checkflag = CheckBindingTrayByTaskId2(task.getIntaskid(), trayNo, "00");
        if (Checkflag.equals("N")) {
            return error("请检查托盘号【" + trayNo + "】数据！");
        }

        String S_CONNECTNO = GenerateDcConnectNo();
        java.util.Date D_CONTIME = new Date();

        DcConnect dcConnect = new DcConnect();
        dcConnect.setDcConnectno(S_CONNECTNO);
        dcConnect.setContime(D_CONTIME);
        dcConnect.setCollectortype("WIRELESS");
        dcConnect.setBusinesskind("INSOLID");
        dcConnect.setConstate(1L);
        dcConnect.setConemp(i_collecterId);
        dcConnect.setTaskid(task.getIntaskid());
        dcConnect.setTaskno(task.getIntaskno());
        dcConnect.setProofno(task.getTaskcomment());
        dcConnect.setProofid(task.getTasksource());
        dcConnect.setDataversion(1L);
        dcConnect.setPalletno(trayNo);
        Long retID = iDcConnectService.insertDcConnect(dcConnect);
        if (retID > 0) {
            I_CONNECTID = dcConnect.getDcConnectid();
        }

        Intaskitem intaskitem = new Intaskitem();
        intaskitem.setIntaskid(task.getIntaskid());
        List<Intaskitem> intaskitemList = iIntaskitemService.selectIntaskitemList2(intaskitem);
        if (StringUtils.isNull(intaskitemList) || intaskitemList.size() <= 0) {
            return error("未查询到任务号" + taskNo + "对应的任务信息");
        }

        Map<String, Intaskitem> dicIntask = new HashMap<>();

        for (int io = 0; io < itemListInfoList.size(); io++) {
            ItemListInfo itemListInfo = itemListInfoList.get(io);
            Long inTaskItemid = Long.parseLong(itemListInfo.getInTaskItemid());

            List<Intaskitem> inTaskItemList2 = intaskitemList.stream().filter(item -> inTaskItemid.equals(item.getIntaskitemid())).collect(Collectors.toList());
            if (StringUtils.isNull(inTaskItemList2)) {
                return error("未查询到凭证号" + task.getTaskcomment() + ",货物" + itemListInfo.getMtlCode() + "对应的入库明细信息");
            }
            Intaskitem inTaskItem = inTaskItemList2.get(0);

            String strInTaskItemid = inTaskItem.getIntaskitemid().toString();
            if (!dicIntask.containsKey(strInTaskItemid)) {
                dicIntask.put(strInTaskItemid, inTaskItem);
            }
            if (!(new BigDecimal(itemListInfo.getMtlQty()[0]).equals(inTaskItem.getCollectedqty()))) {
                return error("货物" + itemListInfo.getMtlCode() + "的数据已经采集，请确认");
            }
            inTaskItem.setCollectedqty(new BigDecimal(itemListInfo.getMtlQty()[1]));//MtlQty[0] 表示开始采集数据时此笔物料的数量  MtlQty[1]表示当前采集数
            iIntaskitemService.updateIntaskitem(inTaskItem);
        }
        for (int io = 0; io < upShelvesInfoList.size(); io++) {
            UpShelvesInfo info = upShelvesInfoList.get(io);

            if (StringUtils.isNull(info.getBatchNo()) && StringUtils.isNull(info.getSn())) {
                return error("物料" + info.getMatCode() + "的采集数据 批次、序列有采集为空的记录");
            }
            if (StringUtils.isNull(info.getBatchNo())) {
                return error("物料" + info.getMatCode() + "的采集数据 批次有采集为空的记录");
            }

            java.util.Date day = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String collect_time = sdf.format(day);

            Long I_InTaskItemid = 0L;
            Long I_InTaskId = 0L;
            if (!(StringUtils.isNull(info.getInTaskItemid()))) {
                I_InTaskItemid = Long.parseLong(info.getInTaskItemid());
            }
            if (!(StringUtils.isNull(info.getTaskid()))) {
                I_InTaskId = Long.parseLong(info.getTaskid());
            }

            Long I_MATERIALID = dicIntask.get(info.getInTaskItemid()).getMaterialid();

            Incollectdata incollectdata = new Incollectdata();
            incollectdata.setDcConnectid(I_CONNECTID);
            incollectdata.setIntaskitemid(I_InTaskItemid);
            incollectdata.setCollecttime(day);
            incollectdata.setMaterialid(I_MATERIALID);
            incollectdata.setBatchno(info.getBatchNo());
            incollectdata.setSn(info.getSn());
            incollectdata.setQty(info.getCollectQty());
            incollectdata.setIndesc(info.getDesc());
            incollectdata.setDataversion(1L);
            incollectdata.setCstate(1L);
            incollectdata.setPalletno(trayNo);

            Incollectdata incollectdataQty = iIncollectdataService.selectSumqtyByintaskitemid(I_InTaskItemid);
            if (!(StringUtils.isNull(incollectdataQty))) {
                BigDecimal taskQty = dicIntask.get(info.getInTaskItemid()).getQty();
                if ((incollectdataQty.getQty().add(info.getCollectQty())).compareTo(taskQty) > 0) {
                    return error("物料【" + info.getMatCode() + "】采集数大于任务数，请确认");
                }
            }
            iIncollectdataService.insertIncollectdata(incollectdata);

            PalletItem palletItem = new PalletItem();
            palletItem.setPalletid(tray.getPalletid());
            palletItem.setTaskid(task.getIntaskid());
            palletItem.setTaskno(task.getIntaskno());
            palletItem.setProofid(task.getTasksource());
            palletItem.setProofno(task.getTaskcomment());
            palletItem.setBillid(dicIntask.get(info.getInTaskItemid()).getInbillid());
            palletItem.setItemMaterialid(dicIntask.get(info.getInTaskItemid()).getMaterialid());
            palletItem.setItemBatch(info.getBatchNo());
            palletItem.setItemSn(info.getSn());
            palletItem.setItemQty(info.getCollectQty());
            palletItem.setCollecttime(day);
            palletItem.setCollector(i_collecterId);
            palletItem.setDataversion(1L);
            iPalletItemService.insertPalletItem(palletItem);
        }

        List<Intaskitem> inTaskItemList3 = iIntaskitemService.selectIntaskitemList3(task.getIntaskid());
        if (inTaskItemList3.size() <= 0) {
            task.setInstate(2L);
            iIntaskService.updateIntask(task);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    public String CheckBindingTrayByTaskId2(Long taskId, String trayNo, String taskType) {
        String v_message = "";
        String v_true = "";

        if (StringUtils.isNull(trayNo)) {
            return "false";
        }
        Pallet pallet = iPalletService.selectPalletByPalletNo(trayNo);
        if (StringUtils.isNull(pallet)) {
            return "false";
        }

        if (!(pallet.getPalletUseState().equals("4"))) {
            return "false";
        }

        Pallet pallet2 = new Pallet();
        pallet2.setI_taskId(taskId);
        pallet2.setI_palletNo(trayNo);
        pallet2.setI_tasktype(taskType);
        String ret = iPalletService.checkBindingTrayNo(pallet2);

        String o_message = pallet2.getO_message();
        String o_true = pallet2.getO_true();

        return o_true;
    }

    /// <summary>
    /// 根据提交托盘上架内容,写指令到WCS
    /// </summary>
    /// <param name="trayInfos"></param>
    /// <param name="lsItems"></param>
    /// <param name="collecterId"></param>
    /// <param name="taskNo">任务号</param>
    /// <param name="trayNo">托盘号</param>
    /// <param name="filter">序列明细</param>
    /// <param name="currentWeight">当前承重</param>
    /// <param name="currentPlot">当前容积</param>
    @GetMapping("/commitUpWmsToWcs")
    public AjaxResult CommitUpWmsToWcs(Long taskId, String taskNo, String trayNo, String startAddr, String endAddr) {
        String v_message = "";
        String v_true = "";
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long collecterId = user.getUserId();

        InterfaceWmsToWcs interfaceWmsToWcs = new InterfaceWmsToWcs();
        interfaceWmsToWcs.setI_palletTaskId(taskId);
        interfaceWmsToWcs.setI_palletNo(taskNo);
        interfaceWmsToWcs.setI_palletNo(trayNo);
        interfaceWmsToWcs.setI_operatorId(collecterId);
        interfaceWmsToWcs.setI_startADDR(startAddr);
        interfaceWmsToWcs.setI_endADDR(endAddr);

        String ret = iInterfaceWmsToWcsService.commitUpWmsToWcs(interfaceWmsToWcs);
        v_message = interfaceWmsToWcs.getO_message();
        v_true = interfaceWmsToWcs.getO_true();
        if (v_true.equals("N")) {
            return error("生成托盘上架指令失败：" + v_message);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /// 下架任务接收
    /// </summary>
    /// <param name="taskcomment"></param>
    /// <param name="userId"></param>
    /// <param name="isCanel">是否取消 true 是</param>
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitRCInTaskItem")
    public AjaxResult CommitRCInTaskItem(@RequestBody UpShelvesInfoReq req) {

        List<Long> inTaskItemIds = req.getIntaskitemids();
        String roomTag = req.getRoomTag();
        String isCanel = req.getIsCanel();

        if (inTaskItemIds.size() <= 0) {
            return error("任务项ID不能为空");
        }
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        Long inState = -1L;
        if (isCanel.equals("true")) {
            inState = 0L;
            userId = 0L;
        } else {
            inState = 1L;
        }
        for (int i = 0; i < inTaskItemIds.size(); i++) {
            Long inTaskItemId = inTaskItemIds.get(i);
            Intaskitem intaskitem = iIntaskitemService.selectIntaskitemByIntaskitemid(inTaskItemId);
            if (StringUtils.isNull(intaskitem)) {
                return error("任务查找失败");
            }
            BigDecimal collqty = intaskitem.getCollectedqty();
            if (collqty != null && collqty.compareTo(BigDecimal.ZERO) > 0) {
                return error("任务项ID：【" + intaskitem + "】已经开始采集不可以取消");
            }
            intaskitem.setCollecter(userId);
            intaskitem.setInstate(inState);
            iIntaskitemService.updateIntaskitem(intaskitem);

            Long inTaskId = intaskitem.getIntaskid();
            Intask intask = iIntaskService.selectIntaskByIntaskid(inTaskId);
            if (StringUtils.isNull(intask)) {
                return error("任务查找失败");
            }
            intask.setInstate(inState);
            intask.setCollecter(userId);
            iIntaskService.updateIntask(intask);
        }
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /// 下架任务接收
    /// </summary>
    /// <param name="taskcomment"></param>
    /// <param name="userId"></param>
    /// <param name="isCanel">是否取消 true 是</param>
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitRCInTaskItemDelivery")
    public AjaxResult CommitRCInTaskItemDelivery(@RequestBody UpShelvesInfoReq req) {

        List<Long> inTaskItemIds = req.getIntaskitemids();
        String roomTag = req.getRoomTag();
        String isCanel = req.getIsCanel();

        if (inTaskItemIds.size() <= 0) {
            return error("任务项ID不能为空");
        }
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        Long inState = -1L;
        if (isCanel.equals("true")) {
            inState = 0L;
            userId = 0L;
        } else {
            inState = 1L;
        }
        for (int i = 0; i < inTaskItemIds.size(); i++) {
            Long inTaskItemId = inTaskItemIds.get(i);
            Deliverytaskitem intaskitem = iDeliverytaskitemService.selectDeliverytaskitemByIntaskitemid(inTaskItemId);
            if (StringUtils.isNull(intaskitem)) {
                return error("任务查找失败");
            }
            BigDecimal collqty = intaskitem.getCollectedqty();
            if (collqty != null && collqty.compareTo(BigDecimal.ZERO) > 0) {
                return error("任务项ID：【" + intaskitem + "】已经开始采集不可以取消");
            }
            intaskitem.setCollecter(userId);
            intaskitem.setInstate(inState);
            iDeliverytaskitemService.updateDeliverytaskitem(intaskitem);

            Long inTaskId = intaskitem.getIntaskid();
            Deliverytask intask = iDeliverytaskService.selectDeliverytaskByIntaskid(inTaskId);
            if (StringUtils.isNull(intask)) {
                return error("任务查找失败");
            }
            intask.setInstate(inState);
            intask.setCollecter(userId);
            iDeliverytaskService.updateDeliverytask(intask);
        }
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 查询组盘任务的物料组盘信息
     *
     * @param palletNo 托盘号
     * @return 当前库存数量
     */
    @GetMapping("/getPalletItemByTaskID")
    public AjaxResult getPalletItemByTaskID(String palletNo) {
        if (StringUtils.isNull(palletNo)) {
            return error("托盘号为空！");
        }
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        PalletItem palletItem = new PalletItem();
        palletItem.setPalletNo(palletNo);
        palletItem.setCollector(userId);

        List<PalletItem> palletItemList = new ArrayList<PalletItem>();
        palletItemList = iPalletItemService.selectPalletItemByTaskID(palletItem);

        AjaxResult ajax = AjaxResult.success(palletItemList);
        return ajax;
    }

    /**
     * 查询任务指令(WCS)信息
     *
     * @param taskComment
     * @return 查询任务指令(WCS)信息
     */
    @GetMapping("/getWmsToWcsByTaskID")
    public AjaxResult getWmsToWcsByTaskID(String taskComment, Long taskId, String TaskType, String queryStr) {
        if (StringUtils.isNull(taskComment)) {
            return error("凭证号不能为空！");
        }

        if (StringUtils.isNull(taskId)) {
            return error("任务号不能为空！");
        }

        InterfaceWmsToWcs interfaceWmsToWcs = new InterfaceWmsToWcs();
        interfaceWmsToWcs.setProofno(taskComment);
        interfaceWmsToWcs.setTaskId(taskId);
        interfaceWmsToWcs.setTasktype(TaskType);
        interfaceWmsToWcs.setPalno(queryStr);
        interfaceWmsToWcs.setSid(taskId);

        List<InterfaceWmsToWcs> interfaceWmsToWcsList = new ArrayList<InterfaceWmsToWcs>();
        if (TaskType.equals("00")) {
            interfaceWmsToWcsList = iInterfaceWmsToWcsService.selectWmsToWcsByTaskID(interfaceWmsToWcs);
        } else {
            interfaceWmsToWcsList = iInterfaceWmsToWcsService.selectWmsToWcsByTaskID2(interfaceWmsToWcs);
        }
        AjaxResult ajax = AjaxResult.success(interfaceWmsToWcsList);
        return ajax;
    }


    /**
     * 获取已接收状态的下架任务信息
     */
    @GetMapping("/outList")
    public AjaxResult getOutList(Outtask outtask) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();


        outtask.setI_collecter(userId);
        outtask.setOutstate(userId);

        Long iOutstate = -1L;
        Long iUserId = 0L;
        if (outtask.getUserId().equals("ALL")) {
            iOutstate = 0L;
        } else {
            iUserId = Long.parseLong(outtask.getUserId());
            iOutstate = 1L;
        }
        outtask.setI_collecter(iUserId);
        outtask.setOutstate(iOutstate);
        outtask.setUserId(outtask.getRoleoRuserId());
        outtask.setRoomTag(outtask.getRoomTag());
        outtask.setTransferType(outtask.getTransferType());

        if (!outtask.getBeatflag().equals("Y")) {
            outtask.setBeatflag("N");
        }
        if (outtask.getPageIndex() > 0 && outtask.getPageSize() > 0) {
            PageHelper.startPage(outtask.getPageIndex(), outtask.getPageSize());
        }
        List<Outtask> outTaskList= new ArrayList<>();
        String finshFlg=outtask.getFinshFlg();

        if(StringUtils.isEmpty(finshFlg)||!finshFlg.equals("1")){
            outTaskList = iOuttaskService.selectOuttaskList2(outtask);
        }else{
            String searchKey=outtask.getSearchKey();
            if(StringUtils.isEmpty(searchKey)){
                return error("请输入查询单号");
            }
            outTaskList = iOuttaskService.selectOuttaskList3(outtask);
        }

        AjaxResult ajax = AjaxResult.success(getDataTable(outTaskList));
        return ajax;
    }

    /**
     * 获取尚未完成的已经收入库单据
     *
     * @param outtaskitem 任务查询条件
     * @return 单据明细
     */
    @GetMapping("/outTaskitemList")
    public AjaxResult getOutTaskitemList(Outtaskitem outtaskitem) {

        Long iUserId = 0L;
        Long iOutstate = -1L;

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        if (outtaskitem.getUserId().equals("ALL")) {
            iOutstate = 0L;
        } else {
            iOutstate = 1L;
            iUserId = Long.parseLong(outtaskitem.getUserId());
        }

        outtaskitem.setI_collecter(iUserId);
        outtaskitem.setOutstate(iOutstate);
        outtaskitem.setUserId(outtaskitem.getRoleoRuserId());
        outtaskitem.setRoomTag(outtaskitem.getRoomTag());
        outtaskitem.setTransferType(outtaskitem.getTransferType());

        if (!outtaskitem.getBeatflag().equals("Y")) {
            outtaskitem.setBeatflag("N");
        }

        if (outtaskitem.getPageIndex() > 0 && outtaskitem.getPageSize() > 0) {
            PageHelper.startPage(outtaskitem.getPageIndex(), outtaskitem.getPageSize());
        }

        List<Outtaskitem> outaskitemList = iOuttaskitemService.selectOuttaskitemList2(outtaskitem);
        AjaxResult ajax = AjaxResult.success(getDataTable(outaskitemList));
        return ajax;
    }

    /// 下架任务接收
    /// </summary>
    /// <param name="taskcomment"></param>
    /// <param name="userId"></param>
    /// <param name="isCanel">是否取消 true 是</param>
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitRCOutTaskItem")
    public AjaxResult CommitRCOutTaskItem(@RequestBody UpShelvesInfoReq req) {

        List<Long> outTaskItemIds = req.getOuttaskitemids();
        String isCanel = req.getIsCanel();

        if (outTaskItemIds.size() <= 0) {
            return error("任务项ID不能为空");
        }
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        Long inState = -1L;
        if (isCanel.equals("true")) {
            inState = 0L;
            userId = 0L;
        } else {
            inState = 1L;
        }

        for (int i = 0; i < outTaskItemIds.size(); i++) {
            Long outTaskItemId = outTaskItemIds.get(i);
            Outtaskitem outtaskitem = iOuttaskitemService.selectOuttaskitemByOuttaskitemid(outTaskItemId);
            if (StringUtils.isNull(outtaskitem)) {
                return error("任务查找失败");
            }
            BigDecimal collqty = outtaskitem.getCollectedqty();
            if (collqty != null && collqty.compareTo(BigDecimal.ZERO) > 0) {
                return error("任务项ID：【" + outtaskitem + "】已经开始采集不可以取消");
            }
            outtaskitem.setCollecter(userId);
            outtaskitem.setOutstate(inState);
            iOuttaskitemService.updateOuttaskitem(outtaskitem);

            Long outTaskId = outtaskitem.getOuttaskid();
            Outtask outtask = iOuttaskService.selectOuttaskByOuttaskid(outTaskId);
            if (StringUtils.isNull(outtask)) {
                return error("任务查找失败");
            }
            outtask.setOutstate(inState);
            outtask.setCollecter(userId);
            iOuttaskService.updateOuttask(outtask);
        }
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 获取尚未完成的已经收入库单据
     *
     * @param outtaskitem 任务查询条件
     * @return 单据明细
     */
    @GetMapping("/getOutTaskItem")
    public AjaxResult getOutTaskItem(Outtaskitem outtaskitem) {

        if (StringUtils.isNull(outtaskitem)) {
            return error("任务不能为空！");
        }
        List<Outtaskitem> outaskitemList= new ArrayList<>();
        String finishFlg=outtaskitem.getFinshFlg();
        if(finishFlg.equals("1")){
            outaskitemList = iOuttaskitemService.getOutTaskItemFinish(outtaskitem);
        }else {
            outaskitemList = iOuttaskitemService.getOutTaskItem(outtaskitem);
        }
        AjaxResult ajax = AjaxResult.success(outaskitemList);
        return ajax;
    }

    /// <summary>
    /// 根据物料号获取物料对应的编码控制：0单件(序列)控制，1批次控制，2无控制
    /// </summary>
    /// <param name="matCode"></param>
    /// <returns></returns>
    @GetMapping("/getRoomMatControl")
    public AjaxResult GetRoomMatControl(Long taskId) {
        if (StringUtils.isNull(taskId)) {
            return error("任务ID参数不能为空！");
        }
        String msgInfo = "";
        Outtask outtask = iOuttaskService.selectOuttaskByOuttaskid(taskId);
        if (StringUtils.isNull(outtask)) {
            return error("未查询到任务ID【" + taskId + "】对应的采集信息！");
        }

        Storeroom storeroom = iStoreroomService.selectStoreroomByStoreroomid(outtask.getStoreroomid());
        if (StringUtils.isNull(storeroom)) {
            return error("未查询到任务ID【" + taskId + "】对应的库房信息");
        }

        if (StringUtils.isNull(storeroom.getRoommatcontrol())) {
            return error("任务ID对应的库房【" + storeroom.getStoreroomname() + "】的物料采集方式控制属性未维护");
        }
        msgInfo = storeroom.getRoommatcontrol().toString();//库房物料采集方式
        msgInfo += "!" + "0";//重量

        BigDecimal decWidth = new BigDecimal(1);
        BigDecimal decHight = new BigDecimal(1);
        BigDecimal decLength = new BigDecimal(1);

        BigDecimal Plot = (decHight.multiply(decLength.multiply(decWidth))).setScale(2, BigDecimal.ROUND_HALF_UP);
        msgInfo += "!" + Plot.toString();
        msgInfo += "!" + storeroom.getStoreroomid().toString();

        if (StringUtils.isNull(storeroom.getRoommatcontrol())) {
            msgInfo += "!" + "0";
        } else {
            msgInfo += "!" + storeroom.getRoommatcontrol();
        }
        AjaxResult ajax = AjaxResult.success(msgInfo);
        return ajax;
    }

    /**
     * 取物料库位库存
     *
     * @return 当前库存数量
     */
    @GetMapping("/getRepertoryByStoresiteNo")
    public AjaxResult GetRepertoryByStoresiteNo(String storesiteno, String matcode, String erpStoreroom, String batchno, String sn) {
        Repertory repertory = new Repertory();
        /*repertory.setMatcode(matcode);
        repertory.setStoresiteno(storesiteno);*/
        /*repertory.setErpStoreroom(erpStoreroom);
        repertory.setBatchno(batchno);
        repertory.setSn(sn);*/
        System.out.println("开始处理");
        if (StringUtils.isNull(storesiteno)) {
            return error("库位编码为空！");
        }

        if (StringUtils.isNull(matcode)) {
            return error("物料编码为空！");
        }
        Storesite storesite = iStoresiteService.selectStoresiteByStoresiteno(storesiteno);
        Long storesiteid = storesite.getStoresiteid();

        PmMaterial pmMaterial = iPmMaterialService.selectPmMaterialByMatcode(matcode);
        Long matid = pmMaterial.getPmMaterialid();

        repertory.setStoresiteid(storesiteid);
        repertory.setMaterialid(matid);

        BigDecimal repertorQty = new BigDecimal(0);

        List<Repertory> repertoryList = iRepertoryService.GetRepertoryByStoresiteNo(repertory);
       /* List<Repertory> UNrepertoryList = iRepertoryService.GetUnRepertoryByStoresiteNo(repertory);
        if(UNrepertoryList.size() > 0){
            for(int i=0;i<UNrepertoryList.size();i++){
                Repertory unRow=UNrepertoryList.get(i);
                String tmpErpStoreroom=unRow.getErpStoreroom();
                String tmpbatchno=unRow.getBatchno();
                String tmpsn=unRow.getSn();

                if(StringUtils.isNull(tmpErpStoreroom)){
                    tmpErpStoreroom="0";
                }
                if(StringUtils.isNull(tmpbatchno)){
                    tmpbatchno="0";
                }
                if(StringUtils.isNull(tmpsn)){
                    tmpsn="0";
                }
                for(int j=0;i<repertoryList.size();j++){
                    Repertory Row=repertoryList.get(j);
                    String tmpErpStoreroom2=Row.getErpStoreroom();
                    String tmpbatchno2=Row.getBatchno();
                    String tmpsn2=Row.getSn();

                    if(StringUtils.isNull(tmpErpStoreroom2)){
                        tmpErpStoreroom2="0";
                    }
                    if(StringUtils.isNull(tmpbatchno2)){
                        tmpbatchno2="0";
                    }
                    if(StringUtils.isNull(tmpsn2)){
                        tmpsn2="0";
                    }

                    if(tmpErpStoreroom.equals(tmpErpStoreroom2) && tmpbatchno.equals(tmpbatchno2)&& tmpsn.equals(tmpsn2)){
                        BigDecimal aa=Row.getRepqty().subtract(unRow.getRepqty());
                        if(aa.compareTo(BigDecimal.ZERO)>0){
                            Row.setRepqty(aa);
                            repertoryList.set(j,Row);
                        }else{
                            repertoryList.remove(j);
                        }
                        break;
                    }
                }
            }
        }*/
        /*if (repertoryList.size() > 0) {
            for (int i = 0; i < repertoryList.size(); i++) {
                repertorQty = repertorQty.add(repertoryList.get(i).getRepqty());
            }
        }
        AjaxResult ajax = AjaxResult.success(repertorQty);*/

        AjaxResult ajax = AjaxResult.success(repertoryList);
        return ajax;
    }

    /**
     * 取物料库位库存
     *
     * @return 当前库存数量
     */
    @GetMapping("/getRepertoryByStoresiteNoSn")
    public AjaxResult GetRepertoryByStoresiteNoSn(String storesiteno, String matcode, String erpStoreroom, String batchno, String sn) {
        Repertory repertory = new Repertory();
        repertory.setErpStoreroom(erpStoreroom);
        repertory.setBatchno(batchno);
        repertory.setSn(sn);

        if (StringUtils.isNull(storesiteno)) {
            return error("库位编码为空！");
        }

        if (StringUtils.isNull(matcode)) {
            return error("物料编码为空！");
        }
        Storesite storesite = iStoresiteService.selectStoresiteByStoresiteno(storesiteno);
        Long storesiteid = storesite.getStoresiteid();

        PmMaterial pmMaterial = iPmMaterialService.selectPmMaterialByMatcode(matcode);
        Long matid = pmMaterial.getPmMaterialid();

        repertory.setStoresiteid(storesiteid);
        repertory.setMaterialid(matid);

        BigDecimal repertorQty = new BigDecimal(0);

        List<Repertory> repertoryList = iRepertoryService.GetRepertoryByStoresiteNoSn(repertory);
        AjaxResult ajax = AjaxResult.success(repertoryList);
        return ajax;
    }

    /**
     * 取物料库位库存
     *
     * @return 当前库存数量
     */
    @GetMapping("/getRepertoryByStoresiteNoErp")
    public AjaxResult GetRepertoryByStoresiteNoErp(String storesiteno, String matcode, String erpStoreroom, String batchno, String sn) {
        Repertory repertory = new Repertory();
        if (StringUtils.isNull(storesiteno)) {
            return error("库位编码为空！");
        }

        if (StringUtils.isNull(matcode)) {
            return error("物料编码为空！");
        }
        Storesite storesite = iStoresiteService.selectStoresiteByStoresiteno(storesiteno);
        Long storesiteid = storesite.getStoresiteid();

        PmMaterial pmMaterial = iPmMaterialService.selectPmMaterialByMatcode(matcode);
        Long matid = pmMaterial.getPmMaterialid();

        repertory.setStoresiteid(storesiteid);
        repertory.setMaterialid(matid);

        BigDecimal repertorQty = new BigDecimal(0);

        List<Repertory> repertoryList = iRepertoryService.GetRepertoryByStoresiteNoErp(repertory);
        AjaxResult ajax = AjaxResult.success(repertoryList);
        return ajax;
    }

    /**
     * 取物料库位库存
     *
     * @return 当前库存数量
     */
    @GetMapping("/getPalletSiteNo")
    public AjaxResult GetPalletSiteNo(String trayNo) {
        if (StringUtils.isNull(trayNo)) {
            return error("待校验托盘单号不能为空！");
        }

        Pallet pallet = iPalletService.selectPalletByPalletNo(trayNo);
        if (pallet == null) {
            return error("托盘号【" + trayNo + "】不存在！");
        }
        Repertory repertory = iRepertoryService.GetPalletSiteNo(trayNo);
        if (repertory == null) {
            return error("托盘号【" + trayNo + "】没有库存！");
        }

        Storesite storesite = iStoresiteService.selectStoresiteByStoresiteid(repertory.getStoresiteid());

        AjaxResult ajax = AjaxResult.success(storesite);
        return ajax;
    }

    /**
     * 平库下架提交业务
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitDownShelves")
    public AjaxResult CommitDownShelves(@RequestBody DownShelvesInfoReq data) throws Exception {

        Long I_CONNECTID = null;
        List<DownShelvesInfo> downShelvesInfoList = data.getDownShelvesInfos();
        List<ItemListInfo> itemListInfoList = data.getItemListInfos();
        if (downShelvesInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }
        if (itemListInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        String taskNo = downShelvesInfoList.get(0).getTaskNo();
        Outtask task = iOuttaskService.selectOuttaskByOuttaskno(taskNo);
        if (StringUtils.isNull(task)) {
            return error("未查询到任务号" + taskNo + "对应的出库任务信息");
        }
        String batchFlag = task.getBatchflag().toString();
        String siteFlag = task.getForcesite();

        String S_CONNECTNO = GenerateDcConnectNo();
        java.util.Date D_CONTIME = new Date();

        DcConnect dcConnect = new DcConnect();
        dcConnect.setDcConnectno(S_CONNECTNO);
        dcConnect.setContime(D_CONTIME);
        dcConnect.setCollectortype("WIRELESS");
        dcConnect.setBusinesskind("OUT");
        dcConnect.setConstate(1L);
        dcConnect.setConemp(i_collecterId);
        dcConnect.setTaskid(task.getOuttaskid());
        dcConnect.setTaskno(task.getOuttaskno());
        dcConnect.setProofno(task.getTaskcomment());
        dcConnect.setProofid(task.getTasksource());
        dcConnect.setDataversion(1L);
        Long retID = iDcConnectService.insertDcConnect(dcConnect);
        if (retID > 0) {
            I_CONNECTID = dcConnect.getDcConnectid();
        }

        Outtaskitem outtaskitem = new Outtaskitem();
        outtaskitem.setOuttaskid(task.getOuttaskid());
        List<Outtaskitem> outtaskitemList = iOuttaskitemService.selectOuttaskitemList(outtaskitem);
        if (StringUtils.isNull(outtaskitemList) || outtaskitemList.size() <= 0) {
            return error("未查询到任务号" + taskNo + "对应的任务信息");
        }

        Map<String, Outtaskitem> dicIntask = new HashMap<>();

        for (int io = 0; io < itemListInfoList.size(); io++) {
            ItemListInfo itemListInfo = itemListInfoList.get(io);
            final Long inTaskItemid = Long.parseLong(itemListInfo.getOutTaskItemid());

            List<Outtaskitem> outTaskItemList2 = outtaskitemList.stream().filter(item -> inTaskItemid.equals(item.getOuttaskitemid())).collect(Collectors.toList());
            if (StringUtils.isNull(outTaskItemList2)) {
                return error("未查询到凭证号" + task.getTaskcomment() + ",货物" + itemListInfo.getMtlCode() + "对应的出库明细信息");
            }
            Outtaskitem outTaskItem = outTaskItemList2.get(0);

            String strOutTaskItemid = outTaskItem.getOuttaskitemid().toString();
            if (!dicIntask.containsKey(strOutTaskItemid)) {
                dicIntask.put(strOutTaskItemid, outTaskItem);
            }
            if (!(new BigDecimal(itemListInfo.getMtlQty()[0]).equals(outTaskItem.getCollectedqty()))) {
                return error("货物" + itemListInfo.getMtlCode() + "的数据已经采集，请确认");
            }

            BigDecimal colqty=new BigDecimal(0);
            List<DownShelvesInfo> downShelvesInfoColl=downShelvesInfoList.stream().filter(item -> outTaskItem.getOuttaskitemid().toString().equals(item.getOutTaskItemid())).collect(Collectors.toList());
            for (int iq = 0; iq < downShelvesInfoColl.size(); iq++) {
                DownShelvesInfo infoColl = downShelvesInfoColl.get(iq);
                colqty=colqty.add(infoColl.getCollectQty());
            }

            if(colqty.compareTo(new BigDecimal(itemListInfo.getMtlQty()[1]))==0){
                //outTaskItem.setCollectedqty(new BigDecimal(itemListInfo.getMtlQty()[1]));//MtlQty[0] 表示开始采集数据时此笔物料的数量  MtlQty[1]表示当前采集数
                outTaskItem.setCollectedqty(colqty.add(outTaskItem.getCollectedqty()));
            }else{
                outTaskItem.setCollectedqty(colqty.add(outTaskItem.getCollectedqty()));
            }
            iOuttaskitemService.updateOuttaskitem(outTaskItem);
        }
        List<Outcollectdata> list = new ArrayList<Outcollectdata>();

        for (int io = 0; io < downShelvesInfoList.size(); io++) {
            DownShelvesInfo info = downShelvesInfoList.get(io);
            if (StringUtils.isNull(info.getStoreSiteNo())) {
                return error("上架明细中库位不能为空");
            }

            Storesite site = iStoresiteService.selectStoresiteByStoresiteno(info.getStoreSiteNo());
            if (StringUtils.isNull(site)) {
                return error("未查询到" + info.getStoreSiteNo() + "对应的库位信息");
            }
            if (!(site.getIsfrozen().equals("0"))) {
                return error("库位【" + info.getStoreSiteNo() + "】被锁定或者冻结");
            }

            if (StringUtils.isNull(info.getBatchNo()) && StringUtils.isNull(info.getSn())) {
                return error("物料" + info.getMatCode() + "的采集数据 批次、序列有采集为空的记录");
            }
            if (StringUtils.isNull(info.getBatchNo())) {
                return error("物料" + info.getMatCode() + "的采集数据 批次有采集为空的记录");
            }

            java.util.Date day = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String collect_time = sdf.format(day);

            Long I_InTaskItemid = 0L;
            if (!(StringUtils.isNull(info.getOutTaskItemid()))) {
                I_InTaskItemid = Long.parseLong(info.getOutTaskItemid());
            }

            Long I_STORESITEID = site.getStoresiteid();
            Long I_MATERIALID = dicIntask.get(info.getOutTaskItemid()).getMaterialid();

            Outcollectdata outcollectdata = new Outcollectdata();
            outcollectdata.setDcConnectid(I_CONNECTID);
            outcollectdata.setOuttaskitemid(I_InTaskItemid);
            outcollectdata.setCollecttime(day);
            outcollectdata.setOutsite(I_STORESITEID);
            outcollectdata.setMaterialid(I_MATERIALID);
            outcollectdata.setBatchno(info.getBatchNo());
            outcollectdata.setSn(info.getSn());
            outcollectdata.setQty(info.getCollectQty());
            outcollectdata.setOutdesc(info.getDesc());
            outcollectdata.setDataversion(1L);
            outcollectdata.setData1(info.getErpStore());
            outcollectdata.setData2(info.getData2());
            outcollectdata.setData3(info.getData3());
            outcollectdata.setCstate(0L);
            //iOutcollectdataService.insertOutcollectdata(outcollectdata);
            list.add(outcollectdata);
        }

        if(list.size()>0){
            iOutcollectdataService.insertOutcollectdataBatch(list);
        }

        Outtaskitem outtaskitem3 = new Outtaskitem();
        outtaskitem3.setOuttaskid(task.getOuttaskid());
        List<Outtaskitem> inTaskItemList3 = iOuttaskitemService.selectOuttaskitemList(outtaskitem3);
        if (inTaskItemList3.size() <= 0) {
            task.setOutstate(2L);
            iOuttaskService.updateOuttask(task);
        }
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 获取系统中所有立体库进出口位置
     *
     * @return 0:正常出库口1:拣货出库口2:组盘入库口
     */
    @GetMapping("/getInOutLocation")
    public AjaxResult GetInOutLocation(String locationType) {
        if (StringUtils.isNull(locationType)) {
            return error("参数不能为空！");
        }
        List<String> exitcodeList = new ArrayList<>();

        Sterrooutexit sterrooutexit = new Sterrooutexit();
        sterrooutexit.setType(locationType);
        sterrooutexit.setData1("Y");
        List<Sterrooutexit> sterrooutexitList = iSterrooutexitService.selectSterrooutexitList(sterrooutexit);
        for (int i = 0; i < sterrooutexitList.size(); i++) {
            String exitcode = sterrooutexitList.get(i).getExitcode();
            exitcodeList.add(exitcode);
        }
        AjaxResult ajax = AjaxResult.success(exitcodeList);
        return ajax;
    }

    /**
     * 在线拣选下架提交业务
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitASWHDownShelves")
    public AjaxResult CommitASWHDownShelves(@RequestBody DownShelvesInfoReq data) {

        Long I_CONNECTID = null;
        List<DownShelvesInfo> downShelvesInfoList = data.getDownShelvesInfos();
        List<ItemListInfo> itemListInfoList = data.getItemListInfos();
        List<InvCheckInfos> invCheckInfoList= data.getInvCheckInfos();
        if (downShelvesInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }
        if (itemListInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }
        if (invCheckInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        String taskNo = downShelvesInfoList.get(0).getTaskNo();
        Outtask task = iOuttaskService.selectOuttaskByOuttaskno(taskNo);
        if (StringUtils.isNull(task)) {
            return error("未查询到任务号" + taskNo + "对应的出库任务信息");
        }
        String batchFlag = task.getBatchflag().toString();
        String siteFlag = task.getForcesite();

        Outtaskitem outtaskitem = new Outtaskitem();
        outtaskitem.setOuttaskid(task.getOuttaskid());
        List<Outtaskitem> outtaskitemList = iOuttaskitemService.selectOuttaskitemList(outtaskitem);
        if (StringUtils.isNull(outtaskitemList) || outtaskitemList.size() <= 0) {
            return error("未查询到任务号" + taskNo + "对应的任务信息");
        }

        String invcheck = configService.selectConfigByKey("sys.terminal.invCheckFlag");
        if((!invcheck.isEmpty()) && invcheck.equals("true")){
            for (int io = 0; io < invCheckInfoList.size(); io++) {
                InvCheckInfos invCheckInfos=invCheckInfoList.get(io);
                String matCode=invCheckInfos.getMatCode();
                String storeSite=invCheckInfos.getStoreSite();
                BigDecimal collectQty=invCheckInfos.getCollectQty();
                Repertory RepertoryCon=new Repertory();
                RepertoryCon.setStoreSite(storeSite);
                RepertoryCon.setMatCode(matCode);

                BigDecimal repQty=new BigDecimal("0");
                List<Repertory> RepertoryList =iRepertoryService.selectMtlRepertoryByStoresiteNo3(RepertoryCon);
                if(RepertoryList.size()>0){
                    repQty=RepertoryList.get(0).getRepqty();
                }

                BigDecimal repQtyCol=new BigDecimal("0");
                for(int io3 = 0; io3 < downShelvesInfoList.size(); io3++){
                    DownShelvesInfo item_col=downShelvesInfoList.get(io3);
                    if(item_col.getMatCode().equals(invCheckInfos.getMatCode())){
                        repQtyCol=repQtyCol.add(downShelvesInfoList.get(io3).getCollectQty());
                    }
                }
                if(!(collectQty.equals(repQty.subtract(repQtyCol)))){
                    return error("物料【" + matCode + "】采集的结余库存【"+collectQty+"】与系统计算结余库存【"+repQty.subtract(repQtyCol)+"】不相符，请检查后重新上传！");
                }
            }
        }

        Map<String, Outtaskitem> dicIntask = new HashMap<>();

        for (int io = 0; io < itemListInfoList.size(); io++) {
            ItemListInfo itemListInfo = itemListInfoList.get(io);
            final Long inTaskItemid = Long.parseLong(itemListInfo.getOutTaskItemid());

            List<Outtaskitem> outTaskItemList2 = outtaskitemList.stream().filter(item -> inTaskItemid.equals(item.getOuttaskitemid())).collect(Collectors.toList());
            if (StringUtils.isNull(outTaskItemList2)) {
                return error("未查询到凭证号" + task.getTaskcomment() + ",货物" + itemListInfo.getMtlCode() + "对应的出库明细信息");
            }
            Outtaskitem outTaskItem = outTaskItemList2.get(0);

            String strOutTaskItemid = outTaskItem.getOuttaskitemid().toString();
            if (!dicIntask.containsKey(strOutTaskItemid)) {
                dicIntask.put(strOutTaskItemid, outTaskItem);
            }
            if (!(new BigDecimal(itemListInfo.getMtlQty()[0]).equals(outTaskItem.getCollectedqty()))) {
                return error("货物" + itemListInfo.getMtlCode() + "的数据已经采集，请确认");
            }

            outTaskItem.setCollectedqty(new BigDecimal(itemListInfo.getMtlQty()[1]));//MtlQty[0] 表示开始采集数据时此笔物料的数量  MtlQty[1]表示当前采集数
            iOuttaskitemService.updateOuttaskitem(outTaskItem);
        }

        Map<String, String> dicTrayList = new HashMap<>();

        for (int io = 0; io < downShelvesInfoList.size(); io++) {
            if (!dicTrayList.containsKey(downShelvesInfoList.get(io).getTrayNo())) {
                dicTrayList.put(downShelvesInfoList.get(io).getTrayNo(), downShelvesInfoList.get(io).getTrayNo());
            }
        }

        for (String dicTrayNo : dicTrayList.keySet()) {

            String S_CONNECTNO = GenerateDcConnectNo();
            java.util.Date D_CONTIME = new Date();

            DcConnect dcConnect = new DcConnect();
            dcConnect.setDcConnectno(S_CONNECTNO);
            dcConnect.setContime(D_CONTIME);
            dcConnect.setCollectortype("WIRELESS");
            dcConnect.setBusinesskind("OUTSOLID");
            dcConnect.setConstate(1L);
            dcConnect.setPalletno(dicTrayList.get(dicTrayNo));
            dcConnect.setConemp(i_collecterId);
            dcConnect.setTaskid(task.getOuttaskid());
            dcConnect.setTaskno(task.getOuttaskno());
            dcConnect.setProofno(task.getTaskcomment());
            dcConnect.setProofid(task.getTasksource());
            dcConnect.setDataversion(1L);
            Long retID = iDcConnectService.insertDcConnect(dcConnect);
            if (retID > 0) {
                I_CONNECTID = dcConnect.getDcConnectid();
            }

            List<DownShelvesInfo> downShelvesInfoList2 = downShelvesInfoList.stream().filter(item -> dicTrayList.get(dicTrayNo).equals(item.getTrayNo())).collect(Collectors.toList());

            for (int io = 0; io < downShelvesInfoList2.size(); io++) {
                DownShelvesInfo info = downShelvesInfoList2.get(io);
                if (StringUtils.isNull(info.getStoreSiteNo())) {
                    return error("上架明细中库位不能为空");
                }

                Storesite site = iStoresiteService.selectStoresiteByStoresiteno(info.getStoreSiteNo());
                if (StringUtils.isNull(site)) {
                    return error("未查询到" + info.getStoreSiteNo() + "对应的库位信息");
                }
                if (!(site.getIsfrozen().equals("0"))) {
                    return error("库位【" + info.getStoreSiteNo() + "】被锁定或者冻结");
                }

                if (StringUtils.isNull(info.getBatchNo()) && StringUtils.isNull(info.getSn())) {
                    return error("物料" + info.getMatCode() + "的采集数据 批次、序列有采集为空的记录");
                }
                if (StringUtils.isNull(info.getBatchNo())) {
                    return error("物料" + info.getMatCode() + "的采集数据 批次有采集为空的记录");
                }

                java.util.Date day = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String collect_time = sdf.format(day);

                Long I_InTaskItemid = 0L;
                if (!(StringUtils.isNull(info.getOutTaskItemid()))) {
                    I_InTaskItemid = Long.parseLong(info.getOutTaskItemid());
                }

                Long I_STORESITEID = site.getStoresiteid();
                Long I_MATERIALID = dicIntask.get(info.getOutTaskItemid()).getMaterialid();

                Outcollectdata outcollectdata = new Outcollectdata();
                outcollectdata.setDcConnectid(I_CONNECTID);
                outcollectdata.setOuttaskitemid(I_InTaskItemid);
                outcollectdata.setCollecttime(day);
                outcollectdata.setOutsite(I_STORESITEID);
                outcollectdata.setMaterialid(I_MATERIALID);
                outcollectdata.setBatchno(info.getBatchNo());
                outcollectdata.setSn(info.getSn());
                outcollectdata.setQty(info.getCollectQty());
                outcollectdata.setOutdesc(info.getDesc());
                outcollectdata.setDataversion(1L);
                outcollectdata.setPalletno(info.getTrayNo());
                outcollectdata.setData1(info.getErpStore());
                outcollectdata.setData2(info.getData2());
                outcollectdata.setData3(info.getData3());
                outcollectdata.setCstate(0L);

                iOutcollectdataService.insertOutcollectdata(outcollectdata);
            }
        }

        Outtaskitem outtaskitem3 = new Outtaskitem();
        outtaskitem3.setOuttaskid(task.getOuttaskid());
        List<Outtaskitem> inTaskItemList3 = iOuttaskitemService.selectOuttaskitemList(outtaskitem3);
        if (inTaskItemList3.size() <= 0) {
            task.setOutstate(2L);
            iOuttaskService.updateOuttask(task);
        }
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 组盘调拨采集提交
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitTrayDownShelves")
    public AjaxResult CommitTrayDownShelves(@RequestBody DownShelvesInfoReq data) {

        Long I_CONNECTID = null;
        List<DownShelvesInfo> downShelvesInfoList = data.getDownShelvesInfos();
        List<ItemListInfo> itemListInfoList = data.getItemListInfos();
        if (downShelvesInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }
        if (itemListInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        String taskNo = downShelvesInfoList.get(0).getTaskNo();
        Outtask task = iOuttaskService.selectOuttaskByOuttaskno(taskNo);
        if (StringUtils.isNull(task)) {
            return error("未查询到任务号" + taskNo + "对应的出库任务信息");
        }
        String batchFlag = task.getBatchflag().toString();
        String siteFlag = task.getForcesite();

        Outtaskitem outtaskitem = new Outtaskitem();
        outtaskitem.setOuttaskid(task.getOuttaskid());
        List<Outtaskitem> outtaskitemList = iOuttaskitemService.selectOuttaskitemList(outtaskitem);
        if (StringUtils.isNull(outtaskitemList) || outtaskitemList.size() <= 0) {
            return error("未查询到任务号" + taskNo + "对应的任务信息");
        }
        Map<String, Outtaskitem> dicIntask = new HashMap<>();

        for (int io = 0; io < itemListInfoList.size(); io++) {
            ItemListInfo itemListInfo = itemListInfoList.get(io);
            Long inTaskItemid = Long.parseLong(itemListInfo.getOutTaskItemid());

            List<Outtaskitem> outTaskItemList2 = outtaskitemList.stream().filter(item -> inTaskItemid.equals(item.getOuttaskitemid())).collect(Collectors.toList());
            if (StringUtils.isNull(outTaskItemList2)) {
                return error("未查询到凭证号" + task.getTaskcomment() + ",货物" + itemListInfo.getMtlCode() + "对应的出库明细信息");
            }
            Outtaskitem outTaskItem = outTaskItemList2.get(0);

            String strOutTaskItemid = outTaskItem.getOuttaskitemid().toString();
            if (!dicIntask.containsKey(strOutTaskItemid)) {
                dicIntask.put(strOutTaskItemid, outTaskItem);
            }
            if (!(new BigDecimal(itemListInfo.getMtlQty()[0]).equals(outTaskItem.getCollectedqty()))) {
                return error("货物" + itemListInfo.getMtlCode() + "的数据已经采集，请确认");
            }

            outTaskItem.setCollectedqty(new BigDecimal(itemListInfo.getMtlQty()[1]));//MtlQty[0] 表示开始采集数据时此笔物料的数量  MtlQty[1]表示当前采集数
            iOuttaskitemService.updateOuttaskitem(outTaskItem);
        }

        Map<String, String> dicTrayList = new HashMap<>();

        for (int io = 0; io < downShelvesInfoList.size(); io++) {
            if (!dicTrayList.containsKey(downShelvesInfoList.get(io).getTrayNo())) {
                dicTrayList.put(downShelvesInfoList.get(io).getTrayNo(), downShelvesInfoList.get(io).getTrayNo());
            }
        }

        for (String dicTrayNo : dicTrayList.keySet()) {

            String Checkflag = CheckBindingTrayByTaskId2(task.getOuttaskid(), dicTrayNo, "01");
            if (Checkflag.equals("N")) {
                return error("请检查托盘号【" + dicTrayNo + "】数据！");
            }

            String S_CONNECTNO = GenerateDcConnectNo();
            java.util.Date D_CONTIME = new Date();

            DcConnect dcConnect = new DcConnect();
            dcConnect.setDcConnectno(S_CONNECTNO);
            dcConnect.setContime(D_CONTIME);
            dcConnect.setCollectortype("WIRELESS");
            dcConnect.setBusinesskind("OUT");
            dcConnect.setConstate(1L);
            dcConnect.setPalletno(dicTrayList.get(dicTrayNo));
            dcConnect.setConemp(i_collecterId);
            dcConnect.setTaskid(task.getOuttaskid());
            dcConnect.setTaskno(task.getOuttaskno());
            dcConnect.setProofno(task.getTaskcomment());
            dcConnect.setProofid(task.getTasksource());
            dcConnect.setDataversion(1L);
            Long retID = iDcConnectService.insertDcConnect(dcConnect);
            if (retID > 0) {
                I_CONNECTID = dcConnect.getDcConnectid();
            }

            List<DownShelvesInfo> downShelvesInfoList2 = downShelvesInfoList.stream().filter(item -> dicTrayNo.equals(item.getTrayNo())).collect(Collectors.toList());

            for (int io = 0; io < downShelvesInfoList2.size(); io++) {
                DownShelvesInfo info = downShelvesInfoList2.get(io);
                if (StringUtils.isNull(info.getStoreSiteNo())) {
                    return error("上架明细中库位不能为空");
                }

                Storesite site = iStoresiteService.selectStoresiteByStoresiteno(info.getStoreSiteNo());
                if (StringUtils.isNull(site)) {
                    return error("未查询到" + info.getStoreSiteNo() + "对应的库位信息");
                }
                if (!(site.getIsfrozen().equals("0"))) {
                    return error("库位【" + info.getStoreSiteNo() + "】被锁定或者冻结");
                }

                if (StringUtils.isNull(info.getBatchNo()) && StringUtils.isNull(info.getSn())) {
                    return error("物料" + info.getMatCode() + "的采集数据 批次、序列有采集为空的记录");
                }
                if (StringUtils.isNull(info.getBatchNo())) {
                    return error("物料" + info.getMatCode() + "的采集数据 批次有采集为空的记录");
                }

                java.util.Date day = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String collect_time = sdf.format(day);

                Long I_InTaskItemid = 0L;
                if (!(StringUtils.isNull(info.getOutTaskItemid()))) {
                    I_InTaskItemid = Long.parseLong(info.getOutTaskItemid());
                }

                Long I_STORESITEID = site.getStoresiteid();
                Long I_MATERIALID = dicIntask.get(info.getOutTaskItemid()).getMaterialid();

                Outcollectdata outcollectdata = new Outcollectdata();
                outcollectdata.setDcConnectid(I_CONNECTID);
                outcollectdata.setOuttaskitemid(I_InTaskItemid);
                outcollectdata.setCollecttime(day);
                outcollectdata.setOutsite(I_STORESITEID);
                outcollectdata.setMaterialid(I_MATERIALID);
                outcollectdata.setBatchno(info.getBatchNo());
                outcollectdata.setSn(info.getSn());
                outcollectdata.setQty(info.getCollectQty());
                outcollectdata.setOutdesc(info.getDesc());
                outcollectdata.setDataversion(1L);
                outcollectdata.setPalletno(info.getTrayNo());
                outcollectdata.setData1(info.getErpStore());
                outcollectdata.setData2(info.getData2());
                outcollectdata.setData3(info.getData3());
                outcollectdata.setCstate(0L);
                outcollectdata.setPalletno(info.getTrayNo());

                iOutcollectdataService.insertOutcollectdata(outcollectdata);
            }
        }

        Outtaskitem outtaskitem3 = new Outtaskitem();
        outtaskitem3.setOuttaskid(task.getOuttaskid());
        List<Outtaskitem> inTaskItemList3 = iOuttaskitemService.selectOuttaskitemList(outtaskitem3);
        if (inTaskItemList3.size() <= 0) {
            task.setOutstate(2L);
            iOuttaskService.updateOuttask(task);
        }
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }
    /// <summary>
    /// 根据提交托盘上架内容,写指令到WCS
    /// </summary>
    /// <param name="trayInfos"></param>
    /// <param name="lsItems"></param>
    /// <param name="collecterId"></param>
    /// <param name="taskNo">任务号</param>
    /// <param name="trayNo">托盘号</param>
    /// <param name="filter">序列明细</param>
    /// <param name="currentWeight">当前承重</param>
    /// <param name="currentPlot">当前容积</param>
    @GetMapping("/commitDownWmsToWcs")
    public AjaxResult CommitDownWmsToWcs(Long taskId, String taskNo, String trayNo, String startAddr, String endAddr, String singleFlag) {
        String v_message = "";
        String v_true = "";
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long collecterId = user.getUserId();

        InterfaceWmsToWcs interfaceWmsToWcs = new InterfaceWmsToWcs();
        interfaceWmsToWcs.setI_palletTaskId(taskId);
        interfaceWmsToWcs.setI_pallettaskNo(taskNo);
        interfaceWmsToWcs.setI_palletNo(trayNo);
        interfaceWmsToWcs.setI_operatorId(collecterId);
        interfaceWmsToWcs.setI_startADDR(startAddr);
        interfaceWmsToWcs.setI_endADDR(endAddr);

        String ret = iInterfaceWmsToWcsService.commitDownWmsToWcs(interfaceWmsToWcs);
        v_message = interfaceWmsToWcs.getO_message();
        v_true = interfaceWmsToWcs.getO_true();
        if (v_true.equals("N") && singleFlag.equals("1")) {
            return error("获取来料盘发送指令失败！：" + v_message);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /// <summary>
    /// 根据提交托盘上架内容,写指令到WCS
    /// </summary>
    /// <param name="trayInfos"></param>
    /// <param name="lsItems"></param>
    /// <param name="collecterId"></param>
    /// <param name="taskNo">任务号</param>
    /// <param name="trayNo">托盘号</param>
    /// <param name="filter">序列明细</param>
    /// <param name="currentWeight">当前承重</param>
    /// <param name="currentPlot">当前容积</param>
    @GetMapping("/commitInvDownWmsToWcs")
    public AjaxResult CommitInvDownWmsToWcs(Long taskId, String taskNo, String trayNo, String startAddr, String endAddr, String singleFlag) {
        String v_message = "";
        String v_true = "";
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long collecterId = user.getUserId();

        InterfaceWmsToWcs interfaceWmsToWcs = new InterfaceWmsToWcs();
        interfaceWmsToWcs.setI_palletTaskId(taskId);
        interfaceWmsToWcs.setI_pallettaskNo(taskNo);
        interfaceWmsToWcs.setI_palletNo(trayNo);
        interfaceWmsToWcs.setI_operatorId(collecterId);
        interfaceWmsToWcs.setI_startADDR(startAddr);
        interfaceWmsToWcs.setI_endADDR(endAddr);

        String ret = iInterfaceWmsToWcsService.commitInvDownWmsToWcs(interfaceWmsToWcs);
        v_message = interfaceWmsToWcs.getO_message();
        v_true = interfaceWmsToWcs.getO_true();
        if (v_true.equals("N") && singleFlag.equals("1")) {
            return error("获取来料盘发送指令失败！：" + v_message);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }


    /// <summary>
    /// 根据提交托盘上架内容,写指令到WCS
    /// </summary>
    /// <param name="trayInfos"></param>
    /// <param name="lsItems"></param>
    /// <param name="collecterId"></param>
    /// <param name="taskNo">任务号</param>
    /// <param name="trayNo">托盘号</param>
    /// <param name="filter">序列明细</param>
    /// <param name="currentWeight">当前承重</param>
    /// <param name="currentPlot">当前容积</param>
    @GetMapping("/commitEmptyTrayWmsToWcs")
    public AjaxResult CommitEmptyTrayWmsToWcs(Long taskId, String taskNo, String trayNo, String startAddr, String endAddr, String singleFlag) {
        String v_message = "";
        String v_true = "";
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long collecterId = user.getUserId();

        InterfaceWmsToWcs interfaceWmsToWcs = new InterfaceWmsToWcs();
        interfaceWmsToWcs.setI_palletTaskId(taskId);
        interfaceWmsToWcs.setI_palletNo(taskNo);
        interfaceWmsToWcs.setI_palletNo(trayNo);
        interfaceWmsToWcs.setI_operatorId(collecterId);
        interfaceWmsToWcs.setI_startADDR(startAddr);
        interfaceWmsToWcs.setI_endADDR(endAddr);

        String ret = iInterfaceWmsToWcsService.commitEmptyTrayWmsToWcs(interfaceWmsToWcs);
        v_message = interfaceWmsToWcs.getO_message();
        v_true = interfaceWmsToWcs.getO_true();
        if (v_true.equals("N") && singleFlag.equals("1")) {
            return error("空托盘入库发送指令失败！：" + v_message);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 根据物料取物料推荐发料数和最小包装数
     *
     * @return 物料代码 库位代码
     */
    @GetMapping("/getMtlQtyByMtlCode")
    public AjaxResult GetMtlQtyByMtlCode(String mtlCode, String siteNo) {
        if (StringUtils.isNull(mtlCode)) {
            return error("参数不能为空！");
        }
        if (StringUtils.isNull(siteNo)) {
            return error("参数不能为空！");
        }

        MaterialQty materialQty = new MaterialQty();
        materialQty.setSiteno(siteNo);
        materialQty.setMatcode(mtlCode);

        List<MaterialQty> materialQtyList = iMaterialQtyService.selectMaterialQtyList(materialQty);
        AjaxResult ajax = AjaxResult.success(materialQtyList);
        return ajax;
    }

    /**
     * 在线拣选下架提交业务
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitMtlSender")
    public AjaxResult CommitMtlSender(@RequestBody UpShelvesInfoReq data) {

        Long I_BILLID = null;
        List<MtlSenderInfo> mtlSenderInfos = data.getMtlSenderInfos();
        if (mtlSenderInfos.size() <= 0) {
            return error("提交拉式对象不能为空");
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        String S_BILLNO = GenerateOutBillNo();
        java.util.Date D_CONTIME = new Date();

        DrawmaterialRfBill drawmaterialRfBill = new DrawmaterialRfBill();
        drawmaterialRfBill.setDrawmaterialRfBillno(S_BILLNO);
        drawmaterialRfBill.setDrawmaterialRfBillstate("0");
        drawmaterialRfBill.setDrawmaterialRfBillSender(i_collecterId);
        drawmaterialRfBill.setCreatetime(D_CONTIME);
        drawmaterialRfBill.setDataversion(1L);
        Long retID = iDrawmaterialRfBillService.insertDrawmaterialRfBill(drawmaterialRfBill);
        if (retID > 0) {
            I_BILLID = drawmaterialRfBill.getDrawmaterialRfBillid();
        }
        for (int io = 0; io < mtlSenderInfos.size(); io++) {
            MtlSenderInfo info = mtlSenderInfos.get(io);
            DrawmaterialRfBillItem drawmaterialRfBillItem = new DrawmaterialRfBillItem();
            drawmaterialRfBillItem.setDrawmaterialRfBillid(I_BILLID);
            drawmaterialRfBillItem.setGoodsshelf(info.getLocationNo());
            drawmaterialRfBillItem.setMatcode(info.getMatCode());
            drawmaterialRfBillItem.setPlanqty(info.getQty());
            drawmaterialRfBillItem.setFinishqty(new BigDecimal(0));
            drawmaterialRfBillItem.setDataversion(1L);
            drawmaterialRfBillItem.setData1("0");
            iDrawmaterialRfBillItemService.insertDrawmaterialRfBillItem(drawmaterialRfBillItem);
        }
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 根据扫描货位号/物料号/托盘号等查询库存信息
     *
     * @return 当前库存数据
     */
    @GetMapping("/getRepertoryByBarCode")
    public AjaxResult GetRepertoryByBarCode(String barcode, String currStep,int PageIndex, int PageSize) {

        if (StringUtils.isNull(barcode)) {
            return error("参数不能为空！");
        }
        if (StringUtils.isNull(currStep)) {
            return error("参数不能为空！");
        }

        Repertory repertory = new Repertory();
        if (currStep.equals("M")) {
            repertory.setMatCode(barcode);
        } else if (currStep.equals("P")) {
            repertory.setPalletno(barcode);
        } else if (currStep.equals("S")) {
            repertory.setStoresiteno(barcode);
        } else {
            return error("参数错误！");
        }
        if (PageIndex > 0 && PageSize > 0) {
            PageHelper.startPage(PageIndex, PageSize);
        }
        List<Repertory> repertoryList = iRepertoryService.GetRepertoryByBarCode(repertory);

        AjaxResult ajax = AjaxResult.success(getDataTable(repertoryList));
        return ajax;
    }

    /**
     * 获取盘库任务
     *
     * @param checktask 任务查询条件
     * @return 单据明细
     */
    @GetMapping("/getInventoryTask")
    public AjaxResult getInventoryTask(Checktask checktask) {

        Long iUserId = 0L;
        Long iInvState = -1L;

        if (checktask.getUserId().equals("ALL")) {
            iInvState = 0L;
        } else {
            iInvState = 1L;
            iUserId = Long.parseLong(checktask.getUserId());
        }
        Checktask checktask2 = new Checktask();

        checktask2.setRoomTag(checktask.getRoomTag());
        checktask2.setiUserId(iUserId);
        checktask2.setRoleoRuserId(checktask.getRoleoRuserId());
        if (checktask.getPageIndex() > 0 && checktask.getPageSize() > 0) {
            PageHelper.startPage(checktask.getPageIndex(), checktask.getPageSize());
        }
        List<Checktask> checktaskList = iChecktaskService.getInventoryTask(checktask2);
        AjaxResult ajax = AjaxResult.success(getDataTable(checktaskList));
        return ajax;
    }

    /// 盘点任务接收撤销
    /// </summary>
    /// <param name="taskcomment"></param>
    /// <param name="userId"></param>
    /// <param name="isCanel">是否取消 true 是</param>
    @GetMapping("/commitInventoryTask")
    public AjaxResult CommitInventoryTask(String taskcomment, Long userId, String isCanel) {

        if (StringUtils.isNull(taskcomment)) {
            return error("任务号不能为空");
        }
        if (StringUtils.isNull(userId)) {
            return error("用户代码不能为空");
        }

        Long inState = -1L;
        if (isCanel.equals("true")) {
            inState = 0L;
            userId = 0L;
        } else {
            inState = 1L;
        }
        List<Checktask> checktaskList = iChecktaskService.getInventoryTaskCol(taskcomment);
        if (checktaskList != null && checktaskList.size() >= 1) {
            return error("任务号：【" + taskcomment + "】已经开始盘点不可以取消");
        }
        Checktask checktask = new Checktask();
        checktask.setChecktaskno(taskcomment);
        List<Checktask> checktaskList2 = iChecktaskService.selectChecktaskList(checktask);
        if (checktaskList2.size() <= 0) {
            return error("任务号：【" + taskcomment + "】不存在");
        }
        Checktask checktask2 = checktaskList2.get(0);
        checktask2.setCollecter(userId);
        checktask2.setCheckstate(inState);
        iChecktaskService.updateChecktask(checktask2);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /// 盘点任务明细
    /// </summary>
    /// <param name="taskcomment"></param>
    /// <param name="userId"></param>
    /// <param name="isCanel">是否取消 true 是</param>
    @GetMapping("/getInventoryTaskItem")
    public AjaxResult GetInventoryTaskItem(Checktask checktask) {

        String taskComment = checktask.getTaskcomment();
        String taskNo = checktask.getChecktaskno();
        String roomTag = checktask.getRoomTag();

        if (StringUtils.isNull(taskComment)) {
            return error("任务号不能为空");
        }
        if (StringUtils.isNull(taskNo)) {
            return error("任务号不能为空");
        }

        Checktask checktask2 = new Checktask();
        checktask2.setTaskcomment(taskComment);
        checktask2.setChecktaskno(taskNo);
        checktask2.setRoomTag(roomTag);
        List<Checktask> checktaskList = iChecktaskService.getInventoryTaskItem(checktask2);
        AjaxResult ajax = AjaxResult.success(checktaskList);
        return ajax;
    }

    /**
     * 在线拣选下架提交业务
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitInventoryInfos")
    public AjaxResult CommitInventoryInfos(@RequestBody DownShelvesInfoReq data) {

        Long I_CONNECTID = null;
        List<InventoryInfo> inventoryInfos = data.getInventoryInfos();
        if (inventoryInfos.size() <= 0) {
            return error("上架提交对象不能为空");
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        String taskComment = data.getTaskComment();
        if (StringUtils.isNull(taskComment)) {
            return error("盘库单号不能为空");
        }

        Checktask checktask = new Checktask();
        checktask.setTaskcomment(taskComment);
        List<Checktask> checktaskList = iChecktaskService.selectChecktaskList(checktask);
        if (checktaskList.size() <= 0) {
            return error("未查询到凭证号【" + taskComment + "】对应的盘库任务信息");
        }
        checktask = checktaskList.get(0);
        checktask.setCheckstate(2L);
        iChecktaskService.updateChecktask(checktask);

        String S_CONNECTNO = GenerateDcConnectNo();
        java.util.Date D_CONTIME = new Date();

        DcConnect dcConnect = new DcConnect();
        dcConnect.setDcConnectno(S_CONNECTNO);
        dcConnect.setContime(D_CONTIME);
        dcConnect.setCollectortype("WIRELESS");
        dcConnect.setBusinesskind("CHECK");
        dcConnect.setConstate(1L);
        dcConnect.setConemp(i_collecterId);
        dcConnect.setTaskid(checktask.getChecktaskid());
        dcConnect.setTaskno(checktask.getChecktaskno());
        dcConnect.setProofno(checktask.getTaskcomment());
        dcConnect.setProofid(checktask.getTasksource());
        dcConnect.setPalletno(inventoryInfos.get(0).getTrayNo());
        dcConnect.setDataversion(1L);
        Long retID = iDcConnectService.insertDcConnect(dcConnect);
        if (retID > 0) {
            I_CONNECTID = dcConnect.getDcConnectid();
        }

        java.util.Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String collect_time = sdf.format(day);


        for (int io = 0; io < inventoryInfos.size(); io++) {
            InventoryInfo itemListInfo = inventoryInfos.get(io);
            Storesite storesite = new Storesite();
            storesite.setStoresiteno(itemListInfo.getStoreSiteNo());
            List<Storesite> storesiteList = iStoresiteService.selectStoresiteList(storesite);
            if (storesiteList.size() > 0) {
                storesite = storesiteList.get(0);
            }
            Checkcollectdata checkcollectdata = new Checkcollectdata();
            checkcollectdata.setDcConnectid(I_CONNECTID);
            checkcollectdata.setChcektaskitemid(Long.parseLong(itemListInfo.getInvTaskItemid()));
            checkcollectdata.setCollecttime(day);
            checkcollectdata.setChecksite(storesite.getStoresiteid());
            checkcollectdata.setMaterialid(Long.parseLong(itemListInfo.getMaterialId()));
            checkcollectdata.setBatchno(itemListInfo.getBatchNo());
            checkcollectdata.setSn(itemListInfo.getSn());
            checkcollectdata.setQty(itemListInfo.getCollectQty());
            checkcollectdata.setDataversion(1L);
            checkcollectdata.setPalletno(itemListInfo.getTrayNo());
            iCheckcollectdataService.insertCheckcollectdata(checkcollectdata);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /// <summary>
    /// 回库指令
    /// </summary>
    /// <param name="trayInfos"></param>
    /// <param name="lsItems"></param>
    /// <param name="collecterId"></param>
    /// <param name="taskNo">任务号</param>
    /// <param name="trayNo">托盘号</param>
    /// <param name="filter">序列明细</param>
    /// <param name="currentWeight">当前承重</param>
    /// <param name="currentPlot">当前容积</param>
    @GetMapping("/commitResetWmsToWcs")
    public AjaxResult CommitResetWmsToWcs(Long taskId, String taskNo, String trayNo, String startAddr, String endAddr) {
        String v_message = "";
        String v_true = "";
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long collecterId = user.getUserId();

        InterfaceWmsToWcs interfaceWmsToWcs = new InterfaceWmsToWcs();
        interfaceWmsToWcs.setI_palletTaskId(taskId);
        interfaceWmsToWcs.setI_pallettaskNo(taskNo);
        interfaceWmsToWcs.setI_palletNo(trayNo);
        interfaceWmsToWcs.setI_operatorId(collecterId);
        interfaceWmsToWcs.setI_startADDR(startAddr);
        interfaceWmsToWcs.setI_endADDR(endAddr);

        String ret = iInterfaceWmsToWcsService.commitResetWmsToWcs(interfaceWmsToWcs);
        v_message = interfaceWmsToWcs.getO_message();
        v_true = interfaceWmsToWcs.getO_true();
        if (v_true.equals("N")) {
            return error("托盘回库指令发送指令失败！：" + v_message);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /// <summary>
    /// 回库指令
    /// </summary>
    /// <param name="trayInfos"></param>
    /// <param name="lsItems"></param>
    /// <param name="collecterId"></param>
    /// <param name="taskNo">任务号</param>
    /// <param name="trayNo">托盘号</param>
    /// <param name="filter">序列明细</param>
    /// <param name="currentWeight">当前承重</param>
    /// <param name="currentPlot">当前容积</param>
    @GetMapping("/commitInvResetWmsToWcs")
    public AjaxResult CommitInvResetWmsToWcs(Long taskId, String taskNo, String trayNo, String startAddr, String endAddr) {
        String v_message = "";
        String v_true = "";
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long collecterId = user.getUserId();

        InterfaceWmsToWcs interfaceWmsToWcs = new InterfaceWmsToWcs();
        interfaceWmsToWcs.setI_palletTaskId(taskId);
        interfaceWmsToWcs.setI_pallettaskNo(taskNo);
        interfaceWmsToWcs.setI_palletNo(trayNo);
        interfaceWmsToWcs.setI_operatorId(collecterId);
        interfaceWmsToWcs.setI_startADDR(startAddr);
        interfaceWmsToWcs.setI_endADDR(endAddr);

        String ret = iInterfaceWmsToWcsService.commitInvResetWmsToWcs(interfaceWmsToWcs);
        v_message = interfaceWmsToWcs.getO_message();
        v_true = interfaceWmsToWcs.getO_true();
        if (v_true.equals("N")) {
            return error("托盘回库指令发送指令失败！：" + v_message);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }
    /**
     * 在线拣选下架提交业务
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitExceptShelves")
    public AjaxResult CommitExceptShelves(@RequestBody DownShelvesInfoReq data) {

        Long I_CONNECTID = null;
        List<ExceptShelvesInfo> exceptShelvesInfos = data.getExceptShelvesInfos();
        if (exceptShelvesInfos.size() <= 0) {
            return error("上架提交对象不能为空");
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        String taskNo = exceptShelvesInfos.get(0).getTaskNo();

        String S_CONNECTNO = GenerateDcConnectNo();
        java.util.Date D_CONTIME = new Date();

        DcConnect dcConnect = new DcConnect();
        dcConnect.setDcConnectno(S_CONNECTNO);
        dcConnect.setContime(D_CONTIME);
        dcConnect.setCollectortype("WIRELESS");
        dcConnect.setBusinesskind("EXP");
        dcConnect.setConstate(0L);
        dcConnect.setConemp(i_collecterId);
        dcConnect.setDataversion(1L);
        Long retID = iDcConnectService.insertDcConnect(dcConnect);
        if (retID > 0) {
            I_CONNECTID = dcConnect.getDcConnectid();
        }

        java.util.Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String collect_time = sdf.format(day);


        for (int io = 0; io < exceptShelvesInfos.size(); io++) {
            ExceptShelvesInfo exceptShelvesInfo = exceptShelvesInfos.get(io);

            if (StringUtils.isNull(exceptShelvesInfo.getStoreSiteNo())) {
                return error("上架明细中库位不能为空");
            }

            Storesite storesite = new Storesite();
            storesite.setStoresiteno(exceptShelvesInfo.getStoreSiteNo());
            List<Storesite> storesiteList = iStoresiteService.selectStoresiteList(storesite);
            if (storesiteList.size() <= 0) {
                return error("未查询到" + exceptShelvesInfo.getStoreSiteNo() + "对应的库位信息");
            }
            storesite = storesiteList.get(0);
            if (!storesite.getIsfrozen().equals("0")) {
                return error("库位【" + exceptShelvesInfo.getStoreSiteNo() + "】被锁定或者冻结");
            }
            PmMaterial pmMaterial = pmMaterialService.selectPmMaterialByMatcode(exceptShelvesInfo.getMatCode());
            if (pmMaterial == null) {
                return error("未查询到" + exceptShelvesInfo.getMatCode() + "对应的物料信息");
            }
            if (exceptShelvesInfo.getBatchNo() == null || exceptShelvesInfo.getBatchNo().equals("")) {
                //如果批号为空填SN
                exceptShelvesInfo.setBatchNo(exceptShelvesInfo.getSn());
            }

            Long I_TaskId = 0L;
            if (!StringUtils.isNull(exceptShelvesInfo.getTaskid())) {
                I_TaskId = Long.parseLong(exceptShelvesInfo.getTaskid());
            }
            Long I_STORESITEID = storesite.getStoresiteid();
            Long I_MATERIALID = pmMaterial.getPmMaterialid();

            Expcollectdata expcollectdata = new Expcollectdata();
            expcollectdata.setDcConnectid(I_CONNECTID);
            expcollectdata.setTaskid(I_TaskId);
            expcollectdata.setCollecttime(day);
            expcollectdata.setExpsite(I_STORESITEID);
            expcollectdata.setMaterialid(I_MATERIALID);
            expcollectdata.setBatchno(exceptShelvesInfo.getBatchNo());
            expcollectdata.setSn(exceptShelvesInfo.getSn());
            expcollectdata.setQty(exceptShelvesInfo.getCollectQty());
            expcollectdata.setExptype(exceptShelvesInfo.getExcepttype());
            expcollectdata.setExpdesc(exceptShelvesInfo.getDesc());
            expcollectdata.setDataversion(1L);
            expcollectdata.setProofno(exceptShelvesInfo.getProofNo());
            expcollectdata.setProtype(exceptShelvesInfo.getProtype());
            expcollectdata.setTaskno(exceptShelvesInfo.getTaskNo());
            expcollectdata.setPalletno(exceptShelvesInfo.getPalletNo());
            iExpcollectdataService.insertExpcollectdata(expcollectdata);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 在线拣选下架提交业务
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitFinishOutTaskItem")
    public AjaxResult CommitFinishOutTaskItem(String outtaskitemid) {

        if (StringUtils.isNull(outtaskitemid)) {
            return error("任务项ID不能为空!");
        }
        Long outtaskitemid_long = Long.parseLong(outtaskitemid);

        Outtaskitem outtaskitem = iOuttaskitemService.selectOuttaskitemByOuttaskitemid(outtaskitemid_long);
        if (outtaskitem == null) {
            return error("任务信息不存在!");
        }
        outtaskitem.setHintfinish(1L);
        iOuttaskitemService.updateOuttaskitem(outtaskitem);

        Outbill outbill = iOutbillService.selectOutbillByOutbillid(outtaskitem.getOutbillid());
        if (outbill == null) {
            return error("单据信息不存在!");
        }
        outbill.setCollectState(2L);
        iOutbillService.updateOutbill(outbill);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 获取尚未完成的已经收入库单据
     *
     * @param intaskitem 任务查询条件
     * @return 单据明细
     */
    @GetMapping("/getInTaskPalletNoByUserID")
    public AjaxResult GetInTaskPalletNoByUserID(Intaskitem intaskitem) {

        Long iUserId = 0L;
        Long iInstate = -1L;

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        if (intaskitem.getUserId().equals("ALL")) {
            iInstate = 0L;
        } else {
            iInstate = 1L;
            iUserId = Long.parseLong(intaskitem.getUserId());
        }

        intaskitem.setInstate(iInstate);
        intaskitem.setUserId(userId.toString());
        intaskitem.setI_collecter(iUserId);
        if (intaskitem.getPageIndex() > 0 && intaskitem.getPageSize() > 0) {
            PageHelper.startPage(intaskitem.getPageIndex(), intaskitem.getPageSize());
        }

        List<Intaskitem> intaskitemList = iIntaskitemService.getInTaskPalletNoByUserID(intaskitem);
        AjaxResult ajax = AjaxResult.success(getDataTable(intaskitemList));
        return ajax;
    }

    /**
     * 获取尚未完成的已经收入库单据
     *
     * @param intaskitem 任务查询条件
     * @return 单据明细
     */
    @GetMapping("/getInTaskPalletNo")
    public AjaxResult GetInTaskPalletNo(Intaskitem intaskitem) {


        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();
        intaskitem.setI_collecter(userId);

        List<Intaskitem> intaskitemList = iIntaskitemService.getInTaskPalletNo(intaskitem);
        AjaxResult ajax = AjaxResult.success(intaskitemList);
        return ajax;
    }

    /// 整盘上架任务接收
    /// </summary>
    /// <param name="taskcomment"></param>
    /// <param name="userId"></param>
    /// <param name="isCanel">是否取消 true 是</param>
    @PostMapping("/commitRCInTaskPalletNo")
    public AjaxResult CommitRCInTaskPalletNo(Long inTaskId, String palletNo,String roomTag, String isCanel) {


        if (!StringUtils.isNotNull(inTaskId)) {
            return error("任务项ID不能为空");
        }
        if (!StringUtils.isNotNull(palletNo)) {
            return error("托盘号不能为空");
        }
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        Long inState = -1L;
        if (isCanel.equals("true")) {
            inState = 0L;
            userId = 0L;
        } else {
            inState = 1L;
        }

        Intaskitem intaskitemCon= new Intaskitem();
        intaskitemCon.setIntaskid(inTaskId);
        intaskitemCon.setPalletno(palletNo);
        List<Intaskitem> IntaskitemColList= iIntaskitemService.selectInTaskByPalletNoCol(intaskitemCon);
        if(IntaskitemColList.size()<=0){
            return error("任务项ID：【"+inTaskId+"】已经开始采集不可以取消");
        }

        List<Intaskitem> IntaskitemList= iIntaskitemService.selectInTaskByPalletNo(intaskitemCon);

        for (int i = 0; i < IntaskitemList.size(); i++) {
            Intaskitem intaskitem = IntaskitemList.get(i);

            intaskitem.setCollecter(userId);
            intaskitem.setInstate(inState);
            iIntaskitemService.updateIntaskitem(intaskitem);
        }

        Intask intask = iIntaskService.selectIntaskByIntaskid(inTaskId);
        intask.setInstate(inState);
        intask.setCollecter(userId);
        iIntaskService.updateIntask(intask);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 获取已接收状态的下架任务信息
     */
    @GetMapping("/getOutTaskPalletNoByUserID")
    public AjaxResult GetOutTaskPalletNoByUserID(Outtaskitem outtaskitem) {

        Long iUserId = 0L;
        Long iOutstate = -1L;

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        if (outtaskitem.getUserId().equals("ALL")) {
            iOutstate = 0L;
        } else {
            iOutstate = 1L;
            iUserId = Long.parseLong(outtaskitem.getUserId());
        }

        outtaskitem.setI_collecter(iUserId);
        outtaskitem.setOutstate(iOutstate);
        outtaskitem.setUserId(outtaskitem.getRoleoRuserId());
        outtaskitem.setRoomTag(outtaskitem.getRoomTag());
        outtaskitem.setTransferType(outtaskitem.getTransferType());

        if (!outtaskitem.getBeatflag().equals("Y")) {
            outtaskitem.setBeatflag("N");
        }

        if (outtaskitem.getPageIndex() > 0 && outtaskitem.getPageSize() > 0) {
            PageHelper.startPage(outtaskitem.getPageIndex(), outtaskitem.getPageSize());
        }
        List<Outtaskitem> outaskitemList = iOuttaskitemService.getOutTaskPalletNoByUserID(outtaskitem);
        AjaxResult ajax = AjaxResult.success(getDataTable(outaskitemList));
        return ajax;
    }

    /// 整盘上架任务接收
    /// </summary>
    /// <param name="taskcomment"></param>
    /// <param name="userId"></param>
    /// <param name="isCanel">是否取消 true 是</param>
    @PostMapping("/commitRCOutTaskPalletNo")
    public AjaxResult CommitRCOutTaskPalletNo(Long outTaskId, String palletNo,String roomTag, String isCanel) {


        if (!StringUtils.isNotNull(outTaskId)) {
            return error("任务项ID不能为空");
        }
        if (!StringUtils.isNotNull(palletNo)) {
            return error("托盘号不能为空");
        }
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        Long inState = -1L;
        if (isCanel.equals("true")) {
            inState = 0L;
            userId = 0L;
        } else {
            inState = 1L;
        }

        Outtaskitem outtaskitemCon= new Outtaskitem();
        outtaskitemCon.setOuttaskid(outTaskId);
        outtaskitemCon.setPalletno(palletNo);
        List<Outtaskitem> OuttaskitemColList= iOuttaskitemService.selectOutTaskByPalletNoCol(outtaskitemCon);
        if(OuttaskitemColList.size()>0){
            return error("任务项ID：【"+outTaskId+"】已经开始采集不可以取消");
        }

        List<Outtaskitem> OuttaskitemList= iOuttaskitemService.selectOutTaskByPalletNo(outtaskitemCon);

        for (int i = 0; i < OuttaskitemList.size(); i++) {
            Outtaskitem outtaskitem = OuttaskitemList.get(i);

            outtaskitem.setCollecter(userId);
            outtaskitem.setOutstate(inState);
            iOuttaskitemService.updateOuttaskitem(outtaskitem);
        }

        Outtask outtask = iOuttaskService.selectOuttaskByOuttaskid(outTaskId);
        outtask.setOutstate(inState);
        outtask.setCollecter(userId);
        iOuttaskService.updateOuttask(outtask);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 工单调拨组盘上架提交业务
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitTrayUpShelves")
    public AjaxResult CommitTrayUpShelves(@RequestBody UpShelvesInfoReq data) {

        Long I_CONNECTID = null;
        List<BindingTrayInfo> trayInfos = data.getTrayInfos();
        List<ItemListInfo> itemListInfoList = data.getItemListInfos();
        if (trayInfos.size() <= 0) {
            return error("上架提交对象不能为空");
        }
        if (itemListInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        String taskNo = data.getTaskNo();

        Intask task = iIntaskService.selectIntaskByIntaskNo(taskNo);
        if (StringUtils.isNull(task)) {
            return error("未查询到任务号" + taskNo + "对应的任务信息");
        }

        for(int i=0;i<trayInfos.size();i++){
            BindingTrayInfo trayInfo=trayInfos.get(i);

            String S_CONNECTNO = GenerateDcConnectNo();
            java.util.Date D_CONTIME = new Date();

            DcConnect dcConnect = new DcConnect();
            dcConnect.setDcConnectno(S_CONNECTNO);
            dcConnect.setContime(D_CONTIME);
            dcConnect.setCollectortype("WIRELESS");
            dcConnect.setBusinesskind("INSOLID");
            dcConnect.setConstate(1L);
            dcConnect.setConemp(i_collecterId);
            dcConnect.setTaskid(task.getIntaskid());
            dcConnect.setTaskno(task.getIntaskno());
            dcConnect.setProofno(task.getTaskcomment());
            dcConnect.setProofid(task.getTasksource());
            dcConnect.setPalletno(trayInfo.getTrayNo());
            dcConnect.setDataversion(1L);
            Long retID = iDcConnectService.insertDcConnect(dcConnect);
            if (retID > 0) {
                I_CONNECTID = dcConnect.getDcConnectid();
            }

            Intaskitem intaskitem = new Intaskitem();
            intaskitem.setIntaskid(task.getIntaskid());
            intaskitem.setPalletno(trayInfo.getTrayNo());
            List<Intaskitem> intaskitemList= iIntaskitemService.selectInTaskByPalletNo(intaskitem);
            if(intaskitemList.size()<=0){
                return error("未查询到凭证号【" + task.getTaskcomment() + "】,托盘号【" + trayInfo.getTrayNo() +"】对应的入库明细信息");
            }
            for(int j=0;j<intaskitemList.size();j++){
                Intaskitem inTaskItemInfo=iIntaskitemService.selectIntaskitemByIntaskitemid(intaskitemList.get(j).getIntaskitemid());
                if(inTaskItemInfo==null){
                    return error("未查询到凭证号【" + task.getTaskcomment() + "】,托盘号【" + trayInfo.getTrayNo() +"】对应的入库明细信息");
                }
                inTaskItemInfo.setCollectedqty(inTaskItemInfo.getQty());
                iIntaskitemService.updateIntaskitem(inTaskItemInfo);

                Incollectdata incollectdata = new Incollectdata();
                incollectdata.setDcConnectid(I_CONNECTID);
                incollectdata.setIntaskid(inTaskItemInfo.getIntaskid());
                incollectdata.setIntaskitemid(inTaskItemInfo.getIntaskitemid());
                incollectdata.setCollecttime(D_CONTIME);
                incollectdata.setMaterialid(inTaskItemInfo.getMaterialid());
                incollectdata.setBatchno(inTaskItemInfo.getBatchno());
                incollectdata.setSn(inTaskItemInfo.getSn());
                incollectdata.setQty(inTaskItemInfo.getQty());
                incollectdata.setIndesc(task.getIndesc());
                incollectdata.setDataversion(1L);
                incollectdata.setCstate(0L);
                incollectdata.setPalletno(inTaskItemInfo.getPalletno());
                iIncollectdataService.insertIncollectdata(incollectdata);
            }
        }
        List<Intaskitem> inTaskItemList3 = iIntaskitemService.selectIntaskitemList3(task.getIntaskid());
        if (inTaskItemList3.size() <= 0) {
            task.setInstate(2L);
            iIntaskService.updateIntask(task);
        }

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 获取已接收状态的下架任务信息
     */
    @GetMapping("/getOutTaskPalletNo")
    public AjaxResult getOutTaskPalletNo(Outtaskitem outtaskitem) {

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();
        outtaskitem.setI_collecter(userId);

        List<Outtaskitem> outtaskitemList = iOuttaskitemService.getOutTaskPalletNo(outtaskitem);
        AjaxResult ajax = AjaxResult.success(outtaskitemList);
        return ajax;
    }

    /**
     * 在线拣选下架提交业务
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitASWHPalletNoDownShelves")
    public AjaxResult CommitASWHPalletNoDownShelves(@RequestBody DownShelvesInfoReq data) {

        List<DownShelvesInfo> downShelvesInfoList = data.getDownShelvesInfos();
        List<ItemListInfo> itemListInfoList = data.getItemListInfos();
        if (downShelvesInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }
        if (itemListInfoList.size() <= 0) {
            return error("上架提交对象不能为空");
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        String taskNo = downShelvesInfoList.get(0).getTaskNo();
        Outtask task = iOuttaskService.selectOuttaskByOuttaskno(taskNo);
        if (StringUtils.isNull(task)) {
            return error("未查询到任务号" + taskNo + "对应的出库任务信息");
        }

        String batchFlag = task.getBatchflag().toString();
        String siteFlag = task.getForcesite();
        java.util.Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String collect_time = sdf.format(day);

        for (int io = 0; io < downShelvesInfoList.size(); io++) {
            Long I_CONNECTID = null;
            DownShelvesInfo CollectInfo=downShelvesInfoList.get(io);

            String S_CONNECTNO = GenerateDcConnectNo();
            java.util.Date D_CONTIME = new Date();

            DcConnect dcConnect = new DcConnect();
            dcConnect.setDcConnectno(S_CONNECTNO);
            dcConnect.setContime(D_CONTIME);
            dcConnect.setCollectortype("WIRELESS");
            dcConnect.setBusinesskind("OUTSOLID");
            dcConnect.setConstate(1L);
            dcConnect.setPalletno(CollectInfo.getTrayNo());
            dcConnect.setConemp(i_collecterId);
            dcConnect.setTaskid(task.getOuttaskid());
            dcConnect.setTaskno(task.getOuttaskno());
            dcConnect.setProofno(task.getTaskcomment());
            dcConnect.setProofid(task.getTasksource());
            dcConnect.setDataversion(1L);
            Long retID = iDcConnectService.insertDcConnect(dcConnect);
            if (retID > 0) {
                I_CONNECTID = dcConnect.getDcConnectid();
            }

            Outtaskitem outtaskitem =new Outtaskitem();
            outtaskitem.setOuttaskid(task.getOuttaskid());
            outtaskitem.setPalletno(CollectInfo.getTrayNo());

            List<Outtaskitem> outtaskitemList= iOuttaskitemService.selectOutTaskByPalletNo(outtaskitem);
            if(outtaskitemList.size()<=0){
                return error("未查询到凭证号【" + task.getTaskcomment() + "】,托盘号【" + CollectInfo.getTrayNo() + "】对应的出库明细信息");
            }
            for (int it = 0; it < outtaskitemList.size(); it++) {
                Outtaskitem outTaskItem=outtaskitemList.get(it);
                if(outTaskItem==null){
                    return error("未查询到凭证号【" + task.getTaskcomment() + "】,托盘号【" + CollectInfo.getTrayNo() + "】对应的出库明细信息");
                }
                outTaskItem.setCollectedqty(outTaskItem.getHintqty());
                iOuttaskitemService.updateOuttaskitem(outTaskItem);

                Outcollectdata outcollectdata = new Outcollectdata();
                outcollectdata.setDcConnectid(I_CONNECTID);
                outcollectdata.setOuttaskitemid(outTaskItem.getOuttaskitemid());
                outcollectdata.setCollecttime(day);
                outcollectdata.setOutsite(outTaskItem.getHintsite());
                outcollectdata.setMaterialid(outTaskItem.getMaterialid());
                outcollectdata.setBatchno(outTaskItem.getHintbatchno());
                outcollectdata.setSn(outTaskItem.getSn());
                outcollectdata.setQty(outTaskItem.getHintqty());
                outcollectdata.setOutdesc(task.getOutdesc());
                outcollectdata.setDataversion(1L);
                outcollectdata.setPalletno(outTaskItem.getPalletno());
                outcollectdata.setData1(outTaskItem.getSubinventoryCode());
                outcollectdata.setCstate(0L);
                iOutcollectdataService.insertOutcollectdata(outcollectdata);
            }
        }

        Outtaskitem outtaskitem3 = new Outtaskitem();
        outtaskitem3.setOuttaskid(task.getOuttaskid());
        List<Outtaskitem> inTaskItemList3 = iOuttaskitemService.selectOuttaskitemList(outtaskitem3);
        if (inTaskItemList3.size() <= 0) {
            task.setOutstate(2L);
            iOuttaskService.updateOuttask(task);
        }
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 获取首页公告栏信息
     */
    @Anonymous
    @GetMapping("/getLatestNotice")
    public AjaxResult getLatestNotice() {
        SysNotice notice= new SysNotice();
        List<SysNotice> noticeList = iSysNoticeService.selectLatestNoticeList(notice);
        AjaxResult ajax = AjaxResult.success(noticeList);
        return ajax;
    }

    /**
     * 获取公告栏信息
     */
    @GetMapping("/getMorNotice")
    public AjaxResult getMorNotice() {
        SysNotice notice= new SysNotice();
        List<SysNotice> noticeListC = new ArrayList<SysNotice>();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yy年MM月dd日");
        List<SysNotice> noticeList = iSysNoticeService.selectMorNoticeList(notice);
        for(int i=0;i<noticeList.size();i++){

            notice=noticeList.get(i);
            String date1 = sdf1.format(notice.getCreateTime());
            String noteContent=notice.getNoticeContent();
            noteContent=noteContent.replaceAll("<[.[^<]]*>", "");
            notice.setNoticeContent(noteContent);
            notice.setCreateDate(date1);
            noticeListC.add(notice);
        }
        AjaxResult ajax = AjaxResult.success(noticeListC);
        return ajax;
    }

    /**
     * 获取首页公告栏信息
     */
    @GetMapping("/getNoticeDetail")
    public AjaxResult getNoticeDetail(Long noticeId) {
        SysNotice notice = iSysNoticeService.selectNoticeDetail(noticeId);

        String noteContent=notice.getNoticeContent();
        noteContent=noteContent.replaceAll("<[.[^<]]*>", "");
        notice.setNoticeContent(noteContent);

        AjaxResult ajax = AjaxResult.success(notice);
        return ajax;
    }

    /**
     * 取物料库位库存
     *
     * @return 当前库存数量
     */
    @GetMapping("/GetRepertoryBySiteNoMatCode")
    public AjaxResult GetRepertoryBySiteNoMatCode(String storesiteno, String matcode, String batchno) {
        Repertory repertory = new Repertory();
        System.out.println("开始处理");
        if (StringUtils.isNull(storesiteno)) {
            return error("库位编码为空！");
        }

        if (StringUtils.isNull(matcode)) {
            return error("物料编码为空！");
        }

        repertory.setStoresiteno(storesiteno);
        repertory.setMatCode(matcode);

        List<Repertory> repertoryList = iRepertoryService.GetRepertoryBySiteNoMatCode(repertory);
        AjaxResult ajax = AjaxResult.success(repertoryList);
        return ajax;
    }

    /**
     * 取物料库位库存
     *
     * @return 当前库存数量
     */
    @GetMapping("/GetRepertoryByStoresiteNoTransfer")
    public AjaxResult GetRepertoryByStoresiteNoTransfer(String sourceStoresiteNo, String targetStoresiteNo) {
        Repertory repertory = new Repertory();
        System.out.println("开始处理");
        //strSourceSite + strMatCode + strBatch + strErpStoreRoom + strErpOwnerCode + strProjectNum
        repertory.setSourceStoresiteNo(sourceStoresiteNo);
        repertory.setTargetStoresiteNo(targetStoresiteNo);




        List<Repertory> repertoryList = iRepertoryService.GetRepertoryByStoresiteNoTransfer(repertory);
        AjaxResult ajax = AjaxResult.success(repertoryList);
        return ajax;
    }

    /**
     * 上架提交业务
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/commitTransfer")
    public AjaxResult CommitTransfer(@RequestBody UpShelvesInfoReq data) {

        Long I_CONNECTID = null;
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long i_collecterId = user.getUserId();

        java.util.Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String collect_time = sdf.format(day);

        List<TransferInfo> transferInfos = data.getTransferInfos();
        if (transferInfos.size() <= 0) {
            return error("上架提交对象不能为空");
        }
        String filter = data.getFilter();
        List<Repertory> RepertoryList = new ArrayList<>();
        List<Repertory> dr = new ArrayList<>();
        List<Repertory> dr2 = new ArrayList<>();

        if(StringUtils.isNotNull(filter)){
            Repertory repertory=new Repertory();
            repertory.setFilter(filter);
            RepertoryList=iRepertoryService.GetRepertoryTransfer(repertory);
        }
        java.util.Date D_CONTIME = new Date();
        for (int io = 0; io < transferInfos.size(); io++) {
            TransferInfo info =transferInfos.get(io);
            if (info.getSn().equals(""))
            {
                String OutSite = info.getOutSite();
                String MaterialCode = info.getMaterialCode();
                String BatchNo = info.getBatchNo();
                String ErpRoom = info.getErpRoom();
                String Supplier = info.getSupplier();
                String ProjectNum = info.getProjectNum();

                if (StringUtils.isEmpty(ProjectNum))
                {
                    dr = RepertoryList.stream().filter(item ->
                            OutSite.equals(item.getStoresiteno()) &&
                                    MaterialCode.equals(item.getMatcode()) &&
                                    BatchNo.equals(item.getBatchno()) &&
                                    ErpRoom.equals(item.getErpStoreroom()) &&
                                    Supplier.equals(item.getRepOwnerCode())

                    ).collect(Collectors.toList());
                }
                else
                {
                    dr = RepertoryList.stream().filter(item ->
                            OutSite.equals(item.getStoresiteno()) &&
                                    MaterialCode.equals(item.getMatcode()) &&
                                    BatchNo.equals(item.getBatchno()) &&
                                    ErpRoom.equals(item.getErpStoreroom()) &&
                                    Supplier.equals(item.getRepOwnerCode()) &&
                                    ProjectNum.equals(item.getProjectNum())

                    ).collect(Collectors.toList());
                }
                if (dr.size() == 0)
                {
                    return error("库位【"+OutSite+"】物料【"+MaterialCode+"】批号【"+BatchNo+"】子库【"+ErpRoom+"】拥有方【"+Supplier+"】项目号【"+ProjectNum+"】找不到对应的库存");
                }
            }
            else
            {
                String OutSite = info.getOutSite();
                String sn = info.getSn();

                dr = RepertoryList.stream().filter(item ->
                        sn.equals(item.getSn())

                ).collect(Collectors.toList());

                if (dr.size() == 0)
                {
                    return error("库位【"+OutSite+"】序列号【"+sn+"】找不到对应的库存");
                }
            }

            Storesite site = iStoresiteService.selectStoresiteByStoresiteno(info.getInSite());
            if (StringUtils.isNull(site)) {
                return error("未查询到" + info.getInSite() + "对应的库位信息");
            }
            if (info.getBatchNo().equals(""))
            {
                info.setBatchNo(info.getSn());
            }
            Long siteId = dr.get(0).getStoresiteid();
            Long materialId =  dr.get(0).getMaterialid();

            Outtaskitem outtaskitem = new Outtaskitem();
            outtaskitem.setHintsite(siteId);
            outtaskitem.setMaterialid(materialId);
            List<Outtaskitem> OuttaskitemList=iOuttaskitemService.selecttransQty(outtaskitem);
            if(OuttaskitemList!=null && OuttaskitemList.size()>0){
                Outbill outbill=new Outbill();
                outbill.setOutbillid(OuttaskitemList.get(0).getOutbillid());
                outbill.setMaterialid(OuttaskitemList.get(0).getMaterialid());
                List<Outbill> OutbillList=iOutbillService.selecttransQty(outbill);
                if(OutbillList!=null && OutbillList.size()>0){
                    return error("库位【"+info.getOutSite()+"】物料【"+info.getMaterialCode()+"】有采集任务未完成,不能移库!");
                }else{
                    dr2 = RepertoryList.stream().filter(item ->
                            info.getOutSite().equals(item.getStoresiteno()) &&
                                    info.getMaterialCode().equals(item.getMatcode())
                    ).collect(Collectors.toList());
                    if(dr2!=null && dr2.size()>0){
                        BigDecimal occupyqty = new BigDecimal(0);
                        for(int occ=0; occ<dr2.size();occ++){
                            occupyqty=occupyqty.add(dr2.get(occ).getOccupyqty());
                        }
                        if(occupyqty.compareTo(new BigDecimal(0))>0){
                            return error("库位【"+info.getOutSite()+"】物料【"+info.getMaterialCode()+"】对应的库存被占用,不能移库!");
                        }
                    }
                }
            }else{

                dr2 = RepertoryList.stream().filter(item ->
                        info.getOutSite().equals(item.getStoresiteno()) &&
                                info.getMaterialCode().equals(item.getMatcode())
                ).collect(Collectors.toList());
                if(dr2!=null && dr2.size()>0){
                    BigDecimal occupyqty = new BigDecimal(0);
                    for(int occ=0; occ<dr2.size();occ++){
                        occupyqty=occupyqty.add(dr2.get(occ).getOccupyqty());
                    }
                    if(occupyqty.compareTo(new BigDecimal(0))>0){
                        return error("库位【"+info.getOutSite()+"】物料【"+info.getMaterialCode()+"】对应的库存被占用,不能移库!");
                    }
                }
            }

            if (dr.size()>0)
            {
                BigDecimal planQty = info.getQty();
                for (int i = 0; i < dr.size();i++ )
                {
                    BigDecimal clentQty = dr.get(i).getRepqty();
                    if (planQty.compareTo(clentQty)<=0 && planQty.compareTo(new BigDecimal(0))>0)
                    {
                        Moveinout moveinout = new Moveinout();
                        moveinout.setInsite(site.getStoresiteid());
                        moveinout.setOutsite(dr.get(i).getStoresiteid());
                        moveinout.setMaterialid(dr.get(i).getMaterialid());
                        moveinout.setBatchno(info.getBatchNo());
                        moveinout.setSn(info.getSn());
                        moveinout.setQty(planQty);
                        moveinout.setMovedesc(info.getMoveDesc());
                        moveinout.setDataversion(1L);
                        moveinout.setData1(i_collecterId.toString());
                        moveinout.setData2(collect_time);
                        moveinout.setData3(dr.get(i).getRepprovider().toString());
                        moveinout.setRepColor(dr.get(i).getRepColor());
                        moveinout.setRepProperty(dr.get(i).getRepProperty());
                        moveinout.setRepOwnerCode(dr.get(i).getRepOwnerCode());
                        moveinout.setRepOwnerName(dr.get(i).getRepOwnerName());
                        moveinout.setRepOrg(dr.get(i).getRepOrg());
                        moveinout.setErpStoreroom(dr.get(i).getErpStoreroom());
                        moveinout.setRepertoryid(dr.get(i).getRepertoryid());
                        moveinout.setProjectNum(dr.get(i).getProjectNum());
                        moveinout.setCreatedate(day);
                        moveinout.setCreator(i_collecterId);
                        iMoveinoutService.insertMoveinout(moveinout);
                        break;
                    }else{
                        planQty = planQty.subtract(clentQty);
                        Moveinout moveinout = new Moveinout();
                        moveinout.setInsite(site.getStoresiteid());
                        moveinout.setOutsite(dr.get(i).getStoresiteid());
                        moveinout.setMaterialid(dr.get(i).getMaterialid());
                        moveinout.setBatchno(info.getBatchNo());
                        moveinout.setSn(info.getSn());
                        moveinout.setQty(clentQty);
                        moveinout.setMovedesc(info.getMoveDesc());
                        moveinout.setDataversion(1L);
                        moveinout.setData1(i_collecterId.toString());
                        moveinout.setData2(collect_time);
                        moveinout.setData3(dr.get(i).getRepprovider().toString());
                        moveinout.setRepColor(dr.get(i).getRepColor());
                        moveinout.setRepProperty(dr.get(i).getRepProperty());
                        moveinout.setRepOwnerCode(dr.get(i).getRepOwnerCode());
                        moveinout.setRepOwnerName(dr.get(i).getRepOwnerName());
                        moveinout.setRepOrg(dr.get(i).getRepOrg());
                        moveinout.setErpStoreroom(dr.get(i).getErpStoreroom());
                        moveinout.setRepertoryid(dr.get(i).getRepertoryid());
                        moveinout.setProjectNum(dr.get(i).getProjectNum());
                        moveinout.setCreatedate(day);
                        moveinout.setCreator(i_collecterId);
                        iMoveinoutService.insertMoveinout(moveinout);
                    }
                }
            }
        }
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 首页获取入库图表
     *
     * @return 首页获取入库图表
     */
    @GetMapping("/getInboundData")
    public AjaxResult getInboundData(String dateType, String dataValue) {
        List<String> categoryList = new ArrayList<>();

        List<BigDecimal> qtydataList = new ArrayList<>();
        List<BigDecimal> kinddataList = new ArrayList<>();
        List<BigDecimal> YOYqtyList = new ArrayList<>();
        List<BigDecimal> YOYkindList = new ArrayList<>();

        BigDecimal Y1max=new BigDecimal(0);
        BigDecimal Y2max=new BigDecimal(0);


        if(StringUtils.isEmpty(dateType)){
            dateType="month";
        }
        if(StringUtils.isEmpty(dataValue)){
            java.util.Date day = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            dataValue = sdf.format(day);
        }
        Incollectdata con=new Incollectdata();
        con.setMonth_id(dataValue);
        List<Incollectdata> IncollectdataList=iIncollectdataService.getInboundData(con);
        if(IncollectdataList.size()>0){
            for(int i=0;i<IncollectdataList.size();i++){
                Incollectdata incollectdata= IncollectdataList.get(i);
                categoryList.add(incollectdata.getMonth_id());
                qtydataList.add(incollectdata.getQty());
                kinddataList.add(incollectdata.getKindqty());
                YOYqtyList.add(incollectdata.getQty_voy());
                YOYkindList.add(incollectdata.getKindqty_voy());
            }
            Y1max = IncollectdataList.stream().map(Incollectdata::getQty).max((x1, x2) -> x1.compareTo(x2)).get();
            Y2max = IncollectdataList.stream().map(Incollectdata::getKindqty).max((x1, x2) -> x1.compareTo(x2)).get();
        }

        AjaxResult ajax = AjaxResult.success();
        ajax.put("categoryList",categoryList);
        ajax.put("qtydataList",qtydataList);
        ajax.put("kinddataList",kinddataList);
        ajax.put("YOYqtyList",YOYqtyList);
        ajax.put("YOYkindList",YOYkindList);
        ajax.put("Y1max",Y1max);
        ajax.put("Y2max",Y2max);

        return ajax;
    }

    /**
     * 首页获取出库图表
     *
     * @return 首页获取出库图表
     */
    @GetMapping("/getOutboundData")
    public AjaxResult getOutboundData(String dateType, String dataValue) {
        List<String> categoryList = new ArrayList<>();

        List<BigDecimal> qtydataList = new ArrayList<>();
        List<BigDecimal> kinddataList = new ArrayList<>();
        List<BigDecimal> YOYqtyList = new ArrayList<>();
        List<BigDecimal> YOYkindList = new ArrayList<>();

        BigDecimal Y1max=new BigDecimal(0);
        BigDecimal Y2max=new BigDecimal(0);


        if(StringUtils.isEmpty(dateType)){
            dateType="month";
        }
        if(StringUtils.isEmpty(dataValue)){
            java.util.Date day = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            dataValue = sdf.format(day);
        }
        Incollectdata con=new Incollectdata();
        con.setMonth_id(dataValue);
        List<Incollectdata> IncollectdataList=iIncollectdataService.getOutboundData(con);
        if(IncollectdataList.size()>0){
            for(int i=0;i<IncollectdataList.size();i++){
                Incollectdata incollectdata= IncollectdataList.get(i);
                categoryList.add(incollectdata.getMonth_id());
                qtydataList.add(incollectdata.getQty());
                kinddataList.add(incollectdata.getKindqty());
                YOYqtyList.add(incollectdata.getQty_voy());
                YOYkindList.add(incollectdata.getKindqty_voy());
            }
            Y1max = IncollectdataList.stream().map(Incollectdata::getQty).max((x1, x2) -> x1.compareTo(x2)).get();
            Y2max = IncollectdataList.stream().map(Incollectdata::getKindqty).max((x1, x2) -> x1.compareTo(x2)).get();
        }

        AjaxResult ajax = AjaxResult.success();
        ajax.put("categoryList",categoryList);
        ajax.put("qtydataList",qtydataList);
        ajax.put("kinddataList",kinddataList);
        ajax.put("YOYqtyList",YOYqtyList);
        ajax.put("YOYkindList",YOYkindList);
        ajax.put("Y1max",Y1max);
        ajax.put("Y2max",Y2max);

        return ajax;
    }

    /**
     * 首页获取平均工作量数据
     *
     * @return 首页获取平均工作量数据
     */
    @GetMapping("/getWorkloadData")
    public AjaxResult getWorkloadData(String dateType, String dataValue) {
        List<String> categoryList = new ArrayList<>();

        List<String> legendList = new ArrayList<>();
        List<BigDecimal> bar1List = new ArrayList<>();
        List<BigDecimal> bar2List = new ArrayList<>();
        List<BigDecimal> bar3List = new ArrayList<>();
        String bar1Name="";
        String bar2Name="";
        String bar3Name="";
        BigDecimal Y1max=new BigDecimal(0);



        if(StringUtils.isEmpty(dateType)){
            dateType="month";
        }
        if(StringUtils.isEmpty(dataValue)){
            java.util.Date day = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            dataValue = sdf.format(day);
        }
        Incollectdata con=new Incollectdata();
        con.setMonth_id(dataValue);
        List<Incollectdata> incollectdataList=iIncollectdataService.getWorkloadData(con);
        if(incollectdataList.size()>0){
            Y1max = incollectdataList.stream().map(Incollectdata::getQty).max((x1, x2) -> x1.compareTo(x2)).get();
            List<Incollectdata> yearList =  incollectdataList.stream().collect(
                    collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(Incollectdata::getYear_id))), ArrayList::new)

            );
            if(yearList.size()>0){
                for(int i=0;i<yearList.size();i++){
                    Incollectdata yeardata=yearList.get(i);
                    legendList.add(yeardata.getYear_id());
                    if(i==0){
                        bar1Name=yeardata.getYear_id();
                    }
                    if(i==1){
                        bar2Name=yeardata.getYear_id();
                    }
                    if(i==2){
                        bar3Name=yeardata.getYear_id();
                    }
                    for(int j=0;j<incollectdataList.size();j++){

                        Incollectdata colldata=incollectdataList.get(j);
                        if(yeardata.getYear_id().equals(colldata.getYear_id())){
                            if(i==0){
                                bar1List.add(colldata.getQty());
                            }
                            if(i==1){
                                bar2List.add(colldata.getQty());
                            }
                            if(i==2){
                                bar3List.add(colldata.getQty());
                            }
                        }
                    }
                }
            }
        }
        AjaxResult ajax = AjaxResult.success();
        ajax.put("legendList",legendList);
        ajax.put("bar1List",bar1List);
        ajax.put("bar2List",bar2List);
        ajax.put("bar3List",bar3List);
        ajax.put("bar1Name",bar1Name);
        ajax.put("bar2Name",bar2Name);
        ajax.put("bar3Name",bar3Name);
        ajax.put("Y1max",Y1max);
        return ajax;
    }

    /**
     * 首页获取平均工作量数据
     *
     * @return 首页获取平均工作量数据
     */
    @GetMapping("/getInboundDatabykindqty")
    public AjaxResult getInboundDatabykindqty(String dateType, String dataValue) {
        List<String> legendList = new ArrayList<>();
        List<BigDecimal> bar1List = new ArrayList<>();
        List<BigDecimal> bar2List = new ArrayList<>();
        List<BigDecimal> bar3List = new ArrayList<>();

        List<BigDecimal> bar1KindList = new ArrayList<>();
        List<BigDecimal> bar2KindList = new ArrayList<>();
        List<BigDecimal> bar3KindList = new ArrayList<>();

        String bar1Name="";
        String bar2Name="";
        String bar3Name="";
        BigDecimal Y1max=new BigDecimal(0);
        BigDecimal Y2max=new BigDecimal(0);

        if(StringUtils.isEmpty(dateType)){
            dateType="month";
        }
        if(StringUtils.isEmpty(dataValue)){
            java.util.Date day = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            dataValue = sdf.format(day);
        }
        Incollectdata con=new Incollectdata();
        con.setMonth_id(dataValue);
        List<Incollectdata> incollectdataList=iIncollectdataService.getInboundDatabykindqty(con);
        if(incollectdataList.size()>0){
            Y1max = incollectdataList.stream().map(Incollectdata::getQty).max((x1, x2) -> x1.compareTo(x2)).get();
            Y2max = incollectdataList.stream().map(Incollectdata::getKindqty).max((x1, x2) -> x1.compareTo(x2)).get();

            List<Incollectdata> yearList =  incollectdataList.stream().collect(
                    collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(Incollectdata::getYear_id))), ArrayList::new)

            );
            if(yearList.size()>0){
                for(int i=0;i<yearList.size();i++){
                    Incollectdata yeardata=yearList.get(i);
                    legendList.add(yeardata.getYear_id());
                    if(i==0){
                        bar1Name=yeardata.getYear_id();
                    }
                    if(i==1){
                        bar2Name=yeardata.getYear_id();
                    }
                    if(i==2){
                        bar3Name=yeardata.getYear_id();
                    }
                    for(int j=0;j<incollectdataList.size();j++){

                        Incollectdata colldata=incollectdataList.get(j);
                        if(yeardata.getYear_id().equals(colldata.getYear_id())){
                            if(i==0){
                                bar1List.add(colldata.getQty());
                                bar1KindList.add(colldata.getKindqty());
                            }
                            if(i==1){
                                bar2List.add(colldata.getQty());
                                bar2KindList.add(colldata.getKindqty());
                            }
                            if(i==2){
                                bar3List.add(colldata.getQty());
                                bar3KindList.add(colldata.getKindqty());
                            }
                        }
                    }
                }
            }
        }
        AjaxResult ajax = AjaxResult.success();
        ajax.put("legendList",legendList);
        ajax.put("bar1List",bar1List);
        ajax.put("bar2List",bar2List);
        ajax.put("bar3List",bar3List);
        ajax.put("bar1KindList",bar1KindList);
        ajax.put("bar2KindList",bar2KindList);
        ajax.put("bar3KindList",bar3KindList);
        ajax.put("bar1Name",bar1Name);
        ajax.put("bar2Name",bar2Name);
        ajax.put("bar3Name",bar3Name);
        ajax.put("Y1max",Y1max);
        ajax.put("Y2max",Y2max);
        return ajax;
    }

    /**
     * 首页指定年月仓库入库明细占比
     *
     * @return 首页获取平均工作量数据
     */
    @GetMapping("/getInbounddetail")
    public AjaxResult getInbounddetail(String mode,String year_month,String dateType) {
        List<String> categoryList = new ArrayList<>();
        List<BigDecimal> bar1List = new ArrayList<>();
        List<IncollectdataRes> bar2List= new ArrayList<>();
        BigDecimal Y1max=new BigDecimal(0);
        String dataValue="";

        if(StringUtils.isEmpty(dateType)){
            dateType="month";
        }
        if(StringUtils.isEmpty(mode)){
            mode="kind";
        }
        if(StringUtils.isEmpty(year_month) ){
            java.util.Date day = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            dataValue = sdf.format(day);
        }else{
            dataValue=year_month;
        }

        Incollectdata con=new Incollectdata();
        con.setMonth_id(dataValue);

        List<Incollectdata> incollectdataList = iIncollectdataService.getInbounddetail(con);

        if(incollectdataList.size()>0) {

            if (mode.equals("kind")) {
                Y1max = incollectdataList.stream().map(Incollectdata::getKindqty).max((x1, x2) -> x1.compareTo(x2)).get();
            } else {
                Y1max = incollectdataList.stream().map(Incollectdata::getQty).max((x1, x2) -> x1.compareTo(x2)).get();
            }

            for (int j = 0; j < incollectdataList.size(); j++) {
                Incollectdata colldata = incollectdataList.get(j);
                categoryList.add(colldata.getStoreroomname());
                if (mode.equals("kind")) {
                    bar1List.add(colldata.getKindqty());
                    IncollectdataRes res = new IncollectdataRes();
                    res.setName(colldata.getStoreroomname());
                    res.setValue(colldata.getKindqty());
                    bar2List.add(res);
                } else {
                    bar1List.add(colldata.getQty());
                    IncollectdataRes res = new IncollectdataRes();
                    res.setName(colldata.getStoreroomname());
                    res.setValue(colldata.getQty());
                    bar2List.add(res);
                }
            }
        }
        AjaxResult ajax = AjaxResult.success();
        ajax.put("categoryList",categoryList);
        ajax.put("bar1List",bar1List);
        ajax.put("bar2List",bar2List);
        ajax.put("Y1max",Y1max);
        return ajax;
    }

    /**
     * 首页指定年月仓库入库明细占比
     *
     * @return 首页获取平均工作量数据
     */
    @GetMapping("/getOutbounddetail")
    public AjaxResult getOutbounddetail(String mode,String year_month,String dateType) {
        List<String> categoryList = new ArrayList<>();
        List<BigDecimal> bar1List = new ArrayList<>();
        List<IncollectdataRes> bar2List= new ArrayList<>();
        BigDecimal Y1max=new BigDecimal(0);
        String dataValue="";

        if(StringUtils.isEmpty(dateType)){
            dateType="month";
        }
        if(StringUtils.isEmpty(mode)){
            mode="kind";
        }
        if(StringUtils.isEmpty(year_month) ){
            java.util.Date day = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            dataValue = sdf.format(day);
        }else{
            dataValue=year_month;
        }

        Incollectdata con=new Incollectdata();
        con.setMonth_id(dataValue);

        List<Incollectdata> incollectdataList = iIncollectdataService.getOutbounddetail(con);

        if(incollectdataList.size()>0) {

            if (mode.equals("kind")) {
                Y1max = incollectdataList.stream().map(Incollectdata::getKindqty).max((x1, x2) -> x1.compareTo(x2)).get();
            } else {
                Y1max = incollectdataList.stream().map(Incollectdata::getQty).max((x1, x2) -> x1.compareTo(x2)).get();
            }

            for (int j = 0; j < incollectdataList.size(); j++) {
                Incollectdata colldata = incollectdataList.get(j);
                categoryList.add(colldata.getStoreroomname());
                if (mode.equals("kind")) {
                    bar1List.add(colldata.getKindqty());
                    IncollectdataRes res = new IncollectdataRes();
                    res.setName(colldata.getStoreroomname());
                    res.setValue(colldata.getKindqty());
                    bar2List.add(res);
                } else {
                    bar1List.add(colldata.getQty());
                    IncollectdataRes res = new IncollectdataRes();
                    res.setName(colldata.getStoreroomname());
                    res.setValue(colldata.getQty());
                    bar2List.add(res);
                }
            }
        }
        AjaxResult ajax = AjaxResult.success();
        ajax.put("categoryList",categoryList);
        ajax.put("bar1List",bar1List);
        ajax.put("bar2List",bar2List);
        ajax.put("Y1max",Y1max);
        return ajax;
    }

    /**
     * 首页指定年月仓库入库明细占比
     *
     * @return 首页获取平均工作量数据
     */
    @GetMapping("/selectPdaCollExceptList")
    public AjaxResult selectPdaCollExceptList(DcConnect Intask) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        java.util.Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String collect_time = sdf.format(day);

        //创建Calendar实例
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);   //设置当前时间
        cal.add(Calendar.MONTH, -1);  //在当前时间基础上加一年

        DcConnect dcConnect= new DcConnect();
        dcConnect.setConemp(userId);
        dcConnect.setFinish_contime(collect_time);
        dcConnect.setStart_contime(sdf.format(cal.getTime()));
        if (dcConnect.getPageIndex() > 0 && dcConnect.getPageSize() > 0) {
            PageHelper.startPage(Intask.getPageIndex(), Intask.getPageSize());
        }

        List<DcConnect> dcConnectList = iDcConnectService.selectPdaCollExceptList(dcConnect);
        AjaxResult ajax = AjaxResult.success(getDataTable(dcConnectList));
        return ajax;
    }

    /**
     * 首页指定年月仓库入库明细占比
     *
     * @return 首页获取平均工作量数据
     */
    @GetMapping("/reprocessDconnect")
    public AjaxResult reprocessDconnect(Long dcConnectid) {

        if(dcConnectid==null){
            return error("通讯批次id为空");
        }

        DcConnect dcConnect= new DcConnect();
        dcConnect=iDcConnectService.selectDcConnectByDcConnectid(dcConnectid);
        if(dcConnect==null){
            return error("未查询到通讯数据");
        }
        if(dcConnect.getConstate() != -1L){
            return error("该数据状态已经调整，请重新刷新数据");
        }
        dcConnect.setConstate(1L);
        iDcConnectService.updateDcConnect(dcConnect);
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 消息状态调整
     *
     * @return 消息状态调整
     */
    @GetMapping("/messageConfim")
    public AjaxResult messageConfim(Long messageId) {

        if(messageId==null){
            return error("消息id为空");
        }

        SysMessage sysMessage= new SysMessage();
        sysMessage=iSysMessageService.selectSysMessageByMessageId(messageId);
        if(sysMessage==null){
            return error("未查询到消息记录");
        }
        if(!sysMessage.getMessageStatus().equals("1")) {
            return error("该数据状态已经调整，请重新刷新数据");
        }
        sysMessage.setMessageStatus("2");
        iSysMessageService.updateSysMessage(sysMessage);
        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    /**
     * 首页指定年月仓库入库明细占比
     *
     * @return 首页获取平均工作量数据
     */
    @GetMapping("/selectPdaCollExceptDetailList")
    public AjaxResult selectPdaCollExceptDetailList(DcConnect Intask) {

        Long dcConnectID=Intask.getDcConnectid();
        if(dcConnectID==null){
            return error("通讯批次id为空");
        }
        DcConnect dcConnect= iDcConnectService.selectDcConnectByDcConnectid(dcConnectID);
        if(dcConnect==null){
            return error("未查询到通讯数据");
        }



        if (dcConnect.getPageIndex() > 0 && dcConnect.getPageSize() > 0) {
            PageHelper.startPage(Intask.getPageIndex(), Intask.getPageSize());
        }

        List<DcConnect> dcConnectList = iDcConnectService.selectPdaCollExceptList(dcConnect);
        AjaxResult ajax = AjaxResult.success(getDataTable(dcConnectList));
        return ajax;
    }

    /**
     * 首页指定年月仓库入库明细占比
     *
     * @return 首页获取平均工作量数据
     */
    @GetMapping("/selectSapInteExceptList")
    public AjaxResult selectSapInteExceptList(DcConnect Intask) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        java.util.Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String collect_time = sdf.format(day);

        //创建Calendar实例
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);   //设置当前时间
        cal.add(Calendar.DATE, -1);  //在当前时间基础上加一年

        DcConnect dcConnect= new DcConnect();
        dcConnect.setConemp(userId);
        dcConnect.setFinish_contime(collect_time);
        dcConnect.setStart_contime(sdf.format(cal.getTime()));
        if (dcConnect.getPageIndex() > 0 && dcConnect.getPageSize() > 0) {
            PageHelper.startPage(Intask.getPageIndex(), Intask.getPageSize());
        }

        List<DcConnect> dcConnectList = iDcConnectService.selectSapInteExceptList(dcConnect);
        AjaxResult ajax = AjaxResult.success(getDataTable(dcConnectList));
        return ajax;
    }

    /**
     * 首页指定年月仓库入库明细占比
     *
     * @return 首页获取平均工作量数据
     */
    @GetMapping("/selectTaskMessageList")
    public AjaxResult selectTaskMessageList(SysMessage sysMessage) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        sysMessage.setMessageReceiver(userId+"");
        List<SysMessage> sysMessageList = iSysMessageService.selectSysMessageList2(sysMessage);
        AjaxResult ajax = AjaxResult.success(getDataTable(sysMessageList));
        return ajax;
    }

    /**
     * 首页指定年月仓库入库明细占比
     *
     * @return 首页获取平均工作量数据
     */
    @GetMapping("/selectSysMessageCount")
    public AjaxResult selectSysMessageCount(SysMessage sysMessage) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        sysMessage.setMessageReceiver(userId+"");
        int sysMessageCount = iSysMessageService.selectSysMessageCount(sysMessage);
        AjaxResult ajax = AjaxResult.success(sysMessageCount);
        return ajax;
    }

    /**
     * 大屏首页右左屏数据
     */
    @Anonymous
    @GetMapping("/getLeftPageData")
    public AjaxResult getLeftPageData() throws IOException {
        JSONObject jsonObject=redisCache.getCacheObject(CacheConstants.BIG_GREEN_PAGE_DATA_KEY+"left_data");
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏首页右中间数据
     */
    @Anonymous
    @GetMapping("/getCenterPageData")
    public AjaxResult getCenterPageData() throws IOException {
        Map<String, Object> res =redisCache.getCacheObject(CacheConstants.BIG_GREEN_PAGE_DATA_KEY+"center_data");
        AjaxResult ajax = AjaxResult.success(res);
        return ajax;
    }

    /**
     * 大屏首页右侧数据
     */
    @Anonymous
    @GetMapping("/getRightPageData")
    public AjaxResult getRightPageData() throws IOException {
        JSONObject RightPageData=redisCache.getCacheObject(CacheConstants.BIG_GREEN_PAGE_DATA_KEY+"right_data");
        AjaxResult ajax = AjaxResult.success(RightPageData);
        return ajax;
    }



    /**
     * 大屏首页右侧数据
     */
    @Anonymous
    @GetMapping("/getRightPageDataC")
    public AjaxResult getRightPageDataC() throws IOException {
        List<Map> dataList = new ArrayList<>();

        List<Map> dataList2 = new ArrayList<>();
        List<Map> dataList3 = new ArrayList<>();

        InputStream inputStream = getClass().getResourceAsStream("/api/api.json");
        //ClassPathResource resource = new ClassPathResource("api/api.json");
        byte[] jsonData = FileCopyUtils.copyToByteArray(inputStream);
        //String jsonString = new String(jsonData);


        List<Incollectdata> IncollectdataList3=iIncollectdataService.getRightActiveRingData1C();
        if(IncollectdataList3.size()>0){
            for (int j = 0; j < IncollectdataList3.size(); j++) {
                Incollectdata colldata = IncollectdataList3.get(j);
                Map dataListchild = new HashMap();
                dataListchild.put("name",colldata.getData5());
                dataListchild.put("value",new BigDecimal(colldata.getData6()));
                dataList2.add(dataListchild);
            }
        }

        String jsonString = new String(jsonData,"UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        JSONObject RightPageData=jsonObject.getJSONObject("rightPageData");
        JSONObject userIdentityCategory=RightPageData.getJSONObject("userIdentityCategory");
        userIdentityCategory.remove("data");
        userIdentityCategory.put("data",dataList);


        JSONObject activeRingData=RightPageData.getJSONObject("activeRingData");
        activeRingData.remove("data");
        activeRingData.put("data",dataList2);

        JSONObject activeRingData2=RightPageData.getJSONObject("activeRingData2");
        activeRingData2.remove("data");
        activeRingData2.put("data",dataList3);

        AjaxResult ajax = AjaxResult.success(RightPageData);
        return ajax;
    }


    /**
     * 大屏首页右侧数据
     */
    @Anonymous
    @GetMapping("/getRightPageDataW")
    public AjaxResult getRightPageDataW() throws IOException {
        List<Map> dataList = new ArrayList<>();

        List<Map> dataList2 = new ArrayList<>();
        List<Map> dataList3 = new ArrayList<>();

        InputStream inputStream = getClass().getResourceAsStream("/api/api.json");
        //ClassPathResource resource = new ClassPathResource("api/api.json");
        byte[] jsonData = FileCopyUtils.copyToByteArray(inputStream);
        //String jsonString = new String(jsonData);



        List<Incollectdata> IncollectdataList3=iIncollectdataService.getRightActiveRingData1W();
        if(IncollectdataList3.size()>0){
            for (int j = 0; j < IncollectdataList3.size(); j++) {
                Incollectdata colldata = IncollectdataList3.get(j);
                Map dataListchild = new HashMap();
                dataListchild.put("name",colldata.getData5());
                dataListchild.put("value",new BigDecimal(colldata.getData6()));
                dataList2.add(dataListchild);
            }
        }




        String jsonString = new String(jsonData,"UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        JSONObject RightPageData=jsonObject.getJSONObject("rightPageData");
        JSONObject userIdentityCategory=RightPageData.getJSONObject("userIdentityCategory");
        userIdentityCategory.remove("data");
        userIdentityCategory.put("data",dataList);


        JSONObject activeRingData=RightPageData.getJSONObject("activeRingData");
        activeRingData.remove("data");
        activeRingData.put("data",dataList2);


        JSONObject activeRingData2=RightPageData.getJSONObject("activeRingData2");
        activeRingData2.remove("data");
        activeRingData2.put("data",dataList3);

        AjaxResult ajax = AjaxResult.success(RightPageData);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailData")
    public AjaxResult getShouHuoDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuo();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataMat")
    public AjaxResult getShouHuoDetailDataMat() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoMat();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataC")
    public AjaxResult getShouHuoDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataMatC")
    public AjaxResult getShouHuoDetailDataMatC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoMatC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataW")
    public AjaxResult getShouHuoDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataMatW")
    public AjaxResult getShouHuoDetailDataMatW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoMatW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailData")
    public AjaxResult getFaHuoDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuo();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataMat")
    public AjaxResult getFaHuoDetailDataMat() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoMat();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataC")
    public AjaxResult getFaHuoDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataMatC")
    public AjaxResult getFaHuoDetailDataMatC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoMatC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataW")
    public AjaxResult getFaHuoDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataMatW")
    public AjaxResult getFaHuoDetailDataMatW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoMatW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }




















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailData")
    public AjaxResult getTuiHuoDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuo();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataMat")
    public AjaxResult getTuiHuoDetailDataMat() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoMat();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataC")
    public AjaxResult getTuiHuoDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataMatC")
    public AjaxResult getTuiHuoDetailDataMatC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoMatC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataW")
    public AjaxResult getTuiHuoDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataMatW")
    public AjaxResult getTuiHuoDetailDataMatW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoMatW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChengsHuoDetailData")
    public AjaxResult getChengsHuoDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftChengshuo();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getChengsHuoDetailDataMat")
    public AjaxResult getChengsHuoDetailDataMat() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftChengshuoMat();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChengfHuoDetailData")
    public AjaxResult getChengfHuoDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftChengfhuo();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getChengfHuoDetailDataMat")
    public AjaxResult getChengfHuoDetailDataMat() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftChengfhuoMat();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }



















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailData")
    public AjaxResult getTuiKuDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuiku();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataMat")
    public AjaxResult getTuiKuDetailDataMat() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuMat();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataC")
    public AjaxResult getTuiKuDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataMatC")
    public AjaxResult getTuiKuDetailDataMatC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuMatC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataW")
    public AjaxResult getTuiKuDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataMatW")
    public AjaxResult getTuiKuDetailDataMatW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuMatW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoLvDetailData")
    public AjaxResult getShouHuoLvDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailshouhuolv();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);


        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);




        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("");
        con.setData4(year+"01");

        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getShouHuoLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData2());
                data1.add(colldata.getData7());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("接收时间",colldata.getData3());
                tableDownRow.put("签收时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("货物清点人",colldata.getData7());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");
        headerList.add("接收时间");
        headerList.add("签收时间");
        headerList.add("截止时间");
        headerList.add("供应商");
        headerList.add("货物清点人");
        headerList.add("统计月份");


        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoLvDetailDataC")
    public AjaxResult getShouHuoLvDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailshouhuolvC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);










        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("C");
        con.setData4(year+"01");

        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getShouHuoLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());

                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData2());
                data1.add(colldata.getData7());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("接收时间",colldata.getData3());
                tableDownRow.put("签收时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("货物清点人",colldata.getData7());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);

            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");
        headerList.add("接收时间");
        headerList.add("签收时间");
        headerList.add("截止时间");
        headerList.add("供应商");
        headerList.add("货物清点人");
        headerList.add("统计月份");


        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);


        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoLvDetailDataW")
    public AjaxResult getShouHuoLvDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailshouhuolvW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);









        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("W");
        con.setData4(year+"01");

        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getShouHuoLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());

                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData2());
                data1.add(colldata.getData7());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("接收时间",colldata.getData3());
                tableDownRow.put("签收时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("货物清点人",colldata.getData7());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");
        headerList.add("接收时间");
        headerList.add("签收时间");
        headerList.add("截止时间");
        headerList.add("供应商");
        headerList.add("货物清点人");
        headerList.add("统计月份");


        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);


        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoLvDetailDataTable")
    public AjaxResult getShouHuoLvDetailDataTable(String statMonth, String monthFlag,String roomflg,String statYear) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        String statMonth2=statMonth.substring(0,statMonth.length()-1);

        statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));

        Incollectdata con= new Incollectdata();
        con.setData1(monthFlag);
        con.setData2(statMonth);
        con.setData3(roomflg);
        con.setData4(statYear+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getShouHuoLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());

                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData2());
                data1.add(colldata.getData7());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("接收时间",colldata.getData3());
                tableDownRow.put("签收时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("货物清点人",colldata.getData7());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");
        headerList.add("接收时间");
        headerList.add("签收时间");
        headerList.add("截止时间");
        headerList.add("供应商");
        headerList.add("货物清点人");
        headerList.add("统计月份");


        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getBaoJianLvDetailData")
    public AjaxResult getBaoJianLvDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailbaojianlv();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);













        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("");
        con.setData4(year+"01");

        List<Map<String,String>> tableDown = new ArrayList<>();

        List<Incollectdata> IncollectdataList4=iIncollectdataService.getBaoJianLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData2());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("报检时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);

            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");

        headerList.add("报检时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("供应商");
        headerList.add("统计月份");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getBaoJianLvDetailDataC")
    public AjaxResult getSBaoJianLvDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailbaojianlvC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);




        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("C");
        con.setData4(year+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getBaoJianLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData2());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("报检时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");

        headerList.add("报检时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("供应商");
        headerList.add("统计月份");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getBaoJianLvDetailDataW")
    public AjaxResult getBaoJianLvDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailbaojianlvW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);










        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("W");
        con.setData4(year+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getBaoJianLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData2());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("报检时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");
        headerList.add("报检时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("供应商");
        headerList.add("统计月份");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getBaoJianLvDetailDataTable")
    public AjaxResult getBaoJianLvDetailDataTable(String statMonth, String monthFlag,String roomflg,String statYear) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        List<Map<String,String>> tableDown = new ArrayList<>();

        String statMonth2=statMonth.substring(0,statMonth.length()-1);

        statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));

        Incollectdata con= new Incollectdata();
        con.setData1(monthFlag);
        con.setData2(statMonth);
        con.setData3(roomflg);
        con.setData4((statMonth.substring(0,4))+"01");

        List<Incollectdata> IncollectdataList4=iIncollectdataService.getBaoJianLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData2());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("报检时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);

            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");
        headerList.add("报检时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("供应商");
        headerList.add("统计月份");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);

        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRuKuLvDetailData")
    public AjaxResult getRuKuLvDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailrukulv();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);






        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("");
        con.setData4(year+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getRuKuLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("入库单号",colldata.getData1());
                tableDownRow.put("来源单号",colldata.getData2());
                tableDownRow.put("创建时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("入库单号");
        headerList.add("来源单号");
        headerList.add("创建时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("统计月份");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);


        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRuKuLvDetailDataC")
    public AjaxResult getSRuKuLvDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailrukulvC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);





        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("C");
        con.setData4(year+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getRuKuLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("入库单号",colldata.getData1());
                tableDownRow.put("来源单号",colldata.getData2());
                tableDownRow.put("创建时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("入库单号");
        headerList.add("来源单号");
        headerList.add("创建时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("统计月份");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRuKuLvDetailDataW")
    public AjaxResult getRuKuLvDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailrukulvW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);




        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("W");
        con.setData4(year+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getRuKuLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("入库单号",colldata.getData1());
                tableDownRow.put("来源单号",colldata.getData2());
                tableDownRow.put("创建时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("入库单号");
        headerList.add("来源单号");
        headerList.add("创建时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("统计月份");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRuKuLvDetailDataTable")
    public AjaxResult getBRuKuLvDetailDataTable(String statMonth, String monthFlag,String roomflg,String statYear) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        String statMonth2=statMonth.substring(0,statMonth.length()-1);

        statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));

        Incollectdata con= new Incollectdata();
        con.setData1(monthFlag);
        con.setData2(statMonth);
        con.setData3(roomflg);
        con.setData4((statMonth.substring(0,4))+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getRuKuLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("入库单号",colldata.getData1());
                tableDownRow.put("来源单号",colldata.getData2());
                tableDownRow.put("创建时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("入库单号");
        headerList.add("来源单号");
        headerList.add("创建时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("统计月份");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }














    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuKuLvDetailData")
    public AjaxResult getChuKuLvDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailchukulv();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);


        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("");
        con.setData4(year+"01");
        con.setData4((statMonth.substring(0,4))+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getChuKuLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData7());
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add("");
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("出库凭证",colldata.getData7());
                tableDownRow.put("出库单号",colldata.getData1());
                tableDownRow.put("工单号",colldata.getData2());
                tableDownRow.put("执行时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDownRow.put("出库采集人","");
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("出库凭证");
        headerList.add("出库单号");
        headerList.add("工单号");
        headerList.add("执行时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("统计月份");
        headerList.add("出库采集人");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuKuLvDetailDataC")
    public AjaxResult getSChuKuLvDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailchukulvC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);


        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("C");
        con.setData4(year+"01");
        con.setData4((statMonth.substring(0,4))+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getChuKuLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData7());
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add("");
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("出库凭证",colldata.getData7());
                tableDownRow.put("出库单号",colldata.getData1());
                tableDownRow.put("工单号",colldata.getData2());
                tableDownRow.put("执行时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDownRow.put("出库采集人","");
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("出库凭证");
        headerList.add("出库单号");
        headerList.add("工单号");
        headerList.add("执行时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("统计月份");
        headerList.add("出库采集人");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuKuLvDetailDataW")
    public AjaxResult getChuKuLvDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailchukulvW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("W");
        con.setData4(year+"01");
        con.setData4((statMonth.substring(0,4))+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getChuKuLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData7());
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add("");


                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("出库凭证",colldata.getData7());
                tableDownRow.put("出库单号",colldata.getData1());
                tableDownRow.put("工单号",colldata.getData2());
                tableDownRow.put("执行时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDownRow.put("出库采集人","");
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("出库凭证");
        headerList.add("出库单号");
        headerList.add("工单号");
        headerList.add("执行时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("统计月份");
        headerList.add("出库采集人");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuKuLvDetailDataTable")
    public AjaxResult getBChuKuLvDetailDataTable(String statMonth, String monthFlag,String roomflg,String statYear) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        String statMonth2=statMonth.substring(0,statMonth.length()-1);

        statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));

        Incollectdata con= new Incollectdata();
        con.setData1(monthFlag);
        con.setData2(statMonth);
        con.setData3(roomflg);
        con.setData4((statMonth.substring(0,4))+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getChuKuLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData7());
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add("");


                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("出库凭证",colldata.getData7());
                tableDownRow.put("出库单号",colldata.getData1());
                tableDownRow.put("工单号",colldata.getData2());
                tableDownRow.put("执行时间",colldata.getData3());
                tableDownRow.put("审核时间",colldata.getData4());
                tableDownRow.put("截止时间",colldata.getData5());
                tableDownRow.put("统计月份",colldata.getData6());
                tableDownRow.put("出库采集人","");
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("出库凭证");
        headerList.add("出库单号");
        headerList.add("工单号");
        headerList.add("执行时间");
        headerList.add("审核时间");
        headerList.add("截止时间");
        headerList.add("统计月份");
        headerList.add("出库采集人");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }



















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getQiTaoLvDetailData")
    public AjaxResult getQiTaoLvDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailqitaolv();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("");
        con.setData4(year+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getQiTaoLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData6());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData7());
                data1.add(colldata.getQty().toString());
                data1.add(colldata.getData8());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("工单号",colldata.getData1());
                tableDownRow.put("执行时间",colldata.getData6());
                tableDownRow.put("需求（种类数）",colldata.getData2());
                tableDownRow.put("首批出库",colldata.getData3());
                tableDownRow.put("首批缺料",colldata.getData4());
                tableDownRow.put("首批齐套率",colldata.getData5());
                tableDownRow.put("已补出库",colldata.getData7());
                tableDownRow.put("当前缺料",colldata.getQty().toString());
                tableDownRow.put("当前齐套率",colldata.getData8());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("工单号");
        headerList.add("执行时间");
        headerList.add("需求（种类数）");
        headerList.add("首批出库");
        headerList.add("首批缺料");
        headerList.add("首批齐套率");
        headerList.add("已补出库");
        headerList.add("当前缺料");
        headerList.add("当前齐套率");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getQiTaoLvDetailDataC")
    public AjaxResult getQiTaoLvDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailqitaolvC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);


        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("C");
        con.setData4(year+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getQiTaoLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData6());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData7());
                data1.add(colldata.getQty().toString());
                data1.add(colldata.getData8());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("工单号",colldata.getData1());
                tableDownRow.put("执行时间",colldata.getData6());
                tableDownRow.put("需求（种类数）",colldata.getData2());
                tableDownRow.put("首批出库",colldata.getData3());
                tableDownRow.put("首批缺料",colldata.getData4());
                tableDownRow.put("首批齐套率",colldata.getData5());
                tableDownRow.put("已补出库",colldata.getData7());
                tableDownRow.put("当前缺料",colldata.getQty().toString());
                tableDownRow.put("当前齐套率",colldata.getData7());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("工单号");
        headerList.add("执行时间");
        headerList.add("需求（种类数）");
        headerList.add("首批出库");
        headerList.add("首批缺料");
        headerList.add("首批齐套率");
        headerList.add("已补出库");
        headerList.add("当前缺料");
        headerList.add("当前齐套率");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getQiTaoLvDetailDataW")
    public AjaxResult getQiTaoLvDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractDetailqitaolvW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String statMonth=String.format("%02d", month);
        statMonth=year+statMonth;

        Incollectdata con= new Incollectdata();
        con.setData1("M");
        con.setData2(statMonth);
        con.setData3("W");
        con.setData4(year+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getQiTaoLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData6());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData7());
                data1.add(colldata.getQty().toString());
                data1.add(colldata.getData8());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("工单号",colldata.getData1());
                tableDownRow.put("执行时间",colldata.getData6());
                tableDownRow.put("需求（种类数）",colldata.getData2());
                tableDownRow.put("首批出库",colldata.getData3());
                tableDownRow.put("首批缺料",colldata.getData4());
                tableDownRow.put("首批齐套率",colldata.getData5());
                tableDownRow.put("已补出库",colldata.getData7());
                tableDownRow.put("当前缺料",colldata.getQty().toString());
                tableDownRow.put("当前齐套率",colldata.getData7());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("工单号");
        headerList.add("执行时间");
        headerList.add("需求（种类数）");
        headerList.add("首批出库");
        headerList.add("首批缺料");
        headerList.add("首批齐套率");
        headerList.add("已补出库");
        headerList.add("当前缺料");
        headerList.add("当前齐套率");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getQiTaoLvDetailDataTable")
    public AjaxResult getQiTaoLvDetailDataTable(String statMonth, String monthFlag,String roomflg,String statYear) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        String statMonth2=statMonth.substring(0,statMonth.length()-1);

        statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));

        Incollectdata con= new Incollectdata();
        con.setData1(monthFlag);
        con.setData2(statMonth);
        con.setData3(roomflg);
        con.setData4((statMonth.substring(0,4))+"01");


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getQiTaoLvDetailDataTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData6());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());

                data1.add(colldata.getData7());
                data1.add(colldata.getQty().toString());
                data1.add(colldata.getData8());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("工单号",colldata.getData1());
                tableDownRow.put("执行时间",colldata.getData6());
                tableDownRow.put("需求（种类数）",colldata.getData2());
                tableDownRow.put("首批出库",colldata.getData3());
                tableDownRow.put("首批缺料",colldata.getData4());
                tableDownRow.put("首批齐套率",colldata.getData5());
                tableDownRow.put("已补出库",colldata.getData7());
                tableDownRow.put("当前缺料",colldata.getQty().toString());
                tableDownRow.put("当前齐套率",colldata.getData7());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("工单号");
        headerList.add("执行时间");
        headerList.add("需求（种类数）");
        headerList.add("首批出库");
        headerList.add("首批缺料");
        headerList.add("首批齐套率");
        headerList.add("已补出库");
        headerList.add("当前缺料");
        headerList.add("当前齐套率");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }




























    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoLvWeekDetailData")
    public AjaxResult getShouHuoLvWeekDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getShouHuoLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }

        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoLvWeekDetailDataC")
    public AjaxResult getShouHuoLvWeekDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getShouHuoLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }

        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoLvWeekDetailDataW")
    public AjaxResult getShouHuoLvWeekDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getShouHuoLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }

        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }













    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getBaoJianLvWeekDetailData")
    public AjaxResult getBaoJianLvWeekDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getBaoJianLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getBaoJianLvWeekDetailDataC")
    public AjaxResult getBaoJianLvWeekDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getBaoJianLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getBaoJianLvWeekDetailDataW")
    public AjaxResult getBaoJianLvWeekDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getBaoJianLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }












    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRuKuLvWeekDetailData")
    public AjaxResult getRuKuLvWeekDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getRuKuLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRuKuLvWeekDetailDataC")
    public AjaxResult getRuKuLvWeekDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getRuKuLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }



    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRuKuLvWeekDetailDataW")
    public AjaxResult getRuKuLvWeekDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getRuKuLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }













    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuKuLvWeekDetailData")
    public AjaxResult getChuKuLvWeekDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getChuKuLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuKuLvWeekDetailDataC")
    public AjaxResult getChuKuLvWeekDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getChuKuLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuKuLvWeekDetailDataW")
    public AjaxResult getChuKuLvWeekDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getChuKuLvWeekW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }





    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getQiTaoLvWeekDetailData")
    public AjaxResult getQiTaoLvWeekDetailData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getQitaoLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getQiTaoLvWeekDetailDataC")
    public AjaxResult getQiTaoLvWeekDetailDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getQitaoLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getQiTaoLvWeekDetailDataW")
    public AjaxResult getQiTaoLvWeekDetailDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getQitaoLvWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }















































    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataWeek")
    public AjaxResult getShouHuoDetailDataWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataMatWeek")
    public AjaxResult getShouHuoDetailDataMatWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoMatWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataWeekC")
    public AjaxResult getShouHuoDetailDataWeekC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoWeekC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataMatWeekC")
    public AjaxResult getShouHuoDetailDataMatWeekC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoMatWeekC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataWeekW")
    public AjaxResult getShouHuoDetailDataWeekW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoWeekW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getShouHuoDetailDataMatWeekW")
    public AjaxResult getShouHuoDetailDataMatWeekW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftShouhuoMatWeekW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataWeek")
    public AjaxResult getFaHuoDetailDataWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataMatWeek")
    public AjaxResult getFaHuoDetailDataMatWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoMatWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataWeekC")
    public AjaxResult getFaHuoDetailDataWeekC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoWeekC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataMatWeekC")
    public AjaxResult getFaHuoDetailDataMatWeekC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoMatWeekC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataWeekW")
    public AjaxResult getFaHuoDetailDataWeekW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoWeekW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getFaHuoDetailDataMatWeekW")
    public AjaxResult getFaHuoDetailDataMatWeekW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftFahuoMatWeekW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }




















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataWeek")
    public AjaxResult getTuiHuoDetailDataWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataMatWeek")
    public AjaxResult getTuiHuoDetailDataMatWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoMatWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataWeekC")
    public AjaxResult getTuiHuoDetailDataWeekC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoWeekC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataMatWeekC")
    public AjaxResult getTuiHuoDetailDataMatWeekC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoMatWeekC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataWeekW")
    public AjaxResult getTuiHuoDetailDataWeekW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoWeekW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiHuoDetailDataMatWeekW")
    public AjaxResult getTuiHuoDetailDataMatWeekW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuihuoMatWeekW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChengsHuoDetailDataWeek")
    public AjaxResult getChengsHuoDetailDataWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftChengshuoWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getChengsHuoDetailDataMatWeek")
    public AjaxResult getChengsHuoDetailDataMatWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftChengshuoMatWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChengfHuoDetailDataWeek")
    public AjaxResult getChengfHuoDetailDataWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftChengfhuoWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getChengfHuoDetailDataMatWeek")
    public AjaxResult getChengfHuoDetailDataMatWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftChengfhuoMatWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }



















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataWeek")
    public AjaxResult getTuiKuDetailDataWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataMatWeek")
    public AjaxResult getTuiKuDetailDataMatWeek() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuMatWeek();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataWeekC")
    public AjaxResult getTuiKuDetailDataWeekC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuWeekC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataMatWeekC")
    public AjaxResult getTuiKuDetailDataMatWeekC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuMatWeekC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataWeekW")
    public AjaxResult getTuiKuDetailDataWeekW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuWeekW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getTuiKuDetailDataMatWeekW")
    public AjaxResult getTuiKuDetailDataMatWeekW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series01_qty_ly = new ArrayList<String>();
        List<String> series02_qty_ly = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getAllLeftTuikuMatWeekW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                    series01_qty_ly.add(series01.get(i).getData4());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                    series02_qty_ly.add(series02.get(i).getData4());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                    series03_qty_ly.add(series03.get(i).getData4());
                }
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=53;i++){
            String weekSth=i+"";
            monthList.add(weekSth);
        }
        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("legend",yearList);
        linebarDataYear.put("series01_nm",yearList.get(0));
        linebarDataYear.put("series01_data_ly",series01_qty_ly);
        linebarDataYear.put("series02_nm",yearList.get(1));
        linebarDataYear.put("series02_data_ly",series02_qty_ly);
        linebarDataYear.put("series03_nm",yearList.get(2));
        linebarDataYear.put("series03_data_ly",series03_qty_ly);

        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getQitaoLvDetail")
    public AjaxResult getQitaoLvDetail(String sourceno) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getQitaoLvDetail(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("工单号",colldata.getData1());
                tableDownRow.put("物料编码",colldata.getData2());
                tableDownRow.put("物料名称",colldata.getData3());
                tableDownRow.put("需求数量",colldata.getData4());
                tableDownRow.put("已出库数量",colldata.getData5());
                tableDownRow.put("缺料数量",colldata.getData6());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("工单号");
        headerList.add("物料代码");
        headerList.add("物料名称");
        headerList.add("需求数量");
        headerList.add("已出库数量");
        headerList.add("缺料数量");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getQitaoLvDetail2")
    public AjaxResult getQitaoLvDetail2(String sourceno) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);



        List<Incollectdata> IncollectdataList4=iIncollectdataService.getQitaoLvDetail2(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                dataList.add(data1);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("工单号");
        headerList.add("物料代码");
        headerList.add("物料名称");
        headerList.add("需求数量");
        headerList.add("已出库数量");
        headerList.add("缺料数量");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }































































    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuRukuDetailDataIn")
    public AjaxResult getChuRukuDetailDataIn() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getractIndexLeftinDetail();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                series03_qty.add(colldata.getData5());
                series03_qty_ly.add(colldata.getData6());
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        monthList.add("08");
        monthList.add("09");
        monthList.add("10");
        monthList.add("11");
        monthList.add("12");
        monthList.add("13");
        monthList.add("14");
        monthList.add("15");
        monthList.add("16");
        monthList.add("17");
        monthList.add("18");

        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("series03_data_ly",series03_qty_ly);
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getChuRukuDetailDataOut")
    public AjaxResult getChuRukuDetailDataOut() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getractIndexLeftoutDetail();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                series03_qty.add(colldata.getData5());
                series03_qty_ly.add(colldata.getData6());
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        monthList.add("08");
        monthList.add("09");
        monthList.add("10");
        monthList.add("11");
        monthList.add("12");
        monthList.add("13");
        monthList.add("14");
        monthList.add("15");
        monthList.add("16");
        monthList.add("17");
        monthList.add("18");

        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("series03_data_ly",series03_qty_ly);
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuRukuDetailDataInC")
    public AjaxResult getChuRukuDetailDataInC() throws IOException {

        List<String> yearList = new ArrayList<>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getractIndexLeftinDetailC();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                series03_qty.add(colldata.getData5());
                series03_qty_ly.add(colldata.getData6());
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        monthList.add("08");
        monthList.add("09");
        monthList.add("10");
        monthList.add("11");
        monthList.add("12");
        monthList.add("13");
        monthList.add("14");
        monthList.add("15");
        monthList.add("16");
        monthList.add("17");
        monthList.add("18");

        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("series03_data_ly",series03_qty_ly);
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getChuRukuDetailDataOutC")
    public AjaxResult getChuRukuDetailDataOutC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getractIndexLeftoutDetailC();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                series03_qty.add(colldata.getData5());
                series03_qty_ly.add(colldata.getData6());
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        monthList.add("08");
        monthList.add("09");
        monthList.add("10");
        monthList.add("11");
        monthList.add("12");
        monthList.add("13");
        monthList.add("14");
        monthList.add("15");
        monthList.add("16");
        monthList.add("17");
        monthList.add("18");

        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("series03_data_ly",series03_qty_ly);
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuRukuDetailDataInW")
    public AjaxResult getChuRukuDetailDataInW() throws IOException {

        List<String> yearList = new ArrayList<>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getractIndexLeftinDetailW();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                series03_qty.add(colldata.getData5());
                series03_qty_ly.add(colldata.getData6());
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        monthList.add("08");
        monthList.add("09");
        monthList.add("10");
        monthList.add("11");
        monthList.add("12");
        monthList.add("13");
        monthList.add("14");
        monthList.add("15");
        monthList.add("16");
        monthList.add("17");
        monthList.add("18");

        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("series03_data_ly",series03_qty_ly);
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**
     * 大屏收货明细数据-种类
     */
    @Anonymous
    @GetMapping("/getChuRukuDetailDataOutW")
    public AjaxResult getChuRukuDetailDataOutW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series03_qty_ly = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getractIndexLeftoutDetailW();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                series03_qty.add(colldata.getData5());
                series03_qty_ly.add(colldata.getData6());
            }
        }

        Map<String, Object> linebarData = new HashMap<>();
        Map<String, Object> linebarDataYear = new HashMap<>();

        List<String> monthList= new ArrayList<>();
        monthList.add("08");
        monthList.add("09");
        monthList.add("10");
        monthList.add("11");
        monthList.add("12");
        monthList.add("13");
        monthList.add("14");
        monthList.add("15");
        monthList.add("16");
        monthList.add("17");
        monthList.add("18");

        linebarDataYear.put("xAxis",monthList);
        linebarData.put("xAxis",monthList);

        linebarDataYear.put("series03_data_ly",series03_qty_ly);
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("linebarDataYear",linebarDataYear);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }




    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRohAgingDetailData")
    public AjaxResult getRohAgingDetailData(String sourceno) throws IOException {
        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);

        List<Map> dataList = new ArrayList<>();
        InputStream inputStream = getClass().getResourceAsStream("/api/api.json");
        byte[] jsonData = FileCopyUtils.copyToByteArray(inputStream);
        List<Incollectdata> IncollectdataList2=iIncollectdataService.getRohAgingDetailData(con);
        if(IncollectdataList2.size()>0){
            for (int j = 0; j < IncollectdataList2.size(); j++) {
                Incollectdata colldata = IncollectdataList2.get(j);
                Map dataListchild = new HashMap();
                dataListchild.put("name",colldata.getData5());
                dataListchild.put("value",colldata.getData6());
                dataList.add(dataListchild);
            }
        }

        String jsonString = new String(jsonData,"UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        JSONObject RightPageData=jsonObject.getJSONObject("rightPageData");
        JSONObject userIdentityCategory=RightPageData.getJSONObject("userIdentityCategory");
        userIdentityCategory.remove("data");
        userIdentityCategory.put("data",dataList);

        AjaxResult ajax = AjaxResult.success(RightPageData);
        return ajax;


    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRohAgingDetailDataC")
    public AjaxResult getRohAgingDetailDataC(String sourceno) throws IOException {
        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);

        List<Map> dataList = new ArrayList<>();
        InputStream inputStream = getClass().getResourceAsStream("/api/api.json");
        byte[] jsonData = FileCopyUtils.copyToByteArray(inputStream);
        List<Incollectdata> IncollectdataList2=iIncollectdataService.getRohAgingDetailDataC(con);
        if(IncollectdataList2.size()>0){
            for (int j = 0; j < IncollectdataList2.size(); j++) {
                Incollectdata colldata = IncollectdataList2.get(j);
                Map dataListchild = new HashMap();
                dataListchild.put("name",colldata.getData5());
                dataListchild.put("value",colldata.getData6());
                dataList.add(dataListchild);
            }
        }

        String jsonString = new String(jsonData,"UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        JSONObject RightPageData=jsonObject.getJSONObject("rightPageData");
        JSONObject userIdentityCategory=RightPageData.getJSONObject("userIdentityCategory");
        userIdentityCategory.remove("data");
        userIdentityCategory.put("data",dataList);

        AjaxResult ajax = AjaxResult.success(RightPageData);
        return ajax;


    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRohAgingDetailDataW")
    public AjaxResult getRohAgingDetailDataW(String sourceno) throws IOException {
        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);

        List<Map> dataList = new ArrayList<>();
        InputStream inputStream = getClass().getResourceAsStream("/api/api.json");
        byte[] jsonData = FileCopyUtils.copyToByteArray(inputStream);
        List<Incollectdata> IncollectdataList2=iIncollectdataService.getRohAgingDetailDataW(con);
        if(IncollectdataList2.size()>0){
            for (int j = 0; j < IncollectdataList2.size(); j++) {
                Incollectdata colldata = IncollectdataList2.get(j);
                Map dataListchild = new HashMap();
                dataListchild.put("name",colldata.getData5());
                dataListchild.put("value",colldata.getData6());
                dataList.add(dataListchild);
            }
        }

        String jsonString = new String(jsonData,"UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        JSONObject RightPageData=jsonObject.getJSONObject("rightPageData");
        JSONObject userIdentityCategory=RightPageData.getJSONObject("userIdentityCategory");
        userIdentityCategory.remove("data");
        userIdentityCategory.put("data",dataList);

        AjaxResult ajax = AjaxResult.success(RightPageData);
        return ajax;


    }





    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getReAgingDetailData")
    public AjaxResult getReAgingDetailData(String sourceno) throws IOException {
        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);

        List<Map> dataList = new ArrayList<>();
        InputStream inputStream = getClass().getResourceAsStream("/api/api.json");
        byte[] jsonData = FileCopyUtils.copyToByteArray(inputStream);
        List<Incollectdata> IncollectdataList2=iIncollectdataService.getReAgingDetailData(con);
        if(IncollectdataList2.size()>0){
            for (int j = 0; j < IncollectdataList2.size(); j++) {
                Incollectdata colldata = IncollectdataList2.get(j);
                Map dataListchild = new HashMap();
                dataListchild.put("name",colldata.getData5());
                dataListchild.put("value",colldata.getData6());
                dataList.add(dataListchild);
            }
        }

        String jsonString = new String(jsonData,"UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        JSONObject RightPageData=jsonObject.getJSONObject("rightPageData");
        JSONObject userIdentityCategory=RightPageData.getJSONObject("userIdentityCategory");
        userIdentityCategory.remove("data");
        userIdentityCategory.put("data",dataList);

        AjaxResult ajax = AjaxResult.success(RightPageData);
        return ajax;


    }























    /**帐帐匹配率月度数据*/
    /**
     * 大屏二级页面
     */
    @Anonymous
    @GetMapping("/getPiPeiLvMonthData")
    public AjaxResult getPiPeiLvMonthData() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getPiPeiLvMonthData();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                }
            }
        }



        List<String> seriesData = new ArrayList<String>();
        List<String> dayList= new ArrayList<>();
        Incollectdata con2= new Incollectdata();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        String data1a=dateFormat.format(new Date());
        String newStr = data1a.replace("-", "");

        con2.setData1(newStr);

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getPiPeiLvMonthDayData(con2);
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList3.size(); i++){
                dayList.add(IncollectdataList3.get(i).getData1());
                seriesData.add(IncollectdataList3.get(i).getData3());
            }
        }
        Map<String, Object> linebarDayData = new HashMap<>();
        linebarDayData.put("xAxis",dayList);
        linebarDayData.put("series_data",seriesData);


        List<List<String>> dataDetailList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();


        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String data1a2=dateFormat2.format(new Date());
        String newStr2 = data1a2.replace("-", "");

        Incollectdata con1= new Incollectdata();
        con1.setData1(newStr2);
        List<Map<String,String>> tableDown = new ArrayList<>();

        List<Incollectdata> IncollectdataList5=iIncollectdataService.getPiPeiLvMonthDayDetailData(con1);
        if(IncollectdataList5.size()>0){
            for (int j = 0; j < IncollectdataList5.size(); j++) {
                Incollectdata colldata = IncollectdataList5.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());

                data1.add(colldata.getDifference_reason());
                data1.add(colldata.getReason_proper());
                data1.add(colldata.getReason_category());
                data1.add(colldata.getFirst_date());

                dataDetailList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("统计日期",colldata.getData1());
                tableDownRow.put("子库",colldata.getData2());
                tableDownRow.put("物料编码",colldata.getData3());
                tableDownRow.put("物料名称",colldata.getData4());
                tableDownRow.put("sap数量",colldata.getData5());
                tableDownRow.put("wms数量",colldata.getData6());
                tableDownRow.put("差异数量",colldata.getData7());

                tableDownRow.put("差异原因",colldata.getDifference_reason());
                tableDownRow.put("是否历史问题",colldata.getReason_proper());
                tableDownRow.put("差异分类",colldata.getReason_category());
                tableDownRow.put("首次出现日期",colldata.getFirst_date());

                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("统计日期");
        headerList.add("子库");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("sap数量");
        headerList.add("wms数量");
        headerList.add("差异数量");

        headerList.add("差异原因");
        headerList.add("是否历史问题");
        headerList.add("差异分类");
        headerList.add("首次出现日期");

        userSitua.put("data",dataDetailList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        Map<String, Object> linebarData = new HashMap<>();
        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarData.put("xAxis",monthList);
        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarDayData",linebarDayData);
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }



    /**帐帐匹配率天数据*/
    /**
     * 大屏二级页面
     */
    @Anonymous
    @GetMapping("/getPiPeiLvMonthDayData")
    public AjaxResult getPiPeiLvMonthDayData(String statMonth,String statYear) throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();


        String statMonth2=statMonth.substring(0,statMonth.length()-1);

        statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));

        List<String> seriesData = new ArrayList<String>();
        List<String> dayList= new ArrayList<>();
        Incollectdata con2= new Incollectdata();
        con2.setData1(statMonth);

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getPiPeiLvMonthDayData(con2);
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList3.size(); i++){
                dayList.add(IncollectdataList3.get(i).getData1());
                seriesData.add(IncollectdataList3.get(i).getData3());
            }
        }
        Map<String, Object> linebarDayData = new HashMap<>();
        linebarDayData.put("xAxis",dayList);
        linebarDayData.put("series_data",seriesData);


        List<List<String>> dataDetailList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();
        Incollectdata con1= new Incollectdata();
        con1.setData1(statMonth+"01");
        List<Map<String,String>> tableDown = new ArrayList<>();

        List<Incollectdata> IncollectdataList5=iIncollectdataService.getPiPeiLvMonthDayDetailData(con1);
        if(IncollectdataList5.size()>0){
            for (int j = 0; j < IncollectdataList5.size(); j++) {
                Incollectdata colldata = IncollectdataList5.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());
                data1.add(colldata.getData8());


                data1.add(colldata.getDifference_reason());
                data1.add(colldata.getReason_proper());
                data1.add(colldata.getReason_category());
                data1.add(colldata.getFirst_date());


                dataDetailList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("统计日期",colldata.getData1());
                tableDownRow.put("子库",colldata.getData2());
                tableDownRow.put("物料编码",colldata.getData3());
                tableDownRow.put("物料名称",colldata.getData4());
                tableDownRow.put("sap数量",colldata.getData5());
                tableDownRow.put("wms数量",colldata.getData6());
                tableDownRow.put("差异数量",colldata.getData7());

                tableDownRow.put("差异原因",colldata.getDifference_reason());
                tableDownRow.put("是否历史问题",colldata.getReason_proper());
                tableDownRow.put("差异分类",colldata.getReason_category());
                tableDownRow.put("首次出现日期",colldata.getFirst_date());

                //year_id
                //month_id
                //storeroomname
                //indesc
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("统计日期");
        headerList.add("子库");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("sap数量");
        headerList.add("wms数量");
        headerList.add("计算时间");

        headerList.add("差异原因");
        headerList.add("是否历史问题");
        headerList.add("差异分类");
        headerList.add("首次出现日期");

        userSitua.put("data",dataDetailList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarDayData",linebarDayData);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**帐帐匹配率天明细数据*/
    /**
     * 大屏二级页面
     */
    @Anonymous
    @GetMapping("/getPiPeiLvMonthDayDetailData")
    public AjaxResult getPiPeiLvMonthDayDetailData(String statdate,String statMonth,String statYear) throws IOException {
        List<List<String>> dataDetailList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con1= new Incollectdata();
        if(statMonth!="" && statYear!=""){
            String statMonth2=statMonth.substring(0,statMonth.length()-1);
            statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));
            con1.setData1(statMonth+statdate);
        }else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            String data1a=dateFormat.format(new Date());
            String newStr = data1a.replace("-", "");
            con1.setData1(newStr+statdate);
        }

        List<Incollectdata> IncollectdataList5=iIncollectdataService.getPiPeiLvMonthDayDetailData(con1);
        if(IncollectdataList5.size()>0){
            for (int j = 0; j < IncollectdataList5.size(); j++) {
                Incollectdata colldata = IncollectdataList5.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());

                data1.add(colldata.getDifference_reason());
                data1.add(colldata.getReason_proper());
                data1.add(colldata.getReason_category());
                data1.add(colldata.getFirst_date());
                dataDetailList.add(data1);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("统计日期");
        headerList.add("子库");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("sap数量");
        headerList.add("wms数量");
        headerList.add("计算时间");

        headerList.add("差异原因");
        headerList.add("是否历史问题");
        headerList.add("差异分类");
        headerList.add("首次出现日期");


        userSitua.put("data",dataDetailList);
        userSitua.put("header",headerList);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }






















    /**帐帐匹配率月度数据*/
    /**
     * 大屏二级页面
     */
    @Anonymous
    @GetMapping("/getPiPeiLvMonthDataC")
    public AjaxResult getPiPeiLvMonthDataC() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getPiPeiLvMonthDataC();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                }
            }
        }



        List<String> seriesData = new ArrayList<String>();
        List<String> dayList= new ArrayList<>();
        Incollectdata con2= new Incollectdata();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        String data1a=dateFormat.format(new Date());
        String newStr = data1a.replace("-", "");

        con2.setData1(newStr);

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getPiPeiLvMonthDayDataC(con2);
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList3.size(); i++){
                dayList.add(IncollectdataList3.get(i).getData1());
                seriesData.add(IncollectdataList3.get(i).getData3());
            }
        }
        Map<String, Object> linebarDayData = new HashMap<>();
        linebarDayData.put("xAxis",dayList);
        linebarDayData.put("series_data",seriesData);


        List<List<String>> dataDetailList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();


        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String data1a2=dateFormat2.format(new Date());
        String newStr2 = data1a2.replace("-", "");

        Incollectdata con1= new Incollectdata();
        con1.setData1(newStr2);
        List<Map<String,String>> tableDown = new ArrayList<>();

        List<Incollectdata> IncollectdataList5=iIncollectdataService.getPiPeiLvMonthDayDetailDataC(con1);
        if(IncollectdataList5.size()>0){
            for (int j = 0; j < IncollectdataList5.size(); j++) {
                Incollectdata colldata = IncollectdataList5.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());

                data1.add(colldata.getDifference_reason());
                data1.add(colldata.getReason_proper());
                data1.add(colldata.getReason_category());
                data1.add(colldata.getFirst_date());

                dataDetailList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("统计日期",colldata.getData1());
                tableDownRow.put("子库",colldata.getData2());
                tableDownRow.put("物料编码",colldata.getData3());
                tableDownRow.put("物料名称",colldata.getData4());
                tableDownRow.put("sap数量",colldata.getData5());
                tableDownRow.put("wms数量",colldata.getData6());
                tableDownRow.put("差异数量",colldata.getData7());

                tableDownRow.put("差异原因",colldata.getDifference_reason());
                tableDownRow.put("是否历史问题",colldata.getReason_proper());
                tableDownRow.put("差异分类",colldata.getReason_category());
                tableDownRow.put("首次出现日期",colldata.getFirst_date());

                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("统计日期");
        headerList.add("子库");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("sap数量");
        headerList.add("wms数量");
        headerList.add("差异数量");
        headerList.add("差异原因");
        headerList.add("是否历史问题");
        headerList.add("差异分类");
        headerList.add("首次出现日期");
        userSitua.put("data",dataDetailList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        Map<String, Object> linebarData = new HashMap<>();
        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarData.put("xAxis",monthList);
        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarDayData",linebarDayData);
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }



    /**帐帐匹配率天数据*/
    /**
     * 大屏二级页面
     */
    @Anonymous
    @GetMapping("/getPiPeiLvMonthDayDataC")
    public AjaxResult getPiPeiLvMonthDayDataC(String statMonth,String statYear) throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();


        String statMonth2=statMonth.substring(0,statMonth.length()-1);

        statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));

        List<String> seriesData = new ArrayList<String>();
        List<String> dayList= new ArrayList<>();
        Incollectdata con2= new Incollectdata();
        con2.setData1(statMonth);

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getPiPeiLvMonthDayDataC(con2);
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList3.size(); i++){
                dayList.add(IncollectdataList3.get(i).getData1());
                seriesData.add(IncollectdataList3.get(i).getData3());
            }
        }
        Map<String, Object> linebarDayData = new HashMap<>();
        linebarDayData.put("xAxis",dayList);
        linebarDayData.put("series_data",seriesData);


        List<List<String>> dataDetailList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();
        Incollectdata con1= new Incollectdata();
        con1.setData1(statMonth+"01");
        List<Map<String,String>> tableDown = new ArrayList<>();

        List<Incollectdata> IncollectdataList5=iIncollectdataService.getPiPeiLvMonthDayDetailDataC(con1);
        if(IncollectdataList5.size()>0){
            for (int j = 0; j < IncollectdataList5.size(); j++) {
                Incollectdata colldata = IncollectdataList5.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());
                data1.add(colldata.getData8());

                data1.add(colldata.getDifference_reason());
                data1.add(colldata.getReason_proper());
                data1.add(colldata.getReason_category());
                data1.add(colldata.getFirst_date());

                dataDetailList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("统计日期",colldata.getData1());
                tableDownRow.put("子库",colldata.getData2());
                tableDownRow.put("物料编码",colldata.getData3());
                tableDownRow.put("物料名称",colldata.getData4());
                tableDownRow.put("sap数量",colldata.getData5());
                tableDownRow.put("wms数量",colldata.getData6());
                tableDownRow.put("差异数量",colldata.getData7());

                tableDownRow.put("差异原因",colldata.getDifference_reason());
                tableDownRow.put("是否历史问题",colldata.getReason_proper());
                tableDownRow.put("差异分类",colldata.getReason_category());
                tableDownRow.put("首次出现日期",colldata.getFirst_date());

                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("统计日期");
        headerList.add("子库");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("sap数量");
        headerList.add("wms数量");
        headerList.add("计算时间");

        headerList.add("差异原因");
        headerList.add("是否历史问题");
        headerList.add("差异分类");
        headerList.add("首次出现日期");

        userSitua.put("data",dataDetailList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarDayData",linebarDayData);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**帐帐匹配率天明细数据*/
    /**
     * 大屏二级页面
     */
    @Anonymous
    @GetMapping("/getPiPeiLvMonthDayDetailDataC")
    public AjaxResult getPiPeiLvMonthDayDetailDataC(String statdate,String statMonth,String statYear) throws IOException {
        List<List<String>> dataDetailList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con1= new Incollectdata();
        if(statMonth!="" && statYear!=""){
            String statMonth2=statMonth.substring(0,statMonth.length()-1);
            statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));
            con1.setData1(statMonth+statdate);
        }else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            String data1a=dateFormat.format(new Date());
            String newStr = data1a.replace("-", "");
            con1.setData1(newStr+statdate);
        }

        List<Incollectdata> IncollectdataList5=iIncollectdataService.getPiPeiLvMonthDayDetailDataC(con1);
        if(IncollectdataList5.size()>0){
            for (int j = 0; j < IncollectdataList5.size(); j++) {
                Incollectdata colldata = IncollectdataList5.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());

                data1.add(colldata.getDifference_reason());
                data1.add(colldata.getReason_proper());
                data1.add(colldata.getReason_category());
                data1.add(colldata.getFirst_date());

                dataDetailList.add(data1);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("统计日期");
        headerList.add("子库");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("sap数量");
        headerList.add("wms数量");
        headerList.add("计算时间");

        headerList.add("差异原因");
        headerList.add("是否历史问题");
        headerList.add("差异分类");
        headerList.add("首次出现日期");

        userSitua.put("data",dataDetailList);
        userSitua.put("header",headerList);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }









    /**帐帐匹配率月度数据*/
    /**
     * 大屏二级页面
     */
    @Anonymous
    @GetMapping("/getPiPeiLvMonthDataW")
    public AjaxResult getPiPeiLvMonthDataW() throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();

        List<Incollectdata> IncollectdataList=iIncollectdataService.getStatyear();
        if(IncollectdataList.size()>0){
            for (int j = 0; j < IncollectdataList.size(); j++) {
                Incollectdata colldata = IncollectdataList.get(j);
                yearList.add(colldata.getData5());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getPiPeiLvMonthDataW();
        if(IncollectdataList2.size()>0){
            String statyear  = yearList.get(0);
            List <Incollectdata> series01 =IncollectdataList2.stream().filter(item->statyear.equals(item.getData1())).collect(Collectors.toList());
            if(series01.size()>0){
                for(int i = 0; i < series01.size(); i++){
                    series01_qty.add(series01.get(i).getData3());
                }
            }

            String statyear2  = yearList.get(1);
            List <Incollectdata> series02 =IncollectdataList2.stream().filter(item->statyear2.equals(item.getData1())).collect(Collectors.toList());
            if(series02.size()>0){
                for(int i = 0; i < series02.size(); i++){
                    series02_qty.add(series02.get(i).getData3());
                }
            }

            String statyear3  = yearList.get(2);
            List <Incollectdata> series03 =IncollectdataList2.stream().filter(item->statyear3.equals(item.getData1())).collect(Collectors.toList());
            if(series03.size()>0){
                for(int i = 0; i < series03.size(); i++){
                    series03_qty.add(series03.get(i).getData3());
                }
            }
        }



        List<String> seriesData = new ArrayList<String>();
        List<String> dayList= new ArrayList<>();
        Incollectdata con2= new Incollectdata();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        String data1a=dateFormat.format(new Date());
        String newStr = data1a.replace("-", "");

        con2.setData1(newStr);

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getPiPeiLvMonthDayDataW(con2);
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList3.size(); i++){
                dayList.add(IncollectdataList3.get(i).getData1());
                seriesData.add(IncollectdataList3.get(i).getData3());
            }
        }
        Map<String, Object> linebarDayData = new HashMap<>();
        linebarDayData.put("xAxis",dayList);
        linebarDayData.put("series_data",seriesData);


        List<List<String>> dataDetailList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();


        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String data1a2=dateFormat2.format(new Date());
        String newStr2 = data1a2.replace("-", "");

        Incollectdata con1= new Incollectdata();
        con1.setData1(newStr2);
        List<Map<String,String>> tableDown = new ArrayList<>();

        List<Incollectdata> IncollectdataList5=iIncollectdataService.getPiPeiLvMonthDayDetailDataW(con1);
        if(IncollectdataList5.size()>0){
            for (int j = 0; j < IncollectdataList5.size(); j++) {
                Incollectdata colldata = IncollectdataList5.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());

                data1.add(colldata.getDifference_reason());
                data1.add(colldata.getReason_proper());
                data1.add(colldata.getReason_category());
                data1.add(colldata.getFirst_date());

                dataDetailList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("统计日期",colldata.getData1());
                tableDownRow.put("子库",colldata.getData2());
                tableDownRow.put("物料编码",colldata.getData3());
                tableDownRow.put("物料名称",colldata.getData4());
                tableDownRow.put("sap数量",colldata.getData5());
                tableDownRow.put("wms数量",colldata.getData6());
                tableDownRow.put("差异数量",colldata.getData7());

                tableDownRow.put("差异原因",colldata.getDifference_reason());
                tableDownRow.put("是否历史问题",colldata.getReason_proper());
                tableDownRow.put("差异分类",colldata.getReason_category());
                tableDownRow.put("首次出现日期",colldata.getFirst_date());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("统计日期");
        headerList.add("子库");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("sap数量");
        headerList.add("wms数量");
        headerList.add("差异数量");

        headerList.add("差异原因");
        headerList.add("是否历史问题");
        headerList.add("差异分类");
        headerList.add("首次出现日期");

        userSitua.put("data",dataDetailList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        Map<String, Object> linebarData = new HashMap<>();
        List<String> monthList= new ArrayList<>();
        for(int i=1;i<=12;i++){
            String monthSth=i+"月";
            monthList.add(monthSth);
        }
        linebarData.put("xAxis",monthList);
        linebarData.put("legend",yearList);
        linebarData.put("series01_nm",yearList.get(0));
        linebarData.put("series01_data",series01_qty);
        linebarData.put("series02_nm",yearList.get(1));
        linebarData.put("series02_data",series02_qty);
        linebarData.put("series03_nm",yearList.get(2));
        linebarData.put("series03_data",series03_qty);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarDayData",linebarDayData);
        jsonObject.put("linebarData",linebarData);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }



    /**帐帐匹配率天数据*/
    /**
     * 大屏二级页面
     */
    @Anonymous
    @GetMapping("/getPiPeiLvMonthDayDataW")
    public AjaxResult getPiPeiLvMonthDayDataW(String statMonth,String statYear) throws IOException {
        List<String> yearList = new ArrayList<>();
        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();


        String statMonth2=statMonth.substring(0,statMonth.length()-1);

        statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));

        List<String> seriesData = new ArrayList<String>();
        List<String> dayList= new ArrayList<>();
        Incollectdata con2= new Incollectdata();
        con2.setData1(statMonth);

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getPiPeiLvMonthDayDataW(con2);
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList3.size(); i++){
                dayList.add(IncollectdataList3.get(i).getData1());
                seriesData.add(IncollectdataList3.get(i).getData3());
            }
        }
        Map<String, Object> linebarDayData = new HashMap<>();
        linebarDayData.put("xAxis",dayList);
        linebarDayData.put("series_data",seriesData);


        List<List<String>> dataDetailList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();
        Incollectdata con1= new Incollectdata();
        con1.setData1(statMonth+"01");
        List<Map<String,String>> tableDown = new ArrayList<>();

        List<Incollectdata> IncollectdataList5=iIncollectdataService.getPiPeiLvMonthDayDetailDataW(con1);
        if(IncollectdataList5.size()>0){
            for (int j = 0; j < IncollectdataList5.size(); j++) {
                Incollectdata colldata = IncollectdataList5.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());
                data1.add(colldata.getData8());

                data1.add(colldata.getDifference_reason());
                data1.add(colldata.getReason_proper());
                data1.add(colldata.getReason_category());
                data1.add(colldata.getFirst_date());

                dataDetailList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("统计日期",colldata.getData1());
                tableDownRow.put("子库",colldata.getData2());
                tableDownRow.put("物料编码",colldata.getData3());
                tableDownRow.put("物料名称",colldata.getData4());
                tableDownRow.put("sap数量",colldata.getData5());
                tableDownRow.put("wms数量",colldata.getData6());
                tableDownRow.put("差异数量",colldata.getData7());

                tableDownRow.put("差异原因",colldata.getDifference_reason());
                tableDownRow.put("是否历史问题",colldata.getReason_proper());
                tableDownRow.put("差异分类",colldata.getReason_category());
                tableDownRow.put("首次出现日期",colldata.getFirst_date());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("统计日期");
        headerList.add("子库");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("sap数量");
        headerList.add("wms数量");
        headerList.add("计算时间");

        headerList.add("差异原因");
        headerList.add("是否历史问题");
        headerList.add("差异分类");
        headerList.add("首次出现日期");

        userSitua.put("data",dataDetailList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarDayData",linebarDayData);
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }


    /**帐帐匹配率天明细数据*/
    /**
     * 大屏二级页面
     */
    @Anonymous
    @GetMapping("/getPiPeiLvMonthDayDetailDataW")
    public AjaxResult getPiPeiLvMonthDayDetailDataW(String statdate,String statMonth,String statYear) throws IOException {
        List<List<String>> dataDetailList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con1= new Incollectdata();
        if(statMonth!="" && statYear!=""){
            String statMonth2=statMonth.substring(0,statMonth.length()-1);
            statMonth=statYear+(String.format("%02d", Integer.parseInt(statMonth2)));
            con1.setData1(statMonth+statdate);
        }else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            String data1a=dateFormat.format(new Date());
            String newStr = data1a.replace("-", "");
            con1.setData1(newStr+statdate);
        }

        List<Incollectdata> IncollectdataList5=iIncollectdataService.getPiPeiLvMonthDayDetailDataW(con1);
        if(IncollectdataList5.size()>0){
            for (int j = 0; j < IncollectdataList5.size(); j++) {
                Incollectdata colldata = IncollectdataList5.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());

                data1.add(colldata.getDifference_reason());
                data1.add(colldata.getReason_proper());
                data1.add(colldata.getReason_category());
                data1.add(colldata.getFirst_date());

                dataDetailList.add(data1);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("统计日期");
        headerList.add("子库");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("sap数量");
        headerList.add("wms数量");
        headerList.add("计算时间");

        headerList.add("差异原因");
        headerList.add("是否历史问题");
        headerList.add("差异分类");
        headerList.add("首次出现日期");

        userSitua.put("data",dataDetailList);
        userSitua.put("header",headerList);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }























    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getInOutQtyDetailData")
    public AjaxResult getInOutQtyDetailData() throws IOException {
        List<String> legendList = new ArrayList<>();

        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series04_qty = new ArrayList<String>();


        List<String> series01_mat = new ArrayList<String>();
        List<String> series02_mat = new ArrayList<String>();
        List<String> series03_mat = new ArrayList<String>();
        List<String> series04_mat = new ArrayList<String>();

        List<String> series01_xAxis = new ArrayList<String>();
        List<String> series02_xAxis = new ArrayList<String>();
        List<String> series03_xAxis = new ArrayList<String>();
        List<String> series04_xAxis = new ArrayList<String>();

        List<Incollectdata> IncollectdataList1=iIncollectdataService.getInOutQtyDetailDataYear();
        if(IncollectdataList1.size()>0){
            for(int i = 0; i < IncollectdataList1.size(); i++){
                series01_xAxis.add(IncollectdataList1.get(i).getData1()+'年');
                series01_mat.add(IncollectdataList1.get(i).getData2());
                series01_qty.add(IncollectdataList1.get(i).getData3());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getInOutQtyDetailDataMonth();
        if(IncollectdataList2.size()>0){
            for(int i = 0; i < IncollectdataList2.size(); i++){
                String strMonth=IncollectdataList2.get(i).getData2();
                String strMonth2=strMonth.substring(4,strMonth.length());
                series02_xAxis.add(strMonth2+"月");
                series02_mat.add(IncollectdataList2.get(i).getData3());
                series02_qty.add(IncollectdataList2.get(i).getData4());
            }
        }

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getInOutQtyDetailDataWeek();
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList3.size(); i++){
                String strMonth=IncollectdataList3.get(i).getData2();
                String strMonth2=strMonth.substring(4,strMonth.length());
                series03_xAxis.add(strMonth2+"周");
                series03_mat.add(IncollectdataList3.get(i).getData3());
                series03_qty.add(IncollectdataList3.get(i).getData4());
            }
        }

        List<Incollectdata> IncollectdataList4=iIncollectdataService.getInOutQtyDetailDataDay();
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList4.size(); i++){
                String strMonth=IncollectdataList4.get(i).getData2();
                series04_xAxis.add(strMonth);
                series04_mat.add(IncollectdataList4.get(i).getData3());
                series04_qty.add(IncollectdataList4.get(i).getData4());
            }
        }


        Map<String, Object> linebarDataYear = new HashMap<>();
        Map<String, Object> linebarDataMonth= new HashMap<>();
        Map<String, Object> linebarDataWeek = new HashMap<>();
        Map<String, Object> linebarDataDay = new HashMap<>();


        linebarDataYear.put("xAxis",series01_xAxis);
        linebarDataMonth.put("xAxis",series02_xAxis);
        linebarDataWeek.put("xAxis",series03_xAxis);
        linebarDataDay.put("xAxis",series04_xAxis);

        legendList.add("种类");
        legendList.add("数量");

        linebarDataYear.put("legend",legendList);
        linebarDataYear.put("series_nm",series01_xAxis);
        linebarDataYear.put("series01_qty_data",series01_qty);
        linebarDataYear.put("series01_mat_data",series01_mat);

        linebarDataMonth.put("legend",legendList);
        linebarDataMonth.put("series_nm",series02_xAxis);
        linebarDataMonth.put("series01_qty_data",series02_qty);
        linebarDataMonth.put("series01_mat_data",series02_mat);

        linebarDataWeek.put("legend",legendList);
        linebarDataWeek.put("series_nm",series03_xAxis);
        linebarDataWeek.put("series01_qty_data",series03_qty);
        linebarDataWeek.put("series01_mat_data",series03_mat);

        linebarDataDay.put("legend",legendList);
        linebarDataDay.put("series_nm",series04_xAxis);
        linebarDataDay.put("series01_qty_data",series04_qty);
        linebarDataDay.put("series01_mat_data",series04_mat);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarYearData",linebarDataYear);
        jsonObject.put("linebarMonthData",linebarDataMonth);
        jsonObject.put("linebarWeekData",linebarDataWeek);
        jsonObject.put("linebarDayData",linebarDataDay);

        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getInOutQtyDetailDataC")
    public AjaxResult getInOutQtyDetailDataC() throws IOException {
        List<String> legendList = new ArrayList<>();

        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series04_qty = new ArrayList<String>();


        List<String> series01_mat = new ArrayList<String>();
        List<String> series02_mat = new ArrayList<String>();
        List<String> series03_mat = new ArrayList<String>();
        List<String> series04_mat = new ArrayList<String>();

        List<String> series01_xAxis = new ArrayList<String>();
        List<String> series02_xAxis = new ArrayList<String>();
        List<String> series03_xAxis = new ArrayList<String>();
        List<String> series04_xAxis = new ArrayList<String>();

        List<Incollectdata> IncollectdataList1=iIncollectdataService.getInOutQtyDetailDataYearC();
        if(IncollectdataList1.size()>0){
            for(int i = 0; i < IncollectdataList1.size(); i++){
                series01_xAxis.add(IncollectdataList1.get(i).getData1()+'年');
                series01_mat.add(IncollectdataList1.get(i).getData2());
                series01_qty.add(IncollectdataList1.get(i).getData3());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getInOutQtyDetailDataMonthC();
        if(IncollectdataList2.size()>0){
            for(int i = 0; i < IncollectdataList2.size(); i++){
                String strMonth=IncollectdataList2.get(i).getData2();
                String strMonth2=strMonth.substring(4,strMonth.length());
                series02_xAxis.add(strMonth2+"月");
                series02_mat.add(IncollectdataList2.get(i).getData3());
                series02_qty.add(IncollectdataList2.get(i).getData4());
            }
        }

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getInOutQtyDetailDataWeekC();
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList3.size(); i++){
                String strMonth=IncollectdataList3.get(i).getData2();
                String strMonth2=strMonth.substring(4,strMonth.length());
                series03_xAxis.add(strMonth2+"周");
                series03_mat.add(IncollectdataList3.get(i).getData3());
                series03_qty.add(IncollectdataList3.get(i).getData4());
            }
        }

        List<Incollectdata> IncollectdataList4=iIncollectdataService.getInOutQtyDetailDataDayC();
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList4.size(); i++){
                String strMonth=IncollectdataList4.get(i).getData2();
                series04_xAxis.add(strMonth);
                series04_mat.add(IncollectdataList4.get(i).getData3());
                series04_qty.add(IncollectdataList4.get(i).getData4());
            }
        }


        Map<String, Object> linebarDataYear = new HashMap<>();
        Map<String, Object> linebarDataMonth= new HashMap<>();
        Map<String, Object> linebarDataWeek = new HashMap<>();
        Map<String, Object> linebarDataDay = new HashMap<>();


        linebarDataYear.put("xAxis",series01_xAxis);
        linebarDataMonth.put("xAxis",series02_xAxis);
        linebarDataWeek.put("xAxis",series03_xAxis);
        linebarDataDay.put("xAxis",series04_xAxis);

        legendList.add("种类");
        legendList.add("数量");

        linebarDataYear.put("legend",legendList);
        linebarDataYear.put("series_nm",series01_xAxis);
        linebarDataYear.put("series01_qty_data",series01_qty);
        linebarDataYear.put("series01_mat_data",series01_mat);

        linebarDataMonth.put("legend",legendList);
        linebarDataMonth.put("series_nm",series02_xAxis);
        linebarDataMonth.put("series01_qty_data",series02_qty);
        linebarDataMonth.put("series01_mat_data",series02_mat);

        linebarDataWeek.put("legend",legendList);
        linebarDataWeek.put("series_nm",series03_xAxis);
        linebarDataWeek.put("series01_qty_data",series03_qty);
        linebarDataWeek.put("series01_mat_data",series03_mat);

        linebarDataDay.put("legend",legendList);
        linebarDataDay.put("series_nm",series04_xAxis);
        linebarDataDay.put("series01_qty_data",series04_qty);
        linebarDataDay.put("series01_mat_data",series04_mat);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarYearData",linebarDataYear);
        jsonObject.put("linebarMonthData",linebarDataMonth);
        jsonObject.put("linebarWeekData",linebarDataWeek);
        jsonObject.put("linebarDayData",linebarDataDay);

        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getInOutQtyDetailDataW")
    public AjaxResult getInOutQtyDetailDataW() throws IOException {
        List<String> legendList = new ArrayList<>();

        List<String> series01_qty = new ArrayList<String>();
        List<String> series02_qty = new ArrayList<String>();
        List<String> series03_qty = new ArrayList<String>();
        List<String> series04_qty = new ArrayList<String>();


        List<String> series01_mat = new ArrayList<String>();
        List<String> series02_mat = new ArrayList<String>();
        List<String> series03_mat = new ArrayList<String>();
        List<String> series04_mat = new ArrayList<String>();

        List<String> series01_xAxis = new ArrayList<String>();
        List<String> series02_xAxis = new ArrayList<String>();
        List<String> series03_xAxis = new ArrayList<String>();
        List<String> series04_xAxis = new ArrayList<String>();

        List<Incollectdata> IncollectdataList1=iIncollectdataService.getInOutQtyDetailDataYearW();
        if(IncollectdataList1.size()>0){
            for(int i = 0; i < IncollectdataList1.size(); i++){
                series01_xAxis.add(IncollectdataList1.get(i).getData1()+'年');
                series01_mat.add(IncollectdataList1.get(i).getData2());
                series01_qty.add(IncollectdataList1.get(i).getData3());
            }
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getInOutQtyDetailDataMonthW();
        if(IncollectdataList2.size()>0){
            for(int i = 0; i < IncollectdataList2.size(); i++){
                String strMonth=IncollectdataList2.get(i).getData2();
                String strMonth2=strMonth.substring(4,strMonth.length());
                series02_xAxis.add(strMonth2+"月");
                series02_mat.add(IncollectdataList2.get(i).getData3());
                series02_qty.add(IncollectdataList2.get(i).getData4());
            }
        }

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getInOutQtyDetailDataWeekW();
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList3.size(); i++){
                String strMonth=IncollectdataList3.get(i).getData2();
                String strMonth2=strMonth.substring(4,strMonth.length());
                series03_xAxis.add(strMonth2+"周");
                series03_mat.add(IncollectdataList3.get(i).getData3());
                series03_qty.add(IncollectdataList3.get(i).getData4());
            }
        }

        List<Incollectdata> IncollectdataList4=iIncollectdataService.getInOutQtyDetailDataDayW();
        if(IncollectdataList3.size()>0){
            for(int i = 0; i < IncollectdataList4.size(); i++){
                String strMonth=IncollectdataList4.get(i).getData2();
                series04_xAxis.add(strMonth);
                series04_mat.add(IncollectdataList4.get(i).getData3());
                series04_qty.add(IncollectdataList4.get(i).getData4());
            }
        }


        Map<String, Object> linebarDataYear = new HashMap<>();
        Map<String, Object> linebarDataMonth= new HashMap<>();
        Map<String, Object> linebarDataWeek = new HashMap<>();
        Map<String, Object> linebarDataDay = new HashMap<>();


        linebarDataYear.put("xAxis",series01_xAxis);
        linebarDataMonth.put("xAxis",series02_xAxis);
        linebarDataWeek.put("xAxis",series03_xAxis);
        linebarDataDay.put("xAxis",series04_xAxis);

        legendList.add("种类");
        legendList.add("数量");

        linebarDataYear.put("legend",legendList);
        linebarDataYear.put("series_nm",series01_xAxis);
        linebarDataYear.put("series01_qty_data",series01_qty);
        linebarDataYear.put("series01_mat_data",series01_mat);

        linebarDataMonth.put("legend",legendList);
        linebarDataMonth.put("series_nm",series02_xAxis);
        linebarDataMonth.put("series01_qty_data",series02_qty);
        linebarDataMonth.put("series01_mat_data",series02_mat);

        linebarDataWeek.put("legend",legendList);
        linebarDataWeek.put("series_nm",series03_xAxis);
        linebarDataWeek.put("series01_qty_data",series03_qty);
        linebarDataWeek.put("series01_mat_data",series03_mat);

        linebarDataDay.put("legend",legendList);
        linebarDataDay.put("series_nm",series04_xAxis);
        linebarDataDay.put("series01_qty_data",series04_qty);
        linebarDataDay.put("series01_mat_data",series04_mat);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("linebarYearData",linebarDataYear);
        jsonObject.put("linebarMonthData",linebarDataMonth);
        jsonObject.put("linebarWeekData",linebarDataWeek);
        jsonObject.put("linebarDayData",linebarDataDay);

        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }





















    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRohAgingDetailTable")
    public AjaxResult getRohAgingDetailTable(String sourceno) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);
        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getRohAgingDetailTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("库房名称",colldata.getData1());
                tableDownRow.put("物料编码",colldata.getData2());
                tableDownRow.put("物料名称",colldata.getData3());
                tableDownRow.put("库存数量",colldata.getData4());
                tableDownRow.put("库存时间(天)",colldata.getData5());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("库房名称");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("库存数量");
        headerList.add("库存时间(天)");


        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }



    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRohAgingDetailTableC")
    public AjaxResult getRohAgingDetailTableC(String sourceno) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);
        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getRohAgingDetailTableC(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("库房名称",colldata.getData1());
                tableDownRow.put("物料编码",colldata.getData2());
                tableDownRow.put("物料名称",colldata.getData3());
                tableDownRow.put("库存数量",colldata.getData4());
                tableDownRow.put("库存时间(天)",colldata.getData5());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("库房名称");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("库存数量");
        headerList.add("库存时间(天)");


        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }




    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRohAgingDetailTableW")
    public AjaxResult getRohAgingDetailTableW(String sourceno) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);
        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getRohAgingDetailTableW(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("库房名称",colldata.getData1());
                tableDownRow.put("物料编码",colldata.getData2());
                tableDownRow.put("物料名称",colldata.getData3());
                tableDownRow.put("库存数量",colldata.getData4());
                tableDownRow.put("库存时间(天)",colldata.getData5());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("库房名称");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("库存数量");
        headerList.add("库存时间(天)");


        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getReAgingDetailTable")
    public AjaxResult getReAgingDetailTable(String sourceno) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);
        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getReAgingDetailTable(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                dataList.add(data1);
                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("库房名称",colldata.getData1());
                tableDownRow.put("物料编码",colldata.getData2());
                tableDownRow.put("物料名称",colldata.getData3());
                tableDownRow.put("库存数量",colldata.getData4());
                tableDownRow.put("库存时间(天)",colldata.getData5());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("库房名称");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("库存数量");
        headerList.add("库存时间(天)");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }








    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getShouHuoLvDetail")
    public AjaxResult getShouHuoLvDetail(String sourceno) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getShouHuoLvDetail(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());
                data1.add(colldata.getQty().toString());
                data1.add(colldata.getBatchno());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("创建日期",colldata.getData3());
                tableDownRow.put("审核日期",colldata.getData4());
                tableDownRow.put("物料编码",colldata.getData5());
                tableDownRow.put("物料名称",colldata.getData6());
                tableDownRow.put("入库子库",colldata.getData7());
                tableDownRow.put("数量",colldata.getQty().toString());
                tableDownRow.put("批次",colldata.getBatchno());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");
        headerList.add("供应商");
        headerList.add("创建日期");
        headerList.add("审核日期");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("入库子库");
        headerList.add("数量");
        headerList.add("批次");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getBaoJianLvDetail")
    public AjaxResult getBaoJianLvDetail(String sourceno) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getBaoJianLvDetail(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());
                data1.add(colldata.getQty().toString());
                data1.add(colldata.getBatchno());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("创建日期",colldata.getData3());
                tableDownRow.put("审核日期",colldata.getData4());
                tableDownRow.put("物料编码",colldata.getData5());
                tableDownRow.put("物料名称",colldata.getData6());
                tableDownRow.put("入库子库",colldata.getData7());
                tableDownRow.put("数量",colldata.getQty().toString());
                tableDownRow.put("批次",colldata.getBatchno());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");
        headerList.add("供应商");
        headerList.add("创建日期");
        headerList.add("审核日期");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("入库子库");
        headerList.add("数量");
        headerList.add("批次");
        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }






    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getRuKuLvDetail")
    public AjaxResult getRuKuLvDetail(String sourceno) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getRuKuLvDetail(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());
                data1.add(colldata.getQty().toString());
                data1.add(colldata.getBatchno());

                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("装箱单号",colldata.getData1());
                tableDownRow.put("供应商",colldata.getData2());
                tableDownRow.put("创建日期",colldata.getData3());
                tableDownRow.put("审核日期",colldata.getData4());
                tableDownRow.put("物料编码",colldata.getData5());
                tableDownRow.put("物料名称",colldata.getData6());
                tableDownRow.put("入库子库",colldata.getData7());
                tableDownRow.put("数量",colldata.getQty().toString());
                tableDownRow.put("批次",colldata.getBatchno());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("装箱单号");
        headerList.add("采购单号");
        headerList.add("创建日期");
        headerList.add("审核日期");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("入库子库");
        headerList.add("数量");
        headerList.add("批次");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuKuLvDetail")
    public AjaxResult getChuKuLvDetail(String sourceno) throws IOException {
        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);


        List<Map<String,String>> tableDown = new ArrayList<>();
        List<Incollectdata> IncollectdataList4=iIncollectdataService.getChuKuLvDetail(con);
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                List<String> data1 = new ArrayList<>();
                data1.add(colldata.getData1());
                data1.add(colldata.getData2());
                data1.add(colldata.getData3());
                data1.add(colldata.getData4());
                data1.add(colldata.getData5());
                data1.add(colldata.getData6());
                data1.add(colldata.getData7());
                data1.add(colldata.getQty().toString());
                data1.add(colldata.getData8());
                dataList.add(data1);

                Map<String,String> tableDownRow=new LinkedHashMap<>();
                tableDownRow.put("工单号",colldata.getData1());
                tableDownRow.put("出库单号",colldata.getData2());
                tableDownRow.put("出库凭证号",colldata.getData3());
                tableDownRow.put("执行日期",colldata.getData4());
                tableDownRow.put("审核日期",colldata.getData5());
                tableDownRow.put("物料编码",colldata.getData6());
                tableDownRow.put("物料名称",colldata.getData7());
                tableDownRow.put("任务数量",colldata.getQty().toString());
                tableDownRow.put("完成数量",colldata.getData8());
                tableDown.add(tableDownRow);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("工单号");
        headerList.add("出库单号");
        headerList.add("出库凭证号");
        headerList.add("执行日期");
        headerList.add("审核日期");
        headerList.add("物料编码");
        headerList.add("物料名称");
        headerList.add("任务数量");
        headerList.add("完成数量");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        userSitua.put("tableDown",tableDown);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userSitua",userSitua);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getChuKuLvDetail2")
    public AjaxResult getChuKuLvDetail2(String sourceno) throws IOException {
        IpqcRes ipqcRes = new IpqcRes();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);



        List<Incollectdata> IncollectdataList4=iIncollectdataService.getIPQC(con);
        if(IncollectdataList4.size()>0){
            Incollectdata incollectdata=IncollectdataList4.get(0);
            ipqcRes.setIpqcno(sourceno);
            ipqcRes.setTransno(incollectdata.getData1());
            ipqcRes.setSupplier(incollectdata.getData2());
            ipqcRes.setResponsible(incollectdata.getData3());
            ipqcRes.setNonconforming(incollectdata.getData4());
            ipqcRes.setDisposal(incollectdata.getData5());
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("ipqcRes",ipqcRes);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    /**大屏收货明细数据*/
    /**
     * 大屏收货明细数据-货量
     */
    @Anonymous
    @GetMapping("/getZXD")
    public AjaxResult getZXD(String sourceno) throws IOException {
        IpqcRes ipqcRes = new IpqcRes();

        Incollectdata con= new Incollectdata();
        con.setData1(sourceno);



        List<Incollectdata> IncollectdataList4=iIncollectdataService.getZXD(con);
        if(IncollectdataList4.size()>0){
            Incollectdata incollectdata=IncollectdataList4.get(0);
            ipqcRes.setReceive_name(incollectdata.getData2());
            ipqcRes.setReceive_stock_site_code(incollectdata.getData3());
            ipqcRes.setReceive_site_code(incollectdata.getData4());
            ipqcRes.setReceive_site_name(incollectdata.getData5());
            ipqcRes.setReceive_project_code(incollectdata.getData6());
            ipqcRes.setReceive_address(incollectdata.getData7());
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("ipqcRes",ipqcRes);
        AjaxResult ajax = AjaxResult.success(jsonObject);
        return ajax;
    }

    // ================================================================
    // 配送核验（work_delivery）—— 前端 flutter 需要的三个新端点
    // 对应 lib/modules/work_delivery/services/work_delivery_task_service.dart
    // 中的 reportVerifyStatus / reportVerifyException / commitVerifyResult
    // ================================================================

    /** VerifyStatus 前端枚举字符串 → INSTATE 数值（0未处理/1通过/2异常/3物损） */
    private Long resolveInstate(String status)
    {
        if (status == null) {
            return 1L;
        }
        switch (status)
        {
            case "pass":
                return 4L;
            case "shortage":
                // 缺料在业务上归为"异常"分支
                return 2L;
            case "damage":
                return 3L;
            case "pending":
            default:
                return 1L;
        }
    }

    /** 将 Map 取值转为字符串，null → ""。 */
    private static String strOrEmpty(Object v)
    {
        return v == null ? "" : v.toString();
    }

    /** 依序返回第一个非空/非空白字符串，全空返回 ""。 */
    private static String firstNonBlank(String... values)
    {
        if (values == null)
        {
            return "";
        }
        for (String v : values)
        {
            if (v != null && !v.trim().isEmpty())
            {
                return v;
            }
        }
        return "";
    }

    /**
     * 配送核验 · 按任务明细 ID 查询异常记录列表。
     *
     * <p>对应前端接口：{@code GET /system/terminal/selectDeliveryVerifyExceptList}，
     * 参见 flutter 端 {@code work_delivery_task_service.dart#getVerifyExceptionListByTaskItem}。
     * <p>入参 {@code intaskitemid} 对应 DELIVERYTASKITEM.INTASKITEMID，
     * 也就是核验明细 ID。返回该行的全部异常记录，按 collect_date 倒序。
     * <p>返回字段与前端 {@code DeliveryVerifyException.fromJson} 兼容：
     * <ul>
     *   <li>id / exceptionId</li>
     *   <li>detailId / intaskitemid / taskDetailId</li>
     *   <li>exceptionType / type（例：shortage / damage / packageDamage / ...）</li>
     *   <li>materialCode / matcode</li>
     *   <li>description / remark / desc</li>
     *   <li>images（当前后端未存图，返回空数组）</li>
     *   <li>reportTime / createTime（ISO8601 字符串）</li>
     * </ul>
     */
    @GetMapping("/selectDeliveryVerifyExceptList")
    public AjaxResult selectDeliveryVerifyExceptList(Long intaskitemid)
    {
        if (intaskitemid == null)
        {
            return error("intaskitemid 不能为空");
        }

        DeliverytaskitemExce query = new DeliverytaskitemExce();
        query.setIntaskitemid(intaskitemid);
        List<DeliverytaskitemExce> exceList = iDeliverytaskitemExceService.selectDeliverytaskitemExceList(query);
        if (exceList == null)
        {
            exceList = new ArrayList<>();
        }

        // materialid → matcode 一次性缓存，避免同一物料重复查库
        Map<Long, String> matcodeCache = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<Map<String, Object>> rows = new ArrayList<>(exceList.size());
        for (DeliverytaskitemExce exce : exceList)
        {
            if (exce == null)
            {
                continue;
            }
            String matcode = "";
            Long matId = exce.getMaterialid();
            if (matId != null)
            {
                matcode = matcodeCache.computeIfAbsent(matId, id -> {
                    PmMaterial pm = iPmMaterialService.selectPmMaterialByPmMaterialid(id);
                    return pm == null || pm.getMatcode() == null ? "" : pm.getMatcode();
                });
            }

            Map<String, Object> row = new LinkedHashMap<>();
            row.put("id", exce.getExexid());
            row.put("exceptionId", exce.getExexid());
            row.put("detailId", exce.getIntaskitemid());
            row.put("intaskitemid", exce.getIntaskitemid());
            row.put("taskDetailId", exce.getIntaskitemid());
            row.put("intaskid", exce.getIntaskid());
            row.put("inbillid", exce.getInbillid());
            row.put("materialid", exce.getMaterialid());
            row.put("materialCode", matcode);
            row.put("matcode", matcode);
            row.put("exceptionType", exce.getExexType());
            row.put("type", exce.getExexType());
            row.put("description", exce.getIndesc());
            row.put("remark", exce.getIndesc());
            row.put("images", new ArrayList<String>());
            String timeStr = exce.getCollectDate() == null ? "" : sdf.format(exce.getCollectDate());
            row.put("reportTime", timeStr);
            row.put("createTime", timeStr);
            row.put("productline", exce.getProductline());
            row.put("transactionId", exce.getTransactionId());
            rows.add(row);
        }

        // 按上报时间倒序：新异常在前
        rows.sort((a, b) -> {
            String ta = a.get("reportTime") == null ? "" : a.get("reportTime").toString();
            String tb = b.get("reportTime") == null ? "" : b.get("reportTime").toString();
            return tb.compareTo(ta);
        });

        return AjaxResult.success(getDataTable(rows));
    }

    /**
     * 配送核验 · 单条状态更新（通过 / 缺料 / 物损）。
     *
     * <p>对应前端接口：{@code POST /system/terminal/verify/updateStatus}。
     * <p>规则：
     * <ul>
     *   <li>按 detailId (=DELIVERYTASKITEM.INTASKITEMID) 更新 INSTATE、COLLECTEDQTY、备注、采集人。</li>
     *   <li>若状态为缺料/物损，同步向 DELIVERYTASKITEM_EXCE 写一条异常明细。</li>
     * </ul>
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/verify/updateStatus")
    public AjaxResult verifyUpdateStatus(@RequestBody Map<String, Object> body)
    {
        if (body == null || body.get("detailId") == null)
        {
            return error("detailId 不能为空");
        }

        Long intaskitemid = Long.valueOf(body.get("detailId").toString());
        String status = body.get("status") == null ? "" : body.get("status").toString();
        String remark = body.get("remark") == null ? "" : body.get("remark").toString();

        Deliverytaskitem item = iDeliverytaskitemService.selectDeliverytaskitemByIntaskitemid(intaskitemid);
        if (StringUtils.isNull(item))
        {
            return error("配送核验明细不存在：" + intaskitemid);
        }

        LoginUser loginUser = getLoginUser();
        Long userId = loginUser.getUser().getUserId();

        item.setInstate(resolveInstate(status));
        if (body.get("actualQty") != null)
        {
            try
            {
                //item.setCollectedqty(new BigDecimal(body.get("actualQty").toString()).longValue());
            }
            catch (NumberFormatException ignore)
            {
                // 忽略非法数字
            }
        }
        if (StringUtils.isNotEmpty(remark))
        {
            item.setIndesc(remark);
        }
        item.setCollecter(userId);
        item.setCollectDate(new Date());
        iDeliverytaskitemService.updateDeliverytaskitem(item);

        // 缺料 / 物损 → 追加一条异常记录，通过 intaskitemid 关联主表
        if ("shortage".equals(status) || "damage".equals(status))
        {
            DeliverytaskitemExce exce = new DeliverytaskitemExce();
            exce.setIntaskitemid(intaskitemid);
            exce.setIntaskid(item.getIntaskid());
            exce.setInbillid(item.getInbillid());
            exce.setMaterialid(item.getMaterialid());
            exce.setExexType(status);
            exce.setIndesc(remark);
            exce.setCollectDate(new Date());
            exce.setTransactionId(item.getTransactionId());
            exce.setProductline(item.getProductline());
            iDeliverytaskitemExceService.insertDeliverytaskitemExce(exce);
        }

        return AjaxResult.success();
    }

    /**
     * 配送核验 · 异常记录写入（异常标记按钮）。
     *
     * <p>对应前端接口：{@code POST /system/terminal/verify/addException}。
     * <p>不修改 INSTATE，仅向 DELIVERYTASKITEM_EXCE 追加一条异常明细，
     * 通过 detailId(=intaskitemid) 反查主表用于回填 inbillid/materialid 等字段。
     */
    @PostMapping("/verify/addException")
    public AjaxResult verifyAddException(@RequestBody Map<String, Object> body)
    {
        if (body == null || body.get("detailId") == null)
        {
            return error("detailId 不能为空");
        }

        Long intaskitemid = Long.valueOf(body.get("detailId").toString());
        Deliverytaskitem item = iDeliverytaskitemService.selectDeliverytaskitemByIntaskitemid(intaskitemid);
        if (StringUtils.isNull(item))
        {
            return error("配送核验明细不存在：" + intaskitemid);
        }

        String exceptionType = body.get("exceptionType") == null ? "" : body.get("exceptionType").toString();
        String description = body.get("description") == null ? "" : body.get("description").toString();

        DeliverytaskitemExce exce = new DeliverytaskitemExce();
        exce.setIntaskitemid(intaskitemid);
        exce.setIntaskid(item.getIntaskid());
        exce.setInbillid(item.getInbillid());
        exce.setMaterialid(item.getMaterialid());
        exce.setExexType(exceptionType);
        exce.setIndesc(description);
        exce.setCollectDate(new Date());
        exce.setTransactionId(item.getTransactionId());
        exce.setProductline(item.getProductline());
        iDeliverytaskitemExceService.insertDeliverytaskitemExce(exce);

        return AjaxResult.success();
    }

    /**
     * 配送核验 · 全量提交（签字确认）。
     *
     * <p>对应前端接口：{@code POST /system/terminal/verify/commitResult}。
     * <p>步骤：
     * <ol>
     *   <li>逐条更新 DELIVERYTASKITEM.INSTATE / COLLECTEDQTY / INDESC。</li>
     *   <li>批量写入 DELIVERYTASKITEM_EXCE 异常明细。</li>
     *   <li>领用人 / 配送人签字图分别落盘为文件，URL 存入
     *       DELIVERYBILL.DATA8（领用人）与 DATA9（配送人）；同时读取 DATA10 作为班组/领料单位。</li>
     *   <li>基于"推式出库单.xls"版式生成 PDF，两枚签名图分别嵌入 PDF 尾部
     *       签字区的「领用人」与「配送人」栏位，返回下载 URL。</li>
     * </ol>
     *
     * @param body 前端 payload：
     *             inTaskId / inTaskNo / receiverSignature / delivererSignature /
     *             (兼容旧字段 signatureReq / signatureWh / signatureImage) /
     *             details[] / exceptions[]
     */
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/verify/commitResult")
    public AjaxResult verifyCommitResult(@RequestBody Map<String, Object> body)
    {
        if (body == null)
        {
            return error("请求体不能为空");
        }

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();
        Long inTaskId = body.get("inTaskId") == null ? null : Long.valueOf(body.get("inTaskId").toString());
        String inTaskNo = body.get("inTaskNo") == null ? "" : body.get("inTaskNo").toString();
        // 兼容三套字段名：
        //   - receiverSignature / delivererSignature（前端 flutter 当前使用，见 work_delivery_task_service.dart）
        //   - signatureReq / signatureWh（后端旧字段命名）
        //   - signatureImage（更早期版本，只有一路签字，视作领用人签字）
        String receiverSignature = firstNonBlank(
                strOrEmpty(body.get("receiverSignature")),
                strOrEmpty(body.get("signatureReq")),
                strOrEmpty(body.get("signatureImage")));
        String delivererSignature = firstNonBlank(
                strOrEmpty(body.get("delivererSignature")),
                strOrEmpty(body.get("signatureWh")));

        // ---- 1. 明细状态更新 ----
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> details = (List<Map<String, Object>>) body.get("details");
        Long inBillId = null;
        Date nowDate = new Date();
        if (details != null)
        {
            for (Map<String, Object> d : details)
            {
                if (d == null || d.get("detailId") == null)
                {
                    continue;
                }
                Long intaskitemid = Long.valueOf(d.get("detailId").toString());
                Deliverytaskitem item = iDeliverytaskitemService.selectDeliverytaskitemByIntaskitemid(intaskitemid);
                if (item == null)
                {
                    continue;
                }
                if (inBillId == null)
                {
                    inBillId = item.getInbillid();
                }
                String status = d.get("status") == null ? "" : d.get("status").toString();
                item.setInstate(resolveInstate(status));
                // COLLECTEDQTY = 实发数量；同时换算为 Long 用于回写 DELIVERYBILL.FINISHQTY
                Long passQty = null;
                if (d.get("actualQty") != null)
                {
                    try
                    {
                        BigDecimal actual = new BigDecimal(d.get("actualQty").toString());
                        item.setCollectedqty(actual);
                        passQty = actual.longValue();
                    }
                    catch (NumberFormatException ignore)
                    {
                        // skip
                    }
                }
                if (d.get("remark") != null)
                {
                    item.setIndesc(d.get("remark").toString());
                }
                item.setCollecter(userId);
                item.setCollectDate(nowDate);
                iDeliverytaskitemService.updateDeliverytaskitem(item);

                // ---- 1.1 同步回写 DELIVERYBILL：FINISHQTY=通过数量，BILLSTATE=2 已审核，COLLECT_DATE=当前时间 ----
                Long lineBillId = item.getInbillid();
                if (lineBillId != null)
                {
                    Deliverybill billLine = iDeliverybillService.selectDeliverybillByInbillid(lineBillId);
                    if (billLine != null)
                    {
                        if (passQty != null)
                        {
                            billLine.setFinishqty(passQty);
                        }
                        billLine.setBillstate(2L);
                        billLine.setCollectDate(nowDate);
                        iDeliverybillService.updateDeliverybill(billLine);
                    }
                }
            }
        }

        // ---- 2. 异常明细写入 ----
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> exceptions = (List<Map<String, Object>>) body.get("exceptions");
        if (exceptions != null)
        {
            for (Map<String, Object> e : exceptions)
            {
                if (e == null || e.get("detailId") == null)
                {
                    continue;
                }
                Long intaskitemid = Long.valueOf(e.get("detailId").toString());
                Deliverytaskitem item = iDeliverytaskitemService.selectDeliverytaskitemByIntaskitemid(intaskitemid);
                if (item == null)
                {
                    continue;
                }
                DeliverytaskitemExce exce = new DeliverytaskitemExce();
                exce.setIntaskitemid(intaskitemid);
                exce.setIntaskid(item.getIntaskid());
                exce.setInbillid(item.getInbillid());
                exce.setMaterialid(item.getMaterialid());
                exce.setExexType(e.get("exceptionType") == null ? "" : e.get("exceptionType").toString());
                exce.setIndesc(e.get("description") == null ? "" : e.get("description").toString());
                exce.setCollectDate(new Date());
                exce.setTransactionId(item.getTransactionId());
                exce.setProductline(item.getProductline());
                iDeliverytaskitemExceService.insertDeliverytaskitemExce(exce);
            }
        }

        // ---- 3. 双方签字图存入 DELIVERYBILL：data8=领用人 / data9=配送人，读取 DATA10 作为班组/领料单位 ----
        //     Oracle DATA* 是 VARCHAR2/LONG，直接塞 base64 会触发 ORA-01461，
        //     所以先把签名图落盘为文件，DB 里只保存相对访问 URL。
        Deliverybill deliverybill = null;
        Long inProofId = null;
        String billNo = inTaskNo;
        String receiverSignUrl = null;
        String delivererSignUrl = null;
        if (inBillId != null)
        {
            deliverybill = iDeliverybillService.selectDeliverybillByInbillid(inBillId);
            if (deliverybill != null)
            {
                inProofId = deliverybill.getInproofid();
                if (StringUtils.isNotEmpty(deliverybill.getInbillno()))
                {
                    billNo = deliverybill.getInbillno();
                }
                if (StringUtils.isNotEmpty(receiverSignature))
                {
                    receiverSignUrl = com.ruoyi.web.controller.system.deliveryverify.DeliveryVerifyPdfUtil
                            .saveSignatureImage(billNo + "_req", receiverSignature);
                    if (StringUtils.isNotEmpty(receiverSignUrl))
                    {
                        deliverybill.setData8(receiverSignUrl);
                    }
                }
                if (StringUtils.isNotEmpty(delivererSignature))
                {
                    delivererSignUrl = com.ruoyi.web.controller.system.deliveryverify.DeliveryVerifyPdfUtil
                            .saveSignatureImage(billNo + "_wh", delivererSignature);
                    if (StringUtils.isNotEmpty(delivererSignUrl))
                    {
                        deliverybill.setData9(delivererSignUrl);
                    }
                }
                iDeliverybillService.updateDeliverybill(deliverybill);
            }
        }

        // ---- 4. 组装 PDF 数据：DELIVERYPROOF 抬头 + DELIVERYBILL 全部明细行 ----
        //   领料单位=DELIVERYBILL.WIP_ENTITY_NAME（第一行）；搬运单号=PROOF.ORDERNO；
        //   任务号=PROOF.PO_NUMBER；备注=PROOF.PRODESC；日期=当前日期 yyyyMMdd。
        Deliveryproof proof = inProofId == null ? null
                : iDeliveryproofService.selectDeliveryproofByInproofid(inProofId);
        String proofNo = "";
        String orderno = "";
        String poNumber = "";
        String remark = "";
        String storekeeperName = "";
        if (proof != null)
        {
            proofNo = proof.getProofno() == null ? "" : proof.getProofno();
            orderno = proof.getOrderno() == null ? "" : proof.getOrderno();
            poNumber = proof.getPoNumber() == null ? "" : proof.getPoNumber();
            remark = proof.getProdesc() == null ? "" : proof.getProdesc();

            // 库管员：DELIVERYPROOF.DEPOTNO → STOREROOM.ROOMCHARGER → EMPLOYEE.EMP_NAME
            if (proof.getDepotno() != null)
            {
                String keeper = iStoreroomService.selectKeeperNameByStoreroomid(proof.getDepotno());
                if (StringUtils.isNotEmpty(keeper))
                {
                    storekeeperName = keeper;
                }
            }

            // ---- 同步审核 DELIVERYPROOF：PROSTATE=2 已审核，DATA10=审核时间 ----
            proof.setProstate(2L);
            proof.setData10(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nowDate));
            iDeliveryproofService.updateDeliveryproof(proof);
        }

        List<Deliverybill> billLines = null;
        if (inProofId != null)
        {
            Deliverybill lineQuery = new Deliverybill();
            lineQuery.setInproofid(inProofId);
            billLines = iDeliverybillService.selectDeliverybillList(lineQuery);
        }

        List<Map<String, Object>> pdfLines = new ArrayList<>();
        String wipEntityName = "";
        Map<Long, PmMaterial> matCache = new HashMap<>();
        if (billLines != null)
        {
            for (Deliverybill line : billLines)
            {
                if (line == null)
                {
                    continue;
                }
                // 领料单位：取第一行的 WIP_ENTITY_NAME
                if (wipEntityName.isEmpty() && StringUtils.isNotEmpty(line.getWipEntityName()))
                {
                    wipEntityName = line.getWipEntityName();
                }

                Long matId = line.getMaterialid();
                PmMaterial mat = null;
                if (matId != null)
                {
                    mat = matCache.computeIfAbsent(matId,
                            id -> iPmMaterialService.selectPmMaterialByPmMaterialid(id));
                }

                Map<String, Object> row = new LinkedHashMap<>();
                row.put("materialCode", mat == null || mat.getMatcode() == null ? "" : mat.getMatcode());
                row.put("materialName", mat == null || mat.getMatname() == null ? "" : mat.getMatname());
                // 物料单位：PM_MATUNIT 为外键 Long，当前系统无单位名称解析服务，参考 PDF 统一为 EA
                row.put("unit", "EA");
                row.put("taskQty", line.getTaskqty());
                row.put("finishQty", line.getFinishqty());
                row.put("subInventoryCode", line.getSubinventoryCode() == null ? "" : line.getSubinventoryCode());
                row.put("hintDesc", line.getHintdesc() == null ? "" : line.getHintdesc());
                row.put("palletNo", line.getPalletno() == null ? "" : line.getPalletno());
                pdfLines.add(row);
            }
        }

        //   领用人签字（receiverSignature）→ 领用人位；配送人签字（delivererSignature）→ 配送人位
        String pdfUrl = com.ruoyi.web.controller.system.deliveryverify.DeliveryVerifyPdfUtil.buildPdf(
                billNo,
                proofNo,
                wipEntityName,
                orderno,
                poNumber,
                remark,
                pdfLines,
                user.getNickName() == null ? user.getUserName() : user.getNickName(),
                storekeeperName,
                receiverSignature,
                delivererSignature);

        // ---- 5. PDF 访问地址回写 DELIVERYTASK.DATA7 ----
        if (StringUtils.isNotEmpty(pdfUrl) && inTaskId != null)
        {
            Deliverytask deliverytask = iDeliverytaskService.selectDeliverytaskByIntaskid(inTaskId);
            if (deliverytask != null)
            {
                deliverytask.setData7(pdfUrl);
                iDeliverytaskService.updateDeliverytask(deliverytask);
            }
        }

        // 相对路径 → 绝对下载链接，供 App 直接下载查看 PDF / 签名图
        String baseUrl = serverConfig.getUrl();
        String pdfDownloadUrl = StringUtils.isNotEmpty(pdfUrl) ? baseUrl + pdfUrl : "";
        String receiverSignDownloadUrl = StringUtils.isNotEmpty(receiverSignUrl) ? baseUrl + receiverSignUrl : "";
        String delivererSignDownloadUrl = StringUtils.isNotEmpty(delivererSignUrl) ? baseUrl + delivererSignUrl : "";

        Map<String, Object> resp = new HashMap<>();
        resp.put("inTaskId", inTaskId);
        resp.put("inTaskNo", billNo);
        resp.put("pdfUrl", pdfUrl);
        resp.put("pdfDownloadUrl", pdfDownloadUrl);
        resp.put("receiverSignUrl", receiverSignUrl);
        resp.put("receiverSignDownloadUrl", receiverSignDownloadUrl);
        resp.put("delivererSignUrl", delivererSignUrl);
        resp.put("delivererSignDownloadUrl", delivererSignDownloadUrl);
        // 兼容旧客户端字段
        resp.put("signatureUrl", receiverSignUrl);
        resp.put("downloadUrl", pdfDownloadUrl);
        return AjaxResult.success(resp);
    }

    /**
     * 配送核验 · 获取已核对完成单据的 PDF 下载链接。
     *
     * <p>页面初始化时，针对已经核对完成（verifyCommitResult 已执行）的单据调用本接口。
     * PDF 的相对访问路径在提交时写入了 DELIVERYTASK.DATA7，这里读出并拼上服务端域名，
     * 返回可直接下载/查看的绝对链接。
     *
     * @param inTaskId 配送任务 ID（DELIVERYTASK.INTASKID）
     * @return data 中包含：
     *         <ul>
     *           <li>inTaskId</li>
     *           <li>pdfUrl（相对路径，可能为空，表示尚未生成 PDF）</li>
     *           <li>pdfDownloadUrl（绝对下载链接）</li>
     *           <li>downloadUrl（pdfDownloadUrl 的别名，兼容旧客户端）</li>
     *         </ul>
     */
    @GetMapping("/verify/pdfUrl")
    public AjaxResult getVerifyPdfUrl(Long inTaskId)
    {
        if (inTaskId == null)
        {
            return error("inTaskId 不能为空");
        }

        Deliverytask deliverytask = iDeliverytaskService.selectDeliverytaskByIntaskid(inTaskId);
        if (deliverytask == null)
        {
            return error("配送任务不存在：" + inTaskId);
        }

        String pdfUrl = deliverytask.getData7();
        if (StringUtils.isEmpty(pdfUrl))
        {
            pdfUrl = "";
        }
        String pdfDownloadUrl = pdfUrl.isEmpty() ? "" : serverConfig.getUrl() + pdfUrl;

        Map<String, Object> data = new HashMap<>();
        data.put("inTaskId", inTaskId);
        data.put("pdfUrl", pdfUrl);
        data.put("pdfDownloadUrl", pdfDownloadUrl);
        data.put("downloadUrl", pdfDownloadUrl);
        return AjaxResult.success(data);
    }




    /**
     * 获取尚未完成的已经收入库单据
     */
    @GetMapping("/intaskListDelivery")
    // @Log(title = "获取尚未完成的已经收入库单据", businessType = BusinessType.INSERT)
    public AjaxResult getIntaskListDelivery(Intask intask) {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        intask.setI_collecter(userId);
        intask.setInstate(userId);

        Long iInstate = -1L;
        Long iUserId = 0L;
        if (intask.getUserId().equals("ALL")) {
            iInstate = 0L;
        } else {
            iUserId = Long.parseLong(intask.getUserId());
            iInstate = 1L;
        }
        intask.setI_collecter(iUserId);
        intask.setInstate(iInstate);
        intask.setUserId(intask.getRoleoRuserId());
        intask.setRoomTag(intask.getRoomTag());
        intask.setTransferType(intask.getTransferType());
        if (intask.getPageIndex() > 0 && intask.getPageSize() > 0) {
            PageHelper.startPage(intask.getPageIndex(), intask.getPageSize());
        }
        List<Intask> intaskList= new ArrayList<>();
        String finshFlg=intask.getFinshFlg();

        if(StringUtils.isEmpty(finshFlg)||finshFlg.equals("0")){
            intaskList = intaskService.selectIntaskListDelivery(intask);
        }else{
            String searchKey=intask.getSearchKey();
            if(StringUtils.isEmpty(searchKey)){
                return error("请输入查询单号");
            }
            intaskList = intaskService.selectIntaskListDeliveryAll(intask);
        }

        AjaxResult ajax = AjaxResult.success(getDataTable(intaskList));
        return ajax;
    }

    /**
     * 获取尚未完成的已经收入库单据
     *
     * @param intaskitem 任务查询条件
     * @return 单据明细
     */
    @GetMapping("/intaskitemListDelivery")
    //@Log(title = "单据明细", businessType = BusinessType.INSERT)
    public AjaxResult getIntaskitemListDelivery(Intaskitem intaskitem) {

        Long iUserId = 0L;
        Long iInstate = -1L;

        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        Long userId = user.getUserId();

        if (intaskitem.getUserId().equals("ALL")) {
            iInstate = 0L;
        } else {
            iInstate = 1L;
            iUserId = Long.parseLong(intaskitem.getUserId());
        }

        intaskitem.setInstate(iInstate);
        intaskitem.setUserId(userId.toString());
        intaskitem.setI_collecter(iUserId);
        /*if (intaskitem.getPageIndex() > 0 && intaskitem.getPageSize() > 0) {
            PageHelper.startPage(intaskitem.getPageIndex(), intaskitem.getPageSize());
        }*/
        List<Intaskitem> intaskitemList= new ArrayList<>();
        String finshFlg=intaskitem.getTaskFinishFlag();

        if(StringUtils.isEmpty(finshFlg)||finshFlg.equals("0")){
            intaskitemList = iIntaskitemService.selectIntaskitemListDelivery(intaskitem);
        }else{
            intaskitemList = iIntaskitemService.selectIntaskitemListDeliveryAll(intaskitem);
        }

        AjaxResult ajax = AjaxResult.success(getDataTable(intaskitemList));
        return ajax;
    }


}
