package com.zcc.study.utils.baseknowledge.thread;

/**
 * @author 赵成成
 * @version 1.0
 * @Description 线程创建方式二---实现Runnable接口
 * @date
 * 创建线程步骤   1.创建一个类实现Runnable接口
 *              2.重新run()方法--run方法中处理线程需要执行的逻辑
 *              3.创建Thread类对象，传入Runnable实现类对象，调用start()f方法启动线程
 */
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            System.out.println("我在看视频..."+i);
        }
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo=new RunnableDemo();
        new Thread(runnableDemo).start();
        for (int i = 0; i <100 ; i++) {
            System.out.println("我在学习..."+i);
        }
    }
}
