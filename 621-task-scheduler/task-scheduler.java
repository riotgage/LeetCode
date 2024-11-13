class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] freq = new int[26];
        int size = tasks.length;
        int count =0;
        int ans=0;

        List<Integer> temp = new ArrayList<>();

        for(char c: tasks){
            freq[c-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(freq[i]);
            }
        }

        while(!pq.isEmpty()){
            count=0;

            while(count<n+1 && !pq.isEmpty()){
                int x = pq.poll();

                x--;
                if(x>0){
                    temp.add(x);
                }
                count++;
            }

            for(int t : temp){
                pq.add(t);
            }
            temp.clear();

            if(pq.isEmpty()){
                ans+=count;
            }else{
                ans+=n+1;
            }
        }

        return ans;

    }
}