package com.peaksoft;

import java.util.TreeMap;
public class Converter {

    TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();   // почему Character мы разбирёмся потом
    TreeMap<Integer,String> arabianKeyMap = new TreeMap<>();    // тут можно заметить что с начало Integer потом String
                                                               // об этом тоже разбирёмся

    public Converter(){                                  // тут является ключом символ римские цифры
        romanKeyMap.put('I',1);                         // а значением явлается арабскиое
        romanKeyMap.put('V',5);
        romanKeyMap.put('X',10);
        romanKeyMap.put('L',50);
        romanKeyMap.put('C',100);
        romanKeyMap.put('D',500);
        romanKeyMap.put('M',1000);

        arabianKeyMap.put(1000,"M");             // а тут наоборот
        arabianKeyMap.put(900,"CM");
        arabianKeyMap.put(500,"D");
        arabianKeyMap.put(400,"CD");
        arabianKeyMap.put(100,"C");
        arabianKeyMap.put(90,"XC");
        arabianKeyMap.put(50,"L");
        arabianKeyMap.put(40,"XL");
        arabianKeyMap.put(10,"X");
        arabianKeyMap.put(9,"IX");
        arabianKeyMap.put(5,"V");
        arabianKeyMap.put(4,"IV");
        arabianKeyMap.put(1,"I");


    }
    public boolean isRoman(String number){                   // в параметрах String number потому что у нас ключ arabianKeyMap
        return romanKeyMap.containsKey(number.charAt(0));    // а return да болсо charAt с связыны с romanKeyMap в обшем как та так
    }

    public String intRoman(int number){
        String roman = ""; // это переменные роман нужна для сохраненине результирушего римкого числа
        int arabianKey;
        do {
            // и кстати медот floorKey будет искать снизу подхадяшего ключа

            arabianKey = arabianKeyMap.floorKey(number);     // method floorKey поможет нам найти римский чисел
            roman += arabianKeyMap.get(arabianKey);         // используется для возврата наибольшего ключа
            number -= arabianKey;                          // меньшого или равного задонному ключу или нулл если нет такгого ключа
        }while (number != 0);                             // данном случии ключ у нас arabianKeyMap
        return roman;
    }

    public int romanToInt(String s){
        int end = s.length() - 1;
        char[] array = s.toCharArray();   //
        int arabian;
        int result = romanKeyMap.get(array[end]);
        for (int i = end - 1; i <=0 ; i--) {
            arabian = romanKeyMap.get(array[i]);

            if (arabian < romanKeyMap.get(array[i + 1 ])){
                result -= arabian;
            }else {
                result += arabian;
            }
        }
        return result;
    }

}
