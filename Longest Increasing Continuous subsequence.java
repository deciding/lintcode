//1D DP, since similar to 1D max sum
public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        int count=1,ans=0;
        boolean flag;
        if(A.length==0) return 0;
        if(A.length==1) return 1;
        flag=A[0]<A[1];
        for(int i=0;i<A.length-1;i++){
            if(flag&&A[i]<=A[i+1]) count++;
            else if(!flag&&A[i]>=A[i+1]) count++;
            else {
                ans=Math.max(ans,count);
                flag=A[i]<A[i+1];
                count=2;
            }
        }
        return ans=Math.max(ans,count);
    }
}
