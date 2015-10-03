//14
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
     //find left first to get first occurence
     //1. in array range
     //2. infinite loop
     //3. first ocurrence
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int end= nums.length-1;
        int start=0;
        int mid=end/2;
        int pos;
        while(end-start>1){
            if(nums[mid]==target) {
                end=mid;
                mid=(end+start)/2;
            }
            else if(nums[mid]<target) {
                start=mid;
                mid=(end+start)/2;
            }
            else if(nums[mid]>target) {
                end=mid;
                mid=(end+start)/2;
            }
        }
        if(end-start==1&&nums[start]==target) pos=start;
        else if(end-start==1&&nums[end]==target) pos=end;
        else if(end-start==0&&nums[start]==target) pos=start;
        else pos=-1;
        return pos;
    }
}
