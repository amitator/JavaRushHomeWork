package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream newStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(newStream);
        System.setOut(stream);

        testString.printSomething();

        String str = newStream.toString();

        String[] arraySample = str.split(" ");
        int numA = Integer.parseInt(arraySample[0]);
        int numB = Integer.parseInt(arraySample[2]);
        char sign = arraySample[1].charAt(0);
        int result = 0;

        switch (sign){
            case 43:{
                result = numA + numB;
                break;
            }
            case 45:{
                result = numA - numB;
                break;
            }
            case 42:{
                result = numA * numB;
                break;
            }
        }

        System.setOut(console);

        str = str.replaceAll("\\r\\n", "");
        str += result;

        System.out.println(str);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

