package com.dylan.study.JDK_8.lambda;

import com.dylan.study.JDK_8.CalculateNum;
import com.dylan.study.JDK_8.MyFunction;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class TestLambda2 {

    @Test
    public void test1(){
        int num=0;
        //匿名内部类常数项
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("num = " + num);
            }
        };
        runnable.run();

        //Lambda表达式
        Runnable runnable1=()->System.out.println("num = " + num);
        runnable1.run();
    }

    @Test
    public void test2(){
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        };
        consumer.accept("Lambda表达式语法格式二");

        Consumer<String> consumer1=(s)-> System.out.println("s = " + s);
        consumer1.accept("Lambda表达式语法格式二");

        //一个参数时，省略括号
        Consumer<String> consumer2=s-> System.out.println("s = " + s);
        consumer2.accept("一个参数时，省略括号");
    }

    @Test
    public void test3(){
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("Lambda表达式语法格式二");
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(1, 2));

        Comparator<Integer> comparator1=(o1,o2)->{
            System.out.println("Lambda表达式语法格式二");
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(321, 3214));

        Comparator<Integer> comparator2=(o1,o2)->o1.compareTo(o2);
        System.out.println(comparator2.compare(32, 43));

        Comparator<Integer> comparator3=(Integer o1,Integer o2)->Integer.compare(o1,o2);
    }


    @Test
    public void test4(){
        //对一个数进行运算，使用不同的策略
        //策略一：参数*10
        this.option(1,num->num*10);
        //策略二：参数+1
        this.option(3,num->num+1);
    }

    private Integer option(Integer num, CalculateNum calculateNum){
        return calculateNum.calcalateNum(num);
    }

    @Test
    public void test5(){
        String result = this.toUpperCase("dfafdasfdasf", str -> str.toUpperCase());
        System.out.println("result = " + result);
    }
    private String toUpperCase(String str, MyFunction myFunction){
        return myFunction.getValue(str);
    }

}
