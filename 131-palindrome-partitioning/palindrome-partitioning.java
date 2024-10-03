class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> allPartitions = new ArrayList<>();
        findPartitions(s, 0, new ArrayList<>(), allPartitions);
        return allPartitions;
        
    }

    public void findPartitions(String s, int start,ArrayList<String> currentPartitions,List<List<String>> allPartition){

        if(start == s.length()){
            allPartition.add(new ArrayList<>(currentPartitions));
            return;
        }

        for(int i=start;i<s.length();i++){

            if(isPalindrome(s,start,i)){
                currentPartitions.add(s.substring(start,i+1));
                findPartitions(s, i+1,currentPartitions, allPartition);
                currentPartitions.remove(currentPartitions.size()-1);   
            }
        }
    }

    public boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}