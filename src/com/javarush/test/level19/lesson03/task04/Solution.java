package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scan) {
            this.scanner = scan;
        }

        public void close() throws IOException{
            this.scanner.close();
        }

        public Person read() throws IOException{
            String lastName = scanner.next();
            String firstName = scanner.next();
            String middleName = scanner.next();
            int day = scanner.nextInt();
            int month = scanner.nextInt() - 1;
            int year = scanner.nextInt();
            Calendar calendar = new GregorianCalendar(year, month, day);
            Date birthDate = calendar.getTime();
            Person user = new Person(firstName, middleName, lastName, birthDate);

            return user;

        }

    }


    public static void main(String[] args) throws IOException {
        File file = new File("c:/tmp/result.txt");
        Scanner scanner = new Scanner(file);
        PersonScannerAdapter adapter = new PersonScannerAdapter(scanner);

        System.out.println(adapter.read());
        System.out.println(adapter.read());
        adapter.close();

    }

}
