package com.reekmike.theglobe.controller;

import com.reekmike.theglobe.model.Country;
import com.reekmike.theglobe.service.CountryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/globe")
public class CountryController {
    private static final Logger logger = LogManager.getLogger(CountryController.class);
    @Autowired
    private CountryService service;

    @RequestMapping("/countries")
    private List<Country> getCountries() {
        return service.findAll();
    }

    @RequestMapping("/countries/code")
    private Country getCountryByCode(@RequestParam String code) {
        return service.findByCode(code);
    }
}
