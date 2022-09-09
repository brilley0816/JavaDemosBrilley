package Brilley.ClassicalAlgorithmsProblems;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-09-09 22:00
 */
public class SortTest {
    public static void test1() {
        long t1 = System.currentTimeMillis();
        Random rd = new Random();
        int len = 20000;
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        int[] arr3 = new int[len];
        for (int i = 0;i < len; i++) {
            int temp = rd.nextInt(len);
            arr1[i] = temp;
            arr2[i] = temp;
            arr3[i] = temp;
        }
        long t2 = System.currentTimeMillis();
        t1 = System.currentTimeMillis();
        bubbleSort(arr1);
        System.out.println(arr1[899]);
        t2 = System.currentTimeMillis();
        System.out.println("the time of sorting arrays is " + (t2 - t1) + "ms");

        t1 = System.currentTimeMillis();
        selectSort(arr2);
        System.out.println(arr2[899]);
        t2 = System.currentTimeMillis();
        System.out.println("the time of sorting arrays is " + (t2 - t1) + "ms");

        t1 = System.currentTimeMillis();
        mergeSort(arr3);
        System.out.println(arr3[899]);
        t2 = System.currentTimeMillis();
        System.out.println("the time of sorting arrays is " + (t2 - t1) + "ms");
    }
    private static void bubbleSort(int[] nums) {
        int len = nums.length;
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                if (flag == true) {
                    break;
                }
            }

        }
    }

    private static void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }

    private static void insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if(nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
                nums[j] = temp;
            }

        }
    }
    
    private static void mergeSort(int[] nums) {
        mergeSortInternally(nums, 0, nums.length - 1);
    }
    private static void mergeSortInternally(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + ((high - low) >> 1);
        mergeSortInternally(nums, low, mid);
        mergeSortInternally(nums, mid + 1, high);
        //merge(nums, low, mid, high);
        mergeBySentry(nums, low, mid, high);
    }
    private static void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <=high) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                k++;
                i++;
            } else {
                temp[k] = nums[j];
                k++;
                j++;
            }
        }
        // 判断剩余数据
        int start = i;
        int end = mid;
        if (j <= high) {
            start = j;
            end = high;
        }
        // 拷贝剩余数据
        while(start <= end) {
            temp[k] = nums[start];
            k++;
            start++;
        }
        for (i = 0; i <= high - low; i++) {
            nums[low + i] = temp[i];
        }
    }
    private static void mergeBySentry(int[] nums, int low, int mid, int high) {
        int[] lowArrs = new int[mid - low + 2];
        int[] highArrs = new int[high - mid - 1 + 2];
        for (int i = 0; i <= mid - low; i++) {
            lowArrs[i] = nums[low + i];
        }
        // 添加哨兵
        lowArrs[mid - low + 1] = Integer.MAX_VALUE;
        for (int i = 0; i <= high - mid - 1; i++) {
            highArrs[i] = nums[mid + 1 + i];
        }
        highArrs[high - mid - 1 + 1] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = low;
        while (k <= high) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (lowArrs[i] <= highArrs[j]) {
                nums[k] = lowArrs[i];
                i++;
                k++;
            } else {
                nums[k] = highArrs[j];
                j++;
                k++;
            }
        }

    }
}
