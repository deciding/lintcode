public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        long factor=1;
        int pos=A.length-2;
        long index=0;
        for(;pos>=0;pos--){
            int count=0;
            for(int j=pos+1;j<A.length;j++)
                if(A[pos]>A[j]) count++;
            factor*=(A.length-1-pos);
            index+=count*factor;
        }
        return index+1;
    }
}