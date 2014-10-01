package common;

import java.util.TreeMap;

public class TrieNode {
	private char character;
	private TreeMap<Character, TrieNode> map;// the map can be replaced by an
												// array. O(1) time for both.

	public TrieNode(char character) {
		this.character = character;
		this.map = new TreeMap<Character, TrieNode>();
	}

	public TrieNode() {
		this.map = new TreeMap<Character, TrieNode>();
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public TreeMap<Character, TrieNode> getMap() {
		return map;
	}

	public void setMap(TreeMap<Character, TrieNode> map) {
		this.map = map;
	}

}
