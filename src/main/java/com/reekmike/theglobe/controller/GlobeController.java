package com.reekmike.theglobe.controller;

import com.reekmike.theglobe.model.Country;
import com.reekmike.theglobe.service.GlobeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GlobeController {
    private static final Logger logger = LogManager.getLogger(GlobeService.class);
    @Autowired
    private GlobeService service;

    @RequestMapping("/")
    private List<Country> getGlobe() {
        return service.getGlobe();
    }
}
