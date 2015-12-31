import java.util.*;
//key point : p=(k-1)/(n-1)!->nums[p]

class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @returnaeturn the k-th permutation
      */
    public String getPermutation(int n, int k) {
    	StringBuilder sb=new StringBuilder();
        k--;
        int fac=1;
        //preprocess()
        for(int i=1;i<n;i++) fac*=i;
        
        boolean[] used=new boolean[n];
        for(int i=0;i<n;i++){
        	int p=k/fac;
        	k%=fac;
        	for(int j=0;j<n;j++)
        		if(!used[j]){
        			if(p==0) {
        				used[j]=true;
        				sb.append(j+1);
        				break;
        			}
        			else p--;
        		}
        	fac/=i!=n-1?(n-1-i):1;
        }
        return sb.toString();
    }
}
