package Brilley.jvm;

/**
 * @author Brilley
 * @date 2022/3/24
 */
public class ClassLoaderTest {
    public static void test1(){
        ClassLoader cl=ClassLoaderTest.class.getClassLoader();
        if(cl!=null)
        {
            System.out.println(cl);
            cl=cl.getParent();//只有AppClassLoader //sun.misc.Launcher$AppClassLoader@18b4aac2
        }
    }
}
