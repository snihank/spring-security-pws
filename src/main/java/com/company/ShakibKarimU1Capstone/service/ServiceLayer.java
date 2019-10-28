package com.company.ShakibKarimU1Capstone.service;

import com.company.ShakibKarimU1Capstone.dao.*;
import com.company.ShakibKarimU1Capstone.model.*;
import com.company.ShakibKarimU1Capstone.viewModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private GameDao gameDao;
    private ConsoleDao consoleDao;
    private TshirtDao tShirtDao;
    private InvoiceDao invoiceDao;
    private SalesTaxRateDao taxRateDao;
    private ProcessingFeeDao processingFeeDao;

    @Autowired
    public ServiceLayer(GameDao gameDao, ConsoleDao consoleDao, TshirtDao tShirtDao, InvoiceDao invoiceDao, SalesTaxRateDao taxRateDao, ProcessingFeeDao processingFeeDao) {
        this.gameDao = gameDao;
        this.consoleDao = consoleDao;
        this.tShirtDao = tShirtDao;
        this.invoiceDao = invoiceDao;
        this.taxRateDao = taxRateDao;
        this.processingFeeDao = processingFeeDao;
    }

//________________________________________________________________________Console

//    Save Console
    public ConsoleViewModel saveConsole(ConsoleViewModel cvm) {
        Console console = new Console();
        console.setModel(cvm.getModel());
        console.setManufacturer(cvm.getManufacturer());
        console.setMemoryAmount(cvm.getMemoryAmount());
        console.setProcessor(cvm.getProcessor());
        console.setPrice(cvm.getPrice());
        console.setQuantity(cvm.getQuantity());
        console =  consoleDao.createConsole(console);

        cvm.setConsoleId(console.getConsoleId());
        return cvm;
    }

//    Update Console

    public void updateConsole(ConsoleViewModel cvm)
    {
        Console c = new Console();
        c.setConsoleId(cvm.getConsoleId());
        c.setModel(cvm.getModel());
        c.setManufacturer(cvm.getManufacturer());
        c.setMemoryAmount(cvm.getMemoryAmount());
        c.setProcessor(cvm.getProcessor());
        c.setPrice(cvm.getPrice());
        c.setQuantity(cvm.getQuantity());

        consoleDao.updateConsole(c);
    }

//    Get Console

    public ConsoleViewModel getConsole(int id) {
        Console c =  consoleDao.getConsole(id);
//        if(c==null){
//            throw new NumberFormatException("Cannot find id " + id);
//        }
            return buildConsoleViewModel(c);
    }

//    Get All Consoles

    public List<ConsoleViewModel> getAllConsoles() {
        List<Console> console = consoleDao.getAllConsoles();
        List<ConsoleViewModel> cList = new ArrayList<>();
        for (Console c : console) {
            ConsoleViewModel cvm = buildConsoleViewModel(c);
            cList.add(cvm);
        }
        return cList;
    }

//    Delete Console

    public void removeConsole(int id)
    {
        consoleDao.deleteConsole(id);
    }


    public List<ConsoleViewModel> getConsolesByManufacturer(String manufacturer) {
        List<Console> cList = consoleDao.getConsoleByManufacturer(manufacturer);
        List<ConsoleViewModel> cvmList = new ArrayList<>();

        for (Console c : cList) {
            cvmList.add(buildConsoleViewModel(c));
        }
        if (cList.size() == 0)
            return null;
        else
            return cvmList;
    }
//_________________________________________________________________________________________Game


//    Save Game
    public GameViewModel addGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getErsbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        game = gameDao.createGame(game);

        gameViewModel.setGameId(game.getGameId());

        return gameViewModel;
    }

//    Get Game

    public GameViewModel getGameById(int id) {
        Game game = gameDao.getGame(id);
//        if(game==null){
//            throw new NumberFormatException("Cannot find id " + id);
//        }
        return buildGameViewModel(game);
    }

//    Get All Games

    public List<GameViewModel> getAllGames() {
        List<Game> gList = gameDao.getAllGames();
        List<GameViewModel> gvmList = new ArrayList<>();

        for (Game g : gList) {
            GameViewModel gvm = buildGameViewModel(g);
            gvmList.add(gvm);
        }

        return gvmList;

    }

