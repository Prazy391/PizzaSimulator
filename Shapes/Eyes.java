import java.awt.*;
/**
 * Write a description of class Cube here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Eyes extends Shape
{
   private double radius;
   /**
    * Constructor
    */
   public Eyes(int x, int y, double radius){
       super(x,y);
       this.radius = radius;
   }
   /**
     * Pre: object exists
     * Post: return radius
     */
   public double getRadius(){
        return radius;
    }
    /**
     * Pre: object exists
     * Post: change radius
     */
    public void setRadius(double rad){
        radius = rad;
    }
    
    @Override
   public double getArea(){
       return Math.PI * (radius/2) * (radius/2);
    }
    
   public void draw(Graphics g){
       Graphics2D g2d = (Graphics2D) g;
       //Making the oval look like an eye
       g2d.drawOval(getX(),getY(),(int)(radius*1.5),(int)(radius));
       //positioning the pupil relative to the eye
       g2d.drawOval(getX()+(int)(radius/3),getY()+(int)(radius/4),(int)(radius/2),
       (int)(radius/2));
   }
}
