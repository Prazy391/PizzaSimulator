import java.awt.Color;
/**
 * Write a description of class v here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vegetable {
        Color vegetableColor;
        Ingredient vegetable;
        
        public Vegetable(String veggie, Color newColor, Money object, int calorie){
            Money veggieCost = new Money(object.getMoney());
            vegetable = new Ingredient(veggie,veggieCost,calorie);
            vegetableColor = new Color(newColor.getRGB());
        } 
        
        public Vegetable(String veggie, Money object, int calorie){
            Money veggieCost = new Money(object.getMoney());
            vegetable = new Ingredient(veggie,veggieCost,calorie);
            vegetableColor = new Color(0,50,0);
        }
}
