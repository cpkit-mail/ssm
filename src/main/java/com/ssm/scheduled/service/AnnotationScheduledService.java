package com.ssm.scheduled.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 基于注解的定时器
 */
// 注解一定要加上，不然定时器不会执行
@Component
public class AnnotationScheduledService {

    /**
     * 定时计算。每天凌晨 01:00 执行一次
     */
    @Scheduled(cron = "0 0 1 * * *")
    public void show() {
//        System.out.println("Annotation：is show run");
    }

    /**
     * 心跳更新。启动时执行一次，之后每隔2秒执行一次
     */
    @Scheduled(fixedRate = 1000 * 2)
    public void print() {
//        System.out.println("Annotation：print run");
    }
}