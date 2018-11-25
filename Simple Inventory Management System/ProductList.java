
/**
 * Write a description of class ProductList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductList
{
    private Product[] listOfProducts;

    public ProductList()
    {
        listOfProducts = new Product[5];
    }

    public ProductList(int a,Product b)
    {
        listOfProducts = new Product[5];
        listOfProducts[a] = b;
    }

    public void addProduct(String addName, String addDesc, double addPrice,
                            int addQtyOnHand, int addMinOrderQty)
    {
        Product add = new Product();
        add.setName(addName);
        add.setDesc(addDesc);
        add.setPrice(addPrice);
        add.setQtyOnHand(addQtyOnHand);
        add.setMinOrderQty(addMinOrderQty);
        inputProduct(add);
    }

    public void inputProduct(Product input)
    {
        int i = 0;  
        int counter = 0;
        for(i=0;i<5;i++)
        {
            if(listOfProducts[i] == null)
            {
                listOfProducts[i] = input;
                break;
            }else
                counter++;
        }
        if(counter == 5)
            System.out.println("This system only allows to register five products.");
    }

    public Product getProduct(int i)
    {
        return listOfProducts[i];
    }

    public void displayListOfProduct()
    {
        int i;        
        for(i=0;i<5;i++)
        {
            if(listOfProducts[i] == null)
                continue;
            System.out.println("Select Product " + (i+1) + ":");
            listOfProducts[i].displayProduct();
        }
    }

    public void displayAvailableProduct()
    {
        int i;   
        int counter = 0;
        for(i=0;i<5;i++)
        {
            if(listOfProducts[i] == null)
            {   counter++;
                continue;
            }
            if(listOfProducts[i].getMinOrderQty() >= listOfProducts[i].getQtyOnHand())
            {
                counter++;
                continue;
            }
            listOfProducts[i].displayProduct();
        }
        if(counter == 5)
            System.out.println("There is no available to be purchase.");
    }

    public boolean checkList()
    {
        int i;
        int counter = 0;
        for(i = 0; i < 5; i++)
        {
            if(listOfProducts[i] == null)                
                counter++;                
        }
        if(counter == 5)
        {    
            System.out.println("There is no products have registered.");
            return true;
        }
        return false;
    }

    public boolean checkListFull()
    {
        int i;
        int counter = 0;
        for(i = 0; i < 5; i++)
        {
            if(listOfProducts[i] == null)                
                counter++;                
        }
        if(counter == 0)
        {    
            System.out.println("This system only allows to register five products.");
            return true;
        }
        return false;
    }

    public int countProduct()
    {
        int i;
        int counter = 0;
        for(i=0;i<5;i++)
        {
            if(listOfProducts[i] == null)
                continue;
            else
                counter++;                
        }
        return counter;
    }
    
    public void changeQty(String name)
    {
        for(int i=0;i<5;i++)
        {
            if(listOfProducts[i].getName().equalsIgnoreCase(name))
            {    
                listOfProducts[i].changeQtyOnHand();
                break;
            }
        }
    }
}
