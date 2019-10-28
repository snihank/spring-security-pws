package com.company.ShakibKarimU1Capstone.controller;

import com.company.ShakibKarimU1Capstone.exception.NotFoundException;
import com.company.ShakibKarimU1Capstone.model.Console;
import com.company.ShakibKarimU1Capstone.service.ServiceLayer;
import com.company.ShakibKarimU1Capstone.viewModel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleController {
    @Autowired
    ServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel addConsole(@RequestBody @Valid ConsoleViewModel console){
        return service.saveConsole(console);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int id) {
        ConsoleViewModel consoleViewModel = service.getConsole(id);
        if (consoleViewModel == null)
            throw new NotFoundException("Cannot find" + id);
        return consoleViewModel;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles(){
        return service.getAllConsoles();
    }

    @GetMapping("/manufacture/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsolesByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        List<ConsoleViewModel> cvmList = service.getConsolesByManufacturer(manufacturer);
        if (cvmList.size() == 0)
            throw new NotFoundException("Cannot find manufacturer" + manufacturer);
        return cvmList;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteConsole(@PathVariable("id") int id){
        service.removeConsole(id);
        return "Console successfully deleted.";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel) {
        service.updateConsole(consoleViewModel);
        return "Console successfully updated.";
    }

    }
