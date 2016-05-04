package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream(args[0]);
        byte[] buffer = new byte[fis.available()];

        int allLetters = 0;
        int spaces = 0;
        if (fis.available() > 0){
            allLetters = fis.read(buffer);

            for (int i = 0; i < allLetters; i++){
                if (buffer[i] == 32) {
                    spaces++;
                }
            }
        }
        fis.close();

        float result = (float) spaces / (float) allLetters * 100;
        System.out.println(String.format("%.2f", result));

    }
}
