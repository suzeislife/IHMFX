package s02;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MineHuntController implements EventHandler<ActionEvent> {

  private MineHunt      view;
  private MineHuntModel model;

  public MineHuntController(MineHunt view, MineHuntModel model) {
    super();
    this.view = view;
    this.model = model;
  }

  @Override
  public void handle(ActionEvent event) {

  }

  public void boutonClicked(CellButton cellB, boolean rightClick) {
    if (!model.isOpen(cellB.getRow(), cellB.getCol())) {
      if (rightClick) {
        if (model.isFlagged(cellB.getRow(), cellB.getCol())) {
          view.setImageButton(cellB, 2, 0);
          model.setFlagState(cellB.getRow(), cellB.getCol(), false);
        } else {
          view.setImageButton(cellB, 1, 0);
          model.setFlagState(cellB.getRow(), cellB.getCol(), true);
        }
      } else {
        if (model.open(cellB.getRow(), cellB.getCol())) {
          view.setImageButton(cellB, 0, 0);
        } else if (model.isGameOver()) {
          view.endGame(model.errors());
        } else
          view.setImageButton(cellB, 3,
              model.neighborMines(cellB.getRow(), cellB.getCol()));
      }

    }
  }

  public void showMine(CellButton[][] mineGrid) {
    for (int i = 0; i < mineGrid.length; i++) {
      for (int j = 0; j < mineGrid[i].length; j++) {
        if (model.getMineHunt()[i][j].isMine()) {
          view.setImageButton(mineGrid[i][j], 0, 0);
        }
      }
    }
  }
  

}
