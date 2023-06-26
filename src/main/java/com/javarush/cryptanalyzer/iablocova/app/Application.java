//package com.javarush.cryptanalyzer.iablocova.app;
//
//import com.javarush.cryptanalyzer.iablocova.controller.MainController;
//import com.javarush.cryptanalyzer.iablocova.entity.Result;
//import com.javarush.cryptanalyzer.iablocova.repository.FunctionCode;
//import com.javarush.cryptanalyzer.iablocova.services.Function;
//
//import static com.javarush.cryptanalyzer.iablocova.constants.FunctionCodeConstants.*;
//
//
//public class Application {
//    private final MainController mainController;
//
//    public Application (MainController mainController){
//        this.mainController = mainController;
//    }
//
//    public Result run(){
//        String[] parameters = mainController.getView().getParameters();
//        String mode = parameters [0];
//        Function function = getFunction (mode);
//        return function.execute(parameters);
//    }
//
//    private Function getFunction (String mode){
//        return switch (mode){
//            case "1" -> FunctionCode.valueOf (ENCODE).getFunction();
//            case "2" -> FunctionCode.valueOf (DECODE).getFunction();
//            default -> FunctionCode.valueOf (UNSUPPORTED_FUNCTION).getFunction();
//        };
//    }
//
//    public void printResult (Result result){
//        mainController.getView().printResult(result);
//    }
//}
