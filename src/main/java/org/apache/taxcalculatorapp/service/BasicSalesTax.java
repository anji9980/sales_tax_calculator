package org.apache.taxcalculatorapp.service;

import org.apache.taxcalculatorapp.model.Item;
import org.apache.taxcalculatorapp.model.TaxRate;

public class BasicSalesTax implements TaxRule{

    @Override
    public double calulateTax(Item item) {
        return item.isExempt() ? 0.0 : item.getPrice()* TaxRate.BASIC_SALES_TAX;
    }
}
