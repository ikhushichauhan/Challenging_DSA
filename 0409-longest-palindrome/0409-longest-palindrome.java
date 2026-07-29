class Solution {
    public int longestPalindrome(String s) {
        int[] charCounts = new int[128];
        
        for (char c : s.toCharArray()) {
            charCounts[c]++;
        }
        
        int maxLength = 0;
        boolean hasOddCount = false;
        
        for (int count : charCounts) {
            maxLength += (count / 2) * 2;
            
            if (count % 2 != 0) {
                hasOddCount = true;
            }
        }
        
        return hasOddCount ? maxLength + 1 : maxLength;
    }
}
