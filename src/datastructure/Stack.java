package datastructure;

import common.ListNode;

public class Stack<T> {
	private ListNode<T> head = null;

	public Stack() {
		head = new ListNode<T>(null);
	}

	/**
	 * 
	 * @param value
	 */
	public void push(T value) {
		ListNode<T> newNode = new ListNode<T>(value);
		newNode.next = this.head.next;
		this.head.next = newNode;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.head.next == null;
	}

	/**
	 * 
	 * @return
	 */
	public T peek() {
		if (isEmpty()) {
			return null;
		} else {
			return head.next.value;
		}
	}

	/**
	 * Does not remove the original link, only moves the head forward.
	 * 
	 * @return
	 */
	public T pop() {
		if (isEmpty()) {
			return null;
		} else {
			T value = head.next.value;
			head.next = head.next.next;
			return value;
		}
	}

	/**
	 * Copy the stack in O(1) time and O(1) space.
	 * 
	 * @return
	 */
	public Stack<T> copy() {
		Stack<T> newStack = new Stack<T>();
		newStack.head.next = this.head.next;
		return newStack;
	}
}
