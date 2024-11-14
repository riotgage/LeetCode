class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap= new PriorityQueue<>();
        maxHeap= new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        
        maxHeap.add(num);

        if(maxHeap.size()>minHeap.size()+1){
            
            minHeap.add(maxHeap.poll());
        }
        if(!minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()){
            int temp = maxHeap.poll();
            maxHeap.add(minHeap.poll());
            minHeap.add(temp);
        }
    }
    
    public double findMedian() {
        
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else{
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */