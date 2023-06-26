//package com.javarush.cryptanalyzer.iablocova.repository;
//
//import com.javarush.cryptanalyzer.iablocova.services.Decode;
//import com.javarush.cryptanalyzer.iablocova.services.Encode;
//import com.javarush.cryptanalyzer.iablocova.services.Function;
//import com.javarush.cryptanalyzer.iablocova.services.UnsupportedFunction;
//
//public enum FunctionCode {
//    ENCODE (new Encode()), DECODE (new Decode()), UNSUPPORTED_FUNCTION (new UnsupportedFunction());
//
//    private Function function;
//    FunctionCode (Function function){ this.function = function;}
//    public Function getFunction (){return function;}
//}
