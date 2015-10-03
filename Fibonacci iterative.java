class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        int a=0,b=1,temp;
        if(n==1) return 0;
        if(n==2) return 1;
        while(n>2){
            temp=a;
            a=b;
            b=temp+b;
            n--;
        }
        return b;
    }
}


