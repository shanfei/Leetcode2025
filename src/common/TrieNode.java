package common;

public class TrieNode {

    // Represents each letter of the alphabet.
    public TrieNode[] children = new TrieNode[26];

    public boolean isEnd; // Flag to represent if the node is the end of a word.

    public TrieNode() {}
}

