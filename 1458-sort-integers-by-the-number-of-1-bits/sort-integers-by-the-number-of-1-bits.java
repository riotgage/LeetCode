class Solution {
    public int[] sortByBits(int[] arr) {

        // boxed makes each element of stream an integer
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new); 

        Arrays.sort(nums, new BitComparator());  

        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}

class BitComparator implements Comparator<Integer>{

    public int weight(int num){
        int mask = 1;
        int bits = 0;

        while(num>0){
            if((num & mask)>0){
                bits++;
            }
            num = num >> 1;
        }
        return bits;
    }
    @Override
    public int compare(Integer a,Integer b){

        if(weight(a) == weight(b)){
            return a-b;
        }
        return weight(a) - weight(b);
    }
}