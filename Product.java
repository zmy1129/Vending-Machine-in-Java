
/**
 * class Product. Represents the products sold by the vending machine.
 *
 * @author Muye Zhao
 * @version 2018 Spring final - due on May 8
 */
public class Product
{
    private String productName; // the name of the product
    private int productPriceInCents; // the price of the product
    private int quantity; // the quantity of the product in a vending machine
    
    //constructor
    public Product(String productName, int productPriceInCents, int quantity)
    {
        this.productName = productName;
        this.productPriceInCents = productPriceInCents;
        this.quantity = quantity;
    }
    
    // return product name
    public String getProductName()
    {
        return productName;
    }
    
    // return the price of the product
    public int getProductPriceInCents()
    {
        return productPriceInCents;
    }
    
    // return the quantity of the product
    public int getQuantity()
    {
        return quantity;
    }
    
    // adds an amount to the quantity of the product
    public void addQuantity(int amount)
    {
        quantity += amount; 
    }
    
    // subtracts an amount to the quantity of the product
    public void reduceQuantity(int amount)
    {
        quantity -= amount; 
    }
}
