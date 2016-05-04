package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = reader.readLine();
        String fName2 = reader.readLine();
        String fName3 = reader.readLine();
        FileOutputStream fos1 = new FileOutputStream(fName1);
        FileInputStream fis2 = new FileInputStream(fName2);
        FileInputStream fis3 = new FileInputStream(fName3);

        byte[] buffer = new byte[1000];

        while (fis2.available() > 0) {
            int count = fis2.read(buffer);
            fos1.write(buffer, 0, count);
        }

        while (fis3.available() > 0) {
            int count = fis3.read(buffer);
            fos1.write(buffer, 0, count);
        }

        reader.close();
        fos1.close();
        fis2.close();
        fis3.close();
    }
}
