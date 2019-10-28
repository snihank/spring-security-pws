package com.company.ShakibKarimU1Capstone.dao;



import com.company.ShakibKarimU1Capstone.model.Game;

import java.util.List;

public interface GameDao {

    Game createGame(Game game);

    Game getGame(int gameId);

    List<Game> getAllGames();

    void updateGame(Game game);

    void deleteGame(int gameId);

    List<Game> getGameByStudio(String studio);

    List<Game> getGameByEsrbRating(String esrbRating);

    List<Game> getGameByTitle(String title);

}
