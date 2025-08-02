class Solution {
    public void rotate(int[] nums, int k) {
        
        // rotate to right by k
        // reverse rightmost k element
        // then reverse remaining n-k elements
        // then reverse the entire array
        int len=nums.length;
        
        if(len==1)return;
        
        if(k>len)k=k%len;

        reverse(nums,len-k,len-1);
        reverse(nums,0,len-k-1);
        reverse(nums,0,len-1);
    }

    public void reverse(int[] arr, int start, int end){

        while(start<=end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }
}