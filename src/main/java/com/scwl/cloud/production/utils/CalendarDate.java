package com.wzb.yd.javase;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Calendar 抽象的日期时间处理类
 */

public class CalendarDate {
    public final static int ERA = 1;

    /**
     * 位移运算 2的0次方 右移一位相当于除2，右移n位相当于除以2的n次方 左移相反
     */

    final static int ERA_MASK = (3 << ERA);

    /**

     1. 程序入口
     2. 能被jvm识别和调用
        public: 因为权限必须是最大的。
        static: 不需要对象，直接用主函数所属类名调用即可。
        void: 主函数没有具体的返回值。
        main:函数名，不是关键字，只是一个jvm识别的固定的名字。
        String[] arg: 这是主函数的参数列表，是一个数组类型的参数，而且元素都是字符串类型的
        main方法作为程序初始线程的起点，任何其他线程均由该线程启动。
        JVM内部有两种线程，非守护线程和守护线程，main方法属于非守护线程，守护线程通常由JVM自己使用
        Java程序也可以表明自己的线程是守护线程。当程序中所有的非守护线程终止时，JVM退出。
        也可以用Runtime类或者System.exit()来退出。


     */
    public static void main(String[] args) {

        // abstract
        Calendar calendar = Calendar.getInstance();

        // calendar 转换为Date类型
        Date date = calendar.getTime();

        // Date类型转换为Calendar类型

        Date dateCalendar = new Date(2018, 8, 20, 12, 24, 34);
        calendar.setTime(dateCalendar);


        System.out.println("打印静态变量" + ERA);
        System.out.println("打印常量" + ERA_MASK);

        System.out.println("calendar转Date当前时间" + date);
        System.out.println("date转calendar" + calendar.getTime());

        /*
        TimeUnit.DAYS          //天
        TimeUnit.HOURS         //小时
        TimeUnit.MINUTES       //分钟
        TimeUnit.SECONDS       //秒
        TimeUnit.MILLISECONDS  //毫秒

        public long toMillis(long d)    //转化成毫秒
        public long toSeconds(long d)  //转化成秒
        public long toMinutes(long d)  //转化成分钟
        public long toHours(long d)    //转化成小时
        public long toDays(long d)     //转化天
         */

        try {

            System.out.println("程序开始");

            Thread.sleep(300);
            //convert 1 day to 24 hour
            System.out.println(TimeUnit.DAYS.toHours(1));

            TimeUnit.MILLISECONDS.sleep(300);
            //convert 1 hour to 60*60 second.
            System.out.println(TimeUnit.HOURS.toSeconds(1));
            //convert 3 days to 72 hours.
            System.out.println(TimeUnit.HOURS.convert(3, TimeUnit.DAYS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
