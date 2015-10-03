public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        int m=matrix.length;
        int n=matrix[0].length;
        int[] result = new int[m*n];
        boolean zig=true;
        int i=0;
        int j=0;
        int cur=0;
        while(i<m&&j<n){
            if(zig&&j+1<n&&i==0) {
                result[cur++]=matrix[i][j++];
                zig=false;
            }
            else if(!zig&&i+1<m&&j==0){
                result[cur++]=matrix[i++][j];
                zig=true;
            }
            else if(zig&&j==n-1){
                result[cur++]=matrix[i++][j];
                zig=false;
            }
            else if(!zig&&i==m-1){
                result[cur++]=matrix[i][j++];
                zig=true;
            }
            else if(zig){
                result[cur++]=matrix[i--][j++];
            }
            else if(!zig){
                result[cur++]=matrix[i++][j--];
            }
        }
        return result;
    }
}
