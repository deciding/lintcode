import java.util.*;

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public static void rotate(int[][] matrix) {
        // write your code here
    	if(matrix==null||matrix.length==0) return;
    	int m=matrix.length-1;
    	for(int i=0;i<matrix.length/2;i++)
    		for(int j=0;j<(matrix[0].length+1)/2;j++){
    			int tmp=matrix[i][j];
    			matrix[i][j]=matrix[m-j][i];
    			matrix[m-j][i]=matrix[m-i][m-j];
    			matrix[m-i][m-j]=matrix[j][m-i];
    			matrix[j][m-i]=tmp;
    		}
    }
    public static void main(String[] args){
    	int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    	rotate(matrix);
    	System.out.println(Arrays.deepToString(matrix));
    }
}