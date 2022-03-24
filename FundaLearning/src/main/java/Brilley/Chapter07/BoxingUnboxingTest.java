package Brilley.Chapter07;

import java.sql.SQLOutput;

/**
 * @author Brilley
 * @date 2022/3/21
 */
public class BoxingUnboxingTest {
    public static void test1(){
        Boolean booVarB=Boolean.valueOf(true);
        Boolean booVarA=Boolean.valueOf(true);
        System.out.println(booVarA==booVarB);//true
        booVarB=new Boolean(true);
        booVarA=new Boolean(true);
        System.out.println(booVarA==booVarB);//false
    }

    public static void test2(){
        // 1）基本类型和包装类型
        int a = 100;
        Integer b = 100;
        System.out.println(a == b);//b会自动拆箱，所以相等为真

        // 2）两个包装类型
        Integer c = 100;
        Integer d = 100;
        System.out.println(c == d);//c,d自动装箱，100是常量值，返回其引用，相等为真

        // 3）
        c = 200;
        d = 200;
        System.out.println(c == d);//new 两个Integer对象，分别又赋值200,200，不等，为false;


        //装箱的两种方式,第三种算不算？
        Integer boxData=800;
        Integer boxData2=Integer.valueOf(800);
        Integer boxData3=new Integer(800);
        System.out.println(boxData2);
        System.out.println(boxData3);
        System.out.println(boxData2==boxData3);

        //拆箱的方式
        int boxData4=boxData3;
        int boxData5=boxData3.intValue();
        System.out.println(boxData4);
        System.out.println(boxData4==boxData3);
        System.out.println(boxData4==boxData5);
    }

    public static void testEfficiency(){
        long t1 = System.currentTimeMillis();
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE;i++) {
            sum += i;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("the time to compute the sum of 0-Integer.MAX_VALUE by float type variable: "+(t2-t1));

        long t3 = System.currentTimeMillis();
        long sums = 0L;
        for (int i = 0; i < Integer.MAX_VALUE;i++) {
            sums += i;
        }
        long t4 = System.currentTimeMillis();
        System.out.println("the time to compute the sum of 0-Integer.MAX_VALUE by float type variable: "+(t4-t3));
    }

}
