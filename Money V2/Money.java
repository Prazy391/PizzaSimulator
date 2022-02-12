/**
 * Write a description of class Money here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Money implements Comparable, Cloneable, java.io.Serializable 
{
    private transient int cents; 
    private transient int dollars;
    /**
     * Constructors
     */
    public Money(int dol){
        this.dollars = dol;
        this.cents = 0;
    }
    
    public Money(int dol, int cents){
        this.dollars = dol;
        if(cents > 99){
            this.cents = cents - 100;
            this.dollars++;
        }
        else{
            this.cents = cents;
        }
    }
    
    public Object clone() throws CloneNotSupportedException{
        return (Money)super.clone();
    }
    /**
     * Pre: object exists 
     * Post: returns dollars
     */
    public int getDollar(){
        return this.dollars;
    }
    /**
     * Pre: object exists 
     * Post: returns cents
     */
    public int getCents(){
        return this.cents; 
    }
     /**
     * Pre: input integer
     * Post: adds integer to Dollars
     */
    public void setDollar(int dol){
        this.dollars = dol;
    } 
    /**
     * Pre: input integer
     * Post: adds integer to cents
     */
    public void setCents(int cen){
        if(cen > 99){
            cents = cen - 100;
            dollars++;
        }
        else{
            cents = cen;
        }
    }
    /**
     * Pre: object exists and is Money
     * Post: returns amount 
     */
    public double getMoney(){
        double money = 0;
        money += dollars; 
        double c = this.cents/100;
        money += c;
        return money;
    }
     /**
      * Pre: enter 2 integers
      * Post: sets amount to the given amount
      */
    public void setMoney(int dol, int cents){
        this.dollars = dol;
        if(cents > 99){
            while(cents > 99){
                this.cents = cents - 100;
                this.dollars++;
            }
        }
        else{
            this.cents = cents;
        }
    } 
    /**
     * Pre: input 2 integers in dollar and cent order
     * Post: adds cents and dollars to the integers
     */
    public void add(int dol, int cents){
        dollars += dol;
        this.cents += cents; 
        if(this.cents > 99){
            while(this.cents > 99){
                this.cents -= 100;
                dollars ++;
            }
        }
    }
    /**
     * Pre: input integer
     * Post: adds int to dollar int
     */
    public void add(int dol){
        dollars += dol;
    }
    /**
     * Pre: object of money class
     * Post: adds amount into the current object
     */
    public void add(Money other){
        dollars += other.dollars; 
        cents += other.cents; 
        if(this.cents > 99){
            while(this.cents > 99){
                dollars++;
                this.cents -= 100;
            }
        }
    }
    /**
     * Pre: Object exists
     * Post: Returns true if object similar to current class object
     */
    public boolean equals(Object o){
        if(o == null || !(o instanceof Money))
            return false;
        Money temp = (Money) o;
        if(this.dollars == temp.dollars && this.cents == temp.cents)
            return true;
        return false;
    }
    /** Pre: object exists
     * Post: returns amount with $
     */
    public String toString(){
        return "$"+getMoney();
    }
    /**
     * Pre: Object exists
     * Post: Returns the difference in amount rounded to nearest dollar
     */
    public int compareTo(Object other){
        if(!(other instanceof Money)){
            return -1;
        }
        Money o = (Money) other;
        return (int)(this.getMoney() - o.getMoney());
    }
    
}
