package lintcode;
import java.util.*;
//recursion n queens
class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
	static boolean valid(int[] col, int row){
		for(int i=1;i<row;i++)
			if(col[i]==col[row]||row-col[row]==i-col[i]||row+col[row]==i+col[i])//don't miss up !!
				return false;
		return true;
	}
	public static int totalNQueens(int n) {
        // write your code here
    	int cnt=0;
    	int[] col=new int[n+1];
    	int row=1;
    	while(row>0){
    		col[row]++;
    		if(col[row]==n+1){
    			col[row]=0;
    			row--;
    			continue;
    		}
    		boolean ok=valid(col,row);
    		if(row==n&&ok) cnt++;
    		else if(row<n&&ok)row++;
    	}
    	return cnt;
    }
    public static void main(String[] args){
    	System.out.println(totalNQueens(8));
    }
};