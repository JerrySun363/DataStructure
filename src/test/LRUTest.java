package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import datastructure.LRU;

public class LRUTest {
	private static LRU<Integer, Integer> lru;

	@BeforeClass
	public static void setup() {
		lru = new LRU<Integer, Integer>(3);
	}

	@Test
	public void testLRUset() {
		lru.set(3, 5); // 3
		lru.set(1, 2); // 1
		lru.set(6, 7); // 6
		lru.get(3); // 3-6-1
		lru.set(1, 4); // 1-3-6
		assertEquals(new Integer(4), lru.get(1));
		lru.get(6); // 6-1-3
		lru.set(5, 7); // 5-6-1
		assertNull(lru.get(3));
	}

}
