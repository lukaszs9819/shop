package com.shop;

public class Orders {
    private final int id;
    private final String name;
    private final String surname;
    private final String addres;
    private final String code;
    private final String city;
    private final String payment;

    public Orders(int id, String name, String surname, String addres, String code, String city, String payment){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.addres=addres;
        this.code=code;
        this.city=city;
        this.payment=payment;
    }


    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getAddres() {
        return addres;
    }

    public String getCity() {
        return city;
    }

    public String getPayment() {
        return payment;
    }
}
