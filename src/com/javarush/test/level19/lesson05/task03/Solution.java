package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(console.readLine()));
        FileWriter writer = new FileWriter(console.readLine());

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] elements = line.split(" ");

            for (int i = 0; i < elements.length; i++){
                try {
                    int num = Integer.parseInt(elements[i]);
                    writer.write(num + " ");
                } catch (NumberFormatException e) { continue; }
            }
        }

        console.close();
        fileReader.close();
        writer.close();
    }
}
