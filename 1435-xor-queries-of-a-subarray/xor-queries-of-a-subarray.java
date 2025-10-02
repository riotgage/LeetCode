class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int n = arr.length;
        int prefix[] = new int[n+1];

        // exclusive prefix
        // prefix[i]=arr[0]^arr[1]^.....arr[i-1];
        prefix[0]=0;

        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]^arr[i-1];
        }

        int m = queries.length;

        int[]result = new int[m];

         for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = prefix[r + 1] ^ prefix[l];
        }
        
        return result;
    }
}