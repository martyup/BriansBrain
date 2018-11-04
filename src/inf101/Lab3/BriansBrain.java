package inf101.Lab3;

import inf101.list.Grid;

import java.awt.Color;
import java.util.Random;

public class BriansBrain implements ICellAutomaton {

	// The grid the game is played in.

	Grid<BBCell> currentGeneration;

	/**
	 * 
	 * Construct a briansbrain ICellAutomaton using a grid with the given height
	 * and width.
	 * 
	 * @param height
	 * @param width
	 */
	public BriansBrain(int height, int width) {
		currentGeneration = new Grid<BBCell>(height, width, BBCell.DEAD);
	}

	@Override
	public void initializeGeneration() {
		Random random = new Random();
		for (int h = 0; h < currentGeneration.getHeight(); h++) {
			for (int w = 0; w < currentGeneration.getWidth(); w++) {
				if (random.nextBoolean()) {
					currentGeneration.setCell(h, w, BBCell.ALIVE);
				} else {
					currentGeneration.setCell(h, w, BBCell.DEAD);
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
		if (currentGeneration.getCell(h, w) == BBCell.ALIVE) {
			return Color.green;
		} else if (currentGeneration.getCell(h, w) == BBCell.DYING) {
			return Color.yellow;
		} else {
			return Color.white;
		}
	}

	@Override
	public void stepAutomata() {

		Grid<BBCell> nextGeneration = new Grid<BBCell>(
				currentGeneration.getHeight(), currentGeneration.getWidth(),
				BBCell.ALIVE);

		for (int h = 0; h < currentGeneration.getHeight(); h++) {
			for (int w = 0; w < currentGeneration.getWidth(); w++) {
				int numNeighbours = 0;
				for (int wd = -1; wd <= 1; wd++) {
					for (int hd = -1; hd <= 1; hd++) {
						if (wd == 0 && hd == 0)
							continue;
						if (h + hd < 0)
							continue;
						if (h + hd >= currentGeneration.getHeight())
							continue;
						if (w + wd < 0)
							continue;
						if (w + wd >= currentGeneration.getWidth())
							continue;
						if (currentGeneration.getCell(h + hd, w + wd) == BBCell.ALIVE) {
							numNeighbours++;
						}
					}
				}
				// alive blir dying
				if (currentGeneration.getCell(h, w) == BBCell.ALIVE) {
					nextGeneration.setCell(h, w, BBCell.DYING);
				}
				// dying blir dead
				else if (currentGeneration.getCell(h, w) == BBCell.DYING) {
					nextGeneration.setCell(h, w, BBCell.DEAD);
				}
				// Dead blir alive
				else if (currentGeneration.getCell(h, w) == BBCell.DEAD
						&& numNeighbours == 2) {
					nextGeneration.setCell(h, w, BBCell.ALIVE);
				}

				else {
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
