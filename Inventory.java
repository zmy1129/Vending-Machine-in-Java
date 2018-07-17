
/**
 * class Inventory. A program that keeps records of the quantity of each product in the vending machine.
 * In this case, there are three procuts, which are Coke(25 cents), Pepsi(35 cents), Soda(45 cents).
 * 
 * @author Muye Zhao
 * @version 2018 Spring final - due on May 8
 */

import java.util.ArrayList;

public class Inventory
{
    final int QUANTITY = 10; // put how many items of a product into a vending machine
    private ArrayList<Product> inventory; // the record of the quantity of each product
    
    // constructor
    public Inventory()
    {
        // create 3 kinds of products for testing
        Product coke = new Product("coke", 25, QUANTITY);
        Product pepsi = new Product("pepsi", 35, QUANTITY);
        Product soda = new Product("soda", 45, QUANTITY);
        
        // add those products to the the list
        inventory = new ArrayList();
        inventory.add(coke);
        inventory.add(pepsi);
        inventory.add(soda);
    }
    
    // search a certain product from the list
    private Product getProduct(String productName)
    {
        for(int i = 0; i < inventory.size(); i++)
        {
            if (inventory.get(i).getProductName() == productName)
            {
                return inventory.get(i);
            }
        }
        
        return null;
    }
    
    // return the price of a centain product in the list
    public int getProductPriceInCents(String productName)
    {
        return getProduct(productName).getProductPriceInCents();
    }
    
    // return the quantity of a centain product in the list
    public int getQuantity(String productName)
    {
        return getProduct(productName).getQuantity();
    }
    
    // add an amount to the quantity of a centain product in the list
    public void addQuantity(String productName, int amount)
    {
        getProduct(productName).addQuantity(amount);
    }
    
    // subtracts an amount to the quantity of a centain product in the list
    public void reduceQuantity(String productName, int amount)
    {
        getProduct(productName).reduceQuantity(amount);
    }
}
