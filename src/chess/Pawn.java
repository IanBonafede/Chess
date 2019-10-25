/**
 *
 * @author Ian Bonafede
 */
package chess;

import javax.swing.ImageIcon;


public class Pawn extends Piece{

    public Pawn(String color, Board b, Square s, ImageIcon i) {
        super(color, b, s, i);
        pieceType = "pawn";
    }

    @Override
    void setAvailableMoves() {
        availableMoves.clear();
        
        if(color.equals("black")){
            Square[] south;
            //if the piece SE or SW is white, it is available to this Pawn
            if(currentSquare.getFile() != H){
                Square[] southEast = b.southEast(currentSquare, 1);
                if(southEast[0].hasPiece) {
                    if(southEast[0].getPiece().getColor().equals("white")) 
                        availableMoves.add(southEast[0]);
                    if(southEast[0].getPiece().getColor().equals("black")) 
                        southEast[0].getPiece().protect();
                }
            }
            
            if(currentSquare.getFile() != A){
                Square[] southWest = b.southWest(currentSquare, 1);
                if(southWest[0].hasPiece) {
                    if(southWest[0].getPiece().getColor().equals("white"))
                        availableMoves.add(southWest[0]);
                    if(southWest[0].getPiece().getColor().equals("black"))
                        southWest[0].getPiece().protect();
                }
            }
            //if the pawn hasnt moved, it can move south 2 squares
            if(moveCount == 0)
                south = b.south(currentSquare, 2);
            else
                south = b.south(currentSquare, 1);
            
            //if there is no piece blocking the pawn, it is an available square
            for(int i = 0; i < south.length; i++){
                if(!south[i].hasPiece)
                    availableMoves.add(south[i]);
                else
                    break;
            }
        }
        else{
            Square[] north;
            if(currentSquare.getFile() != H){
                Square[] northEast = b.northEast(currentSquare, 1);
                if(northEast[0].hasPiece) {
                    if(northEast[0].getPiece().getColor().equals("black"))
                        availableMoves.add(northEast[0]);
                    if(northEast[0].getPiece().getColor().equals("white"))
                        northEast[0].getPiece().protect();
                }
            }
            if(currentSquare.getFile() != A) {
                Square[] northWest = b.northWest(currentSquare, 1);
                if(northWest[0].hasPiece){
                    if(northWest[0].getPiece().getColor().equals("black"))
                        availableMoves.add(northWest[0]);
                    if(northWest[0].getPiece().getColor().equals("white"))
                        northWest[0].getPiece().protect();
                }
            }
            
            if(moveCount == 0)
                north = b.north(currentSquare, 2);
            else
                north = b.north(currentSquare, 1);
            
            for(int i = 0; i < north.length; i++){
                if(!north[i].hasPiece)
                    availableMoves.add(north[i]);
                else
                    break;
            }
        }
    }
    
    @Override
    void setAvailableMovesOne(Square kingSquare, Piece attackingPiece) {
        availableMoves.clear();
        if(color.equals("black")){
            Square[] south;
            //if the piece SE or SW is white, it is available to this Pawn
            if(currentSquare.getFile() != H){
                Square[] southEast = b.southEast(currentSquare, 1);
                if(southEast[0].hasPiece) {
                    canTakeOrBlock(southEast[0], kingSquare, attackingPiece);
                }
            }
            
            if(currentSquare.getFile() != A){
                Square[] southWest = b.southWest(currentSquare, 1);
                if(southWest[0].hasPiece) {
                    if(southWest[0].getPiece().getColor().equals("white")) {
                        canTakeOrBlock(southWest[0], kingSquare, attackingPiece);
                    }
                }
            }
            //if the pawn hasnt moved, it can move south 2 squares
            if(moveCount == 0)
                south = b.south(currentSquare, 2);
            else
                south = b.south(currentSquare, 1);
            
            //if there is no piece blocking the pawn, it is an available square
            for(int i = 0; i < south.length; i++){
                if(!south[i].hasPiece) {
                    canTakeOrBlock(south[i], kingSquare, attackingPiece);
                }
                else
                    break;
            }
        }
        else{
            Square[] north;
            if(currentSquare.getFile() != H){
                Square[] northEast = b.northEast(currentSquare, 1);
                if(northEast[0].hasPiece) {
                    if(northEast[0].getPiece().getColor().equals("black")){
                        canTakeOrBlock(northEast[0], kingSquare, attackingPiece);
                        
                    }
                }
            }
            if(currentSquare.getFile() != A) {
                Square[] northWest = b.northWest(currentSquare, 1);
                if(northWest[0].hasPiece){
                    if(northWest[0].getPiece().getColor().equals("black")){
                        canTakeOrBlock(northWest[0], kingSquare, attackingPiece);
                    }
                }
            }
            
            if(moveCount == 0)
                north = b.north(currentSquare, 2);
            else
                north = b.north(currentSquare, 1);
            
            for(int i = 0; i < north.length; i++){
                if(!north[i].hasPiece){
                    canTakeOrBlock(north[i], kingSquare, attackingPiece);
                }
                        
                else
                    break;
            }
        }
    }
}
