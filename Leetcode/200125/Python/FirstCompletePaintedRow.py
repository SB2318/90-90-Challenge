# Problem Link: https://leetcode.com/problems/first-completely-painted-row-or-column/submissions/1518724779/?envType=daily-question&envId=2025-01-20

# Intuition: Do as said, but our goal is to see how efficiently we can do it.
# As per given problem statement
# For each element in arr we have to find the corresponding position of the component in the matrix, and we have to paint the position
# Our goal is to find the smallest index in arr where painting any element will result in at least one full row or column being painted.

# Approach 1: Bruteforce with HashMap
# Time Complexity : O(m*n) + O(k*(m+n))  , k= length of arr
# With HashMap, we are trying to reduce the time complexity needed to find any element in the map. From first, we are taking any element position in the 2D matrix as its coordinates (x,y)
# We are storing the elements of a 2d array with its coordinates in the HashMap.
# Then we are traversing the arr
# For each element position we are retrieving its coordinates
# And then check with the paint of this element with at least its corresponding row or column completely painted or not.
# If yes we are marking the index of arr as our answer.

# Now, how we are checking whether the position or box is painted or not? For painting, we are making the element negative. (as, given constraint, 1 <= arr[i], mat[r][c] <= m * n)
# If all elements in a particular row or column are negative, it means the particular row or column is completely painted.

class Solution(object):

    def checkRow(self, mat, row):
        
         for j in range(len(mat[row])):
             if mat[row][j] > 0:
                return False
         return True

    def checkCol(self, mat, col):     
         for j in range(len(mat)):
             if mat[j][col] > 0:
                return False
         return True
    def firstCompleteIndex(self, arr, mat):
        """
        :type arr: List[int]
        :type mat: List[List[int]]
        :rtype: int
        """
        position_map = {}

        for i in range(len(mat)):
            for j in range(len(mat[i])):
                position_map[mat[i][j]] = (i,j)

        for i in range(len(arr)):
            row, col = position_map[arr[i]]
            mat[row][col] *= -1

            if self.checkRow( mat, row) or self.checkCol( mat, col):
                return i
        return -1

   
               
# Approach 2: Bruteforce with HashMap (Optimized)
# Here our target is to optimize the time, Is it possible, why not?
# Optimized Time Complexity : O(m*n) + O(k)  , k= length of arr

# With HashMap, we are trying to reduce the time complexity needed to find any element in the map. From first, we are taking any element position in the 2D matrix as its coordinates (x,y)
# We are storing the elements of a 2d array with its coordinates in the HashMap.

# Here instead of checking each row and column every time, whether all elements are negative or not, we are tracking the count of each row and each column, how much element is negative.

# Note: 
# (i) In any row the number of elements is equal to the column size.
# (ii) In any column, the number of elements is equal to the row size.
# Algorithm:
# We are traversing the arr
# For each element position we are retrieving its coordinates
# And then check with the paint of this element with at least its corresponding row or column completely painted or not.
# If yes we are marking the index of arr as our answer.
# Now, how we are checking whether the position or box is painted or not? For painting, we are making the element negative. (as, given constraint, 1 <= arr[i], mat[r][c] <= m * n)
# We previously took two other arrays, one for tracking negative element count across the row, and another for tracking negative element across the column.
# If any row or any element achieved the target negative element count (the size of the column or size of the row), we are returning the responsible index of arr.

class Solution(object):

    def firstCompleteIndex(self, arr, mat):
        """
        :type arr: List[int]
        :type mat: List[List[int]]
        :rtype: int
        """
        position_map = {}
        m= len(mat)
        n= len(mat[0])

        for i in range(len(mat)):
            for j in range(len(mat[i])):
                position_map[mat[i][j]] = (i,j)
        
        rowPaintCount = [0]*len(mat)
        colPaintCount = [0]*len(mat[0])

        for i in range(len(arr)):
            row, col = position_map[arr[i]]
            mat[row][col] *= -1
            rowPaintCount[row] += 1
            colPaintCount[col] += 1
            if rowPaintCount[row] == len(mat[0]) or colPaintCount[col] == len(mat):
                return i
        return -1

# Approach 3: Reverse Mapping
# Time Complexity: O(k+ (m∗n))
# Intuition:
# Till Now, we have storing matrix elements in the map, and trying to find the optimized solution
# In this case, we will store each element of arr and their corresponding index in the map, and try to find the optimized result.
# How?
# First store each element of arr inside the map
# Then try to find for which max index of arr, a row will be completely painted.
        # Try to return the minimum result among the rows
# Then try to find for which max index of arr, a column will be completely painted
      # Try to return the minimum result among the columns
# Return the minimum of them

class Solution(object):
    def firstCompleteIndex(self, arr, mat):
        """
        :type arr: List[int]
        :type mat: List[List[int]]
        :rtype: int
        """
        position_map = {}

        for i in range(len(arr)):
            position_map[arr[i]] = i
        
        result = 100000000006
       # Check at how much max index  a row will be completely painted

        for i in range(len(mat)):
           maxIndex = -1
           for j in range(len(mat[i])):
              maxIndex = max(maxIndex, position_map[mat[i][j]])
           result = min(result, maxIndex)
       
      # Check at how much max index  a column will be completely painted  
        for j in range(len(mat[0])):
           maxIndex = -1
           for i in range(len(mat)):
              maxIndex = max(maxIndex, position_map[mat[i][j]])
           result = min(result, maxIndex)
        return result
