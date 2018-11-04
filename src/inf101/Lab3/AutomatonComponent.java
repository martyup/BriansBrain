package inf101.Lab3;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * 
 * A Component that draws the cells in a ICellAutomaton.
 * 
 * @author eivind
 */
class AutomatonComponent extends Component {
	/**
	 * The dimension of the grid containing the cells.
	 */
	private Dimension gridDim;
	/**
	 * The automaton to paint the cells of.
	 */
	private ICellAutomaton automaton;

	/**
	 * The height of each cell in pixels.
	 */
	private final int cellHeight = 5;

	/**
	 * The width of each cell in pixels.
	 */
	private final int cellWidth = 5;
	/**
	 * The size of the space between each cell and between the cell and the edge
	 * of the window.
	 */
	private final int padding = 1;
	private static final long serialVersionUID = 4548104480314044678L;

	/**
	 * Construct a AutomatonComponent that will paint the given automaton.
	 * 
	 * @param grid
	 */
	public AutomatonComponent(ICellAutomaton automaton) {
		this.automaton = automaton;
		gridDim = new Dimension((cellWidth + padding) * automaton.getWidth()
				+ padding, (cellHeight + padding) * automaton.getHeight()
				+ padding);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Component#getPreferredSize() Returns the dimensions of the
	 * grid.
	 */
	@Override
	public Dimension getPreferredSize() {
		return gridDim;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Component#paint(java.awt.Graphics) Paints the automaton.
	 */
	public void paint(Graphics g) {
		for (int h = 0; h < automaton.getHeight(); h++) {
			for (int w = 0; w < automaton.getWidth(); w++) {
				g.setColor(automaton.getColorInCurrentGeneration(h, w));
				g.fillRect(w * (cellHeight + padding) + padding, h
						* (cellHeight + padding) + padding, cellHeight,
						cellWidth);
			}
		}
	}
}
