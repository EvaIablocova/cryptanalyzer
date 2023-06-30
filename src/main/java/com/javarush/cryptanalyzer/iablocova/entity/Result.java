package com.javarush.cryptanalyzer.iablocova.entity;

import com.javarush.cryptanalyzer.iablocova.repository.ResultCode;
import com.javarush.cryptanalyzer.iablocova.exception.ApplicationException;

public class Result {
    /**
     * понять как всё прошло - хорошо или плохо
     */
    private ResultCode resultCode;
    private ApplicationException applicationException;
    public Result (ResultCode resultCode){ this.resultCode = resultCode;}
    public Result (ResultCode resultCode, ApplicationException applicationException){
        this.resultCode = resultCode;
        this.applicationException = applicationException;
    }
    public ResultCode getResultCode(){
        return resultCode;
    }

    public ApplicationException getApplicationException() {
        return applicationException;
    }
}
