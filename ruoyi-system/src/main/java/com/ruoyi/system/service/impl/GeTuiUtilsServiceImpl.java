package com.ruoyi.system.service.impl;

import com.getui.push.v2.sdk.ApiHelper;
import com.getui.push.v2.sdk.api.PushApi;
import com.getui.push.v2.sdk.common.ApiResult;
import com.getui.push.v2.sdk.dto.req.Audience;
import com.getui.push.v2.sdk.dto.req.AudienceDTO;
import com.getui.push.v2.sdk.dto.req.Settings;
import com.getui.push.v2.sdk.dto.req.Strategy;
import com.getui.push.v2.sdk.dto.req.message.PushChannel;
import com.getui.push.v2.sdk.dto.req.message.PushDTO;
import com.getui.push.v2.sdk.dto.req.message.PushMessage;
import com.getui.push.v2.sdk.dto.req.message.android.AndroidDTO;
import com.getui.push.v2.sdk.dto.req.message.android.ThirdNotification;
import com.getui.push.v2.sdk.dto.req.message.android.Ups;
import com.getui.push.v2.sdk.dto.req.message.ios.Alert;
import com.getui.push.v2.sdk.dto.req.message.ios.Aps;
import com.getui.push.v2.sdk.dto.req.message.ios.IosDTO;
import com.getui.push.v2.sdk.dto.res.TaskIdDTO;
import com.ruoyi.common.domin.FebsResponse;
import com.ruoyi.common.domin.FebsResponseUtil;
import com.ruoyi.system.domain.ArrivalsAbnormal;
import com.ruoyi.system.mapper.ArrivalsAbnormalMapper;
import com.ruoyi.system.service.IArrivalsAbnormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.service.GeTuiUtilsService;
import com.google.code.kaptcha.Producer;
import com.getui.push.v2.sdk.dto.req.message.android.GTNotification;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * 到货异常信息,已单据为单位,不和具体物料关联Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-04
 */
@Service
public class GeTuiUtilsServiceImpl implements GeTuiUtilsService
{
    @Resource(name = "myApiHelper")
    private ApiHelper myApiHelper;

    /**
     * 消息推送（离线推送）单cid推送
     * @param cid
     * @param title
     * @param content
     */
    public FebsResponse pushToSingleByCid(String cid, String title, String content) {


        PushDTO<Audience> pushDTO = this.buildPushDTO(title,content);
        // 设置接收人信息
        Audience audience = new Audience();
        pushDTO.setAudience(audience);
        audience.addCid(cid);// cid
        // 进行cid单推
        PushApi pushApi = myApiHelper.creatApi(PushApi.class);
        ApiResult<Map<String, Map<String, String>>> apiResult = pushApi.pushToSingleByCid(pushDTO);
        if (apiResult.isSuccess()) {


            // success
            return FebsResponseUtil.success(apiResult.getMsg(),apiResult.getData());
        } else {


            // failed
            return FebsResponseUtil.fail("code:" + apiResult.getCode() + ", msg: " + apiResult.getMsg());
        }
    }

    /**
     * cid批量推
     * @param cidList
     * @param title
     * @param content
     */
    public FebsResponse pushListByCid(List<String> cidList, String title, String content) {


        //批量发送
        AudienceDTO audienceDTO = new AudienceDTO();

        PushDTO<Audience> pushDTO = this.buildPushDTO(title,content);

        PushApi pushApi = myApiHelper.creatApi(PushApi.class);
        ApiResult<TaskIdDTO> createApiResult = pushApi.createMsg(pushDTO);
        if (! createApiResult.isSuccess()) {


            return FebsResponseUtil.fail("推送：创建消息失败"+createApiResult.getMsg());
        }
        // 设置接收人信息
        Audience audience = new Audience();
        pushDTO.setAudience(audience);
        audience.setCid(cidList);

        audienceDTO.setAudience(audience);
        audienceDTO.setTaskid(createApiResult.getData().getTaskId());
        audienceDTO.setAsync(true);

        ApiResult<Map<String, Map<String, String>>> apiResult = pushApi.pushListByCid(audienceDTO);
        if (apiResult.isSuccess()) {


            // success
            return FebsResponseUtil.success(apiResult.getMsg());
        } else {


            // failed
            return FebsResponseUtil.fail("code:" + apiResult.getCode() + ", msg: " + apiResult.getMsg());
        }
    }

