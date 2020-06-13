package com.online.dao;

import com.online.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO {

    Map<Integer, Customer> customerDao = new HashMap<>();

    {
        customerDao.put(1, new Customer(1, "John","Walker", "john","1234","123 456 7896", "1000 N 4th Street Fairfield Iowa"));
        customerDao.put(2, new Customer(2, "Nathan","James", "nathan","4567","987 456 7896", "963 N 5th Street Demoins Iowa"));
        customerDao.put(3, new Customer(3, "Hanna","Scott", "hanna","7896","564 456 7896", "458 S 6th Street Chicago Illinois"));
    }

    public void addCustomer(Customer cust){
        customerDao.put(cust.getId(), cust);
    }

    public void deleteCustomer(int customerId){
        customerDao.remove(customerId);
    }

    public void updateCustomer(Customer cust){
        customerDao.put(cust.getId(), cust);
    }

    public List<Customer> getAllProducts(){
        return new ArrayList<>(customerDao.values());
    }

    public Customer getProductById(int customerId){
        return customerDao.get(customerId);
    }

    public int genId() {
        return customerDao.size()+1;
    }
}
