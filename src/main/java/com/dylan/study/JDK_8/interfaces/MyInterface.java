package com.dylan.study.JDK_8.interfaces;

/**
 * Java8接口中可以存在默认方法
 */
public interface MyInterface {

    default String getName(){
        return "王奎";
    }

    default void print(){
        System.out.println("接口中的默认方法");
    }

     static void print2(){
        System.out.println("接口中的静态方法");
    }

    public static void print3(){
        System.out.println("接口中的静态方法");
    }

    private static void print4(){
        System.out.println("接口中的静态方法");
    }

}
