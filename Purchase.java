
/**
 * class Purchase. Represents the purchase transaction.
 *
 * @author Muye Zhao
 * @version Spring final - due on May 8
 */

public class Purchase
{
    private int deposit; // the amount of the coins a user insert
    private Screen screen; // the screen of the vending machine
    private Keypad keypad; // the keypad of the vending machine
    private CoinSlot coinSlot; // the coinSlot of the vending machine
    private CoinReturn coinReturn; // the coinReturn of the vending machine
    private DeliveryBox deliveryBox; // the deliveryBox of the vending machine
    private Inventory inventory; // the inventory of the vending machine
    
    // constructor
    public Purchase(Screen screen, Keypad keypad, CoinSlot coinSlot, 
                    CoinReturn coinReturn, DeliveryBox deliveryBox, Inventory inventory)
    {
        this.screen = screen;
        this.keypad = keypad;
        this.coinSlot = coinSlot;
        this.coinReturn = coinReturn;
        this.deliveryBox = deliveryBox;
        this.inventory = inventory;
    }
    
    // purchase process
    public void execute()
    {
        screen.displayMessage("\nWelcome!");
        screen.displayMessage("\nPlease enter the amount you wish to deposit in cents:");
        int input = keypad.getInput();
        
        if (input>0)
        {
            if (coinSlot.coinReceived())
            {
                deposit += input;
                String selectedProduct = selectFromMenu();
            
                if(selectedProduct != "Cancel")
                {
                    if(inventory.getQuantity(selectedProduct)>0)
                    {
                        if(deposit >= inventory.getProductPriceInCents(selectedProduct))
                        {
                            deposit -= inventory.getProductPriceInCents(selectedProduct);
                            inventory.reduceQuantity(selectedProduct, 1);
                            
                            if(deliveryBox.productDelivered())
                            {
                                screen.displayMessage("\nPlease take your drink.");
                            }
                        }
                        else
                        {
                            screen.displayMessage("\nnot enough deposit.");
                        }
                    }
                    else
                    {
                        screen.displayMessage("\nSorry, the machine is out of that product.");
                    }
                }
                else
                {
                    //canceled.
                }
            
                if(deposit>0)
                {
                    if(coinReturn.coinReturned())
                    {
                        screen.displayMessage("\nPlease take your change of " + deposit + " cents.");
                    }
                    deposit = 0;
                }
                
                screen.displayMessage("\n\nThank you! Goodbye!");
            }
            else
            {
                screen.displayMessage("\nnot enough valid coins received. ");
                screen.displayMessage("This machine only accepts coins of 1,5,10,25 Cents ");
                screen.displayMessage("i.e. penny, nickel, dime, and quarter.");
            }
        }
        else
        {
            screen.displayMessage("Invalid amount.\n\n");
        }
    }
    
    // return user's choice
    private String selectFromMenu()
    {
        String productNames[] = {"", "coke", "pepsi", "soda"};
        
        String productName = "";
        
        while(productName == "")
        {
            displayMainMenu();
            
            // get user input through keypad
            int num = keypad.getInput();
            
            // determine how to proceed based on the input value
            switch(num)
            {
                case 1:
                case 2:
                case 3:
                    productName = productNames[num];
                    break;
                case 4:
                    productName = "Cancel";
                    break;
                default:
                    screen.displayMessage("\nInvalid selection. Try again.");
                    break;
            }
        }

        return productName;
    }
    
    // display the product list
    private void displayMainMenu()
    {
        screen.displayMessage("\nMain menu: All prices are in cents.");
        screen.displayMessage("\n1 - Coke 25");
        screen.displayMessage("\n2 - Pepsi 35");
        screen.displayMessage("\n3 - Soda 45");
        screen.displayMessage("\n4 - Cancel\n");
        screen.displayMessage("\nEnter a choice: ");
    }
}
