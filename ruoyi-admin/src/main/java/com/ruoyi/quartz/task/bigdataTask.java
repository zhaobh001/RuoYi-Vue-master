package com.ruoyi.quartz.task;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.controller.system.BigScreenDataController;
import com.ruoyi.web.controller.system.ZxdController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 定时任务调度测试
 * @author ruoyi
 */
@Component("bigdataTask")
public class bigdataTask
{
    @Autowired
    private ApplicationContext applicationContext;

    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams() throws IOException {
        BigScreenDataController bean1 = applicationContext.getBean(BigScreenDataController.class);
        bean1.getCenterPageData();
        bean1.getLeftPageData();
        bean1.getRightPageData();
    }
}
