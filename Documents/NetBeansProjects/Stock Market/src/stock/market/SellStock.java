
package stock.market;

public class SellStock implements Request { 

    private Stocks money; 

    public SellStock(Stocks sellmoney){ 
        this.money = sellmoney; } 


    public void execute() { 
        money.sell(); } 

} 
