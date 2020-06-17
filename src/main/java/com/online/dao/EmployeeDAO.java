package com.online.dao;

;

import com.online.model.Employee;
import com.online.model.Employee.EmployeeType;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDAO {
    public static Map<Integer, Employee> employeedb = new HashMap<>();

    private static Integer nextId = 1;

    public static Integer getNextId() {
        return nextId++;
    }

    static {
        Employee employee1 = new Employee("bekalu","assegid", EmployeeType.PERMANENT, 41);
        Employee employee2 = new Employee("john","michle", EmployeeType.TEMPORARY,44);
        Employee employee3 = new Employee("helen","dani", EmployeeType.PART_TIME,43);


        employeedb.put( employee1.getEmployeeId(), employee1);
        employeedb.put(employee2.getEmployeeId(), employee2);
        employeedb.put(employee3.getEmployeeId(), employee3);

    }

    public void addEmployee(Employee employee) {employeedb.put(employee.getEmployeeId(),employee);}
    public void deleteEmployee(int employeeId){
        employeedb.remove(employeeId);
    }

    public void updateEmployee(Employee employee){
        employeedb.put(employee.getEmployeeId(), employee);
    }

    public List<Employee> getAllEmployee(){
        return new ArrayList<>(employeedb.values());
    }
    public Optional<Employee> getEmployeeByName(String name){
        return employeedb.values().stream()
                .filter(f -> f.getFirstname().toLowerCase().equals(name.toLowerCase()))
                .findAny();
    }
    public int genId() { return employeedb.size()+1; }

    public Optional<Employee> findById(Integer id) {
        return Optional.ofNullable(employeedb.get(id));
    }
    public boolean remove(Employee employee) {
        return employeedb.remove(employee.getEmployeeId()) == null;
    }

    public Collection<Employee> getEmployeeByType(String employeeType) {
        if (employeeType.equals("ALL")) return getAllEmployee();
        return getAllEmployee().stream().filter(f -> f.getEmployeeType().toString().equals(employeeType)).collect(Collectors.toList());
    }
}

