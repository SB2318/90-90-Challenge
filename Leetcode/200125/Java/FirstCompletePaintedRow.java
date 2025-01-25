// Problem Link: https://leetcode.com/problems/first-completely-painted-row-or-column/submissions/1518724779/?envType=daily-question&envId=2025-01-20

// Intuition: Do as said, but our goal is to see how efficiently we can do it.
// As per given problem statement
// For each element in arr we have to find the corresponding position of the component in the matrix, and we have to paint the position
// Our goal is to find the smallest index in arr where painting any element will result in at least one full row or column being painted.

// Approach 1: Bruteforce with HashMap
// Time Complexity : O(m*n) + O(k*(m+n))  , k= length of arr
// With HashMap, we are trying to reduce the time complexity needed to find any element in the map. From first, we are taking any element position in the 2D matrix as its coordinates (x,y)
// We are storing the elements of a 2d array with its coordinates in the HashMap.
// Then we are traversing the arr
// For each element position we are retrieving its coordinates
// And then check with the paint of this element with at least its corresponding row or column completely painted or not.
// If yes we are marking the index of arr as our answer.

// Now, how we are checking whether the position or box is painted or not? For painting, we are making the element negative. (as, given constraint, 1 <= arr[i], mat[r][c] <= m * n)
// If all elements in a particular row or column are negative, it means the particular row or column is completely painted.

class Solution {

    public int firstCompleteIndex(int[] arr, int[][] mat) {

      Map<Integer, Pair> map = new HashMap<>();

      for(int i=0; i<mat.length; i++){

        for(int j=0; j<mat[i].length; j++){

            map.put(mat[i][j], new Pair(i,j));
        }
      }

      for(int i=0; i<arr.length; i++){

          Pair p = map.get(arr[i]);
          mat[p.x][p.y]*=-1;

          if(isRowPainted(mat,p.x) || isColPainted(mat,p.y)){
            return i;
          }
      }

      return -1;
         
    }

    private boolean isRowPainted(int[][] mat, int row){

        for(int col=0; col<mat[row].length; col++){
            if(mat[row][col] >=0)
               return false;
        }

        return true;
    }

    private boolean isColPainted(int[][] mat, int col){

        for(int row=0; row<mat.length; row++){
            if(mat[row][col] >=0)
               return false;
        }

        return true;

    }

    class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

// Approach 2: Bruteforce with HashMap (Optimized)
// Here our target is to optimize the time, Is it possible, why not?
// Optimized Time Complexity : O(m*n) + O(k)  , k= length of arr

// With HashMap, we are trying to reduce the time complexity needed to find any element in the map. From first, we are taking any element position in the 2D matrix as its coordinates (x,y)
// We are storing the elements of a 2d array with its coordinates in the HashMap.

// Here instead of checking each row and column every time, whether all elements are negative or not, we are tracking the count of each row and each column, how much element is negative.

// Note: 
// (i) In any row the number of elements is equal to the column size.
// (ii) In any column, the number of elements is equal to the row size.
// Algorithm:
//We are traversing the arr
// For each element position we are retrieving its coordinates
// And then check with the paint of this element with at least its corresponding row or column completely painted or not.
// If yes we are marking the index of arr as our answer.
// Now, how we are checking whether the position or box is painted or not? For painting, we are making the element negative. (as, given constraint, 1 <= arr[i], mat[r][c] <= m * n)
// We previously took two other arrays, one for tracking negative element count across the row, and another for tracking negative element across the column.
// If any row or any element achieved the target negative element count (the size of the column or size of the row), we are returning the responsible index of arr.

class Solution {

    public int firstCompleteIndex(int[] arr, int[][] mat) {

      Map<Integer, Pair> map = new HashMap<>();

      for(int i=0; i<mat.length; i++){
        for(int j=0; j<mat[i].length; j++){
            map.put(mat[i][j], new Pair(i,j));
        }
      }

      int[] rowPaintCount = new int[mat.length];
      int[] colPaintCount = new int[mat[0].length];

      for(int i=0; i<arr.length; i++){

          Pair p = map.get(arr[i]);
         // mat[p.x][p.y]*=-1;

          rowPaintCount[p.x]++;
          colPaintCount[p.y]++;

          if(rowPaintCount[p.x] == mat[0].length || colPaintCount[p.y] == mat.length){
            return i;
          }
      }

      return -1;
         
    }


    class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

// Approach 3: Reverse Mapping
// Time Complexity: O(k+ (m∗n))
// Intuition:
// Till Now, we have storing matrix elements in the map, and trying to find the optimized solution
// In this case, we will store each element of arr and their corresponding index in the map, and try to find the optimized result.
// How?
// First store each element of arr inside the map
// Then try to find for which max index of arr, a row will be completely painted.
        // Try to return the minimum result among the rows
// Then try to find for which max index of arr, a column will be completely painted
      // Try to return the minimum result among the columns
// Return the minimum of them

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

       Map<Integer,Integer> map = new HashMap<>();

       for(int i=0; i<arr.length; i++){
           map.put(arr[i],i);
       }

       int result = Integer.MAX_VALUE;

// Check at how much max index  a row will be completely painted
       for(int row=0; row<mat.length; row++){
           int maxIndex = Integer.MIN_VALUE;
           for(int col=0; col<mat[0].length; col++){
                maxIndex = Math.max(maxIndex, map.get(mat[row][col])); 
           }
           result = Math.min(result, maxIndex);
       }

// Check at how much max index  a column will be completely painted
       for(int col=0; col<mat[0].length; col++){
           int maxIndex = Integer.MIN_VALUE;
           for(int row=0; row<mat.length; row++){
                maxIndex = Math.max(maxIndex, map.get(mat[row][col])); 
           }
           result = Math.min(result, maxIndex);
       }

       return result;
    }
}




