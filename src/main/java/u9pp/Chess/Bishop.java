package u9pp.Chess;


public class Bishop extends ChessPiece{

  public Bishop(ChessPiece[][] boardB, int rowB, int colB, boolean isWhiteB){
    super(boardB, rowB, colB, isWhiteB);
  }

  public String toString() {
    String name = "b";
    if(this.isWhite){
      name = "B";
    }
    return name;
  }

  public boolean canMoveTo(int r, int c){
    if(super.canMoveTo(r, c)) {
      if(this.diagMove(r, c)) {
        if(this.diagCheck(r, c)) {
          return true;
        }
      }
    }
    return false;
  }

}