package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();

        while (reader.ready()){
            String[] data = reader.readLine().split(" ");
            if (!map.containsKey(data[0])){
                map.put(data[0], Double.parseDouble(data[1]));
            } else {
                Double temp = map.get(data[0]);
                map.put(data[0], temp + Double.parseDouble(data[1]));
            }
        }

        reader.close();

        List<String> list = new ArrayList<>();
        String maxName = "";
        Double max = 0.0;
        boolean flag = true;
        for (Map.Entry<String, Double> entry : map.entrySet()){
            if (flag) {
                max = entry.getValue();
                flag = false;
            } else {
                if (entry.getValue() == max) {
                    list.add(entry.getKey());
                }
                if (entry.getValue() > max){
                    max = entry.getValue();
                    maxName = entry.getKey();
                    list.clear();
                    list.add(maxName);
                }
            }
        }

        for (String s : list)
        {
            System.out.println(s);
        }
    }
}
