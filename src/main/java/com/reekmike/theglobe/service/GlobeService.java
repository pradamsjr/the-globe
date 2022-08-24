package com.reekmike.theglobe.service;


import com.reekmike.theglobe.model.GlobeResponse;
import com.reekmike.theglobe.model.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Properties;

@Service
public class GlobeService {

    private static final Logger logger = LogManager.getLogger(GlobeService.class);
    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    private Properties applicationProperties;

    public GlobeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Country> getGlobe() {
        String url = applicationProperties.getProperty("geonames.countryInfo.url");
        ResponseEntity<GlobeResponse> responseEntity = restTemplate.getForEntity(url, GlobeResponse.class);
        GlobeResponse globeResponse = responseEntity.getBody();
        List<Country> globe = globeResponse.getGeonames();
        return globe;
    }
}

