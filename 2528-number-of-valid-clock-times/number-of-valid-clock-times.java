class Solution {
    public int countTime(String time) {
        String[] timeParts = time.split(":");
        String hr = timeParts[0];
        String min = timeParts[1];
        
        int hourCombinations = getHourCombinations (hr);
        int minCombinations = getMinuteCombinations (min);

        return minCombinations * hourCombinations;
    }

    private int getHourCombinations(String h) {
        char h0 = h.charAt(0);
        char h1 = h.charAt(1);
        
        if (h0 == '?' && h1 == '?') {
            return 24; 
        } else if (h0 == '?') {
            if (h1 <= '3') return 3; 
            else return 2;           
        } else if (h1 == '?') {
            if (h0 == '2') return 4; 
            else return 10;          
        } else {
            int hour = Integer.parseInt(h);
            return hour < 24 ? 1 : 0;
        }
    }

    private int getMinuteCombinations(String m) {
        char m0 = m.charAt(0), m1 = m.charAt(1);
        if (m0 == '?' && m1 == '?') {
            return 60; // 00–59
        } else if (m0 == '?') {
            return 6; // 0-5
        } else if (m1 == '?') {
            return 10; // 0-9
        } else {
            int minute = Integer.parseInt(m);
            return minute < 60 ? 1 : 0;
        }
    }
}