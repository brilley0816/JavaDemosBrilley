package Brilley.Chapter06;

import sun.java2d.pipe.SpanIterator;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Brilley
 * @date 2022/3/20
 */
public class ArraysTools {
    public static void test1(){
        int[] arr=new int[]{1,2,3,4};
        System.out.println(Arrays.toString(arr));
        Arrays.parallelPrefix(arr,(left,right)->left+right);
        System.out.println(Arrays.toString(arr));
        Arrays.parallelPrefix(arr,(left,right)->{
            System.out.println(left+","+right);
            return left+right;
        });
        System.out.println(Arrays.toString(arr));
        Arrays.setAll(arr,i->i*10);
        System.out.println(Arrays.toString(arr));
        Arrays.setAll(arr,i->{
            System.out.println("the element is: "+i);
            return i<<1;
        });
        System.out.println(Arrays.toString(arr));
        //arr需要装一下箱才可以，否则不允许下面的操作
        //List<Integer> nums=new ArrayList<Integer>(Arrays.asList(arr));
        //Integer[] arrIntBox=Arrays.copyOf(arr,4); 也不可以
        Integer[] arrIntBox=new Integer[]{7,7,8,8,5,2,1};
        System.out.println(Arrays.toString(arrIntBox));
        List<Integer> nums=new ArrayList<>(Arrays.asList(arrIntBox));
        System.out.println(nums);
        Arrays.sort(arrIntBox);
        System.out.println(Arrays.toString(arrIntBox));
        Object c=Arrays.binarySearch(arrIntBox,5);
        System.out.println("search result is: "+c);
    }
}
