
package u9pp.Chess;

public class Rook extends ChessPiece {
  public Rook(ChessPiece[][] boardR, int rowR, int colR, boolean isWhiteR){
    super(boardR, rowR, colR, isWhiteR);
  }

  public String toString() {
    String name = "r";
    if(this.isWhite){
      name = "R";
    }
    return name;
  }

  public boolean canMoveTo(int r, int c) {
    if(super.canMoveTo(r, c)){   
      if(this.horAndVertMove(r, c)) {
        if(this.horAndVertCheck(r, c)) {
          return true;
        }
      }
    }
    return false;
  }

}