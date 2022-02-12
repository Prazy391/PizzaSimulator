
/**
 * Write a description of class Date here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Date implements Comparable,Cloneable, java.io.Serializable 
{
    private transient int month;
    private transient int year;
    private transient int day;
    /**
     * Constructors
     */
    public Date(int m, int d, int y){
        this.month = m;
        this.day = d;
        this.year = y;
        if(day > 31){
            month++;
            day -= 31;
        }
        if(month > 12){
            year++;
            month-=12;
        }
        if(year < 2013 || year > 2024){
            System.out.println("Wrong year");
            return;
        }
    }
    
    public Object clone() throws CloneNotSupportedException{
        return (Date)super.clone();
    }
    /**
     * Pre: object exists 
     * Post: returns Month
     */
    public int getMonth(){
        return month;
    }
    /**
     * Pre: object exists 
     * Post: returns Day
     */
    public int getDay(){
        return day;
    }
    /**
     * Pre: object exists 
     * Post: returns Year
     */
    public int getYear(){
        return year;
    } 
     /**
     * Pre: input integer
     * Post:set month to the integer if 
     * it's between 0 and 12
     */
    public void setMonth(int month){
        if(month < 0 || year > 12){
            System.out.println("Wrong Month");
            return;
        }
        this.month = month;
    }
     /**
     * Pre: input integer
     * Post:set year to the integer if 
     * it's between 2014 and 2024
     */
    public void setYear(int year){
        if(year < 2014 || year > 2024){
            System.out.println("Wrong year");
            return;
        }
        this.year = year;
    }
     /**
     * Pre: input integer
     * Post:set day to the integer if 
     * it's between 0 and 31
     */
    public void setDay(int day){
        if(day < 0 || day > 32){
            System.out.println("Wrong day");
            return;
        }
        this.day = day;
    }
    /** Pre: object exists
     * Post: returns Date in month day year order
     */
    public String toString(){
        return month+"/"+day+"/"+year;
    }
    /**
     * Pre: Object exists
     * Post: Returns true if object similar to current class object
     */
    public boolean equals(Object o){
        if(o == null || !(o instanceof Date))
            return false;
        Date temp = (Date) o;
        if(this.day == temp.day && this.month == temp.month && this.year == temp.year)
            return true;
        return false;
    }
    /**
     * Pre: Object exists
     * Post: Returns the difference between the dates in days
     */
    public int compareTo(Object other){
        if(!(other instanceof Date)){
            return -1;
        }
        int difference = 0;
        Date o = (Date) other;
        if(o.year != this.year)
            difference += (this.year - o.year)*365;
        if(o.month != this.month)
            difference += (this.month - o.month)*31;
        if(o.day != this.month) 
            difference += this.day - o.day;
        return difference;
    }
}
