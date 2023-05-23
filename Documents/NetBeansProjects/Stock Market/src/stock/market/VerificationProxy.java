/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.market;

/**
 *
 * @author pc
 */
public class VerificationProxy implements Verification {
    private final String verificationToken = "123";
    private String userToken = "";

    private final Verification marketVerification;

    public VerificationProxy() {
        marketVerification = new MarketVerification();
    }

    public VerificationProxy(String userEnteredCode) {
        this();
        this.userToken = userEnteredCode;
    }

    @Override
    public void MarketAccess() {
        if (isValidUserToken()) {
            marketVerification.MarketAccess();
        } else {
            handleInvalidAccess();
        }
    }

    private boolean isValidUserToken() {
        return userToken.equalsIgnoreCase(verificationToken);
    }

    private void handleInvalidAccess() {
        System.out.println("Failed access");
        System.exit(0);
    }
}