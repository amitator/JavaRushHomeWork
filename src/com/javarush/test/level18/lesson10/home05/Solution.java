package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = reader.readLine();
        String fName2 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fName1));

        List<String> list = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        while (fileReader.ready()) {
            line.append(fileReader.readLine());
        }

        Pattern pattern = Pattern.compile(" ");
        String[] strDoubles = pattern.split(line.toString());
        Double[] doubles = new Double[strDoubles.length];

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strDoubles.length; i++){
            doubles[i] = Double.parseDouble(strDoubles[i]);
            if (doubles[i] > 0) {
                builder.append((int)(new BigDecimal(doubles[i]).setScale(0, RoundingMode.HALF_UP).doubleValue()) + " ");
            } else {
                builder.append((int)(new BigDecimal(doubles[i]).setScale(0, RoundingMode.HALF_DOWN).doubleValue()) + " ");
            }

        }

        FileWriter fileWriter = new FileWriter(fName2);
        fileWriter.write(builder.toString());

        fileWriter.close();
        fileReader.close();
        reader.close();

    }
}
