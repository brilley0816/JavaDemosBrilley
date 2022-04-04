package Brilley.ClassicalAlgorithmsProblems;

/**
 * @author Brilley
 * @date 2022/4/4
 */
public class IsPowerOf2 {
    public static boolean isPowerOf2(int a){
        return (a&(a-1)) == 0;
    }
}
