class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int n= prices.length;
        if(n==0) return 0;
        int[] left= new int[n];
        int[] right= new int[n];
        int min=prices[0];
        for(int i=1;i<n;i++){
            min=Math.min(min,prices[i]);
            left[i]=Math.max(left[i-1],prices[i]-min);
        }
        int max=prices[n-1];
        for(int i=n-2;i>=0;i--){
            max=Math.max(max,prices[i]);
            right[i]=Math.max(right[i+1],max-prices[i]);
        }
        int profit=0;
        for(int i=0;i<n;i++)
        profit=Math.max(profit,left[i]+right[i]);
        return profit;
    }
};