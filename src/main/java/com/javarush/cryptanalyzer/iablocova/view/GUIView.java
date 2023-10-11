package com.javarush.cryptanalyzer.iablocova.view;

import com.javarush.cryptanalyzer.iablocova.entity.Result;

public class GUIView implements View{

    @Override
    // TODO finish GUIView getParameters method
    public String[] getParameters (){
        return new String[0];
    }

    @Override
    public void printResult (Result result){

    }

    @Override
    public boolean repeat() {
       return true;
    }
}
