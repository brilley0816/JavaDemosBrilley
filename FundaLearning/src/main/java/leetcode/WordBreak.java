package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet=new HashSet<String>(wordDict);
        int len=s.length();
        if(len==0) return false;
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&wordSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
