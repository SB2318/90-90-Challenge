/**
  Problem Date: 19/01/24
  Problem Name: Water the plants
  Problem Link: https://www.geeksforgeeks.org/problems/water-the-plants--170646/1
  Problem Category: Array, Searching, Sorting
    
*/

class Solution {
  min_sprinklers(gallery, n) {
    const range = [];
    for (let i = 0; i < n; i++) {
      if (gallery[i]!== -1) {
        const left = Math.max(0, i - gallery[i]);
        const right = Math.min(n - 1, i + gallery[i]);
        range.push({ left, right });
      }
    }
    range.sort((a, b) => a.left - b.left);
    let start = 0,
      ans = 0,
      i = 0,
      end = 0;
    while (start <= n - 1) {
      end = -1;
      while (i < range.length && range[i].left <= start) {
        end = Math.max(end, range[i].right);
        i++;
      }
      if (end === -1) return -1;
      ans++;
      start = end + 1;
    }
    return ans;
  }
}