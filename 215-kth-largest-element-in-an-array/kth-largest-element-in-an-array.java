class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer>pQueue=new PriorityQueue<>();

        for(int i:nums){
            pQueue.add(i);
        }

        for(int i=0;i<nums.length-k;i++){
            pQueue.poll();
        }

        return pQueue.peek();
    }
}