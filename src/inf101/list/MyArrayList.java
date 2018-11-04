package inf101.list;

import java.util.Arrays;

/**
 * An implementation of IList that uses arrays.
 */
public class MyArrayList<ElementType> implements IList<ElementType> {
	private ElementType[] data;
	private int length;

	/**
	 * Create a new ArrayList with the given capacity.
	 * 
	 * @param size
	 *            Max capacity of the list
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList(int size) {
		data = (ElementType[]) new Object[size];
		length = 0;
	}

	@Override
	public int getSize() {
		return length;
	}

	@Override
	public ElementType get(int index) {
		if (index >= length)
			throw new IndexOutOfBoundsException("" + index);
		return data[index];
	}

	@Override
	public ElementType set(int index, ElementType obj) {
		if (index >= length)
			throw new IndexOutOfBoundsException("" + index);
		ElementType r = data[index];
		data[index] = obj;
		return r;
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public void add(ElementType obj) {
		if (length >= data.length)
			throw new IndexOutOfBoundsException("" + length);

		data[length] = obj;

		length = length + 1;

		Arrays.copyOf(data, length + 100);
	}

}