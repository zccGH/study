package com.dylan.study.JDK_8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 */
public class TestMethodRef {

    /**
     * 对象名::实例方法名
     */
    @Test
    public void test1(){
        Employee employee=new Employee(1,"张三",15,5555.55);
        Supplier<String> supplier=employee::getName;
        System.out.println(supplier.get());
    }


    /**
     * 类名::静态方法名
     */
    @Test
    public void test2(){
        Comparator<Integer> comparator=(x,y)->Integer.compare(x,y);
        System.out.println(comparator.compare(1, 2));

        Comparator<Integer> comparator1=Integer::compare;
        System.out.println(comparator1.compare(1, 2));

    }

    /**
     * 类名::实例方法名
     */
    @Test
    public void test3(){
        BiFunction<String,String,Boolean> biFunction=(x,y)->x.equals(y);
        System.out.println(biFunction.apply("方法引用", "方法引用"));

        BiFunction<String,String,Boolean> biFunction1=String::equals;
        System.out.println(biFunction1.apply("方法引用", "方法引用"));

    }

    /**
     * 构造器引用
     */
    @Test
    public void test4(){
       Employee employee=new Employee(1);
       Function<Integer,Employee> function=Employee::new;
       Employee employee1 = function.apply(1);

       Employee employee2=new Employee("张三",15);
       BiFunction<String,Integer,Employee> function1=Employee::new;
       Employee employee3 = function1.apply("张三", 34);

    }

    /**
     * 数组引用
     */
    @Test
    public void test5(){
       String[] str=new String[8];
       Function<Integer,String[]> biFunction1=(x)->new String[x];
       Function<Integer,String[]> biFunction=String[]::new;
    }






}
