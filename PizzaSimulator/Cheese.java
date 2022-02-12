
/**
 * Write a description of class a here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cheese{
        Ingredient cheese;
        
        public Cheese(String name, Money object, int calorie){
            Money veggieCost = new Money(object.getMoney());
            cheese = new Ingredient(name,veggieCost,calorie);
        }
}
