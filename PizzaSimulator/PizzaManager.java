import java.util.Scanner;

/** PizzaManager Skeleton File
 *  CSS 162, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Note that if there are any inconsistencies between this skeleton and
 *  the assignment description, the assignment description controls.
 * 
 *  Author: Rob Nash with edits by Johnny Lin
 */
public class PizzaManager {
    List pizzas = new List();
    
    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection='q';
        boolean loop = true;
        Scanner foo = new Scanner(System.in);
        
        while(loop) {
            displayAllPizzas();
            displayInstructions();
            
            
             //foo.nextChar() doesn't exist, so now what?
            selection = foo.nextLine().charAt(0);
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                                //todo:
                                Pizza newPizza = new Pizza();
                                pizzas.append(newPizza);
                                System.out.println(pizzas.toString());
                                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                                //todo:
                                for(int i = 0; i < 100; i++){
                                    Pizza newPizzas = new Pizza();
                                    pizzas.append(newPizzas);
                                }
                                break;                    
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                                //todo:pizza eating code here
                                Scanner sc = new Scanner(System.in);
                                eatSomePizza(sc);
                                
                                break;            
                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                                //todo:
                                  sortByPrice();
                                  break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                                 //todo:
                                 sortBySize();
                                 break;          
                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                                  //todo
                                  sortByCalories();
                                  break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                                //todo:
                                Scanner scan = new Scanner(System.in);
                                binarySearchByCalories(scan.nextInt());
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                                //todo:
                                displayAllPizzas();
                                loop = false;
                                break;
                default:    System.out.println("Unrecognized input - try again");
            }
        }

    }
    /**
     * Eat some pizza from some index
     */
    private void eatSomePizza(Scanner keys) {
        //todo:b
        Fraction eaten = new Fraction(keys.nextLine());
        System.out.println("index of pizza");
        int index = keys.nextInt();
        Pizza newPizza = (Pizza) pizzas.get(index).data;
        newPizza.eatSomePizza(eaten);
    }
    /**
     * Add 1 pizza
     */
    private void addRandomPizza() {
        //todo:    
        Pizza newPizza = new Pizza();
        if(pizzas.size() == 0)
            pizzas.insert(newPizza,0);
        else
            pizzas.append(newPizza);
    }
    /**
     * Print all pizzas
     */
    private void displayAllPizzas() {
        Node curr = new Node();
        curr = pizzas.head;
        while(curr.next!=null){
            Pizza placer = (Pizza) curr.data;
            System.out.println(placer.toString());
            curr = curr.next;
        }
    }
    
    private void sortByPrice() {  
        //todo: 
        Node first = new Node();
        Node second = new Node();
        first = pizzas.head;
        second = pizzas.head.next;
        for(int i = 1; i < pizzas.size(); i++){
            for(int j = 1; j < pizzas.size(); j++){
                Pizza curr = (Pizza) first.data;
                Pizza next = (Pizza) second.data;
                if(curr.getCost().getMoney() > next.getCost().getMoney()){
                    Object placer = first.data;
                    first.data = second.data;
                    second.data = placer;
                }
                second = second.next;
            }
            first = first.next;
            second = first.next;
        }
    }
    
    private void sortBySize() {
        //todo:
        Node first = new Node();
        Node second = new Node();
        first = pizzas.head;
        second = pizzas.head.next;
        for(int i = 1; i < pizzas.size(); i++){
            for(int j = 1; j < pizzas.size(); j++){
                Pizza curr = (Pizza) first.data;
                Pizza next = (Pizza) second.data;
                if(curr.getShape().getArea() > next.getShape().getArea()){
                    Object placer = first.data;
                    first.data = second.data;
                    second.data = placer;
                }
                second = second.next;
            }
            first = first.next;
            second = first.next;
        }
    }
    
    private void sortByCalories() {
        //todo:
        Node first = new Node();
        Node second = new Node();
        first = pizzas.head;
        second = pizzas.head.next;
        for(int i = 1; i < pizzas.size(); i++){
            for(int j = 1; j < pizzas.size(); j++){
                Pizza curr = (Pizza) first.data;
                Pizza next = (Pizza) second.data;
                if(curr.getCalories() > next.getCalories()){
                    Object placer = first.data;
                    first.data = second.data;
                    second.data = placer;
                }
                second = second.next;
            }
            first = first.next;
            second = first.next;
        }
    }
    
    private int binarySearchByCalories(int cals) {
        //todo
        Node curr = new Node();
        curr = pizzas.head;
        for(int i = 0 ; i < pizzas.size()/2; i++){
            curr = curr.next;
        }
        Pizza loc = (Pizza) curr.data;
        if(loc.getCalories() == cals){
            return pizzas.indexOf(cals);
        }
        else if(loc.getCalories() < cals){
            return binarySearchByCalories(cals,0,pizzas.size()/2);
        }
        else
            return binarySearchByCalories(cals,pizzas.size()/2,pizzas.size());
        
    }
    
    private int binarySearchByCalories(int cals, int start,int end){
        Node curr = new Node();
        curr = pizzas.head;
        for(int i = 0 ; i < start; i++){
            curr = curr.next;
        }
        for(int i = 0; i < (start-end)/2; i++){
            curr = curr.next;
        }
        Pizza loc = (Pizza) curr.data;
        if(loc.getCalories() == cals){
            return pizzas.indexOf(cals);
        }
        else if(loc.getCalories() < cals){
            return binarySearchByCalories(cals,pizzas.indexOf(curr.data),end);
        }
        else
            return binarySearchByCalories(cals,start,pizzas.indexOf(curr.data));
    }
    
    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
