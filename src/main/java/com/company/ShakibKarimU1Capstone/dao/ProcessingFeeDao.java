package com.company.ShakibKarimU1Capstone.dao;

import com.company.ShakibKarimU1Capstone.model.ProcessingFee;

import java.math.BigDecimal;

public interface ProcessingFeeDao {
    ProcessingFee getFee(String productType);
}
