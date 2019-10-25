/**
 *
 * @author Ian Bonafede
 */
package chess;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SquareSelector extends MouseAdapter{
      
    Canvas myCanvas;

    public SquareSelector(Canvas mydraw) {
        myCanvas = mydraw;   
    }
    
    public void setCanvas(Canvas mydraw) {
        myCanvas = mydraw; 
    }
   
    @Override
    public void mousePressed(MouseEvent e)  
    {  
        Point p = e.getPoint();
        
        myCanvas.clickLogic(p);
        
        myCanvas.repaint();
        
    }
    
    
}
