package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;


public class Solution {
    public static void main(String[] args) throws  Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> set = new TreeSet<String>(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                int k = Integer.parseInt(o1.substring(o1.lastIndexOf(".part") + 5));
                int v = Integer.parseInt(o2.substring(o2.lastIndexOf(".part") + 5));
                if (k > v) return 1;
                else if (k < v) return -1;
                return 0;
            }
        });
        String name = reader.readLine();
        String s = name;
        while (!name.equals("end"))
        {
            set.add(name);
            name = reader.readLine();
        }
        reader.close();

        String mas[] = s.split("\\.");


        String t = "";
        for (int i = 0; i < mas.length - 1; i++)
        {
            t = t + mas[i];
            if (i != mas.length - 2) t = t + ".";


        }
        FileOutputStream fos = new FileOutputStream(t);

        for (String x : set)
        {
            FileInputStream fis = new FileInputStream(x);
            byte[] buffer = new byte[fis.available()];
            int count = fis.read(buffer);
            fos.write(buffer, 0, count);
            fis.close();
        }


        fos.close();
    }
}
