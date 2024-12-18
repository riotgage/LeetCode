class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int indegree[]= new int[numCourses];

        for(int i=0;i< prerequisites.length; i++){
            // adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            adj.get(pre).add(course);
            indegree[course]++;
        }


        // for(int i=0;i<numCourses;i++){
        //    for(int it: adj.get(i)){
        //         indegree[it]++;
        //    } 
        // }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[numCourses];
        int ind = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            topo[ind++] = node;

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)q.add(it);
            }
        }

        if(ind == numCourses) return true;

        return false;

    }
}