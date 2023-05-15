package BankingApplication2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bank {
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public void listAccount() {
        Connection connection = Bankingconnection.connect();
        String sql = "SELECT * FROM account";
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            while (results.next()) {
                System.out.println(results.getString(1) + "  " + results.getString(2) + "   " + results.getString(3));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void openAccout(int accountNumber, String accountName, double balance) {
        Connection connection = Bankingconnection.connect();
        String sql = "INSERT INTO account (accNumber,accName,accBalance)" + "VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountNumber);
            preparedStatement.setString(2, accountName);
            preparedStatement.setDouble(3, balance);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void closeAccount(int accountNumber) {
        Connection connection = Bankingconnection.connect();
        String sql = "DELETE FROM account WHERE accNumber=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void depositMoney(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.deposit(amount);

        Connection connection = Bankingconnection.connect();
        String sql = "UPDATE account SET accBalance=?  WHERE accNumber=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void withdrawMoney(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.withdraw(amount);

        Connection connection = Bankingconnection.connect();
        String sql = "UPDATE account SET accBalance=?  WHERE accNumber=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Account getAccount(int accountNumber) {
        Account account = null;
        Connection connection = Bankingconnection.connect();
        String sql = "SELECT * FROM account WHERE accNumber=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountNumber);
            ResultSet result = preparedStatement.executeQuery();

            result.next();

            account = new Account(result.getInt(1), result.getString(2), result.getDouble(3));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return account;
    }
}
