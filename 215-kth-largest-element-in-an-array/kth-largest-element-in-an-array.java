class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer>pQueue=new PriorityQueue<>(Collections.reverseOrder());

        for(int i:nums){
            pQueue.add(i);
        }

        for(int i=0;i<k-1;i++){
            pQueue.poll();
        }

        return pQueue.peek();
    }
}