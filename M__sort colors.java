class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void swap(int[] nums, int i, int j){
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}
    public void sortColors(int[] nums) {
        // write your code here
    	int l=0,r=nums.length-1;
    	int i=0;
    	while(i<=r){
    		if(nums[i]==0){
    			swap(nums,i,l);
    			i++;
    			l++;
    		}
    		else if(nums[i]==1) i++;
    		else {
    			swap(nums,i,r);
    			r--;
    		}
    	}
    }
}