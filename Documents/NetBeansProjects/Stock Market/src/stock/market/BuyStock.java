
package stock.market;

public class BuyStock implements Request {

    private Stocks money;

    public BuyStock(Stocks Buymoney) {
        this.money = Buymoney;
    }

    public void execute() {
        money.buy();
    }
}
