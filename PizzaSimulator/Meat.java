
/**
 * Write a description of class a here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Meat
{
      Ingredient base;
        
      public Meat(String meatName, Money object, int calorie){
          Money meatCost = new Money(object.getMoney());
          base = new Ingredient(meatName,meatCost,calorie);
      }
       
}
