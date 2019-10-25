/**
 *
 * @author Ian Bonafede
 */
package chess;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import javax.swing.JPanel;


public class Canvas extends JPanel {
    Board myBoard;
    Square[][] mySquares;
    Rectangle[] rectangles = new Rectangle[64];
    Color squareColor;
    Random seed = new Random(); 
    ArrayList<Piece> myPieces;
    boolean isPieceSelected;
    Piece pieceSelected;
    Chess chess;
    Color darkSquareColor, highlightedSquareColor;
    
    String moveList;
    
    String prevMove;
    
    
    public Canvas(Board b, ArrayList<Piece> p, Chess c){
        myBoard = b;
        mySquares = b.getSquares();
        myPieces = p;
        chess = c;
        
        darkSquareColor = Color.LIGHT_GRAY;
        highlightedSquareColor = Color.BLUE;
        
        moveList = "";
        prevMove = "";
    }
    
    public Dimension getPreferredSize() {
        return new Dimension( myBoard.SQUARE_WIDTH*8, myBoard.SQUARE_WIDTH*8);
    }
    
    public void reset() {
        pieceSelected = null;
        isPieceSelected = false;
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                mySquares[i][j].removePiece();
            }
        }
        
        moveList = "";
    }
    
    
    public void setSquareColor() {
        JColorChooser chooser = new JColorChooser();
                int option = JOptionPane.showConfirmDialog(null, chooser, "chooser", JOptionPane.OK_CANCEL_OPTION);
                if (option == 0)
                    darkSquareColor = chooser.getColor();
                repaint();
    }
    
    public void setHighlightColor() {
        JColorChooser chooser = new JColorChooser();
                int option = JOptionPane.showConfirmDialog(null, chooser, "chooser", JOptionPane.OK_CANCEL_OPTION);
                if (option == 0)
                    highlightedSquareColor = chooser.getColor();
                repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.black);
        
        //draw all squares
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
               rectangles[i*8 + j] = mySquares[i][j].getRectangle(); 
               
               if(mySquares[i][j].getColor() == Color.white)
                   g2d.setColor(Color.white);
               else
                   g2d.setColor(darkSquareColor);
               
               
                g2d.fill(rectangles[i*8 + j]);
               
            }
        }
        //draw all pieces
        for(int i = 0; i < myPieces.size(); i++) {
            if(!myPieces.get(i).taken())
                myPieces.get(i).paintPiece(this, g2d, myBoard.SQUARE_WIDTH);
        }
        
        //draw moves
        if(isPieceSelected) {
            for(int i = 0; i < pieceSelected.getAvailableMoves().size(); i++) {
                showMove(pieceSelected.getAvailableMoves().get(i), g2d); 
            }
        }
            
            
        
    }
    
    public void showMove(Square s, Graphics2D g2d) {
        
        g2d.setColor(highlightedSquareColor);
        
        Ellipse2D cirlce = new Ellipse2D.Double( myBoard.SQUARE_WIDTH*(s.getFile()-1) + myBoard.SQUARE_WIDTH/3, myBoard.SQUARE_WIDTH*(8-s.getRank())+ myBoard.SQUARE_WIDTH/3, myBoard.SQUARE_WIDTH/3, myBoard.SQUARE_WIDTH/3);
        g2d.fill(cirlce);
        
        g2d.draw(cirlce);
    }
    
    
    
    public void setSelectedPiece(Piece p) {
        pieceSelected = p;
    }
    
    public void clickLogic(Point p) {
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                //find the square
                if(mySquares[i][j].getRectangle().contains(p)) {
                    
                    
                    //if no piece has been seleceted, set this piece to be selected
                    if(!isPieceSelected){
                        if(isCorrectColor(i, j)) {
                            System.out.println("piece selected");
                            pieceSelected = mySquares[i][j].getPiece();
                            isPieceSelected = true;
                        }
                    }
                        
                        
                    //if a piece has been selected already
                     else {
                        
                        //check to see if the square is ok for a piece to move there
                        if(checkSquareAvailability(mySquares[i][j])){
                                movePieceToNewSquare(i, j);
                        }
                        
                        else {
                            //stop showing available moves (maybe a cancel() funtion?
                            System.out.println("piece deselected");
                            pieceSelected = null;
                            isPieceSelected = false;
                            //if another piece is selected
                            if(isCorrectColor(i, j)) {
                                System.out.println("piece selected");
                                pieceSelected = mySquares[i][j].getPiece();
                                //pieceSelected.setAvailableMoves();
                                isPieceSelected = true;
                            }
                        }
                    }
                }
            }  
        }
        
    }
    
    public void movePieceToNewSquare(int i, int j) {
        
        
        
        if(pieceSelected.getPieceType().compareTo("king") == 0 && pieceSelected.moveCount == 0) {
            if(i == 0) {
                //if black
                if(j == 2) {
                    //move black left rook
                    mySquares[0][3].setPiece(mySquares[0][0].getPiece());
                    mySquares[0][0].getPiece().move(mySquares[0][3]);
                    mySquares[0][0].removePiece();
                }
                if(j == 6) {
                    //move black right rook
                    mySquares[0][5].setPiece(mySquares[0][7].getPiece());
                    mySquares[0][7].getPiece().move(mySquares[0][5]);
                    mySquares[0][7].removePiece();
                }
            }
             if(i == 7) {
                 //if white
                if(j == 2) {
                    //move white left rook
                    mySquares[7][3].setPiece(mySquares[7][0].getPiece());
                    mySquares[7][0].getPiece().move(mySquares[7][3]);
                    mySquares[7][0].removePiece();
                }
                if(j == 6) {
                    //move white right rook
                    mySquares[7][5].setPiece(mySquares[7][7].getPiece());
                    mySquares[7][7].getPiece().move(mySquares[7][5]);
                    mySquares[7][7].removePiece();
                }
            }
        }
        
        
        
        if(pieceSelected.getPieceType().equals("pawn") ) {
                if(pieceSelected.getColor().equals("white")) {
                    if(pieceSelected.currentSquare.getRank() == 5) {
                        if(j == pieceSelected.currentSquare.getFile() - 2 && !myBoard.getSquare(2, pieceSelected.currentSquare.getFile() - 2).hasPiece) {
                            myBoard.getSquare(3, pieceSelected.currentSquare.getFile() - 2).getPiece().captured();
                            myBoard.getSquare(3, pieceSelected.currentSquare.getFile() - 2).removePiece();
                        }
                        if(j == pieceSelected.currentSquare.getFile() && !myBoard.getSquare(2, pieceSelected.currentSquare.getFile() ).hasPiece) {
                            myBoard.getSquare(3, pieceSelected.currentSquare.getFile() ).getPiece().captured();
                            myBoard.getSquare(3, pieceSelected.currentSquare.getFile() ).removePiece();
                        }
                    }
                }
                if(pieceSelected.getColor().equals("black")) {
                    if(pieceSelected.currentSquare.getRank() == 4) {
                        if(j == pieceSelected.currentSquare.getFile() - 2 && !myBoard.getSquare(5, pieceSelected.currentSquare.getFile() - 2).hasPiece) {
                            myBoard.getSquare(4, pieceSelected.currentSquare.getFile() - 2).getPiece().captured();
                            myBoard.getSquare(4, pieceSelected.currentSquare.getFile() - 2).removePiece();
                        }
                        if(j == pieceSelected.currentSquare.getFile() && !myBoard.getSquare(5, pieceSelected.currentSquare.getFile() ).hasPiece) {
                            myBoard.getSquare(4, pieceSelected.currentSquare.getFile() ).getPiece().captured();
                            myBoard.getSquare(4, pieceSelected.currentSquare.getFile() ).removePiece();
                        }
                    }
                }
            }
        
        
        prevMove = pieceSelected.getPieceType() + pieceSelected.currentSquare.getFile() + pieceSelected.currentSquare.getRank() + ",";
        
        
        //remove piece from its original square
        pieceSelected.currentSquare.removePiece();
                            
        //change square of piece to new square
        pieceSelected.move(mySquares[i][j]);
                            
        //add piece to new square
        mySquares[i][j].setPiece(pieceSelected);
        
        prevMove = prevMove + pieceSelected.getPieceType() + pieceSelected.currentSquare.getFile() + pieceSelected.currentSquare.getRank();
        
        
        
        System.out.println(pieceSelected.getPieceType() + pieceSelected.currentSquare.getFileChar() + pieceSelected.currentSquare.getRank() + "\n");
        System.out.println(prevMove);
        
        
        moveList = moveList + pieceSelected.getPieceType() + pieceSelected.currentSquare.getFileChar() + pieceSelected.currentSquare.getRank() + "\n";
        
        chess.turnOver();
        pieceSelected = null;
        isPieceSelected = false;
    }
    
    public boolean isCorrectColor(int i, int j) {
        if(chess.getTurnFlag()){
            if(mySquares[i][j].hasPiece) {
                if(mySquares[i][j].getPiece().getColor().equals("white")){
                    
                    return true;
                    
                }
            }
        }
        if(!chess.getTurnFlag()){
            if(mySquares[i][j].hasPiece) {
                if(mySquares[i][j].getPiece().getColor().equals("black")) {
                    
                   return true;
                }
            }
        }
        
            return false;
    }
    
    
    
    
    
    public boolean checkSquareAvailability(Square s){
        for(int i = 0; i < pieceSelected.getAvailableMoves().size(); i++){
            if(pieceSelected.getAvailableMoves().get(i) == s){
                return true;
            }
        }
        return false;
    }
    
}

