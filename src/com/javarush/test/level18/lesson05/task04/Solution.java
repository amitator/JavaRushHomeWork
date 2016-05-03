package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = reader.readLine();
        String fName2 = reader.readLine();
        FileInputStream fis = new FileInputStream(fName1);
        FileOutputStream fos = new FileOutputStream(fName2);

        byte[] buffer = new byte[fis.available()];
        int count = 0;
        if (fis.available() > 0){
            count = fis.read(buffer);
        }

        byte[] writeBuff = new byte[count];
        for (int i = 0; i < count; i++) {
            writeBuff[count - i - 1] = buffer[i];
        }

        fos.write(writeBuff, 0, count);

        reader.close();
        fis.close();
        fos.close();
    }
}
