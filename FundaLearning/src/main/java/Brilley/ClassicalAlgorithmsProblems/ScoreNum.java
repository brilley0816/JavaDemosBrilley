package Brilley.ClassicalAlgorithmsProblems;

import java.util.Scanner;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-04-21 11:31
 */
public class ScoreNum {
        private static int sum = 0;
        private static int N;
        public static int[] scores = {2,2,2,2,2,2,2,2,2,2,4,4,4,4,4,4,4,4,4,4,8,8,8,8,8};
        public static void test1() {
            Scanner scanner = new Scanner(System.in);
            N=scanner.nextInt();
            backTracking(0, 0, 0);
            System.out.println(sum);
        }
        public static void backTracking(int index, int score, int err){
            if (err >= 3) return;
            if (score == N) {
                sum++;
                return;
            }
            if (score > N) {
                return;
            }
            for (int i = index; i < 25; i++) {
                score += scores[i];
                backTracking(i + 1, score,err);
                score -= scores[i];
                err++;
            }
        }
}
