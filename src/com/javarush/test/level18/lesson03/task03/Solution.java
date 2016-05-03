package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        FileInputStream fis = new FileInputStream(fName);
        Map<Integer, Integer> map = new HashMap<>();

        while (fis.available() > 0) {
            int data = fis.read();
            if (!map.containsKey(data)) {
                map.put(data, 1);
            } else {
                int tmp = map.get(data);
                map.put(data, ++tmp);
            }
        }
        fis.close();

        int max = 0;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if (value > max) {
                max = value;
                maxKey = entry.getKey();
            }
        }

        System.out.println(maxKey);
    }
}
