package com.shop;

public class Users {
    private final int id;
    private final String name;
    private final String surname;
    private final String login;
    private final String password;
    private final boolean adminRights;

    public Users(int id, String name, String surname, String login, String password, boolean admin){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.login=login;
        this.password=password;
        this.adminRights=admin;
    }

    public String getName() {
        return name;
    }

    public boolean isAdminRights() {
        return adminRights;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword(String login,String password) {
        int pass = Database.logging(login,password);
        if(pass==1)
            return this.password;
        else
            return "Incorrect login, password or lack of rights";
    }

    public String getSurname() {
        return surname;
    }
}
