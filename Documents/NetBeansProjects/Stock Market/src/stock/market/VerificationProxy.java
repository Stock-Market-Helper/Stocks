/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.market;

/**
 *
 * @author pc
 */
public class VerificationProxy implements Verification{
     String VerificationToken = "123";
    String userToken ="";

    private Verification MV = new MarketVerification();

    public VerificationProxy() {
    }
       
    public VerificationProxy(String userEnteredCode) {
        this.userToken = userEnteredCode;
        
    }

    @Override
    public void MarketAccess() {
        if (userToken.equalsIgnoreCase(VerificationToken)) {
         MV.MarketAccess();
        }else{

            System.out.println("Failed access");
                System.exit(0);
        }
    }

}