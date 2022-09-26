package Brilley.ClassicalAlgorithmsProblems;

import java.util.Scanner;

/**
 * @author Brilley
 * @date 2022/9/24
 */
public class IntegerReverse {
    public static void test1() {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        num = reverse(num);
        System.out.println("the reverse result is: " + num);

    }
    public static int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
        }
        if (x == 0) {
            return 0;
        }
        x = x * sign;
        long res = 0l;
        while (x >= 10) {
            res = res * 10 + (x % 10);
            x = x / 10;
        }
        res = res * 10 + (x % 10);
        if (sign == 1) {
            if (res > Integer.MAX_VALUE) {
                return 0;
            }
        }
        if (sign == -1) {
            if ((-1) * (res) < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) (sign * res);
    }
}
