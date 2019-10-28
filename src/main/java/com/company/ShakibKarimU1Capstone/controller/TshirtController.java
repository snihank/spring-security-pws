package com.company.ShakibKarimU1Capstone.controller;


import com.company.ShakibKarimU1Capstone.exception.NotFoundException;
import com.company.ShakibKarimU1Capstone.service.ServiceLayer;
import com.company.ShakibKarimU1Capstone.viewModel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/tshirt")
public class TshirtController {

    @Autowired
    ServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TshirtViewModel addTShirt(@RequestBody @Valid TshirtViewModel shirt) {
        return service.addTShirt(shirt);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TshirtViewModel getTShirt(@PathVariable("id") int id) {
        TshirtViewModel tShirtViewModel = service.getTShirt(id);
        if (tShirtViewModel == null)
            throw new NotFoundException("Cannot find t-shirt " + id);
        return tShirtViewModel;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getAllShirts(){
        return service.getAllTShirts();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTShirt(@PathVariable("id") int id) {
        service.deleteTShirt(id);
        return "T-Shirt successfully deleted.";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateTShirt(@RequestBody @Valid TshirtViewModel tShirtViewModel) {
        service.updateTShirt(tShirtViewModel);
        return "T-Shirt successfully updated.";
    }

    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getTshirtBySize(@PathVariable("size") String size){
        return service.getTShirtsBySize(size);
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getTshirtByColor(@PathVariable("color") String color) {
        return service.getTShirtsByColor(color);
    }


//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loggedIn(Principal principal) {
//        return "Hello " + principal.getName() + "! Looks like you're logged in!";
//    }
//
//    @RequestMapping(value = "/allDone", method = RequestMethod.GET)
//    public String allDone() {
//        return "That's All Folks!";
//    }

}
