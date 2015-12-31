//don't care order, O(N)
public int removeElement(int[] A, int elem) {
        int i = 0;
        int pointer = A.length - 1;
        while(i <= pointer){
            if(A[i] == elem){
                A[i] = A[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }

//care order, two pointers, O(N)
public int removeElement(int[] A, int elem) {
        // write your code here
        int walker=0,runner=0;
        while(runner<A.length){
        while(walker<A.length&&A[walker]!=elem) walker++;
        if(runner<=walker)
            runner=walker+1;
        while(runner<A.length&&A[runner]==elem){
            runner++;
        }
        if(runner<A.length){
            int temp=A[walker];
            A[walker]=A[runner];
            A[runner]=temp;
            walker++;
            runner++;
        }
        }
        return walker;
    }