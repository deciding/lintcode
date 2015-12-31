package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
	public long fac(int n){
		long ans=1;
		for(int i=2;i<=n;i++)
			ans*=i;
		return ans;
	}
	public long permutationWithRepeatedNumbers(HashMap<Integer,Integer> hm){
		long repeater=1;
		int sum=0;
		for(int val:hm.values())
			if(val!=0){
				repeater*=fac(val);//repeat counts
				sum+=val;
			}
		return fac(sum)/repeater;
	}
	public void preprocess(HashMap<Integer,Integer> hm, int[] A){
		for(int i=0;i<A.length;i++)
			if(!hm.containsKey(A[i]))
				hm.put(A[i], 1);
			else hm.put(A[i], hm.get(A[i])+1);
	}
    public long permutationIndexII(int[] A) {
        // Write your code here
    	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    	preprocess(hm,A);
    	long ans=0;
    	for(int i=0;i<A.length;i++){
    		HashSet<Integer> smaller=new HashSet<Integer>();
    		for(int j=i+1;j<A.length;j++)
    			if(!smaller.contains(A[j])&&A[j]<A[i]){
    				smaller.add(A[j]);
    				hm.put(A[j], hm.get(A[j])-1);
    				ans+=permutationWithRepeatedNumbers(hm);
    				hm.put(A[j], hm.get(A[j])+1);
    			}
    		hm.put(A[i], hm.get(A[i])-1);
    	}
    	return ans+1;//plus self
    }
}