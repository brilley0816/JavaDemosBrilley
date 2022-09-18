package Brilley.ClassicalAlgorithmsProblems;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Brilley
 * @date 2022/9/17
 */
public class FindKestNum {
    public static void test1() {
        int len = 100000;
        int[] nums = new int[len];
        Random rd = new Random();
        for (int i = 0; i < len; i++) {
            nums[i] = rd.nextInt(1000);
        }
        int k = 8000;
        long t1, t2;
        t1 = System.currentTimeMillis();
        int result = findKestNumWithStack(nums, 0, len - 1, k);
        t2 = System.currentTimeMillis();
        System.out.println("The Kest Num in Nums is: " + result + " duration: " + (t2 - t1));
        t1 = System.currentTimeMillis();
        result = findKestNumWithQuickSort(nums, 0, len - 1, k);
        t2 = System.currentTimeMillis();
        System.out.println("The Kest Num in Nums is: " + result+ " duration: " + (t2 - t1));
        SortTest.quickSort(nums, 0, len - 1); // from small to big
        System.out.println("After sorting, the Kth num is: " + nums[len - k]);
    }
    private static int findKestNumWithQuickSort(int[] nums, int low, int high, int K) {
        if (low > high) {              // low == high时，可能也是想要的分治点，所以不能返回，这里的条件和QuickSort有所不同
            return -1;
        }
        int pivot = findPivot(nums, low, high);
        if (pivot == (K - 1)) {
            return nums[pivot];
        } else if (pivot < (K - 1)) {
            return findKestNumWithQuickSort(nums, pivot + 1, high, K);
        } else {
            return findKestNumWithQuickSort(nums, low, pivot - 1, K);
        }
    }
    private static int findPivot(int[] nums, int low, int high) {
        int i = low;
        int temp = nums[high];
        for (int j = low; j < high; j++) {
            if (nums[j] > temp) {
                if (i != j) {
                    int value = nums[j];
                    nums[j] = nums[i];
                    nums[i] = value;
                }
                i++;
            }
        }
        nums[high] = nums[i];
        nums[i] = temp;
        return i;
    }

    private static int findKestNumWithStack(int[] nums, int low, int high, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(K);
        for (int i = low; i <= high; i++) {
            if (queue.size() < K) {
                queue.add(nums[i]);
            } else {
                // // 在小根堆内，存储着K个较大的元素，根是这K个中最小的，如果出现比根还要大的元素，说明可以替换根
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.add(nums[i]);
                }

            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
