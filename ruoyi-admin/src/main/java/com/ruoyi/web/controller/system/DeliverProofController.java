package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.domin.FebsResponse;
import com.ruoyi.common.domin.FebsResponseUtil;
import com.ruoyi.system.domain.CuxWmsOrderHeaderInterface;
import com.ruoyi.system.domain.Incollectdata;
import com.ruoyi.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/delivery")

public class DeliverProofController {
    @Autowired
    private GeTuiUtilsService geTuiUtils;

    @Autowired
    private IDeliverybillService iDeliverybillService;

    @Autowired
    private IDeliveryproofService iDeliveryproofService;

    @RequestMapping("/insertDelivery")
    public FebsResponse insertDelivery() {

        System.out.println("同步数据作业开始");
        // 先查询待同步的 OUTPROOFID 列表（已按 data7 倒序、限量 100、排除已同步）
        List<Long> outProofIds = iDeliveryproofService.selectPendingOutProofIds();

        int proofCount = 0;
        int billCount = 0;
        for (Long outProofId : outProofIds)
        {
            if (outProofId == null)
            {
                continue;
            }
            // 1. 先单条写入 DELIVERYPROOF
            int inserted = iDeliveryproofService.insertDeliveryProofById(outProofId);
            if (inserted <= 0)
            {
                // 未插入（并发等原因已存在），跳过该凭证的明细同步
                continue;
            }
            proofCount++;

            // 2. 插入成功后，按 OUTPROOFID 精确写入该凭证对应的 DELIVERYBILL
            billCount += iDeliverybillService.insertDeliveryBillByOutProofId(outProofId);
        }

        System.out.println("同步数据作业结束");
        return FebsResponseUtil.success("成功");
    }
}
