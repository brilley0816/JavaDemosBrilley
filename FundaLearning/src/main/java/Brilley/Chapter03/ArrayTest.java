package Brilley.Chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Brilley
 * @date 2022/3/13
 */
public class ArrayTest {
    static int[] anArray=new int[]{35,7,99,23,5};
    public static void test(){
        for(int i:anArray)
        {
            System.out.println(i+" ");
        }
        Arrays.sort(anArray);
        System.out.println(anArray);
        for(int i:anArray)
        {
            System.out.println(i+" ");
        }

        List<Integer> aList=new ArrayList<>();
        for(int element:anArray)
        {
            aList.add(element);
        }
        System.out.println(aList);
        aList.add(6);
        System.out.println(aList);

        //array to list
        int[] anotherArray=new int[]{3,5,3,2,5};
        //List<Integer> anotherList=Arrays.asList(anotherArray);
        List annList=new ArrayList(Arrays.asList(anotherArray));
        annList.add(67);
        System.out.println(annList.toString());
        Integer[] theArray=new Integer[]{23,34,234,44,23};
        Arrays.sort(theArray);
        System.out.println(theArray);
        List<Integer> theList=Arrays.asList(theArray);
        System.out.println(theList);
        //theList.add(78934);//UnsupportedOperationException
        List<Integer> theoList=new ArrayList<>(Arrays.asList(theArray));
        System.out.println(theoList);
        theoList.add(23);
        System.out.println(theoList);
        //Arrays.asList 接入的参数是泛型参数，基本类型无法泛型化
    }

    public static void printArray()
    {
        int[] intArray=new int[]{333,123,454,123,34};
        //method1
        System.out.println(Arrays.toString(intArray));
        //method2
        for(int i=0;i<intArray.length;i++)
        {
            System.out.print(intArray[i]+" ");
        }
        //method3
        for(int ele:intArray)
        {
            System.out.println(ele+" ");
        }
        //method4
        System.out.println("method4");
        Arrays.asList(intArray).stream().forEach(s-> System.out.print(s+" "));
        //method5
        System.out.println("method5");
        Stream.of(intArray).forEach(System.out::print);
        //method6
        System.out.println("method6");
        Arrays.stream(intArray).forEach(System.out::print);
    }
}
