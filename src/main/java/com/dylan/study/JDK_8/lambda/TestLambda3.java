package com.dylan.study.JDK_8.lambda;

import com.dylan.study.JDK_8.Employee;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java内置四大函数型接口
 */
public class TestLambda3 {

    /**
     * 消费型接口
     */
    @Test
    public void test1(){
        Consumer<List<Employee>> consumer=(employees)->{
          employees.add(new Employee(1,"张三",63,666.3));
          employees.add(new Employee(2,"李四",45,654.3));
          employees.add(new Employee(3,"王五",36,785.6));
        };
        List<Employee> employees= Lists.newArrayList();
        this.optionList(employees,consumer);
    }

    public void optionList(List<Employee> employees,Consumer<List<Employee>> consumer){
         consumer.accept(employees);
    }

    /**
     * 供给型接口  1641396984526
     */
    @Test
    public void test2(){
        Supplier<Employee> supplier=()->{
            Employee employee=new Employee();
            employee.setId(Integer.parseInt(String.valueOf(System.currentTimeMillis()).substring(10,13)));
            employee.setAge(Math.getExponent((Math.random()+1)*10));
            employee.setName("张三");
            employee.setSalary(Math.ceil((Math.random()+1000)*1000)/100);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return employee;
        };
        List<Employee> employees=Lists.newArrayList();

        this.getEmployee(employees,supplier).forEach(System.out::println);
    }

    private List<Employee> getEmployee(List<Employee> employees,Supplier<Employee> supplier){
        for (int i = 0; i < 20; i++) {
            employees.add(supplier.get());
        }
        return employees;
    }

    /**
     * 函数型接口
     */
    @Test
    public void test3(){
        Function<List<Employee>, Map<String,String>> function=(e)->{
            Map<String,String> map= Maps.newHashMap();
            for (Employee employee : e) {
                map.put(employee.getName(),String.valueOf(employee.getSalary()));
            }
            return map;
        };
        List<Employee> ems= Arrays.asList(new Employee(101, "张三", 18, 9999.99),
                new Employee(102, "李四", 59, 6666.66),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 8, 6666.66),
                new Employee(104, "赵七", 8, 3333.33),
                new Employee(104, "赵八", 8, 5555.55),
                new Employee(104, "赵九", 8, 7777.77),
                new Employee(105, "田七", 38, 6555.55),
                new Employee(105, "田七", 54, 8555.55)
        );
        Map<String, String> employeeMap = this.getEmployeeMap(ems, function);

    }

    private Map<String,String> getEmployeeMap(List<Employee> employees,Function<List<Employee>,Map<String,String>> function){
        return function.apply(employees);
    }

    /**
     * 断定接口
     */
    @Test
    public void test4(){
        Predicate<Employee> predicate=(e)->{
         return e.getSalary()>5000&&e.getName().substring(0,1).equals("田");
        };
        List<Employee> ems= Arrays.asList(new Employee(101, "张三", 18, 9999.99),
                new Employee(102, "李四", 59, 6666.66),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 8, 6666.66),
                new Employee(104, "赵七", 8, 3333.33),
                new Employee(104, "赵八", 8, 5555.55),
                new Employee(104, "赵九", 8, 7777.77),
                new Employee(105, "田七", 38, 6555.55),
                new Employee(105, "田七", 28, 5555.55),
                new Employee(105, "田七", 18, 4555.55),
                new Employee(105, "田七", 34, 7555.55),
                new Employee(105, "田七", 54, 8555.55)
        );
        this.filterList(ems,predicate).forEach(System.out::println);

    }

    private List<Employee> filterList(List<Employee> employees,Predicate<Employee> predicate){
        List<Employee> employees1=Lists.newArrayList();
        if (!Objects.isNull(employees)&&!employees.isEmpty()) {
            for (Employee employee : employees) {
                if (predicate.test(employee)) {
                    employees1.add(employee);
                }
            }
        }
        return employees1;
    }
}
