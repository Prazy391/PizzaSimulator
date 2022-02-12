
/**
 * Write a description of class Fraction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fraction
{
    String numerator;
    String denominator;
    //Constructor 
    public Fraction(String f){
        numerator = f.substring(0,f.indexOf("/"));
        denominator = f.substring(f.indexOf("/")+1);
    }
    //Get numerator
    public String getNumerator(){
        return numerator; 
    }
    //Return denominator
    public String getDenominator(){
        return denominator;
    }
    //Change Numerator
    public void setNumerator(String n){
        numerator = n;
    }
    //Change Denominator
    public void setDenominator(String d){
        denominator = d;
    }
    //Return fraction as a String
    public String getFraction(){
        return numerator+"/"+denominator;
    }
}
