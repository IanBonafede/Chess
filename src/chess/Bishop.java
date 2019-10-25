/**
 *
 * @author Ian Bonafede
 */
package chess;


import javax.swing.ImageIcon;


public class Bishop extends Piece{

    public Bishop(String color, Board b, Square s, ImageIcon i) {
        super(color, b, s, i);
        pieceType = "bishop";
    }

    @Override
    void setAvailableMoves() {
        availableMoves.clear();
        Square[] northEast = setNorthEast();
        Square[] northWest = setNorthWest();
        Square[] southEast = setSouthEast();
        Square[] southWest = setSouthWest();
        if(color.equals("black")){
            if(northEast != null){
                for(int  i = 0; i < northEast.length; i++){
                    //if the square NE of the bishop i squares has a piece
                    if(northEast[i].hasPiece){
                        //if its white its available
                        if(northEast[i].getPiece().getColor().equals("white")){
                            availableMoves.add(northEast[i]);
                            if(!northEast[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(northEast[i].getPiece().getColor().equals("black")){
                            northEast[i].getPiece().protect();
                            //pieces NE this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces NE this piece aren't available
                            if(!northEast[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square NE of the bishop i squares has no piece
                    else {
                        //its available
                        availableMoves.add(northEast[i]);
                    }
                }
            }
            if(northWest != null){
                for(int  i = 0; i < northWest.length; i++){
                    //if the square NW of the bishop i squares has a piece
                    if(northWest[i].hasPiece){
                        //if its white its available
                        if(northWest[i].getPiece().getColor().equals("white")){
                            availableMoves.add(northWest[i]);
                            if(!northWest[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(northWest[i].getPiece().getColor().equals("black")){
                            northWest[i].getPiece().protect();
                            //pieces NW this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces NW this piece aren't available
                            if(!northWest[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square NW of the bishop i squares has no piece
                    else {
                        //its available
                        availableMoves.add(northWest[i]);
                    }
                }
            }
            if(southEast != null) {
                for(int  i = 0; i < southEast.length; i++){
                    //if the square SE of the bishop i squares has a piece
                    if(southEast[i].hasPiece){
                        //if its white its available
                        if(southEast[i].getPiece().getColor().equals("white")){
                            availableMoves.add(southEast[i]);
                            if(!southEast[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(southEast[i].getPiece().getColor().equals("black")){
                            southEast[i].getPiece().protect();
                            //pieces SE of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces SE of this piece aren't available
                            if(!southEast[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square SE of the bishop i squares has no piece
                    else {
                        //its available
                        availableMoves.add(southEast[i]);
                    }
                }
            }
            if(southWest != null){
                for(int  i = 0; i < southWest.length; i++){
                    //if the square SW of the bishop i squares has a piece
                    if(southWest[i].hasPiece){
                        //if its white its available
                        if(southWest[i].getPiece().getColor().equals("white")){
                            availableMoves.add(southWest[i]);
                            if(!southWest[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(southWest[i].getPiece().getColor().equals("black")){
                            southWest[i].getPiece().protect();
                            //pieces SW of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces SW of this piece aren't available
                            if(!southWest[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square SW of the bishop i squares has no piece
                    else {
                        //its available
                        availableMoves.add(southWest[i]);
                    }
                }
            }
        }
        //if the bishop is white
        else {
            if(northEast != null){
                for(int  i = 0; i < northEast.length; i++){
                    //if the square NE of the bishop i squares has a piece
                    if(northEast[i].hasPiece){
                        //if its black its available
                        if(northEast[i].getPiece().getColor().equals("black")){
                            availableMoves.add(northEast[i]);
                            if(!northEast[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(northEast[i].getPiece().getColor().equals("white")){
                            northEast[i].getPiece().protect();
                            //pieces NE this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces NE this piece aren't available
                            if(!northEast[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square NE of the bishop i squares has no piece
                    else {
                        //its available
                        availableMoves.add(northEast[i]);
                    }
                }
            }
            if(northWest != null){
                for(int  i = 0; i < northWest.length; i++){
                    //if the square NW of the bishop i squares has a piece
                    if(northWest[i].hasPiece){
                        //if its black its available
                        if(northWest[i].getPiece().getColor().equals("black")){
                            availableMoves.add(northWest[i]);
                            if(!northWest[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(northWest[i].getPiece().getColor().equals("white")){
                            northWest[i].getPiece().protect();
                            //pieces NW this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces NW this piece aren't available
                            if(!northWest[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square NW of the bishop i squares has no piece
                    else {
                        //its available
                        availableMoves.add(northWest[i]);
                    }
                }
            }
            if(southEast != null) {
                for(int  i = 0; i < southEast.length; i++){
                    //if the square SE of the bishop i squares has a piece
                    if(southEast[i].hasPiece){
                        //if its black its available
                        if(southEast[i].getPiece().getColor().equals("black")){
                            availableMoves.add(southEast[i]);
                            if(!southEast[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(southEast[i].getPiece().getColor().equals("white")){
                            southEast[i].getPiece().protect();
                            //pieces SE of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces SE of this piece aren't available
                            if(!southEast[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square SE of the bishop i squares has no piece
                    else {
                        //its available
                        availableMoves.add(southEast[i]);
                    }
                }
            }
            if(southWest != null){
                for(int  i = 0; i < southWest.length; i++){
                    //if the square SW of the bishop i squares has a piece
                    if(southWest[i].hasPiece){
                        //if its black its available
                        if(southWest[i].getPiece().getColor().equals("black")){
                            availableMoves.add(southWest[i]);
                            if(!southWest[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(southWest[i].getPiece().getColor().equals("white")){
                            southWest[i].getPiece().protect();
                            //pieces SW of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces SW of this piece aren't available
                            if(!southWest[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square SW of the bishop i squares has no piece
                    else {
                        //its available
                        availableMoves.add(southWest[i]);
                    }
                }
            }
        }
    }
    
    @Override
    void setAvailableMovesOne(Square kingSquare, Piece attackingPiece) {
        availableMoves.clear();
        Square[] northEast = setNorthEast();
        Square[] northWest = setNorthWest();
        Square[] southEast = setSouthEast();
        Square[] southWest = setSouthWest();
        if(color.equals("black")){
            if(northEast != null){
                for(int  i = 0; i < northEast.length; i++){
                    //if the square NE of the bishop i squares has a piece
                    if(northEast[i].hasPiece){
                        //if its white its available
                        if(northEast[i].getPiece().getColor().equals("white")){
                            canTakeOrBlock(northEast[i], kingSquare, attackingPiece);
                            //pieces NE this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces NE this piece aren't available
                            break;
                        }
                    }
                    //if the square NE of the bishop i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(northEast[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(northWest != null){
                for(int  i = 0; i < northWest.length; i++){
                    //if the square NW of the bishop i squares has a piece
                    if(northWest[i].hasPiece){
                        //if its white its available
                        if(northWest[i].getPiece().getColor().equals("white")){
                            canTakeOrBlock(northWest[i], kingSquare, attackingPiece);
                            //pieces NW this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces NW this piece aren't available
                            break;
                        }
                    }
                    //if the square NW of the bishop i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(northWest[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(southEast != null) {
                for(int  i = 0; i < southEast.length; i++){
                    //if the square SE of the bishop i squares has a piece
                    if(southEast[i].hasPiece){
                        //if its white its available
                        if(southEast[i].getPiece().getColor().equals("white")){
                            canTakeOrBlock(southEast[i], kingSquare, attackingPiece);
                            //pieces SE of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces SE of this piece aren't available
                            break;
                        }
                    }
                    //if the square SE of the bishop i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(southEast[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(southWest != null){
                for(int  i = 0; i < southWest.length; i++){
                    //if the square SW of the bishop i squares has a piece
                    if(southWest[i].hasPiece){
                        //if its white its available
                        if(southWest[i].getPiece().getColor().equals("white")){
                            canTakeOrBlock(southWest[i], kingSquare, attackingPiece);
                            //pieces SW of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces SW of this piece aren't available
                            break;
                        }
                    }
                    //if the square SW of the bishop i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(southWest[i], kingSquare, attackingPiece);
                    }
                }
            }
        }
        //if the bishop is white
        else {
            if(northEast != null){
                for(int  i = 0; i < northEast.length; i++){
                    //if the square NE of the bishop i squares has a piece
                    if(northEast[i].hasPiece){
                        //if its black its available
                        if(northEast[i].getPiece().getColor().equals("black")){
                            canTakeOrBlock(northEast[i], kingSquare, attackingPiece);
                            //pieces NE this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces NE this piece aren't available
                            break;
                        }
                    }
                    //if the square NE of the bishop i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(northEast[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(northWest != null){
                for(int  i = 0; i < northWest.length; i++){
                    //if the square NW of the bishop i squares has a piece
                    if(northWest[i].hasPiece){
                        //if its black its available
                        if(northWest[i].getPiece().getColor().equals("black")){
                            canTakeOrBlock(northWest[i], kingSquare, attackingPiece);
                            //pieces NW this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces NW this piece aren't available
                            break;
                        }
                    }
                    //if the square NW of the bishop i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(northWest[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(southEast != null) {
                for(int  i = 0; i < southEast.length; i++){
                    //if the square SE of the bishop i squares has a piece
                    if(southEast[i].hasPiece){
                        //if its black its available
                        if(southEast[i].getPiece().getColor().equals("black")){
                            canTakeOrBlock(southEast[i], kingSquare, attackingPiece);
                            //pieces SE of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces SE of this piece aren't available
                            break;
                        }
                    }
                    //if the square SE of the bishop i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(southEast[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(southWest != null){
                for(int  i = 0; i < southWest.length; i++){
                    //if the square SW of the bishop i squares has a piece
                    if(southWest[i].hasPiece){
                        //if its black its available
                        if(southWest[i].getPiece().getColor().equals("black")){
                            canTakeOrBlock(southWest[i], kingSquare, attackingPiece);
                            //pieces SW of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces SW of this piece aren't available
                            break;
                        }
                    }
                    //if the square SW of the bishop i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(southWest[i], kingSquare, attackingPiece);
                    }
                }
            }
        }
    }

    public Square[] setNorthWest(){
        int i;
        if(currentSquare.getRank() == 8 || currentSquare.getFile() == 1)
            i = 0;
        else if(currentSquare.getRank() == 7 || currentSquare.getFile() == 2)
            i = 1;
        else if(currentSquare.getRank() == 6 || currentSquare.getFile() == 3)
            i = 2;
        else if(currentSquare.getRank() == 5 || currentSquare.getFile() == 4)
            i = 3;
        else if(currentSquare.getRank() == 4 || currentSquare.getFile() == 5)
            i = 4;
        else if(currentSquare.getRank() == 3 || currentSquare.getFile() == 6)
            i = 5;
        else if(currentSquare.getRank() == 2 || currentSquare.getFile() == 7)
            i = 6;
        else
            i = 7;
        return b.northWest(currentSquare, i);
    }
    
    public Square[] setNorthEast(){
        int i;
        if(currentSquare.getRank() == 8 || currentSquare.getFile() == 8)
                i = 0;
            else if(currentSquare.getRank() == 7 || currentSquare.getFile() == 7)
                i = 1;
            else if(currentSquare.getRank() == 6 || currentSquare.getFile() == 6)
                i = 2;
            else if(currentSquare.getRank() == 5 || currentSquare.getFile() == 5)
                i = 3;
            else if(currentSquare.getRank() == 4 || currentSquare.getFile() == 4)
                i = 4;
            else if(currentSquare.getRank() == 3 || currentSquare.getFile() == 3)
                i = 5;
            else if(currentSquare.getRank() == 2 || currentSquare.getFile() == 2)
                i = 6;
            else
                i = 7;
            return b.northEast(currentSquare, i);
    }
    
    public Square[] setSouthWest(){
        int i;
        if(currentSquare.getRank() == 1 || currentSquare.getFile() == 1)
                i = 0;
            else if(currentSquare.getRank() == 2 || currentSquare.getFile() == 2)
                i = 1;
            else if(currentSquare.getRank() == 3 || currentSquare.getFile() == 3)
                i = 2;
            else if(currentSquare.getRank() == 4 || currentSquare.getFile() == 4)
                i = 3;
            else if(currentSquare.getRank() == 5 || currentSquare.getFile() == 5)
                i = 4;
            else if(currentSquare.getRank() == 6 || currentSquare.getFile() == 6)
                i = 5;
            else if(currentSquare.getRank() == 7 || currentSquare.getFile() == 7)
                i = 6;
            else
                i = 7;
           return b.southWest(currentSquare, i);
    }
    
    public Square[] setSouthEast(){
        int i;
        if(currentSquare.getRank() == 1 || currentSquare.getFile() == 8)
                i = 0;
            else if(currentSquare.getRank() == 2 || currentSquare.getFile() == 7)
                i = 1;
            else if(currentSquare.getRank() == 3 || currentSquare.getFile() == 6)
                i = 2;
            else if(currentSquare.getRank() == 4 || currentSquare.getFile() == 5)
                i = 3;
            else if(currentSquare.getRank() == 5 || currentSquare.getFile() == 4)
                i = 4;
            else if(currentSquare.getRank() == 6 || currentSquare.getFile() == 3)
                i = 5;
            else if(currentSquare.getRank() == 7 || currentSquare.getFile() == 2)
                i = 6;
            else
                i = 7;
            return b.southEast(currentSquare, i);
    }
    
    
}
