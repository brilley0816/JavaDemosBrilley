package Brilley.ClassicalAlgorithmsProblems;

import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.Random;


/**
 * @author Brilley
 * @date 2022/9/18
 */
public class HeapSort {
    public static void test1() {
        int len = 20;
        Random rd = new Random();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = rd.nextInt(100);
        }
        System.out.println(Arrays.toString(nums));
        buildHeap(nums);
        System.out.println("After heaping: " + Arrays.toString(nums));
        heapSort(nums);
        System.out.println("After sorting: " + Arrays.toString(nums));
    }
    public static void buildHeap(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            heapify(nums, len - 1, i);
        }
    }
    private static void heapify(int[] nums, int high, int index) {
        int maxPos = 0;
        int left = 0;
        int right = 0;
        int temp = 0;
        while (true) {
            maxPos = index;
            left = index * 2 + 1;
            right = index * 2 + 2;
            if (left <= high && nums[index] < nums[left] ) {
                maxPos = left;
            }
            if (right <= high && nums[maxPos] < nums[right]) {
                maxPos = right;
            }
            if (index == maxPos) {
                break;
            }
            temp = nums[maxPos];
            nums[maxPos] = nums[index];
            nums[index] = temp;
            index = maxPos;
        }
    }
    public static void heapSort(int[] nums) {
        int len = nums.length;
        int temp = 0;
        for (int i = 0; i < len - 1; i++) {
            temp = nums[0];
            nums[0] = nums[len - 1 - i];
            nums[len - 1 - i] = temp;
            heapify(nums, len - 1 - i - 1, 0);
        }
    }
}
