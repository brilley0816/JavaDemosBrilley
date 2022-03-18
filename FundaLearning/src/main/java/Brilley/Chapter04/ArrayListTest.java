package Brilley.Chapter04;

import java.util.ArrayList;

/**
 * @author Brilley
 * @date 2022/3/17
 */
public class ArrayListTest {
    public static void addFromFirst(int num){
        ArrayList<String> list=new ArrayList<>(num);
        int i=0;

        long timeStart=System.currentTimeMillis();
        while(i<num)
        {
            list.add(0,String.valueOf(i));
            i++;
        }
        long timeEnd=System.currentTimeMillis();
        System.out.println("The time of ArrayList add "+num+" elements from first is "+(timeEnd-timeStart));
    }

    public static void addFromMid(int num){
        ArrayList<String> list=new ArrayList<>(num);
        int i=0;

        long timeStart=System.currentTimeMillis();
        while(i<num)
        {
            int temp=list.size();
            list.add(temp/2,String.valueOf(i));
            i++;
        }
        long timeEnd=System.currentTimeMillis();
        System.out.println("The time of ArrayList add "+num+" elements from mid is "+(timeEnd-timeStart));
    }

    public static void addFromLast(int num){
        ArrayList<String> list=new ArrayList<>(num);
        int i=0;
        long timeStart=System.currentTimeMillis();
        while(i<num){
            list.add(String.valueOf(i));
            i++;
        }
        long timeEnd= System.currentTimeMillis();
        System.out.println("The time of ArrayList add "+num+" elements from last is "+(timeEnd-timeStart));

    }
}
