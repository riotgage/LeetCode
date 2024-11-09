class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by their end time. 
        // earliest end time comes first
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int prevEnd = intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<prevEnd){
                // Conflicting appointment
                // cancel this appointment
                count++;
            }
            else{
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}