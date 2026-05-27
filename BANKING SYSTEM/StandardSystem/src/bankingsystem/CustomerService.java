package bankingsystem;

import java.sql.*;

public class CustomerService {

    public int addCustomer(String first, String last, String email, String phone) {

        int id = -1;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO Customers(first_name,last_name,email,phone) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, first);
            ps.setString(2, last);
            ps.setString(3, email);
            ps.setString(4, phone);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            System.out.println("Customer added ID: " + id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return id;
    }
}
