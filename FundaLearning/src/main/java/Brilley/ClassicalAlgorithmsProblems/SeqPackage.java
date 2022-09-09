package Brilley.ClassicalAlgorithmsProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-09-03 9:43
 */
public class SeqPackage {
    private static final int N = 100;
    static int[] value = new int[N];
    static int[][] v = new int[N][N];
    static int[][] w = new int[N][N];
    static int[] s = new int[N];
    public static void test1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            for (int j = 1; j <= s[i]; j++) {
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <=n; i++) {
            for (int j = m; j >= 0; --j) {
                for (int k = 0; k <= s[j]; k++) {
                    if (v[i][k] <= j) {
                        value[j] = Math.max(value[j], value[j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(value));
    }
}
