package Brilley.ClassicalAlgorithmsProblems;

/**
 * @author Brilley
 * @date 2022/4/4
 */
public class CommonDivisor {
    public static int getGreatestCommonDivisorV1(int a,int b){
        int big=a>b? a:b;
        int small=a>b? b:a;
        if(big%small==0)
            return small;
        for(int i=small/2;i>1;i--){
            if(big%i==0 && small%i==0)
                return i;
        }
        return 1;
    }

    public static int getGreatestCommonDivisorV2(int a,int b){
        int big=a>b? a:b;
        int small=a>b? b:a;
        if(big%small==0)
            return small;
        return getGreatestCommonDivisorV2(small,big%small);
    }

    public static int getGreatestCommonDivisorV3(int a,int b){
        int big=a>b? a:b;
        int small=a>b? b:a;
        if(big%small==0)
            return small;
        return getGreatestCommonDivisorV2(small,big-small);
    }

    public static int getGreatestCommonDivisorV4(int a,int b){
        if(a==b){
            return a;
        }
        if((a&1)==0 && (b&1)==0)
            return getGreatestCommonDivisorV4(a>>1,b>>1)<<1;
        else if((a&1)==0 && (b&1)!=0)
            return getGreatestCommonDivisorV4(a>>1,b);
        else if((a&1)!=0 && (b&1)==0)
            return getGreatestCommonDivisorV4(a,b>>1);
        else{
            int big=a>b? a:b;
            int small=a>b? b:a;
            if(big%small==0)
                return small;
            return getGreatestCommonDivisorV2(small,big-small);
        }
    }
}
