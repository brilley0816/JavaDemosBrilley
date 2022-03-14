package Brilley.Chapter03;

import sun.java2d.pipe.SpanIterator;

import java.util.ArrayList;

/**
 * @author Brilley
 * @date 2022/3/13
 */
public class GenericTypeTest {
    public static void test(){
        ArrayList<Wanger> list1=new ArrayList<>();
        Wanger w1=new Wanger();
        list1.add(w1);
        Wangxiaoer w2=new Wangxiaoer();
        list1.add(w2);
        System.out.println(list1);
        Wanglaoer w3=new Wanglaoer();
        //list1.add(w3);//error!
    }

    public static void test2(){
        ArrayList<? extends Wanger> list2=new ArrayList<>();
        Wanger w1=new Wanger();
        //list2.add(w1); error
        Wangxiaoer w2=new Wangxiaoer();
        //list2.add(w2); error
        System.out.println(list2);
        list2.add(null);
        list2.add(null);
        System.out.println(list2);
        // list2.get(0)=w2;
        System.out.println(list2.get(0));
        System.out.println(list2.get(1));

        ArrayList<Wanger> list3=new ArrayList<>();
        list3.add(w1);
        list3.add(w2);
        list2=list3;
        System.out.println(list2);//That's the point

        ArrayList<? super Wanger> list4=new ArrayList<>();
        list4.add(w1);
        list4.add(w2);
        System.out.println(list4);
        System.out.println(list4.get(0));
        //Wanger w3= list4.get(0); //can not get value;
        Wanger w3=list2.get(0);
        System.out.println(w3);

    }
}
