package Brilley.DynamicProgramming;

import java.util.Arrays;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-05-07 11:15
 */
public class LWSTDistanceDP {
    public static int result = Integer.MAX_VALUE;
    private static int m;
    private static int n;
    private static char[] arr1;
    private static char[] arr2;
    public static void lwstDistance1(String str1, String str2) {
        m = str1.length();
        n = str2.length();
        arr1 = str1.toCharArray();
        arr2 = str2.toCharArray();
        int[][] states = new int[m][n];

        if (arr1[0] == arr2[0]) states[0][0] = 0;
        else states[0][0] = 1;

        //初始化第0行
        for (int j = 1; j < n; j++) {
            if (arr1[0] == arr2[j])
                states[0][j] = j;
            else
                states[0][j] = states[0][j - 1] + 1;
        }

        //初始化第0列
        for (int i = 1; i < m; i++) {
            if (arr1[i] == arr2[0])
                states[i][0] = i;
            else
                states[i][0] = states[i - 1][0] + 1;
        }

        int i = 1, j = 1;
        for (; i < m; i++)
            for(j = 1; j < n; j++) {
                if (arr1[i] == arr2[j])
                    states[i][j] = states[i - 1][j - 1];
                else
                    states[i][j] = Math.min((Math.min(states[i - 1][j - 1], states[i - 1][j])), states[i][j - 1]) + 1;
            }
        System.out.println(Arrays.toString(states[0]));
        System.out.println("The lwst distance between " + str1 + " and " + str2 + " is: " + states[m - 1][n - 1]);

    }

    public static void lwstDistance2(String str1, String str2) {
        result = Integer.MAX_VALUE;
        m = str1.length();
        n = str2.length();
        arr1 = str1.toCharArray();
        arr2 = str2.toCharArray();
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mem[i][j] = -1;

        result = getLWSTDT(m - 1, n - 1, mem);

        System.out.println(Arrays.toString(mem[0]));
        System.out.println("The lwst distance between " + str1 + " and " + str2 + " is: " + result);
    }

    private static int getLWSTDT1(int index1, int index2, int[][] mem) {
//        if (index1 == 0 && index2 == 0) {
//            if (arr1[0] == arr2[0])
//                mem[0][0] = 0;
//            else
//                mem [0][0] = 1;
//            return mem[0][0];
//        }

        if (mem[index1][index2] >= 0)
            return mem[index1][index2];

        if (index1 == 0) {
            System.out.println(index2);
            if (arr1[0] == arr2[index2])
                mem[0][index2] = index2;
            else
                mem[0][index2] = mem[0][index2 - 1] + 1;         //这里的mem[0][0]还是-1！！！！
            System.out.println(mem[0][index2]);
            return mem[0][index2];
        }

        if (index2 == 0) {
            if (arr2[0] == arr1[index1])
                mem[index1][0] = index1;
            else
                mem[index1][0] = mem[index1 - 1][0] + 1;
            return mem[index1][0];
        }
        //这里为什么没有考虑字符串的比较？这是两种截然不同的情况，下面的转移情况是只考虑了字符串不相等的时候
        if (arr1[index1 - 1] != arr2[index2 - 1])
            mem[index1][index2] = Math.min(Math.min(getLWSTDT(index1 - 1, index2, mem),getLWSTDT(index1, index2 - 1,mem)),getLWSTDT(index1 - 1, index2 - 1, mem)) + 1;
        else
            mem[index1][index2] = Math.min(Math.min(getLWSTDT(index1 - 1, index2 - 1, mem),getLWSTDT(index1, index2 - 1,mem) + 1), getLWSTDT(index1 - 1, index2 - 1, mem) + 1);
        return mem[index1][index2];
    }

    private static int getLWSTDT(int index1, int index2, int[][] mem) {
        if (index1 == 0 && index2 == 0) {
            if (arr1[0] == arr2[0])
                mem[0][0] = 0;
            else
                mem [0][0] = 1;
            return mem[0][0];
        }

        if (mem[index1][index2] >= 0)
            return mem[index1][index2];

        if (index1 == 0) {
            //System.out.println(index2);
            if (arr1[0] == arr2[index2])
                mem[0][index2] = index2;
            else
                mem[0][index2] = getLWSTDT(0, index2 - 1, mem) + 1;
            //System.out.println(mem[0][index2]);
            return mem[0][index2];
        }

        if (index2 == 0) {
            if (arr2[0] == arr1[index1])
                mem[index1][0] = index1;
            else
                mem[index1][0] = getLWSTDT(index1 - 1, 0, mem) + 1;
            return mem[index1][0];
        }
        //这里为什么没有考虑字符串的比较？这是两种截然不同的情况，下面的转移情况是只考虑了字符串不相等的时候
        if (arr1[index1 - 1] != arr2[index2 - 1])
            mem[index1][index2] = Math.min(Math.min(getLWSTDT(index1 - 1, index2, mem),getLWSTDT(index1, index2 - 1,mem)),getLWSTDT(index1 - 1, index2 - 1, mem)) + 1;
        else
            mem[index1][index2] = Math.min(Math.min(getLWSTDT(index1 - 1, index2 - 1, mem),getLWSTDT(index1, index2 - 1,mem) + 1), getLWSTDT(index1 - 1, index2 - 1, mem) + 1);
        return mem[index1][index2];
    }

    public static void lwstDistance3(String str1, String str2) {
        m = str1.length();
        n = str2.length();
        arr1 = str1.toCharArray();
        arr2 = str2.toCharArray();
        int[][] states = new int[m + 1][n + 1];

        //初始化第0行
        for (int j = 0; j <= n; j++) {
            states[0][j] = j;
        }

        //初始化第0列
        for (int i = 1; i < m; i++) {
            states[i][0] = i;
        }

        int i = 1, j = 1;
        for (; i <= m; i++)
            for(j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1])
                    states[i][j] = Math.min((Math.min(states[i - 1][j - 1] - 1, states[i - 1][j])), states[i][j - 1]) + 1;
                else
                    states[i][j] = Math.min((Math.min(states[i - 1][j - 1], states[i - 1][j])), states[i][j - 1]) + 1;
            }
        System.out.println(Arrays.toString(states[1]));
        System.out.println("The lwst distance between " + str1 + " and " + str2 + " is: " + states[m][n]);
    }

    public static void lwstDistance4(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int result;
        // 有一个字符串为空串
        if (n * m == 0) {
            result = n + m;
        }

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        System.out.println("The lwst distance between " + str1 + " and " + str2 + " is: " + D[n][m]);
    }
}
