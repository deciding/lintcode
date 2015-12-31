package lintcode;
import java.util.*;
// O(N) time, O(1) space !!
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
	public static int firstMissingPositive(int[] A) {
        // write your code here
        for(int i=0;i<A.length;i++)
        while(A[i]>0&&A[i]<=A.length&&i+1!=A[i]&&A[i]!=A[A[i]-1]){
            int tmp=A[i];
            A[i]=A[tmp-1];
            A[tmp-1]=tmp;
        }
        for(int i=0;i<A.length;i++)
        if(i+1!=A[i]) return i+1;
        return A.length+1;
    }
	public static void main(String[] args){
		firstMissingPositive(new int[]{2,1});
	}
}
