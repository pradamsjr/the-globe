package com.reekmike.theglobe.service;


import com.reekmike.theglobe.lambda.ConvertEntityToModelLambda;
import com.reekmike.theglobe.mapper.CountryMapper;
import com.reekmike.theglobe.model.CountriesResponse;
import com.reekmike.theglobe.model.Country;
import com.reekmike.theglobe.repository.CountryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class CountryService {

    private static final Logger logger = LogManager.getLogger(CountryService.class);
    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    private Properties applicationProperties;

    @Autowired
    private CountryRepository countryRepository;

    private static ConvertEntityToModelLambda convertEntityToModelLambda = (entities) -> {
        List<Country> models = new ArrayList<>();
        entities.forEach((entity) -> {
            logger.info("convertEntityToModelLambda: entity: " + entity);
            models.add(CountryMapper.convert(entity));
        });

        return models;
    };

    public CountryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Country> findAll() {
        List<Country> models = new ArrayList<>();
        if (countryRepository.count() == 0) {
            models.addAll(findAllModelsFromService());
        } else {
            models.addAll(findAllModelsFromDb());
        }

        return models;
    }

    public Country findByCode(String code) {
        logger.info("findByCode: " + code);
        com.reekmike.theglobe.entity.Country entity = countryRepository.findByCode(code);
        return CountryMapper.convert(entity);
    }

    private List<Country> findAllModelsFromDb() {
        return convertEntityToModelLambda.convert((List<com.reekmike.theglobe.entity.Country>) countryRepository.findAll());
    }

    private List<Country> findAllModelsFromService() {
        String url = applicationProperties.getProperty("geonames.countryInfo.url");
        ResponseEntity<CountriesResponse> responseEntity = restTemplate.getForEntity(url, CountriesResponse.class);
        CountriesResponse countriesResponse = responseEntity.getBody();
        List<Country> models = countriesResponse.getGeonames();
        saveModels(models);
        return models;
    }

    private void saveModels(List<Country> models) {
        models.stream().forEach(model -> {
            logger.info("saveModels: model: " + model);
            countryRepository.save(CountryMapper.convert(model));
        });
    }
}

