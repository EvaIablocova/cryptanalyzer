package com.javarush.cryptanalyzer.iablocova.services;

import java.io.*;

import com.javarush.cryptanalyzer.iablocova.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.iablocova.entity.Result;
import com.javarush.cryptanalyzer.iablocova.exception.ApplicationException;
import com.javarush.cryptanalyzer.iablocova.repository.ResultCode;

public class Encode implements Function{
    @Override
    public Result execute (String[] parameters){
        //keyForShift - from parameters
        int  keyForEncode =5;

        Result execute (String[] parameters){

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            StringBuilder encryptedText = new StringBuilder();

            int character;
            while ((character = reader.read()) != -1) {
                int currentIndex = CryptoAlphabet.ALPHABET.indexOf((char)character);
                char encryptedChar = (char) character;

                if (currentIndex != -1) {// если этот символ есть в нашем алфавите
                        if (currentIndex + keyForEncode < CryptoAlphabet.lengthOfAlphabet) {
                            encryptedChar = CryptoAlphabet.ALPHABET.charAt(currentIndex + keyForEncode + 1);
                        } else if (currentIndex + keyForEncode >= CryptoAlphabet.ALPHABET.length())
                            encryptedChar = CryptoAlphabet.ALPHABET.charAt(currentIndex + keyForEncode + 1 - CryptoAlphabet.lengthOfAlphabet);
                    }

                    encryptedText.append(encryptedChar);
                }
        return null;
        } catch (Exception e){
            return new Result(ResultCode.ERROR, new ApplicationException("Encode operation finish with exception ", e));
        }
        return new Result(ResultCode.OK);};
    }
}
