/**
 *
 * @author Ian Bonafede
 */
package chess;


import javax.swing.ImageIcon;


public class Rook extends Piece{

    public Rook(String color, Board b, Square s, ImageIcon i) {
        super(color, b, s, i);
        pieceType = "rook";
    }

    @Override
    void setAvailableMoves() {
        availableMoves.clear();
        Square[] north = b.north(currentSquare, (8 - currentSquare.getRank()));
        Square[] south = b.south(currentSquare, currentSquare.getRank() - 1);
        Square[] east = b.east(currentSquare, (8 - currentSquare.getFile()));
        Square[] west = b.west(currentSquare, currentSquare.getFile() - 1);
        //if the rook is black
        if(color.equals("black")){
            
            if(north != null){
                for(int  i = 0; i < north.length; i++){
                    //if the square north of the rook i squares has a piece
                    if(north[i].hasPiece){
                        //if its white its available
                        if(north[i].getPiece().getColor().equals("white")){
                            availableMoves.add(north[i]);
                            //pieces above this piece aren't available
                            if(!north[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(north[i].getPiece().getColor().equals("black")){
                            north[i].getPiece().protect();
                            //pieces above this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces above this piece aren't available
                            if(!north[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square north of the rook i squares has no piece
                    else {
                        //its available
                        availableMoves.add(north[i]);
                    }
                }
            }
            if(south != null){
                for(int  i = 0; i < south.length; i++){
                    //if the square south of the rook i squares has a piece
                    if(south[i].hasPiece){
                        //if its white its available
                        if(south[i].getPiece().getColor().equals("white")){
                            availableMoves.add(south[i]);
                            //pieces below this piece aren't available
                            if(!south[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(south[i].getPiece().getColor().equals("black")){
                            south[i].getPiece().protect();
                            //pieces below this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces below this piece aren't available
                            if(!south[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square south of the rook i squares has no piece
                    else {
                        //its available
                        availableMoves.add(south[i]);
                    }
                }
            }
            if(east != null) {
                for(int  i = 0; i < east.length; i++){
                    //if the square east of the rook i squares has a piece
                    if(east[i].hasPiece){
                        //if its white its available
                        if(east[i].getPiece().getColor().equals("white")){
                            availableMoves.add(east[i]);
                            //pieces right of this piece aren't available
                            if(!east[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(east[i].getPiece().getColor().equals("black")){
                            east[i].getPiece().protect();
                            //pieces right of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces right of this piece aren't available
                            if(!east[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square east of the rook i squares has no piece
                    else {
                        //its available
                        availableMoves.add(east[i]);
                    }
                }
            }
            if(west != null){
                for(int  i = 0; i < west.length; i++){
                    //if the square west of the rook i squares has a piece
                    if(west[i].hasPiece){
                        //if its white its available
                        if(west[i].getPiece().getColor().equals("white")){
                            availableMoves.add(west[i]);
                            //pieces left of this piece aren't available
                            if(!west[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(west[i].getPiece().getColor().equals("black")){
                            west[i].getPiece().protect();
                            //pieces left of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces left of this piece aren't available
                            if(!west[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square west of the rook i squares has no piece
                    else {
                        //its available
                        availableMoves.add(west[i]);
                    }
                }
            }
        }
        //if the rook is white
        else {    
            if(north != null) {
                for(int  i = 0; i < north.length; i++){
                    //if the square north of the rook i squares has a piece
                    if(north[i].hasPiece){
                        //if its black its available
                        if(north[i].getPiece().getColor().equals("black")){
                            availableMoves.add(north[i]);
                            //pieces above this piece aren't available
                            if(!north[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(north[i].getPiece().getColor().equals("white")){
                            north[i].getPiece().protect();
                            //pieces above this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces above this piece aren't available
                            if(!north[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square north of the rook i squares has no piece
                    else {
                        //its available
                        availableMoves.add(north[i]);
                    }
                }
            }
            if(south != null){
                for(int  i = 0; i < south.length; i++){
                    //if the square south of the rook i squares has a piece
                    if(south[i].hasPiece){
                        //if its black its available
                        if(south[i].getPiece().getColor().equals("black")){
                            availableMoves.add(south[i]);
                            //pieces below this piece aren't available
                            if(!south[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(south[i].getPiece().getColor().equals("white")){
                            south[i].getPiece().protect();
                            //pieces below this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces below this piece aren't available
                            if(!south[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square south of the rook i squares has no piece
                    else {
                        //its available
                        availableMoves.add(south[i]);
                    }
                }
            }
            if(east != null){
                for(int  i = 0; i < east.length; i++){
                    //if the square east of the rook i squares has a piece
                    if(east[i].hasPiece){
                        //if its black its available
                        if(east[i].getPiece().getColor().equals("black")){
                            availableMoves.add(east[i]);
                            //pieces right of this piece aren't available
                            if(!east[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(east[i].getPiece().getColor().equals("white")){
                            east[i].getPiece().protect();
                            //pieces right of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces right of this piece aren't available
                            if(!east[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square east of the rook i squares has no piece
                    else {
                        //its available
                        availableMoves.add(east[i]);
                    }
                }
            }
            if(west != null){
                for(int  i = 0; i < west.length; i++){
                    //if the square west of the rook i squares has a piece
                    if(west[i].hasPiece){
                        //if its black its available
                        if(west[i].getPiece().getColor().equals("black")){
                            availableMoves.add(west[i]);
                            //pieces left of this piece aren't available
                            if(!west[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                        if(west[i].getPiece().getColor().equals("white")){
                            west[i].getPiece().protect();
                            //pieces left of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces left of this piece aren't available
                            if(!west[i].getPiece().getPieceType().equals("king"))
                                break;
                        }
                    }
                    //if the square west of the rook i squares has no piece
                    else {
                        //its available
                        availableMoves.add(west[i]);
                    }
                }
            }
        }
    }
    
    
    @Override
    void setAvailableMovesOne(Square kingSquare, Piece attackingPiece) {
        availableMoves.clear();
        Square[] north = b.north(currentSquare, (8 - currentSquare.getRank()));
        Square[] south = b.south(currentSquare, currentSquare.getRank() - 1);
        Square[] east = b.east(currentSquare, (8 - currentSquare.getFile()));
        Square[] west = b.west(currentSquare, currentSquare.getFile() - 1);
        //if the rook is black
        if(color.equals("black")){
            
            if(north != null){
                for(int  i = 0; i < north.length; i++){
                    //if the square north of the rook i squares has a piece
                    if(north[i].hasPiece){
                        //if its white its available
                        if(north[i].getPiece().getColor().equals("white")){
                            canTakeOrBlock(north[i], kingSquare, attackingPiece);
                            //pieces above this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces above this piece aren't available
                            break;
                        }
                    }
                    //if the square north of the rook i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(north[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(south != null){
                for(int  i = 0; i < south.length; i++){
                    //if the square south of the rook i squares has a piece
                    if(south[i].hasPiece){
                        //if its white its available
                        if(south[i].getPiece().getColor().equals("white")){
                            canTakeOrBlock(south[i], kingSquare, attackingPiece);
                            //pieces below this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces below this piece aren't available
                            break;
                        }
                    }
                    //if the square south of the rook i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(south[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(east != null) {
                for(int  i = 0; i < east.length; i++){
                    //if the square east of the rook i squares has a piece
                    if(east[i].hasPiece){
                        //if its white its available
                        if(east[i].getPiece().getColor().equals("white")){
                            canTakeOrBlock(east[i], kingSquare, attackingPiece);
                            //pieces right of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces right of this piece aren't available
                            break;
                        }
                    }
                    //if the square east of the rook i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(east[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(west != null){
                for(int  i = 0; i < west.length; i++){
                    //if the square west of the rook i squares has a piece
                    if(west[i].hasPiece){
                        //if its white its available
                        if(west[i].getPiece().getColor().equals("white")){
                            canTakeOrBlock(west[i], kingSquare, attackingPiece);
                            //pieces left of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces left of this piece aren't available
                            break;
                        }
                    }
                    //if the square west of the rook i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(west[i], kingSquare, attackingPiece);
                    }
                }
            }
        }
        //if the rook is white
        else {    
            if(north != null) {
                for(int  i = 0; i < north.length; i++){
                    //if the square north of the rook i squares has a piece
                    if(north[i].hasPiece){
                        //if its black its available
                        if(north[i].getPiece().getColor().equals("black")){
                            canTakeOrBlock(north[i], kingSquare, attackingPiece);
                            //pieces above this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces above this piece aren't available
                            break;
                        }
                    }
                    //if the square north of the rook i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(north[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(south != null){
                for(int  i = 0; i < south.length; i++){
                    //if the square south of the rook i squares has a piece
                    if(south[i].hasPiece){
                        //if its black its available
                        if(south[i].getPiece().getColor().equals("black")){
                            canTakeOrBlock(south[i], kingSquare, attackingPiece);
                            //pieces below this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces below this piece aren't available
                            break;
                        }
                    }
                    //if the square south of the rook i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(south[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(east != null){
                for(int  i = 0; i < east.length; i++){
                    //if the square east of the rook i squares has a piece
                    if(east[i].hasPiece){
                        //if its black its available
                        if(east[i].getPiece().getColor().equals("black")){
                            canTakeOrBlock(east[i], kingSquare, attackingPiece);
                            //pieces right of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces right of this piece aren't available
                            break;
                        }
                    }
                    //if the square east of the rook i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(east[i], kingSquare, attackingPiece);
                    }
                }
            }
            if(west != null){
                for(int  i = 0; i < west.length; i++){
                    //if the square west of the rook i squares has a piece
                    if(west[i].hasPiece){
                        //if its black its available
                        if(west[i].getPiece().getColor().equals("black")){
                            canTakeOrBlock(west[i], kingSquare, attackingPiece);
                            //pieces left of this piece aren't available
                            break;
                        }
                        //if its not its not available
                        else {
                            //pieces left of this piece aren't available
                            break;
                        }
                    }
                    //if the square west of the rook i squares has no piece
                    else {
                        //its available
                        canTakeOrBlock(west[i], kingSquare, attackingPiece);
                    }
                }
            }
        }
    }
    
    
}
