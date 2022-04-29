package Brilley.Stream;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Brilley
 * @date 2022/4/7
 */
public class ScannerTest {
    public static void test1(){
        Scanner inStream=new Scanner(System.in);
        String str1=inStream.next();
        String str2=inStream.next();
        inStream.next
        System.out.println("str1 is: "+str1);
        System.out.println("str2 is: "+str2);
    }

    public static void test2() throws IOException {
        BufferedReader inStream=new BufferedReader(new InputStreamReader(System.in));
        String str1=inStream.readLine();
        String str2=inStream.readLine();//按行读入，空格也可以
        //String str3=inStream.read(); 返回的是int
        char[] ccAr=new char[20];
        inStream.read(ccAr,0,15);
        System.out.println("str1 is: "+str1);
        System.out.println("str2 is: "+str2);
        System.out.println(Arrays.toString(ccAr));
    }

    public static void test3() {
        Console console=System.console();
        if(console!=null){
            String str1=console.readLine("User:");
            String str2=console.readLine("passwd:");
            char[] charra3=console.readPassword("passwd:");
            System.out.println("str1 is: "+str1);
            System.out.println("str2 is: "+str2);
            for(char c:charra3)
            {
                System.out.print(c);
            }
        }

    }
}
