package Brilley.SortAlgorithms;

import java.util.Arrays;

/**
 * @author Brilley
 * @date 2022/4/7
 */
public class DictionarySort {
    public static void findNearBiggestValue(int[] vals){
        int index=findIndexTraversal(vals);
        if(index==0)
            System.out.println("there are no corresponding nums");
        exchangeVal(vals,index);
        sortTraveral(vals,index);
        System.out.println(Arrays.toString(vals));
    }

    private static int findIndexTraversal(int[] vals){
        int index;
        for(int i=vals.length-1;i>0;i--){
            if(vals[i]>vals[i-1])
                return i;
        }
        return 0;
    }

    private static void exchangeVal(int[] vals,int index){
        int temp=vals[index-1];
        int valCompare=vals[index];
        int exIndex=index;
        for(int i=index;i< vals.length;i++)
        {
            if(vals[i]>temp && vals[i]<valCompare)
            {
                valCompare=vals[i];
                exIndex=i;
            }
        }
        vals[index-1]=vals[exIndex];
        vals[exIndex]=temp;
    }

    private static void sortTraveral(int[] vals,int index){
        for(int i=index,j=vals.length-1;i<j;i++,j--){
            int temp=vals[i];
            vals[i]=vals[j];
            vals[j]=temp;
        }
    }
}
