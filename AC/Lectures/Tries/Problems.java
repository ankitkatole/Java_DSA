import java.util.*;


public class Problems {
    /*
     * Word Break Problem
     * Given a string s and a dictionary of strings wordDict, return true if s can
     * be segmented into a space-separated sequence of one or more dictionary words.
     * Note that the same word in the dictionary may be reused multiple times in the
     * segmentation.
     * Example 1:
     * Input: Words[]= {i,like,sam,samsung,mobile,ice} key= ilikesamsung
     * Output: Yes
     */
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            // Initialize all children to null
            // This is done in the constructor to avoid null pointer exceptions
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static TrieNode root = new TrieNode();

    public static void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public static boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public static boolean wordbreak(String key){
        // Base case: if the string is empty, return true
        if (key.length() == 0) {
            return true;
        }
        // Check if the string is present in the trie
        if (search(key)) {
            return true;
        }
        // Iterate through the string and check for all prefixes
        // If any prefix is found in the trie, check for the remaining substring
        // recursively
        // This is the main logic of the word break problem
        for(int i = 1; i <= key.length();i++){
            if(search(key.substring(0, i)) && wordbreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
   
    /*
      Problem: StartsWith Problem
        Given an array of string s and a prefix p, return true if there is any previously inserted String s that starts with p.
        words[] = {"apple,"app","mango","man,"woman"}
        prefix = "app"
        Output: Yes
        prefix = "moon"
        Output: No
     */
     public static boolean startsWith(String prefix){
        if(prefix.length() == 0){
            return false;
        }
        
        TrieNode node = root;
        for(int i = 0; i<prefix.length();i++){
            int idx = prefix.charAt(i) - 'a';
            if(node.children[idx] == null){
                return false;
            }
            node = node.children[idx];
        }
        return true;
     }

     

    public static void main(String[] args) {
        // String arr[] = { "b" };
        // String key = "a";
        // for (String word : arr) {
        //     insert(word);
        // }
        // if (wordbreak(key)) {
        //     System.out.println("Yes");
        // } else {
        //     System.out.println("No");
        // }
        // System.out.println("----------------------");
        
        // String words[] = {"apple","app","mango","man","woman"};
        // for(String word : words) {
        //     insert(word);
        // }
        // System.out.println("Starts with app: " + startsWith("app")); // true
        // System.out.println("Starts with moon: " + startsWith("moon")); // false
        // System.out.println("Starts with mai: " + startsWith("mai")); // false

        System.out.println("----------------------");

    }
}
