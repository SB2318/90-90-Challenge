# Problem Link: https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/?envType=daily-question&envId=2025-01-08

# Trie is a kinda data structure, I can't explain in two or three words with side comments. But for good practice, you have to absorb this.
# But, still, I would like to suggest that you try with a naive approach until you visualize Trie.
# For a Real-World example, you can take the keypad suggestion you get when you usually type something on your mobile using the keyboard.
# Keep practicing. 

class TrieNode:
    def __init__(self):
        self.links = [None] * 26  
        self.prefCount = 0  

class Trie:
    def __init__(self):
        self.root = TrieNode()
    def insert(self, word):
        crawl = self.root
        for i in range(len(word)):
            idx = ord(word[i])-ord('a')
            if crawl.links[idx] is None:
               crawl.links[idx] = TrieNode()
            crawl = crawl.links[idx]
            crawl.prefCount+=1
    
    def searchWord(self, word):
        crawl = self.root
        for i in range(len(word)):
            idx = ord(word[i])-ord('a')
            if crawl.links[idx] is None:
               return 0
            crawl = crawl.links[idx]
        
        return crawl.prefCount
    
class Solution(object):
    def countPrefixSuffixPairs(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        # Lets try trie,  first time I am writing such complex python code
        count = 0

        for i in range(len(words)):
            prefTrie = Trie()
            suffTrie = Trie()

            prefTrie.insert(words[i])
            suffTrie.insert(words[i][::-1])

            for j in range(i):
                if len(words[j]) > len(words[i]): continue;

                if prefTrie.searchWord(words[j]) > 0 and suffTrie.searchWord(words[j][::-1]) > 0:
                    count+=1

        return count
