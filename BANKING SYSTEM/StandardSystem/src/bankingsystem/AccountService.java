package bankingsystem;

import java.sql.*;

public class AccountService {

    public int createAccount(int customerId, String type, double balance) {

        int id = -1;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO Accounts(customer_id,account_type,balance) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, customerId);
            ps.setString(2, type);
            ps.setDouble(3, balance);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            System.out.println("Account created ID: " + id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return id;
    }
}
