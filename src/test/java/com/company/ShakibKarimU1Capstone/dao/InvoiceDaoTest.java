package com.company.ShakibKarimU1Capstone.dao;

import com.company.ShakibKarimU1Capstone.model.Console;
import com.company.ShakibKarimU1Capstone.model.Game;
import com.company.ShakibKarimU1Capstone.model.Invoice;
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

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    TshirtDao tshirtDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    SalesTaxRateDao salestaxRateDao;
    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        List<Game> gList = gameDao.getAllGames();
        for (Game g : gList) {
            gameDao.deleteGame(g.getGameId());
        }

        List<Console> cList = consoleDao.getAllConsoles();
        for (Console c : cList) {
            consoleDao.deleteConsole(c.getConsoleId());
        }

        List<TShirt> tList = tshirtDao.getAllTshirts();
        for (TShirt t : tList) {
            tshirtDao.deleteTshirt(t.gettShirtId());
        }

        List<Invoice> iList = invoiceDao.getAllInvoices();
        for (Invoice i: iList) {
            invoiceDao.deleteInvoice(i.getInvoiceId());
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteInvoice(){

        Invoice invoice = new Invoice();
        invoice.setName("Test");
        invoice.setStreet("Test");
        invoice.setCity("Test");
        invoice.setState("NY");
        invoice.setZipcode("Test");
        invoice.setItemType("Consoles");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("15.99"));
        invoice.setQuantity(5);
        invoice.setSubTotal(new BigDecimal("79.95"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("86.24"));


        invoice = invoiceDao.createInvoice(invoice);

        Invoice invoice2 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice2, invoice);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());

        invoice2 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertNull(invoice2);


    }

    @Test
    public void getAllInvoices() {
        Invoice invoice = new Invoice();
        invoice.setName("Test");
        invoice.setStreet("Test");
        invoice.setCity("Test");
        invoice.setState("NY");
        invoice.setZipcode("Test");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("10.00"));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("20.00"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("22.69"));


        invoiceDao.createInvoice(invoice);


        Invoice invoice2 = new Invoice();
        invoice2.setName("Test1");
        invoice2.setStreet("Test1");
        invoice2.setCity("Test1");
        invoice2.setState("NY");
        invoice2.setZipcode("Test1");
        invoice2.setItemType("Consoles");
        invoice2.setItemId(1);
        invoice2.setUnitPrice(new BigDecimal("15.99"));
        invoice2.setQuantity(1);
        invoice2.setSubTotal(new BigDecimal("15.99"));
        invoice2.setTax(new BigDecimal("0.06"));
        invoice2.setProcessingFee(new BigDecimal("1.49"));
        invoice2.setTotal(new BigDecimal("18.45"));


        invoiceDao.createInvoice(invoice2);

        assertEquals( invoiceDao.getAllInvoices().size(), 2);
    }

    @Test
    public void updateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Test");
        invoice.setStreet("Test");
        invoice.setCity("Test");
        invoice.setState("NY");
        invoice.setZipcode("Test");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("10.99"));
        invoice.setQuantity(1);
        invoice.setSubTotal(new BigDecimal("10.99"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("13.14"));


        invoiceDao.createInvoice(invoice);

        invoice.setName("Test1");
        invoice.setStreet("Test1");
        invoice.setCity("Test1");
        invoice.setState("NY");
        invoice.setZipcode("Test1");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(1);
        invoice.setSubTotal(new BigDecimal("12.99"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("15.26"));

        invoiceDao.updateInvoice(invoice);

        Invoice invoice2 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice2, invoice);

    }


}