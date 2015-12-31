package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int find(int[] num,int a, int b) {
        if(a==b) return num[a];
        if(a+1==b) return Math.min(num[a],num[b]);
        int mid=(a+b)/2;
        if(num[mid]<num[b]) return find(num,a,mid);
        else if(num[mid]>num[b]) return find(num,mid,b);
        else return Math.min(find(num,a,mid),find(num,mid,b));
    }
    public int findMin(int[] num){
        // write your code here
        return find(num,0,num.length-1);
    }
}