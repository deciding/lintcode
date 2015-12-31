package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
	//we need to update the first bigger one, then add, or just add if it is bigger than all
	//following is just for non decreasing case
	//we need to get the last one if there are duplicates
	public static int binarySearch(ArrayList<Integer> nums, int key){
		if(nums.size()==0) return -1;
		int a=0,b=nums.size()-1;
		while(a+1<b){
			int mid=(a+b)/2;
			if(nums.get(mid)<=key) a=mid;
			else b=mid;
		}
		if(nums.get(b)==key) return b;
		if(nums.get(a)==key) return a;
		if(nums.get(a)>key) return a-1;
		if(nums.get(b)<key) return b;
		return a;
	}
	public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
		ArrayList<Integer> lis=new ArrayList<Integer>();
		int index;
		for(int i:nums){
		index=binarySearch(lis, i);
		if(index+1!=lis.size())
		lis.remove(index+1);
		lis.add(index+1,i);
		}
		return lis.size();
    }
    public static void main(String[] args){
    	System.out.println(longestIncreasingSubsequence(new int[]{5,4,1,2,3}));
    }
}