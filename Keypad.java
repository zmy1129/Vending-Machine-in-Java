
/**
 * class Keypad. Represents the keypad of the vending machine.
 *
 * @author Muye Zhao
 * @version 2018 Spring final - due on May 8
 */

import java.util.Scanner;

public class Keypad
{
    Scanner kb;
    
    public Keypad()
    {
        kb = new Scanner(System.in);
    }
    
    // return an integer value entered by user
    public final int getInput() 
    {
        int input;
        input = kb.nextInt();
        return input;
    }
}
