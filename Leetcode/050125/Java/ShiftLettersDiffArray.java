// Problem Link: https://leetcode.com/problems/shifting-letters-ii/?envType=daily-question&envId=2025-01-05
/**
  Intuition: Difference Array Technique
This efficient algorithm helps us reduce time complexity by calculating the net effect of any changes.

The core idea of this technique is to update the range efficiently, instead of updating the entire subarray.

General Approach for Range Update:
if the range is [i,j]
1. Increment the value at the index i, start of the range. (To mark the beginning of the effect)
2. Decrement the value at the index (j+1). (To mark the end of the impact)

Use cases:
When you have to implement some range operation in an array.

 */

class Solution {

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffArray = new int[n]; 

        // Process each shift operation
        for (int[] shift : shifts) {
            if (shift[2] == 1) { // If direction is forward (1)
                diffArray[shift[0]]++; // Increment at the start index
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]--; // Decrement at the end+1 index
                }
            } else { // If direction is backward (0)
                diffArray[shift[0]]--; // Decrement at the start index
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]++; // Increment at the end+1 index
                }
            }
        }

        StringBuilder result = new StringBuilder(s);
        int numberOfShifts = 0;

        // Apply the shifts to the string
        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + diffArray[i]) % 26; // Update cumulative shifts, keeping within the alphabet range
            if (numberOfShifts < 0) numberOfShifts += 26; // Ensure non-negative shifts

            // Calculate the new character by shifting `s[i]`
            char shiftedChar = (char) ('a' +
                ((s.charAt(i) - 'a' + numberOfShifts) % 26));
            result.setCharAt(i, shiftedChar);
        }

        return result.toString();
    }
}
