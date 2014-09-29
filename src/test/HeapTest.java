package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import datastructure.Heap;

public class HeapTest {
	private static Heap<Integer> heap;

	@BeforeClass
	public static void setup() {
		heap = new Heap<Integer>(new Integer[] { 1, 5, 7, 4, 2, 9, 6 });
	}

	@Test
	public void testInsert() {
		heap.insert(10);
		assertEquals((Integer) heap.max(), new Integer(10));
	}

	@Test
	public void testDelete() {

		assertEquals(new Integer(9), (Integer) heap.max());
		heap.deleteMax();
		assertEquals(new Integer(7), (Integer) heap.max());
	}
}
