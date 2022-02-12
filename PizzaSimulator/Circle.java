import java.awt.*;
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a d  ate)
 */
  public class Circle extends Shape
{
    private double radius;
    /**
     * Constructor
     */
    public Circle(int x,int y, double r){
        super(x,y);
        this.radius = r;
    }
    /**
     * Pre: object exists
     * Post: return radius
     */
    public double getRadius(){
        return radius;
    }
    /**
     * Pre: Object exists
     * Post: sets different radius
     */
    public void setRadius(double r){
        radius = r;
    }
    @Override 
    public double getArea(){
        return radius * radius * Math.PI; 
    }
    
    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawOval(getX(),getY(),(int)radius,(int)radius);
    }
}
