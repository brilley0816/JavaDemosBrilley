package Brilley.ClassicalAlgorithmsProblems;

import java.util.Arrays;
import java.util.Scanner;

// 有三个题库A、B、C，每个题库均有n道题目，且题目都是从1到n进行编号。每个题目都有一个难度值，题库A中第i个题目的难度为ai，题库B中第i个题目的难度为bi，题库C中第i个题目的难度为ci。
//
//小美准备组合出一套试题，试题共有三道题，第一题来自题库A，第二题来自题库B，第三题来自题库C。试题要求题目难度递增，且梯度不能过大。具体地说，第二题的难度必须大于第一题的难度，但不能大于第一题难度的两倍；第三题的难度必须大于第二题的难度，但不能大于第二题难度的两倍。小美想知道在满足上述要求下，有多少种不同的题目组合？（三道题目中只要存在一道题目不同，则两个题目组合就视为不同）
// AC 82%
/**
 * @author Brilley
 * @description voa-server
 * @date 2022-09-03 11:53
 */
public class QuestionHard {
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[] c = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            c[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (b[j] > a[i] && b[j] <= 2 * a[i]) {
                    for (int k = 1; k <= n; k++) {
                        if (c[k] > b[j] && c[k] <= 2 * b[j]) {
                            count++;
                        }
                    }

                } else {
                    continue;
                }
            }
        }
        System.out.print(count);
    }
}
