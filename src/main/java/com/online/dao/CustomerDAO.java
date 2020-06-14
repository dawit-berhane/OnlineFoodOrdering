package com.online.dao;

import com.online.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO {

    Map<String, Customer> customerDao = new HashMap<>();

    Customer cust1 =  new Customer(1, "John","Walker", "john","1234","123 456 7896", "1000 N 4th Street Fairfield Iowa");
    Customer cust2 =  new Customer(2, "Nathan","James", "nathan","4567","987 456 7896", "963 N 5th Street Demoins Iowa");
    Customer cust3 =  new Customer(3, "Hanna","Scott", "hanna","7896","564 456 7896", "458 S 6th Street Chicago Illinois");

    {
        customerDao.put(cust1.getUserName(),cust1);
        customerDao.put(cust2.getUserName(),cust2);
        customerDao.put(cust3.getUserName(),cust3);
    }

    public void addCustomer(Customer cust){
        customerDao.put(cust.getUserName(), cust);
    }

    public void deleteCustomer(int customerId){
        customerDao.remove(customerId);
    }

    public void updateCustomer(Customer cust){
        customerDao.put(cust.getUserName(), cust);
    }

    public List<Customer> getAllCustomer(){
        return new ArrayList<>(customerDao.values());
    }

    public Customer getCustomerById(int customerId){
        return customerDao.get(customerId);
    }

    public int getId() {
        return customerDao.size()+1;
    }

    public Map<String, Customer> getCustomerDb(){
        return customerDao;
    }
}
