package com.designguru.code.pattern.tree.tire;

import common.TrieNode;

/**
 *
 * Design a data structure that supports the addition of new words and the ability to check if a string matches any previously added word.
 *
 * Implement the Solution class:
 *
 * Solution() Initializes the object.
 * void addWord(word) Inserts word into the data structure, making it available for future searches.
 * bool search(word) Checks if there is any word in the data structure that matches word. The method returns true if such a match exists, otherwise returns false.
 * Note: In the search query word, the character '.' can represent any single letter, effectively serving as a wildcard character.
 *
 * Examples
 * Example 1:
 *
 * Input:
 * ["Solution", "addWord", "addWord", "search", "search"]
 * [[], ["apple"], ["banana"], ["apple"], ["......"]]
 * Expected Output:
 * [-1, -1, -1, 1, 1]
 * Justification: After adding the words "apple" and "banana", searching for "apple" will return true since "apple" is in the data structure. Searching for "......" will also return true as "banana" match the pattern.
 * Example 2:
 *
 * Input:
 * ["Solution", "addWord", "addWord", "search", "search"]
 * [[], ["cat"], ["dog"], ["c.t"], ["d..g"]]
 * Expected Output:
 * [-1, -1, -1, 1, 0]
 * Justification: "c.t" matches "cat" and "d..g" doesn't matches "dog".
 * Example 3:
 *
 * Input:
 * ["Solution", "addWord", "search", "search"]
 * [[], ["hello"], ["h.llo"], ["h...o"]]
 * Expected Output:
 * [-1, -1, 1, 1]
 * Justification: "h.llo" and "h...o" both match "hello".
 * Constraints:
 *
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 2 dots in word for search queries.
 * At most 104 calls will be made to addWord and search.
 *
 *
 */
public class DesignAddAndSearchWordDataStructure {

    private TrieNode root;

    public DesignAddAndSearchWordDataStructure() {
        this.root = new TrieNode();
    }

    // Function to add a word into the trie structure.
    public void addWord(String word) {
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

    // Function to search a word, considering '.' as a wildcard.
    public boolean search(String word) {
        return searchWord(word, this.root, 0);
    }

    boolean searchWord(String word, TrieNode node, int index) {

        char[] cs = toLowerCase(word);

        TrieNode currentNode = node;

        for ( int i = index; i < cs.length; ++i ) {

            char c = cs[i];

            if ( c == '.') {

                boolean isFound = false;

                for ( TrieNode n : currentNode.children ) {
                    if ( n != null ) {
                        isFound |= searchWord(word, n, i + 1);
                    }
                }

                return isFound;

            }

            int in = hash(c);

            if ( currentNode.children[in] == null) {
                return false;
            }

            currentNode = currentNode.children[in];
        }

        return currentNode.isEnd;
    }

    int hash(char c) {
        return ( c - 'a' ) % 26;
    }

    char[] toLowerCase(String word) {
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = Character.toLowerCase(chars[i]);
        }

        return chars;
    }


}
