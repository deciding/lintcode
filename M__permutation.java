import java.util.*;
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
//    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
//        // write your code here
//      ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
//      if(nums==null||nums.size()==0) return ans;
//      ArrayList<Integer> perm=new ArrayList<Integer>();
//      
//      int n=nums.size();
//      int i=1;
//      int[] pos=new int[n+1];
//      boolean[] used=new boolean[n+1];
//      while(i>0){
//          pos[i]++;
//          if(pos[i]==n+1){
//              pos[i]=0;
//              if(i!=1)perm.remove(perm.size()-1);
//              i--;
//              used[pos[i]]=false;
//          }
//          else if(i==n&&!used[pos[i]]) {
//              //used[pos[i]]=true;
//              perm.add(nums.get(pos[i]-1));
//              ans.add((ArrayList<Integer>) perm.clone());
//              perm.remove(perm.size()-1);
//          }
//          else if(!used[pos[i]]) {
//                  used[pos[i]]=true;
//                  perm.add(nums.get(pos[i]-1));
//                  i++;
//          }
//      }
//      return ans;
//    }
    public static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer>perm, ArrayList<Integer> nums){
        if(perm.size()==nums.size()){
            ans.add((ArrayList<Integer>)perm.clone());
            return;
        }
        for(int i=0;i<nums.size();i++)
            if(!perm.contains(nums.get(i))){
                perm.add(nums.get(i));
                helper(ans,perm,nums);
                perm.remove(perm.size()-1);
            }
    }
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        if(nums==null||nums.size()==0) return ans;
        ArrayList<Integer> perm=new ArrayList<Integer>();
        helper(ans,perm,nums);
        return ans;
    }
    public static void main(String[] args){
        ArrayList<Integer> nums=new ArrayList<Integer>(Arrays.asList(1,2,3));
        System.out.println(permute(nums));
    }
}
