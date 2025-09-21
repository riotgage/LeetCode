class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int index =-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index = i;
                System.out.println(index);
                break;
            }
        }

        if(index == -1){
            nums = reverse(nums,0,n-1);
            print(nums,n);
            return;
        }

        for(int i=n-1;i>=index;i--){
            if(nums[i]>nums[index]){
                int temp = nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                break;
            }
        }
        reverse(nums,index+1,n-1);
        print(nums,n);
    }

    static void print(int a[],int len){
        for(int i=0;i<len-1;i++){
            System.out.print(a[i]+" ");
        }
        System.out.print(a[len-1]);
    }

    static int[] reverse(int arr[], int start, int end) 
    { 
        int i, k, t; 
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}