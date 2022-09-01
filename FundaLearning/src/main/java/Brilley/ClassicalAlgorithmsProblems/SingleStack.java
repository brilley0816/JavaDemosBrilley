package Brilley.ClassicalAlgorithmsProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-09-01 19:16
 */
public class SingleStack {
    public static void test1() {
        int nums = 0;
        Scanner sc = new Scanner(System.in);
        nums = sc.nextInt();
        int[] arr1 = new int[nums];
        for (int i = 0; i < nums; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[nums];
        for (int i = 0; i < nums; i++) {
            arr2[i] = sc.nextInt();
        }
        Map<Integer, Integer> arrMap = new HashMap<>();
        int index1 = nums - 1;
        int index2 = nums - 1;
        while (index1 > 0) {
            if (arrMap.get(arr2[index2]) != null) {
                index2 --;
                continue;
            }
            if (arr1[index1] == arr2[index2]) {
                index2 --;
                index1 --;
            } else {
                index1 --;
                arrMap.put(arr1[index2], 0);
            }
        }
        System.out.println(arrMap.size());
    }
}
