/**
 *
 * @author Ian Bonafede
 */
package chess;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;


public class Board {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final int D = 4;
    public static final int E = 5;
    public static final int F = 6;
    public static final int G = 7;
    public static final int H = 8;
    public static final int SQUARE_WIDTH = 100;
    
    private Square[][] squares;
    
    public Board(){
        squares = new Square[8][8];
        int k = 0;
        for(int r = 0; r < 8; r++) {
            for(int f = 0; f < 8; f++) {
                if((f+r)%2 == 0)
                    squares[r][f] = new Square(f+1, 8-r, Color.WHITE);
                else
                    squares[r][f] = new Square(f+1, 8-r, Color.LIGHT_GRAY);
                
               squares[r][f].setRectangle(new Rectangle(SQUARE_WIDTH*f, SQUARE_WIDTH*r, SQUARE_WIDTH, SQUARE_WIDTH));
            }
        } 
    }
    
    public Square getSquare(int r, int f) {
        
        return squares[r][f];
        
    }
    
    public Square[][] getSquares(){
        return squares;
    }
    
    //(8 - rank) is equal to the first index of squares[][]
    //(file - 1) is equal to the second index of squares[][]
    //if equations below aren't simplified below its most likely
    //due to the above, i left all instances of these formulas
    //intact for simplicity
    
    public Square[] north(Square s, int j){
        int r = s.getRank();
        if(r == 8 || j == 0)
            return null;
        int f = s.getFile();
        Square[] sArray = new Square[j];
        for(int i = 0; i < sArray.length; i++){
            sArray[i] = squares[(8 - r) - (i + 1)][f - 1];
        }
        return sArray;
    }
    public Square[] south(Square s, int j){
        int r = s.getRank();
        if(r == 1 || j == 0)
            return null;
        int f = s.getFile();
        Square[] sArray = new Square[j];
        for(int i = 0; i < sArray.length; i++){
            sArray[i] = squares[(8 - r) + (i + 1)][f - 1];
        }
        return sArray;
    }
    public Square[] east(Square s, int j){
        int r = s.getRank();
        int f = s.getFile();
        if(f == H || j == 0)
            return null;
        Square[] sArray = new Square[j];
        for(int i = 0; i < sArray.length; i++){
            sArray[i] = squares[8 - r][(f - 1) + (i + 1)];
        }
        return sArray;
    }
    public Square[] west(Square s, int j){
        int r = s.getRank();
        int f = s.getFile();
        if(f == A || j == 0)
            return null;
        Square[] sArray = new Square[j];
        for(int i = 0; i < sArray.length; i++){
            sArray[i] = squares[8 - r][(f - 1) - (i + 1)];
        }
        return sArray;
    }
    public Square[] northEast(Square s, int j){
        int r = s.getRank();
        int f = s.getFile();
        if(j == 0)
            return null;
        Square[] sArray = new Square[j];
        for(int i = 0; i < sArray.length; i++){
            sArray[i] = squares[(8 - r) - (i + 1)][(f - 1) + (i + 1)];
        }
        return sArray;
    }
    public Square[] northWest(Square s, int j){
        int r = s.getRank();
        int f = s.getFile();
        if(j == 0)
            return null;
        Square[] sArray = new Square[j];
        for(int i = 0; i < sArray.length; i++){
            sArray[i] = squares[(8 - r) - (i + 1)][(f - 1) - (i + 1)];
        }
        return sArray;
    }
    public Square[] southWest(Square s, int j){
        int r = s.getRank();
        int f = s.getFile();
        if(j == 0)
            return null;
        Square[] sArray = new Square[j];
        for(int i = 0; i < sArray.length; i++){
            sArray[i] = squares[(8 - r) + (i + 1)][(f - 1) - (i + 1)];
        }
        return sArray;
    }
    public Square[] southEast(Square s, int j){
        int r = s.getRank();
        int f = s.getFile();
        if(j == 0)
            return null;
        Square[] sArray = new Square[j];
        for(int i = 0; i < sArray.length; i++){
            sArray[i] = squares[(8 - r) + (i + 1)][(f - 1) + (i + 1)];
        }
        return sArray;
    }
    
    public ArrayList knightMoves(Square s){
        ArrayList<Square> sArray = new ArrayList();
        int r = s.getRank();
        int f = s.getFile();
        if(8 - r >= 2 && 8 - f >= 1){
            sArray.add(squares[(8 - r) - 2][(f - 1) + 1]);
        }
        if(8 - r >= 1 && 8 - f >= 2){
            sArray.add(squares[(8 - r) - 1][(f - 1) + 2]);
        }
        if(r >= 2 && 8 - f >= 2){
            sArray.add(squares[(8 - r) + 1][(f - 1) + 2]);
        }
        if(r >= 3 && 8 - f >= 1){
            sArray.add(squares[(8 - r) + 2][(f - 1) + 1]);
        }
        if(r >= 3 && f >= 2){
            sArray.add(squares[(8 - r) + 2][(f - 1) - 1]);
        }
        if(r >= 2 && f >= 3){
            sArray.add(squares[(8 - r) + 1][(f - 1) - 2]);
        }
        if(8 - r >= 1 && f >= 3){
            sArray.add(squares[(8 - r) - 1][(f - 1) - 2]);
        }
        if(8 - r >= 2 && f >= 2){
            sArray.add(squares[(8 - r) - 2][(f - 1) - 1]);
        }
        return sArray;
    }
}
