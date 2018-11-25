
/**
 * Write a description of class SaleTranasction here.
 *
 * @author Dylan
 * @version (a version number or a date)
 */
public class Product
{
    // instance variables - replace the example below with your own
    private String name;
    private String desc;
    private double price;
    private int qtyOnHand;
    private int minOrderQty;
    
    public Product()
    {
        name = "";
        desc = "";
        price = 0.0;
        qtyOnHand = 0;
        minOrderQty = 0;
    }

    public Product(String name, String desc, double price, 
                    int qtyOnHand, int minOrderQty)
    {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
        this.minOrderQty = minOrderQty;
    }

    public void setName(String newName)
    {
        name = newName;        
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setDesc(String newDesc)
    {
        desc = newDesc;
    }

    public String getDesc()
    {
        return desc;
    }
    
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setQtyOnHand(int newQtyOnHand)
    {
        qtyOnHand = newQtyOnHand;
    }
    
    public int getQtyOnHand()
    {
        return qtyOnHand;
    }
    
    public void changeQtyOnHand()
    {
        qtyOnHand -= minOrderQty;
    }
    
    public void setMinOrderQty(int newMinOrderQty)
    {
        minOrderQty = newMinOrderQty;
    }
    
    public int getMinOrderQty()
    {
        return minOrderQty;
    }
    
    public void displayProduct()
    {
        System.out.println("Name: " + getName());
        System.out.println("Description: " + getDesc());
        System.out.println("Quantity: " + getQtyOnHand());
        System.out.println("Price: " + getPrice());
        System.out.println("Min Order Quantity: " + getMinOrderQty() + "\n");
    }
}
