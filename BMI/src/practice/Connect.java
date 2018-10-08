package practice;

import java.io.*; 
//Java Program to illustrate reading from FileReader 
//using BufferedReader 
import java.util.StringTokenizer;

public class Connect 
{ 
public static void main(String[] args)throws Exception 
{ 
File file = new File("C:\\Users\\SNU1\\git\\BMI\\BMI\\text\\test.txt"); 

BufferedReader br = new BufferedReader(new FileReader(file)); 
StringTokenizer tokenizer;
String st; 
while ((st = br.readLine()) != null) 
 System.out.println(st); 
} 
} 