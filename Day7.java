class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int count = 0; // Count of words that pass through this node
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.count++; // Increment count at this node
        }
    }

    // Get the score for all prefixes of a word
    public int getPrefixScore(String word) {
        TrieNode node = root;
        int score = 0;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                break; // No further prefixes exist
            }
            node = node.children[index];
            score += node.count; // Add the count for this prefix
        }
        return score;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        
        // Step 1: Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }

        // Step 2: Calculate the prefix scores for each word
        int[] answer = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            answer[i] = trie.getPrefixScore(words[i]);
        }

        return answer;
    }
}
//leetcode