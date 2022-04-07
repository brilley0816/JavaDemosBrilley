package Brilley.DynamicProgramming;

public class MaximumGold {
    private static int count;
    public static void test1(){
        int nums=5;
        int w=10;
        int[] p=new int[]{5,5,3,2,2};
        int[] gold=new int[]{500,400,200,300,350};
        int res=findMaximunGold(nums,w,p,gold);
        System.out.println("the maximum gold is "+res);
        System.out.println(count);
    }

    public static void test2(){
        count=0;
        int nums=5;
        int w=10;
        int[] p=new int[]{5,5,3,2,2};
        int[] gold=new int[]{500,400,200,300,350};
        int res=findMaximunGold_2(nums,w,p,gold);
        System.out.println("the maximum gold is "+res);
        System.out.println(count);

    }
    public static void test3(){
        count=0;
        int nums=5;
        int w=10;
        int[] p=new int[]{5,5,3,2,2};
        int[] gold=new int[]{500,400,200,300,350};
        int res=findMaximunGold_3(nums,w,p,gold);
        System.out.println("the maximum gold is "+res);
        System.out.println(count);

    }
    private static int findMaximunGold(int nums, int w, int[] p, int[] gold){
        count++;
        if(nums==0)
            return 0;
        else{
            if(w<p[nums-1]) return findMaximunGold(nums-1,w,p,gold);
            else return Math.max(findMaximunGold(nums-1,w,p,gold),findMaximunGold(nums-1,w-p[nums-1],p,gold)+gold[nums-1]);
        }
    }

    private static int findMaximunGold_2(int nums, int w, int[] p, int[] gold){
        count++;
        int[][] funcArr=new int[nums+1][w+1];
        for(int i=0;i<=nums;i++)
            for(int j=0;j<=w;j++){
                funcArr[i][j]=0;
            }

        for(int i=0;i<=nums;i++)
            for(int j=0;j<=w;j++){
                if(i==0) {
                    funcArr[i][j] = 0;
                }
                else if(p[i-1]>j)
                    funcArr[i][j]=funcArr[i-1][j];
                else
                    funcArr[i][j]=Math.max(funcArr[i-1][j],funcArr[i-1][j-p[i-1]]+gold[i-1]);
            }
        return funcArr[nums][w];
    }

    private static int findMaximunGold_3(int nums, int w, int[] p, int[] gold){
        count++;
        int[] funcArr=new int[w+1];
        for(int j=0;j<=w;j++){
                funcArr[j]=0;
            }

        //每一行需要从右到左搜索，为什么？不能先更新每一行的小坐标，因为大坐标要用！
        for(int i=1;i<=nums;i++)
            for(int j=w;j>=1;j--){
                if(p[i-1]<=j)
                    funcArr[j]=Math.max(funcArr[j],funcArr[j-p[i-1]]+gold[i-1]);
            }
        return funcArr[w];
    }
}
