package com.javarush.cryptanalyzer.iablocova.services;

import com.javarush.cryptanalyzer.iablocova.entity.Result;
import com.javarush.cryptanalyzer.iablocova.exception.ApplicationException;
import com.javarush.cryptanalyzer.iablocova.repository.ResultCode;

public class BruteForce implements Function{
    @Override
    public Result execute (String[] parameters){
        try{

            //TODO finish BruteForce execute method
        } catch (Exception e){
            return new Result(ResultCode.ERROR, new ApplicationException("BruteForce operation finish with exception ", e));
        }
        return new Result(ResultCode.OK);
    }
}
