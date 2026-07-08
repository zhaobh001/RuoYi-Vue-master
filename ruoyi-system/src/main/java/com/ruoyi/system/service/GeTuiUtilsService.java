package com.ruoyi.system.service;

import com.getui.push.v2.sdk.dto.req.Audience;
import com.getui.push.v2.sdk.dto.req.message.PushDTO;
import com.ruoyi.common.domin.FebsResponse;

import java.util.List;

public interface GeTuiUtilsService {
    public FebsResponse pushToSingleByCid(String cid, String title, String content);

    public FebsResponse pushListByCid(List<String> cidList, String title, String content);

    public PushDTO<Audience> buildPushDTO(String title, String content);
}
