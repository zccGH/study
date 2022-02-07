package com.dylan.study.JDK_8;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Set;

public class TestLocalDate {

    @Test
    public void test1(){
        //now() 静态方法，根据当前时间创建对象
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);
        System.out.println("localDateTime = " + localDateTime);

        System.out.println("-------------------------------");

        //of() 静态方法，根据指定日期/时间创建对象
        LocalDate of = LocalDate.of(2022, 1, 21);
        LocalDateTime of1 = LocalDateTime.of(2022, 2, 22, 13, 59, 34);
        LocalDateTime of3 = LocalDateTime.of(2022, Month.of(1), 22, 13, 59, 34);
        LocalTime of2 = LocalTime.of(1, 34, 0);
        System.out.println("of = " + of);
        System.out.println("of1 = " + of1);
        System.out.println("of2 = " + of2);
        System.out.println("of3 = " + of3);

        System.out.println("--------------------------------");

        //plusDays, plusWeeks,plusMonths, plusYears,plusHours,plusMinutes,plusSeconds,plusNanos
        // 向当前 LocalDate,LocalDateTime,LocalTime 对象添加几天、几周、几个月、几年,几小时，几分，几秒，几纳秒
        LocalDateTime localDateTime1 = of1.plusDays(1);
        System.out.println("localDateTime1 = " + localDateTime1);
        LocalDateTime localDateTime2 = of1.plusMonths(2);
        System.out.println("localDateTime2 = " + localDateTime2);
        LocalDateTime localDateTime3 = of1.plusYears(3);
        System.out.println("localDateTime3 = " + localDateTime3);
        LocalDateTime localDateTime5 = localDateTime.plusWeeks(3);
        System.out.println("localDateTime5 = " + localDateTime5);
        LocalDateTime localDateTime4 = of1.plusYears(1).plusMonths(2).plusDays(3);
        System.out.println("localDateTime4 = " + localDateTime4);

        System.out.println("------------------------------");
        //minusDays, minusWeeks,minusMonths, minusYears,minusHours,minusMinutes,minusSeconds,minusNanos
        //从当前 LocalDate,LocalDateTime,LocalTime 对象减去几天、几周、几个月、几年,几小时,几分,几秒,几纳秒
        LocalDateTime localDateTime6 = of1.minusYears(1);
        LocalDateTime localDateTime7 = of1.minusMonths(2);
        LocalDateTime localDateTime8 = of1.minusWeeks(2);
        LocalDateTime localDateTime9 = of1.minusDays(22);
        LocalDateTime localDateTime10 = of1.minusHours(14);
        LocalDateTime localDateTime11 = of1.minusMinutes(60);
        LocalDateTime localDateTime12 = of1.minusSeconds(35);
        LocalDateTime localDateTime13 = of1.minusNanos(32);
        System.out.println("of1 = " + formatDate(of1));
        System.out.println("localDateTime6 = " + formatDate(localDateTime6));
        System.out.println("localDateTime7 = " + formatDate(localDateTime7));
        System.out.println("localDateTime8 = " + formatDate(localDateTime8));
        System.out.println("localDateTime9 = " + formatDate(localDateTime9));
        System.out.println("localDateTime10 = " + formatDate(localDateTime10));
        System.out.println("localDateTime11 = " + formatDate(localDateTime11));
        System.out.println("localDateTime12 = " + formatDate(localDateTime12));
        System.out.println("localDateTime13 = " + formatDate(localDateTime13));

        System.out.println("-----------------------------");
        //plus, minus 添加或减少一个Duration 或 Period
        Duration duration=Duration.ofDays(1);
        Period period=Period.between(LocalDate.of(2021,2,2),LocalDate.of(2021,2,5));
        LocalDateTime localDateTime14 = of1.plus(duration);
        LocalDateTime localDateTime15 = of1.plus(period);
        LocalDateTime localDateTime16 = of1.minus(duration);
        LocalDateTime localDateTime17 = of1.minus(period);
        System.out.println("of1 = " + formatDate(of1));
        System.out.println("localDateTime14 = " + formatDate(localDateTime14));
        System.out.println("localDateTime15 = " + formatDate(localDateTime15));
        System.out.println("localDateTime16 = " + formatDate(localDateTime16));
        System.out.println("localDateTime17 = " + formatDate(localDateTime17));

        System.out.println("----------------------------");

        /**
         * withDayOfMonth,   将月份天数、年份天数、月份、年份,时,分,秒
         * withDayOfYear,    修 改 为 指 定 的 值 并 返 回 新 的
         * withMonth,        LocalDate 对象
         * withYear,
         * withHour,
         * withMinute,
         * withSecond
         */
        LocalDateTime localDateTime18 = of1.withDayOfMonth(5);
        LocalDateTime localDateTime19 = of1.withDayOfYear(123);
        LocalDateTime localDateTime20 = of1.withHour(5);
        LocalDateTime localDateTime21 = of1.withYear(2025);
        LocalDateTime localDateTime22 = of1.withMonth(4);
        LocalDateTime localDateTime23 = of1.withHour(12);
        LocalDateTime localDateTime24 = of1.withMinute(34);
        LocalDateTime localDateTime25 = of1.withSecond(23);
        LocalDateTime localDateTime26 = of1.withNano(123);
        System.out.println("of1 = " +formatDate(of1));
        System.out.println("localDateTime18 = " + formatDate(localDateTime18));
        System.out.println("localDateTime19 = " + formatDate(localDateTime19));
        System.out.println("localDateTime20 = " + formatDate(localDateTime20));
        System.out.println("localDateTime21 = " + formatDate(localDateTime21));
        System.out.println("localDateTime22 = " + formatDate(localDateTime22));
        System.out.println("localDateTime23 = " + formatDate(localDateTime23));
        System.out.println("localDateTime24 = " + formatDate(localDateTime24));
        System.out.println("localDateTime25 = " + formatDate(localDateTime25));
        System.out.println("localDateTime26 = " + formatDate(localDateTime26));

