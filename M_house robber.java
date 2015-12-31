package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        long[] mem= new long[3];
        if(A.length==0) return 0;
        if(A.length>0)
        mem[0]=A[0];
        if(A.length>1)
        mem[1]=A[1]>A[0]?A[1]:A[0];
        if(A.length>2)
        mem[2]=(A[0]+A[2])>A[1]?A[0]+A[2]:A[1];
        for(int i=3;i<A.length;i++)
        mem[i%3]=Math.max(mem[(i-1)%3],Math.max(mem[(i-2)%3]+A[i],mem[(i-3)%3]+A[i]));
        return mem[(A.length-1)%3];
    }
}