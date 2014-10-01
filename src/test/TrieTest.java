package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datastructure.Trie;

/**
 * 
 * @author Jerry
 * 
 */
public class TrieTest {
	private static Trie trie;

	@Before
	public void setup() {
		trie = new Trie();
		trie.insert("we");
		trie.insert("test");
		trie.insert("whatever");
		trie.insert("what");
	}

	@Test
	public void testInsert() {

		assertEquals(trie.getWordOfPrefix("what").size(), 2);
		assertEquals("what", trie.getWordOfPrefix("what").get(0));
	}

	@Test
	public void testIsExist() {
		trie.insert("where");
		assertTrue(trie.isExist("what"));
		assertFalse(trie.isExist("ever"));
	}

	@Test
	public void testDelete() {
		trie.deleteWord("whatever");
		assertEquals("what", trie.getWordOfPrefix("what").get(0));
		assertEquals(trie.getWordOfPrefix("what").size(), 1);
	}
}
