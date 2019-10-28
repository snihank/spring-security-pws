package com.company.ShakibKarimU1Capstone.controller;

import com.company.ShakibKarimU1Capstone.exception.NotFoundException;
import com.company.ShakibKarimU1Capstone.service.ServiceLayer;

import com.company.ShakibKarimU1Capstone.viewModel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameController {
    @Autowired
    ServiceLayer service;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel addGame(@RequestBody @Valid GameViewModel game) {
        return service.addGame(game);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") int id) {
        GameViewModel game = service.getGameById(id);
        if (game == null)
            throw new NotFoundException("Cannot find game " + id);
        return game;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames(){
        return service.getAllGames();
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable("title") String title){
        return service.getGamesByTitle(title);
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio) {
//        return service.getGamesByStudio(studio);
        List<GameViewModel> game = service.getGamesByStudio(studio);
        if (game.size() == 0)
            throw new NotFoundException("Cannot find game with studio " + studio);
        return game;
    }

    @GetMapping("ersb/{ersb_rating}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByErsb(@PathVariable("ersb_rating") String ersbRating){
        return service.getGamesByErsbRating(ersbRating);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteConsole(@PathVariable("id") int id) {
        service.deleteGame(id);
        return "Game successfully deleted.";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateGame(@RequestBody @Valid GameViewModel gameViewModel) {
        service.updateGame(gameViewModel);
        return "Game successfully updated.";
    }


}

