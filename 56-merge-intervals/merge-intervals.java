class Solution {
    public int[][] merge(int[][] arr) {
        
        // sort the array based on first element 
        Arrays.sort(arr, new Comparator<int []>(){
            public int compare(int a[], int b[]){
                return a[0]-b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(arr[0][0], arr[0][1]));

        for (int i = 1; i < arr.length; i++) {

            if (arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            // if the current interval
            // lies in the last interval:
            else {
                ans.get(ans.size() - 1).set(1,
                                            Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }

        int [][] a = new int[ans.size()][2];

        for(int i=0;i<ans.size();i++){
            
            a[i][0] = ans.get(i).get(0);
            a[i][1] = ans.get(i).get(1);
        }

        return a;
    }
}