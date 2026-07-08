package com.ruoyi.web.controller.system;

import com.google.code.kaptcha.Producer;
import com.ruoyi.common.domin.FebsResponse;
import com.ruoyi.common.domin.FebsResponseUtil;
import com.ruoyi.system.domain.SysMessage;
import com.ruoyi.system.service.ISysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.system.service.GeTuiUtilsService;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/system/push")

public class PushController {
    @Autowired
    private GeTuiUtilsService geTuiUtils;

    @Autowired
    private ISysMessageService sysMessageService;

    @RequestMapping("/pushMess")
    public FebsResponse pushMessage() {
        SysMessage sysMessage = new SysMessage();
        sysMessage.setMessageStatus("0"); // 0 未通知，1 已通知，2 已处理
        List<SysMessage> list = sysMessageService.selectSysMessageList(sysMessage);
        if(list.size()>0){
            for(SysMessage pushMessage: list){
                String cld = pushMessage.getCldNo();
                String title = pushMessage.getMessageTitle();
                String concent = pushMessage.getMessageConcent();

                geTuiUtils.pushToSingleByCid(cld,title,concent);
                pushMessage.setMessageStatus("1");
                sysMessageService.updateSysMessage(pushMessage);
            }
        }
        return FebsResponseUtil.success("成功");
    }
}
