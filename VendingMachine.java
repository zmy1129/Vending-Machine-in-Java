
/**
 * class VendingMachine. Simulates a vending machine.
 *
 * @author Muye Zhao
 * @version 2018 Spring final - due on May 8
 */
import java.util.InputMismatchException;

public class VendingMachine
{
    private Screen screen;
    private Keypad keypad;
    private CoinSlot coinSlot;
    private CoinReturn coinReturn;
    private DeliveryBox deliveryBox;
    private Inventory inventory;
    
    // constructor
    public VendingMachine()
    {
        screen = new Screen();
        keypad = new Keypad();
        coinSlot = new CoinSlot();
        coinReturn = new CoinReturn();
        deliveryBox = new DeliveryBox();
        inventory = new Inventory();
    }
    
    // keep running. serve users one after another.
    public void run()
    {
        while(true)
        {
            Purchase newTask = new Purchase(screen, keypad, coinSlot, coinReturn, deliveryBox, inventory);
            
            try
            {
                newTask.execute();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Input. Type in an integer please.");
                keypad = new Keypad();
            }
            catch(Exception e) // handle the invalid input which is not an integer
            {
                System.out.println("The folowing error occurred: " + e.getMessage());
                keypad = new Keypad();
            }
        }
    }
}