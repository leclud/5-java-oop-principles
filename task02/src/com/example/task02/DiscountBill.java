package com.example.task02;

public class DiscountBill extends Bill {
    private final int Discount;

    public DiscountBill(int discount) {
        Discount = discount;
    }

    public String getDiscount() {
        return Discount + "%";
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }

    @Override
    public long getPrice() {
        return (super.getPrice() - super.getPrice() * (Discount / 100));
    }
}