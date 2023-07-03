package com.javarush.cryptanalyzer.iablocova.services;

import com.javarush.cryptanalyzer.iablocova.entity.Result;
import com.javarush.cryptanalyzer.iablocova.repository.ResultCode;

public class UnsupportedFunction implements Function{
    @Override
    public Result execute (String[] parameters){
        return new Result(ResultCode.ERROR);
    }
}
