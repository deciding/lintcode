import java.util.*;
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> item, ArrayList<Integer> nums, int index){
    	ans.add(new ArrayList<Integer>(item));
    	if(index==nums.size()) return;
    	for(int i=index;i<nums.size();i++){
    		if(i!=index&&nums.get(i)==nums.get(i-1)) continue;
    		item.add(nums.get(i));
    		helper(ans,item,nums,i+1);
    		item.remove(item.size()-1);
    	}
    }
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
    	Collections.sort(S);
    	ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> item=new ArrayList<Integer>();
    	helper(ans,item,S,0);
    	return ans;
    }
    public static void main(String[] args){
    	System.out.println(subsetsWithDup(new ArrayList<Integer>(Arrays.asList(1,2,2))));
    }
}
