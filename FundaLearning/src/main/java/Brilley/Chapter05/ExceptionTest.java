package Brilley.Chapter05;

import sun.java2d.pipe.SpanIterator;

/**
 * @author Brilley
 * @date 2022/3/19
 */
public class ExceptionTest {
    public static void test1(String str){
        try{
            Class clz=Class.forName("Brilley.Chapter01."+str);
            System.out.println("The Class is available!");
        }
        catch (ClassNotFoundException e){
            System.out.println("there are some errors");
            e.printStackTrace();
        }
    }

    public static void test2(String str) throws ClassNotFoundException{
        Class clz=Class.forName("Brilley.Chapter01."+str);
        System.out.println("The Class is available!");
    }
}
