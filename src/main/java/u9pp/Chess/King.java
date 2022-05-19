package u9pp.Chess;

public class King extends ChessPiece {

  public King(ChessPiece[][] boardK, int rowK, int colK, boolean isWhiteK) {
    super(boardK, rowK, colK, isWhiteK);
  }

  public String toString() {
    String name = "k";
    if(this.isWhite){
      name = "K";
    }
    return name;
  }

  public boolean canMoveTo(int rowK, int colK){
    if(super.canMoveTo(rowK, colK)){
      if(kingRepel(rowK, colK)){
        if((rowK + 1 == this.row || rowK == this.row || rowK - 1 == this.row) && (colK + 1 == this.col || colK == this.col || colK - 1 == this.col)){
          return true;
        }
      }
    }
    return false;
  }


  public boolean kingRepel(int rowK, int colK){
    for(int r = rowK - 1; r < rowK + 2; r++){
      for(int c = colK - 1; c < colK + 2; c++){
        if(boardCheck(r, c)){
          if(board[r][c] != null && board[r][c] instanceof King && board[r][c] != this){
            return false;
          }
        }
      }
    }
    return true;
  }

}
