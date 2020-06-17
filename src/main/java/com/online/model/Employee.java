package com.online.model;


import com.online.dao.EmployeeDAO;

public class Employee {
    public enum EmployeeType {
        PERMANENT,TEMPORARY,PART_TIME
    }

    private Integer employeeId;
    private String firstname, lastname;
    private EmployeeType employeeType;
    private int salary;

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Employee(String firstname, String lastname, EmployeeType employeeType, int salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.employeeType = employeeType;
        this.salary = salary;
        this.employeeId = EmployeeDAO.getNextId();
    }

    public Employee(String firstname, String lastname, int salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer foodId) {
        this.employeeId = foodId;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public void setSalary(int price) {
        this.salary = price;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastnmae() {
        return lastname;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", employeeType=" + employeeType +
                ", salary=" + salary +
                '}';
    }
}

