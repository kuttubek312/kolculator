package com.peaksoft;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * тут мы вывозем все необхадимые на консол
 * и римские и арабского числа
 * вроде отулгон еле темалар но всё таки трудно самостаятельно написать
 * колькулятор по этому используваем Google или YouTube
 * и кстати если заметили тут нет класса main
 * его можете не искать я его спрятол но мы вернёмся класса main
 * а пока обратите внимание на этот класс
 */
public class Calculator {
    public static void main(String[] args) {

        Converter converter = new Converter();   // создаем обьект то есть конверт

        String[] actions = {"+", "-", "/", "*"};       // тут обычные знаки действие

        String[] regexActions = {"\\+", "-", "/", "\\*"};   //  а этот масив нужен что бы расплит вырожение на две части

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение:");       // тут всё понятно
        String exp = sc.nextLine();

        // тут определяем орифметичиское действие
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        // если не нашли арифметического деействие завершаем программу
        if (actionIndex == -1) {
            System.out.println("Некорпректное выражение!");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);     // метод split в Java разделает строку на подстроки
        // Данное подстроки собираются методом массив и представляеть
        // собой его возвращаемое значение "2-4".split("-")->{"2", "4"}

        // определаем находится ли числа в одном фармате (оба римские или оба арабское)
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {   //это определяет подхидит ли арабское вырожение
            //на римкое и возврашает тру или фолс в данном случе фолс
            int a, b;                                                     // иммено этот позваляет не совершать умножать или делить минусовать
            // итд с арабского на римкое

            // конвертуруем арабские числа из строки число
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {

                // если римское то конвертуруем их в арабское
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);


            } else {
                a = Integer.parseInt(data[0]);  // конвертуруем на int
                b = Integer.parseInt(data[1]);

            }



            int result = 0;
            try {

                checkNumber(a);
                checkNumber(b);

                switch (actions[actionIndex]) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    default:
                        System.out.println("Такого действия нет");
                }
            } catch (MyException e){
                System.out.println(" неверный формат: number > 10 || number <= 0 ");

            } catch (InputMismatchException e) {
                System.out.println("Exception :" + e);
              //  System.out.println("на ноль делить нельзя брат");
            }

            if (isRoman) {
                //если числа были римские возврашаем результат в римском числе
                System.out.println(converter.intRoman(result));
            } else {
                //если числа арабские возравшаем результат в арабском числе
                System.out.println(result);
            }
        } else {
            System.out.println("Числа должны быть в одном формате !");
        }
    }

    public static void checkNumber(int number) throws MyException {
        if (number > 10 || number <= 0) {
            throw new MyException("number format");
        }
    }
}
