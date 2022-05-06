package Brilley.BackTracking;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-05-06 19:41
 */
public class KnapsackPro {
    public static int wMax = Integer.MIN_VALUE;
    private static int[] weight = {2,4,4,5,3};
    private static int n = 5;
    private static int w = 10;
    public static int nums = 0;
    public static int[][] mem= new int[n][w];
    public static void findMaxWeight1(int i, int cw) { //findMaxWeight(0,0);
        if (i == n) {
            if (cw <= w) {
                if (cw > wMax) wMax = cw;
                nums ++;
                return;
            }
            else return;
        }
//        if (i ==n || cw == w) {
//            if (cw > wMax) wMax =cw;
//            nums++;
//            return;
//        }
        //不装第i个物品
        findMaxWeight1(i+1,cw);

        //装第i个物品
        if (cw + weight[i] <= w)  //这个条件可以加也可以不加，这里加了的话，终止条件不需要有else，因为cw不会超过w;
            findMaxWeight1(i+1, cw + weight[i]);

    }

    //加上备忘录，剪枝
    public static void findMaxWeight2(int i, int cw) {
        if (i == n || cw == w) {
            if (cw > wMax) wMax = cw;
            nums ++;
            return;
        }
        if (mem[i][cw] != 0) return;
        mem[i][cw] = 1;
        findMaxWeight1(i + 1, cw);
        if (cw + weight[i] < w)
            findMaxWeight1(i + 1,cw + weight[i]);
    }
}
