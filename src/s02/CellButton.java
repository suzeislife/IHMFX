package s02;

import javafx.scene.control.Button;

public class CellButton extends Button{

  private boolean flag;
  private boolean mine;
  private boolean open;
  private int row;
  private int col;

  public CellButton(int row, int col) {
    flag = false;
    open = false;
    mine = false;
    this.row = row;
    this.col = col;
  }

  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  public boolean isMine() {
    return mine;
  }

  public void setMine(boolean mine) {
    this.mine = mine;
  }

  public boolean isOpen() {
    return open;
  }

  public void setOpen(boolean open) {
    this.open = open;
  }

}
