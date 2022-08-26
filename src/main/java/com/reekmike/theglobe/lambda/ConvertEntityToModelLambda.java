package com.reekmike.theglobe.lambda;

import com.reekmike.theglobe.model.Country;

import java.util.List;

public interface ConvertEntityToModelLambda {
    public List<Country> convert(List<com.reekmike.theglobe.entity.Country> entity);
}
