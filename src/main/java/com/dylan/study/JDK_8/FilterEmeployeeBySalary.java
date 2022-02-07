package com.dylan.study.JDK_8;

public class FilterEmeployeeBySalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        if (employee.getSalary()>5000) {
            return true;
        }
        return false;
    }
}
