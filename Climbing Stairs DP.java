import java.util.*;
public class Solution {
	private static int[] ways;
	public static int DP(int n){
		if(n<2) return 1;
		if(ways[n]!=0) return ways[n];
		ways[n]=DP(n-1)+DP(n-2);
		return ways[n];
	}
	public static int climbStairs(int n) {
        // write your code here
		ways=new int[n+1];
		ways[0]=1;
		if(n>0)
			ways[1]=1;
		return DP(n);
    }
	
    public static void main(String args[]){
    	Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();
    	System.out.println(climbStairs(n));
    	sc.close();
    }
}