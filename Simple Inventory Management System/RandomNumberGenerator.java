
/**
 * Write a description of class RandomNumberGenerator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomNumberGenerator
{
    // instance variables - replace the example below with your own
    private int minimumValue;
    private int maximumValue;
   
    public RandomNumberGenerator()
    {
       minimumValue = 0;
       maximumValue = 0;
    }
    
    public RandomNumberGenerator(int newMin,int newMax)
    {
       minimumValue = newMin;
       maximumValue = newMax;
    }
    
    public int generateRandomNumber(int min, int max)
    {
        int randomNumber = min + (int)(Math.random() * (max - min + 1));
        return randomNumber;
    }
    
    public int getMinimumValue()
    {
        return minimumValue;
    }
    
    public int getMaximumValue()
    {
        return maximumValue;
    }
    
    public void setMinimumValue(int newMinimumValue)
    {
        minimumValue = newMinimumValue;
    }
    
    public void setMaximumValue(int newMaximumValue)
    {
        maximumValue = newMaximumValue;
    }
    
    public void display()
    {
        System.out.println(generateRandomNumber(getMinimumValue(),getMaximumValue()));
    }
}
