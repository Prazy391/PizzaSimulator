import java.awt.*;
/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle extends Shape
{
    private int side;
    /**
    * Constructor
    */
    public Rectangle(int x, int y, int side){
        super(x,y);
        this.side = side; 
    }
    
    @Override 
    public double getArea(){
        return side * side; 
    }
    /**
     * Pre: Object exists
     * Post: sets different width
     */
    public void setSide(int side){
        this.side = side;
    }
    
    /**
     * Pre: object exists
     * Post: return width
     */
    public int getSide(){
        return side; 
    }
    
    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawRect(getX(),getY(),side,side); 
    }
    
    @Override 
    public Rectangle clone(){
        return new Rectangle(getX(),getY(),side);
    }
}
