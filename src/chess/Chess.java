/**
 *
 * @author Ian Bonafede
 */
package chess;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class Chess extends JFrame{

    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final int D = 4;
    public static final int E = 5;
    public static final int F = 6;
    public static final int G = 7;
    public static final int H = 8;
    public Board board;
    private boolean turnFlag = true;
    
    private JMenuBar menuBar;
    private JMenu fMenu;
    private JMenu OMenu;
    private JMenuItem newGameItem;
    private JMenuItem changeColorOfDarkSquaresItem;
    private JMenuItem changeColorOfHighlightedSquaresItem;
    
    
    
    
    SquareSelector selector;
    ArrayList<Piece> pieces;
    ArrayList<Square> whiteAvailableMoves;
    ArrayList<Square> blackAvailableMoves;
    
    King whiteKing, blackKing;
    Rook leftBlackRook, rightBlackRook, leftWhiteRook, rightWhiteRook;
    Bishop leftWhiteBishop, rightWhiteBishop, leftBlackBishop, rightBlackBishop;
    Knight rightBlackKnight, leftBlackKnight, leftWhiteKnight, rightWhiteKnight;
    Queen whiteQueen, blackQueen;
    
    Piece attackingPiece;
    int checkCount;
    
    ImageIcon wPawn, wBishop, wKnight, wRook, wQueen, wKing,
              bPawn, bBishop, bKnight, bRook, bQueen, bKing;
    
    Canvas mydraw;
    
    
    public Chess(){
        
        
        
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        fMenu = new JMenu("File");
        menuBar.add(fMenu);
        
        newGameItem = new JMenuItem("New Game");
        fMenu.add(newGameItem);
        newGameItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                newGame();
            }
        });
        
        
        OMenu = new JMenu("Options");
        menuBar.add(OMenu);
        
        changeColorOfDarkSquaresItem = new JMenuItem("Change Color of Dark Squares");
        OMenu.add(changeColorOfDarkSquaresItem);
        changeColorOfDarkSquaresItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mydraw.setSquareColor();
            }
        });
        
        changeColorOfHighlightedSquaresItem = new JMenuItem("Change Color of Highlighted Squares");
        OMenu.add(changeColorOfHighlightedSquaresItem);
        changeColorOfHighlightedSquaresItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mydraw.setHighlightColor();
            }
        });
        
        
        wPawn = new ImageIcon("PiecesPngs//WPawn.PNG");
        bPawn = new ImageIcon("PiecesPngs//BPawn.PNG");
        
        wBishop = new ImageIcon("PiecesPngs//WBishop.PNG");
        bBishop = new ImageIcon("PiecesPngs//BBishop.PNG");
        
        wKnight = new ImageIcon("PiecesPngs//WKnight.PNG");
        bKnight = new ImageIcon("PiecesPngs//BKnight.PNG");
        
        wRook = new ImageIcon("PiecesPngs//WRook.PNG");
        bRook = new ImageIcon("PiecesPngs//BRook.PNG");
        
        wQueen = new ImageIcon("PiecesPngs//WQueen.PNG");
        bQueen = new ImageIcon("PiecesPngs//BQueen.PNG");
        
        wKing = new ImageIcon("PiecesPngs//WKing.PNG");
        bKing = new ImageIcon("PiecesPngs//BKing.PNG");
        
        pieces = new ArrayList();
        whiteAvailableMoves = new ArrayList();
        blackAvailableMoves = new ArrayList();
        
        board = new Board();
        
        
        pieces.clear();
        whiteAvailableMoves.clear();
        blackAvailableMoves.clear();
        
        for(int i = 0; i < 8; i++) {
            pieces.add(new Pawn("white", board, board.getSquares()[6][i], wPawn));
            pieces.add(new Pawn("black", board, board.getSquares()[1][i], bPawn));
        }
        
        leftWhiteRook = new Rook("white", board, board.getSquares()[7][0], wRook);
        rightWhiteRook = new Rook("white", board, board.getSquares()[7][7], wRook);
        
        pieces.add(leftWhiteRook);
        pieces.add(rightWhiteRook);
        
        leftBlackRook = new Rook("black", board, board.getSquares()[0][0], bRook);
        rightBlackRook = new Rook("black", board, board.getSquares()[0][7], bRook);
        
        pieces.add(leftBlackRook);
        pieces.add(rightBlackRook);
        
        leftWhiteBishop = new Bishop("white", board, board.getSquares()[7][2], wBishop);
        rightWhiteBishop = new Bishop("white", board, board.getSquares()[7][5], wBishop);
        
        pieces.add(leftWhiteBishop);
        pieces.add(rightWhiteBishop);
        
        leftBlackBishop = new Bishop("black", board, board.getSquares()[0][2], bBishop);
        rightBlackBishop = new Bishop("black", board, board.getSquares()[0][5], bBishop);
        
        pieces.add(leftBlackBishop);
        pieces.add(rightBlackBishop);
        
        whiteQueen = new Queen("white", board, board.getSquares()[7][3], wQueen);
        blackQueen = new Queen("black", board, board.getSquares()[0][3], bQueen);
        
        pieces.add(whiteQueen);
        pieces.add(blackQueen);
        
        whiteKing = new King("white", board, board.getSquares()[7][4], wKing);
        blackKing = new King("black", board, board.getSquares()[0][4], bKing);
        
        pieces.add(whiteKing);
        pieces.add(blackKing);
        
        leftBlackKnight = new Knight("black", board, board.getSquares()[0][1], bKnight);
        rightBlackKnight = new Knight("black", board, board.getSquares()[0][6], bKnight);
        
        pieces.add(leftBlackKnight);
        pieces.add(rightBlackKnight);
        
        leftWhiteKnight = new Knight("white", board, board.getSquares()[7][1], wKnight);
        rightWhiteKnight = new Knight("white", board, board.getSquares()[7][6], wKnight);
        
        pieces.add(leftWhiteKnight);
        pieces.add(rightWhiteKnight);
        
        
        
        
        
        mydraw = new Canvas(board, pieces, this);
        
          
        selector = new SquareSelector(mydraw);
        mydraw.addMouseListener(selector);
        
        
        add(mydraw);
        setSize(board.SQUARE_WIDTH*8, board.SQUARE_WIDTH*8 + 60);
        setTitle("Chess");
        
        
        
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void newGame(){
        
        
        mydraw.reset();
        
        for(int i = 0; i < 16; i+=2) {
            pieces.get(i).reset(board.getSquares()[6][i/2]);
            pieces.get(i+1).reset(board.getSquares()[1][i/2]);
        }
        
        leftWhiteRook.reset(board.getSquares()[7][0]);
        rightWhiteRook.reset(board.getSquares()[7][7]);
        
        leftBlackRook.reset(board.getSquares()[0][0]);
        rightBlackRook.reset(board.getSquares()[0][7]);
        
        leftWhiteBishop.reset(board.getSquares()[7][2]);
        rightWhiteBishop.reset(board.getSquares()[7][5]);
        
        leftBlackBishop.reset(board.getSquares()[0][2]);
        rightBlackBishop.reset(board.getSquares()[0][5]);
        
        whiteQueen.reset(board.getSquares()[7][3]);
        blackQueen.reset(board.getSquares()[0][3]);
        
        whiteKing.reset(board.getSquares()[7][4]);
        blackKing.reset(board.getSquares()[0][4]);
        
        leftBlackKnight.reset(board.getSquares()[0][1]);
        rightBlackKnight.reset(board.getSquares()[0][6]);
        
        leftWhiteKnight.reset(board.getSquares()[7][1]);
        rightWhiteKnight.reset(board.getSquares()[7][6]);
        
        for(int i = 0; i < pieces.size(); i++) {
            pieces.get(i).setAvailableMoves();
        }
        
        
        mydraw.repaint();
        
        turnFlag = true;
    }
    
    boolean getTurnFlag() {
        return turnFlag;
    }
    
    public void turnOver() {
        checkCount = 0;
        
        unProtectPieces();
        
        pawnPromotion();
        
        setPiecesMoves();
        
        restrictKings();
        
        lookForInterruptions();
        
        lookForChecks();
        
        lookForPins();
        
        if(lookForCheckMate())
            checkmate();
        
        if(turnFlag){
            ((King) whiteKing).outOfCheck();
        }
        if(!turnFlag){
            ((King)blackKing).outOfCheck();
        }
        
        turnFlag = !turnFlag;
        
        String tempS;
        if(turnFlag)
            tempS = "White in check ";
        else
            tempS = "Black in check ";
            
        System.out.println(tempS + checkCount + " times");
        
    }
    
    public void unProtectPieces() {
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).currentSquare != null )
            pieces.get(i).unProtect();
        }
    }
    
    public void setPiecesMoves() {
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).currentSquare != null ) {
            pieces.get(i).setAvailableMoves();
            
            
            //-----------en pesant--------------------------------------
            if(pieces.get(i).getPieceType().equals("pawn") ) {
                if(pieces.get(i).getColor().equals("white")) {
                    if(pieces.get(i).currentSquare.getRank() == 5) {
                        if(mydraw.prevMove.equals("pawn" + (pieces.get(i).currentSquare.getFile() - 1) + "" + 7 + ",pawn"  + (pieces.get(i).currentSquare.getFile() - 1) + "" + 5)) {
                            pieces.get(i).availableMoves.add(board.getSquare(2, pieces.get(i).currentSquare.getFile() - 2));
                        }
                        if(mydraw.prevMove.equals("pawn" + (pieces.get(i).currentSquare.getFile() + 1) + "" + 7 + ",pawn"  + (pieces.get(i).currentSquare.getFile() + 1) + "" + 5)) {
                            pieces.get(i).availableMoves.add(board.getSquare(2, pieces.get(i).currentSquare.getFile() ));
                        }
                    }
                }
                if(pieces.get(i).getColor().equals("black")) {
                    if(pieces.get(i).currentSquare.getRank() == 4) {
                        if(mydraw.prevMove.equals("pawn" + (pieces.get(i).currentSquare.getFile() - 1) + "" + 2 + ",pawn"  + (pieces.get(i).currentSquare.getFile() - 1) + "" + 4)) {
                            pieces.get(i).availableMoves.add(board.getSquare(5, pieces.get(i).currentSquare.getFile() - 2));
                        }
                        if(mydraw.prevMove.equals("pawn" + (pieces.get(i).currentSquare.getFile() + 1) + "" + 2 + ",pawn"  + (pieces.get(i).currentSquare.getFile() + 1) + "" + 4)) {
                            pieces.get(i).availableMoves.add(board.getSquare(5, pieces.get(i).currentSquare.getFile() ));
                        }
                    }
                }
            }
            }
        }
    }
    
    public void restrictKings() {
        
        ArrayList<Square> bKingAvailableMoves = blackKing.getAvailableMoves();
        ArrayList<Square> wKingAvailableMoves = whiteKing.getAvailableMoves();
        
        
        
        for(int i = 0; i < pieces.size(); i++){
            for(int j = 0; j < pieces.get(i).availableMoves.size(); j++) {
                if(pieces.get(i).color.equals("white")){
                    for(int k = 0; k < bKingAvailableMoves.size(); k++) {
                        if((pieces.get(i).availableMoves.get(j) == bKingAvailableMoves.get(k) 
                                && !pieces.get(i).getPieceType().equals("pawn"))
                                || isPawnAttacking((Square)bKingAvailableMoves.get(k), "black") 
                                || isKingAttacking((Square)bKingAvailableMoves.get(k), "black")) {
                            bKingAvailableMoves.remove(bKingAvailableMoves.get(k));
                            System.out.println("Removed : BK" + pieces.get(i).availableMoves.get(j).getFileChar() + "" + pieces.get(i).availableMoves.get(j).getRank());
                            
                        }
                    }
                }
                if(pieces.get(i).color.equals("black")){
                    for(int k = 0; k < wKingAvailableMoves.size(); k++) {
                        if((pieces.get(i).availableMoves.get(j) == wKingAvailableMoves.get(k) 
                                && !pieces.get(i).getPieceType().equals("pawn") )
                                || isPawnAttacking((Square)wKingAvailableMoves.get(k), "white") 
                                || isKingAttacking((Square)wKingAvailableMoves.get(k), "white")) {
                            wKingAvailableMoves.remove(wKingAvailableMoves.get(k));
                            System.out.println("Removed : WK" + pieces.get(i).availableMoves.get(j).getFileChar() + "" + pieces.get(i).availableMoves.get(j).getRank());
                        }
                    }
                }
            }
        }
        
    }
    public boolean isKingAttacking(Square s, String kingColor) {
        
        
        
        if(kingColor.equals("white") && blackKing.getAvailableMoves() != null) {
            for(int i = 0; i < blackKing.getAvailableMoves().size(); i++) {
                if( blackKing.getAvailableMoves().get(i) == s)
                    return true;
            }
        }
        if(kingColor.equals("black") && whiteKing.getAvailableMoves() != null) {
            for(int i = 0; i < whiteKing.getAvailableMoves().size(); i++) {
                if( whiteKing.getAvailableMoves().get(i) == s)
                    return true;
            }
        }
        
        
        return false;
    }
    public boolean isPawnAttacking(Square s, String kingColor) {
        int tempFile, tempRank;
        
        
        for(int i = 0; i < pieces.size(); i++) {
            if(pieces.get(i).currentSquare != null && pieces.get(i).getPieceType().equals("pawn") && !pieces.get(i).getColor().equals(kingColor)) {
                    
                tempFile =  pieces.get(i).currentSquare.getFile();
                tempRank = pieces.get(i).currentSquare.getRank();
                
                
                if(kingColor.equals("white") && tempRank - 1 == s.getRank()){
                    
                    if(tempFile - 1 == s.getFile() || tempFile + 1 == s.getFile()) {
                        System.out.println("kdfalrkjf");
                        return true;
                    }
                    
                }
                if(kingColor.equals("black") && tempRank + 1 == s.getRank()){
                    
                    if(tempFile - 1 == s.getFile() || tempFile + 1 == s.getFile()) {
                        System.out.println("kdfalrkjf");
                        return true;
                    }
                    
                }
                
                
            }
        }
        
        
        return false;
    }
    
    public boolean lookForCheckMate(){
        if(turnFlag){
            for(int i = 0; i < pieces.size(); i++){
                if(pieces.get(i).color.equals("black")){
                    if(!pieces.get(i).availableMoves.isEmpty()){
                        return false;
                    }
                } 
            }
            return true;
        }
        else {
            for(int i = 0; i < pieces.size(); i++){
                if(pieces.get(i).color.equals("white")){
                    if(!pieces.get(i).availableMoves.isEmpty()){
                        return false;
                    }
                }
            }
            return true;
        }
    }
    
    public void lookForChecks() {
        
        
        
        for(int i = 0; i < pieces.size(); i++){
            //if whites turn
            if(turnFlag){

                //looks for any of its pieces putting black king in check
                if(pieces.get(i).color.equals("white")) {
                    for(int j = 0; j < pieces.get(i).getAvailableMoves().size(); j++){
                        if(pieces.get(i).getAvailableMoves().get(j).hasPiece){
                            if(pieces.get(i).getAvailableMoves().get(j) == blackKing.currentSquare){
                                checkCount++;
                                ((King) blackKing).setCheck();
                                attackingPiece = pieces.get(i);
                            }
                        }
                    }
                }

                resetMoves();   
                restrictKings();
            }

            //if blacks turn
            if(!turnFlag){

                //looks for any of its pieces putting whtie king in check
                if(pieces.get(i).color.equals("black")) {
                    for(int j = 0; j < pieces.get(i).getAvailableMoves().size(); j++){
                        if(pieces.get(i).getAvailableMoves().get(j).hasPiece){
                            if(pieces.get(i).getAvailableMoves().get(j) == whiteKing.currentSquare){
                                ((King) whiteKing).setCheck();
                                checkCount++;
                                attackingPiece = pieces.get(i);
                            }
                        }
                    }
                }

                resetMoves();
                restrictKings();
            }
        }
    }
    
    public void lookForInterruptions() {
        
        //if whites turn
        if(turnFlag) {
            //look through white pieces to interrupt black king
            for(int i = 0; i < pieces.size(); i++) {
                if(pieces.get(i).currentSquare != null && pieces.get(i).getColor().compareTo("white") == 0) {
                    for(int j = 0; j < pieces.get(i).availableMoves.size(); j++ ) {
                        //if the move on the first rank
                        if(pieces.get(i).availableMoves.get(j).getRank() == 8) {
                            //if move is on west side
                            if(pieces.get(i).availableMoves.get(j).getFile() < 5) {
                                ((King) blackKing).interruptWest();
                            }
                            //if move is on east side
                            else if(pieces.get(i).availableMoves.get(j).getFile() > 5){
                                ((King) blackKing).interruptEast();
                            }
                        }
                    }
                }
            }
        }
        //if blacks turn
        else {
            //look through black pieces to interrupt white king
            for(int i = 0; i < pieces.size(); i++) {
                if(pieces.get(i).currentSquare != null&& pieces.get(i).getColor().compareTo("black") == 0) {
                    for(int j = 0; j < pieces.get(i).availableMoves.size(); j++ ) {
                        //if the move on the first rank
                        if(pieces.get(i).availableMoves.get(j).getRank() == 1) {
                            //if move is on west side
                            if(pieces.get(i).availableMoves.get(j).getFile() < 5) {
                                ((King) whiteKing).interruptWest();
                            }
                            //if move is on east side
                            else if(pieces.get(i).availableMoves.get(j).getFile() > 5){
                                ((King) whiteKing).interruptEast();
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void resetMoves() {
        
        for(int i = 0; i < pieces.size(); i++){
            
            //if whites turn
            if(turnFlag){
                
                //reset blacks moves
                if(pieces.get(i).color.equals("black")) {
                        
                    //if not checked then do nothing
                    if(checkCount == 0) {}
                    
                    //if checked once, then can block, take, or move king
                    if(checkCount == 1) {
                        if(pieces.get(i).currentSquare != null)
                            pieces.get(i).setAvailableMovesOne(blackKing.currentSquare, attackingPiece);
                    }
                
                    //if checked twice or more, then can only move king
                    if(checkCount >= 2) {
                        if(!pieces.get(i).getPieceType().equals("king")) {
                            pieces.get(i).getAvailableMoves().clear();
                        }
                    }
                }        
            }
            
            //if blacks turn
            if(!turnFlag){
                
                //reset whites moves
                if(pieces.get(i).color.equals("white")) {
                        
                    //if not checked then do nothing
                    if(checkCount == 0) {}
                    
                    //if checked once, then can block, take, or move king
                    if(checkCount == 1) {
                        
                        if(pieces.get(i).currentSquare != null)
                            pieces.get(i).setAvailableMovesOne(whiteKing.currentSquare, attackingPiece);  
                    }
                
                    //if checked twice or more, then can only move king
                    if(checkCount >= 2) {
                            if(!pieces.get(i).getPieceType().equals("king")) {
                                pieces.get(i).getAvailableMoves().clear();
                        }
                    }    
                }   
            } 
        }        
    }
    
    
    
    
    
    public void updateWhite(){
        whiteAvailableMoves.clear();
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).color.equals("white")){
                for(int j = 0; j < pieces.get(i).availableMoves.size(); j++){
                    whiteAvailableMoves.add(pieces.get(i).availableMoves.get(j));
                }
            }
        }
    }
    
    public void updateBlack(){
        blackAvailableMoves.clear();
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).color.equals("black")){
                for(int j = 0; j < pieces.get(i).availableMoves.size(); j++){
                    whiteAvailableMoves.add(pieces.get(i).availableMoves.get(j));
                }
            }
        }
    }
    
    private void pawnPromotion(){
        if(turnFlag){
            for(int i = 0; i < pieces.size(); i++){
                if(pieces.get(i).color.equals("white")){
                    if(pieces.get(i).getPieceType().equals("pawn")){
                        if(pieces.get(i).currentSquare != null){
                            if(pieces.get(i).currentSquare.getRank() == 8){
                                Object[] possibilities = {"Queen", "Rook", "Bishop", "Knight"};
                                String s = (String)JOptionPane.showInputDialog(this, "Choose a piece to promote to",
                                        "Pawn Promotion", JOptionPane.PLAIN_MESSAGE, wPawn, possibilities, "Queen");
                                Square promotionSquare = pieces.get(i).currentSquare;
                                pieces.get(i).currentSquare = null;
                                pieces.get(i).availableMoves.clear();
                                switch(s){
                                    case "Queen":
                                        pieces.add(new Queen("white", board, board.getSquares()
                                                [8 - promotionSquare.getRank()][promotionSquare.getFile() - 1],
                                                wQueen));
                                        break;
                                    case "Rook":
                                        pieces.add(new Rook("white", board, board.getSquares()
                                                [8 - promotionSquare.getRank()][promotionSquare.getFile() - 1],
                                                wRook));
                                        break;
                                    case "Bishop":
                                        pieces.add(new Bishop("white", board, board.getSquares()
                                                [8 - promotionSquare.getRank()][promotionSquare.getFile() - 1],
                                                wBishop));
                                        break;
                                    case "Knight":
                                        pieces.add(new Knight("white", board, board.getSquares()
                                                [8 - promotionSquare.getRank()][promotionSquare.getFile() - 1],
                                                wKnight));
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            for(int i = 0; i < pieces.size(); i++){
                if(pieces.get(i).color.equals("black")){
                    if(pieces.get(i).getPieceType().equals("pawn")){
                        if(pieces.get(i).currentSquare != null){
                            if(pieces.get(i).currentSquare.getRank() == 1){
                                Object[] possibilities = {"Queen", "Rook", "Bishop", "Knight"};
                                String s = (String)JOptionPane.showInputDialog(this, "Choose a piece to promote to",
                                        "Pawn Promotion", JOptionPane.PLAIN_MESSAGE, bPawn, possibilities, "Queen");
                                Square promotionSquare = pieces.get(i).currentSquare;
                                pieces.get(i).currentSquare = null;
                                pieces.get(i).availableMoves.clear();
                                switch(s){
                                    case "Queen":
                                        pieces.add(new Queen("black", board, board.getSquares()
                                                [8 - promotionSquare.getRank()][promotionSquare.getFile() - 1],
                                                bQueen));
                                        break;
                                    case "Rook":
                                        pieces.add(new Rook("black", board, board.getSquares()
                                                [8 - promotionSquare.getRank()][promotionSquare.getFile() - 1],
                                                bRook));
                                        break;
                                    case "Bishop":
                                        pieces.add(new Bishop("black", board, board.getSquares()
                                                [8 - promotionSquare.getRank()][promotionSquare.getFile() - 1],
                                                bBishop));
                                        break;
                                    case "Knight":
                                        pieces.add(new Knight("black", board, board.getSquares()
                                                [8 - promotionSquare.getRank()][promotionSquare.getFile() - 1],
                                                bKnight));
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void checkmate(){
        if(turnFlag)
            JOptionPane.showMessageDialog(this, "White wins by Checkmate. File... New Game to play again.");
        else
            JOptionPane.showMessageDialog(this, "Black wins by Checkmate. File... New Game to play again.");
        
        for(int i = 0; i < pieces.size(); i++){
            pieces.get(i).getAvailableMoves().clear();
        }
    }
    
    public void changeTurn(){
        turnFlag = !turnFlag;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chess chess = new Chess();
        
    }

    private void lookForPins(){
        //if white queen or bishop is on same diagonal as king
        Square kingSquare = blackKing.currentSquare;
        Square attackingSquare;
        int wCounter = 0;
        int bCounter = 0;
        ArrayList<Square> inBetween = new ArrayList();
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).color.equals("white")){
                if(pieces.get(i).currentSquare != null){
                    if(pieces.get(i).pieceType.equals("queen") || pieces.get(i).pieceType.equals("bishop")) {
                        attackingSquare = pieces.get(i).currentSquare;
                        //if they are on the same diagonal going from northeast to southwest
                        if((kingSquare.getFile() - attackingSquare.getFile()) == (kingSquare.getRank() - attackingSquare.getRank())){
                            //attacking piece is SW
                            if((kingSquare.getFile() - attackingSquare.getFile()) > 0) {
                                int k = attackingSquare.getRank() + 1;
                                for(int j = attackingSquare.getFile() + 1; j < kingSquare.getFile(); j++){
                                    inBetween.add(board.getSquares()[8 - k][j - 1]);
                                    k++;
                                }
                            }
                            //attacking piece is NE
                            else {
                                int k = kingSquare.getRank() + 1;
                                for(int j = kingSquare.getFile() + 1; j < attackingSquare.getFile(); j++){

                                    inBetween.add(board.getSquares()[8 - k][j - 1]);
                                    k++;
                                }
                            }
                            for(int j = 0; j < inBetween.size(); j++){
                                if(inBetween.get(j).hasPiece){
                                    if(inBetween.get(j).getPiece().color.equals("white")){
                                        if(!inBetween.get(j).getPiece().pieceType.equals("queen") && !inBetween.get(j).getPiece().pieceType.equals("bishop")){
                                            ++wCounter;
                                        }
                                    }
                                    else
                                        ++bCounter;
                                }
                            }
                            if(wCounter == 0 && bCounter == 1){
                                for(int j = 0; j < inBetween.size(); j++){
                                    if(inBetween.get(j).hasPiece){
                                        if(inBetween.get(j).getPiece().color.equals("black")){
                                            Piece pinnedPiece = inBetween.get(j).getPiece();
                                            ArrayList<Square> oldAvailable = new ArrayList(pinnedPiece.getAvailableMoves());
                                            pinnedPiece.availableMoves.clear();
                                            
                                            if(oldAvailable.contains(attackingSquare))
                                                pinnedPiece.availableMoves.add(attackingSquare);
                                            
                                            for(int k = 0; k < inBetween.size(); k++){
                                                    if(oldAvailable.contains(inBetween.get(k))){
                                                        pinnedPiece.availableMoves.add(inBetween.get(k));
                                                    }
                                                }
                                                
                                        }
                                    }
                                }
                            }
                        }
                        //if they are on the same diagonal going from NW to SE
                        if(-(kingSquare.getFile() - attackingSquare.getFile()) == (kingSquare.getRank() - attackingSquare.getRank())){
                            //attacking piece is NW
                            if((kingSquare.getFile() - attackingSquare.getFile()) > 0) {
                                int k = attackingSquare.getRank() - 1;
                                for(int j = attackingSquare.getFile() + 1; j < kingSquare.getFile(); j++){                                    
                                    inBetween.add(board.getSquares()[8 - k][j - 1]);
                                    k--;
                                }
                            }
                            //attacking piece is SE
                            else {
                                int k = kingSquare.getRank() - 1;
                                for(int j = kingSquare.getFile() + 1; j < attackingSquare.getFile(); j++){                                    
                                    inBetween.add(board.getSquares()[8 - k][j - 1]);
                                    k--;
                                }
                            }
                            for(int j = 0; j < inBetween.size(); j++){
                                if(inBetween.get(j).hasPiece){
                                    if(inBetween.get(j).getPiece().color.equals("white")){
                                        if(!inBetween.get(j).getPiece().pieceType.equals("queen") && !inBetween.get(j).getPiece().pieceType.equals("bishop")){
                                            ++wCounter;
                                        }
                                    }
                                    else
                                        ++bCounter;
                                }
                            }
                            if(wCounter == 0 && bCounter == 1){
                                for(int j = 0; j < inBetween.size(); j++){
                                    if(inBetween.get(j).hasPiece){
                                        if(inBetween.get(j).getPiece().color.equals("black")){
                                            Piece pinnedPiece = inBetween.get(j).getPiece();
                                            ArrayList<Square> oldAvailable = new ArrayList(pinnedPiece.getAvailableMoves());
                                            pinnedPiece.availableMoves.clear();
                                            
                                            if(oldAvailable.contains(attackingSquare))
                                                pinnedPiece.availableMoves.add(attackingSquare);
                                            
                                            for(int k = 0; k < inBetween.size(); k++){
                                                    if(oldAvailable.contains(inBetween.get(k))){
                                                        pinnedPiece.availableMoves.add(inBetween.get(k));
                                                    }
                                                }
                                                
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //if black queen or bishop is on same diagonal as white king
        kingSquare = whiteKing.currentSquare;
        wCounter = 0;
        bCounter = 0;
        inBetween = new ArrayList();
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).color.equals("black")){
                if(pieces.get(i).currentSquare != null) {
                    if(pieces.get(i).pieceType.equals("queen") || pieces.get(i).pieceType.equals("bishop")) {
                        attackingSquare = pieces.get(i).currentSquare;
                        //if they are on the same diagonal going from northeast to southwest
                        if((kingSquare.getFile() - attackingSquare.getFile()) == (kingSquare.getRank() - attackingSquare.getRank())){
                            //attacking piece is SW
                            if((kingSquare.getFile() - attackingSquare.getFile()) > 0) {
                                int k = attackingSquare.getRank() + 1;
                                for(int j = attackingSquare.getFile() + 1; j < kingSquare.getFile(); j++){
                                    inBetween.add(board.getSquares()[8 - k][j - 1]);
                                    k++;
                                }
                            }
                            //attacking piece is NE
                            else {
                                int k = kingSquare.getRank() + 1;
                                for(int j = kingSquare.getFile() + 1; j < attackingSquare.getFile(); j++){                                    
                                    inBetween.add(board.getSquares()[8 - k][j - 1]);
                                    k++;
                                }
                            }
                            for(int j = 0; j < inBetween.size(); j++){
                                if(inBetween.get(j).hasPiece){
                                    if(inBetween.get(j).getPiece().color.equals("black")){
                                        if(!inBetween.get(j).getPiece().pieceType.equals("queen") && !inBetween.get(j).getPiece().pieceType.equals("bishop")){
                                            ++bCounter;
                                        }
                                    }
                                    else
                                        ++wCounter;
                                }
                            }
                            if(bCounter == 0 && wCounter == 1){
                                for(int j = 0; j < inBetween.size(); j++){
                                    if(inBetween.get(j).hasPiece){
                                        if(inBetween.get(j).getPiece().color.equals("white")){
                                            Piece pinnedPiece = inBetween.get(j).getPiece();
                                            ArrayList<Square> oldAvailable = new ArrayList(pinnedPiece.getAvailableMoves());
                                            pinnedPiece.availableMoves.clear();
                                            
                                            if(oldAvailable.contains(attackingSquare))
                                                pinnedPiece.availableMoves.add(attackingSquare);
                                            
                                            for(int k = 0; k < inBetween.size(); k++){
                                                    if(oldAvailable.contains(inBetween.get(k))){
                                                        pinnedPiece.availableMoves.add(inBetween.get(k));
                                                    }
                                                }
                                                
                                        }
                                    }
                                }
                            }
                        }
                        //if they are on the same diagonal going from NW to SE
                        if(-(kingSquare.getFile() - attackingSquare.getFile()) == (kingSquare.getRank() - attackingSquare.getRank())){
                            //attacking piece is NW
                            if((kingSquare.getFile() - attackingSquare.getFile()) > 0) {
                                int k = attackingSquare.getRank() - 1;
                                for(int j = attackingSquare.getFile() + 1; j < kingSquare.getFile(); j++){                                    
                                    inBetween.add(board.getSquares()[8 - k][j - 1]);
                                    k--;
                                }
                            }
                            //attacking piece is SE
                            else {
                                int k = kingSquare.getRank() - 1;
                                for(int j = kingSquare.getFile() + 1; j < attackingSquare.getFile(); j++){
                                    inBetween.add(board.getSquares()[8 - k][j - 1]);
                                    k--;
                                }
                            }
                            for(int j = 0; j < inBetween.size(); j++){
                                if(inBetween.get(j).hasPiece){
                                    if(inBetween.get(j).getPiece().color.equals("black")){
                                        if(!inBetween.get(j).getPiece().pieceType.equals("queen") && !inBetween.get(j).getPiece().pieceType.equals("bishop")){
                                            ++bCounter;
                                        }
                                    }
                                    else
                                        ++wCounter;
                                }
                            }
                            if(bCounter == 0 && wCounter == 1){
                                for(int j = 0; j < inBetween.size(); j++){
                                    if(inBetween.get(j).hasPiece){
                                        if(inBetween.get(j).getPiece().color.equals("white")){
                                            Piece pinnedPiece = inBetween.get(j).getPiece();
                                            ArrayList<Square> oldAvailable = new ArrayList(pinnedPiece.getAvailableMoves());
                                            pinnedPiece.availableMoves.clear();
                                            
                                            if(oldAvailable.contains(attackingSquare))
                                                pinnedPiece.availableMoves.add(attackingSquare);
                                            
                                            for(int k = 0; k < inBetween.size(); k++){
                                                    if(oldAvailable.contains(inBetween.get(k))){
                                                        pinnedPiece.availableMoves.add(inBetween.get(k));
                                                    }
                                                }
                                                
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //if white queen or rook is on same file or rank as king
        kingSquare = blackKing.currentSquare;
        wCounter = 0;
        bCounter = 0;
        inBetween = new ArrayList();
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).color.equals("white")){
                if(pieces.get(i).currentSquare != null){
                    if(pieces.get(i).pieceType.equals("queen") || pieces.get(i).pieceType.equals("rook")) {
                        attackingSquare = pieces.get(i).currentSquare;
                        //if they are on the same rank
                        if((kingSquare.getRank() == attackingSquare.getRank())){
                            //attacking piece is W
                            if((kingSquare.getFile() - attackingSquare.getFile()) > 0) {
                                for(int j = attackingSquare.getFile() + 1; j < kingSquare.getFile(); j++){
                                    inBetween.add(board.getSquares()[8 - kingSquare.getRank()][j - 1]);
                                }
                            }
                            //attacking piece is E
                            else {
                                for(int j = kingSquare.getFile() + 1; j < attackingSquare.getFile(); j++){
                                    inBetween.add(board.getSquares()[8 - kingSquare.getRank()][j - 1]);
                                }
                            }
                            for(int j = 0; j < inBetween.size(); j++){
                                if(inBetween.get(j).hasPiece){
                                    if(inBetween.get(j).getPiece().color.equals("white")){
                                        if(!inBetween.get(j).getPiece().pieceType.equals("queen") && !inBetween.get(j).getPiece().pieceType.equals("rook")){
                                            ++wCounter;
                                        }
                                    }
                                    else
                                        ++bCounter;
                                }
                            }
                            if(wCounter == 0 && bCounter == 1){
                                for(int j = 0; j < inBetween.size(); j++){
                                    if(inBetween.get(j).hasPiece){
                                        if(inBetween.get(j).getPiece().color.equals("black")){
                                            Piece pinnedPiece = inBetween.get(j).getPiece();
                                            ArrayList<Square> oldAvailable = new ArrayList(pinnedPiece.getAvailableMoves());
                                            pinnedPiece.availableMoves.clear();
                                            
                                            if(oldAvailable.contains(attackingSquare))
                                                pinnedPiece.availableMoves.add(attackingSquare);
                                            
                                            for(int k = 0; k < inBetween.size(); k++){
                                                    if(oldAvailable.contains(inBetween.get(k))){
                                                        pinnedPiece.availableMoves.add(inBetween.get(k));
                                                    }
                                                }
                                                
                                        }
                                    }
                                }
                            }
                        }
                        //if they are on the same file
                        if((kingSquare.getFile() == attackingSquare.getFile())){
                            //attacking piece is S
                            if((kingSquare.getRank() - attackingSquare.getRank()) > 0) {
                                for(int j = attackingSquare.getRank() + 1; j < kingSquare.getRank(); j++){
                                    inBetween.add(board.getSquares()[8 - j][kingSquare.getFile() - 1]);
                                }
                            }
                            //attacking piece is N
                            else {
                                for(int j = kingSquare.getRank() + 1; j < attackingSquare.getRank(); j++){
                                    inBetween.add(board.getSquares()[8 - j][kingSquare.getFile() - 1]);
                                }
                            }
                            for(int j = 0; j < inBetween.size(); j++){
                                if(inBetween.get(j).hasPiece){
                                    if(inBetween.get(j).getPiece().color.equals("white")){
                                        if(!inBetween.get(j).getPiece().pieceType.equals("queen") && !inBetween.get(j).getPiece().pieceType.equals("rook")){
                                            ++wCounter;
                                        }
                                    }
                                    else
                                        ++bCounter;
                                }
                            }
                            if(wCounter == 0 && bCounter == 1){
                                for(int j = 0; j < inBetween.size(); j++){
                                    if(inBetween.get(j).hasPiece){
                                        if(inBetween.get(j).getPiece().color.equals("black")){
                                            Piece pinnedPiece = inBetween.get(j).getPiece();
                                            ArrayList<Square> oldAvailable = new ArrayList(pinnedPiece.getAvailableMoves());
                                            pinnedPiece.availableMoves.clear();
                                            
                                            if(oldAvailable.contains(attackingSquare))
                                                pinnedPiece.availableMoves.add(attackingSquare);
                                            
                                            for(int k = 0; k < inBetween.size(); k++){
                                                    if(oldAvailable.contains(inBetween.get(k))){
                                                        pinnedPiece.availableMoves.add(inBetween.get(k));
                                                    }
                                                }
                                                
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //if white queen or rook is on same file or rank as king
        kingSquare = whiteKing.currentSquare;
        wCounter = 0;
        bCounter = 0;
        inBetween = new ArrayList();
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).color.equals("black")){
                if(pieces.get(i).currentSquare != null){
                    if(pieces.get(i).pieceType.equals("queen") || pieces.get(i).pieceType.equals("rook")) {
                        attackingSquare = pieces.get(i).currentSquare;
                        //if they are on the same rank
                        if((kingSquare.getRank() == attackingSquare.getRank())){
                            //attacking piece is W
                            if((kingSquare.getFile() - attackingSquare.getFile()) > 0) {
                                for(int j = attackingSquare.getFile() + 1; j < kingSquare.getFile(); j++){
                                    inBetween.add(board.getSquares()[8 - kingSquare.getRank()][j - 1]);
                                }
                            }
                            //attacking piece is E
                            else {
                                for(int j = kingSquare.getFile() + 1; j < attackingSquare.getFile(); j++){
                                    inBetween.add(board.getSquares()[8 - kingSquare.getRank()][j - 1]);
                                }
                            }
                            for(int j = 0; j < inBetween.size(); j++){
                                if(inBetween.get(j).hasPiece){
                                    if(inBetween.get(j).getPiece().color.equals("black")){
                                        if(!inBetween.get(j).getPiece().pieceType.equals("queen") && !inBetween.get(j).getPiece().pieceType.equals("rook")){
                                            ++bCounter;
                                        }
                                    }
                                    else
                                        ++wCounter;
                                }
                            }
                            if(bCounter == 0 && wCounter == 1){
                                for(int j = 0; j < inBetween.size(); j++){
                                    if(inBetween.get(j).hasPiece){
                                        if(inBetween.get(j).getPiece().color.equals("white")){
                                            Piece pinnedPiece = inBetween.get(j).getPiece();
                                            ArrayList<Square> oldAvailable = new ArrayList(pinnedPiece.getAvailableMoves());
                                            pinnedPiece.availableMoves.clear();
                                            
                                            if(oldAvailable.contains(attackingSquare))
                                                pinnedPiece.availableMoves.add(attackingSquare);
                                            
                                            for(int k = 0; k < inBetween.size(); k++){
                                                    if(oldAvailable.contains(inBetween.get(k))){
                                                        pinnedPiece.availableMoves.add(inBetween.get(k));
                                                    }
                                                }
                                                
                                        }
                                    }
                                }
                            }
                        }
                        //if they are on the same file
                        if((kingSquare.getFile() == attackingSquare.getFile())){
                            //attacking piece is S
                            if((kingSquare.getRank() - attackingSquare.getRank()) > 0) {
                                for(int j = attackingSquare.getRank() + 1; j < kingSquare.getRank(); j++){
                                    inBetween.add(board.getSquares()[8 - j][kingSquare.getFile() - 1]);
                                }
                            }
                            //attacking piece is N
                            else {
                                for(int j = kingSquare.getRank() + 1; j < attackingSquare.getRank(); j++){
                                    inBetween.add(board.getSquares()[8 - j][kingSquare.getFile() - 1]);
                                }
                            }
                            for(int j = 0; j < inBetween.size(); j++){
                                if(inBetween.get(j).hasPiece){
                                    if(inBetween.get(j).getPiece().color.equals("black")){
                                        if(!inBetween.get(j).getPiece().pieceType.equals("queen") && !inBetween.get(j).getPiece().pieceType.equals("rook")){
                                            ++bCounter;
                                        }
                                    }
                                    else
                                        ++wCounter;
                                }
                            }
                            if(bCounter == 0 && wCounter == 1){
                                for(int j = 0; j < inBetween.size(); j++){
                                    if(inBetween.get(j).hasPiece){
                                        if(inBetween.get(j).getPiece().color.equals("white")){
                                            Piece pinnedPiece = inBetween.get(j).getPiece();
                                            ArrayList<Square> oldAvailable = new ArrayList(pinnedPiece.getAvailableMoves());
                                            pinnedPiece.availableMoves.clear();
                                            
                                            if(oldAvailable.contains(attackingSquare))
                                                pinnedPiece.availableMoves.add(attackingSquare);
                                            
                                            for(int k = 0; k < inBetween.size(); k++){
                                                    if(oldAvailable.contains(inBetween.get(k))){
                                                        pinnedPiece.availableMoves.add(inBetween.get(k));
                                                    }
                                                }
                                                
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    } 
}
