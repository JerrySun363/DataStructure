package datastructure;

import java.util.HashMap;

public class LRU<K, V> {

	private static class DoubleLinkedListNode<K, V> {
		public K key;
		public V value;
		public DoubleLinkedListNode<K, V> next;
		public DoubleLinkedListNode<K, V> prev;

		public DoubleLinkedListNode() {

		}

		public DoubleLinkedListNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	private static class DoubleLinkedList<K, V> {
		DoubleLinkedListNode<K, V> head;
		DoubleLinkedListNode<K, V> tail;
		int count;

		public DoubleLinkedList() {
			this.head = new DoubleLinkedListNode<K, V>();
			this.tail = new DoubleLinkedListNode<K, V>();
			this.head.next = tail;
			this.tail.prev = head;
		}

		public void addHead(DoubleLinkedListNode<K, V> item) {
			item.next = this.head.next;
			item.next.prev = item;
			item.prev = head;
			this.head.next = item;
			count++;
		}

		public DoubleLinkedListNode<K, V> extractNode(
				DoubleLinkedListNode<K, V> item) {
			item.prev.next = item.next;
			item.next.prev = item.prev;
			count--;
			return item;
		}

		public K removeTail() {
			if (count == 0) {
				return null;
			}
			K res = tail.prev.key;
			this.tail.prev = this.tail.prev.prev;
			this.tail.prev.next = this.tail;
			count--;
			return res;
		}

		public int size() {
			return count;
		}
	}

	private int capcity;
	private DoubleLinkedList<K, V> list;
	private HashMap<K, DoubleLinkedListNode<K, V>> map;

	public LRU(int capcity) {
		this.capcity = capcity;
		this.list = new DoubleLinkedList<K, V>();
		this.map = new HashMap<K, DoubleLinkedListNode<K, V>>();
	}

	public void set(K key, V value) {
		if (this.map.containsKey(key)) {
			DoubleLinkedListNode<K, V> node = this.map.get(key);
			node = list.extractNode(node);
			node.value = value;
			this.list.addHead(node);
		} else {
			DoubleLinkedListNode<K, V> node = new DoubleLinkedListNode<K, V>(
					key, value);
			this.list.addHead(node);
			this.map.put(key, node);
			if (list.size() > this.capcity) {
				K delkey = this.list.removeTail();
				this.map.remove(delkey);
			}
		}

	}

	public V get(K key) {
		DoubleLinkedListNode<K, V> node = this.map.get(key);
		if (node == null) {
			return null;
		}
		node = list.extractNode(node);
		this.list.addHead(node);
		return node.value;
	}

}
