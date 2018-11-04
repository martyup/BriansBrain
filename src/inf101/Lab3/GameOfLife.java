package inf101.Lab3;

import inf101.list.Grid;

import java.awt.Color;
import java.util.Random;

/**
 * 
 * An ICellAutomata that implements Conways game of life.
 * 
 * @see ICellAutomata
 * 
 *      Every cell has two states: Alive or Dead. Each step the state of each
 *      cell is decided from its neighbors (diagonal, horizontal and lateral).
 *      If the cell has less than two alive Neighbors or more than three
 *      neighbors the cell dies. If a dead cell has exactly three neighbors it
 *      will become alive.
 * 
 * @author eivind
 */
public class GameOfLife implements ICellAutomaton {

	/**
	 * The grid the game is played in.
	 */
	Grid<GOLCell> currentGeneration;

	/**
	 * 
	 * Construct a GameOfLife ICellAutomaton using a grid with the given height
	 * and width.
	 * 
	 * @param height
	 * @param width
	 */
	public GameOfLife(int height, int width) {
		currentGeneration = new Grid<GOLCell>(height, width, GOLCell.DEAD);
	}

	@Override
	public void initializeGeneration() {
		Random random = new Random();
		for (int h = 0; h < currentGeneration.getHeight(); h++) {
			for (int w = 0; w < currentGeneration.getWidth(); w++) {
				if (random.nextBoolean()) {
					currentGeneration.setCell(h, w, GOLCell.ALIVE);
				} else {
					currentGeneration.setCell(h, w, GOLCell.DEAD);
				}
			}
		}
	}

	@Override
	public int getHeight() {
		return currentGeneration.getHeight();
	}

	@Override
	public int getWidth() {
		return currentGeneration.getWidth();
	}

	@Override
	public Color getColorInCurrentGeneration(int h, int w) {
		if (currentGeneration.getCell(h, w) == GOLCell.ALIVE) {
			return Color.black;
		} else {
			return Color.white;
		}
	}

	@Override
	public void stepAutomata() {

		Grid<GOLCell> nextGeneration = new Grid<GOLCell>(
				currentGeneration.getHeight(), currentGeneration.getWidth(),
				GOLCell.ALIVE);

		for (int h = 0; h < currentGeneration.getHeight(); h++) {
			for (int w = 0; w < currentGeneration.getWidth(); w++) {
				int numNeighbours = 0;
				for (int wd = -1; wd <= 1; wd++) {
					for (int hd = -1; hd <= 1; hd++) {
						if (wd == 0 && hd == 0)
							continue;// samme celle, hopp over
						if (h + hd < 0)
							continue; // utenfor brettet
						if (h + hd >= currentGeneration.getHeight())
							continue;// utenfor brettet
						if (w + wd < 0)
							continue;// utenfor brettet
						if (w + wd >= currentGeneration.getWidth())
							continue;// utenfor brettet
						
						// tell levende naboer
						if (currentGeneration.getCell(h + hd, w + wd) == GOLCell.ALIVE) {
							numNeighbours++;
						}
					}
				}
				if (numNeighbours < 2) {
					nextGeneration.setCell(h, w, GOLCell.DEAD);
				} else if (numNeighbours == 3) {
					nextGeneration.setCell(h, w, GOLCell.ALIVE);
				} else if (numNeighbours > 3) {
					nextGeneration.setCell(h, w, GOLCell.DEAD);
				} else {
					nextGeneration.setCell(h, w,
							currentGeneration.getCell(h, w));
				}
			}
		}

		for (int h = 0; h < currentGeneration.getHeight(); h++) {
			for (int w = 0; w < currentGeneration.getWidth(); w++) {
				currentGeneration.setCell(h, w, nextGeneration.getCell(h, w));
			}
		}
	}
}
