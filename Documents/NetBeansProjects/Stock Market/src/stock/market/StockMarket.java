
package stock.market;

import stock.market.DataSaving;
import stock.market.Database;
import static java.lang.System.in;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
public class StockMarket {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database db = new Database();
        DataSaving data_info = new DataSaving();
        //Command Objects
        Stocks Stock = new Stocks();

        BuyStock buyStockOrder = new BuyStock(Stock);

        SellStock sellStockOrder = new SellStock(Stock);

        MiddleMan broker = new MiddleMan();

        //proxy
        Verification author = null;

//------------------------------------------------------
        Scanner in = new Scanner(System.in);
        //Singltone object
        Wallet wallet = Wallet.getWallet();
        boolean isAppRunning = true;
        System.out.println(" Welcome to Stock Market App ");
        while (isAppRunning) {
            try {

                System.out.println("1- Sign up");
                System.out.println("2- Log in");

                int menu = in.nextInt();

                switch (menu) {
                    case 1:
                        signupApp(in, wallet);
                        isAppRunning = false;
                        break;
                    case 2:
                        if (loginApp(in, wallet) == true) {
                            isAppRunning = false;
                        } else {
                            System.out.println("Wrong username or password");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                in.nextLine();

            }
        }
        int exit = 0;

        while (exit != 5) {
            System.out.println("Choice:  1.Buy 2.Sell 3.view wallet 4.add balance 5.save and exit ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Verification Code: " + wallet.getAutho().getVerificationCode());
                    String code = in.next();
                    // Proxy object
                    wallet.getAutho().setInputedCode(code);
                    author = wallet.getAutho();
                    boolean Q1 = author.Marketentry();
                    if (Q1 == false) {
                        break;
                    } else {
                        broker.placeOrders(buyStockOrder);
                        break;
                    }
                case 2:
                    System.out.println("Enter Verification Code: " + wallet.getAutho().getVerificationCode());
                    code = in.next();
                    // Proxy object
                    wallet.getAutho().setInputedCode(code);
                    author = wallet.getAutho();
                    boolean Q2 = author.Marketentry();
                    if (Q2 == false) {
                        break;
                    } else {
                        broker.placeOrders(sellStockOrder);
                        break;
                    }
                case 3:
                    wallet.viewWallet(wallet.getUsername().getUserName());
                    break;
                case 4:
                    System.out.println("your Blanace is: " + wallet.getBalance() + " add some money to start trading ");
                    System.out.println("How much you want to add: ");
                    int x = in.nextInt();
                    double balance = wallet.getBalance() + x;
                    wallet.setBalance(balance);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    db.Update_Userinfo(wallet);
                    exit = 5;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    public static void signupApp(Scanner in, Wallet wallet) throws SQLException, ClassNotFoundException {
        Database db = new Database();
        DataSaving data_info = new DataSaving();
        System.out.println("-------------------------Welcome----------------");
        System.out.println("Please Enter : ");
        System.out.println("User Name: ");
        String Username = in.next();
        System.out.println("Password: ");
        String UserPass = in.next();
        User user = new User(Username, UserPass);

        System.out.println("your Balnace is 0 add some money to start trading ");
        System.out.println("How much you want to add: ");
        int balance = in.nextInt();

        wallet.setBalance(balance);
        wallet.setUsername(user);

        int code = (int) (10000 * Math.random());
        try {
            while (!db.Check(code)) {
                code = (int) (10000 * Math.random());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        data_info.setUserName(Username);
        data_info.setPassword(UserPass);
        data_info.setBalance(balance);
        data_info.setAuthorizationCode(code);
        db.Saveinfo(data_info);
    }

    private static boolean loginApp(Scanner in, Wallet wallet) throws SQLException, ClassNotFoundException {
        Database db = new Database();
        DataSaving data_info = new DataSaving();
        System.out.println("-------------------------Welcome----------------");
        System.out.println("Please Enter : ");
        System.out.println("User Name: ");
        String Username = in.next();
        System.out.println("Password: ");
        String UserPass = in.next();
        data_info.setUserName(Username);
        data_info.setPassword(UserPass);

        if (!db.CheckUser(data_info)) {
            return false;
        }
        User user = new User(Username, UserPass);
        wallet.setUsername(user);
        ArrayList<String> temp1 = new ArrayList<String>();
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        if (data_info.aramco != 0) {
            temp1.add("Aramco");
            temp2.add(data_info.getAramco());
        }
        if (data_info.google != 0) {
            temp1.add("Google");
            temp2.add(data_info.getGoogle());
        }
        if (data_info.apple != 0) {
            temp1.add("Apple");
            temp2.add(data_info.getApple());
        }
        wallet.setStocks(temp1);
        wallet.setStocksAmount(temp2);
        wallet.setBalance(data_info.getBalance());
        wallet.setAutho(String.valueOf(data_info.getAuthorizationCode()));
        return true;
    }
}

