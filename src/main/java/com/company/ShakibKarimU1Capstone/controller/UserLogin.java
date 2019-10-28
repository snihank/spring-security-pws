package com.company.ShakibKarimU1Capstone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserLogin {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loggedIn(Principal principal) {
        return "Hello " + principal.getName() + "! Looks like you're logged in!";
    }

    @RequestMapping(value = "/allDone", method = RequestMethod.GET)
    public String allDone(Principal principal) {
        return "That's All + " + principal.getName() + " !";
    }
}
