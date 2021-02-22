package com.shop;

public class Providers {
    private final double nip;
    private final String adres;
    private final String name;

    public Providers(double nip,String adres,String name){
        this.nip=nip;
        this.adres=adres;
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public double getNip() {
        return nip;
    }

    public String getAdres() {
        return adres;
    }
}
