package com.dylan.study.JDK_8.lambda;

import com.dylan.study.JDK_8.Employee;
import com.dylan.study.JDK_8.FilterEmeployeeBySalary;
import com.dylan.study.JDK_8.FilterEmployeeByAge;
import com.dylan.study.JDK_8.MyPredicate;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class TestLambda1 {

    List<Employee> ems= Arrays.asList(new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 6666.66),
            new Employee(104, "赵七", 8, 3333.33),
            new Employee(104, "赵八", 8, 5555.55),
            new Employee(104, "赵九", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );


    /**
     * 原来的匿名内部类
     */
    @Test
    public void test1(){
        Comparator<String> comparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };
        TreeSet<String> treeSet=new TreeSet<>(comparator);
        treeSet.add("sfdsfds");
        treeSet.add("fdasfdsa");
        treeSet.add("fdadssa");
        treeSet.add("gfgffg");
        treeSet.add("hgghghg");
        for (Iterator i=treeSet.iterator();i.hasNext();){
            System.out.println(i.next());
        }
    }

    /**
     * lambda表达式
     */
    @Test
    public void test2(){
        Comparator<String> com=(x,y)->Integer.compare(x.length(),y.length());
        TreeSet<String> treeSet=new TreeSet<>(com);
        treeSet.add("sfdsfds");
        treeSet.add("fdasfdsa");
        treeSet.add("fdadssa");
        treeSet.add("gfgffg");
        treeSet.add("hgghghg");
        for (Iterator i=treeSet.iterator();i.hasNext();){
            System.out.println(i.next());
        }
    }

    /**
     * 方法一：获取公司中年龄小于 35 的员工信息
     */
    private List<Employee> getEmps(List<Employee> ems){
        List<Employee> employees= Lists.newArrayList();
        if (!Objects.isNull(ems)&&!ems.isEmpty()) {
            for (Employee em : ems) {
                if (em.getAge()<35) {
                    employees.add(em);
                }
            }
        }
        return employees;
    }

    //方法二：获取公司中工资大于 5000 的员工信息
    private List<Employee> filterEmployeeSalary(List<Employee> emps){
        List<Employee> list = new ArrayList<>();

        for (Employee emp : emps) {
            if(emp.getSalary() >= 5000){
                list.add(emp);
            }
        }

        return list;
    }

    @Test
    public void test3(){
       this.getEmps(this.ems).forEach(System.out::println);
       this.filterEmployeeSalary(this.ems).forEach(System.out::println);
    }

    /**
     * 策略设计模式，针对方法一，二进行优化
     * 策略设计模式实现：1.函数式接口定义规范 2.创建不同的子类，实现不同的执行策略（具体执行策略由执行的方法确定）
     */
    private List<Employee> filterListByConditon(List<Employee> ems, MyPredicate<Employee> myPredicate){
        List<Employee> employees=Lists.newArrayList();
        if (!Objects.isNull(ems)&&!ems.isEmpty()) {
            for (Employee em : ems) {
                if (myPredicate.test(em)) {
                    employees.add(em);
                }
            }
        }
        return employees;
    }

    @Test
    public void test4(){
        //年龄大于35岁的员工
        this.filterListByConditon(this.ems,new FilterEmployeeByAge()).forEach(System.out::println);
        //工资大于5000的员工
        System.out.println("-------------------------");
        this.filterListByConditon(this.ems,new FilterEmeployeeBySalary()).forEach(System.out::println);
    }

    /**
     * 使用匿名内部类,不需要再创建实现类执行策略，可以更灵活的调整策略
     */
    @Test
    public void test5(){
        //赵姓员工
        this.filterListByConditon(this.ems, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                //
                return employee.getName().substring(0,1).equals("赵");
            }
        }).forEach(System.out::println);
        //赵姓 工资大于5000的员工
        System.out.println("-------------------------");
        this.filterListByConditon(this.ems, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getName().substring(0,1).equals("赵") && employee.getSalary()>5000;
            }
        }).forEach(System.out::println);
    }

    /**
     * 使用lambda表达式改写匿名内部类的写法
     */
    @Test
    public void test6(){
        //赵姓员工
        this.filterListByConditon(this.ems,
                (e)->e.getName().substring(0,1).equals("赵"))
                .forEach(System.out::println);
        //赵姓 工资大于5000的员工
        System.out.println("-------------------------");
        this.filterListByConditon(this.ems,
                (e)->e.getName().substring(0,1).equals("赵")&&e.getSalary()>5000)
                .forEach(System.out::println);
    }

    /**
     * 使用Stream API实现对集合数据的操作
     */
    @Test
    public void test7(){
        //赵姓员工
        this.ems.stream()
                .filter((e)->e.getName().substring(0,1).equals("赵"))
                .forEach(System.out::println);
        //赵姓 工资大于5000的员工
        System.out.println("-----------------------");
        this.ems.stream()
                .filter(employee -> employee.getName().substring(0,1).equals("赵")&& employee.getSalary()>5000)
                .forEach(System.out::println);
    }




}