        System.out.println("--------------------------");

        //getDayOfMonth 获得月份天数(1-31)
        int dayOfMonth = of1.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);
        //getDayOfYear 获得年份天数(1-366)
        int dayOfYear = of1.getDayOfYear();
        System.out.println("dayOfYear = " + dayOfYear);
        //getDayOfWeek 获得星期几(返回一个 DayOfWeek枚举值)
        DayOfWeek dayOfWeek = of1.getDayOfWeek();
        int value = dayOfWeek.getValue();
        System.out.println("value = " + value);

        System.out.println("------------------------------");

        /**
         * getMonth() 获得月份-返回一个枚举值
         * getMonthValue 获得月份(1-12)
         * getHour() 获取时
         * getMinute() 获取分
         * getSecond() 获取秒
         */
        Month month = of1.getMonth();
        System.out.println("month.getValue() = " + month.getValue());
        int monthValue = of1.getMonthValue();
        System.out.println("monthValue = " + monthValue);
        int hour = of1.getHour();
        System.out.println("hour = " + hour);
        int minute = of1.getMinute();
        System.out.println("minute = " + minute);
        int second = of1.getSecond();
        System.out.println("second = " + second);

        System.out.println("-------------------------");

        /**
         * isBefore, isAfter 比较两个 LocalDate
         */
        LocalDateTime localDateTime27 = of1.withHour(14);
        System.out.println("of1 = " + formatDate(of1));
        System.out.println("localDateTime27 = " + formatDate(localDateTime27));
        System.out.println("of1.isBefore(localDateTime27) = " + of1.isBefore(localDateTime27));
        System.out.println("of1.isAfter(localDateTime27) = " + of1.isAfter(localDateTime27));

        System.out.println("--------------------------");

        /**
         * isLeapYear 判断是否是闰年--针对LocalDate时间类型
         */
        boolean leapYear = of.isLeapYear();
        System.out.println("of = " + of);
        System.out.println("leapYear = " + leapYear);
    }


    /**
     * 时间日期格式化
     * @param t
     * @param <T>
     * @return
     */
    private static  <T extends TemporalAccessor> String formatDate(T t){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(t);
    }

    /**
     * Instant 时间戳
     * Instant.now()  初始化一个时区对象
     * ZoneId.systemDefault()  获取当前系统默认时区
     * ZoneOffset.UTC  获取UTC时区
     * LocalDateTime.ofInstant(instant,zone)  将时区转化为LocalDateTime，使用指定时区
     * instant.atOffset(ZoneOffset.ofHours(8)) 从当前时间戳对象偏移指定小时
     * Instant.ofEpochSecond(5) 从1970-01-01时间开始偏移5秒
     */
    @Test
    public void test2(){
        //默认使用UTC时区
        Instant instant = Instant.now();
        System.out.println("now = " + instant);
        //系统默认时区--此时为Asia/Shanghai
        ZoneId zone=ZoneId.systemDefault();
        System.out.println("zone = " + zone);
        LocalDateTime localDateTime=LocalDateTime.ofInstant(instant,zone);
        System.out.println("localDateTime = " + formatDate(localDateTime));
        //UTC时区
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        System.out.println("localDateTime1 = " + formatDate(localDateTime1));
        //时区偏移8小时
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);
        //从1970-01-01时间开始偏移5秒
        Instant instant1 = Instant.ofEpochSecond(5);
        System.out.println("instant1 = " + instant1);
    }


    /**
     * Duration:用于计算两个“时间”间隔
     * Period:用于计算两个“日期”间隔
     */
    @Test
    public void test3(){
        Instant instant = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant instant1 = Instant.now();

        Duration between = Duration.between(instant, instant1);
        System.out.println("between = " + between.getSeconds());

        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(2022, 3, 22);
        Period period = Period.between(now, of);
        System.out.println("period = " + period.getDays());
    }

    /**
     * 时间校正器 TemporalAdjuster  根据当前时间获取特定的某个日期
     */
    @Test
    public void test4(){

        //当前月第一天
        LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("date = " + formatDate(dateTime));

        //下一个周一
        LocalDateTime dateTime1 = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("dateTime1 = " + formatDate(dateTime1));
    }

    /**
     * DateTimeFormatter : 解析和格式化日期或时间
     */
    @Test
    public void test5(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        String format = dateTimeFormatter.format(date);
        System.out.println("format = " + format);
        LocalDateTime parse = LocalDateTime.parse(format, dateTimeFormatter);
        System.out.println("parse = " + parse);
    }

    /**
     * 带时区的时间为分别为：ZonedDate、ZonedTime、ZonedDateTime
     * of(id) : 用指定的时区信息获取ZoneId 对象
     * getAvailableZoneIds(): 获取所有的时区信息
     */
    @Test
    public void test6(){
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(ZoneId.systemDefault().toString()));
        System.out.println("localDateTime = " + formatDate(localDateTime));
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }

    /**
     * 传统时间格式与JDK8新时间格式转换
     *
     * 传统时间格式与新时间格式转换：通过Instant时间戳对象转换
     */
    @Test
    public void test7(){
        //Date->LocalDateTime
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("localDateTime = " + formatDate(localDateTime));

        //LocalDateTime->Date
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime1.atZone(ZoneId.systemDefault());
        Date date1 = Date.from(zonedDateTime.toInstant());
        System.out.println("date1 = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1));
    }


}
