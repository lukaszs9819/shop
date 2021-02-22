package com.shop;

public class Product {
    private final int barcode;
    private final String name;
    private final float price;
    private final float amount;
    private String Category = null;
    private float amountMinus=0;
    private final String provider;

    public Product(int barcode, String name, float price, float amount, String provider){
        this.barcode= barcode;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.provider = provider;
    }

    public float getPrice() {
        return price;
    }

    public int getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmountMinus(float amountMinus) {
        this.amountMinus = amountMinus;
    }

    public float getAmountMinus() {
        return amountMinus;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getProvider() {
        return provider;
    }
}




