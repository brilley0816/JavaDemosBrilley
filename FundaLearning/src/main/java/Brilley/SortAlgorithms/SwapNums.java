package Brilley.SortAlgorithms;

import java.util.Arrays;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-08-31 20:08
 */
public class SwapNums {
    public static void test1() {
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = {1,5, 3, 4, 2};
        int h = 1;
        int m = dictionarySeqNums(arr1);
        int n = dictionarySeqNums(arr2);
        System.out.println(m);
        System.out.println(n);
        System.out.println(Math.abs(m - n));
        System.out.println("done");
    }

    private static int dictionarySeqNums(int[] arr) {
        int result = 0;
        for (int i = 1;i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                result++;
            }
        }
        return result;
    }
}
