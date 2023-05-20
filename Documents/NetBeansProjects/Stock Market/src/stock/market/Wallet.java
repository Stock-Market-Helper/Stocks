/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.market;

/**
 *
 * @author hhh
 */
public class Wallet {
    //Singleton
    private static Wallet wallet = null;

    private Wallet() {
    }

 
    public static Wallet getWallet() {
        if (wallet == null) {
            wallet = new Wallet();

        }
        return wallet;
    }
    
}
