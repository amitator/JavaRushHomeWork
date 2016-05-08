package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData incomeData;

        public IncomeDataAdapter (IncomeData incomeData){
            this.incomeData = incomeData;
        }

        public String getCompanyName(){
            return this.incomeData.getCompany();
        }

        public String getCountryName() {
            String country = "";

            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (entry.getKey().equals(this.incomeData.getCountryCode())) {
                    country = entry.getValue();
                }
            }

            return country;
        }

        public String getName() {
            return this.incomeData.getContactLastName() + ", " + this.incomeData.getContactFirstName();
        }

        public String getPhoneNumber() {
            String tel = "";
            if ((tel = String.valueOf(this.incomeData.getPhoneNumber())).length() < 10) {
                int len = tel.length();
                for (int i = 0; i < 10 - len; i++) {
                    tel = "0" + tel;
                }
                tel = String.valueOf("+" + this.incomeData.getCountryPhoneCode() + "(" +
                        tel.substring(0, 3) +
                        ")" + tel.substring(3, 6) +
                        "-" + tel.substring(6, 8) +
                        "-" + tel.substring(8));
            } else {
                tel = String.valueOf(this.incomeData.getPhoneNumber());
            }

            return tel;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

}