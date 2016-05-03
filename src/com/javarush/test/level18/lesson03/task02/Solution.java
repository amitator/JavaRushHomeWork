package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();

        FileInputStream fis = new FileInputStream(fName);
        int min = fis.read();

        while (fis.available() > 0) {
            int data = fis.read();
            if (data < min) {
                min = data;
            }
        }

        System.out.println(min);
        fis.close();
    }
}
