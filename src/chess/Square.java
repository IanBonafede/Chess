/**
 *
 * @author Ian Bonafede
 */
package chess;

import java.awt.Color;
import java.awt.Rectangle;


public class Square {
    private Color color;
    private Piece currentPiece;
    private int rank;
    private int file;
    private Rectangle rectangle;
    boolean hasPiece;
    boolean hasKing;
    
    
    
    //Ctors
    public Square(int f, int r, Color col){
        file = f;
        rank = r;
        hasPiece = false;
        currentPiece = null;
        color = col;
    }    
    
    //setters
    public void removePiece(){
        currentPiece = null;
        hasPiece = false;
    }
    void setPiece(Piece p){
        //if no piece was on this square
        if(currentPiece == null){
            currentPiece = p;
            //add graphic of the Piece p to the canvas
            hasPiece = true;
        }
        //if a piece was on this square
        else{
            //remove graphic of Piece currentPiece from canvas
            System.out.println("Captured Piece");
            currentPiece.captured();
            currentPiece = p;
            //add graphic of Piece p to the canvas
            hasPiece = true;
        }
    }
    

    public void setRectangle(Rectangle r){
        rectangle = r;
    }
    
    //getters
    public int getRank(){
        return rank;
    }
    
    public char getFileChar() {
        switch (file) {
            case 1: return 'A';
            case 2: return 'B';
            case 3: return 'C';
            case 4: return 'D';
            case 5: return 'E';
            case 6: return 'F';
            case 7: return 'G';
            case 8: return 'H';
            
        }
        return 'Z';
    }
    
    public int getFile(){
        return file;
    }
    public Piece getPiece(){
        return currentPiece;
    }
    public Rectangle getRectangle(){
        return rectangle;
    }
    
    
    public Color getColor() {
        return color;
    }
    
    
    
    
}
