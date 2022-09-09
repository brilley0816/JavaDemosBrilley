package Brilley.ClassicalAlgorithmsProblems;

import cn.hutool.crypto.digest.BCrypt;

import java.util.Date;

/**
 * @author Brilley
 * @date 2022/9/5
 */
public class BCryptTest {
    public static void test1() {
        String password = "21yanyan";
        String a= BCrypt.hashpw(password, BCrypt.gensalt(10));
        System.out.println(a);
        System.out.println(a.length());
        Date createDate = new Date();
        int n = (int) createDate.getTime();
        System.out.println(BCrypt.gensalt(20));
        String temp = BCrypt.gensalt(10);
        System.out.println(temp);
        System.out.println(temp.length());
        String b= BCrypt.hashpw(password, temp);
        System.out.println(b);
        System.out.println(b.length());
    }
}
