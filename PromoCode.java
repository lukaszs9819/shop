package com.shop;

public class PromoCode {
    private final int discount;
    private final String code;

    public PromoCode(int discount, String code){
        this.discount=discount;
        this.code=code;
    }

    public int getDiscount() {
        return discount;
    }

    public String getCode() {
        return code;
    }
}
