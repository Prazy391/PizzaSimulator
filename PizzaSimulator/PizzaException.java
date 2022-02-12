
/**
 * Write a description of class LinkedListException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PizzaException extends Exception
{
    public PizzaException(){
        System.out.println("Exception case");
    }
    
    public PizzaException(String m){
        System.out.println(m);
    }
}
