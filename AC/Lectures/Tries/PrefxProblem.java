public class PrefxProblem {
    /*
     * Problem 2: Prefix Problem
     * Given a list of words, find the shortest unique prefix for every words in
     * list.
     * Example:
     * Input: Words[] = {zebra, dog, duck, dove}
     * Output: {z, dog, du, dov}
     */
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        int freq;

        TrieNode() {
            isEndOfWord = false;
            freq = 1;
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
            } else {
                node.children[index].freq++;
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

    public static void findPrefix(TrieNode root, String ans) { // O(L) where L is the length of the longest prefix
        // Base case: if the string is empty, return true
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }
        // Check if the string is present in the trie
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    /*
     * Problem: Count Unique Substrings
     * Given a string s, return the number of unique substrings of s.
     * Example:
     * Input: s = "ababa"
     * ans = 10
     * Explanation: The unique substrings are: "a", "b", "ab", "ba", "aba", "bab",
     * "abab", "a", "b", "ababa"
     */
    public static int countNodes(TrieNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1; // Count the current node
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count;
    }

    public static int countUniqueSubStrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            insert(s.substring(i));
        }
        int count = 0;
        TrieNode node = root;
        return countNodes(node);
    }

    /*
      Problem: LArgest Word with All Prefixes
        Given a list of words, find the largest word with all prefixes.
        Example:
        input: words = ["a","banana","app","appl","ap","apply","apple"]
        output: "apple"
     */
    private static String ans = "";
    public static void longestWord(TrieNode root, StringBuilder temp) {
         if(root == null){
            return;
         }
         for(int i = 0; i< 26;i++){
            if(root.children[i] != null && root.children[i].isEndOfWord){
                temp.append((char)(i + 'a'));
                if(temp.length() > ans.length()){
                    ans =  temp.toString();
                }
                longestWord(root.children[i], temp);
                //Backtrack
                temp.deleteCharAt(temp.length() - 1);
            }
         }

    }
    public static void main(String[] args) {
        // String arr2[] = { "zebra", "dog", "duck", "dove" };
        // for (String word : arr2) {
        // insert(word);
        // }
        // root.freq = -1; // to avoid printing the root node
        // findPrefix(root, "");

        // Counting unique substrings for a given string;
        // System.out.println(countUniqueSubStrings("ababa"));
        // System.out.println(countUniqueSubStrings("apple"));

        String words[] = { "a", "banana", "app", "appl", "ap", "apply" };
        for (String word : words) {
            insert(word);
        }
        longestWord(root, new StringBuilder());
        System.out.println("Longest word with all prefixes: " + ans);
    }
}
