package com.javarush.cryptanalyzer.iablocova.view;

import com.javarush.cryptanalyzer.iablocova.entity.Result;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

import static com.javarush.cryptanalyzer.iablocova.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptanalyzer.iablocova.constants.ApplicationCompletionConstants.KEY;
import static com.javarush.cryptanalyzer.iablocova.constants.ApplicationCompletionConstants.SUCCESS;
import static com.javarush.cryptanalyzer.iablocova.constants.CryptoAlphabet.lengthOfAlphabet;


public class ConsoleView implements View {

    @Override
    public String[] getParameters(){
        int k = 4;
        String[] parameters = new String [k];
        boolean t = true;
        Scanner scanner = new Scanner(System.in);
        while (t) {
            System.out.println("Выберите режим, который вы ходите использовать");
            System.out.println("1 - зашифровать файл");
            System.out.println("2 - расшифровать файл");
            System.out.println("3 - BruteForce");
            System.out.println("4 - Статистический анализ");
            parameters[0] = scanner.nextLine();

            switch (parameters[0]) {
                case "1":
                    System.out.println("Введите путь файла, который вы хотите зашифровать или нажмите Enter для выбора файла по умолчанию");
                    t = false;
                    parameters[1] = scanner.nextLine();
//                    scanner.close();
                    if (parameters[1].isEmpty()) parameters[1] = "input.txt";
                    break;
                case "2", "3", "4":
                    System.out.println("Введите путь файла, который вы хотите расшифровать или нажмите Enter для выбора файла по умолчанию");
                    t = false;
                    parameters[1] = scanner.nextLine();
//                    scanner.close();
                    if (parameters[1].isEmpty()) parameters[1] = "encoded.txt";
                    break;
                default:
                    System.out.println("Нет такого режима. Попробуйте ещё раз");
            }
        }

        t = true;
        while (t) {
            try {
                switch (parameters[0]) {
                    case "1":
                        System.out.println("Введите ключ для шифровки или нажмите Enter для случайного генерирования ключа");
                        parameters[2] = scanner.nextLine();

                        if (parameters[2].isEmpty()){
                            Random random = new Random();
                            parameters[2] = String.valueOf(random.nextInt(lengthOfAlphabet-1 - 0 + 1) + 0);
                            System.out.println(KEY + parameters[2]);
                        }

                        System.out.println("Выберите в какой файл записать результат или нажмите Enter для выбора файла по умолчанию");
                        parameters[3] = scanner.nextLine();
                        if (parameters[3].isEmpty()) parameters[3] = "encoded.txt";
                        break;
                    case "2":
                        System.out.println("Введите ключ для расшифровки");
                        parameters[2] = scanner.nextLine();
                        System.out.println("Выберите в какой файл записать результат или нажмите Enter для выбора файла по умолчанию");
                        parameters[3] = scanner.nextLine();
                        if (parameters[3].isEmpty()) parameters[3] = "output.txt";
                        break;
                    default:
                        break;
                }
                t = false; //пока не введут число не закончится цикл
            } catch (NumberFormatException e) {
            }
        }

        scanner.close();
        return parameters;
    }

    @Override
    public void printResult (Result result){
        switch (result.getResultCode()){
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }
    }
}
