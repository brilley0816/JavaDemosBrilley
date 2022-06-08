package Brilley.BackTracking;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-05-07 10:25
 */
public class LWSTDistance {
    public static int result = Integer.MAX_VALUE;
    private static int m;
    private static int n;
    private static char[] arr1;
    private static char[] arr2;
    public static void lwstDistance(String str1, String str2) {
        result = Integer.MAX_VALUE;
        int len1 = str1.length();
        int len2 = str2.length();
        char[] str1CharArr = str1.toCharArray();
        char[] str2CharArr = str2.toCharArray();
        getLWSTDT(str1CharArr, str2CharArr, len1, len2, 0, 0, 0);
        System.out.println("The lwst distance between " + str1 + " and " + str2 + " is: " + result);

    }
    private static void getLWSTDT(char[] strc1, char[] strc2, int len1, int len2, int index1, int index2, int editDT) {
        if (index1 == len1  || index2 == len2) {
//            if (editDT < 3) {
//                System.out.println("len1 " + len1);
//                System.out.println("len2 " + len2);
//                System.out.println("index1 " + index1);
//                System.out.println("index2 " + index2);
//                System.out.println(editDT);
//            }

            if (index1 < len1) editDT += len1 - index1;
            if (index2 < len2) editDT += len2 - index2;
            if (editDT < result)
                result = editDT;
            return; //一定要有一个return来结束！！！！
        }
        if (strc1[index1] == strc2[index2])
                getLWSTDT(strc1, strc2, len1, len2,index1 + 1, index2 + 1, editDT);
        else {
            getLWSTDT(strc1, strc2, len1, len2,index1 + 1, index2, editDT + 1);
            getLWSTDT(strc1, strc2, len1, len2,index1 , index2 + 1, editDT + 1);
            getLWSTDT(strc1, strc2, len1, len2,index1 + 1, index2 + 1, editDT + 1);
        }
        //System.out.println(editDT);
    }

    public static void lwstDistance2(String str1, String str2) {
        result = Integer.MAX_VALUE;
        m= str1.length();
        n= str2.length();
        arr1= str1.toCharArray();
        arr2= str2.toCharArray();
        getLWSTDT2(0, 0, 0);
        System.out.println("The lwst distance between " + str1 + " and " + str2 + " is: " + result);

    }
    private static void getLWSTDT2(int index1, int index2, int editDT) {
        if (index1 == m  || index2 == n) {
            if (index1 < m) editDT += m - index1;
            if (index2 < n) editDT += n - index2;
            if (editDT < result)
                result = editDT;
            return; //一定要有一个return来结束！！！！
        }
        if (arr1[index1] == arr2[index2])
            getLWSTDT2(index1 + 1, index2 + 1, editDT);
        else {
            getLWSTDT2(index1 + 1, index2, editDT + 1);
            getLWSTDT2(index1 , index2 + 1, editDT + 1);
            getLWSTDT2(index1 + 1, index2 + 1, editDT + 1);
        }
    }
}
