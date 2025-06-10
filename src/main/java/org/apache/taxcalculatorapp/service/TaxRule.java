package org.apache.taxcalculatorapp.service;

import org.apache.taxcalculatorapp.model.Item;

public interface TaxRule {
    double calulateTax(Item item);
}
