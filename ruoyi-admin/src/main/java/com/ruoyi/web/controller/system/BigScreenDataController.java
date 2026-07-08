package com.ruoyi.web.controller.system;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.domin.FebsResponse;
import com.ruoyi.common.domin.FebsResponseUtil;
import com.ruoyi.system.domain.CuxWmsOrderHeaderInterface;
import com.ruoyi.system.domain.Incollectdata;
import com.ruoyi.system.service.GeTuiUtilsService;
import com.ruoyi.system.service.ICuxWmsOrderHeaderInterfaceService;
import com.ruoyi.system.service.IIncollectdataService;
import com.ruoyi.system.service.ISysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/bigscreendata")

public class BigScreenDataController {
    @Autowired
    private GeTuiUtilsService geTuiUtils;

    @Autowired
    private ISysMessageService sysMessageService;

    @Autowired
    ICuxWmsOrderHeaderInterfaceService iCuxWmsOrderHeaderInterfaceService;

    @Autowired
    private IIncollectdataService iIncollectdataService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 大屏首页右左屏数据
     */
    @RequestMapping("/getLeftPageData")
    public FebsResponse getLeftPageData() throws IOException {

        List<String> timeList = new ArrayList<>();
        List<String> outData = new ArrayList<String>();
        List<String> inData = new ArrayList<String>();
        Map<String, List<String>> trafficSitua = new HashMap<>();

        String accessFrequency="";
        String peakFlow="";

        List<Incollectdata> IncollectdataList=iIncollectdataService.getractIndexLeftPack();
        if(IncollectdataList.size()>0){
            accessFrequency = IncollectdataList.get(0).getData6();
            peakFlow = IncollectdataList.get(0).getData5();
        }


        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractIndexLeftin();
        if(IncollectdataList2.size()>0){
            for (int j = 0; j < IncollectdataList2.size(); j++) {
                Incollectdata colldata = IncollectdataList2.get(j);
                inData.add(colldata.getData6());
                timeList.add(colldata.getData7());
            }
        }

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getractIndexLeftout();
        if(IncollectdataList3.size()>0){
            for (int j = 0; j < IncollectdataList3.size(); j++) {
                Incollectdata colldata = IncollectdataList3.get(j);
                outData.add(colldata.getData6());
            }
        }



        trafficSitua.put("timeList",timeList);
        trafficSitua.put("outData",outData);
        trafficSitua.put("inData",inData);

        String waterLevelPond1down="";
        String waterLevelPond2down="";
        String waterLevelPond3down="";
        String waterLevelPond4down="";
        String waterLevelPond5down="";
        String waterLevelPond6down="";

        List<Incollectdata> IncollectdataList1down=iIncollectdataService.getractIndexCentershouhuoqty();
        if(IncollectdataList.size()>0){
            waterLevelPond1down = IncollectdataList1down.get(0).getQty().toString();
        }

        List<Incollectdata> IncollectdataList2down=iIncollectdataService.getractIndexCenterfahuoqty();
        if(IncollectdataList.size()>0){
            waterLevelPond2down = IncollectdataList2down.get(0).getQty().toString();
        }

        List<Incollectdata> IncollectdataList3down=iIncollectdataService.getractIndexCentercaituiqty();
        if(IncollectdataList.size()>0){
            waterLevelPond3down = IncollectdataList3down.get(0).getQty().toString();
        }

        List<Incollectdata> IncollectdataList4down=iIncollectdataService.getractIndexCenterchengruqty();
        if(IncollectdataList.size()>0){
            waterLevelPond4down = IncollectdataList4down.get(0).getQty().toString();
        }

        List<Incollectdata> IncollectdataList5down=iIncollectdataService.getractIndexCenterchengfaqty();
        if(IncollectdataList.size()>0){
            waterLevelPond5down = IncollectdataList5down.get(0).getQty().toString();
        }

        List<Incollectdata> IncollectdataList6down=iIncollectdataService.getractIndexCentershengtuiqty();
        if(IncollectdataList.size()>0){
            waterLevelPond6down = IncollectdataList6down.get(0).getQty().toString();
        }

        List<Map> detailsList = new ArrayList<Map>();

        Map<String, Object> data1 = new HashMap<>();
        data1.put("title","采购入库");
        data1.put("number",waterLevelPond1down);
        data1.put("unit","件/累计");
        data1.put("url","/ShouHuoDetailPage");

        Map<String, Object> data2 = new HashMap<>();
        data2.put("title","工单发料");
        data2.put("number",waterLevelPond2down);
        data2.put("unit","件/累计");
        data2.put("url","/FaHuoDetailPage");

        Map<String, Object> data3 = new HashMap<>();
        data3.put("title","采购退货");
        data3.put("number",waterLevelPond3down);
        data3.put("unit","件/累计");
        data3.put("url","/TuiHuoDetailPage");

        Map<String, Object> data4 = new HashMap<>();
        data4.put("title","成品入库");
        data4.put("number",waterLevelPond4down);
        data4.put("unit","台/累计");
        data4.put("url","/ChengsHuoDetailPage");

        Map<String, Object> data5 = new HashMap<>();
        data5.put("title","成品发货");
        data5.put("number",waterLevelPond5down);
        data5.put("unit","台/累计");
        data5.put("url","/ChengfHuoDetailPage");

        Map<String, Object> data6 = new HashMap<>();
        data6.put("title","生产材料退库");
        data6.put("number",waterLevelPond6down);
        data6.put("unit","台/累计");
        data6.put("url","/TuiKuDetailPage");

        detailsList.add(data1);
        detailsList.add(data2);
        detailsList.add(data3);
        detailsList.add(data4);
        detailsList.add(data5);
        detailsList.add(data6);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("accessFrequency",accessFrequency);
        jsonObject.put("peakFlow",peakFlow);
        jsonObject.put("trafficSitua",trafficSitua);
        jsonObject.put("detailsList",detailsList);

        redisCache.setCacheObject(CacheConstants.BIG_GREEN_PAGE_DATA_KEY+"left_data",jsonObject);
        return FebsResponseUtil.success("成功");

    }

