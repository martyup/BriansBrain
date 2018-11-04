package inf101.list;

/**
 * A list is an ordered sequence of elements, indexed from 0 to getLength()-1.
 */
public interface IList<ElementType> {

	/**
	 * Get length of list.
	 * 
	 * @return Length of the list
	 */
	int getSize();

	/**
	 * Get the value at a position.
	 * 
	 * @param index
	 *            The position to examine
	 * @return The value at that position
	 * @throws IndexOutOfBoundsException
	 *             if index is not >= 0 and < getLength()
	 */
	ElementType get(int index);

	/**
	 * Update the value at a position.
	 * 
	 * @param index
	 *            The position to update
	 * @param num
	 *            The value to write
	 * @return The previous value stored at that location.
	 * @throws IndexOutOfBoundsException
	 *             if index is not >= 0 and < getLength()
	 * @property after set(i,x), get(i) will return x.
	 * 
	 */
	ElementType set(int index, ElementType obj);

	/**
	 * Insert an element at position {@link #getSize()}
	 * 
	 * 
	 * @param num
	 *            The value to add
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the list's capacity is exceeded
	 * @property After add, length of list will have increased by one.
	 * @property After add(n), get(getLength()-1) == n
	 */
	void add(ElementType obj);

	/**
	 * Check if list is empty.
	 * 
	 * @return True if the list is empty.
	 * @property isEmpty() iff getLength() == 0
	 */
	boolean isEmpty();
}