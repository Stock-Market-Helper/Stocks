
package stock.market;


import java.util.ArrayList;


public class Wallet {

    DataSaving data = new DataSaving();
    VerificationProxy Autho = new VerificationProxy();

    User username;
    double Balance;
    String[][] money;
    ArrayList<String> Stocks = new ArrayList<String>();
    ArrayList<Integer> StocksAmount = new ArrayList<Integer>();

    private static Wallet wallet = null;

    private Wallet() {
    }

    public static Wallet getWallet() {
        if (wallet == null) {
            wallet = new Wallet();

        }
        return wallet;
    }

    public double getBalance() {
        return Balance;
    }

    public ArrayList<String> getStocks() {
        return Stocks;
    }

    public void setStocks(ArrayList<String> Stocks) {
        this.Stocks = Stocks;
    }

    public ArrayList<Integer> getStocksAmount() {
        return StocksAmount;
    }

    public void setStocksAmount(ArrayList<Integer> StocksAmount) {
        this.StocksAmount = StocksAmount;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public boolean getStock(String stockName) {
        boolean isExsist = false;
        for (String element : Stocks) {
            if (element.contains(stockName)) {
                isExsist = true;
                break;
            }

        }
        return isExsist;
    }

    public void buyStock(String stockName, int amount) {
        Stocks.add(stockName);
        StocksAmount.add(amount);
        if (stockName == "Aramco") {

            int number = data.aramco + amount;
            data.setAramco(number);

        } else if (stockName == "Google") {
            int number = data.google + amount;
            data.setGoogle(number);

        } else if (stockName == "Apple") {
            int number = data.apple + amount;
            data.setApple(number);

        }
    }

    public void sellStock(String stockName, int amount) {

        for (String element : Stocks) {
            if (element.contains(stockName)) {
                Stocks.remove(element);

                break;
            }
            for (int amountelement : StocksAmount) {
                if (amountelement == amount) {
                    StocksAmount.remove(amountelement);
                    if (stockName == "Aramco") {

                        int number = data.aramco - amount;
                        data.setAramco(number);

                    } else if (stockName == "Google") {
                        int number = data.google - amount;
                        data.setGoogle(number);

                    } else if (stockName == "Apple") {
                        int number = data.apple - amount;
                        data.setApple(number);

                    }
                    break;
                }
            }

        }
    }

    public void viewWallet(String username) {
        System.out.println("your user name is:" + username);
        System.out.println("Your balance is: " + this.getBalance());
        int aramco = 0;
        int apple = 0;
        int google = 0;
        for (int i = 0; i < Stocks.size(); i++) {
            if (Stocks.get(i).equalsIgnoreCase("Aramco")) {
                aramco += StocksAmount.get(i);
            } else if (Stocks.get(i).equalsIgnoreCase("Apple")) {
                apple += StocksAmount.get(i);
            } else if (Stocks.get(i).equalsIgnoreCase("Google")) {
                google += StocksAmount.get(i);
            }
        }
        if (aramco != 0) {
            System.out.print("stock: Aramco ");
            System.out.println("quantity: " + aramco);
        }
        if (google != 0) {
            System.out.print("stock: Google ");
            System.out.println("quantity: " + google);
        }
        if (apple != 0) {
            System.out.print("stock: Apple ");
            System.out.println("quantity: " + apple);
        }
    }

    public VerificationProxy getAutho() {
        return Autho;
    }

    public void setAutho(String code) {
        this.Autho.setVerificationCode(code);
    }
}

