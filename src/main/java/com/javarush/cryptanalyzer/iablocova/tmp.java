package com.javarush.cryptanalyzer.iablocova;

import com.javarush.cryptanalyzer.iablocova.constants.CryptoAlphabet;
import org.w3c.dom.ls.LSOutput;

import java.lang.String;
import java.util.Scanner;

public class tmp {
    public static void main(String[] args) {
        //choose

        // main controller ±
        boolean d = true;
        while (d) {
            System.out.println("Choose what interface do ypu want to use?");
            System.out.println("1 - console");
            System.out.println("2 - Graphic User Interface");
            System.out.println("0 - End use");
            int t = 0;
            switch (t) {
                case 1: //functionConsole.run();
                    d = false;
                    break;
                case 2: // functionGUI.run();
                    d = false;
                    break;
                case 0: //finish programm
                    d = false;
                    break;
                default:
                    System.out.println("Не предусмотренный режим. Повторите попытку!");
            }
        }





        //Encode
        //I have:  right text - input.txt
        // key for decode - int
        // Should get: cifertext - output.txt

        String exampleOfFile = "привет,   A";

        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите ключ для кодирования:");
        int keyForEncode = scanner.nextInt();
        keyForEncode = keyForEncode % CryptoAlphabet.ALPHABET.length(); // целое число смещений
        scanner.close();

        System.out.println("start " + exampleOfFile);

        //идем по алфавиту

//        int count = CryptoAlphabet.ALPHABET.length();
//        for (int i = 0; i < count; i++) {
//            char currentChar = CryptoAlphabet.ALPHABET.charAt(i);
//            if (exampleOfFile.contains(Character.toString (currentChar))){
//            if (i< count - keyForEncode)
//                exampleOfFile = exampleOfFile.replace (currentChar, CryptoAlphabet.ALPHABET.charAt(i+keyForEncode));
//            else if (i>= count - keyForEncode)
//                exampleOfFile = exampleOfFile.replace (currentChar, CryptoAlphabet.ALPHABET.charAt(i+keyForEncode - count + 1));
//        }}
//
//        System.out.println(exampleOfFile);

        //идем по строке
        int count = exampleOfFile.length();

        for (int i = 0; i < count; i++) {
            char currentChar = exampleOfFile.charAt(i);
            int currentIndex = CryptoAlphabet.ALPHABET.indexOf (currentChar);
                if (currentIndex + keyForEncode < CryptoAlphabet.ALPHABET.length())
                    exampleOfFile = exampleOfFile.replace (currentChar, CryptoAlphabet.ALPHABET.charAt(currentIndex+keyForEncode));
                else if (currentIndex + keyForEncode >= CryptoAlphabet.ALPHABET.length())
                    exampleOfFile = exampleOfFile.replace (currentChar, CryptoAlphabet.ALPHABET.charAt(currentIndex+keyForEncode - CryptoAlphabet.ALPHABET.length() + 1));
            }

        System.out.println(exampleOfFile);

        //Decode
        //I have: cifertext- input.txt
        // key for decode - int
        // Should get: right text - output.txt


        for (int i = 0; i < count; i++) {
            char currentChar = exampleOfFile.charAt(i);
            int currentIndex = CryptoAlphabet.ALPHABET.indexOf (currentChar);
            int newIndex = currentIndex - keyForEncode;
            if (newIndex >= 0)
                exampleOfFile = exampleOfFile.replace (currentChar, CryptoAlphabet.ALPHABET.charAt(newIndex));
            else if (newIndex < 0)
                exampleOfFile = exampleOfFile.replace (currentChar, CryptoAlphabet.ALPHABET.charAt(CryptoAlphabet.ALPHABET.length()+ newIndex));
        }

        System.out.println(exampleOfFile);


    }
}
