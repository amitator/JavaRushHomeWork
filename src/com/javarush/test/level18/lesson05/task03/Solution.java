package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = reader.readLine();
        String fName2 = reader.readLine();
        String fName3 = reader.readLine();
        FileInputStream fis = new FileInputStream(fName1);
        FileOutputStream fos2 = new FileOutputStream(fName2);
        FileOutputStream fos3 = new FileOutputStream(fName3);

        byte[] buffer = new byte[fis.available()];

        if (fis.available() > 0) {
            int count = fis.read(buffer);
            int half = count / 2 + count % 2;
            fos2.write(buffer, 0, half);
            fos3.write(buffer, half, count - half);

        }

        reader.close();
        fis.close();
        fos2.close();
        fos3.close();

    }
}
