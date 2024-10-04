class Solution {
     
    List<String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>();

        for(String str : wordDict){
            dictionary.add(str);
        }

        List<String> words= new ArrayList<>();

        getWordsBreaks(s,0,dictionary,words);

        return ans;
    }

    public void getWordsBreaks(String s,int start,Set<String> dictionary,List<String> words){

        if(start == s.length()){
            String ansString = String.join(" ", words);
            
            ans.add(ansString);
        }

        for(int i=start;i<s.length();i++){

            if(dictionary.contains(s.substring(start,i+1))){
                words.add(s.substring(start,i+1));
                getWordsBreaks(s,i+1,dictionary,words);
                words.remove(words.size()-1);
            }
        }

    }
}