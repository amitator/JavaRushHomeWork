package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fNameIn = bufferedReader.readLine();
        FileReader fileReader = new FileReader(fNameIn);
        String result = "";

        while (fileReader.ready()) {
            result += (char)fileReader.read();
        }

        String res = result.toLowerCase().replaceAll("[,.!?\r\n]", " ");
        int counter = 0;
        String[] splited = res.split(" ");
        for (int i = 0; i < splited.length; i++){
            if (splited[i].equals("world")){
                counter++;
            }
        }

        System.out.println(counter);

        bufferedReader.close();
        fileReader.close();

    }
}
