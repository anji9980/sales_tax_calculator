package org.apache.javadsa;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<ReceiptItem> items = new ArrayList<>();

    public void addItem(ReceiptItem item) {
        items.add(item);
    }

    public double getTotalSalesTax() {
        return items.stream().mapToDouble(ReceiptItem::getSalesTax).sum();
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(ReceiptItem::getTotalPrice).sum();
    }

    public List<ReceiptItem> getItems() {
        return items;
    }
}
