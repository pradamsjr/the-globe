package com.reekmike.theglobe.repository;

import com.reekmike.theglobe.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {

    public Country findByCode(String code);
}

