package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName;

        while (!(fName = reader.readLine()).equals("exit")) {
            ReadThread rt = new ReadThread(fName);
            rt.start();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            super(fileName);

        }
        // implement file reading here - реализуйте чтение из файла тут
        public  void run() {
            try
            {
                FileInputStream fis = new FileInputStream(this.getName());
                Map<Integer, Integer> map = new HashMap<>();
                int maxVal = 0,
                        maxInt = 0;

                while (fis.available() > 0) {
                    int data = fis.read();
                    if (!map.containsKey(data)) {
                        map.put(data, 1);
                    } else {
                        int count = map.get(data) + 1;
                        map.put(data, count);
                        if (count > maxVal) {
                            maxVal = count;
                            maxInt = data;
                        }
                    }
                }

                synchronized (resultMap) {
                    resultMap.put(this.getName(), maxInt);
                }

                fis.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {}


        }
    }
}
