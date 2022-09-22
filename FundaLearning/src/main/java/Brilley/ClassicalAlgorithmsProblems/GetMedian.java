package Brilley.ClassicalAlgorithmsProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Brilley
 * @date 2022/9/18
 */
public class GetMedian {
    private static PriorityQueue<Integer> bigHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private static PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
    private static int numsLeft = 0;
    private static int numsRight = 0;
    private static double result = 0;

    public static void test1() {
        int len = 10;
        int[] nums = new int[len];
        Random rd = new Random();
        for (int i = 0; i < len; i++) {
            int temp = rd.nextInt(10);
            nums[i] = temp;
            insert(temp);
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("the median is: " + getMedian().toString());
        }
    }

    public static void insert(Integer num) {
        if (numsLeft == numsRight) {
            if (bigHeap.isEmpty() || num <= smallHeap.peek()) {
                bigHeap.add(num);
            } else {
                int temp = smallHeap.poll();
                bigHeap.add(temp);
                smallHeap.add(num);
            }
            numsLeft++;

        } else if (numsLeft == numsRight + 1) {
            if (num >= bigHeap.peek()) {
                smallHeap.add(num);
            }
            else {
                int temp = bigHeap.poll();
                smallHeap.add(temp);
                bigHeap.add(num);
            }
            numsRight++;
        }
    }

    public static Double getMedian() {
//        System.out.println(smallHeap.peek());
//        System.out.println(bigHeap.peek());
//        System.out.println("hi");
        if (numsLeft == numsRight) {
            result = (double) (bigHeap.peek() + (smallHeap.peek() - bigHeap.peek()) / 2.0);
        } else {
            result = (double) bigHeap.peek() / 1.0;
        }
        return new Double(result);

    }
}
