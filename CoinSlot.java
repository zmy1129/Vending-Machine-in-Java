
/**
 * class CoinSlot. Represents the coin slot of the vending machine, which accepts coins.
 *
 * @author Muye Zhao
 * @version 2018 Spring final - due on May 8
 */
public class CoinSlot
{
    // this machine only accepts coins of 1,5,10,25 Cents 
    // i.e. penny, nickel, dime, and quarter
    private boolean coinCheck()
    {
        return true; 
    }
    
    public boolean coinReceived()
    {
        if(coinCheck())
        {
            return true;
        }
        
        return false;
    }
}
