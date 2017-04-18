package pelotas;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pelota {
        private static final int TAMX=15;
	private static final int TAMY=15;
	private double x=0;
	private double y=0;
	private double dx=5;
	private double dy=5;
        
    public void mueve_pelota(Rectangle2D limites ){
            x+=dx;
            y+=dy;
            if(x<limites.getMinX()){
                x=limites.getMinX();
                dx=-dx;
            }
            if(x + TAMX>=limites.getMaxX()){
                x=limites.getMaxX() - TAMX;
                dx=-dx;
            }
            if(y<limites.getMinY()){
                y=limites.getMinY();
                dy=-dy;
            }
            if(y + TAMY>=limites.getMaxY()){
                y=limites.getMaxY()-TAMY;
                dy=-dy;
            }
    }
    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }
}
