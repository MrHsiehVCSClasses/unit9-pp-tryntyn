package u9pp.Chess;

public class Queen extends ChessPiece{
  public Queen(ChessPiece[][] boardQ, int rowQ, int colQ, boolean isWhiteQ){
    super(boardQ, rowQ, colQ, isWhiteQ);
  }

  public String toString() {
    String name = "q";
    if(this.isWhite){
      name = "Q";
    }
    return name;
  }

  public boolean canMoveTo(int r, int c) {
    if(super.canMoveTo(r, c)){
      if(this.diagMove(r, c)){
        if(this.diagCheck(r, c)){
          return true;
        }
      } else if(this.horAndVertMove(r, c)) {
        if(this.horAndVertCheck(r, c)){
          return true;
        }
      }
    }
    return false;
  }

  
}
