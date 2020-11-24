package com.zcc.study.utils.baseknowledge.thread;

/**
 * @author 赵成成
 * @version 1.0
 * @Description 利用买票来模拟多线程并发问题--多个线程操作统一资源，导致数据紊乱
 * @date
 */
public class Subsequent implements Runnable {
    private static int ticket=100;//模拟100张票

    @Override
    public void run() {
        //买票
        while (true){
            if (ticket<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"买了第"+ticket+"张票");
            ticket--;
        }
    }

    public static void main(String[] args) {
        //创建三个线程来模拟买票
        Subsequent s1=new Subsequent();
        //创建Thread线程对象--此处Thread充当代理对象角色
        Thread thread1=new Thread(s1,"老王");
        Thread thread2=new Thread(s1,"老李");
        Thread thread3=new Thread(s1,"黄牛");

        thread1.start();
        thread2.start();
        thread3.start();



    }
}

//利用多线程模拟龟兔赛跑
class Race implements Runnable{
    private static String winner;//胜利者
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子")&&i==10){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag=gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }


    }

    private boolean gameOver(int steps) {
        if (winner!=null){//已经存在胜利者
            return true;
        }else {
            if (steps>=100){
                winner=Thread.currentThread().getName();
                System.out.println("胜利者是："+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race=new Race();
        new Thread(race, "乌龟").start();
        new Thread(race, "兔子").start();
    }
}
