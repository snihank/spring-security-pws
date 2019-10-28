package com.company.ShakibKarimU1Capstone.dao;

import com.company.ShakibKarimU1Capstone.model.Game;
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
public class GameDaoTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        List<Game> game = gameDao.getAllGames();
        for (Game g : game) {
            gameDao.deleteGame(g.getGameId());
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteGame(){
        Game game = new Game();
        game.setTitle("Test");
        game.setEsrbRating("Test");
        game.setDescription("Test");
        game.setPrice(new BigDecimal("10.50"));
        game.setStudio("Test");
        game.setQuantity(10);

        game = gameDao.createGame(game);

        Game g1 = gameDao.getGame(game.getGameId());
        assertEquals(g1,game);

//        gameDao.deleteGame(game.getGameId());
//        g1 = gameDao.getGame(game.getGameId());
//        assertNull(g1);
    }

    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setTitle("Test");
        game.setEsrbRating("Test");
        game.setDescription("Test");
        game.setPrice(new BigDecimal("10.50"));
        game.setStudio("Test");
        game.setQuantity(10);

        game = gameDao.createGame(game);

        game = new Game();
        game.setTitle("Test1");
        game.setEsrbRating("Test1");
        game.setDescription("Test1");
        game.setPrice(new BigDecimal("20.50"));
        game.setStudio("Test1");
        game.setQuantity(20);
        gameDao.createGame(game);

        List<Game> gList = gameDao.getAllGames();
        assertEquals(2, gList.size());


    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("Test1");
        game.setEsrbRating("Test1");
        game.setDescription("Test1");
        game.setPrice(new BigDecimal("20.50"));
        game.setStudio("Test1");
        game.setQuantity(20);

        game = gameDao.createGame(game);

        game.setDescription("Updated");
        game.setPrice(new BigDecimal("21.50"));
        game.setStudio("Updated");
        gameDao.updateGame(game);

        Game g1 = gameDao.getGame(game.getGameId());
        assertEquals(g1,game);
    }


    @Test
    public void getGameByStudio() {

        Game game = new Game();
        game.setTitle("Test1");
        game.setEsrbRating("Test1");
        game.setDescription("Test1");
        game.setPrice(new BigDecimal("20.50"));
        game.setStudio("Studio");
        game.setQuantity(20);

        game = gameDao.createGame(game);

        game = new Game();
        game.setTitle("Test2");
        game.setEsrbRating("Test2");
        game.setDescription("Test2");
        game.setPrice(new BigDecimal("19.50"));
        game.setStudio("Studio");
        game.setQuantity(30);

        game = gameDao.createGame(game);

        List<Game> gList = gameDao.getGameByStudio("Studio");
        assertEquals(2,gList.size());


    }

    @Test
    public void getGameByEsrbRating() {
        Game game = new Game();
        game.setTitle("Test1");
        game.setEsrbRating("R");
        game.setDescription("Test1");
        game.setPrice(new BigDecimal("20.50"));
        game.setStudio("Studio");
        game.setQuantity(20);

        game = gameDao.createGame(game);

        game = new Game();
        game.setTitle("Test2");
        game.setEsrbRating("R");
        game.setDescription("Test2");
        game.setPrice(new BigDecimal("19.50"));
        game.setStudio("Studio");
        game.setQuantity(30);

        game = gameDao.createGame(game);

        List<Game> gList = gameDao.getGameByEsrbRating("R");
        assertEquals(2,gList.size());
    }

    @Test
    public void getGameByTitle() {
        Game game = new Game();
        game.setTitle("Test1");
        game.setEsrbRating("R");
        game.setDescription("Test1");
        game.setPrice(new BigDecimal("20.50"));
        game.setStudio("Studio");
        game.setQuantity(20);

        game = gameDao.createGame(game);

        game = new Game();
        game.setTitle("Test1");
        game.setEsrbRating("R");
        game.setDescription("Test2");
        game.setPrice(new BigDecimal("19.50"));
        game.setStudio("Studio");
        game.setQuantity(30);

        game = gameDao.createGame(game);

        List<Game> gList = gameDao.getGameByTitle("Test1");
        assertEquals(2,gList.size());
    }
}