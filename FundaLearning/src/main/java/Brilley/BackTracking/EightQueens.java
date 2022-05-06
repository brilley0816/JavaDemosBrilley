package Brilley.BackTracking;

import java.sql.SQLOutput;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-05-06 17:19
 */
public class EightQueens {
    private static int[] results = new int[8];
    public static int nums = 0;
    public static void cal8queens(int row) {
        if (row == 8) {
            System.out.println("第 " + (nums + 1) + " 解法： ");
            queensPrint();
            nums++;
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk2(row, column)) {
                results[row] = column;
                cal8queens(row + 1);
            }
            //不满足上面的条件就不会执行，所以这里也不会有回溯的语句
            //回溯的时间复杂度很高，需要剪枝；另外再写
        }
    }

    private static boolean isOk2 (int row, int column) {
        int i = row;
        while (i > 0) {
            if (results[i - 1] == column) return false;
            i--;
        }
        //左上对角线
        i = row;
        int j = column;
        while (i > 0 && j > 0) {
            if (results[i - 1] == j -1 ) return false;
            i -- ;
            j -- ;
        }
        //右下对角线
        i = row;
        j = column;
        while (i > 0 && j + 1 < 8) {
            if (results[i - 1] == j + 1 ) return false;
            i -- ;
            j ++ ;
        }
        return true;
    }

    private static void queensPrint() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (results[i]== j) System.out.print('Q');
                else System.out.print('*');
            }
            System.out.println();
        }
    }

    private static boolean isOk(int row, int column) {// 判断 row 行 column 列放置是否合适

        int leftup = column - 1, rightup = column + 1;

        for (int i = row-1; i >= 0; --i) { // 逐行往上考察每一行

            if (results[i] == column) return false; // 第 i 行的 column 列有棋子吗？

            if (leftup >= 0) { // 考察左上对角线：第 i 行 leftup 列有棋子吗？

                if (results[i] == leftup) return false;

            }

            if (rightup < 8) { // 考察右上对角线：第 i 行 rightup 列有棋子吗？

                if (results[i] == rightup) return false;

            }

            --leftup; ++rightup;

        }

        return true;

    }
}
