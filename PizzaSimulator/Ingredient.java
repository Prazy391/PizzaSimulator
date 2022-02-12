import java.awt.Color;
/**
 * Write a description of class Ingredient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ingredient implements Comparable
{ 
    final Money cost;
    final int calorie;
    final String ingredient; 
    
    public Ingredient(String ingredient, Money cost, int calorie){
        this.cost = new Money(cost.getMoney());
        this.calorie = calorie; 
        this.ingredient = ingredient;
    }
    /**
     * Compare cost
     */
    public int compareTo(Object other){
        if(!(other instanceof Ingredient)){
            return -1;
        }
        Ingredient o = (Ingredient) other;
        return cost.compareTo(o.cost); 
    }
    
    public String getIngredient(){
        return ingredient;
    }
}
