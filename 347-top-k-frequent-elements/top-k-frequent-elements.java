class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] ans = new int[k];

        Map<Integer,Integer> freq = new HashMap<>();

        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }


        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(freq.entrySet());

        entryList.sort((a,b)->b.getValue()-a.getValue());

        for(int i=0;i<k;i++){
            ans[i]=entryList.get(i).getKey();
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