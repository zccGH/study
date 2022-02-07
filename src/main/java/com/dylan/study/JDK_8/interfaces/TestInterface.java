package com.dylan.study.JDK_8.interfaces;

import org.junit.Test;

public class TestInterface {

    @Test
    public void test(){
        SubClass subClass=new SubClass();
        String name = subClass.getName();
        System.out.println("name = " + name);
    }
}
