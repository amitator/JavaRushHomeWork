package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(console.readLine()));
        FileWriter fileWriter = new FileWriter(console.readLine());

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            line = line.replaceAll("\\.", "!");
            fileWriter.write(line);
        }

        console.close();
        fileReader.close();
        fileWriter.close();
    }
}
