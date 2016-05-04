package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = reader.readLine();
        String fName2 = reader.readLine();
        FileInputStream fisFile1 = new FileInputStream(fName1);
        FileInputStream fis = new FileInputStream(fName2);
        byte[] buffer = new byte[1000];
        byte[] temp = new byte[fisFile1.available()];
        int size = 0;

        if (fisFile1.available() > 0){
            size = fisFile1.read(temp);
        }
        fisFile1.close();

        FileOutputStream fos = new FileOutputStream(fName1);
        while (fis.available() > 0){
            int count = fis.read(buffer);
            fos.write(buffer, 0, count);
        }

        fos.write(temp);



        reader.close();
        fos.close();
        fis.close();

    }
}
