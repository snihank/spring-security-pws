package com.company.ShakibKarimU1Capstone.controller;

import com.company.ShakibKarimU1Capstone.service.ServiceLayer;
import com.company.ShakibKarimU1Capstone.viewModel.InvoiceViewModel;
import com.company.ShakibKarimU1Capstone.viewModel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    ServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody @Valid OrderViewModel ord) {
        return service.saveInvoice(ord);
    }

}
