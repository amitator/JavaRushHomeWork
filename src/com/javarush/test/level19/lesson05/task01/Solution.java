package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fNameIn = reader.readLine();
        String fNameOut = reader.readLine();
        FileInputStream fis = new FileInputStream(fNameIn);
        FileOutputStream fos = new FileOutputStream(fNameOut);

        int index = 1;
        while (fis.available() > 0) {
            int data = fis.read();
            if (index % 2 == 0) {
                fos.write(data);
            }
            index++;
        }

        reader.close();
        fis.close();
        fos.close();

    }
}
