package com.javarush.cryptanalyzer.iablocova.services;

import com.javarush.cryptanalyzer.iablocova.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.iablocova.entity.Result;
import com.javarush.cryptanalyzer.iablocova.exception.ApplicationException;
import com.javarush.cryptanalyzer.iablocova.repository.ResultCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static com.javarush.cryptanalyzer.iablocova.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptanalyzer.iablocova.repository.FunctionCode.DECODE;

public class BruteForce implements Function{
    @Override
    public Result execute (String[] parameters){
        try {

            int maxMatches =0;
            int rigthKey = 0;

            for (int i = 0; i < CryptoAlphabet.lengthOfAlphabet; i++) {
                Function function = DECODE.getFunction();
                parameters[2] = Integer.toString(i);
                function.execute(parameters);
                //in parameters[3] - decode text

                String filePath = parameters[3];
                String regex = "([а-яёА-ЯЁ]+[ ]+[а-яёА-ЯЁ]+)+[(,;)]";

                try {
                    File file = new File(filePath);
                    BufferedReader reader1 = new BufferedReader(new FileReader(file));

                    String line;
                    Pattern pattern = Pattern.compile(regex);

                    int count =0;
                    while ((line = reader1.readLine()) != null) {
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            count++;
                        }
                    }
                    if (count > maxMatches){
                        maxMatches = count;
                        rigthKey = i;
                    }
                    reader1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                }

            Function function = DECODE.getFunction();
            parameters[2] = Integer.toString(rigthKey);
            function.execute(parameters);
            }
        catch (Exception e){
            return new Result(ResultCode.ERROR, new ApplicationException(EXCEPTION, e));
        }
        return new Result(ResultCode.OK);}
}
