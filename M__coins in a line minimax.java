package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean minimax(int[] mem, int n){
        if(mem[n]!=0) return mem[n]==1?true:false;
        if(n==0) return false;
        if(n==1) return true;
        if(n==2) return true;
        if(n==3) return false;
        boolean ans=(minimax(mem,n-2)&&minimax(mem,n-3))||(minimax(mem,n-3)&&minimax(mem,n-4));
        mem[n]=ans?1:2;
        return ans;
    }
    public boolean firstWillWin(int n) {
        // write your code here
        int[] mem= new int[n+1];
        return minimax(mem,n);
    }
    
}