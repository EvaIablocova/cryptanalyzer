package com.javarush.cryptanalyzer.iablocova.controller;
import com.javarush.cryptanalyzer.iablocova.view.View;

public class MainController {
    private View view;
    public MainController (View view){
        this.view = view;
    }
    public View getView(){
        return view;
    }
}
