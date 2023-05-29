/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.market;

/**
 *
 * @author pc
 */
public class MarketVerification implements Verification{
       public MarketVerification() {
    }



     @Override
    public boolean Marketentry() {
        System.out.println("success entry for the stock market ");
        return true;
    }

}

