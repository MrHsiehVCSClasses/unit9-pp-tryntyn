package u9pp.Chess;

public class ChessPiece{
  // Instance variables
  public int row;
  public int col;
  public boolean isWhite;
  public ChessPiece[][] board;

  // Constructors
  public ChessPiece(ChessPiece[][] boardCP, int rowCP, int colCP, boolean isWhiteCP){
    board = boardCP;
    row = rowCP;
    col = colCP;
    isWhite = isWhiteCP;
  }


  public boolean isWhite(){
    return isWhite;
  }

  public void doMove(int rowTo, int colTo){
    board[rowTo][colTo] = board[row][col];
    board[row][col] = null;
  }


  public boolean canMoveTo(int rowCP, int colCP){
    if(boardCheck(rowCP, colCP)){
        if(this.raceCheck(rowCP, colCP)){
            if(this.gridCheck(rowCP, colCP)){
                return true;
            }
        }
    }
    return false;
  }


  public boolean boardCheck(int rowCP, int colCP){
    if((rowCP < board.length && rowCP >= 0) && (colCP < board[rowCP].length && colCP >= 0)){
        return true;
    }
    return false;
  }

 
  public boolean raceCheck(int rowCP, int colCP){
    if(board[rowCP][colCP] == null || board[rowCP][colCP].isWhite() != this.isWhite()){
        return true;
    } else 
    return false;
  }


  public boolean gridCheck(int rowCP, int colCP){
    if(rowCP == this.row && colCP == this.col){
        return false;
    }
    return true;
  }




// Movement Functions \\

 
  public boolean diagMove(int r, int c){
    int distRow = Math.abs(this.row - r);
    int distCol = Math.abs(this.col - c);
    if(distCol == distRow){
        return true;
    }
    return false;
  }


  public boolean diagCheck(int r1, int c1){
    int rDirection = 1;
    int cDirection = 1;


    if(this.row - r1 > 0){rDirection = -1;}
    if(this.col - c1 > 0){cDirection = -1;}

    for(int currRow = this.row + rDirection; currRow != r1; currRow += rDirection){
        for(int currCol = this.col + cDirection; currCol != c1; currCol += cDirection){
            if(this.diagMove(currRow, currCol) && board[currRow][currCol] != null){
                return false;
            }
        }
    }
    return true;
  }

  
  public boolean horAndVertMove(int rowCP, int colCP){
    int distRow = this.row - rowCP;
    int distCol = this.col - colCP;
    if(distRow == 0 || distCol == 0){
        return true;
    }
    return false;
  }

  public boolean horAndVertCheck(int r1, int c1){
    int distRow = this.row - r1;
    int distCol = this.col - c1;

  
    int rDirection = 1;
    if(this.row - r1 > 0){
      rDirection = -1;
    }

    if(distRow != 0){
        for(int currRow = this.row + rDirection ; currRow != r1; currRow += rDirection){
            if(board[currRow][c1] != null){
                System.out.println("false on test vertically");

                return false;
            }
        }
    }

 
    int cDirection = 1;
    if(this.col - c1 > 0) {
      cDirection = -1;
    }

    if(distCol != 0){
        for(int currCol = this.col + cDirection ; currCol != c1; currCol += cDirection){
            if(board[r1][currCol] != null){
                return false;
            }
        }
    }
    return true;
  }



}