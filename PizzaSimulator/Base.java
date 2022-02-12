
/**
 * Write a description of class a here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Base {
        Ingredient base;
        
        public Base(String baseName, Money object, int calorie){
            Money veggieCost = new Money(object.getMoney());
            base = new Ingredient(baseName,veggieCost,calorie);
        }
        
}
