package Brilley.stringRelated;
import java.util.*;

/**
 * @author Brilley
 * @date 2022/4/11
 */

public class EncodeString {
    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        String str = scanner.next();
//         String key = "nihao";
//         String str = "ni";
        String characTable = "abcdefghijklmnopqrstuvwxyz";
        //System.out.println(characTable.length());
        Map<Character,Character> characMap = new HashMap<>();
        Map<Character,Character> tempMap = new HashMap<>();
        for (int i = 0; i < 26; i++ )
        {
            int j=0;
            while (j < key.length()) {
                if ( !characMap.containsKey( key.charAt(j) ) ) {
                    characMap.put( key.charAt(j), characTable.charAt(i) );
                    tempMap.put(  characTable.charAt(i),  key.charAt(j) );
                    i++;
                }
                j++;
            }

            j=0;
            while (j<characTable.length()) {
                if ( !characMap.containsKey( characTable.charAt(j) ) ) {
                    characMap.put( characTable.charAt(j), characTable.charAt(i) );
                    tempMap.put(  characTable.charAt(i),  characTable.charAt(j) );
                    i++;
                }
                j++;
            }

        }
        char[] resultChar = new char[str.length()];
        for( int i = 0; i < str.length(); i++) {
            resultChar[i] = tempMap.get(str.charAt(i));
        }
        String resultStr = new String(resultChar);
        System.out.println(resultStr);
    }

    public static void test2() {
        Scanner scanner = new Scanner(System.in);
        String characTable = "abcdefghijklmnopqrstuvwxyz";
        while (scanner.hasNext()) {
            String key = scanner.nextLine();
            String str = scanner.nextLine();
            System.out.println(key);
            System.out.println(str);
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            int i;
            for (i = 0; i < key.length(); i++){
                set.add(key.charAt(i));
            }
            i = 0;
            while (i < 26) {
                char c = characTable.charAt(i);
                set.add(c);
                i++;
            }

            LinkedList<Character> list = new LinkedList<>(set);
            System.out.println(list);
            StringBuffer resultStr = new StringBuffer();
            for( i = 0; i < str.length(); i++) {
                int num = str.charAt(i)-'a';
                resultStr.append(list.get(num));
            }
            System.out.println(resultStr);
        }

    }
}
