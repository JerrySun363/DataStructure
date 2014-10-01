package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.media.jai.registry.CIFRegistry;

import common.TrieNode;

public class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		// leave the validation to java itself.
		char[] letters = word.toCharArray();
		TrieNode current = root;
		for (int i = 0; i < letters.length; i++) {
			if (current.getMap().containsKey(letters[i])) {
				current = current.getMap().get(letters[i]);
			} else {
				TrieNode node = new TrieNode(letters[i]);
				current.getMap().put(letters[i], node);
				current = node;
			}
		}
		// after the last letter, should input that this does exist.
		current.getMap().put('#', null);
	}

	public List<String> getWordOfPrefix(String prefix) {
		char[] letters = prefix.toCharArray();
		TrieNode current = this.root;
		for (int i = 0; i < letters.length; i++) {
			current = current.getMap().get(letters[i]);
			if (current == null) {
				return null;
			}

		}
		return this.getWords(prefix, current);

	}

	private List<String> getWords(String prefix, TrieNode node) {
		List<String> res = new ArrayList<String>();

		// ordered loop
		for (Entry<Character, TrieNode> entry : node.getMap().entrySet()) {
			if (entry.getKey() == '#') {
				res.add(prefix);
			} else {
				res.addAll(this.getWords(prefix + entry.getKey(),
						entry.getValue()));
			}

		}
		return res;
	}

	/**
	 * Return whether the word exists in the dictionary
	 * 
	 * @param word
	 */
	public boolean isExist(String word) {
		char[] letters = word.toCharArray();
		TrieNode current = root;
		for (int i = 0; i < letters.length; i++) {
			current = current.getMap().get(letters[i]);
			if (current == null) {
				return false;
			}
		}
		if (current.getMap().containsKey('#')) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lazy delete, keep the nodes on the way there.
	 * 
	 * @param word
	 * @return false if there is no such word
	 */
	public boolean deleteWord(String word) {
		char[] letters = word.toCharArray();
		TrieNode current = this.root;
		for (int i = 0; i < letters.length; i++) {

			current = current.getMap().get(letters[i]);
			if (current == null) {
				return false;
			}
		}
		if (current.getMap().containsKey('#')) {
			current.getMap().remove('#');
			return true;
		} else {
			return false;
		}
	}

}
