class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;

        int color[] = new int[n];  // this will act as the visited array
        Arrays.fill(color,-1);

        for(int i=0; i<n; i++){
            if(color[i]==-1){
                if(bfs(graph,i,color)==false) return false;
            }
        }
        return true;
    }

    static boolean bfs(int arr[][], int src, int color[]){
        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;

        while(q.size()!=0){
            int a = q.remove();
            int col = color[a];

            for(int x : arr[a]){
                if(color[x]==-1){
                    color[x] = (col==1) ? 0 : 1;
                    q.add(x);
                }else{
                    if(color[x]==col) return false;
                }
            }
        }
        return true;
    }
}