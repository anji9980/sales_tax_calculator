package org.apache.taxcalculatorapp.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<ReceiptItem> items = new ArrayList<>();
    private double totalSalesTax = 0.0;
    private double totalAmount = 0.0;

    public void addItem(ReceiptItem item){
        items.add(item);
    }

    public void addSalesTax(double tax){
        totalSalesTax += tax;
    }

    public void addTotalAmount(double amount){
        totalAmount += amount;
    }

    public List<ReceiptItem> getItems(){
        return items;
    }

    public double getTotalSalesTax(){
        return totalSalesTax;
    }

    public double getTotalAmount(){
        return  totalAmount;
    }
}
