class Solution {
    public String minInteger(String num, int k) {
        StringBuilder minNum = new StringBuilder(num);

        getMinInteger(num.toCharArray(),k,0,minNum);

        return minNum.toString();
    }

    public void getMinInteger(char[] num, int swaps,int index,StringBuilder minNum){

        if(swaps == 0 || index == num.length){
            return;
        }

        int length = num.length;
        char minChar = num[index];
        int minIdx = index;
        for (int i = index + 1; i < length && i <= index + swaps; i++) {
            if (num[i] < minChar) {
                minChar = num[i];
                minIdx = i;
            }
        }

        if(index != minIdx){
            for(int i=minIdx;i>index;i--){
                swap(num,i,i-1);
            }
            swaps -= minIdx-index;
        }
        String currentNum = new String(num);
        if (currentNum.compareTo(minNum.toString()) < 0) {
            minNum.replace(0, minNum.length(), currentNum);
        }

        // Recur for the next index with updated k
        getMinInteger(num, swaps,index + 1 ,minNum );
        
    }

    public void swap(char[] num, int index, int i) {
        char temp = num[index];
        num[index] = num[i];
        num[i]=temp;
    }
}