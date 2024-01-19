/**
  Problem Date: 19/01/24
  Problem Name: Water the plants
  Problem Link: https://www.geeksforgeeks.org/problems/water-the-plants--170646/1
  Problem Category: Array, Searching, Sorting
    
*/



//User function Template for Java

class Solution {
    public int min_sprinklers(int[] gallery, int n) {
        int[][] range = new int[n][2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (gallery[i] != -1) {
                int left = Math.max(0, i - gallery[i]);
                int right = Math.min(n - 1, i + gallery[i]);
                range[index][0] = left;
                range[index][1] = right;
                index++;
            }
        }
        range = Arrays.copyOfRange(range, 0, index);
        Arrays.sort(range, (a, b) -> Integer.compare(a[0], b[0]));
        int start = 0, ans = 0, end = 0, i = 0;
        while (start <= n - 1) {
            end = Integer.MIN_VALUE;
            while (i < index && range[i][0] <= start) {
                end = Math.max(end, range[i][1]);
                i++;
            }
            if (end == Integer.MIN_VALUE)
                return -1;
            ans++;
            start = end + 1;
        }
        return ans;
    }
}