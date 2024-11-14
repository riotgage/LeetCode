class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] ans = new int[k];

        Map<Integer,Integer> freq = new HashMap<>();

        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }


        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll().num;  // Get the number with the highest frequency
        }
        return ans;
    }
}

class Pair{

    int num;
    int freq;

    Pair(int num,int freq){
        this.num=num;
        this.freq=freq;
    }
}