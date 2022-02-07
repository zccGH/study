package com.dylan.study.JDK_8;

public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        if (employee.getAge()>35) {
            return true;
        }
        return false;
    }
}
