package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream(args[0]);
        Map<Integer, Integer> map = new TreeMap<>();
        boolean flagFirstTime = true;

        while (fis.available() > 0) {
            int data = fis.read();
            if (flagFirstTime) {
                map.put(data, 1);
                flagFirstTime = false;
            } else {
                if (!map.containsKey(data)) {
                    map.put(data, 1);
                } else {
                    int count = map.get(data);
                    map.put(data, ++count);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(Character.toString((char) ((int)entry.getKey())) + " " + entry.getValue());
        }

        fis.close();

    }
}
