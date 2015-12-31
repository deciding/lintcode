package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
	
	//following is faster !
//	int result = 0;
//    while(a >= b){
//        int shift = 0;
//        while(a >= (b << shift)){
//            shift++;
//        }
//        a -= b << (shift - 1);
//        result += 1 << (shift - 1);
//    }
    public int divide(int dividend, int divisor) {
        // Write your code here
		if(dividend==0) return 0;
		if(divisor==0) return dividend>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
		if(divisor==1) return dividend;
		if(divisor==-1) {
		    if(dividend==Integer.MAX_VALUE) return Integer.MIN_VALUE;
		    if(dividend==Integer.MIN_VALUE) return Integer.MAX_VALUE;
		}
		boolean sign=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
		int ans=0;
		long x= Math.abs((long)dividend),y=Math.abs((long)divisor);
		while(x>=y){
			x-=y;
			ans++;
		}
		return sign?ans:-ans;
    }
}