    /**
     * 大屏首页右中间数据
     */
    @RequestMapping("/getCenterPageData")
    public FebsResponse getCenterPageData() throws IOException {
        List<String> outData = new ArrayList<String>();
        List<String> inData = new ArrayList<String>();
        Map<String, List<String>> trafficSitua = new HashMap<>();
        Map<String, Object> res = new HashMap<>();

        String waterLevelPond1="";
        String waterLevelPond2="";
        String waterLevelPond3="";
        String waterLevelPond4="";
        String waterLevelPond5="";
        String waterLevelPond6="";

        List<Incollectdata> IncollectdataList=iIncollectdataService.getractIndexCentershouhuolv();
        if(IncollectdataList.size()>0){
            waterLevelPond1 = IncollectdataList.get(0).getData5();
        }

        List<Incollectdata> IncollectdataList2=iIncollectdataService.getractIndexCenterbaojianlv();
        if(IncollectdataList2.size()>0){
            waterLevelPond2 = IncollectdataList2.get(0).getData5();
        }

        List<Incollectdata> IncollectdataList3=iIncollectdataService.getractIndexCenterrukulv();
        if(IncollectdataList3.size()>0){
            waterLevelPond3 = IncollectdataList3.get(0).getData5();
        }

        List<Incollectdata> IncollectdataList4=iIncollectdataService.getractIndexCenterchukulv();
        if(IncollectdataList4.size()>0){
            waterLevelPond4 = IncollectdataList4.get(0).getData5();
        }

        List<Incollectdata> IncollectdataList5=iIncollectdataService.getractIndexCenterqitaolv();
        if(IncollectdataList5.size()>0){
            waterLevelPond5 = IncollectdataList5.get(0).getData5();
        }

        List<Incollectdata> IncollectdataList6=iIncollectdataService.getractIndexCenterpipeilv();
        if(IncollectdataList6.size()>0){
            waterLevelPond6 = IncollectdataList6.get(0).getData1();
        }

        Map<String, Object> waterLevelPond1map = new HashMap<>();
        List<String> waterLevelPond1mapdata=new ArrayList<>();
        waterLevelPond1mapdata.add(waterLevelPond1);
        waterLevelPond1map.put("data",waterLevelPond1mapdata);
        waterLevelPond1map.put("shape","roundRect");

        Map<String, Object> waterLevelPond2map = new HashMap<>();
        List<String> waterLevelPond2mapdata=new ArrayList<>();
        waterLevelPond2mapdata.add(waterLevelPond2);
        waterLevelPond2map.put("data",waterLevelPond2mapdata);
        waterLevelPond2map.put("shape","roundRect");

        Map<String, Object> waterLevelPond3map = new HashMap<>();
        List<String> waterLevelPond3mapdata=new ArrayList<>();
        waterLevelPond3mapdata.add(waterLevelPond3);
        waterLevelPond3map.put("data",waterLevelPond3mapdata);
        waterLevelPond3map.put("shape","roundRect");


        Map<String, Object> waterLevelPond4map = new HashMap<>();
        List<String> waterLevelPond4mapdata=new ArrayList<>();
        waterLevelPond4mapdata.add(waterLevelPond4);
        waterLevelPond4map.put("data",waterLevelPond4mapdata);
        waterLevelPond4map.put("shape","roundRect");


        Map<String, Object> waterLevelPond5map = new HashMap<>();
        List<String> waterLevelPond5mapdata=new ArrayList<>();
        waterLevelPond5mapdata.add(waterLevelPond5);
        waterLevelPond5map.put("data",waterLevelPond5mapdata);
        waterLevelPond5map.put("shape","roundRect");


        Map<String, Object> waterLevelPond6map = new HashMap<>();
        List<String> waterLevelPond6mapdata=new ArrayList<>();
        waterLevelPond6mapdata.add(waterLevelPond6);
        waterLevelPond6map.put("data",waterLevelPond6mapdata);
        waterLevelPond6map.put("shape","roundRect");




        List<List<String>> dataList = new ArrayList<>();
        Map<String, Object> userSitua = new HashMap<>();

        List<Incollectdata> IncollectdataList41=iIncollectdataService.getractIndexLefworkorder();
        if(IncollectdataList41.size()>0){
            for (int j = 0; j < IncollectdataList41.size(); j++) {
                Incollectdata colldata = IncollectdataList41.get(j);
                List<String> data12 = new ArrayList<>();
                data12.add(colldata.getData1());
                data12.add(colldata.getData2());
                data12.add(colldata.getData3());
                dataList.add(data12);
            }
        }
        List<String> headerList = new ArrayList<>();
        headerList.add("工单");
        headerList.add("统计日期");
        headerList.add("首批齐套率");

        userSitua.put("data",dataList);
        userSitua.put("header",headerList);
        res.put("userSitua",userSitua);
        res.put("waterLevelPond1",waterLevelPond1map);
        res.put("waterLevelPond2",waterLevelPond2map);
        res.put("waterLevelPond3",waterLevelPond3map);
        res.put("waterLevelPond4",waterLevelPond4map);
        res.put("waterLevelPond5",waterLevelPond5map);
        res.put("waterLevelPond6",waterLevelPond6map);

        redisCache.setCacheObject(CacheConstants.BIG_GREEN_PAGE_DATA_KEY+"center_data",res);
        return FebsResponseUtil.success("成功");
    }

