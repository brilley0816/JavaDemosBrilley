package Brilley.ClassicalAlgorithmsProblems;

import Brilley.Chapter06.ArraysTools;
import sun.java2d.pipe.SpanIterator;

import java.util.Arrays;

/**
 * @author Brilley
 * @date 2022/7/20
 */
public class MaxRealValue {
    public static void maxRealValue (int m, int[] sellPrice, int[] realValue) {
        // write code here
        sort(sellPrice);
        sort(realValue);
        int index = 0;
        int sum = 0;
        for (int i = 0; i < sellPrice.length; i++) {
            if (sum >= m && i != 0) {
                index = i - 1;
                System.out.println(sum);
                break;
            }
            sum += sellPrice[i];
        }
        sum = 0;
        for (int i = realValue.length - 1; i >= realValue.length - index - 1; i-- ) {
            sum += realValue[i];
        }
        System.out.println(Arrays.toString(sellPrice));
        System.out.println(Arrays.toString(realValue));
        System.out.println(index);
        System.out.println(sum);
    }
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