    public PushDTO<Audience> buildPushDTO(String title, String content) {


        PushDTO<Audience> pushDTO = new PushDTO<>();
        // 设置推送参数
        //requestid需要每次变化唯一
        pushDTO.setRequestId(System.currentTimeMillis() + "");
        pushDTO.setGroupName("wxb-group");

        //配置推送条件
        // 1: 表示该消息在用户在线时推送个推通道，用户离线时推送厂商通道;
        // 2: 表示该消息只通过厂商通道策略下发，不考虑用户是否在线;
        // 3: 表示该消息只通过个推通道下发，不考虑用户是否在线；
        // 4: 表示该消息优先从厂商通道下发，若消息内容在厂商通道代发失败后会从个推通道下发。
        Strategy strategy = new Strategy();
        strategy.setDef(1);
        strategy.setSt(1);
        Settings settings = new Settings();
        settings.setStrategy(strategy);
        pushDTO.setSettings(settings);
        //消息有效期，走厂商消息需要设置该值
        settings.setTtl(3600000);

        //推送苹果离线通知标题内容
        Alert alert = new Alert();
        //苹果离线通知栏标题
        alert.setTitle(title);
        //苹果离线通知栏内容
        alert.setBody(content);
        Aps aps = new Aps();
        //1表示静默推送(无通知栏消息)，静默推送时不需要填写其他参数。
        //苹果建议1小时最多推送3条静默消息
        aps.setContentAvailable(0);
        aps.setSound("default");
        aps.setAlert(alert);
        IosDTO iosDTO = new IosDTO();
        iosDTO.setAps(aps);
        iosDTO.setType("notify");
        PushChannel pushChannel = new PushChannel();
        pushChannel.setIos(iosDTO);
        //安卓离线厂商通道推送消息体
        AndroidDTO androidDTO = new AndroidDTO();
        Ups ups = new Ups();
        ThirdNotification notification1 = new ThirdNotification();
        ups.setNotification(notification1);
        //安卓离线展示的标题
        notification1.setTitle(title);
        //安卓离线展示的内容
        notification1.setBody(content);
        notification1.setClickType("intent");
        notification1.setIntent("intent:#Intent;action=android.intent.action.oppopush;launchFlags=0x14000000;component=uni.UNI004B011/io.dcloud.PandoraEntry;S.UP-OL-SU=true;S.title="+title+ ";S.content="+content+";S.payload=test;end");
        //各厂商自有功能单项设置
        //ups.addOption("HW", "/message/android/notification/badge/class", "io.dcloud.PandoraEntry ");
        //ups.addOption("HW", "/message/android/notification/badge/add_num", 1);
        //ups.addOption("HW", "/message/android/notification/importance", "HIGH");
        //ups.addOption("VV","classification",1);
        androidDTO.setUps(ups);
        pushChannel.setAndroid(androidDTO);
        pushDTO.setPushChannel(pushChannel);


        GTNotification notification = new GTNotification();

        notification.setTitle(title + new Date());
        notification.setBody(content);
        //notification.setClickType("url");
        //notification.setUrl("https://www.baidu.com");// 跳转地址
        notification.setClickType("intent");
        notification.setIntent("intent://io.dcloud.unipush/?#Intent;scheme=unipush;launchFlags=0x4000000;component=uni.UNI004B011/io.dcloud.PandoraEntry;S.UP-OL-SU=true;S.title=" + title + ";S.content=" + content + ";S.payload=test;end");

        // PushMessage在线走个推通道才会起作用的消息体
        PushMessage pushMessage = new PushMessage();
        pushDTO.setPushMessage(pushMessage);
        //pushMessage.setTransmission(" {title:"" + title + "",content:"" + content + "",payload:"test"}");
/*
        pushMessage.setTransmission("{title:\\\"\" + title + \"\\\",content:\\\"\" + content + \"\\\",payload:\\\"自定义数据\\\"}\"");
*/
        pushMessage.setNotification(notification);




        return pushDTO;
    }
}
