class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> letterMapping = new HashMap<>();
        List<String> ans = new ArrayList<>();
        letterMapping.put('2',"abc");
        letterMapping.put('3',"def");
        letterMapping.put('4',"ghi");
        letterMapping.put('5',"jkl");
        letterMapping.put('6',"mno");
        letterMapping.put('7',"pqrs");
        letterMapping.put('8',"tuv");
        letterMapping.put('9',"wxyz");

        getCombinations(0,digits.toCharArray(),letterMapping,ans,new StringBuilder());

        return ans;
    }

    public void getCombinations(int index,char[] digits,Map<Character,String> letterMapping,List<String> ans,StringBuilder partAns){
        if(index == digits.length){
            if(!partAns.isEmpty())
                ans.add(partAns.toString());
            return;
        }

        char c = digits[index];

        for(char letter: letterMapping.get(c).toCharArray()){
            partAns.append(letter);
            getCombinations(index+1,digits,letterMapping,ans,partAns);
            partAns.deleteCharAt(partAns.length()-1);
        }
    }
}