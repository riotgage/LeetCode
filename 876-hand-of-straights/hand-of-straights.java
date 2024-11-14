class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize !=0){
            return false;
        }

        // get Frequency of all cards

        TreeMap<Integer,Integer> counts = new TreeMap<>();
        for(int card:hand){
            counts.put(card,counts.getOrDefault(card,0)+1);
        }


        while (!counts.isEmpty()) {
            Map.Entry<Integer, Integer> firstEntry = counts.firstEntry();
            int card = firstEntry.getKey();
            int frequency = firstEntry.getValue();

            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                if (counts.getOrDefault(currentCard, 0) <frequency) {
                    return false; 
                }
                counts.put(currentCard, counts.get(currentCard) - frequency);
                if (counts.get(currentCard) == 0) {
                    counts.remove(currentCard);
                }
            }
        }       

        return true;
    }
}