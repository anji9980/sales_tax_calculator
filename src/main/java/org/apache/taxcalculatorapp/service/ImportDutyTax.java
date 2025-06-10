package org.apache.taxcalculatorapp.service;

import org.apache.taxcalculatorapp.model.Item;
import org.apache.taxcalculatorapp.model.TaxRate;

public class ImportDutyTax implements TaxRule{
    @Override
    public double calulateTax(Item item) {
        return item.isImported() ? item.getPrice() * TaxRate.IMPORT_DUTY : 0.0;
    }
}
