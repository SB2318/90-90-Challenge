# Problem Link: https://leetcode.com/problems/map-of-highest-peak/description/?envType=daily-question&envId=2025-01-22
# Solution Link: https://www.youtube.com/watch?v=nQe5OBs0FgQ

# Intution: Multisource BFS

# To solve this question, Prerequisite: A clear and conceptual understanding of QUEUE DS
# BFS from all 0 cells at the same time
# Your queue will look like 0,0,0,0,0,1,2...
# Means try to visualize the things,
# First what are you doing, in the array traversal, you are adding every water element as 0 in the queue, right?
# Then comes to queue traversal, where you are starting from 1st layer,
# Means, that all the 0 cells come in the first layer of the queue, and their corresponding cells will be already visited and assigned to 1 (Initially they are not visited, means -1). 
# Amazing problem, Feeling good to learn the concept.


class Solution(object):
    def highestPeak(self, isWater):
        """
        :type isWater: List[List[int]]
        :rtype: List[List[int]]
        """
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        rows = len(isWater)
        cols = len(isWater[0])

        cellsQueue = deque()
        cells = [[-1]*cols for i in range(rows)]

        # fill all water cell
        for i in range(rows):
            for j in range(cols):
                if isWater[i][j] == 1:
                    cells[i][j] = 0
                    cellsQueue.append((i,j)) # multisource bfs
        layer =1 

        while cellsQueue:
            layerSize = len(cellsQueue)

            for i in range(layerSize):
                x, y = cellsQueue.popleft()
                for dir in dirs:
                    x1 = x+ dir[0]
                    y1 = y+ dir[1]
                    
                    if self.isValid(x1,y1, rows, cols) and cells[x1][y1] == -1:
                       cells[x1][y1] = layer
                       cellsQueue.append((x1,y1))
            layer+=1
        
        return cells
    def isValid(self, x1, y1, rows, cols):
        return x1>=0 and y1 >= 0 and x1< rows and y1 < cols

  # Note: Difference Between heapq and deque in python:
  # heapq and deque are two different data structures in Python, each with its own unique characteristics and use cases.
  # Heapq
  # Functionality:
  # Implements a priority queue data structure using a binary heap algorithm.
  # Purpose:
  # Efficiently access the smallest (min-heap) or largest (max-heap) element in a collection. 
  # heapq.heapify(list): Converts a list into a heap.
  # heapq.heappush(heap, item): Adds an item to the heap.
  # heapq.heappop(heap): Removes and returns the smallest element from the heap.

  # Usecase :  PriorityQueue , Max-Heap , Min-Heap
  # Deque
  # Functionality:
  # Implements a double-ended queue, which allows you to add and remove elements from both ends efficiently.
  # Purpose:
  # Used when you need fast insertion and deletion at both ends of a collection.
  # Key Methods:
  # append(x): Adds an element to the right end.
  # appendleft(x): Adds an element to the left end.
  # pop(): Removes and returns an element from the right end.
  # popleft(): Removes and returns an element from the left end.
  
