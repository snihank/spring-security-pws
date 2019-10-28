package com.company.ShakibKarimU1Capstone.dao;

import com.company.ShakibKarimU1Capstone.model.SalesTaxRate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoTest {

    @Autowired
    SalesTaxRateDao strDao;



    @Test
    public void getSalesTaxByState() {


        SalesTaxRate taxRate = strDao.getSalesTaxByState("NY");

        Assert.assertEquals(new BigDecimal("0.06"),taxRate.getRate());



    }
}