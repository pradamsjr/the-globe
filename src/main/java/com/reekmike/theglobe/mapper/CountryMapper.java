package com.reekmike.theglobe.mapper;

import com.reekmike.theglobe.model.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountryMapper {
    private static final Logger logger = LogManager.getLogger(CountryMapper.class);

    public static Country convert(com.reekmike.theglobe.entity.Country entity) {
        Country model = new Country();
        model.setCountryCode(entity.getCode());
        model.setCountryName(entity.getName());
        model.setPopulation(entity.getPopulation());
        return model;
    }

    public static com.reekmike.theglobe.entity.Country convert(Country model) {
        com.reekmike.theglobe.entity.Country entity = new com.reekmike.theglobe.entity.Country();
        entity.setCode(model.getCountryCode());
        entity.setName(model.getCountryName());
        entity.setPopulation(model.getPopulation());
        return entity;
    }
}
