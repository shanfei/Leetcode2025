package common;

public class TrieNode {

    // Represents each letter of the alphabet.
    TrieNode[] children = new TrieNode[26];

    public boolean isEnd; // Flag to represent if the node is the end of a word.

    public TrieNode() {}
}

