package Brilley.DynamicProgramming;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-05-07 21:03
 */
public class LongestComStr {

    public static void getLongestCommonStr (String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int[][] states = new int[m][n];
        //初始化第零行
        if (arr1[0] == arr2[0])
            states[0][0] = 1;
        else
            states[0][0] = 0;
        for (int j = 1; j < n; j++) {
            if (arr1[0] == arr2[j])
                states[0][j] = 1;
            else
                states[0][j] = states[0][j - 1];
        }
        //KISS keep it simple and stupid!!!
        //初化始化零列
        for (int i = 1; i < m; i++) {
            if (arr1[i] == arr2[0])
                states[i][0] = 1;
            else
                states[i][0] = states[i - 1][0];
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                if (arr1[i] == arr2[j])
                    states[i][j] = states[i - 1][j - 1] + 1;
                else
                    states[i][j] = Math.max( Math.max(states[i - 1][j - 1], states[i - 1][j]), states[i][j - 1] );
            }
        System.out.println("The longest length common str between " + str1 + " and " + str2 + " is: " + states[m - 1][n - 1]);
    }

    public static void getLongestCommonStr2 (String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mem[i][j] = -1;
        int result = getLCS(arr1,arr2,m-1,n-1,mem);
        System.out.println("The longest length common str between " + str1 + " and " + str2 + " is: " + result);
    }

    private static int getLCS(char[] arr1, char[] arr2, int index1, int index2, int[][] mem) {
        if (index1 == 0 && index2 == 0) {
            if (arr1[0] == arr2[0])
                mem[0][0] = 1;
            else
                mem[0][0] = 0;
            return mem[0][0];
        }
        if(mem[index1][index2] >= 0) return mem[index1][index2];
        //初始化第零行
        if (index1 == 0) {
            if(arr1[0] == arr2[index2])
                mem[0][index2] = 1;
            else
                mem[0][index2] = getLCS(arr1, arr2, 0, index2 - 1, mem);
            return mem[0][index2];
        }
        //KISS keep it simple and stupid!!!
        //初化始化零列
        if (index2 == 0) {
            if(arr1[index1] == arr2[0])
                mem[index1][0] = 1;
            else
                mem[index1][0] = getLCS(arr1, arr2, index1 - 1, 0, mem);
            return mem[index1][0];
        }

        if (arr1[index1] == arr2[index2])
            mem[index1][index2] = Math.max( Math.max(getLCS(arr1,arr2,index1 - 1 ,index2 - 1, mem) + 1, getLCS(arr1,arr2,index1 - 1 ,index2, mem)), getLCS(arr1,arr2,index1,index2 - 1, mem));
        else
            mem[index1][index2] = Math.max( Math.max(getLCS(arr1,arr2,index1 - 1 ,index2 - 1, mem), getLCS(arr1,arr2,index1 - 1 ,index2, mem)), getLCS(arr1,arr2,index1,index2 - 1, mem));
        return mem[index1][index2];
    }
}
