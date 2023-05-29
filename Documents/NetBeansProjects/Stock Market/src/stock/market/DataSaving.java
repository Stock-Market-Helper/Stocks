
package stock.market;

import java.util.ArrayList;

public class DataSaving {

    String UserName;
    String Password;
    double Balance;
    int authorizationCode;

    int aramco= 0;
    int apple= 0;
    int google= 0;

    public DataSaving(String UserName, String Password, double Balance, int authorizationCode, int aramco, int apple, int google) {
        this.UserName = UserName;
        this.Password = Password;
        this.Balance = Balance;
        this.authorizationCode = authorizationCode;
        this.aramco = aramco;
        this.apple = apple;
        this.google = google;
    }

    DataSaving() {

    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public double getBalance() {
        return Balance;
    }

    public int getAuthorizationCode() {
        return authorizationCode;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public void setAuthorizationCode(int authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public void setAramco(int aramco) {
        this.aramco = aramco;
    }

    public void setApple(int apple) {
        this.apple = apple;
    }

    public void setGoogle(int google) {
        this.google = google;
    }

    public int getAramco() {
        return aramco;
    }

    public int getApple() {
        return apple;
    }

    public int getGoogle() {
        return google;
    }

}
