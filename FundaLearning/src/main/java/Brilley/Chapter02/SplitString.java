package Brilley.Chapter02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Brilley
 * @date 2022/3/13
 */
public class SplitString {
    public static void test1(){
        String mylove="brilley,yanyan";
        if(mylove.contains(","))
        {
            String[] parts=mylove.split(",");
            System.out.println("First part: "+parts[0]+" Second part: "+parts[1]);
        }
        else
        {
            throw new IllegalArgumentException("There is no character ','");
        }

        String mylove2="brilley.yanyan";
        if(mylove2.contains("."))
        {
            //String[] parts=mylove2.split("\\.");
            String[] parts=mylove2.split("[.]");
            System.out.println("First part: "+parts[0]+" Second part: "+parts[1]);
        }
        else
        {
            throw new IllegalArgumentException("There is no character '.'");
        }

    }

    private static Pattern twopart=Pattern.compile("\\.");

    public static void test2(){
        String[] parts=twopart.split("brilley.yanyan.forever");
        System.out.println(parts[0]+" "+parts[1]);
        parts=twopart.split("brilley.yanyan.forever",2);
        System.out.println(parts[0]+" "+parts[1]);
        String name1="brilley";
        System.out.println(name1);
        System.out.println(name1.hashCode());
        System.out.println(System.identityHashCode(name1));
        name1="yanyan";
        System.out.println(name1);
        System.out.println(name1.hashCode());
        System.out.println(System.identityHashCode(name1));
        name1="brilley";
        System.out.println(name1);
        System.out.println(name1.hashCode());
        System.out.println(System.identityHashCode(name1));
    }

    private static Pattern two=Pattern.compile("(.+)\\.(.+)");
    public static void testPattern(){
        String[] testStrs={"brilley.yanyan","briool.","cc.123"};
        for(String s:testStrs)
        {
            checkString(s);
        }

    }

    private static void checkString(String str){
        //two=Pattern.compile("(?<=\\.)");  //Pattern is not supported by this regular expression.
        Matcher m=two.matcher(str);
        if(m.matches()){
            for(int i=0;i<=m.groupCount();i++){
                System.out.print(m.group(i)+" ");
            }
            System.out.println("");
        }
        else
        {
            System.out.println("Not matching");
        }
    }

    public static void test3(){
        String mylove="brilley,yanyan";
        if(mylove.contains(","))
        {
            // String[] parts=mylove.split("(?<=,)"); //First part: brilley, Second part: yanyan
            // String[] parts=mylove.split("(?=,)");//First part: brilley Second part: ,yanyan
            // String[] parts=mylove.split("(?!,)"); //First part: b Second part: r
            String[] parts=mylove.split("(?<!,)"); //First part: b Second part: r
            System.out.println("First part: "+parts[0]+" Second part: "+parts[1]);
        }
        else
        {
            throw new IllegalArgumentException("There is no character ','");
        }
    }
}
