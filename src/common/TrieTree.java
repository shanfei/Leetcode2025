package common;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> searchSubstr(int currentIndex, char[] chars) {

        TrieNode currentNode = this.root;
        int index = currentIndex;

        List<Integer> result = new ArrayList<>();

        while ( index < chars.length ) {
            char c = chars[index];
            int i = hash(c);
            TrieNode nextNode = currentNode.children[i];
            if ( nextNode != null ) {
                if (nextNode.isEnd) {
                    result.add(index);
                }
                currentNode = currentNode.children[i];
                index++;
            } else {
                return result;
            }
        }

        return result;

    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {

        char[] cs = toLowerCase(prefix);

        TrieNode currentNode = root;

        for (char c : cs) {
            int in = hash(c);
            if ( currentNode.children[in] == null) {
                return false;
            }
            currentNode = currentNode.children[in];
        }

        return true;
    }

    public List<String> autoComplete(String prefix) {

        char[] cs = toLowerCase(prefix);

        List<String> result = new ArrayList<>();

        TrieNode currentNode = root;

        for (char c : cs) {
            int in = hash(c);
            if ( currentNode.children[in] == null) {
                return result;
            }
            currentNode = currentNode.children[in];
        }

        StringBuilder sb = new StringBuilder(prefix);

        if (currentNode.isEnd) {
            result.add(sb.toString());
        }

        buildStringFromPrefix(currentNode, result ,sb);

        return result;

    }

    void buildStringFromPrefix(TrieNode currentNode, List<String> result, StringBuilder sb) {

        for (int i = 0; i < currentNode.children.length; ++i) {
            TrieNode node = currentNode.children[i];

            if (node != null) {
                sb.append((char)('a' + i));

                if (node.isEnd) {
                    if (result.size() < 3) {
                        result.add(sb.toString());
                    }
                }

                buildStringFromPrefix(node, result, sb);

                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    int hash(char c) {
        return ( c - 'a' ) % 26;
    }

    char[] toLowerCase(String word) {
        return word.toLowerCase().toCharArray();
    }


}
