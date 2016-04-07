package s02;

public class Case {

  private boolean flag;
  private boolean mine;
  private boolean open;

  public Case(boolean mine) {
    flag = false;
    open = false;
    this.mine = mine;
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
