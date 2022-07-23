package Brilley.Interview;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-07-08 15:12
 */
public class TheLongestStr {
        public static void test() {
            String str = "aswqsdwqerd";
            int len = str.length();
            int right = -1;
            int lenMax = 0;
            HashSet<Character> charSet = new HashSet<>();
            StringBuffer sb = new StringBuffer();
            String resultStr="";
            for (int i = 0; i < len; i++) {
                if (i > 0) {
                    sb.deleteCharAt(0);
                    charSet.remove(str.charAt(i-1));
                }
                while (right + 1 < len && !charSet.contains(str.charAt(right + 1))) {
                    right++;
                    charSet.add(str.charAt(right));
                    sb.append(str.charAt(right));
                }
                int temp = right - i + 1;
                if (temp > lenMax) {
                    resultStr = sb.toString();
                    lenMax = temp;
                    System.out.println(lenMax);
                    System.out.println(resultStr);
                }

            }
            System.out.print(resultStr);
        }

        public static void test2() {
            Scanner sn = new Scanner(System.in);
            String str = sn.next();
            int len = str.length();
            int right = -1;
            int lenMax = 0;
            Set<Character> setChar = new HashSet<>();
            StringBuffer sb = new StringBuffer();
            String resultStr = "";
            for (int i = 0; i < len; i++) {
                if (i > 0) {
                    sb.deleteCharAt(0);
                    setChar.remove(str.charAt(i - 1));
                }
                while (right + 1 < len && !setChar.contains(str.charAt(right + 1))) {
                    right++;
                    setChar.add(str.charAt(right));
                    sb.append(str.charAt(right));
                }
                if (right - i + 1 > lenMax) {
                    lenMax = right - i + 1;
                    resultStr = sb.toString();
                }
            }
            System.out.println(resultStr);
        }
    }
