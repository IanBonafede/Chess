/**
 *
 * @author Ian Bonafede
 */
package chess;

import javax.swing.ImageIcon;


public class King extends Piece{
    
    public boolean inCheck;

    public King(String color, Board b, Square s, ImageIcon i) {
        super(color, b, s, i);
        inCheck = false;
        
        pieceType = "king";
    }
    
    public void setCheck(){
        inCheck = true;
    }
    
    public void outOfCheck(){
        inCheck = false;
    }
    public boolean isInCheck(){
        return inCheck;
    }
    
    public void interruptEast() {
        for(int i = 0; i < availableMoves.size(); i++) {
            if (availableMoves.get(i).getRank() == 1 || availableMoves.get(i).getRank() == 8) {
                if (availableMoves.get(i).getFile() == 7) {
                    availableMoves.remove(i);
                }
            }
        }
    }
    
    public void interruptWest() {
        for(int i = 0; i < availableMoves.size(); i++) {
            if (availableMoves.get(i).getRank() == 1 || availableMoves.get(i).getRank() == 8) {
                if (availableMoves.get(i).getFile() == 3) {
                    availableMoves.remove(i);
                }
            }
        }
    }
    
    @Override
    void setAvailableMoves() {
        availableMoves.clear();
        Square[] north = b.north(currentSquare, 1);
        Square[] south = b.south(currentSquare, 1);
        Square[] east = b.east(currentSquare, 1);
        Square[] west = b.west(currentSquare, 1);
        Square[] northEast = setNorthEast();
        Square[] northWest = setNorthWest();
        Square[] southEast = setSouthEast();
        Square[] southWest = setSouthWest();
        
        if(color.equals("black")){
            if(north != null){
                for(int  i = 0; i < north.length; i++){
                    //if the square north of the rook i squares has a piece
                    if(north[i].hasPiece){
                        //if its white its available
                        if(north[i].getPiece().getColor().equals("white") && !north[i].getPiece().isProtected()){
                            availableMoves.add(north[i]);
                            //pieces above this piece aren't available
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
                        if(south[i].getPiece().getColor().equals("white") && !south[i].getPiece().isProtected()){
                            availableMoves.add(south[i]);
                            //pieces below this piece aren't available
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
                        if(east[i].getPiece().getColor().equals("white") && !east[i].getPiece().isProtected()){
                            availableMoves.add(east[i]);
                            //pieces right of this piece aren't available
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
                        if(west[i].getPiece().getColor().equals("white") && !west[i].getPiece().isProtected()){
                            availableMoves.add(west[i]);
                            //pieces left of this piece aren't available
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
            if(northEast != null){
                for(int  i = 0; i < northEast.length; i++){
                    //if the square NE of the bishop i squares has a piece
                    if(northEast[i].hasPiece){
                        //if its white its available
                        if(northEast[i].getPiece().getColor().equals("white") && !northEast[i].getPiece().isProtected()){
                            availableMoves.add(northEast[i]);
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
                        if(northWest[i].getPiece().getColor().equals("white") && !northWest[i].getPiece().isProtected()){
                            availableMoves.add(northWest[i]);
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
                        if(southEast[i].getPiece().getColor().equals("white") && !southEast[i].getPiece().isProtected()){
                            availableMoves.add(southEast[i]);
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
                        if(southWest[i].getPiece().getColor().equals("white") && !southWest[i].getPiece().isProtected()){
                            availableMoves.add(southWest[i]);
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
        //if the queen is white
        else {
            if(north != null) {
                for(int  i = 0; i < north.length; i++){
                    //if the square north of the rook i squares has a piece
                    if(north[i].hasPiece){
                        //if its black its available
                        if(north[i].getPiece().getColor().equals("black") && !north[i].getPiece().isProtected()){
                            availableMoves.add(north[i]);
                            //pieces above this piece aren't available
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
                        if(south[i].getPiece().getColor().equals("black") && !south[i].getPiece().isProtected()){
                            availableMoves.add(south[i]);
                            //pieces below this piece aren't available
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
                        if(east[i].getPiece().getColor().equals("black") && !east[i].getPiece().isProtected()){
                            availableMoves.add(east[i]);
                            //pieces right of this piece aren't available
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
                        if(west[i].getPiece().getColor().equals("black") && !west[i].getPiece().isProtected()){
                            availableMoves.add(west[i]);
                            //pieces left of this piece aren't available
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
            if(northEast != null){
                for(int  i = 0; i < northEast.length; i++){
                    //if the square NE of the bishop i squares has a piece
                    if(northEast[i].hasPiece){
                        //if its black its available
                        if(northEast[i].getPiece().getColor().equals("black") && !northEast[i].getPiece().isProtected()){
                            availableMoves.add(northEast[i]);
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
                        if(northWest[i].getPiece().getColor().equals("black") && !northWest[i].getPiece().isProtected()){
                            availableMoves.add(northWest[i]);
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
                        if(southEast[i].getPiece().getColor().equals("black") && !southEast[i].getPiece().isProtected()){
                            availableMoves.add(southEast[i]);
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
                        if(southWest[i].getPiece().getColor().equals("black") && !southWest[i].getPiece().isProtected()){
                            availableMoves.add(southWest[i]);
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
        
        castleEast();
        castleWest();
    }
    
    @Override
    void setAvailableMovesOne(Square kingSquare, Piece attackingPiece) {
        availableMoves.clear();
        Square[] north = b.north(currentSquare, 1);
        Square[] south = b.south(currentSquare, 1);
        Square[] east = b.east(currentSquare, 1);
        Square[] west = b.west(currentSquare, 1);
        Square[] northEast = setNorthEast();
        Square[] northWest = setNorthWest();
        Square[] southEast = setSouthEast();
        Square[] southWest = setSouthWest();
        
        if(color.equals("black")){
            if(north != null){
                for(int  i = 0; i < north.length; i++){
                    //if the square north of the rook i squares has a piece
                    if(north[i].hasPiece){
                        //if its white its available
                        if(north[i].getPiece().getColor().equals("white") && !north[i].getPiece().isProtected()){
                            availableMoves.add(north[i]);
                            //pieces above this piece aren't available
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
                        if(south[i].getPiece().getColor().equals("white") && !south[i].getPiece().isProtected()){
                            availableMoves.add(south[i]);
                            //pieces below this piece aren't available
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
                        if(east[i].getPiece().getColor().equals("white") && !east[i].getPiece().isProtected()){
                            availableMoves.add(east[i]);
                            //pieces right of this piece aren't available
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
                        if(west[i].getPiece().getColor().equals("white") && !west[i].getPiece().isProtected()){
                            availableMoves.add(west[i]);
                            //pieces left of this piece aren't available
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
            if(northEast != null){
                for(int  i = 0; i < northEast.length; i++){
                    //if the square NE of the bishop i squares has a piece
                    if(northEast[i].hasPiece){
                        //if its white its available
                        if(northEast[i].getPiece().getColor().equals("white") && !northEast[i].getPiece().isProtected()){
                            availableMoves.add(northEast[i]);
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
                        if(northWest[i].getPiece().getColor().equals("white") && !northWest[i].getPiece().isProtected()){
                            availableMoves.add(northWest[i]);
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
                        if(southEast[i].getPiece().getColor().equals("white") && !southEast[i].getPiece().isProtected()){
                            availableMoves.add(southEast[i]);
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
                        if(southWest[i].getPiece().getColor().equals("white") && !southWest[i].getPiece().isProtected()){
                            availableMoves.add(southWest[i]);
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
        //if the queen is white
        else {
            if(north != null) {
                for(int  i = 0; i < north.length; i++){
                    //if the square north of the rook i squares has a piece
                    if(north[i].hasPiece){
                        //if its black its available
                        if(north[i].getPiece().getColor().equals("black") && !north[i].getPiece().isProtected()){
                            availableMoves.add(north[i]);
                            //pieces above this piece aren't available
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
                        if(south[i].getPiece().getColor().equals("black") && !south[i].getPiece().isProtected()){
                            availableMoves.add(south[i]);
                            //pieces below this piece aren't available
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
                        if(east[i].getPiece().getColor().equals("black") && !east[i].getPiece().isProtected()){
                            availableMoves.add(east[i]);
                            //pieces right of this piece aren't available
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
                        if(west[i].getPiece().getColor().equals("black") && !west[i].getPiece().isProtected()){
                            availableMoves.add(west[i]);
                            //pieces left of this piece aren't available
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
            if(northEast != null){
                for(int  i = 0; i < northEast.length; i++){
                    //if the square NE of the bishop i squares has a piece
                    if(northEast[i].hasPiece){
                        //if its black its available
                        if(northEast[i].getPiece().getColor().equals("black") && !northEast[i].getPiece().isProtected()){
                            availableMoves.add(northEast[i]);
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
                        if(northWest[i].getPiece().getColor().equals("black") && !northWest[i].getPiece().isProtected()){
                            availableMoves.add(northWest[i]);
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
                        if(southEast[i].getPiece().getColor().equals("black") && !southEast[i].getPiece().isProtected()){
                            availableMoves.add(southEast[i]);
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
                        if(southWest[i].getPiece().getColor().equals("black") && !southWest[i].getPiece().isProtected()){
                            availableMoves.add(southWest[i]);
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
    
    public void castleEast() {
        if(getMoveCount() == 0) {
            Square[] east = b.east(currentSquare, 3);
            
            for(int i = 0; i < east.length; i++) {
                if(east[i].hasPiece) {
                    if(east[i].getPiece().getPieceType().compareTo("rook") == 0 && east[i].getPiece().getMoveCount() == 0 && !inCheck) {
                        availableMoves.add(east[i-1]);
                    }
                    break;
                }
            }
        }
        
        
        
    }
    
    public void castleWest() {
        if(getMoveCount() == 0) {
            Square[] west = b.west(currentSquare, 4);
            
            for(int i = 0; i < west.length; i++) {
                if(west[i].hasPiece) {
                    if(west[i].getPiece().color.compareTo(color) == 0 &&
                            west[i].getPiece().getPieceType().compareTo("rook") == 0 && west[i].getPiece().getMoveCount() == 0 && !inCheck) {
                        availableMoves.add(west[i-2]);
                    }
                    break;
                }
            }
        }
    }
    
    
    
    public Square[] setNorthWest(){
        int i;
        if(currentSquare.getRank() == 8 || currentSquare.getFile() == 1)
            i = 0;
        else 
            i = 1;
        return b.northWest(currentSquare, i);
    }
    
    public Square[] setNorthEast(){
        int i;
        if(currentSquare.getRank() == 8 || currentSquare.getFile() == 8)
            i = 0;
        else
            i = 1;
        return b.northEast(currentSquare, i);
    }
    
    public Square[] setSouthWest(){
        int i;
        if(currentSquare.getRank() == 1 || currentSquare.getFile() == 1)
                i = 0;
        else 
            i = 1;
           return b.southWest(currentSquare, i);
    }
    
    public Square[] setSouthEast(){
        int i;
        if(currentSquare.getRank() == 1 || currentSquare.getFile() == 8)
                i = 0;
            else 
                i = 1;
            return b.southEast(currentSquare, i);
    }

}
