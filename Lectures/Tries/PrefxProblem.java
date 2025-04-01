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
            }else{
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

    public static void findPrefix(TrieNode root, String ans){ //O(L) where L is the length of the longest prefix
        // Base case: if the string is empty, return true   
        if (root == null) {
            return;
        }   
        if(root.freq == 1){
            System.out.println(ans);
            return;
        }
        // Check if the string is present in the trie
        for(int i = 0; i<26;i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans + (char)(i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String arr2[] = { "zebra", "dog", "duck", "dove" };
        for (String word : arr2) {
            insert(word);
        }
        root.freq = -1; // to avoid printing the root node
        findPrefix(root, "");
    }
}
