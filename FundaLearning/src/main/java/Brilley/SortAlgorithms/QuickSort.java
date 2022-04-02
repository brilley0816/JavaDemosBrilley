package Brilley.SortAlgorithms;

import java.util.Arrays;

/**
 * @author Brilley
 * @date 2022/3/24
 */
public class QuickSort {
    public static void sort(int[] arrs){
        System.out.println(Arrays.toString(arrs));
        quickSort(arrs,0,arrs.length-1);
        System.out.println(Arrays.toString(arrs));
    }

    public static void quickSort(int[] arrs,int start, int end){
        if(start<end){
            int q=partion(arrs,start,end);
            quickSort(arrs,start,q-1);
            quickSort(arrs,q+1,end);
        }
    }

    public static int partion(int[] arrs, int start, int end){
        int i=start;
        int j=start;
        int pivot=arrs[end];
        int temp;
        for(;j<end;j++){
            if(arrs[j]<pivot){
                temp=arrs[j];
                arrs[j]=arrs[i];
                arrs[i++]=temp;
            }
        }
        temp=arrs[i];
        arrs[i]=arrs[end];
        arrs[end]=temp;
        return i;
    }

    public static int kthMaxValue(int[] arrs, int k){
        System.out.println(Arrays.toString(arrs));
        int result=quickSortSearch(arrs,0,arrs.length-1,k);
        return result;
    }

    public static int quickSortSearch(int[] arrs, int start, int end, int k){
        if(k>end+1 || k<=0)
            return -1;
        if(start<end){
            int q=partion(arrs,start,end);
            if(q==k-1)
                return arrs[q];
            else if(q<k-1)
                return quickSortSearch(arrs,q+1,end,k-q-1);
            else if(q>k-1)
                return quickSortSearch(arrs,start,q-1,k);
        }
        return arrs[start];
    }
}
