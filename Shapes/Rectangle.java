import java.awt.*;
/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle extends Shape
{
    private int width; 
    private int length;
    /**
    * Constructor
    */
    public Rectangle(int x, int y, int width, int length){
        super(x,y);
        this.width = width;
        this.length = length; 
    }
    
    @Override 
    public double getArea(){
        return width * length; 
    }
    /**
     * Pre: Object exists
     * Post: sets different width
     */
    public void setWidth(int wid){
        width = wid;
    }
    /**
     * Pre: Object exists
     * Post: sets different length
     */
    public void setLength(int len){
        length = len;
    }
    /**
     * Pre: object exists
     * Post: return width
     */
    public int getWidth(){
        return width; 
    }
    /**
     * Pre: object exists
     * Post: return length
     */
    public int getLength(){
        return length; 
    }
    
    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawRect(getX(),getY(),width,length); 
    }
}
