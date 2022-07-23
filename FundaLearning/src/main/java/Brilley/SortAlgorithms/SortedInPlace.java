package Brilley.SortAlgorithms;

import java.util.Arrays;

/**
 * @author Brilley
 * @date 2022/3/21
 */
public class SortedInPlace {
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++)
        {
            int flag=0;
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=1;
                }
            }
            if(flag==0)
                break;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for (int i = 1;i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            for (; j >= 0; j--) {
                if(arr[j] > temp) {
                    arr[j+1] = arr[j];
                }
                else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++)
        {
            int min=arr[i];
            int index=i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<min)
                {
                    min=arr[j];
                    index=j;
                }
            }
            int temp=arr[i];
            arr[i]=min;
            arr[index]=temp;

        }
        System.out.println(Arrays.toString(arr));
    }
}
