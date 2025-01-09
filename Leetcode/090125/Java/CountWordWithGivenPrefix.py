// Problem Link: https://leetcode.com/problems/counting-words-with-a-given-prefix/?envType=daily-question&envId=2025-01-09
/**
 Trie is a kinda data structure, I can't explain in two or three words with side comments. But for good practice, you have to absorb this.

 But, still, I would like to suggest that you try with a naive approach until you visualize Trie.

 For a Real-World example, you can take the keypad suggestion you get when you usually type something on your mobile using the keyboard.

 Keep practicing. 
 If you want to learn:
   Youtube Link: https://youtu.be/pnOJGH2gVJU?si=xFO_8ah-qOdFsEa1
*/

class TrieNode{
    TrieNode[] links = new TrieNode [26];
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
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();

        for(String word: words){

            trie.insert(word);
        }

        return trie.searchPrefixCount(pref);
    }
}
