package com.company.ShakibKarimU1Capstone.dao;

import com.company.ShakibKarimU1Capstone.model.SalesTaxRate;

import java.math.BigDecimal;
import java.util.List;

public interface SalesTaxRateDao {

    SalesTaxRate getSalesTaxByState(String state);
//    List<SalesTaxRate> getAllSalesTax();
//    void deleteSalesTaxRate();

}
