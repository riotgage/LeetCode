class Solution {
    public String[] findWords(String[] words) {
        
        //  return Arrays.stream(words)
        //         .filter(word -> word.toLowerCase().matches("[qwertyuiop]*") ||
        //                         word.toLowerCase().matches("[asdfghjkl]*") ||
        //                         word.toLowerCase().matches("[zxcvbnm]*"))
        //         .toArray(String[]::new);

        Set<Character> row1 = Set.of('q','w','e','r','t','y','u','i','o','p');
        Set<Character> row2 = Set.of('a','s','d','f','g','h','j','k','l');
        Set<Character> row3 = Set.of('z','x','c','v','b','n','m');

        List<String> result = new ArrayList<>();

        for(String wording: words){
            String word = wording.toLowerCase();
            Set<Character> targetRow = null;
            char firstChar = word.charAt(0);

            if(row1.contains(firstChar)){
                targetRow = row1;
            }else if(row2.contains(firstChar)){
                targetRow = row2;
            }else{
                targetRow = row3;
            }

            boolean isValid = true;
            for (char c : word.toCharArray()) {
                if (!targetRow.contains(c)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(wording);
            }
        }

        return result.toArray(new String[0]);
    }
}