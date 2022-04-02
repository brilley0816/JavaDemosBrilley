package Brilley.SortAlgorithms;

import java.util.Arrays;

/**
 * @author Brilley
 * @date 2022/3/24
 */
public class MergeSort {
    public static void sort(int[] arrs){
        System.out.println(Arrays.toString(arrs));
        mergeSort(arrs,0,arrs.length-1);
        System.out.println(Arrays.toString(arrs));
    }
    public static void mergeSort(int[] arrs, int start, int end){
        if(start<end)
        {
            int mid=start+(end-start)/2;
            mergeSort(arrs,start,mid);
            mergeSort(arrs,mid,start);
            merge(arrs,start,mid,end);
        }
    }

    public static void merge(int[] arrs,int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k=0;
        int[] temp=new int[end-start+1];
        while (i <= mid && j <= end){
            if(arrs[i]<=arrs[j]) //stable,keep left is left
            {
                temp[k++]=arrs[i++];
            }
            else
                temp[k++]=arrs[j++];
        }
        while (i<=mid){
            temp[k++]=arrs[i++];
        }
        while(j<=end)
            temp[k++]=arrs[j++];

        for(k=0;k<=end-start;k++)
            arrs[k+start]=temp[k];
    }
}
