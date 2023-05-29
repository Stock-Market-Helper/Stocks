
package stock.market;
import java.util.HashMap;
import java.util.Scanner;

public class Stocks {

    Logger logger = Logger.getLogger();

    private String aramco;
    private String google;
    private String apple;

    public Stocks() {
        aramco = "1000";
        google = "20000";
        apple = "6000";
    }

    public String stockName(int i) {
        if (i == 0) {
            return "Aramco";
        } else if (i == 1) {
            return "Google";
        } else if (i == 2) {
            return "Apple";
        } else {
            return null;
        }
    }

    public double getPrice(String stockName) {
        if (stockName.equalsIgnoreCase("Aramco")) {
            return Double.parseDouble(aramco);
        } else if (stockName.equalsIgnoreCase("Google")) {
            return Double.parseDouble(google);
        } else if (stockName.equalsIgnoreCase("Apple")) {
            return Double.parseDouble(apple);
        } else {
            return 0.0;
        }
    }

    public void buy() {
        Stocks s = new Stocks();

        printStock(s);
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the stock Name: ");
        String Stockname = in.next();
        System.out.println("Enter amount: ");
        int amount = in.nextInt();
        System.out.println("--------------------------------");

        double sum = amount * s.getPrice(Stockname);

        if (Wallet.getWallet().getBalance() < sum) {
            System.out.println("Sorry you don't have enough money");
        } else {
            Wallet.getWallet().setBalance(Wallet.getWallet().getBalance() - sum);
            System.out.println("Your Purchase was successful");
            System.out.println("your balance is " + Wallet.getWallet().getBalance());
            Wallet.getWallet().buyStock(Stockname, amount);
            logger.info("A new request was created by: " + Wallet.getWallet().getUsername());
            logger.info(this.toString("Buy", Stockname, amount));
        }
    }

    public void sell() {
        Stocks s = new Stocks();

        printStock(s);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Stock Name: ");
        String Stockname = in.next();
        System.out.println("Enter amount: ");
        int amount = in.nextInt();
        System.out.println("----------------------------");

        double sum = amount * s.getPrice(Stockname);

        if (Wallet.getWallet().getStock(Stockname) != true) {
            System.out.println("You don't have " + Stockname);

        } else {
            System.out.println("You sold it");
            Wallet.getWallet().sellStock(Stockname, amount);
            logger.info("INFO: A new order was created");

            logger.info(this.toString("Sell", Stockname, amount));

        }
    }

    public void printStock(Stocks s) {

        System.out.println("1. Stock Aramco Price: " + aramco);
        System.out.println("2. Stock Google Price: " + google);
        System.out.println("3. Stock Apple Price: " + apple);

    }

    public String toString(String operation, String Stockname, double amount) {
        if (operation.equalsIgnoreCase("Buy")) {
            return operation + " " + "stock: " + Stockname + " " + "quantity: " + amount + ".";
        } else if (operation.equalsIgnoreCase("Sell")) {
            return operation + " " + "stock: " + Stockname + " " + "quantity: " + amount + ".";
        } else {
            return null;
        }

    }
}