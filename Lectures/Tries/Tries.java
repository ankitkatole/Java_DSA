import java.util.*;

public class Tries {
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

    public static void main(String[] args) {
        String words[] = { "hello", "hell", "heaven", "heavy", "hero" };
        System.out.println("## Words inserted into the trie. ##");
        // Insert words into the trie
        for (String word : words) {
            insert(word);
        }
        System.out.println("----------------------");

        // Search for words in the trie
        String searchWords[] = { "hello", "hell", "heaven", "heavy", "hero", "her" };
        System.out.println("## Words searched in the trie. ##");
        for (String word : searchWords) {
            if (search(word)) {
                System.out.println(word + " is present in the trie.");
            } else {
                System.out.println(word + " is not present in the trie.");
            }
        }
        System.out.println("----------------------");
    }
}
