package com.zcc.study.utils.baseknowledge.thread;

/**
 * @author 赵成成
 * @version 1.0
 * @Description 静态代理
 * @date
 * 静态代理模式总结
 *   真实对象和代理对象都要实现同一个接口
 *   代理对象要代理真实角色
 * 好处：
 *   代理对象可以做真实对象无法完成的操作
 *   真实对象可以专注做自己的事
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        MarryCompany marryCompany=new MarryCompany(new You());
        marryCompany.happyMarry();
    }

}
interface Marry{
    void happyMarry();
}
//真实角色，结婚
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("我要结婚了");
    }
}
//代理角色，协助结婚的过程
class MarryCompany implements Marry{
    private Marry target;

    public MarryCompany(Marry target){
        this.target=target;
    }
    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚之前布置场地");
    }

    private void after() {
        System.out.println("结婚之后收钱");
    }
}
