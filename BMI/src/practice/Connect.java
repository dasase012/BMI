package practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connect 
{ 
public static void main(String[] args)throws Exception 
{ 
File file = new File("C:\\Users\\SNU1\\git\\BMI\\BMI\\text\\test.txt"); 
Scanner scanner = new Scanner(file);
List<Integer> integers = new ArrayList<>();
while (scanner.hasNext()) {
    if (scanner.hasNextInt()) {
        integers.add(scanner.nextInt());
    } 
    else {
        scanner.next();
    }
}
System.out.println(integers);
} 


} 