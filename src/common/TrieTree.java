package common;

public class TrieTree {

    public TrieTree() {
        this.root = new TrieNode();
    }

    private final TrieNode root;

    // Inserts a word into the trie.
    public void insert(String word) {

        char[] chars = toLowerCase(word);

        TrieNode currentNode = root;

        for (char c : chars) {
            int in = hash(c);
            if (currentNode.children[in] == null) {
                currentNode.children[in] = new TrieNode();
            }

            currentNode = currentNode.children[in];
        }

        currentNode.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }

//    public boolean search(String word) {
//
//        char[] cs = toLowerCase(word);
//
//        TrieNode currentNode = root;
//
//        for (char c : cs) {
//            int in = hash(c);
//            if ( currentNode.children[in] == null) {
//                return false;
//            }
//            currentNode = currentNode.children[in];
//        }
//        return currentNode.isEnd;
//    }

    int hash(char c) {
        return Character.hashCode(c);
    }

    char[] toLowerCase(String word) {
        return word.toLowerCase().toCharArray();
    }


}