//    Get Game By Studio

    public List<GameViewModel> getGamesByStudio(String studio) {
        List<Game> gList = gameDao.getGameByStudio(studio);
        List<GameViewModel> gvmList = new ArrayList<>();
        for (Game g : gList) {
            GameViewModel gvm = buildGameViewModel(g);
            gvmList.add(gvm);
        }
        return gvmList;
    }

//    Get Game By Title

    public List<GameViewModel> getGamesByTitle(String title) {
        List<Game> gList = gameDao.getGameByTitle(title);
        List<GameViewModel> gvmList = new ArrayList<>();
        for (Game g : gList) {
            GameViewModel gvm = buildGameViewModel(g);
            gvmList.add(gvm);
        }
        return gvmList;
    }

    //    Get Game By esrbRating

    public List<GameViewModel> getGamesByErsbRating(String esrbRating) {
        List<Game> gList = gameDao.getGameByEsrbRating(esrbRating);
        List<GameViewModel> gvmList = new ArrayList<>();
        for (Game g : gList) {
            GameViewModel gvm = buildGameViewModel(g);
            gvmList.add(gvm);
        }
        return gvmList;
    }

//    Update Game

    public void updateGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setGameId(gameViewModel.getGameId());
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getErsbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        gameDao.updateGame(game);
    }

//    Delete Game

    public void deleteGame(int id) {
        gameDao.deleteGame(id);


    }

//    ______________________________________________________________________________Tshirt

    public TshirtViewModel addTShirt(TshirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();

        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirt = tShirtDao.createTshirt(tShirt);

        tShirtViewModel.settShirtId(tShirt.gettShirtId());

        return tShirtViewModel;
    }

    public TshirtViewModel getTShirt(int id) {
        TShirt tshirt = tShirtDao.getTshirt(id);
        if(tshirt==null){
            return null;
        }else
        return buildTshirtViewModel(tshirt);
    }

    public List<TshirtViewModel> getAllTShirts(){
        List<TShirt> tList= tShirtDao.getAllTshirts();
        List<TshirtViewModel> tvmList = new ArrayList<>();

        for (TShirt t : tList){
            TshirtViewModel tvm = buildTshirtViewModel(t);
            tvmList.add(tvm);
        }

        return tvmList;
    }

    public List<TshirtViewModel> getTShirtsByColor(String color){
        List<TShirt> tList= tShirtDao.getTshirtByColor(color);
        List<TshirtViewModel> tvmList = new ArrayList<>();

        for (TShirt t : tList){
            TshirtViewModel tvm = buildTshirtViewModel(t);
            tvmList.add(tvm);
        }

        return tvmList;
    }

    public List<TshirtViewModel> getTShirtsBySize(String size){
        List<TShirt> tList= tShirtDao.getTshirtBySize(size);
        List<TshirtViewModel> tvmList = new ArrayList<>();

        for (TShirt t : tList){
            TshirtViewModel tvm = buildTshirtViewModel(t);
            tvmList.add(tvm);
        }

        return tvmList;
    }

    public void updateTShirt(TshirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(tShirtViewModel.gettShirtId());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirtDao.updateTshirt(tShirt);
    }

    public void deleteTShirt(int id) {
        tShirtDao.deleteTshirt(id);
    }

