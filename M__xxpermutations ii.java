import java.util.*;
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
	public static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer>perm, ArrayList<Integer> nums, boolean[] used){
		if(perm.size()==nums.size()){
			ans.add((ArrayList<Integer>)perm.clone());
			return;
		}
		for(int i=0;i<nums.size();i++){
			if(used[i]||(i>0&&nums.get(i)==nums.get(i-1)&&!used[i-1])) continue;
			used[i]=true;
			perm.add(nums.get(i));
			helper(ans,perm,nums,used);
			used[i]=false;
			perm.remove(perm.size()-1);
		}
	}
	public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
		if(nums==null||nums.size()==0) return ans;
		ArrayList<Integer> perm=new ArrayList<Integer>();
		boolean[] used= new boolean[nums.size()];
		Collections.sort(nums);
		helper(ans,perm,nums,used);
		return ans;
	}
    public static void main(String[] args){
    	ArrayList<Integer> nums=new ArrayList<Integer>(Arrays.asList(1,2,2));
    	System.out.println(permute(nums));
    }
}
