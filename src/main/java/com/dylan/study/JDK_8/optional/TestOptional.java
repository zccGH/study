package com.dylan.study.JDK_8.optional;

import com.dylan.study.JDK_8.Employee;
import org.junit.Test;

import java.util.Objects;
import java.util.Optional;

public class TestOptional {

    /**
     * Optional.of(T t) : 创建一个 Optional 实例
     */
    @Test
    public void test(){
        Optional<Employee> employee = Optional.of(new Employee());
        Employee employee1 = employee.get();
        System.out.println("employee1 = " + employee1);
    }


    /**
     * Optional.empty() : 创建一个空的 Optional 实例
     * Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
     */
    @Test
    public void test1(){
        Optional<Object> empty = Optional.empty();
        Object o = empty.get();
        System.out.println("o = " + o);
        Optional<Object> o1 = Optional.ofNullable(null);
        Object o2 = o1.get();
        System.out.println("o2 = " + o2);
    }

    /**
     * isPresent() : 判断是否包含值
     * orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
     * orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
     */
    @Test
    public void test2(){
        Optional<Employee> employee = Optional.of(new Employee());
        if (employee.isPresent()) {
            Employee employee1 = employee.get();
            System.out.println("employee1 = " + employee1);
        }
        Employee employee1 = employee.orElse(new Employee("张飒"));

        Employee employee2 = employee.orElseGet(Employee::new);
    }

    /**
     * map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
     * flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
     */
    @Test
    public void test3(){
        Optional<Employee> employee = Optional.of(new Employee(1, "王论悟", 32, 999.99));
        Optional<String> name = employee.map(Employee::getName);
        Optional<String> name1 = employee.flatMap((e) -> Optional.of(e.getName()));
    }


    @Test
    public void test4(){
       Goddess goddess=new Goddess("高圆圆");
       Man man=new Man("赵又廷",goddess);
        String goddessName = getGoddessName(man);
    }
    private String getGoddessName(Man man){
        String name="";
        if (!Objects.isNull(man)) {
            Goddess goddess = man.getGoddess();
            if (!Objects.isNull(goddess)) {
                 name = goddess.getName();
            }
        }
        return name;
    }

    @Test
    public void test5(){
        NewMan newMan=new NewMan("周芷若",Optional.of(new Goddess()),null);
        String goddessName2 = getGoddessName2(Optional.ofNullable(newMan));
        System.out.println("goddessName2 = " + goddessName2);
    }

    private String getGoddessName2(Optional<NewMan> newMan){
        return newMan.orElse(new NewMan())
                .getGoddess()
                .orElse(new Goddess("高圆圆"))
                .getName();

    }


}
