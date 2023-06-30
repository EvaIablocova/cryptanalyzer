package com.javarush.cryptanalyzer.iablocova.repository;

import com.javarush.cryptanalyzer.iablocova.services.Decode;
import com.javarush.cryptanalyzer.iablocova.services.Encode;
import com.javarush.cryptanalyzer.iablocova.services.Function;
import com.javarush.cryptanalyzer.iablocova.services.UnsupportedFunction;

public enum FunctionCode {
    /**
     * имитация базы данных
     * отправляем данные, которые получили от пользователя
     * и в зависимости от них выполняем дальнейшние наши действия
     *
     * описывает те возможности, которые может делать наша программа
     * и соответсвенно вернет необходимые инструменты, чтобы это сделать
     *
     * преобразование какой-то циферки, которую пользователь введёт преобразовать в джавовский класс
     */
    ENCODE (new Encode()), DECODE (new Decode()), UNSUPPORTED_FUNCTION (new UnsupportedFunction()), BRUTE_FORCE (new BruteForce());

    private Function function;
    FunctionCode (Function function){ this.function = function;}
    public Function getFunction (){return function;}
}
