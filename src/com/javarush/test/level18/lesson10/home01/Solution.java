package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        byte[] buffer = new byte[fis.available()];
        int count = 0;

        if (fis.available() > 0) {
            count = fis.read(buffer);
        }

        int counter = 0;
        for (int i = 0; i < count; i++){
            if ( (buffer[i] >= 65 && buffer[i] <= 90) ||
                    (buffer[i] >= 97 && buffer[i] <= 122) ) {
                counter++;
            }
        }

        fis.close();
        System.out.println(counter);
    }
}
