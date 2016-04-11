package s02;

public class TestMineHuntModel {

	public static void main(String[] args) {

		int nbMine = 10;
		MineHuntModel mineHuntModel = new MineHuntModel(nbMine, 10, 10);
		// Test method initNewGame:
		System.out.println(mineHuntModel.toString());
		int countMine = 0;
		Cell[][] listCell = mineHuntModel.getMineHunt();
		for (int i = 0; i < listCell.length; i++) {
			for (int j = 0; j < listCell[i].length; j++) {
				if (listCell[i][j].isMine()) {
					countMine++;
				}
			}
		}
		// Test method mine and the number of mine in the table are correct
		if (countMine == mineHuntModel.mines() && nbMine == countMine) {
			System.out.println("Number of mine: " + countMine);
		} else {
			System.out.println("Error number mine incorrect");
		}

		// Create a grid fix to test method
		Cell[][] fixListCell = new Cell[10][10];
		for (int i = 0; i < fixListCell.length; i++) {
			for (int j = 0; j < fixListCell[i].length; j++) {
				fixListCell[i][j] = new Cell(false);
			}
		}
		// Create mine fix
		fixListCell[1][1].setMine(true);
		fixListCell[1][3].setMine(true);

		MineHuntModel newMineHuntModel = new MineHuntModel(fixListCell);
		System.out.println(newMineHuntModel.toString());
		if(newMineHuntModel.neighborMines(2, 2) == 2 && newMineHuntModel.neighborMines(2, 1) == 1){
			System.out.println("NeightborMines OK!");
		}else{
			System.out.println("Error with NeightborMines");
		}

	}

}
