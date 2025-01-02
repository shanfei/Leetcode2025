package com.designguru.code.pattern.tree.tire;

import common.TrieTree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a list of distinct strings products and a string searchWord.
 *
 * Determine a set of product suggestions after each character of the search word is typed. Every time a character is typed, return a list containing up to three product names from the products list that have the same prefix as the typed string.
 *
 * If there are more than 3 matching products, return 3 lexicographically smallest products. These product names should be returned in lexicographical (alphabetical) order.
 *
 * Examples
 * Example 1:
 *
 * Input: Products: ["apple", "apricot", "application"], searchWord: "app"
 * Expected Output: [["apple", "apricot", "application"], ["apple", "apricot", "application"], ["apple", "application"]]
 * Justification: For the perfix 'a', "apple", "apricot", and "application" match. For the prefix 'ap', "apple", "apricot", and "application" match. For the prefix 'app', "apple", and "application" match
 * Example 2:
 *
 * Input: Products: ["king", "kingdom", "kit"], searchWord: "ki"
 * Expected Output: [["king", "kingdom", "kit"], ["king", "kingdom", "kit"]]
 * Justification: All products starting with "k" are "king", "kingdom", and "kit". The list remains the same for the 'ki' prefix.
 * Example 3:
 *
 * Input: Products: ["fantasy", "fast", "festival"], searchWord: "farm"
 * Expected Output: [["fantasy", "fast", "festival"], ["fantasy", "fast"], [], []]
 * Justification: Initially, "fantasy", "fast", and "festival" match 'f'. Moving to 'fa', only "fantasy" and "fast" match. No product matches with "far", and "farm".
 *
 */
public class SearchSuggestionSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        TrieTree trieTree = new TrieTree();

        for (String w : products) {
            trieTree.insert(w);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            List<String> autoComplete =  trieTree.autoComplete(sb.toString());
            if (autoComplete.isEmpty()) {
                result.add(new ArrayList<>());
            } else {
                result.add(autoComplete);
            }
        }

        return result;
    }


}

