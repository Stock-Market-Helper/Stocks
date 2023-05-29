package stock.market;

import java.util.*;
import java.sql.*;

public class Database {

    public void Saveinfo(DataSaving Users) throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");

        String ur1 = "jdbc:mysql://localhost:3305/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String pass = "maz123";
        try (Connection conn = DriverManager.getConnection(ur1, user, pass); Statement stat = conn.createStatement();) {
            if (conn != null) {
                stat.executeUpdate("INSERT INTO `stock_market`.`users` (`Username`, `Password`, `verification`, `Balance`, `Aramco`, `Google`, `Apple`)"
                        + " VALUES ('" + Users.getUserName() + "', '" + Users.getPassword() + "', '" + Users.getAuthorizationCode() + "', '" + Users.getBalance() + "', '"
                        + Users.getAramco() + "', '" + Users.getGoogle() + "', '" + Users.getApple() + "');");

            } else {
                System.out.println("    u didnt");
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public DataSaving Showinfo(String num) throws SQLException, ClassNotFoundException {
        // Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");

        String ur1 = "jdbc:mysql://localhost:3305/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String pass = "maz123";
        try (Connection conn = DriverManager.getConnection(ur1, user, pass); Statement stat = conn.createStatement();) {
            if (conn != null) {

                ResultSet Rs1 = stat.executeQuery("SELECT * FROM stock_market.users;");
                while (Rs1.next()) {
                    if (num == Rs1.getString(1)) {
                        DataSaving data = new DataSaving();
                        data.setUserName(Rs1.getString(1));
                        data.setPassword(Rs1.getString(2));
                        data.setAuthorizationCode(Rs1.getInt(3));
                        data.setBalance(Rs1.getInt(4));
                        data.setAramco(Rs1.getInt(5));
                        data.setGoogle(Rs1.getInt(6));
                        data.setApple(Rs1.getInt(7));

                        return data;
                    }
                }
            } else {
                System.out.println("    u didnt");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean Check(int num) throws SQLException, ClassNotFoundException {
        // Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");

        String ur1 = "jdbc:mysql://localhost:3305/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String pass = "maz123";
        try (Connection conn = DriverManager.getConnection(ur1, user, pass); Statement stat = conn.createStatement();) {
            if (conn != null) {
                ResultSet Rs1 = stat.executeQuery("SELECT * FROM stock_market.users;");
                while (Rs1.next()) {
                    if (num == Integer.parseInt(Rs1.getString(3))) {
                        return false;
                    }
                }
            } else {
                System.out.println("    u didnt");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean CheckUser(DataSaving Users) throws SQLException, ClassNotFoundException {
        // Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");

        String ur1 = "jdbc:mysql://localhost:3305/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String pass = "maz123";
        try (Connection conn = DriverManager.getConnection(ur1, user, pass); Statement stat = conn.createStatement();) {
            if (conn != null) {
                ResultSet Rs1 = stat.executeQuery("select * FROM stock_market.users where Username = '" + Users.getUserName() + "' and Password = '" + Users.getPassword() + "';  ");
                if (Rs1.next() == false) {
                    return false;
                } else {
                   // while (Rs1.next()) {
                        Users.setAuthorizationCode(Integer.parseInt(Rs1.getString(3)));
                        Users.setBalance(Float.parseFloat(Rs1.getString(4)));
                        Users.setAramco(Rs1.getInt(5));
                        Users.setGoogle(Rs1.getInt(6));
                        Users.setApple(Rs1.getInt(7));

                 //   }
                }

            } else {
                System.out.println("    u didnt");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public void Update_Userinfo(Wallet wallet) throws ClassNotFoundException {
        // Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");

        String ur1 = "jdbc:mysql://localhost:3305/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String pass = "maz123";
        try (Connection conn = DriverManager.getConnection(ur1, user, pass); Statement stat = conn.createStatement();) {
            if (conn != null) {
                int aramco = 0;
                int apple = 0;
                int google = 0;
                for (int i = 0; i < wallet.getStocks().size(); i++) {
                  if (wallet.getStocks().get(i).equalsIgnoreCase("Aramco")) {
                        aramco += wallet.getStocksAmount().get(i);
                    } else if (wallet.getStocks().get(i).equalsIgnoreCase("Apple")) {
                        apple += wallet.getStocksAmount().get(i);
                    } else if (wallet.getStocks().get(i).equalsIgnoreCase("Google")) {
                        google += wallet.getStocksAmount().get(i);
                    }
                }
                int Rs1 = stat.executeUpdate("UPDATE stock_market.users SET Balance = '" + wallet.getBalance() + "', Aramco = '" + aramco + "', Google = '"+google+"', Apple = '"+apple+"' WHERE Username = '"+wallet.getUsername().getUserName()+"';");
                

            } else {
                System.out.println("    u didnt");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
