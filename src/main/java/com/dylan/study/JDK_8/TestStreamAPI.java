package com.dylan.study.JDK_8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamAPI {
    public static void main(String[] args) {
        /**
         * 1.创建Stream
         *  Collection提供了两个方法 stream()与 parallelStream()
         */
        List<String> list= Lists.newArrayList();
        //创建一个顺序流
        Stream<String> stream = list.stream();
        //创建一个并行流
        Stream<String> parallelStream = list.parallelStream();

        //2.通过Arrays的静态方法stream()创建
        String[] strings = list.toArray(new String[]{});
        Stream<String> stream1 = Arrays.stream(strings);

        //3.通过 Stream 类中的静态方法 of()
        Stream<String> stream2 = Stream.of("张三", "李四", "王五", "刘六", "王维");
        Stream<Employee> stream3 = Stream.of(new Employee(1, "张三", 14, 8976.34));

        //4.使用静态方法Stream.iterate()和Stream.generate()创建无限流
        Stream<Integer> iterate = Stream.iterate(0, x -> x+2).limit(10);
        Stream<Double> generate = Stream.generate(() -> Math.random()).limit(10);


        /**
         * 2.Stream中间操作
         */
        List<Employee> employees=Lists.newArrayList(new Employee(101, "张三", 18, 9999.99),
                new Employee(102, "李四", 59, 6666.66),
                new Employee(103, "王五", 38, 3333.33),
                new Employee(103, "王五", 38, 3333.33),
                new Employee(104, "赵六", 81, 9999.66),
                new Employee(104, "赵七", 18, 3333.33),
                new Employee(104, "赵八", 48, 5555.55),
                new Employee(104, "赵九", 58, 7777.77),
                new Employee(105, "田七", 38, 5555.55));

        //筛选与切片
        Stream<Employee> employeeStream = employees.stream().filter(employee -> {
            return employee.getAge() > 48 && employee.getSalary() > 5000;
        });
        employees.stream().filter(employee -> employee.getSalary()>5000).skip(2);
        employees.stream().filter(employee -> employee.getSalary()>5000).limit(2);
        employees.stream().distinct();


    }

    List<Employee> employees=Lists.newArrayList(new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 38, 3333.33),
            new Employee(103, "王五", 38, 3333.33),
            new Employee(104, "赵六", 81, 9999.66),
            new Employee(104, "赵七", 18, 3333.33),
            new Employee(104, "赵七", 48, 5555.55),
            new Employee(104, "赵九", 58, 7777.77),
            new Employee(105, "田七", 38, 5555.55));

    @Test
    public void test(){
        //映射
        Integer[] num=new Integer[]{2,3,4,5,6,7};
        //把num数组中每个元素做平方运算，产生一个新的数组
        List<Integer> collect = Arrays.stream(num).map(x -> x * x).collect(Collectors.toList());
        Integer[] integers = collect.toArray(new Integer[]{});
        //如何根据map()和reduce()函数获取集合长度
        Stream<Integer> integerStream = employees.stream().map(e -> 1);
        //integerStream.forEach(System.out::println);
        Optional<Integer> reduce = integerStream
                .reduce(Integer::sum);
        System.out.println(reduce.get());

        employees.stream().mapToDouble((e)->e.getSalary()).forEach(System.out::println);

    }


    @Test
    public void test1(){

        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        Stream<String> stream = strList.stream()
                .map(String::toUpperCase);

        stream.forEach(System.out::println);

        Stream<Stream<Character>> stream2 = strList.stream()
                .map(TestStreamAPI::filterCharacter);

        stream2.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("---------------------------------------------");

        Stream<Character> stream3 = strList.stream()
                .flatMap(TestStreamAPI::filterCharacter);

        stream3.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }

    /**
     * sorted() 自然排序
     * sorted(Comparator<? super T> comparator)——定制排序
     */

    @Test
    public void Test2(){
        employees.stream().map(Employee::getName).sorted().forEach(System.out::println);
        System.out.println("----------------");
        employees.stream().map(Employee::getSalary).sorted().forEach(System.out::println);

        //定制排序
        employees.stream().sorted((e1,e2)->{
            if (e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        }).forEach(System.out::println);
    }

    /**
     * 终止操作
     * allMatch-检查是否匹配所有元素
     * anyMatch-检查是否至少匹配一个元素
     * noneMathc-检查是否没有元素匹配
     * findFirst-返回第一个元素
     * findAny-返回流中任意一个元素
     * count-返回流中元素个数
     * max-返回流中的最大值
     * min-返回流中的最小值
     */
    @Test
    public void Test3(){
        //判断每一个员工的工资是否大于5000

        boolean b = employees.stream().allMatch(e -> e.getSalary() > 3000);

        boolean b1 = employees.stream().anyMatch(e -> e.getName().substring(0, 1).equals("赵"));

        boolean b2 = employees.stream().noneMatch(e -> e.getAge() < 10);

        Optional<Employee> first = employees.stream().findFirst();

        Optional<Employee> any = employees.stream().findAny();

        long count = employees.stream().count();

        Optional<Employee> max = employees.stream().max((e1, e2) -> {
            return Double.compare(e1.getSalary(), e2.getSalary());
        });
    }


    /**
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
     */
    @Test
    public void Test4(){
        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(20, (x, y) -> x + y);

        //计算所有员工的工资和
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce((x, y) -> x + y);

        //统计所有员工的名字含有“六”字的个数
        Integer count = employees.stream().map(Employee::getName)
                .flatMap(TestStreamAPI::filterCharacter)//将员工所有名字转换为字符流
                .map(x -> {
                    if (x.equals('六')) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .reduce(Integer::sum).get();
    }

    /**
     * 将字符串转换为字符流
     * @param args
     * @return
     */
    private Stream<Character> strToCharStream(String args){
        List<Character> list=Lists.newArrayList();
        for (char c : args.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     *  collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test5(){
        //把元素收集到list
        List<Double> salarys = employees.stream().map(Employee::getSalary).collect(Collectors.toList());
        //把元素收集到set
        Set<String> nameSet = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        //把元素收集到新创建的集合
        ArrayList<Employee> employees1 = employees.stream().collect(Collectors.toCollection(ArrayList::new));
        //计算流中元素的个数
        Long collect = employees.stream().collect(Collectors.counting());
        /**
         * 对流中元素属性求和
         * 1.计算double型属性
         * Collectors.summarizingDouble()------>DoubleSummaryStatistics{count=9, sum=55555.170000, min=3333.330000, average=6172.796667, max=9999.990000}
         * Collectors.summingDouble()-------->aDouble = 55555.17
         * 2.计算int型属性
         * Collectors.summarizingInt()
         * Collectors.summingInt()
         * 3.计算long型属性
         * Collectors.summarizingLong()
         * Collectors.summingLong()
         */
        DoubleSummaryStatistics summaryStatistics = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        Double aDouble = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        /**
         * 对流中元素属性求平均值
         * 1.计算double型属性
         * Collectors.averagingDouble()
         * 2.计算int型属性
         * Collectors.averagingInt()
         * 3.计算long型属性
         * Collectors.averagingLong()
         */
        Double aDouble1 = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));

        //连接流中的字符串
        String collect1 = employees.stream().map(Employee::getName).collect(Collectors.joining());
        //根据比较器选择最大值
        Optional<Employee> collect2 = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        Optional<Double> collect3 = employees.stream().map(Employee::getSalary).collect(Collectors.maxBy(Double::compareTo));
        //根据比较器选择最小值
        Optional<Employee> collect4 = employees.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getName)));
        Optional<String> collect5 = employees.stream().map(Employee::getName).collect(Collectors.minBy(String::compareTo));
        //从一个作为累加器的初始值开始，利用BinaryOperator与流中元素逐个结合，从而归约成单个值
        Integer collect6 = employees.stream().collect(Collectors.reducing(0, Employee::getAge, Integer::sum));
        //包裹另一个收集器，对其结果转换函数
        Object[] collect7 = employees.stream().collect(Collectors.collectingAndThen(Collectors.toList(), (e) -> e.toArray()));
        //根据某属性值对流分组，属性为K，结果为V
        Map<String, List<Employee>> collect8 = employees.stream().collect(Collectors.groupingBy(Employee::getName));
        //根据true或false进行分区
        Map<Boolean, List<Employee>> collect9 = employees.stream().collect(Collectors.partitioningBy((e) -> e.getAge() > 35));

    }

    /**
     *  并行流/串行流
     */
    @Test
    public void test6(){

        long start = System.currentTimeMillis();
        //并行流
        Map<String, Double> map = employees.stream().parallel().collect(Collectors.toMap(Employee::getName, Employee::getSalary, (k1, k2) -> k2));
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        long start1 = System.currentTimeMillis();
        //串行流
        Map<String, Double> map1 = employees.stream().sequential().collect(Collectors.toMap(Employee::getName, Employee::getSalary, (k1, k2) -> k2));
        for (Map.Entry<String, Double> entry : map1.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

    }


}
