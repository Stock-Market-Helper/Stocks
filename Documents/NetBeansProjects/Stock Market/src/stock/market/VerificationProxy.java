/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.market;

public class VerificationProxy implements Verification{
    String VerificationCode="";
    String InputedCode="";

    private Verification me = new MarketVerification();

    public VerificationProxy() {
    }

    public String getVerificationCode() {
        return VerificationCode;
    }

    public void setVerificationCode(String VerificationCode) {
        this.VerificationCode = VerificationCode;
    }

    public String getInputedCode() {
        return InputedCode;
    }

    public void setInputedCode(String InputedCode) {
        this.InputedCode = InputedCode;
    }
    
    
       
    public VerificationProxy(String InputedCode) {
        this.InputedCode = InputedCode;
        
    }

    @Override
    public boolean Marketentry() {
        if (InputedCode.equalsIgnoreCase(VerificationCode)) {
         me.Marketentry();
         return true;
        }else{
            System.out.println("sorry failed to enter the stock market");
                return false;
        }
    }

}