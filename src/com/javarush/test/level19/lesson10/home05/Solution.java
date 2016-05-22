package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            FileWriter writer = new FileWriter(args[1]);

            while (reader.ready()){
                String line = reader.readLine();

                if (line.length() > 1) {
                    String[] strArray = line.split(" ");

                    for (String str: strArray){
                        boolean hasNum = false;
                        char[] charArray = str.toCharArray();

                        for (char c: charArray){
                            if (isNum(c)){
                                hasNum = true;
                            }
                        }

                        if (hasNum){
                            writer.write(str);
                            writer.write(" ");
                        }

                    }
                }
            }

            reader.close();
            writer.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {}
    }

    public static boolean isNum(char charIn){
        boolean result = false;

        if (charIn >= 48 && charIn <= 57){
            result = true;
        }

        return result;
    }
}
