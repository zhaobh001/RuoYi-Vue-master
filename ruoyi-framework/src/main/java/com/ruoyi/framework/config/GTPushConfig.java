package com.ruoyi.framework.config;

import com.getui.push.v2.sdk.ApiHelper;
import com.getui.push.v2.sdk.GtApiConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class GTPushConfig {
  @Autowired
  private Environment env;

    @Bean(name = "myApiHelper")
    public ApiHelper apiHelper() {

        GtApiConfiguration apiConfiguration = new GtApiConfiguration();
        //填写应用配置
        apiConfiguration.setAppId(env.getProperty("push.appId"));
        apiConfiguration.setAppKey(env.getProperty("push.appKey"));
        apiConfiguration.setMasterSecret(env.getProperty("push.masterSecret"));
        // 接口调用前缀，请查看文档: 接口调用规范 -> 接口前缀, 可不填写appId
        //默认为https://restapi.getui.com/v2
        apiConfiguration.setDomain("https://restapi.getui.com/v2/");
        // 实例化ApiHelper对象，用于创建接口对象
        ApiHelper apiHelper = ApiHelper.build(apiConfiguration);
        return apiHelper;
    }
}