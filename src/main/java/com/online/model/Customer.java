package com.online.model;

public class Customer {
    private int id;
    private String fname;
    private String lname;
    private String userName;
    private String password;
    private String tel;
    private String address;

    private Cart cart;

    public Customer(){
        super();
    }
    public Customer(int id, String fname, String lname, String userName, String password, String tel, String address){
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.userName = userName;
        this.password= password;
        this. tel = tel;
        this.address = address;
    }
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public Cart getCart(){
        return cart;
    }


}
