package bankingsystem;

import java.sql.*;

public class TransactionService {

    public double getBalance(int accountId) {

        double balance = 0;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT balance FROM Accounts WHERE account_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                balance = rs.getDouble("balance");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return balance;
    }

    public void deposit(int accountId, double amount) {

        double balance = getBalance(accountId);
        balance += amount;

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE Accounts SET balance=? WHERE account_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, balance);
            ps.setInt(2, accountId);

            ps.executeUpdate();

            System.out.println("Deposit done: " + balance);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(int accountId, double amount) {

        double balance = getBalance(accountId);

        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }

        balance -= amount;

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE Accounts SET balance=? WHERE account_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, balance);
            ps.setInt(2, accountId);

            ps.executeUpdate();

            System.out.println("Withdraw done: " + balance);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}