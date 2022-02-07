package com.dylan.study.JDK_8;

/**
 * 函数式接口中使用泛型
 */

@FunctionalInterface
public interface MyFunction2<T,R> {

    public R getValue(T t1,T t2);

}
