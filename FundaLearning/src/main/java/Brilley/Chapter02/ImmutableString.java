package Brilley.Chapter02;

/**
 * @author Brilley
 * @date 2022/3/12
 */
public class ImmutableString {
    public static void strTest()
    {
        //create 3 objects;
        String s=new String("brilley");
        String s1=new String ("brilley");
        System.out.println(s);
        System.out.println(s1);

        String s2=new String("hi,yanyan");
        String s3=s2.intern();
        System.out.println(s3==s2);//one object in stack, the another one in pool
        System.out.println(s==s1);//two different objects in stack
        // pool and stack already has the string "hi,yanyan"
        String s4=new String("hi,")+new String("yanyan");//s4 in a new object in stack
        String s5=s4.intern();//the adddress in the pool
        System.out.println(s4==s5);//false
        System.out.println(s4.hashCode());
        System.out.println(s5.hashCode());
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s2.hashCode());
        System.out.println(System.identityHashCode(s4)); //in stack
        System.out.println(System.identityHashCode(s5)); //in pool
        System.out.println(System.identityHashCode(s2)); //in stack
        System.out.println(System.identityHashCode(s3)); // in pool

        String s6=new String("hi,")+new String("brilley");
        String s7=s6.intern();
        System.out.println(s6==s7);
        System.out.println(System.identityHashCode(s6));
        System.out.println(System.identityHashCode(s7));
    }
}
