/**
 *
 * @author Ian Bonafede
 */
package chess;

import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;


abstract class Piece {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final int D = 4;
    public static final int E = 5;
    public static final int F = 6;
    public static final int G = 7;
    public static final int H = 8;
    private ImageIcon image;
    protected ArrayList<Square> availableMoves;
    protected int moveCount;
    protected String color;
    protected String pieceType;
    protected Board b;
    protected Square currentSquare;
    private boolean taken;
    private boolean isProtected;
    
    public Piece(String color, Board b, Square s, ImageIcon i) {
        
        isProtected = false;
        taken = false;
        moveCount = 0;
        this.b = b;
        currentSquare = s;
        currentSquare.setPiece(this);
        this.color = color;
        availableMoves = new ArrayList();
        setAvailableMoves();
        
        image = i;
    }
    
    public void reset(Square s) {
        isProtected = false;
        taken = false;
        moveCount = 0;
        currentSquare = s;
        currentSquare.setPiece(this);
        availableMoves = new ArrayList();
    }
   
    public void setImage(ImageIcon i) {
        image = i;
    }
    
    public void protect() {
        isProtected = true;
    }
    public void unProtect() {
        isProtected = false;
    }
    
    public boolean isProtected() {
        return isProtected;
    }
    
    public String getPieceType(){
        return pieceType;
    }
    
    abstract void setAvailableMoves();
    
    abstract void setAvailableMovesOne(Square kingSquare, Piece attackingPiece);
    
    public void canTakeOrBlock(Square moveSquare, Square kingSquare, Piece attackingPiece) {
        //taking or blocking, add it
        if(moveSquare == attackingPiece.currentSquare || blocks(moveSquare, kingSquare, attackingPiece)) {
            availableMoves.add(moveSquare);
        }
    }
    
    public boolean blocks(Square moveSquare, Square kingSquare, Piece attackingPiece) {
        if(attackingPiece.getPieceType().equals("knight")){
            return false;
        }
        Square attackingSquare = attackingPiece.currentSquare;
        //if the king and piece are on the same file  (N or S)
        if(kingSquare.getFile() == attackingSquare.getFile()){
            //if the king is south of the attacking piece
            if(kingSquare.getRank() < attackingSquare.getRank()){
                //if the square is blocking the check
                if(moveSquare.getRank() > kingSquare.getRank() && moveSquare.getRank() < attackingSquare.getRank()){
                    return true;
                }
            } 
            else {
                if(moveSquare.getRank() < kingSquare.getRank() && moveSquare.getRank() > attackingSquare.getRank()){
                    return true;
                }
            }
        }
        //if the king and piece are on the same rank  (E or W)
        if(kingSquare.getRank() == attackingSquare.getRank()){
            //if the king is W of the attacking piece
            if(kingSquare.getFile() < attackingSquare.getFile()){
                //if the square is blocking the check
                if(moveSquare.getFile() > kingSquare.getFile() && moveSquare.getFile() < attackingSquare.getFile()){
                    return true;
                }
            } 
            else {
                if(moveSquare.getFile() < kingSquare.getFile() && moveSquare.getFile() > attackingSquare.getFile()){
                    return true;
                }
            }
        }        
        //if they are on the same diagonal going from northeast to southwest
        if((kingSquare.getFile() - attackingSquare.getFile()) == (kingSquare.getRank() - attackingSquare.getRank())){
            //attacking piece is SW
            if((kingSquare.getFile() - attackingSquare.getFile()) > 0) {
                //test if moveSquare is on same diagonal
                if((kingSquare.getFile() - moveSquare.getFile()) == (kingSquare.getRank() - moveSquare.getRank())){
                    //if blocking square is SW of king
                    if((kingSquare.getFile() - moveSquare.getFile()) > 0){
                        //if blocking square is NE of attacking piece
                        if((moveSquare.getFile() - attackingSquare.getFile()) > 0){
                            return true;
                        }
                    }
                }
            }
            else {
                //test if moveSquare is on same diagonal
                if((kingSquare.getFile() - moveSquare.getFile()) == (kingSquare.getRank() - moveSquare.getRank())){
                    //if blocking square is NE of king
                    if((kingSquare.getFile() - moveSquare.getFile()) < 0){
                        //if blocking square is SW of attacking piece
                        if((moveSquare.getFile() - attackingSquare.getFile()) < 0){
                            return true;
                        }
                    }
                }
            }
        }
        
        //if they are on the same diagonal going from northwest to southeast
        if(-(kingSquare.getFile() - attackingSquare.getFile()) == (kingSquare.getRank() - attackingSquare.getRank())){
            //attacking piece is NW
            if((kingSquare.getFile() - attackingSquare.getFile()) > 0) {
                //test if moveSquare is on same diagonal
                if(-(kingSquare.getFile() - moveSquare.getFile()) == (kingSquare.getRank() - moveSquare.getRank())){
                    //if blocking square is NW of king
                    if((kingSquare.getFile() - moveSquare.getFile()) > 0){
                        //if blocking square is SE of attacking piece
                        if((moveSquare.getFile() - attackingSquare.getFile()) > 0){
                            return true;
                        }
                    }
                }
            }
            else {
                //test if moveSquare is on same diagonal
                if(-(kingSquare.getFile() - moveSquare.getFile()) == (kingSquare.getRank() - moveSquare.getRank())){
                    //if blocking square is SE of king
                    if((kingSquare.getFile() - moveSquare.getFile()) < 0){
                        //if blocking square is NW of attacking piece
                        if((moveSquare.getFile() - attackingSquare.getFile()) < 0){
                            return true;
                        }
                    }
                }
            }
        }
        
        
        return false;
    }
    
    void paintPiece(Canvas c, Graphics2D g2, int w) {
       
        
        if(currentSquare != null)
            g2.drawImage(image.getImage(), w*(currentSquare.getFile()-1), w*(8-currentSquare.getRank()) , w, w, null);
        
    }
    
    public void move(Square s){
        currentSquare = s;
        moveCount++;
    }
    public String getColor(){
        return color;
    }
    
    public void captured(){
        currentSquare = null;
        availableMoves.clear();
    }
    
    
    public ArrayList<Square> getAvailableMoves() {
        return availableMoves;
    }
    
    public void takePiece() {
        taken = true;
    }
    
    public boolean taken() {
        return taken;
    }
    
    public int getMoveCount() {
        return moveCount;
    }
    
    
}
