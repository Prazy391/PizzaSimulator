
/**
 * Write a description of class ExpenseAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExpenseAccount extends List
{
   
   public ExpenseAccount(){
       super(); 
   }
   
   public ExpenseAccount(ExpenseAccount list){
        super(list); 
   }
   
   public int numberUnpaid(){
       int counter = 0;
       Node curr = new Node();
       curr = head; 
       while(curr.next != null){
           if(!(curr.data.isPaid()))
                counter++;
           curr = curr.next;
       }
       return counter;
   }
   /**
    * Pre: Object exists
    * Post: Return the amount left for the person to pay
    */
   public double totalExpenseToPay(){
       double amount = 0;
       Node curr = new Node();
       curr = head; 
       while(curr.next != null){
           if(!(curr.data.isPaid()))
                amount += curr.data.getAmount().getMoney();
           curr = curr.next;
       }
       return amount;
   }
   /**
    * Pre: Object exists
    * Post: Return the amount the person has to pay
    */
   public double totalExpense(){
       double amount = 0;
       Node curr = new Node();
       curr = head; 
       while(curr.next != null){
           amount += curr.data.getAmount().getMoney();
           curr = curr.next;
       }
       return amount;
   }
   /**
    * Pre: Object exists
    * Post: Return the amount the person has paid
    */
   public double totalExpensePaid(){
       double amount = 0;
       Node curr = new Node();
       curr = head; 
       while(curr.next != null){
           if((curr.data.isPaid()))
                amount += curr.data.getAmount().getMoney();
           curr = curr.next;
       }
       return amount;
   }
}
 