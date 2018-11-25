import java.util.Scanner;
/**
 * Write a description of class Sale here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sale
{    
    private ProductList prodList;
    private SaleTransaction transaction;

    public Sale()
    {
        prodList = new ProductList();
        transaction = new SaleTransaction();
    }

    public void startTheSystem()
    {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("Welcome to the Simple Inventory Management System");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        choose();
    }

    public void choose()
    {
        boolean exit = true;
        while(exit)
        {
            System.out.println("\nPlease Select from the following options:");
            System.out.println("Press 1 to Register a Product for Sale");
            System.out.println("Press 2 to Buy a Product to the Cart");
            System.out.println("Press 3 to Remove a Product from the Cart");
            System.out.println("Press 4 to View all Available Products");
            System.out.println("Press 5 to Check out");
            System.out.println("Press 6 to Get Help");
            System.out.println("Press 7 to Exit");
            String userInput = input("Please Enter your Choice:");
            int userIn = 0;
            while(isNumeric(userInput) == false || numberRange(userInput,7,1,"Option") == false)
            {
                userInput = input("Please Enter your Choice:");  
            }
            userIn = Integer.parseInt(userInput);
            switch(userIn)
            {
                case 1:
                    register();
                    break;
                case 2: 
                    if(prodList.checkList())
                        break;
                    else
                        purchase();
                    break;
                case 3: 
                    if(transaction.checklist())
                        break;
                    else    
                        remove();
                break;
                case 4: 
                    if(prodList.checkList())
                        break;
                    else
                        available();
                        break;
                case 5: 
                    checkOut();
                    break;
                case 6: 
                    getHelp();
                    break;
                case 7: 
                    System.out.print("Thank You for Using Inventory Management System.");
                    exit = false;          
                default:
                    break;            
            }            
        }
        System.exit(0);
    }

    public void register()
    {   
        RandomNumberGenerator number = new RandomNumberGenerator();
        if(prodList.checkListFull());
        else{
            String name;
            do
            {
                name = input("Please Enter Product Name :");            
            }while((checkNameLength(name,25,3) == false) || (repeatName(name) == false));
            String desc;
            do
            {
                desc = input("Please Enter Product Describtion :");
            }while(checkLength(desc,50,1,"Description") == false);       
            double price;
            String inputPrice = input("Please Enter Product Price :");
            while(isNumeric(inputPrice) == false)
            {
                inputPrice = input("Please Enter Product Price :");            
            }
            price = Double.valueOf(inputPrice.toString());
            while(price <= 0)
            {                
                inputPrice = input("Please Enter your Product Price:");
                price = Double.valueOf(inputPrice.toString());
            }          
            int qtyOnHand = number.generateRandomNumber(0,10);
            int minOrderQty = number.generateRandomNumber(1,5);
            prodList.addProduct(name,desc,price,qtyOnHand,minOrderQty);
        }   
        choose();
    }

    public void purchase()
    {
        String userInput;
        int productNumber = prodList.countProduct();
        int exit = productNumber + 1;
        System.out.println("Please select from the following products which are available:");
        prodList.displayListOfProduct();
        System.out.println("Select Product " + exit + " to exit purchase menu");
        int userInputNumber = 0;
        do
        { 
            userInput = input("Please Enter Selected Product: "); 
            while(isNumeric(userInput) == false || numberRange(userInput,exit,1,"Select number") == false)
            {
                userInput = input("Please Enter Selected Product: ");  
            }
            userInputNumber = Integer.parseInt(userInput);
            int index = userInputNumber - 1;
            if(exit == userInputNumber)
                break;
            else if(prodList.getProduct(index).getMinOrderQty() >= prodList.getProduct(index).getQtyOnHand())
                System.out.println("This product is not available.");
            else{
                transaction.inputItem(prodList.getProduct(index));                
                transaction.totalCost();
            }                          
        }while(userInputNumber != exit);        
    }

    public void remove()
    {
        String userInput;
        int exit = transaction.countItems();        
        System.out.println("Please select from the following products which have been added to the cart:");     
        int userInputNumber = 0;
        do
        {                  
            transaction.displayCart();
            exit = transaction.countItems() + 1;
            System.out.println("Select Added Item " + exit + " to exit the romove menu");
            userInput = input("Please Enter Added Item: ");
            while(isNumeric(userInput) == false || numberRange(userInput,exit,1,"Select number") == false)
            {
                userInput = input("Please Enter Added Item: ");  
            }
            userInputNumber = Integer.parseInt(userInput);
            if(userInputNumber == exit)
                break;
            transaction.removeItem(userInputNumber - 1);
            System.out.println("Item "+ userInputNumber +" has removed from your cart");          
            transaction.totalCost();
        }while(userInputNumber != exit);
    }

    public void available()
    {
        prodList.displayAvailableProduct();
    }

    public void checkOut()
    {
        if(transaction.checklist() == false)
        {
            double payment = 0.0;
            double cost = 0.0;
            for(int i = 2; i >= 0; i--)
            {
                if(transaction.getItems(i) == null)
                    continue;
                int available = (transaction.getItems(i).getQtyOnHand() - transaction.getItems(i).getMinOrderQty());
                if(available >= 0)
                {
                    cost = transaction.getItems(i).getPrice() * transaction.getItems(i).getMinOrderQty();
                    payment = payment + cost;
                    prodList.changeQty(transaction.getItems(i).getName());
                    transaction.removeItem(i);  
                }else if(available < 0){
                    System.out.println(transaction.getItems(i).getName() + " does not have enough quantity.");
                    transaction.removeItem(i);
                }            
            }
            System.out.println("Sale code :" + transaction.getSaleCode());
            System.out.println("Total cost :" + payment);
        }
    }

    public void getHelp()
    {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("         H          E           L           P       ");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("You can use option 1 to register the product.");
        System.out.println("Option 2 and 3 is used for adding and removing product from your cart.");
        System.out.println("Option 4 will list the items which are able to purchase.");
        System.out.println("Using option 5 to check out your payment.");
        System.out.println("Using option 7 to exit the system");
    }

    public  boolean isNumeric(String str) 
    {
        for (int i = 0; i < str.length(); i++) 
        {            
            if(str.charAt(i) == '.')
                continue;
            if (!Character.isDigit(str.charAt(i))) 
            {
                System.out.println(str + " is not a number.");
                return false;
            }
        }
        return true;
    }

    public boolean checkNameLength(String name, int maxLength, int minLength)
    {
        if(name.length() == 0)
        {
            System.out.println("Name cannot be blank.");
            return false;
        }
        if((name.length() >= minLength) && (name.length() <= maxLength))
        {
            return true;
        }else{
            System.out.println("Name should between 3 and 25 characters long.");
            return false;
        }
    }

    public boolean checkLength(String input, int maxLength, int minLength,String str)
    {
        if(input.length() == 0)
        {
            System.out.println(str + " cannot be blank.");
            return false;
        }
        if((input.length() >= minLength) && (input.length() <= maxLength))
        {
            return true;
        }else{
            System.out.println(str + " should between " + minLength + " and " + maxLength +" characters long.");
            return false;
        }
    }

    public boolean numberRange(String inputstr, int maxLength, int minLength,String str)
    {
        int input= Integer.parseInt(inputstr);
        if(input == 0)
        {
            System.out.println(str + " cannot be blank.");
            return false;
        }
        if((input >= minLength) && (input <= maxLength))
        {
            return true;
        }else{
            System.out.println(str + " should between " + minLength + " and " + maxLength + ".");
            return false;
        }
    }

    public boolean repeatName(String inputName)
    {
        for(int i = 0;i<5;i++)
        {
            if(prodList.getProduct(i) == null)
                continue;            
            else if(inputName.equalsIgnoreCase(prodList.getProduct(i).getName()))
            {
                System.out.println("Product already exists.");
                return false;
            }
        }
        return true;
    }

    public String input(String words)
    {    
        System.out.println(words);
        Scanner console = new Scanner(System.in);        
        return console.nextLine();
    }
}
