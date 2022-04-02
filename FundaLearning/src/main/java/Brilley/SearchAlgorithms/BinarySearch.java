package Brilley.SearchAlgorithms;

import java.time.chrono.MinguoChronology;

public class BinarySearch {
    public static int searchImp1(int[] arrs,int val)
    {
        int low=0;
        int high=arrs.length-1;
        int mid=0;
        // must check the boundary
        while(low<=high)
        {
            mid=low+((high-low)>>1);
            if(arrs[mid]==val)
                return mid;
            else if(arrs[mid]<val)
            {
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return -1;
    }

    public static int searchImp2(int[] arrs,int low, int high,int val)
    {
        // must check the boundary
        if(low>high)
            return -1;
        int mid=low+((high-low)>>1);
        if (arrs[mid]==val) return mid;
        else if(arrs[mid]<val)
            return searchImp2(arrs,mid+1,high,val);
        return searchImp2(arrs,0,mid-1,val);
    }

    public static int bSearchFirst(int[] arrs,int low, int high,int val)
    {

        int mid=0;
        // must check the boundary
        while(low<=high)
        {
            mid=low+((high-low)>>1);
            if(arrs[mid]==val)
                if(mid==0 || arrs[mid-1]<val)
                    return mid;
                else
                {
                    high=mid-1;
                }
            else if(arrs[mid]<val)
            {
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return -1;
    }

    public static int bSearchLast(int[] arrs,int low, int high,int val)
    {
        int mid=0;
        while(low<=high)
        {
            mid=(low+((high-low)>>1));
            if(arrs[mid]==val)
                if(mid==arrs.length-1 || arrs[mid+1]>val)
                    return mid;
                else
                {
                    low=mid+1;
                }
            else if(arrs[mid]>val)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }

    //get the index of first val a that greater than or equal to val b
    public static int bSearchFirstGreaterOrEqual(int[] arrs,int low, int high,int val)
    {
        int mid=0;
        while(low<=high)
        {
            mid=(low+((high-low)>>1));
            if(arrs[mid]>=val)
            {
                if(mid==0 || arrs[mid-1]<val)
                    return mid;
                else
                {
                    high=mid-1;
                }
            }
            else
                low=mid+1;
        }
        return -1;
    }

    //get the index of first val a that greater than or equal to val b
    public static int bSearchLastLessOrEqual(int[] arrs,int low, int high,int val)
    {
        int mid=0;
        while(low<=high)
        {
            mid=low+((high-low)>>1);
            if(arrs[mid]<=val)
            {
                if(mid==arrs.length-1 || arrs[mid+1]>val)
                    return mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return -1;
    }
}
