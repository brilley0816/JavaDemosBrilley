package Brilley.ClassicalAlgorithmsProblems;

/**
 * @author Brilley
 * @date 2022/8/30
 */
public class PrimeTest {

    public static void isPrime(int n) {
        if (n == 1) {
            System.out.println(n + " is not a prime");
            return;
        }

        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                System.out.println(n + " is not a prime");
                return;
            }
        }
        System.out.println(n + " is a prime");
    }

    public static void allPrimes(int n) {
        System.out.print(n + " = ");
        if (n == 1) {
            System.out.println(n);
        }

        for (int i = 2; i <= n / i; i++) {
            int count = 0;
            boolean flag = false;
            while (n % i == 0) {
                count ++;
                flag = true;
                n = n / i;
            }
            if (flag) {
                System.out.print(i);
                if (count > 1) {
                    System.out.print("^" + count);
                }
                if (n != 1) {
                    System.out.print("*");
                }
            }
        }
        //
        if (n != 1) {
            System.out.print(n);
        }
    }

}
