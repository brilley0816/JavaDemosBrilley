package Brilley.Chapter04;

import sun.awt.image.ImageWatched;

import javax.annotation.processing.SupportedSourceVersion;
import java.sql.SQLSyntaxErrorException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Brilley
 * @date 2022/3/17
 */
public class LinkedListTest {
    public static void addFromFrist(int num){
        LinkedList<String> list=new LinkedList<>();
        int i=0;
        long startTime=System.currentTimeMillis();
        while (i<num)
        {
            list.addFirst("brilley");
            i++;
        }
        long endTime= System.currentTimeMillis();
        System.out.println("The time of LinkedList add "+num+" elements from first is "+(endTime-startTime));
    }

    public static void addFromMid(int num){
        LinkedList<String> list=new LinkedList<>();
        int i=0;
        long startTime=System.currentTimeMillis();
        while (i<num)
        {
            int temp=list.size();
            list.add(temp/2,"brilley");
            i++;
        }
        long endTime= System.currentTimeMillis();
        System.out.println("The time of LinkedList add "+num+" elements from mid is "+(endTime-startTime));
    }

    public static void addFromLast(int num){
        LinkedList<String> list=new LinkedList<>();
        int i=0;
        long startTime=System.currentTimeMillis();
        while (i<num)
        {
            list.add("brilley");
            i++;
        }
        long endTime= System.currentTimeMillis();
        System.out.println("The time of LinkedList add "+num+" elements from first is "+(endTime-startTime));
    }

    public static void forPrint(int num)
    {
        LinkedList<String> list=new LinkedList<>();
        long startTime= System.currentTimeMillis();
        for(int i=0;i<num;i++)
            list.add("brilley");
        for(int i=0;i<list.size();i++)
            list.get(i);
        long endTime=System.currentTimeMillis();
        System.out.println("The time of LinkedList add "+num+" elements and for print is "+(endTime-startTime));
    }

    public static void iteratorPrint(int num)
    {
        LinkedList<String> list=new LinkedList<>();
        long startTime= System.currentTimeMillis();
        for(int i=0;i<num;i++)
            list.add("brilley");

        int i=0;
        for(Iterator<String> it=list.iterator();it.hasNext();)
        {
            it.next();
            i++;
            if(i<50)
                System.out.println(it.next().toString());
        }
        long endTime=System.currentTimeMillis();
        System.out.println("The time of LinkedList add "+num+" elements and iterator print is "+(endTime-startTime));
    }
}
