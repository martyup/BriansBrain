package inf101.list;

/**
 * 
 * A Grid contains a set of cells in a square 2D matrix.
 * 
 * @author eivind
 *
 */
public class Grid<ElementType> {

	/**
	 * We use a MyArrayList filled with MyArrayLists to hold all the elements.
	 */
	private MyArrayList<MyArrayList<ElementType>> cells;

	private int height;
	private int width;

	/**
	 * 
	 * Construct a grid with the given dimensions.
	 * 
	 * @param height
	 * @param width
	 * @param initElement
	 *            What the cells should initially hold.
	 */

	public Grid(int height, int width, ElementType initElement) {
		// TODO Steg 2a
		this.height = height;
		this.width = width;

		int miniHeight = 1;
		int miniWidth = 1;

		if (height <= 0) {
			height = miniHeight;
		}

		if (width <= 0) {
			width = miniWidth;
		}
		cells = new MyArrayList<MyArrayList<ElementType>>(height);

		for (int i = 0; i < height; i++) {
			cells.add(new MyArrayList<ElementType>(width));
			for (int j = 0; j < width; j++) {
				cells.get(i).add(initElement);
			}
		}
	}

	/**
	 * @return The height of the grid.
	 */
	public int getHeight() {
		// TODO Steg 2a
		return height;
	}

	/**
	 * @return The width of the grid.
	 */
	public int getWidth() {
		// TODO Steg 2a
		return width;
	}

	/**
	 * 
	 * Set the contents of the cell in the given row and column.
	 * 
	 * row must be greater than or equal to 0 and less than getHeight(). column
	 * must be greater than or equal to 0 and less than getWidth().
	 * 
	 * @param row
	 *            The row of the cell to change the contents of.
	 * @param column
	 *            The column of the cell to change the contents of.
	 * @param c
	 *            The contents the cell is to have.
	 */

	public void setCell(int row, int column, ElementType c) {
		// TODO Steg 2a
		if ((row >= 0 && row <= getHeight())
				&& (column >= 0 && column <= getWidth()))
			cells.get(row).set(column, c);
	}

	/**
	 * 
	 * Get the contents of the cell in the given row and column.
	 * 
	 * row must be greater than or equal to 0 and less than getHeight(). column
	 * must be greater than or equal to 0 and less than getWidth().
	 * 
	 * @param row
	 *            The row of the cell to get contents of.
	 * @param column
	 *            The column of the cell to get the contents of.
	 */
	public ElementType getCell(int h, int w) {
		// TODO Steg 2a
		return cells.get(h).get(w);
	}
}
