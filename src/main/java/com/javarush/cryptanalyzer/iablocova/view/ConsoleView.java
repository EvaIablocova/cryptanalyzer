package com.javarush.cryptanalyzer.iablocova.view;

import com.javarush.cryptanalyzer.iablocova.entity.Result;
import static com.javarush.cryptanalyzer.iablocova.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptanalyzer.iablocova.constants.ApplicationCompletionConstants.SUCCESS;


public class ConsoleView {

    @Override
    public String[] getParameters(){
        //TODO finish ConsoleView getParameters method
        return new String[0];
    }

    @Override
    public void printResult (Result result){
        switch (result.getResultCode()){
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }
    }
}
