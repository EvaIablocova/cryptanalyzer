package com.javarush.cryptanalyzer.iablocova.services;

import java.io.*;

import com.javarush.cryptanalyzer.iablocova.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.iablocova.entity.Result;
import com.javarush.cryptanalyzer.iablocova.exception.ApplicationException;
import com.javarush.cryptanalyzer.iablocova.repository.ResultCode;

import static com.javarush.cryptanalyzer.iablocova.constants.ApplicationCompletionConstants.EXCEPTION;

public class Decode implements Function{
    @Override
    public Result execute (String[] parameters){

        try (BufferedReader reader = new BufferedReader(new FileReader(parameters[1]))) {
            StringBuilder encryptedText = new StringBuilder();

            int  keyForDecode = Integer.parseInt (parameters[2]);
            int character;
            while ((character = reader.read()) != -1) {
                int currentIndex = CryptoAlphabet.ALPHABET.indexOf((char)character);
                char encryptedChar = (char) character;

                if (currentIndex != -1) {// если этот символ есть в нашем алфавите
                    int newIndex = currentIndex - keyForDecode;
                    if (newIndex >= 0) {
                        encryptedChar = CryptoAlphabet.ALPHABET.charAt(newIndex);
                    } else if (newIndex < 0)
                        encryptedChar = CryptoAlphabet.ALPHABET.charAt(newIndex + CryptoAlphabet.lengthOfAlphabet);
                }

                encryptedText.append(encryptedChar);
            }
//        return null;

            try (FileWriter fileWriter = new FileWriter(parameters[3])) {
                fileWriter.write(encryptedText.toString());
            } catch (IOException e) {
                System.out.println(EXCEPTION + e.getMessage());
            }
        } catch (Exception e){
            return new Result(ResultCode.ERROR, new ApplicationException("Encode operation finish with exception ", e));
        }
        return new Result(ResultCode.OK);}
}
