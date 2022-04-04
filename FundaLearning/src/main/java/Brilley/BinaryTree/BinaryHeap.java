package Brilley.BinaryTree;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author Brilley
 * @date 2022/4/4
 */
public class BinaryHeap {
    public static void upAdjust(int[] array){
        int childIndex=array.length-1;
        int parentIndex=(childIndex-1)/2;
        int temp=array[childIndex];
        while(childIndex>0 && temp<array[parentIndex]){
            array[childIndex]=array[parentIndex];
            childIndex=parentIndex;
            parentIndex=(parentIndex-1)/2;
        }
        array[childIndex]=temp;
    }

    public static void downAdjust(int[] array, int parentIdnex, int length){
        int temp=array[parentIdnex];
        int childIndex=2*parentIdnex+1;
        while(childIndex<length){
            if(childIndex+1<length && array[childIndex+1]<array[childIndex]){
                childIndex++;
            }
            if(temp<=array[childIndex])
                break;
            array[parentIdnex]=array[childIndex];
            parentIdnex=childIndex;
            childIndex=2*childIndex+1;
        }
        array[parentIdnex]=temp;
    }

    public static void downAdjustMax(int[] array, int parentIdnex, int length){
        int temp=array[parentIdnex];
        int childIndex=2*parentIdnex+1;
        while(childIndex<length){
            if(childIndex+1<length && array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            if(temp>=array[childIndex])
                break;
            array[parentIdnex]=array[childIndex];
            parentIdnex=childIndex;
            childIndex=2*childIndex+1;
        }
        array[parentIdnex]=temp;
    }
    public static void buildHeap(int[] array){
        for(int i=(array.length-2)/2;i>=0;i--){
            downAdjust(array,i,array.length);
        }
    }

    public static void buildMaxHeap(int[] array){
        for(int i=(array.length-2)/2;i>=0;i--){
            downAdjustMax(array,i,array.length);
        }
    }
    public static void heapSort(int[] array){
        System.out.println("origin array is: ");
        System.out.println(Arrays.toString(array));
        buildMaxHeap(array);
        System.out.println("build heap array is: ");
        System.out.println(Arrays.toString(array));

        for(int i=array.length-1;i>=0;i--){
            int temp=array[0];
            array[0]=array[i];
            array[i]=temp;
            downAdjustMax(array,0,i);
        }
        System.out.println("after heap sort is: ");
        System.out.println(Arrays.toString(array));
    }

    public static void test1(){
        int[] array=new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array=new int[]{7,1,4,4,6,3,6,8};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
