// Problem Link: https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/?envType=daily-question&envId=2025-01-08

/**
 Trie is a kinda data structure, I can't explain in two or three words with side comments. But for good practice, you have to absorb this.

 But, still, I would like to suggest that you try with a naive approach until you visualize Trie.

 For a Real-World example, you can take the keypad suggestion you get when you usually type something on your mobile using the keyboard.

 Keep practicing. 

*/


class TrieNode{
    TrieNode[] links = new TrieNode[26];
    int prefCount = 0;

    public TrieNode(){
        for(int i=0; i<26; i++)
           links[i] = null;
    }
}

class Trie{

    TrieNode root;
    public Trie(){
      root= new TrieNode();
    }

    public void insert(String word){

        TrieNode crawl = root;

        for(int i=0; i<word.length(); i++){

            int idx = word.charAt(i)-'a';

            if(crawl.links[idx] == null){
                crawl.links[idx] = new TrieNode();
            }
            crawl = crawl.links[idx];
            crawl.prefCount++;
        }
    }

    public int searchPrefixCount(String word){

        TrieNode crawl = root;

        for(int i=0; i<word.length(); i++){

            int idx = word.charAt(i) - 'a';

            if(crawl.links[idx] == null){
                return 0;
            }
            crawl = crawl.links[idx];
        }

        return crawl.prefCount;
    }
}

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
     
        int count=0;

        for(int i=0; i<words.length; i++){

         Trie prefTrie = new Trie(); 
         Trie suffTrie = new Trie();
            prefTrie.insert(words[i]);
            // also insert the reverse

            suffTrie.insert(new StringBuilder(words[i]).reverse().toString());

            // now start checking

            for(int j=0; j<i; j++){

                // we are checking all prefix and suffix pair with words[i]
                if(words[j].length() > words[i].length()) continue;

                String rev = new StringBuilder(words[j]).reverse().toString();

                if(prefTrie.searchPrefixCount(words[j]) > 0 && suffTrie.searchPrefixCount(rev) > 0){
                    count++;
                }
            }
        }

        return count;
    }
}

// Let's try trie
