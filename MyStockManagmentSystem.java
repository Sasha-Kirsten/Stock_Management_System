import java.util.ArrayList;
import java.util.Scanner;

public class MyStockManagmentSystem {
    //Complete the main function and the swtich cases!!!
    public static void main(String[] args){
        Scanner user_input = new Scanner(System.in);
        //creating an empty arraylist to hold the stocks
        ArrayList<StockfromUser> stocks = new ArrayList<>();
        //display the menu and ask for user input
        int choice;
        do{
            System.out.println("Here are the choices that you can choose, user");
            System.out.println("First choice: Add Stock(1)");
            System.out.println("Second choice: Remove Stock(2)");
            System.out.println("Third choice: View Stock(3)");
            System.out.println("Fourth choice: Exit the Stock Management System(4)");
            System.out.println("Enter your choice: ");
            choice = user_input.nextInt();

            switch(choice){
                case 1:
                    //asking the user for the details of the stocks that they want to add
                    System.out.print("Enter the stock name: ");
                    String nameStock = user_input.next();
                    System.out.print("Enter the amount of the stock: ");
                    int quantityStock = user_input.nextInt();
                    System.out.print("Enter the stock price: ");
                    double priceStock = user_input.nextDouble();

                    //creating the new stock object and then adding it to the arraylist
                    StockfromUser newStock = new StockfromUser(nameStock, quantityStock, priceStock);
                    stocks.add(newStock);

                    System.out.println("Stock added successfully");
                    break;
                case 2:
                    //ask for the stock name and quantity to remove
                    System.out.print("Enter the stock name: ");
                    String stockName = user_input.next();
                    System.out.print("Enter the quantity to remove: ");
                    int removeQuantity = user_input.nextInt();

                    //loop through the stocks to find the matching stock
                    boolean stockFound = false;
                    for(StockfromUser stock: stocks){
                        if(stock.getNameoftheStock().equals(stockName)){
                            //if the stock is found, remove the specified quantity
                            stockFound = true;
                            stock.RemovetheAmountoftheCertainStock(removeQuantity);
                            System.out.println("Stock removed successfully");
                            break;
                        }
                    }
                    if(!stockFound){
                        System.out.println("Stock not found");
                    }
                    break;
                case 3:
                    //display the list of stocks
                    System.out.println("Current stocks are ");
                    for(StockfromUser stock : stocks){
                        System.out.println(stock.toString());
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice, try again");
                }
        }while(choice !=4);
        user_input.close();
    }
}

class StockfromUser{
    private String nameoftheStock;
    private int amountoftheStock;
    private double priceoftheStock;

    public StockfromUser(String nameoftheStock, int amountoftheStock, double priceoftheStock){
        this.nameoftheStock = nameoftheStock;
        this.amountoftheStock = amountoftheStock;
        this.priceoftheStock = priceoftheStock;
    }

    public String getNameoftheStock(){
        return nameoftheStock;
    }

    public int getAmountoftheStock(){
        return amountoftheStock;
    }

    public double getPriceoftheStock(){
        return priceoftheStock;
    }

    public void RemovetheAmountoftheCertainStock(int theAmountoftheStocktoRemove){
        if(theAmountoftheStocktoRemove <= amountoftheStock){
            amountoftheStock -= theAmountoftheStocktoRemove;
        }else{
            System.out.println("Not enough quantity to remove, please check the correct quantity");
        }
    }

    public String toString(){
        return nameoftheStock + ", quantity:" + amountoftheStock + ", price: £"+ priceoftheStock;
    }
    

}

