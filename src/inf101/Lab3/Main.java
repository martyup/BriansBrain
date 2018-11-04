package inf101.Lab3;

public class Main {

	public static void main(String[] args) {
		//ICellAutomaton ca = new GameOfLife (100, 100);
		ICellAutomaton ca = new BriansBrain(100, 100);

		CellAutomataGUI.run(ca);
	}

}
