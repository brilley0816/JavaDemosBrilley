package Brilley.DynamicProgramming;

import java.util.Arrays;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-05-06 20:09
 */
public class KnapsackProDP {
    private static int[] weight = {2,3,3,3,3};
    private static int[] values = {8,3,3,5,6};
    private static int n = 5;
    private static int w = 10;
    public static int wMax;
    public static int vMax;
    public static void knapsack() {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true; //初始状态是正确的 特殊处理
        states[0][weight[0]] = true;
        for (int i = 1; i < n; i++) {
           for (int j = 0; j <= w; j ++) {
               //不装第i个物品
               if (states[i - 1][j] == true) states[i][j] = true;
           }
            for (int j = 0; j + weight[i] <= w; j ++) {
                //装第i个物品
                if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
            }
        }
        for (int j = 0; j <= w; j++) {
            if(states[n-1][j] == true && j > wMax ) wMax = j;
        }
        System.out.println(Arrays.toString(states[n - 1]));
        System.out.println(wMax);
    }

    //降低空间复杂度
    public static void knapsack2() {
        boolean[] states = new boolean[w+1];
        states[0] = true;
        states[weight[0]] = true;
        //这里的I其实就是阶段
        for (int i = 1; i < n; i ++) {
            for (int j = w; j >= 0; j--) {
                if (states[j] == true) states[j] = true;
            }
            for (int j = w - weight[i]; j >= 0; j--) {
                if (states[j] == true) states[j + weight[i]] = true;
            }
            System.out.println(Arrays.toString(states));
        }

        for (int j = w; j >= 0; j--) {
            if(states[j] == true) {
                wMax = j;
                break;
            }
        }
        System.out.println(wMax);
    }

    //加入价值怎么算
    public static void knapsack3() {
        int[] states = new int[w + 1];
        for (int i = 0; i <= w; i++)
            states[i] = -1;
        states[0] = 0;
        states[weight[0]] = values[0];
        for (int i =1 ; i < n; i++) {
//            //不加入i
//            for (int j = w; j >= 0; j--)
//                if (states[j] != -1) states[j] = states[j];
            //加入i

            for (int j = w -weight[i]; j >= 0; j--) {
                int v = 0;
                if (states[j] != -1)  v = states[j] + values[i];
                if (v > states[j + weight[i]]) states[j + weight[i]] = v;
            }
        }
        for (int j = w; j >= 0; j--) {
            if(states[j] > vMax) {
                vMax = states[j];
            }
        }
        System.out.println(vMax);

    }
    //上面的方法其实都算是状态转移表
}
