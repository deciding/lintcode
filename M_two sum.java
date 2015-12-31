import java.util.*;

//two pointers, just like liangtoujia algo
//hashmap is better, because we want index result
public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
    	HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
    	for(int i=0;i<numbers.length;i++)
    		hm.put(numbers[i], i);
    	for(int i=0;i<numbers.length;i++){
    		int key=target-numbers[i];
    		if(hm.containsKey(key)&&hm.get(key)!=i)
    			return new int[]{i+1,hm.get(key)+1};
    	}
    	return new int[]{};
    }
}