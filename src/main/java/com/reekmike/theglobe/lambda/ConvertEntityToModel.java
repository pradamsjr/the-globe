package com.reekmike.theglobe.lambda;

import com.reekmike.theglobe.model.Country;

import java.util.List;

public interface ConvertEntityToModel {
    public List<Country> convert(List<com.reekmike.theglobe.entity.Country> entity);
}
