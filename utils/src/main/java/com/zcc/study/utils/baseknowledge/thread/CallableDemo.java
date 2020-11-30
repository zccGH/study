package com.zcc.study.utils.baseknowledge.thread;

import java.util.concurrent.*;

/**
 * @author 赵成成
 * @version 1.0
 * @Description 线程创建方式三--实现callable接口
 * @date
 * 实现Callable接口创建线程步骤：
 *       1.创建类，实现Callable接口，使该类具有线程特征
 *       2.重写call()方法
 *       3.创建自定义线程类对象
 *       4.创建执行服务
 *       5.使用服务启动线程
 *       6.获取线程执行结果
 *       7.关闭服务
 */
public class CallableDemo implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"在第"+i+"次循环执行");
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo c1=new CallableDemo();
        CallableDemo c2=new CallableDemo();
        CallableDemo c3=new CallableDemo();
        //创建执行服务
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> s1 = executorService.submit(c1);
        Future<Boolean> s2 = executorService.submit(c2);
        Future<Boolean> s3 = executorService.submit(c3);

        //获取结果
        Boolean b2 = s1.get();
        Boolean b1 = s2.get();
        Boolean b3 = s3.get();
        //关闭服务
        executorService.shutdown();

    }
}
