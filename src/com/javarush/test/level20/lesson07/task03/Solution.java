package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static class Person implements Externalizable {
        private static final long serialVersionUID = 1L;
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public  Person() {}

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = (int) in.readObject();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            children = (List<Person>)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        FileOutputStream fileOutputStream = new FileOutputStream("temp.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        Person alex = new Person("Alex", "Prus", 25);
        alex.setMother(new Person("Kta", "Hz", 45));
        alex.setFather(new Person("Kto", "Hz", 50));
        List<Person> alexListOfKids = new ArrayList<>();
        alexListOfKids.add(new Person("Sin", "Hz", 3));
        alexListOfKids.add(new Person("Doch", "Hz", 7));
        alex.setChildren(alexListOfKids);

        outputStream.writeObject(alex);
        fileOutputStream.close();
        outputStream.close();

        FileInputStream fiStream = new FileInputStream("temp.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Person alexDeserialized = (Person) objectStream.readObject();
        fiStream.close();
        objectStream.close();
    }
}
