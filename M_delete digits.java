package lintcode;
import java.util.*;

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        for(int i=0;i<k;i++)
        for(int j=0;j<A.length();j++)
        if(j==A.length()-1||A.charAt(j)>A.charAt(j+1)){
            A=A.substring(0,j)+A.substring(j+1,A.length());
            break;
        }
        while(A.charAt(0)=='0') A=A.substring(1,A.length());
        return A;
    }
}