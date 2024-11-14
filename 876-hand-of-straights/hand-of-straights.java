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
        // for(int card:counts.keySet()){
        //     int freq = counts.get(card);

        //     if(freq>0){

        //         for(int i=0;i<groupSize;i++){
        //             int currentCard = card+i;

        //             if(counts.getOrDefault(currentCard,0)<=0){
        //                 System.out.println(currentCard);
        //                 return false;
        //             }
        //             counts.put(currentCard,counts.get(currentCard)-1);
        //         }
        //     }
        // }

        while (!counts.isEmpty()) {
            Map.Entry<Integer, Integer> firstEntry = counts.firstEntry();
            int card = firstEntry.getKey();
            int frequency = firstEntry.getValue();

            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                if (counts.getOrDefault(currentCard, 0) <=0) {
                    return false; 
                }
                counts.put(currentCard, counts.get(currentCard) - 1);
                if (counts.get(currentCard) == 0) {
                    counts.remove(currentCard); // Remove the card if its count goes to zero
                }
            }
        }       

        return true;
    }
}