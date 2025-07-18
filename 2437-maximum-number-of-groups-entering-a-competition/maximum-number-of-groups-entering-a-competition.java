class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        return (int)(Math.sqrt(2.0 * n + 0.25) - 0.5);
    }
}