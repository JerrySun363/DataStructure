package test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructure.Stack;

public class StackTest {
	private static Stack<Integer> stack;

	@BeforeClass
	public static void setup() {
		stack = new Stack<Integer>();
	}

	@Test
	public void testPush() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		assertEquals(new Integer(9), stack.peek());
	}

	@Test
	public void testPop() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		for (int i = 9; i >= 0; i--) {
			Integer ele = stack.pop();
			assertEquals(ele, new Integer(i));
		}
	}

}