//    __________________________________________________________________Invoice

    @Transactional
    public InvoiceViewModel saveInvoice(OrderViewModel order) {


        Invoice invoice = new Invoice();
        invoice.setName(order.getName());
        invoice.setStreet(order.getStreet());
        invoice.setCity(order.getCity());
        invoice.setState(order.getState());
        invoice.setZipcode(order.getZipCode());
        invoice.setItemType(order.getItemType());
        invoice.setItemId(order.getItemId());
        invoice.setQuantity(order.getQuantity());


        BigDecimal itemPrice;

        if (invoice.getItemType().equals("Console")) {
            Console item = consoleDao.getConsole(invoice.getItemId());
            int itemQuantity = item.getQuantity();
            itemPrice = item.getPrice();

            if (invoice.getQuantity() > itemQuantity) {
                throw new IllegalArgumentException("Short on inventory.");
            } else {
                item.setQuantity(itemQuantity - invoice.getQuantity());
                consoleDao.updateConsole(item);
            }
        } else if (invoice.getItemType().equals("Tshirt")) {
            TShirt item = tShirtDao.getTshirt(invoice.getItemId());
            int itemQuantity = item.getQuantity();
            itemPrice = item.getPrice();

            if (invoice.getQuantity() > itemQuantity) {
                throw new IllegalArgumentException("Short on inventory.");
            } else {
                item.setQuantity(itemQuantity - invoice.getQuantity());
                tShirtDao.updateTshirt(item);
            }
        } else if (invoice.getItemType().equals("Game")) {
            Game item = gameDao.getGame(invoice.getItemId());
            int itemQuantity = item.getQuantity();
            itemPrice = item.getPrice();

            if (invoice.getQuantity() > itemQuantity) {
                throw new IllegalArgumentException("Short on inventory.");
            } else {
                item.setQuantity(itemQuantity - invoice.getQuantity());
                gameDao.updateGame(item);
            }
        } else {
            throw new IllegalArgumentException("Incorrect Input! Choose either [Console] or [Game] or [Tshirt]");
        }


        invoice.setUnitPrice(itemPrice.setScale(2));


        SalesTaxRate taxRate = taxRateDao.getSalesTaxByState(invoice.getState());
        ProcessingFee processingFee = processingFeeDao.getFee(invoice.getItemType());


        invoice.setSubTotal(BigDecimal.valueOf(invoice.getQuantity()).multiply(invoice.getUnitPrice()).setScale(2));


        invoice.setTax(taxRate.getRate().multiply(invoice.getSubTotal()).setScale(2, RoundingMode.HALF_UP));


        if (invoice.getQuantity() > 10) {
            invoice.setProcessingFee(new BigDecimal("15.49").add(processingFee.getFee()).setScale(2));
        } else {

            ProcessingFee value = processingFeeDao.getFee(invoice.getItemType()+"s");
            invoice.setProcessingFee(value.getFee());
        }


        invoice.setTotal((invoice.getSubTotal()).add(invoice.getTax()).add(invoice.getProcessingFee()));


        invoice = invoiceDao.createInvoice(invoice);

        return buildInvoiceViewModel(invoice);
    }

    //_______________________________________________________________Helper Methods
    private GameViewModel buildGameViewModel(Game game) {
        GameViewModel gvm = new GameViewModel();
        gvm.setGameId(game.getGameId());
        gvm.setTitle(game.getTitle());
        gvm.setErsbRating(game.getEsrbRating());
        gvm.setDescription(game.getDescription());
        gvm.setPrice(game.getPrice());
        gvm.setStudio(game.getStudio());
        gvm.setQuantity(game.getQuantity());

        return gvm;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setInvoiceId(invoice.getInvoiceId());
        ivm.setName(invoice.getName());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setZipCode(invoice.getZipcode());
        ivm.setItemType(invoice.getItemType());
        ivm.setItemId(invoice.getItemId());
        ivm.setUnitPrice(invoice.getUnitPrice());
        ivm.setQuantity(invoice.getQuantity());
        ivm.setSubtotal(invoice.getSubTotal());
        ivm.setTax(invoice.getTax());
        ivm.setProcessingFee(invoice.getProcessingFee());
        ivm.setTotal(invoice.getTotal());

        return ivm;
    }

    private ConsoleViewModel buildConsoleViewModel(Console console) {
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setConsoleId(console.getConsoleId());
        cvm.setModel(console.getModel());
        cvm.setManufacturer(console.getManufacturer());
        cvm.setMemoryAmount(console.getMemoryAmount());
        cvm.setProcessor(console.getProcessor());
        cvm.setPrice(console.getPrice());
        cvm.setQuantity(console.getQuantity());

        return cvm;
    }

    private TshirtViewModel buildTshirtViewModel(TShirt tShirt) {
        TshirtViewModel tvm = new TshirtViewModel();
        tvm.settShirtId(tShirt.gettShirtId());
        tvm.setSize(tShirt.getSize());
        tvm.setColor(tShirt.getColor());
        tvm.setDescription(tShirt.getDescription());
        tvm.setPrice(tShirt.getPrice());
        tvm.setQuantity(tShirt.getQuantity());

        return tvm;
    }

}