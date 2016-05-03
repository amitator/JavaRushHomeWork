package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test
{
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream("c:/tmp/123.txt");
        FileOutputStream output = new FileOutputStream("c:/tmp/test.txt");

        System.out.println("Original:");
        while (input.available() > 0) {
            int data = input.read();
            output.write(data);
            System.out.print(data + " ");
        }
        input.close();

        System.out.println("Done");

        System.out.println("Copy:");

        FileInputStream in2 = new FileInputStream("c:/tmp/test.txt");

        while (in2.available() > 0){
            int data = in2.read();
            System.out.print(data + " ");
        }
        in2.close();

    }
}
