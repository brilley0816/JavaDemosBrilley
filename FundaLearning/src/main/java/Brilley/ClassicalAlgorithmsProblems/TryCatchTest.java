package Brilley.ClassicalAlgorithmsProblems;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-09-22 12:24
 */
public class TryCatchTest {
    public static StringBuffer o = new StringBuffer();
    TryCatchTest(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            o.append("3");
        } finally {
            o.append("0");
        }
        o.append("2");
    }
    public static void test1() {
        TryCatchTest o1 = new TryCatchTest(2);
        TryCatchTest o2 = new TryCatchTest(1);
        System.out.println(o.toString());
    }
}
