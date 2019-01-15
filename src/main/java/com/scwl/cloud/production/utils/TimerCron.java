package com.scwl.cloud.production.utils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * java定时任务实现
 *  A：Timer类
 *  schedule(TimerTask task, long delay) 延迟 delay 毫秒 执行
 *  schedule(TimerTask task, Date time)  特定时间执行
 *  schedule(TimerTask task, long delay, long period) 延迟 delay 执行并每隔period 执行一次
 *
 *  B：ScheduledExecutorService 接口实现类
 *  默认实现为ScheduledThreadPoolExecutor 继承了ThreadPoolExecutor 的线程池特性，配合future特性，比Timer更强大。 具体用法可以阅读JDK文档；spring Task内部也是依靠它实现的
 *
 *  C：Quartz 定时器实现
 *  允许开发人员根据时间间隔来调度作业。它实现了作业和触发器的多对多的关系，还能把多个作业与不同的触发器关联。可以动态的添加删除定时任务，另外很好的支撑集群调度
 *
 * @author weizhibang
 * @date 2018/10/31
 */
public class TimerCron {

    public static void main(String[] args) {
        int cunt = 10;
        for (int i = 0; i < cunt; ++i) {
            new Timer("timer - " + i).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run ");
                }
            }, 3000);
        }

        System.out.println("******begin Timer*******\\n" );
        for (int i =0; i < cunt;i++) {
            new Timer("timer cron- " + i).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run ");
                }
            }, new Date(System.currentTimeMillis() + 2000));
        }

        System.out.println("******begin Timer*******\\n" );
        for (int i = 0; i < 10; ++i) {
            new Timer("timer period - " + i).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run ");
                }
            }, 2000 , 3000);
        }
    }
}
