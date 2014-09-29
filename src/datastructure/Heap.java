package datastructure;

import java.util.ArrayList;

/**
 * This function implements a heap that stores a heap The definition of Heap can
 * be found here. http://en.wikipedia.org/wiki/Heap_(data_structure)
 * 
 * @author Jerry
 * 
 */
public class Heap<T extends Comparable<T>> {
	ArrayList<T> array;

	public Heap() {
		array = new ArrayList<>();
	}

	public Heap(T[] list) {
		array = new ArrayList<>(list.length);
		for (int i = 0; i < list.length; i++) {
			this.insert(list[i]);
		}
	}

	public void insert(T value) {
		// firstly put it at the end.
		array.add(value);
		int lastIndex = array.size() - 1;
		while (lastIndex > 0) {
			int parentIndex = (lastIndex - 1) / 2;
			if (array.get(lastIndex).compareTo(array.get(parentIndex)) > 0) {
				this.swap(lastIndex, parentIndex);
				lastIndex = parentIndex;
			} else {
				break;
			}
		}
	}

	// Suppose it is a max heap.
	public T max() {
		return array.get(0);
	}

	public T deleteMax() {
		T res = array.get(0); // O(1)
		array.set(0, array.get(array.size() - 1)); // O(1)
		array.remove(array.size() - 1); // O(1)
		int index = 0;
		while (index < array.size()) {
			int left = index * 2 + 1;
			int right = index * 2 + 2;
			if (right > array.size()) {
				break;
			} else if (right < array.size()) {
				int larger = array.get(left).compareTo(array.get(right)) > 0 ? left
						: right;
				if (array.get(index).compareTo(array.get(larger)) < 0) {
					this.swap(index, larger);
					index = larger;
				} else {
					break;
				}

			} else {// only have left children.
				if (array.get(index).compareTo(array.get(left)) < 0) {
					this.swap(index, left);
					index = left;
				} else {
					break;
				}

			}

		}
		return res;
	}

	private void swap(int fromIndex, int toIndex) {
		T temp = array.get(fromIndex);
		array.set(fromIndex, array.get(toIndex));
		array.set(toIndex, temp);
	}

	public boolean isEmpty() {
		return array.isEmpty();
	}

	public int size() {
		return array.size();
	}

}