    /**
     * 大屏首页右侧数据
     */
    @RequestMapping("/getRightPageData")
    public FebsResponse getRightPageData() throws IOException {
        List<Map> dataList = new ArrayList<>();

        List<Map> dataList2 = new ArrayList<>();
        List<Map> dataList3 = new ArrayList<>();

        InputStream inputStream = getClass().getResourceAsStream("/api/api.json");
        //ClassPathResource resource = new ClassPathResource("api/api.json");
        byte[] jsonData = FileCopyUtils.copyToByteArray(inputStream);
        //String jsonString = new String(jsonData);
        List<Incollectdata> IncollectdataList2=iIncollectdataService.getIndexRightStomeroom();
        if(IncollectdataList2.size()>0){
            for (int j = 0; j < IncollectdataList2.size(); j++) {
                Incollectdata colldata = IncollectdataList2.get(j);
                Map dataListchild = new HashMap();
                dataListchild.put("name",colldata.getData5());
                dataListchild.put("value",colldata.getData6());
                dataList.add(dataListchild);
            }
        }


        List<Incollectdata> IncollectdataList3=iIncollectdataService.getRightActiveRingData1();
        if(IncollectdataList3.size()>0){
            for (int j = 0; j < IncollectdataList3.size(); j++) {
                Incollectdata colldata = IncollectdataList3.get(j);
                Map dataListchild = new HashMap();
                dataListchild.put("name",colldata.getData5());
                dataListchild.put("value",new BigDecimal(colldata.getData6()));
                dataList2.add(dataListchild);
            }
        }

        List<Incollectdata> IncollectdataList4=iIncollectdataService.getRightActiveRingData2();
        if(IncollectdataList4.size()>0){
            for (int j = 0; j < IncollectdataList4.size(); j++) {
                Incollectdata colldata = IncollectdataList4.get(j);
                Map dataListchild = new HashMap();
                dataListchild.put("name",colldata.getData5());
                dataListchild.put("value",new BigDecimal(colldata.getData6()));
                dataList3.add(dataListchild);
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

        redisCache.setCacheObject(CacheConstants.BIG_GREEN_PAGE_DATA_KEY+"right_data",RightPageData);
        return FebsResponseUtil.success("成功");
    }

}
