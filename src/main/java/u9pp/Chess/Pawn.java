package u9pp.Chess;

public class Pawn extends ChessPiece{
  // instance variables
   private boolean firstTurn;
   private int direction = 1;
  
   public Pawn(ChessPiece[][] boardP, int rowP, int colP, boolean isWhiteP){
    super(boardP, rowP, colP, isWhiteP);
    firstTurn = true;
   }

   public String toString() {
    String name = "p";
    if(this.isWhite){
      name = "P";
    }
    return name;
   }


   public void doMove(int rowTo, int colTo) {
    super.doMove(rowTo, colTo);
    firstTurn = false;
   }


   public boolean canMoveTo(int r, int c) {
    if(this.isWhite){
      direction = -1;
    }

    if(super.canMoveTo(r, c)){
      if(r == this.row + direction){
        if(c == this.col){
          if(board[r][c] == null){
            return true;
           }
         } else if(c == this.col + 1 || c == this.col - 1) {
           if(board[r][c] != null && board[r][c].isWhite() != this.isWhite()){
             return true;
           }
         }
       }

       if((r == this.row + 2 * direction) && firstTurn && c == this.col) {
         if(board[r][c] == null && board[r - direction][c] == null){
           return true;
          }
        }
      }
      return false;
    }
}