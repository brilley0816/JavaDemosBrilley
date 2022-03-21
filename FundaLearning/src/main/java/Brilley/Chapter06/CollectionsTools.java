package Brilley.Chapter06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTools {
    public static void test1(){
        List<String> list=new ArrayList<>();
        Collections.addAll(list,"brilley1","brilley2","brilley3","yanyan1","yanyan2");
        System.out.println(list);
        List<String> list2=new ArrayList<>();
        Collections.addAll(list2,"brilley1","brilley5","brilley8","yanyan9","yanyan10");
        System.out.println(list2);
        System.out.println(Collections.disjoint(list,list2));
        List<String> list3=new ArrayList<>();
        Collections.addAll(list3,"brilley4","brilley9","brilley81","yanyan19","yanyan102");
        System.out.println(Collections.disjoint(list,list3));
        List emptyList=Collections.emptyList();
        try{
            emptyList.add("love");
        }
        catch (Exception e){
            System.out.println(e);
        }
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.swap(list,1,list.size()-1);
        System.out.println(list);
        System.out.println("where is the string of yanyan1: " +Collections.binarySearch(list,"yanyan1"));

    }
}
