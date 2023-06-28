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

        String exampleOfFile = "Cfv самые СложныЕ знаки, преп !";

        Scanner scanner = new Scanner (System.in);
        boolean t = true;
        int keyForEncode=0;
        while (t){
        System.out.println("Введите ключ для кодирования:");
        if (scanner.hasNextInt()) {keyForEncode = scanner.nextInt();
            keyForEncode = keyForEncode % CryptoAlphabet.ALPHABET.length(); // целое число смещений
            t = false; }
        else System.out.println("Введите целое число");
        }

        scanner.close();

        System.out.println("start " + exampleOfFile);

        //идем по строке
        int count = exampleOfFile.length();
        int lengthOfAlphabet = CryptoAlphabet.ALPHABET.length();
        char [] newExampleOfFile = exampleOfFile.toCharArray();

        for (int i = 0; i < count; i++) {
            int currentIndex = CryptoAlphabet.ALPHABET.indexOf (newExampleOfFile [i]);
            if (currentIndex != -1){// если этот символ есть в нашем алфавите
                if (currentIndex + keyForEncode < lengthOfAlphabet) {
                    newExampleOfFile [i] = CryptoAlphabet.ALPHABET.charAt(currentIndex + keyForEncode + 1);
                }else if (currentIndex + keyForEncode >= CryptoAlphabet.ALPHABET.length())
                    newExampleOfFile [i] = CryptoAlphabet.ALPHABET.charAt(currentIndex+keyForEncode + 1 - lengthOfAlphabet);
            }}

        System.out.println(newExampleOfFile);

        //Decode
        //I have: cifertext- input.txt
        // key for decode - int
        // Should get: right text - output.txt

        for (int i = 0; i < count; i++) {
            int currentIndex = CryptoAlphabet.ALPHABET.indexOf (newExampleOfFile [i]);
            if (currentIndex != -1){// если этот символ есть в нашем алфавите
            int newIndex = currentIndex - keyForEncode-1;
            if (newIndex >= 0)
                newExampleOfFile [i] =CryptoAlphabet.ALPHABET.charAt(newIndex);
            else if (newIndex < 0)
                newExampleOfFile [i] = CryptoAlphabet.ALPHABET.charAt(lengthOfAlphabet + newIndex );
        }}

        System.out.println(newExampleOfFile);


        //брут форс перебираем ключи, сравниваем по количеству совпавших регулярок - сохраняем вариант где наибольшее количство совпрадений
        //инкод, декод с файла

    }
}
