class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int i = 0, j = n - 1;

        while (i < n && directions.charAt(i) == 'L') i++;
        while (j >= 0 && directions.charAt(j) == 'R') j--;

        int ans = 0;
        for (int k = i; k <= j; k++) {
            if (directions.charAt(k) != 'S') ans++;
        }
        return ans;
    }
}
