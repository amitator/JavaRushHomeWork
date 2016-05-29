package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable{
    private static final long serialVersionUID = 23452345L;

    public A getOriginalObject(ObjectInputStream objectStream) {
        Object obj = null;

        try {
            obj = objectStream.readObject();
        } catch (ClassNotFoundException ex) {
        } catch (IOException ex) {}

        if (obj instanceof B) {
            return (B) obj;
        } else {
            return (A) obj;
        }
    }

    public class A implements Serializable{
        private static final long serialVersionUID = 334L;
    }

    public class B extends A {
        private static final long serialVersionUID = 3425L;
        public B() {
            System.out.println("inside B");
        }
    }
}
