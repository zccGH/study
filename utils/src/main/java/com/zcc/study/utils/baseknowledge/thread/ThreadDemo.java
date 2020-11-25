package com.zcc.study.utils.baseknowledge.thread;

/**
 * @author 赵成成
 * @version 1.0
 * @Description 线程创建方式一   定义一个类继承Thread类
 * @date
 * 创建线程步骤：1.创建一个类，继承Thread类
 *            2.重写run方法---run方法中执行线程需要执行的逻辑
 *            3.创建子类对象，调用start()方法启动线程---调用start()方法，线程不会立即启动，线程的运行有cpu分配调度
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <=20 ; i++) {
            System.out.println(Thread.currentThread().getName()+"正在看视频..."+i);
        }
    }

    /**
     * main函数相当与一个主线程
     * @param args
     */
    public static void main(String[] args) {
        ThreadDemo threadDemo=new ThreadDemo();
        threadDemo.start();
        for (int i = 0; i <=100 ; i++) {
            System.out.println("我正在学习..."+i);
        }
    }

}
