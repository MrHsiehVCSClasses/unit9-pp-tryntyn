package u9pp.Chess;

public class Knight extends ChessPiece{
  public Knight(ChessPiece[][] boardN, int rowN, int colN, boolean isWhiteN){
    super(boardN, rowN, colN, isWhiteN);
  }

  public String toString() {
    String name = "n";
    if(this.isWhite){
      name = "N";
    }
    return name;
  }


  public boolean lMovement(int r, int c){
    int otherRow = Math.abs(this.row - r);
    int otherCol = Math.abs(this.col - c);
    if ((otherRow == 2 && otherCol == 1) || (otherRow == 1 && otherCol == 2)){
      return true;
    }
    return false;
  }

  public boolean canMoveTo(int r, int c){
    if(super.canMoveTo(r, c)){
      if(lMovement(r, c)){
        return true;
      }
    }
    return false;
  }

}