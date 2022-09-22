package Brilley.ClassicalAlgorithmsProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Brilley
 * @date 2022/9/22
 */
class Data implements Comparable<Data>{
    int pos;
    int r;
    int value;
    Data() {
    }
    @Override
    public int compareTo(Data o) {
        if (this.pos > o.pos) {
            return 1;
        } else if (this.pos == o.pos) {
            return 0;
        } else {
            return -1;
        }
    }

}
public class GetMaxTreeValue {
    public static void test1() {
        Scanner sc = new Scanner(System.in);
        int len = 0;
        len = sc.nextInt();
        Data[] nums = new Data[len];
        for (int i = 0; i < len; i++) {
            nums[i] = new Data();
        }
        int edge = 0;
        for (int i = 0; i < len; i++) {
            nums[i].pos = sc.nextInt();
        }
        for (int i = 0; i < len; i++) {
            nums[i].r = sc.nextInt();
            edge = Math.max(nums[i].r + nums[i].pos, edge);
        }
        for (int i = 0; i < len; i++) {
            nums[i].value = sc.nextInt();
        }
        int[] dp = new int[edge + 1];
        Arrays.sort(nums);
//        for (int i = 0; i < len; i++) {
//            System.out.println(nums[i].pos);
//        }
//        dp[nums[0].pos + nums[0].r] = nums[0].value;
        //计算坐标为K时，可种植树的最大价值
        for (int k = nums[0].pos + 1; k < edge + 1; k ++) {
            for (int i = 0; i < len && nums[i].pos < k; i++ ) {
                if (nums[i].pos + nums[i].r == k && nums[i].value > dp[k - 1] - dp[nums[i].pos - nums[i].r]) {
                    dp[k] = Math.max(dp[k],dp[nums[i].pos - nums[i].r] + nums[i].value);
                }
                dp[k] = Math.max(dp[k], dp[k - 1]);
            }
        }
        System.out.println(Arrays.toString(dp));

    }
}
