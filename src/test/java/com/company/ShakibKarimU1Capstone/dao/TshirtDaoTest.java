package com.company.ShakibKarimU1Capstone.dao;

import com.company.ShakibKarimU1Capstone.model.TShirt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TshirtDaoTest {

    @Autowired
    TshirtDao tshirtDao;

    @Before
    public void setUp() throws Exception {

        List<TShirt> tshirt = tshirtDao.getAllTshirts();
        for (TShirt t : tshirt) {
            tshirtDao.deleteTshirt(t.gettShirtId());
        }

    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void addGetDeleteTshirt(){
//        TShirt t = new TShirt();
//        t.setSize("Test");
//        t.setColor("Test");
//        t.setDescription("Test");
//        t.setPrice(new BigDecimal("10.50"));
//        t.setQuantity(10);
//
//        t = tshirtDao.createTshirt(t);
//
//        TShirt t1 = tshirtDao.getTshirt(t.gettShirtId());
//        assertEquals(t1,t);
//
//        tshirtDao.deleteTshirt(t.gettShirtId());
//        t1 = tshirtDao.getTshirt(t.gettShirtId());
//        assertNull(t1);
//    }

    @Test
    public void getAllTshirts() {
        TShirt t = new TShirt();
        t.setSize("Test");
        t.setColor("Test");
        t.setDescription("Test");
        t.setPrice(new BigDecimal("10.50"));
        t.setQuantity(10);

        t = tshirtDao.createTshirt(t);

        t = new TShirt();
        t.setSize("Test1");
        t.setColor("Test1");
        t.setDescription("Test1");
        t.setPrice(new BigDecimal("10.50"));
        t.setQuantity(20);
        tshirtDao.createTshirt(t);

        List<TShirt> tList = tshirtDao.getAllTshirts();
        assertEquals(2, tList.size());
    }

    @Test
    public void updateTshirt() {
        TShirt t = new TShirt();
        t.setSize("Test");
        t.setColor("Test");
        t.setDescription("Test");
        t.setPrice(new BigDecimal("10.50"));
        t.setQuantity(10);

        t = tshirtDao.createTshirt(t);

        t.setDescription("Test1");
        t.setPrice(new BigDecimal("11.50"));
        t.setQuantity(15);
        tshirtDao.updateTshirt(t);

        TShirt t1 = tshirtDao.getTshirt(t.gettShirtId());
        assertEquals(t1,t);

    }


    @Test
    public void getTshirtByColor() {
        TShirt t = new TShirt();
        t.setSize("Test");
        t.setColor("Test");
        t.setDescription("Test");
        t.setPrice(new BigDecimal("10.50"));
        t.setQuantity(10);

        t = tshirtDao.createTshirt(t);

        t = new TShirt();
        t.setSize("Test1");
        t.setColor("Test");
        t.setDescription("Test1");
        t.setPrice(new BigDecimal("11.50"));
        t.setQuantity(15);

        t = tshirtDao.createTshirt(t);

        List<TShirt> tList = tshirtDao.getTshirtByColor("Test");
        assertEquals(2,tList.size());
    }

    @Test
    public void getTshirtBySize() {
        TShirt t = new TShirt();
        t.setSize("M");
        t.setColor("Test");
        t.setDescription("Test");
        t.setPrice(new BigDecimal("10.50"));
        t.setQuantity(10);

        t = tshirtDao.createTshirt(t);

        t = new TShirt();
        t.setSize("M");
        t.setColor("Test");
        t.setDescription("Test1");
        t.setPrice(new BigDecimal("11.50"));
        t.setQuantity(15);

        t = tshirtDao.createTshirt(t);

        List<TShirt> tList = tshirtDao.getTshirtBySize("M");
        assertEquals(2,tList.size());
    }
}