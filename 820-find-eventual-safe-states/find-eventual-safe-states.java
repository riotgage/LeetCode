class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();

        int vertices = graph.length;
        int [] indegree = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            adjRev.add(new ArrayList<>());
        }

        for(int i=0;i<vertices;i++){
            for(int it: graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<vertices;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans.add(node);
            System.out.println(adjRev.get(node));
            for(int it: adjRev.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
        
    }
}