package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        FileInputStream fis = new FileInputStream(fName);

        Map<Integer, Integer> map = new HashMap<>();
        while (fis.available() > 0){
            int data = fis.read();
            if (!map.containsKey(data)) {
                map.put(data, 1);
            } else {
                int value = map.get(data);
                map.put(data, ++value);
            }
        }
        fis.close();

        int minValue = 0;
        boolean flagFirstEntry = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (flagFirstEntry) {
                minValue = entry.getValue();
                flagFirstEntry = false;
            }

            int data = entry.getValue();
            if (data < minValue) {
                minValue = data;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == minValue) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
