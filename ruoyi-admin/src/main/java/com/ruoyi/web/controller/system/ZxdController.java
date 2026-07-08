package com.ruoyi.web.controller.system;

import com.ruoyi.common.domin.FebsResponse;
import com.ruoyi.common.domin.FebsResponseUtil;
import com.ruoyi.system.domain.CuxWmsOrderHeaderInterface;
import com.ruoyi.system.domain.Incollectdata;
import com.ruoyi.system.domain.SysMessage;
import com.ruoyi.system.service.GeTuiUtilsService;
import com.ruoyi.system.service.ICuxWmsOrderHeaderInterfaceService;
import com.ruoyi.system.service.IIncollectdataService;
import com.ruoyi.system.service.ISysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/zxd")

public class ZxdController {
    @Autowired
    private GeTuiUtilsService geTuiUtils;

    @Autowired
    private ISysMessageService sysMessageService;

    @Autowired
    ICuxWmsOrderHeaderInterfaceService iCuxWmsOrderHeaderInterfaceService;

    @Autowired
    private IIncollectdataService iIncollectdataService;

    @RequestMapping("/zxdGet")
    public FebsResponse zxdGet() {

        System.out.println("同步数据作业开始");
        CuxWmsOrderHeaderInterface cuxWmsOrderHeaderInterface = new CuxWmsOrderHeaderInterface();
        List<CuxWmsOrderHeaderInterface> list = iCuxWmsOrderHeaderInterfaceService.selectCuxWmsOrderHeaderList(cuxWmsOrderHeaderInterface);
        if(list.size()>0){
            for(CuxWmsOrderHeaderInterface zxdOrder: list){
                String ErpOrderNumber=zxdOrder.getErpOrderNumber();

                Incollectdata con= new Incollectdata();
                con.setData1(ErpOrderNumber);


                List<Incollectdata> IncollectdataList4=iIncollectdataService.getZXD(con);
                if(IncollectdataList4.size()>0){
                    Incollectdata incollectdata=IncollectdataList4.get(0);
                    zxdOrder.setReceiveName(incollectdata.getData2());
                    zxdOrder.setReceiveStockSiteCode(incollectdata.getData3());
                    zxdOrder.setReceiveSiteCode(incollectdata.getData4());
                    zxdOrder.setReceiveSiteName(incollectdata.getData5());
                    zxdOrder.setReceiveProjectCode(incollectdata.getData6());
                    zxdOrder.setReceiveAddress(incollectdata.getData7());
                    iCuxWmsOrderHeaderInterfaceService.updateCuxWmsOrderHeaderInterface(zxdOrder);
                }
            }
        }
        System.out.println("同步数据作业结束");
        return FebsResponseUtil.success("成功");
    }
}
