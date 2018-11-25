
/**
 * Write a description of class SaleTranasction here.
 *
 * @author Dylan
 * @version (a version number or a date)
 */
public class SaleTransaction
{
    // instance variables - replace the example below with your own
    private int saleCode;
    private Product[] items;
    private double totalCost;

    public SaleTransaction()
    {
        saleCode = 0;
        items = new Product[3];
        totalCost = 0.0;
    }

    public SaleTransaction(int newSaleCode,int newTotalCost)
    {
        saleCode = newSaleCode;
        items = new Product[3];
        totalCost = newTotalCost;
    }
    
    public void setSaleCode(int newSaleCode)
    {
        saleCode = newSaleCode;
    }
    
    public int getSaleCode()
    {
        saleCode = 1000 + (int)(Math.random() * 9000);
        return saleCode;
    }
        
    public void inputItem(Product input)
    {
        int i = 0;  
        int counter = 0;
        for(i=0;i<3;i++)
        {
            if(items[i] == null)
            {
                items[i] = input;
                System.out.println(items[i].getName() + " has added in your Cart");
                break;
            }else
                counter++;
        }
        if(counter == 3)
            System.out.println("Only three items can be put into cart.");
    }
    
    public void removeItem(int i)
    {       
        for(i = i; i < 2; i++)
        {
            items[i] = items[i+1];            
        }
        items[2] = null;
    }
    
    public Product getItems(int i)
    {
        return items[i];
    }    

    public void setTotalCost(int i)
    {
        totalCost = i;
    }

    public double totalCost()
    {
        int i;
        double cost;
        double totalCost = 0.0;
        for(i=0;i<3;i++)
        {
            if(items[i] == null)
                continue;
            cost = items[i].getPrice() * items[i].getMinOrderQty();
            totalCost += cost;
        }
        return totalCost;
    }
    
    public void displayItems()
    {
        int i;
        for(i=0;i<3;i++)
        {
            if(items[i] == null)
                continue;
            items[i].displayProduct();
        }
    }
    
    
    public void displayCart()
    {
        int i;        
        for(i = 0; i < 3; i++)
        {
            if(items[i] == null)
                continue;
            System.out.println("Select Added Item " + (i+1) + ":");
            items[i].displayProduct();
        }
    }
    
     public int countItems()
    {
        int i;
        int counter = 0;
        for(i = 0;i <3;i++)
        {
            if(items[i] == null)
                continue;
            else
                counter++;                
        }
        return counter;
    }
    
    public boolean checklist()
    {
        int i;
        int counter = 0;
        for(i=0;i<3;i++)
        {
            if(items[i] == null)                
                counter++;                
        }
        if(counter == 3)
        {
            System.out.println("There is no items in your cart.");
            return true;
        }
        return false;
    }
}
       

