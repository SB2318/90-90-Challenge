// Problem Link: https://www.geeksforgeeks.org/problems/lru-cache/1

// Approach 1: With LinkedHashMap
class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
    
    /**
     * 
     *  Why LinkedHashMap?
     * LinkedHashMap instead of a normal HashMap in an LRU (Least Recently Used) cache is that LinkedHashMap maintains access order, 
     * which is crucial for efficiently identifying and removing the least recently used entry.
     * 
     * 
         In a normal HashMap, 
         you cannot directly remove the eldest entry when the capacity exceeds
     */
    static LinkedHashMap<Integer, Integer> map ;
    private final int capacity;
    
    LRUCache(int cap) {
        // code here
        this.capacity = cap;
        
        // The method checks if the size of the map exceeds the defined capacity (capacity).
        // If it does, the eldest (least recently used) entry is removed from the cache. 
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
        
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        // your code here
        return map.getOrDefault(key, -1);
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        // your code here
        
        map.put(key, value);
    }
}

// Approach 2: With Normal Hashmap and LinkedList
// https://takeuforward.org/data-structure/implement-lru-cache/
