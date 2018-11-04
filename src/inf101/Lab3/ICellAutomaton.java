package inf101.Lab3;

import java.awt.Color;

/**
 * 
 * An ICellAutomaton represents a Cellular Automaton. The automaton contains a
 * cell generation organized in rows and columns. Height and width refers to how
 * many rows and columns there are in the Cellular Automaton respectively.
 * 
 * @author eivind
 */
public interface ICellAutomaton {

	/**
	 * 
	 * Get the color of the cell in a given row and column.
	 * 
	 * @param row
	 * @param columns
	 * @return The color of the cell in the given row and column.
	 */
	Color getColorInCurrentGeneration(int row, int columns);

	/**
	 * The ICellAutomaton gives the cells their initial value. For instance the
	 * cellular automaton might give the cells a random state.
	 */
	void initializeGeneration();

	/**
	 * Progresses the state of the cell to the next generation.
	 */
	void stepAutomata();

	/**
	 * @return The number of rows.
	 */
	int getHeight();

	/**
	 * @return The number of columns.
	 */
	int getWidth();

}
