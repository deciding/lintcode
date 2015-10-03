//just enumerate all the cases!!
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
		boolean inserted=false;
		if(intervals.size()==0){
			intervals.add(0,newInterval);
			return intervals;
		}
			
		for(int i=0;i<intervals.size();i++){
			Interval cur=intervals.get(i);
			if(cur.start<=newInterval.start&&cur.end>=newInterval.start&&cur.end<=newInterval.end){
				cur.end=newInterval.end;
				newInterval=cur;// like a pointer
				inserted=true;
			}
			else if(cur.start<=newInterval.end&&cur.end>=newInterval.end&&cur.start>=newInterval.start){
				
				if(inserted){
					newInterval.end=cur.end;
					intervals.remove(i);
				}
				else {
					cur.start=newInterval.start;
					newInterval=cur;
					inserted=true;
				}
			}
			else if(cur.start<newInterval.start&&cur.end>newInterval.end){
				return intervals;
			}
			else if(cur.start>newInterval.start&&cur.end<newInterval.end){
				if(inserted){
					intervals.remove(i);
					i--;
				}
				else{
					cur.start=newInterval.start;
					cur.end=newInterval.end;
					newInterval=cur;
					inserted=true;
				}
			}
			else if(cur.end<newInterval.start&&i+1==intervals.size()||
					cur.start>newInterval.end&&i==0||
					cur.end<newInterval.start&&intervals.get(i+1).start>newInterval.end){
				if(cur.start>newInterval.end&&i==0)
					intervals.add(i,newInterval);
				else intervals.add(i+1,newInterval);
				return intervals;
			}
		}
		return intervals;
		
	}
}
