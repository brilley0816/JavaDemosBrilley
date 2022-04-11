package Brilley.ClassicalAlgorithmsProblems;

import java.util.Scanner;

/**
 * @author Brilley
 * @date 2022/4/11
 */
public class RemoveKDigits {
    public static void test1(){
        System.out.println("请输入一个数字，和要删除的位数：例如 1234 2");
        Scanner scanner=new Scanner((System.in));
        String numsStr=scanner.next();
        String kStr=scanner.next();
        System.out.println(numsStr);
        System.out.println(kStr);
        int result;
        int nums=Integer.valueOf(numsStr);
        int k=Integer.valueOf(kStr);
        if(k>=numsStr.length())
        {
            result=0;
            System.out.println("result: "+result);
            return;
        }


        String temp="";

        for(int i=0;i<numsStr.length()-1;i++){
            if(numsStr.charAt(i)>numsStr.charAt(i+1))
            {
                if(k>0)
                {
                    numsStr=numsStr.substring(0,i)+numsStr.substring(i+1,numsStr.length());
                    k--;
                    i=0;//有没有什么可以优化的地方！可以记录删除的位置，下一次从这个位置的前一个位置找！可以用栈来存结果！
                }

            }
        }
        System.out.println(temp);
        while(k>0 && numsStr.length()!=0){
            numsStr=numsStr.substring(0,numsStr.length()-1);
            k--;
        }
        if(numsStr=="")
        {
            result=0;
            System.out.println("result: "+result);
            return;
        }
        result=Integer.valueOf(numsStr);
        System.out.println("result: "+numsStr);
    }

    public static void test2(){
        System.out.println("请输入一个数字，和要删除的位数：例如 1234 2");
        Scanner scanner=new Scanner((System.in));
        String numsStr=scanner.next();
        String kStr=scanner.next();
        int result;
        char[] charArr=new char[numsStr.length()];
        int k=Integer.valueOf(kStr);
        if(k>=numsStr.length())
        {
            result=0;
            System.out.println("result: "+result);
            return;
        }
        charArr[0]=numsStr.charAt(0);
        int top=1;
        for(int i=1;i<numsStr.length();i++){
            if(charArr[top-1]>numsStr.charAt(i) && k>0){
                if(top>0)
                    top--;
                k--;
                continue;
            }
            charArr[top++]=numsStr.charAt(i);
        }
        top=k>0? Math.max(0,top-k):top;
        String temp=new String(charArr,0,top);
        result=Integer.valueOf(temp);
        System.out.println("result: "+result);
    }
}
