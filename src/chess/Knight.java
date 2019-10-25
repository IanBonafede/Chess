/**
 *
 * @author Ian Bonafede
 */
package chess;


import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Knight extends Piece{

    public Knight(String color, Board b, Square s, ImageIcon i) {
        super(color, b, s, i);
        pieceType = "knight";
    }

    @Override
    void setAvailableMoves() {
        availableMoves.clear();
        int r = currentSquare.getRank();
        int f = currentSquare.getFile();
        ArrayList<Square> knightMoves = b.knightMoves(currentSquare);
        
        if(color.equals("black")){
            for(int i = 0; i < knightMoves.size(); i++){
                //if the square has a piece
                if(knightMoves.get(i).hasPiece){
                    //if its a white piece
                    if(knightMoves.get(i).getPiece().getColor().equals("white"))
                        //its available
                        availableMoves.add(knightMoves.get(i)); 
                    if(knightMoves.get(i).getPiece().getColor().equals("black"))
                        //protect it
                        knightMoves.get(i).getPiece().protect();
                }
                //if the square doesnt have a piece
                else
                    //its available
                    availableMoves.add(knightMoves.get(i));
            }
        }
        //if the knight is white
        else{
            for(int i = 0; i < knightMoves.size(); i++){
                //if the square has a piece
                if(knightMoves.get(i).hasPiece){
                    //if its a black piece
                    if(knightMoves.get(i).getPiece().getColor().equals("black"))
                        //its available
                        availableMoves.add(knightMoves.get(i)); 
                    if(knightMoves.get(i).getPiece().getColor().equals("white"))
                        //its available
                        knightMoves.get(i).getPiece().protect();
                }
                //if the square doesnt have a piece
                else
                    //its available
                    availableMoves.add(knightMoves.get(i));
            }
        }
    }
    
    @Override
    void setAvailableMovesOne(Square kingSquare, Piece attackingPiece) {
        availableMoves.clear();
        int r = currentSquare.getRank();
        int f = currentSquare.getFile();
        ArrayList<Square> knightMoves = b.knightMoves(currentSquare);
        
        if(color.equals("black")){
            for(int i = 0; i < knightMoves.size(); i++){
                //if the square has a piece
                if(knightMoves.get(i).hasPiece){
                    //if its a white piece
                    if(knightMoves.get(i).getPiece().getColor().equals("white"))
                        //its available
                        canTakeOrBlock(knightMoves.get(i), kingSquare, attackingPiece);
                }
                //if the square doesnt have a piece
                else
                    //its available
                    canTakeOrBlock(knightMoves.get(i), kingSquare, attackingPiece);
            }
        }
        //if the knight is white
        else{
            for(int i = 0; i < knightMoves.size(); i++){
                //if the square has a piece
                if(knightMoves.get(i).hasPiece){
                    //if its a black piece
                    if(knightMoves.get(i).getPiece().getColor().equals("black"))
                        //its available
                        canTakeOrBlock(knightMoves.get(i), kingSquare, attackingPiece);
                }
                //if the square doesnt have a piece
                else
                    //its available
                    canTakeOrBlock(knightMoves.get(i), kingSquare, attackingPiece);
            }
        }
    }
    

}
