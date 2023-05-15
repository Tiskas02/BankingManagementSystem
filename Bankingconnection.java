package BankingApplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bankingconnection {
    
    public static Connection connect(){
        String url= "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "Collection-2021";
        Connection con =null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            
            } catch (ClassNotFoundException | SQLException ex) {
                java.util.logging.Logger.getLogger(BankingApplication2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        return con;
    }
}
