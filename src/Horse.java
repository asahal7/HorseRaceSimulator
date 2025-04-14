
/**
 * This code represents a horse participiating in a horse race.
 * Each and every horse has a name , symbol, confidence rating from 0-1 and is able to track its race progress
 * @author (Abdimaalik Sahal) 
 * @version (12/04/2025)
 */
public class Horse
{
    // The five required fields for the horse class are stated below
    private String name; // stores the name of the horse
    private char symbol; // the unicode character symbol to represent each horse
    private int distanceTravelled; // an integer variable which stores how much distance the horse has travelled
    private boolean hasFallen; // a boolean variable which states true if the horse has fallen and false if not
    private double confidence; // a double variable which represents how confident the horse is

    /**
    * Constructor of class Horse
    * @param horseSymbol The character used to represent the horse
    * @param horseName The name of the horse
    * @param horseConfidence The confidence rating of the horse on a scale of 0 to 1
    */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
        this.symbol = horseSymbol;
        this.name = horseName;
        // valid and set the confidence(ensure that the argument lies between 0 and 1);
        setConfidence(horseConfidence);

        this.distanceTravelled = 0; 
        this.hasFallen = false;

       
    }
    
    
    
    //Other methods of class Horse
    public void fall()
    {
        this.hasFallen = true;
    }
    
    public double getConfidence()
    {
        
    }
    
    public int getDistanceTravelled()
    {
        
    }
    
    public String getName()
    {
        
    }
    
    public char getSymbol()
    {
        
    }
    
    public void goBackToStart()
    {
        
    }
    
    public boolean hasFallen()
    {
        
    }

    public void moveForward()
    {
        
    }

    public void setConfidence(double newConfidence)
    {
        
    }
    
    public void setSymbol(char newSymbol)
    {
        
    }
    
}
