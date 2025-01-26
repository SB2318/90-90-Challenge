# Problem Link: https://www.geeksforgeeks.org/problems/lru-cache/1

from collections import OrderedDict
class LRUCache:
      
    #Constructor for initializing the cache capacity with the given value.  
    def __init__(self, cap):
        #code here
        self.capacity =cap
        self.cache = OrderedDict()
        
        
    #Function to return value corresponding to the key.
    def get(self, key):
        #code here
        if key not in self.cache:
            return -1
        self.cache.move_to_end(key) # In LRU SYSTEM, WHENEVER YOU USE ONE ITEM, MOVE IT TO END (MOST RECENTLY USED)
        return self.cache[key]
        
        
    #Function for storing key-value pair.   
    def put(self, key, value):
        #code here
        if key in self.cache:
           self.cache.move_to_end(key)
           
           
        elif len(self.cache) >= self.capacity:
            self.cache.popitem(last= False)
        
        
        self.cache[key] = value
        self.cache.move_to_end(key)
