# Problem Link: https://leetcode.com/problems/counting-words-with-a-given-prefix/?envType=daily-question&envId=2025-01-09
# Trie is a kinda data structure, I can't explain in two or three words with side comments. But for good practice, you have to absorb this.
# But, still, I would like to suggest that, you try with a naive approach until you visualize Trie.
# For a Real-World example, you can take the keypad suggestion you get when you usually type something on your mobile using the keyboard.
# Keep practicing. 
# If you want to learn:
# Youtube Link: https://youtu.be/pnOJGH2gVJU?si=xFO_8ah-qOdFsEa1

class TrieNode:
      def __init__(self):
         self.links = [None]*26
         self.prefCount = 0

class Trie:
      def __init__(self):
         self.root = TrieNode()
      def insert(self, word):
          crawl = self.root
          for c in word:
              idx = ord(c) - ord('a')
              if crawl.links[idx] is None:
                 crawl.links[idx] = TrieNode()
              crawl = crawl.links[idx]
              crawl.prefCount+=1
      def search(self, word):
          crawl = self.root
          for c in word:
              idx = ord(c) - ord('a')
              if crawl.links[idx] is None:
                 return 0
              crawl = crawl.links[idx]
          return crawl.prefCount

class Solution(object):
    def prefixCount(self, words, pref):
        """
        :type words: List[str]
        :type pref: str
        :rtype: int
        """
        trie = Trie()

        for word in words:
            trie.insert(word)
        return trie.search(pref)
        

 
