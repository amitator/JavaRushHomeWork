package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

            while (bufferedReader.ready()) {
                StringBuilder name = new StringBuilder();
                StringBuilder dateStr = new StringBuilder();
                int date = 0,
                        month = 0,
                        year = 0;

                String[] str = bufferedReader.readLine().split(" ");
                if (str.length > 1){
                    for (String s : str)
                    {
                        if (!isNumber(s))
                        {
                            name.append(s);
                            name.append(" ");
                        } else
                        {
                            dateStr.append(s);
                            dateStr.append(" ");
                        }
                    }

                    String[] dates = dateStr.toString().split(" ");
                    date = Integer.parseInt(dates[0]);
                    month = Integer.parseInt(dates[1]);
                    year = Integer.parseInt(dates[2]);

                    PEOPLE.add(new Person(name.toString().trim(), new GregorianCalendar(year, month - 1, date).getTime()));
                }
            }

            bufferedReader.close();


        } catch (FileNotFoundException e) {
        } catch (IOException e) {}

    }

    public static boolean isNumber(String str){
        boolean result = false;

        try {
            int test = Integer.parseInt(str);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }

        return result;
    }

}
