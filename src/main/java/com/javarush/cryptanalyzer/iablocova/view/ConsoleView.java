package com.javarush.cryptanalyzer.iablocova.view;

import com.javarush.cryptanalyzer.iablocova.entity.Result;

import java.util.Scanner;
import java.util.Random;

import static com.javarush.cryptanalyzer.iablocova.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptanalyzer.iablocova.constants.ApplicationCompletionConstants.SUCCESS;
import static com.javarush.cryptanalyzer.iablocova.constants.CryptoAlphabet.lengthOfAlphabet;


public class ConsoleView implements View {

    @Override
    public String[] getParameters(){
        String[] parameters = {};
        boolean t = true;
        while (t) {
            System.out.println("Выберите режим, который вы ходите использовать");
            System.out.println("1 - зашифровать файл");
            System.out.println("2 - расшифровать файл");
            System.out.println("3 - BruteForce");
            System.out.println("4 - Статистический анализ");
            Scanner scanner = new Scanner(System.in);
            parameters[0] = scanner.nextLine();
            scanner.close();

            switch (parameters[0]) {
                case "1":
                    System.out.println("Введите путь файла, который вы хотите зашифровать или нажмите Enter для выбора файла по умолчанию");
                    t = false;
                    parameters[1] = scanner.nextLine();
                    scanner.close();
                    if (parameters[1].isEmpty()) parameters[1] = "input.txt";
                    break;
                case "2", "3", "4":
                    System.out.println("Введите путь файла, который вы хотите расшифровать или нажмите Enter для выбора файла по умолчанию");
                    t = false;
                    parameters[1] = scanner.nextLine();
                    scanner.close();
                    if (parameters[1].isEmpty()) parameters[1] = "output.txt";
                    break;
                default:
                    System.out.println("Нет такого режима. Попробуйте ещё раз");
            }
        }

        t = true;
        while (t) {
            try (Scanner scanner = new Scanner(System.in);) {
                switch (parameters[0]) {
                    case "1":
                        System.out.println("Введите ключ для шифровки или нажмите Enter для случайного генерирования ключа");
                        parameters[2] = scanner.nextLine();
                        scanner.close();

                        if (parameters[2].isEmpty()){
                            Random random = new Random();
                            parameters[2] = String.valueOf(random.nextInt());
                        }
                        break;
                    case "2":
                        System.out.println("Введите ключ для расшифровки");
                        parameters[2] = scanner.nextLine();
                        break;
                    default:
                        break;
                }
                int key = Integer.parseInt(parameters[2]);
                key = key % lengthOfAlphabet; // целое число смещений ?? не будет нуля если ввести меньше число чем длина алфавита
                parameters[2] = String.valueOf(key);
                t = false; //пока не введут число не закончится цикл
            } catch (NumberFormatException e) {
            }
        }


        System.out.println("Выберите в какой файл записать результат или нажмите Enter для выбора файла по умолчанию");
        Scanner scanner = new Scanner(System.in);
        parameters[3] = scanner.nextLine();
        scanner.close();
        if (parameters[3].isEmpty()) parameters[3] = "result.txt";


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
