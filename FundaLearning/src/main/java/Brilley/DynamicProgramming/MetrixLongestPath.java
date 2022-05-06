package Brilley.DynamicProgramming;

/**
 * @author Brilley
 * @date 2022/5/6
 */
public class MetrixLongestPath {
    private static int[][] metrix = new int[][] {{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private static int m = 4;
    private static int n = 4;
    private static int[][] mem = new int[m][n];
    private static int[][] states = new int[m][n];

    public static void findLongestPath() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += metrix[0][i];
            states[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < m; i++) {
            sum +=  metrix[i][0];
            states[i][0] = sum;
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                states[i][j] = metrix[i][j] + Math.max(states[i - 1][j], states[i][j - 1]);
        System.out.println("Longest path: " +states[3][3]);
    }

    public static int findLongestPath2(int row, int column) {
        if (row == 0 && column == 0)
            return metrix[0][0];
        if (mem[row][column] != 0)
            return mem[row][column];
        int up = Integer.MIN_VALUE;
        if (row > 0)
            up = findLongestPath2(row - 1 ,column);
        int left = Integer.MIN_VALUE;
        if (column > 0)
            left = findLongestPath2(row, column - 1);
        int dist = 0;
        dist = metrix[row][column] + Math.max(up, left);
        mem[row][column] = dist;
        return dist;
    }
}
