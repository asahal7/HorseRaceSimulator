package Part1;
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

    /**
     * Sets the horse as fallen
     */
    public void fall()
    {
        this.hasFallen = true;
    }
    /**
     * Returns the horse's confidence rating which is between 0 and 1
     * @return The confidence rating of the horse
     */
    public double getConfidence()
    {
        return this.confidence;
    }
    /**
     * Returns the distance the horse has travelled in the race
     * @return The distance travelled by the horse
     */
    public int getDistanceTravelled()
    {
        return this.distanceTravelled;
    }
    /**
     * Returns the name of the horse
     * @return The name of the horse
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * Returns the character used to represent the horse
     * @return The symbol of the horse
     */
    public char getSymbol()
    {
        return this.symbol;
    }
    /**
     * Resets the horse to the beginning of the race so the distance it has travelled becomes zero again and isn't in a fallen state.
     */
    public void goBackToStart()
    {
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }
    /**
     * Checks if the horse has fallen or not
     * @return true if the horse has fallen, false otherwise
     */
    public boolean hasFallen()
    {
        return this.hasFallen;
    }
    /**
     * Increments the distance the horse has travelled by 1
     */
    public void moveForward() {
        System.out.println("Inside moveForward(): hasFallen = " + hasFallen + ", confidence = " + confidence);
        if (!hasFallen) {
            double roll = Math.random();
            System.out.println("Random roll = " + roll);
            if (roll < confidence) {
                distanceTravelled++;
            } else {
                fall();
            }
        } else {
            System.out.println("Cannot move. Horse has already fallen.");
        }
    }
    
    
    /**
     * Sets the horse's confidence to the value inputted and ensures that it lies between the valid range of 0 and 1
     * @param newConfidence The new confidence value to set
     */
    public void setConfidence(double newConfidence)
    {
        if (newConfidence < 0) {
            this.confidence = 0;
        } else if (newConfidence > 1) {
            this.confidence = 1;
        } else{
            this.confidence = newConfidence;
        }
    }
    /**
     * Sets the horse's symbol to the specified character
     * @param newSymbol The new symbol to represent the horse
     */
    public void setSymbol(char newSymbol)
    {
        this.symbol = newSymbol;
    }
}
