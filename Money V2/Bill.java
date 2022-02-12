
/**
 * Write a description of class Bill here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bill implements Comparable,Cloneable, java.io.Serializable
{
    private transient Money amount;
    private transient Date dueDate;
    private transient Date paidDate;
    private transient String originator; 
   /**
    * Constructors
    */
    public Bill(Money amount, Date dueDate, String originator){
        this.amount = amount;
        this.dueDate = dueDate;
        this.paidDate = null;
        this.originator = originator;
    }
   
    public Object clone() throws CloneNotSupportedException{
        return (Bill)super.clone();
    }
    /**
     * Pre: Object exists
     * Post: returns the dueDate of the bill
     */
    public Date getDueDate(){
        return dueDate;
    }
   /**
     * Pre: Object exists
     * Post: returns the company issueing the bill
     */
    public String getOriginator(){
        return originator;
    }
    /**
     * Pre: Object exists
     * Post: returns true if bill paid false if not
     */
    public boolean isPaid(){
        if(paidDate != null)
             return true;
        return false;
    }
    /**
     * Pre: Date entered exists
     * Post: sets paidDate
     */
    public void setPaid(Date onDay){
       paidDate = onDay;
    }
    /**
     * Pre: Date entered exists
     * Post: sets next due date
     */
    public void setDueDate(Date nextDate){
       dueDate = nextDate;
    }
    /**
     * Pre: Money entered exists
     * Post: sets new amount due to the bill
     */
    public void setAmount(Money amount){
       this.amount = amount;
    } 
    /**
     * Pre: Object exists
     * Post: returns the Amount of the bill
     */
    public Money getAmount(){
        return this.amount;
    }
    /**
     * Pre: Object exists 
     * Post: changes the company issueing the bill
     */
    public void setOriginator(String originator){
        this.originator = originator;
    }
    /** Pre: object exists
     * Post: returns the amount duedate company and if the bill is paid
     */
    public String toString(){
        
        return amount+" is due on "+dueDate.toString()+" to "+originator+
        " which is "+isPaid(); 
    }
    /**
     * Pre: Object exists
     * Post: Returns true if object similar to current class object
     */
    public boolean equals(Bill toCompare){
        if(this.amount.equals(toCompare.amount) && this.originator == toCompare.originator
            && this.dueDate.equals(toCompare.dueDate) && this.paidDate.equals(toCompare.paidDate)){
                return true;
            }
            return false;
    }
    /**
     * Pre: Object exists
     * Post: If both bills paid gives the time between the payents were made
     * Returns differecne in amount if either is not paid off
     */
    public int compareTo(Object other){
        if(!(other instanceof Bill)){
            return -1;
        }
        Bill o = (Bill) other;
        if(o.paidDate != null && this.paidDate != null){
            return this.paidDate.compareTo(o.paidDate); 
        }
        else {
            return this.amount.compareTo(o.amount);
        }
        
    }
}
