package com.javarush.cryptanalyzer.iablocova.view;

import com.javarush.cryptanalyzer.iablocova.entity.Result;

public interface View {

    String [] getParameters();

    void printResult (Result result);
}
