class Solution {
    public int maxProduct(int[] arr) {
        int max_prod=arr[0];
        int min_prod=arr[0];
        int result=arr[0];

        for(int i=1;i<arr.length;i++){

            int temp=Math.max(arr[i],Math.max(arr[i]*max_prod, arr[i]*min_prod));

            min_prod=Math.min(arr[i]*max_prod,Math.min(arr[i], arr[i]*min_prod));
           
            max_prod=temp;
            result=Math.max(result,max_prod);
        }

        return result;
    }
}