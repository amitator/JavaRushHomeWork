package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            FileWriter writer = new FileWriter(args[1]);
            StringBuilder builder = new StringBuilder();

            while (reader.ready()){
                String line = reader.readLine();
                if (line.length() > 0){
                    String[] str = line.split(" ");

                    for (String s: str){
                        if (s.length() > 6){
                            builder.append(s).append(",");
                        }
                    }

                }
            }

            String result = builder.toString().substring(0, builder.lastIndexOf(","));
            writer.write(result);

            reader.close();
            writer.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {}
    }
}
