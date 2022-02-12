
/**
 * Write a description of class Pizza here.
 *
 * @author (your name)
 * @version (a version number  or a date)
 */
public class Pizza implements PizzaComparable
{
    List ingredients = new List();
    Shape pizzaShape; 
    int totalCalorie = 0;
    Money totalCost;
    Fraction pizzaLeft = new Fraction("1/1"); 
    
    public Pizza(){
        switch((int)Math.random()*3){
           case 1:{
               Goat goat = new Goat();
               ingredients.append(goat);
               break;
           }
           case 2:{
              Mozzarella moz = new Mozzarella();
              ingredients.append(moz);
              break;
           }
           case 3:{
               Mozzarella moz = new Mozzarella();
               ingredients.append(moz);
               Goat goat = new Goat();
               ingredients.append(goat);
               break;
           }
        }
        switch((int)Math.random()*3){
            case 1:{
                Pepper pepper = new Pepper();
                ingredients.append(pepper);
                break;
            }
            case 2:{
                Olive olive = new Olive();
                ingredients.append(olive);
                break;
            }
            case 3:{
                Pepper pepper = new Pepper();
                Olive olive = new Olive();
                ingredients.append(olive);
                ingredients.append(pepper);
                break;
            }
        }
        switch((int)Math.random()*3){
           case 1:{
               Pepperoni pepperoni = new Pepperoni();
               ingredients.append(pepperoni);
               break;
           }
           case 2:{
              Sausage saus = new Sausage();
              ingredients.append(saus);
              break;
           }
           case 3:{
              Pepperoni pepperoni = new Pepperoni();
              ingredients.append(pepperoni);
              Sausage saus = new Sausage();
              ingredients.append(saus);
              break;
           }
        }
        switch((int)Math.random()*1){
           case 0:{
               Alfredo alfredo = new Alfredo();
               ingredients.append(alfredo);
               break;
           }
           case 1:{
              Marinara marin = new Marinara();
              ingredients.append(marin);
              break;
           }
        }
        switch((int)Math.random()*1){
           case 0:{
               Rectangle pizza = new Rectangle(0,0,(int)Math.random()*10);
               ingredients.append(pizza);
               break;
           }
           case 1:{
              Circle pizza = new Circle(0,0,(int)Math.random()*10);
              ingredients.append(pizza);
              break;
           }
        }
    }
    
    public void setRemaining(Fraction f){
        pizzaLeft.setNumerator(f.numerator);
        pizzaLeft.setDenominator(f.denominator);
    }
    
    public Fraction getRemaining(){
        return pizzaLeft;
    }
      
    public int getCalories(){
        return totalCalorie;
    }
    
    public Money getCost(){
        return totalCost;
    }
    
    public double getRemainingArea(){
        return pizzaShape.getArea() * ((Integer.parseInt(pizzaLeft.getNumerator())
        /Integer.parseInt(pizzaLeft.getDenominator())));
    }
       
    public void setShape(Shape s) { pizzaShape = (Shape)s.clone();}
    public Shape getShape() { return (Shape) pizzaShape.clone();}
    /**
     * Adds ingredients to ingredients list
     */
    public void addIngredient(Ingredient a){
        ingredients.append(a);
    }
    /**
     * Eat part of pizza
     */
    public void eatSomePizza(Fraction amt){
        if(pizzaLeft.getDenominator() == amt.getDenominator()){
             int c = Integer.parseInt(pizzaLeft.getNumerator()) - Integer.parseInt(amt.getNumerator());
             pizzaLeft.setNumerator(""+c);
        }
        else{
             int placer = Integer.parseInt(pizzaLeft.getDenominator());
             int n = Integer.parseInt(pizzaLeft.getNumerator()) * Integer.parseInt(amt.getDenominator());
             pizzaLeft.setNumerator(""+n);
             int d = Integer.parseInt(pizzaLeft.getDenominator()) * Integer.parseInt(amt.getDenominator());
             pizzaLeft.setDenominator(""+d);
             n = Integer.parseInt(amt.getNumerator()) * placer;
             pizzaLeft.setNumerator(""+n);
             d = Integer.parseInt(amt.getDenominator()) * placer;
             pizzaLeft.setDenominator(""+d);
             int c = Integer.parseInt(pizzaLeft.getNumerator()) - Integer.parseInt(amt.getNumerator());
             pizzaLeft.setNumerator(""+c);
            int  firstNumber = Integer.parseInt(pizzaLeft.getNumerator());
            int secondNumber = Integer.parseInt(pizzaLeft.getDenominator());
            //If both variables are perfectly divisible to each other
            if(firstNumber % secondNumber == 0){
                firstNumber = firstNumber / secondNumber;
                secondNumber = 1;
            }
            else if(secondNumber % firstNumber == 0){
                secondNumber = secondNumber / firstNumber;
                firstNumber = 1;
            }
            //Simplifying the fraction 
            if(secondNumber < firstNumber){
                int divider = secondNumber; 
                //dividing by every number less than the denominator to simplify 
                while(divider != 1){
                    if(firstNumber % divider==0 && secondNumber % divider==0){
                        firstNumber = firstNumber / divider; 
                        secondNumber = secondNumber / divider;
                        divider = secondNumber;
                    }
                    else
                        divider --;
                }
            }
        }
    }
    /**
     * compare costs
     */
    public int compareTo(Object c){
        if(!(c instanceof Pizza)){
            return -1;
        }
        
        else{
            Pizza o = (Pizza) c;
            return totalCost.compareTo(o.totalCost);
        }
    }
    /**
     * Compare size of pizzas
     */
    public int compareToBySize(Object c){
        if(!(c instanceof Pizza)){
            return -1;
        }
        
        else{
            Pizza o = (Pizza) c;
            return (int)getRemainingArea() - (int)o.getRemainingArea();
        }
    }
    /**
     * Compare by calories
     */
    public int compareToByCalories(Object c){
        if(!(c instanceof Pizza)){
            return -1;
        }
        
        else{
            Pizza o = (Pizza) c;
            return totalCalorie - o.totalCalorie;
        }
    }
     
    public String toString(){
         String result = "";
         Node list = new Node();
         list = ingredients.head;
         while(list.next!=null){
            Ingredient curr = (Ingredient) list.data;
            result += " "+curr.getIngredient();
         }
         return result;
    }
}
