package com.company.ShakibKarimU1Capstone.service;

import com.company.ShakibKarimU1Capstone.dao.*;

import com.company.ShakibKarimU1Capstone.model.*;
import com.company.ShakibKarimU1Capstone.viewModel.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceLayerTest {
    GameDao gameDao;
    ConsoleDao consoleDao;
    TshirtDao tShirtDao;
    InvoiceDao invoiceDao;
    ServiceLayer service;
    SalesTaxRateDao salestaxRateDao;
    ProcessingFeeDao processingFeeDao;


    @Before
    public void setUp() throws Exception{

        setUpSalesTaxRateDaoMock();
        setUpProcessingFeeDaoMock();
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpTShirtDaoMock();
        setUpInvoiceDaoMock();

        service = new ServiceLayer(gameDao,consoleDao,tShirtDao,invoiceDao, salestaxRateDao, processingFeeDao);
    }




    @Test
    public void saveFindConsole(){
        ConsoleViewModel console = new ConsoleViewModel();
        console.setModel("Test");
        console.setManufacturer("Test");
        console.setProcessor("Test");
        console.setMemoryAmount("Test");
        console.setPrice(new BigDecimal("11.50").setScale(2));
        console.setQuantity(10);

        console = service.saveConsole(console);

        ConsoleViewModel s = service.getConsole(console.getConsoleId());

        assertEquals(console, s);

    }

    @Test
    public void getConsolesByManufacturer(){

        ConsoleViewModel console = new ConsoleViewModel();

        console.setModel("Test");
        console.setManufacturer("Test");
        console.setProcessor("Test");
        console.setMemoryAmount("Test");
        console.setPrice(new BigDecimal("11.50"));
        console.setQuantity(10);

        console = service.saveConsole(console);

        List<ConsoleViewModel> cList = service.getConsolesByManufacturer("Test");

        assertEquals(cList.size(), 1);
    }

    @Test
    public void saveFindGame(){
        GameViewModel game = new GameViewModel();

        game.setTitle("Test");
        game.setErsbRating("R");
        game.setDescription("Test");
        game.setPrice(new BigDecimal ("10.50").setScale(2));
        game.setStudio("Test");
        game.setQuantity(10);

        game = service.addGame(game);

        GameViewModel game2 = service.getGameById(game.getGameId());

        assertEquals(game, game2);

    }

    @Test
    public void addGetTShirt(){
        TshirtViewModel tshirt = new TshirtViewModel();

        tshirt.setSize("S");
        tshirt.setColor("White");
        tshirt.setDescription("Test");
        tshirt.setPrice(new BigDecimal("10.20"));
        tshirt.setQuantity(10);

        tshirt = service.addTShirt(tshirt);
        TshirtViewModel fromService = service.getTShirt(tshirt.gettShirtId());

        assertEquals(tshirt, fromService);

    }



    @Test
    public void saveFindInvoice(){
        OrderViewModel invoice = new OrderViewModel();

        invoice.setName("Test");
        invoice.setStreet("Test");
        invoice.setCity("Test");
        invoice.setState("NJ");
        invoice.setZipCode("Test");
        invoice.setItemType("Tshirt");
        invoice.setItemId(1);
        invoice.setQuantity(5);

        InvoiceViewModel invoice1 = service.saveInvoice(invoice);

        InvoiceViewModel invoice2 = service.saveInvoice(invoice);

        assertEquals(invoice2, invoice1);

    }




    @Test
    public void updateConsole() {

    }

    @Test
    public void deleteConsole(){
        service.deleteTShirt(5);
    }

    @Test
    public void getAllConsoles() {

        List<ConsoleViewModel> fromService = service.getAllConsoles();

        assertEquals(1, fromService.size());


    }



    @Test
    public void getAllGames() {

        List<GameViewModel> fromService = service.getAllGames();

        assertEquals(1, fromService.size());

    }

    @Test
    public void getGamesByStudio() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Test");
        game.setErsbRating("R");
        game.setDescription("Test");
        game.setPrice(new BigDecimal ("10.50").setScale(2));
        game.setStudio("Test");
        game.setQuantity(10);

        game = service.addGame(game);

        List <GameViewModel> gList = service.getGamesByStudio("Test");

        assertEquals(gList.size(), 1);
    }

    @Test
    public void getGamesByTitle() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Test");
        game.setErsbRating("R");
        game.setDescription("Test");
        game.setPrice(new BigDecimal ("10.50").setScale(2));
        game.setStudio("Test");
        game.setQuantity(10);

        game = service.addGame(game);

        List <GameViewModel> gList = service.getGamesByTitle("Test");

        assertEquals(gList.size(), 1);
    }

    @Test
    public void getGamesByErsbRating() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Test");
        game.setErsbRating("R");
        game.setDescription("Test");
        game.setPrice(new BigDecimal ("10.50").setScale(2));
        game.setStudio("Test");
        game.setQuantity(10);

        game = service.addGame(game);

        List <GameViewModel> gList = service.getGamesByErsbRating("R");

        assertEquals(gList.size(), 1);
    }

    @Test
    public void updateGame() {
    }

    //    This test will fail because of the exception handling in service layer class
    @Test
    public void deleteGame() {
        service.deleteGame(5);
    }

    @Test
    public void getAllTShirts() {

        List<TshirtViewModel> fromService = service.getAllTShirts();

        assertEquals(1, fromService.size());

    }

    @Test
    public void getTShirtsByColor() {
        TshirtViewModel tShirt = new TshirtViewModel();

        tShirt.setSize("S");
        tShirt.setColor("White");
        tShirt.setDescription("Test");
        tShirt.setPrice(new BigDecimal("10.20").setScale(2));
        tShirt.setQuantity(10);

        tShirt = service.addTShirt(tShirt);

        List <TshirtViewModel> tList = service.getTShirtsByColor("White");

        assertEquals(tList.size(),1);
    }

    @Test
    public void getTShirtsBySize() {
        TshirtViewModel tShirt = new TshirtViewModel();

        tShirt.setSize("S");
        tShirt.setColor("White");
        tShirt.setDescription("Test");
        tShirt.setPrice(new BigDecimal("10.20").setScale(2));
        tShirt.setQuantity(10);

        tShirt = service.addTShirt(tShirt);

        List <TshirtViewModel> tList = service.getTShirtsBySize("S");

        assertEquals(tList.size(),1);
    }

    @Test
    public void updateTShirt() {
    }

    //    This test will fail because of the exception handling in service layer class
    @Test
    public void deleteTShirt() {

        service.deleteTShirt(5);
        TshirtViewModel tshirt = service.getTShirt(5);
        assertNull(tshirt);

    }


    private void setUpInvoiceDaoMock(){

        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);


        Invoice invoice = new Invoice();
        invoice.setInvoiceId(2);
        invoice.setName("Test");
        invoice.setStreet("Test");
        invoice.setCity("Test");
        invoice.setState("NJ");
        invoice.setZipcode("Test");
        invoice.setItemType("Tshirt");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("10.20"));
        invoice.setQuantity(5);
        invoice.setSubTotal(new BigDecimal("51.00"));
        invoice.setTax(new BigDecimal("0.05"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("55.53"));


        Invoice invoice2 = new Invoice();
        invoice2.setName("Test");
        invoice2.setStreet("Test");
        invoice2.setCity("Test");
        invoice2.setState("NJ");
        invoice2.setZipcode("Test");
        invoice2.setItemType("Tshirt");
        invoice2.setItemId(1);
        invoice2.setUnitPrice(new BigDecimal("10.20"));
        invoice2.setQuantity(5);
        invoice2.setSubTotal(new BigDecimal("51.00"));
        invoice2.setTax(new BigDecimal("2.55"));
        invoice2.setProcessingFee(new BigDecimal("1.98"));
        invoice2.setTotal(new BigDecimal("55.53"));

        doReturn(invoice).when(invoiceDao).createInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(2);


    }
    private void setUpSalesTaxRateDaoMock() {
        salestaxRateDao = mock(SalesTaxRateDaoJdbcImpl.class);

        SalesTaxRate salestaxRate = new SalesTaxRate();
        salestaxRate.setState("NJ");
        salestaxRate.setRate(new BigDecimal("0.05"));

        doReturn(salestaxRate).when(salestaxRateDao).getSalesTaxByState("NJ");
    }

    private void setUpProcessingFeeDaoMock() {
        processingFeeDao = mock(ProcessingFeeDaoJdbcImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("Tshirts");
        processingFee.setFee(new BigDecimal("1.98"));

        doReturn(processingFee).when(processingFeeDao).getFee("Tshirts");
    }

    private void setUpConsoleDaoMock(){

        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        Console console = new Console();

        console.setConsoleId(1);
        console.setModel("Test");
        console.setManufacturer("Test");
        console.setProcessor("Test");
        console.setMemoryAmount("Test");
        console.setPrice(new BigDecimal("11.50").setScale(2));
        console.setQuantity(10);

        Console console2 = new Console();
        console2.setModel("Test");
        console2.setManufacturer("Test");
        console2.setProcessor("Test");
        console2.setMemoryAmount("Test");
        console2.setPrice(new BigDecimal("11.50").setScale(2));
        console2.setQuantity(10);

        List<Console> cList = new ArrayList<>();

        cList.add(console);

//        Delete Console

        Console c = new Console();

        c.setConsoleId(5);
        c.setModel("Test");
        c.setManufacturer("Test");
        c.setProcessor("Test");
        c.setMemoryAmount("Test");
        c.setPrice(new BigDecimal("11.50").setScale(2));
        c.setQuantity(10);

        doReturn(console).when(consoleDao).createConsole(console2);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(cList).when(consoleDao).getAllConsoles();
        doReturn(cList).when(consoleDao).getConsoleByManufacturer("Test");



    }

    private void setUpGameDaoMock(){

        gameDao = mock(GameDaoJdbcTemplateImpl.class);


        Game game = new Game();

        game.setGameId(1);
        game.setTitle("Test");
        game.setEsrbRating("R");
        game.setDescription("Test");
        game.setPrice(new BigDecimal ("10.50").setScale(2));
        game.setStudio("Test");
        game.setQuantity(10);

        Game game2 = new Game();

        game2.setTitle("Test");
        game2.setEsrbRating("R");
        game2.setDescription("Test");
        game2.setPrice(new BigDecimal ("10.50").setScale(2));
        game2.setStudio("Test");
        game2.setQuantity(10);

        List<Game> gList = new ArrayList<>();
        gList.add(game);

//        Delete Game
        Game g = new Game();
        g.setGameId(5);
        g.setTitle("Test");
        g.setEsrbRating("Test");
        g.setDescription("Test");
        g.setPrice(new BigDecimal("10.99"));
        g.setStudio("Test");
        g.setQuantity(10);

        doReturn(game).when(gameDao).createGame(game2);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(gList).when(gameDao).getAllGames();
        doReturn(gList).when(gameDao).getGameByTitle("Test");
        doReturn(gList).when(gameDao).getGameByStudio("Test");
        doReturn(gList).when(gameDao).getGameByEsrbRating("R");


    }


    private void setUpTShirtDaoMock(){
        tShirtDao = mock(TshirtDaoJdbcTemplateImpl.class);

        TShirt tshirt = new TShirt();
        tshirt.settShirtId(1);
        tshirt.setSize("S");
        tshirt.setColor("White");
        tshirt.setDescription("Test");
        tshirt.setPrice(new BigDecimal("10.20").setScale(2));
        tshirt.setQuantity(10);

        TShirt tshirt2 = new TShirt();
        tshirt2.setSize("S");
        tshirt2.setColor("White");
        tshirt2.setDescription("Test");
        tshirt2.setPrice(new BigDecimal("10.20").setScale(2));
        tshirt2.setQuantity(10);

        List<TShirt> tList = new ArrayList<>();
        tList.add(tshirt);

//        Delete Tshirt
        tshirt.settShirtId(5);
        tshirt.setSize("S");
        tshirt.setColor("White");
        tshirt.setDescription("Test");
        tshirt.setPrice(new BigDecimal("10.20").setScale(2));
        tshirt.setQuantity(10);

        doReturn(tshirt).when(tShirtDao).createTshirt(tshirt2);
        doReturn(tshirt).when(tShirtDao).getTshirt(1);
        doReturn(tList).when(tShirtDao).getAllTshirts();
        doReturn(tList).when(tShirtDao).getTshirtByColor("White");
        doReturn(tList).when(tShirtDao).getTshirtBySize("S");
        doNothing().when(tShirtDao).deleteTshirt(5);
        doReturn(null).when(tShirtDao).getTshirt(5);
    }

}
