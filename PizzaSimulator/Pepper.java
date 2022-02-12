import java.awt.Color;
/**
 * Write a description of class Pepper here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */ 
public class Pepper{
            Color myColor = new Color(0,30,0);
            Vegetable pepper;
            Money cost = new Money(.65);
            public Pepper(){
                pepper = new Vegetable("Pepper",myColor,cost,24);
            }
        }
