package com.ruoyi.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 开启 Spring 定时任务调度，用于 edoc 临时文件清理等 @Scheduled 方法。
 *
 * <p>项目原有定时任务走 Quartz（{@code ruoyi-quartz}），这里的 Spring 调度
 * 仅服务于轻量级的内部清理任务，避免额外在 Quartz 表中配置。
 *
 * @author ruoyi
 */
@Configuration
@EnableScheduling
public class EdocSchedulingConfig
{
}
