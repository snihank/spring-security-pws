package com.company.ShakibKarimU1Capstone.dao;



import com.company.ShakibKarimU1Capstone.model.Console;
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
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        List<Console> console = consoleDao.getAllConsoles();
        for (Console con : console) {
            consoleDao.deleteConsole(con.getConsoleId());
        }

    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setModel("Test");
        console.setManufacturer("Test");
        console.setMemoryAmount("Test");
        console.setProcessor("Test");
        console.setPrice(new BigDecimal("10.50"));
        console.setQuantity(10);

        console = consoleDao.createConsole(console);

        Console c1 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(c1,console);

//        consoleDao.deleteConsole(console.getConsoleId());
//        c1 = consoleDao.getConsole(console.getConsoleId());
//        assertNull(c1);
    }



    @Test
    public void getAllConsoles() {

        Console console = new Console();
        console.setModel("Test");
        console.setManufacturer("Test");
        console.setMemoryAmount("Test");
        console.setProcessor("Test");
        console.setPrice(new BigDecimal("10.50"));
        console.setQuantity(10);

        console = consoleDao.createConsole(console);

        console = new Console();
        console.setModel("Test1");
        console.setManufacturer("Test1");
        console.setMemoryAmount("Test1");
        console.setProcessor("Test1");
        console.setPrice(new BigDecimal("11.50"));
        console.setQuantity(15);
        consoleDao.createConsole(console);

        List<Console> cList = consoleDao.getAllConsoles();
        assertEquals(2, cList.size());


    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setModel("Test");
        console.setManufacturer("Test");
        console.setMemoryAmount("Test");
        console.setProcessor("Test");
        console.setPrice(new BigDecimal("10.50"));
        console.setQuantity(10);

        console = consoleDao.createConsole(console);

        console.setMemoryAmount("Test1");
        console.setProcessor("Test1");
        console.setPrice(new BigDecimal("12.50"));
        consoleDao.updateConsole(console);

        Console c1 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(c1,console);

    }


    @Test
    public void getConsoleByManufacturer() {

        Console console = new Console();
        console.setModel("Test");
        console.setManufacturer("Test");
        console.setMemoryAmount("Test");
        console.setProcessor("Test");
        console.setPrice(new BigDecimal("10.50"));
        console.setQuantity(10);

        console = consoleDao.createConsole(console);

        console = new Console();
        console.setModel("Test");
        console.setManufacturer("Test");
        console.setMemoryAmount("Test");
        console.setProcessor("Test");
        console.setPrice(new BigDecimal("10.50"));
        console.setQuantity(10);

        console = consoleDao.createConsole(console);

        List<Console> cList = consoleDao.getConsoleByManufacturer("Test");
        assertEquals(2,cList.size());



    }
}